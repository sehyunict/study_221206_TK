package sehyunict.tk.cart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import sehyunict.tk.cart.entity.CartVo;
import sehyunict.tk.cart.service.CartService;
import sehyunict.tk.constant.BaseStatus;
import sehyunict.tk.constant.FormStatus;
import sehyunict.tk.constant.UserStatus;

@RequestMapping("/cart")
@RestController
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping
	public ModelAndView save(CartVo cartVo, HttpSession session) {
		ModelAndView mav = new ModelAndView("jsonView"); 
		try {
			int userId = getUserId(session);
			int result = cartService.save(userId, cartVo);
			if(result == -1) 
				mav.addObject("status", FormStatus.INSERT_FAIL_COUNT_OVER);
			else if (result != 1)
				throw new Exception("[cart put error]");
			else 
				mav.addObject("status", FormStatus.INSERT_OK);
		} catch (NullPointerException e) {
			e.printStackTrace();
			mav.addObject("status", UserStatus.SESSION_FAIL);
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("status", FormStatus.INSERT_FAIL);
		}
		return mav;
	}

	@DeleteMapping
	public ModelAndView delete(@RequestParam("ids") List<Integer> cartIds, HttpSession session) {
		ModelAndView mav = new ModelAndView("jsonView");
		try {
			int userId = getUserId(session);
			if (cartService.delete(userId, cartIds) < 1)
				throw new RuntimeException("[Cart delete err] - 에러요");
			mav.addObject("status", FormStatus.DELETE_OK);
		} catch (NullPointerException e) {
			e.printStackTrace();
			mav.addObject("status", UserStatus.SESSION_FAIL);
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("status", FormStatus.DELETE_FAIL);
		}
		return mav;
	}

	@GetMapping("/list")
	public ModelAndView getList(HttpSession session) {
		ModelAndView mav = new ModelAndView("jsonView");
		try {
			int userId = getUserId(session);
			List<CartVo> cartList = cartService.getList(userId);
			mav.addObject("cartList", cartList);
			mav.addObject("status", FormStatus.SELECT_OK);
		} catch (NullPointerException e) {
			e.printStackTrace();
			mav.addObject("status", UserStatus.SESSION_FAIL);
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("status", FormStatus.SELECT_FAIL);
		}
		return mav;
	}

	// @ResponseStatus(HttpStatus.BAD_GATEWAY)
	@GetMapping
	public ModelAndView getCartMain(ModelAndView mv) {
		mv.setViewName("cart/cart");
		return mv;
	}

	private int getUserId(HttpSession session) throws NullPointerException {
		Object userId = session.getAttribute("userId");
		if (userId == null)
			throw new NullPointerException("session hasn't userId");
		return (int) userId;
	}

		
}