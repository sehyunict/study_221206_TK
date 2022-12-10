package Sehyunict.Tk.basket.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import Sehyunict.Tk.basket.entity.BasketVo;
import Sehyunict.Tk.basket.service.BasketService;

@RequestMapping("/basket")
@RestController
public class BasketController {

	@Autowired
	private BasketService basketService;
	
	@PostMapping
	public String put(BasketVo basketVo, Model model, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		try {
			if(basketService.put(userId, basketVo)!=1)
				throw new Exception("basket put error");
			model.addAttribute("msg", "put_ok");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "put_err");
		}
		
		return "basket";
	}
	
	@DeleteMapping("/{basketId}")
	public String delete(@PathVariable int basketId, Model model, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		try {
			if(basketService.delete(userId, basketId)!=1)
				throw new Exception("basket delete err");
			model.addAttribute("msg", "delete_ok");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "delete_err");
		}
		return "basket";
	}
	
	@GetMapping
	public ModelAndView getList(ModelAndView mav, HttpSession session) {
		int userId = (Integer)session.getAttribute("userId");
		
		try {
			List<BasketVo> basketList = basketService.getList(userId);
			mav.addObject("basketList", basketList);
			mav.setViewName("Basket");
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return mav;
	}
}