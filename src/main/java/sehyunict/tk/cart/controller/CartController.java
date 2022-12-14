package sehyunict.tk.cart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import sehyunict.tk.cart.entity.CartVo;
import sehyunict.tk.cart.service.CartService;
import sehyunict.tk.cart.service.impl.CartServiceImpl;

@RequestMapping("/cart")
@RestController
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping
	public String put(CartVo cartVo, Model model, HttpSession session) {
		
		//int userId = (Integer)session.getAttribute("userId");
		int userId = 1;
		
		try {
			if(cartService.save(userId, cartVo)!=1)
				throw new Exception("cart put error");
			model.addAttribute("msg", "put_ok");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "put_err");
		}
		
		return "cart";
	}
	
	@DeleteMapping
	public String delete(CartVo cartVo, Model model, HttpSession session) {
		
		//int userId = (Integer)session.getAttribute("userId");
		int userId = 1;
		try {
			if(cartService.delete(userId, cartVo)!=1)
				throw new Exception("cart delete err");
			model.addAttribute("msg", "delete_ok");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "delete_err");
		}
		return "cart";
	}
	
	@GetMapping("/list")
	public ModelAndView getList(ModelAndView mav, HttpSession session) {
		//int userId = (Integer)session.getAttribute("userId");
		int userId = 1;
		try {
			List<CartVo> cartList = cartService.getList(userId);
			mav.addObject("cartList", cartList);
			mav.setViewName("Main");
			for(CartVo c : cartList) {
			System.out.println(c.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;
	}
	
	@GetMapping
	public ModelAndView getCartMain(ModelAndView mv) {
		mv.setViewName("CartMain");
		return mv;
	}
	
}