package sehyunict.tk.item.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sehyunict.tk.item.entity.ItemVo;
import sehyunict.tk.item.service.ItemService;


@Controller
@RequestMapping(value = "/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	
	//전시회 페이지
	@GetMapping(value = "/exhibition")
	public String exhibition(Model model) throws Exception {
		List<ItemVo> exhibitionList = itemService.exhibitionGetList();
		System.out.println(exhibitionList);
		System.out.println(exhibitionList.get(0).getImage_path());
//			System.out.println(exhibitionList.get(1).getImage_path());

////			ItemVo exhibitionItem = itemService.get();
//			ArrayList<String> exList = new ArrayList<String>();
//			
//			for (int i = 0; i < exhibitionList.size(); i++) {
//				exList.add(exhibitionList.get(i).getImage_path());
//				exList.add(exhibitionList.get(i).getTitle());
//				exList.add(exhibitionList.get(i).getStart_day_str());
//				exList.add(exhibitionList.get(i).getEnd_day_str());
//			}

		model.addAttribute("exhibitionList", exhibitionList);
		return "item/exhibition";
		
	}
	

	//영화 페이지
	@GetMapping(value = "/movie")
	public String movie(Model model) throws Exception {
		List<ItemVo> movieList = itemService.movieGetList();
		
		System.out.println(movieList);
		System.out.println(movieList.get(0).getImage_path());
		System.out.println(movieList.get(1).getImage_path());
		
		model.addAttribute("movieList", movieList);
		
		return "item/movie";
	}
	
	//연극 페이지
	@GetMapping(value = "/theater")
	public String theater(Model model) throws Exception {
		List<ItemVo> theaterList = itemService.theaterGetList();
		
		System.out.println(theaterList);
		System.out.println(theaterList.get(0).getImage_path());
		System.out.println(theaterList.get(1).getImage_path());
		
		model.addAttribute("theaterList", theaterList);
		
		return "item/theater";
	}
	
	//아이템별 상세 페이지
	@GetMapping(value = "/itemDetail")
	public String itemDetail(@RequestParam("item_id") int item_id, Model model) throws Exception {
		List<ItemVo> detailList = itemService.getDetailList(item_id);

		System.out.println(detailList);
		
		model.addAttribute("detailList", detailList);
		
		return "item/itemDetail";
	}
	
	//관리자 아이템 상세 페이지
	@GetMapping(value = "/adminItemDetail")
	public String adminItemDetail(@RequestParam("item_id") int item_id, Model model) throws Exception {
		List<ItemVo> detailList = itemService.getDetailList(item_id);

		System.out.println(detailList);
		
		model.addAttribute("detailList", detailList);
		
		return "item/adminItemDetail";
	}
	
	//아이템 등록
	@PostMapping(value = "/register")
	public String register(ItemVo itemvo, HttpSession session) throws Exception {
		System.out.println("아이템 등록 메소드 진입");

		ItemVo registervo = itemService.register(itemvo);
		
			
//		rttr.addFlashAttribute("resultMsg", registervo);
//		if (condition) {
//			
//		} else {
//
//		}
		return "";
	}
//	//수정화면
//	@GetMapping(value = "/member/modify")
//	public String modifyForm(Principal principal, MemberDto dto, Model model) {
//		String userId = principal.getName();				
//		MemberDto memberDto = memberService.get(userId);	
//		
//		model.addAttribute("memberDto", memberDto);	
//		return "member/memberModifyForm";
//	}
	
}
