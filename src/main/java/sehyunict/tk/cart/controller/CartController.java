package sehyunict.tk.cart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import sehyunict.tk.cart.entity.CartVo;
import sehyunict.tk.cart.service.CartService;
import sehyunict.tk.constant.CustomStatus;
import sehyunict.tk.constant.FormStatus;
import sehyunict.tk.constant.UserStatus;

@RequestMapping("/cart")
@RestController
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping
	public ModelMap save(CartVo cartVo, HttpSession session) {
		ModelMap mm = new ModelMap();
		try {
			int userId = hasUserId(session);
			int result = cartService.save(userId, cartVo);
			if(result == -1) 
				setStatus(mm, FormStatus.INSERT_FAIL_COUNT_OVER);
			else if (result != 1)
				throw new Exception("[cart put error]");
			else 
				setStatus(mm, FormStatus.INSERT_OK);
		} catch (NullPointerException e) {
			setStatus(mm, UserStatus.SESSION_FAIL);
		} catch (Exception e) {
			e.printStackTrace();
			setStatus(mm, FormStatus.INSERT_FAIL);
		}
		return mm;
	}

	@DeleteMapping
	public ModelMap delete(@RequestParam List<Integer> ids, HttpSession session) {
		ModelMap mm = new ModelMap();
		try {
			int userId = hasUserId(session);
			if (cartService.delete(userId, ids) != 1)
				throw new RuntimeException("[Cart delete err] - 에러요");
			setStatus(mm, FormStatus.DELETE_OK);
		} catch (NullPointerException e) {
			e.printStackTrace();
			setStatus(mm, UserStatus.SESSION_FAIL);
		} catch (Exception e) {
			e.printStackTrace();
			setStatus(mm, FormStatus.DELETE_FAIL);
		}
		return mm;
	}

	@GetMapping("/list")
	public ModelMap getList(HttpSession session) {
		ModelMap mm = new ModelMap();
		try {
			int userId = hasUserId(session);
			List<CartVo> result = cartService.getList(userId);
			mm.addAttribute("result", result);
			setStatus(mm, FormStatus.SELECT_OK);
		} catch (NullPointerException e) {
			e.printStackTrace();
			setStatus(mm, UserStatus.SESSION_FAIL);
		} catch (Exception e) {
			e.printStackTrace();
			setStatus(mm, FormStatus.SELECT_FAIL);
		}
		return mm;
	}

	// @ResponseStatus(HttpStatus.BAD_GATEWAY)
	@GetMapping
	public ModelAndView getCartMain(ModelAndView mv) {
		mv.setViewName("cart/cart");
		// mv.setStatus(HttpStatus.BAD_GATEWAY);
		return mv;
	}

	private int hasUserId(HttpSession session) throws NullPointerException {
		Object userId = session.getAttribute("userId");
		if (userId == null)
			throw new NullPointerException("session hasn't userId");
		return (int) userId;
	}
	private void setStatus(ModelMap mm, CustomStatus status) {
		mm.addAttribute("msg", status.getDescription());
		mm.addAttribute("status", status.getStatus());
	}
		
}