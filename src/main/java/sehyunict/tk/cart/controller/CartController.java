package sehyunict.tk.cart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import sehyunict.tk.cart.entity.CartVo;
import sehyunict.tk.cart.exception.FormException;
import sehyunict.tk.cart.exception.UserException;
import sehyunict.tk.cart.service.CartService;
import sehyunict.tk.constant.FormStatus;
import sehyunict.tk.constant.UserStatus;

@RequestMapping("/cart")
@RestController
public class CartController {

	@Autowired
	private CartService cartService;
	private ModelAndView mav;

	@PostMapping
	public ModelAndView save(CartVo cartVo, HttpSession session) throws Exception {
		mav = new ModelAndView("jsonView"); 
		int userId = getUserId(session);
		int result = cartService.save(userId, cartVo);
		if(result == -1) 
			throw new FormException(FormStatus.INSERT_FAIL_MAX_OVER, "[cart save fail] - 장바구니 상품 최대 개수 초과");
		else if (result < 1)
			throw new FormException(FormStatus.FAIL, "[cart save fail] - 정상 삽입된 행이 없음");
		else 
			mav.addObject("status", FormStatus.OK);
		return mav;
	}

	@DeleteMapping
	public ModelAndView delete(@RequestParam("ids") List<Integer> cartIds, HttpSession session) throws Exception {
		mav = new ModelAndView("jsonView");
	
		int userId = getUserId(session);
		if (cartService.delete(userId, cartIds) < 1)
			throw new FormException(FormStatus.FAIL, "[cart delete error] - 요청정보와 일치하는 정보가 없음");
		
		mav.addObject("status", FormStatus.OK);
		return mav;
	}
 
	@GetMapping("/list")
	public ModelAndView getList(HttpSession session) throws Exception {
		mav = new ModelAndView("jsonView");
		
		int userId = getUserId(session);
		List<CartVo> cartList = cartService.getList(userId);
		mav.addObject("cartList", cartList);
		mav.addObject("status", FormStatus.OK);
		
		return mav;
	}


	// @ResponseStatus(HttpStatus.BAD_GATEWAY)
	@GetMapping
	public ModelAndView getCartMain() {
		mav = new ModelAndView();
		mav.setViewName("cart/cart");
		
		return mav;
	}

	private int getUserId(HttpSession session) throws UserException {
		Object userId = session.getAttribute("userId");
		if (userId == null)
			throw new UserException(UserStatus.SESSION_FAIL,"Session hasn't userId");
		return (int) userId;
	}

		
}