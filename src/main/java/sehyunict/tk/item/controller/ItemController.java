package sehyunict.tk.item.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import sehyunict.tk.item.service.ItemService;

@Controller
@RequestMapping(value = "/item")
public class ItemController {
//	@Autowired
//	private ItemService itemservice;
	
	
	//뮤지컬 페이지
	@GetMapping(value = "/musical")
	public String musical() {
		
		return "item/musical";
	}
	

//	@PostMapping(value = "/register")
//	public String register(itemVO itemvo, RedirectAttributes rttr, HttpSession session) throws Exception {
//		System.out.println("아이템 등록 메소드 진입");
//
//		itemVO registervo = itemservice.register(itemvo);
//		
//			
////		rttr.addFlashAttribute("resultMsg", registervo);
////		if (condition) {
////			
////		} else {
////
////		}
//		return "";
//	}
	
	//영화 페이지
	@GetMapping(value = "/movie")
	public String movie() {
		
		return "item/movie";
	}
	
	//연극 페이지
	@GetMapping(value = "/theater")
	public String theater() {
		
		return "item/theater";
	}

	//아이템별 상세 페이지
	@GetMapping(value = "/itemDetail")
	public String itemDetail() {
		
		return "item/itemDetail";
	}
}
