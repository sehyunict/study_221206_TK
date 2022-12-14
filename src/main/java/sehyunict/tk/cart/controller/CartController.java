package sehyunict.tk.cart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import sehyunict.tk.cart.entity.CartVo;
import sehyunict.tk.cart.entity.constant.FormStatus;
import sehyunict.tk.cart.service.CartService;

@RequestMapping("/cart")
@RestController
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping
	public String save(CartVo cartVo, Model model, HttpSession session) {

		try {
			int userId = hasUserId(session);
			
			if (cartService.save(userId, cartVo) != 1)
				throw new Exception("cart put error");
			model.addAttribute("msg", FormStatus.OK);
			System.out.println(FormStatus.OK);

		} catch (NullPointerException e) {
			model.addAttribute("msg", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", FormStatus.FAIL);
			System.out.println(FormStatus.FAIL);
		}

		return "cart";
	}

	@DeleteMapping
	public Model delete(CartVo cartVo, Model model, HttpSession session) {

		try {
			int userId = hasUserId(session);
			//int userId = 1;
			if (cartService.delete(userId, cartVo) != 1)
				throw new RuntimeException("[Cart delete err] - 정보가 존재하지 않습니다");
			model.addAttribute("msg", FormStatus.OK);
		} catch (NullPointerException e) {
			model.addAttribute("msg", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", FormStatus.FAIL);
		}
		return model;
	}

	@GetMapping("/list")
	public List<CartVo> getList(Model model, HttpSession session) {
		List<CartVo> cartList=null;
		try {
			int userId = hasUserId(session);
			//int userId = 1;
			cartList = cartService.getList(userId);
			model.addAttribute("cartList", cartList);
			for (CartVo c : cartList) {
				System.out.println(c.toString());
			}
			model.addAttribute("msg", FormStatus.OK);
		}catch (NullPointerException e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", FormStatus.FAIL);
		}

		return cartList;
	}

	@GetMapping
	public ModelAndView getCartMain(ModelAndView mv) {
		mv.setViewName("cart/cart");
		return mv;
	}

	private int hasUserId(HttpSession session) throws NullPointerException {

		if (session.getAttribute("userId") == null)
			throw new NullPointerException("session hasn't userId");
		return (int) session.getAttribute("userId");

	}

}