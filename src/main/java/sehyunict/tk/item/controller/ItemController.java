package sehyunict.tk.item.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
//		System.out.println(exhibitionList);
//		System.out.println(exhibitionList.get(0).getImagePath());

		model.addAttribute("exhibitionList", exhibitionList);
		return "item/exhibition";
	}
	

	//영화 페이지
	@GetMapping(value = "/movie")
	public String movie(Model model) throws Exception {
		List<ItemVo> movieList = itemService.movieGetList();
		
//		System.out.println(movieList);
//		System.out.println(movieList.get(0).getImagePath());
//		System.out.println(movieList.get(1).getImagePath());
		
		model.addAttribute("movieList", movieList);
		
		return "item/movie";
	}
	
	//연극 페이지
	@GetMapping(value = "/theater")
	public String theater(Model model) throws Exception {
		List<ItemVo> theaterList = itemService.theaterGetList();
		
//		System.out.println(theaterList);
//		System.out.println(theaterList.get(0).getImagePath());
//		System.out.println(theaterList.get(1).getImagePath());
		
		model.addAttribute("theaterList", theaterList);
		
		return "item/theater";
	}
	
	//상세 페이지(공통)
	@GetMapping(value = "/itemDetail")
	public String itemDetail(@RequestParam(value = "itemId", required=false) Integer itemId, Model model) throws Exception {
		List<ItemVo> detailList = itemService.getDetailList(itemId);

		System.out.println(detailList);
		
		model.addAttribute("detailList", detailList);
		
		return "item/itemDetail";
	}
	
	
	//관리자 아이템 목록 페이지
	@GetMapping(value = "/adminItemList")
		public String adminItemList(Model model) throws Exception {
			List<ItemVo> adminItemList = itemService.adminGetList();

//			System.out.println(exhibitionList);
//			System.out.println(exhibitionList.get(0).getImagePath());

			model.addAttribute("adminItemList", adminItemList);

			return "item/adminItemList";
			
		}
	
	//관리자 아이템 상세 페이지
	@GetMapping(value = "/adminItemDetail")
	public String adminItemDetail(@RequestParam(value = "itemId") Integer itemId, Model model) throws Exception {
		
		HashMap<String, ItemVo> adminDetailVoList = new HashMap<>();
		ItemVo adminDetailItem = itemService.adminItemDetail(itemId);
		System.out.println(adminDetailItem);

		adminDetailVoList.put("adminDetailItem", adminDetailItem);
		model.addAttribute("adminDetailVoList", adminDetailVoList);
		
//		model.addAttribute("adminDetailItem ", adminDetailItem);
//		model.addAttribute("imagePath", adminDetailItem.getImagePath() );
//		model.addAttribute("title", adminDetailItem.getTitle() );
//		model.addAttribute("director", adminDetailItem.getDirector() );
//		model.addAttribute("summary", adminDetailItem.getSummary() );
		
		return "item/adminItemDetail";
	}
	
	
	//관리자 아이템 수정 처리
//	@RequestMapping(value = "/adminItemDetail", method = {RequestMethod.GET, RequestMethod.POST} )
	@PostMapping(value = "/modifyAction")
	@ResponseBody
	public Map<String, Object> modify(@RequestBody ItemVo itemObj) throws Exception {
		System.out.println("아이템 수정 메소드 진입");
		System.out.println(itemObj);
		
		Map<String, Object> modifyVoList = new HashMap<>();
		boolean modifyVo = itemService.modify(itemObj);
		
		modifyVoList.put("modifyVo", modifyVo); 
		
		if (modifyVo == false) {
			return null;

		} else {
			return modifyVoList;
		}
	}
	
	//관리자 아이템 등록 페이지
	@GetMapping(value = "/adminItemRegister")
	public String adminItemRegister() {
		
		return "item/adminItemRegister";
	}
	
	//관리자 아이템 등록 처리
	@PostMapping(value = "/registerAction1")
	public @ResponseBody Map<String, Object> register1(@RequestBody ItemVo itemvo) throws Exception {
		System.out.println("아이템 등록 메소드 진입");
		System.out.println(itemvo);
		Map<String, Object> registerVoMap = new HashMap<>();
		
		ItemVo registerVo1 = itemService.register(itemvo);
		registerVoMap.put("registerVo1", registerVo1);
		
		if (registerVo1 == null) {
			return null;

		} else {
			return registerVoMap;
		}
	}
	
	//파일 업로드 처리
	@PostMapping("/uploadFile")
	public ModelAndView uploadFile(@RequestPart(value="inputFile") MultipartFile uploadFile, HttpServletRequest request) throws IOException {
		System.out.println("업로드 메소드 진입..");
		
		ModelAndView mv = new ModelAndView();
		
//		String path = "\\resources\\image";
//		String absolutePath = request.getServletPath().get getRequestURI();
//		System.out.println(absolutePath);
		String uploadFolder = "C:\\Users\\sehyunict\\git\\study_221206_TK\\src\\main\\webapp\\resources\\image";

		System.out.println("-------------------");
		System.out.println("파일명 : " + uploadFile.getOriginalFilename());
		System.out.println("파일사이즈 : " + uploadFile.getSize());
		System.out.println("파일타입 : " + uploadFile.getContentType());
		 
		System.out.println(uploadFolder);
		
		String savedName = uploadFile.getOriginalFilename();

		File saveFile = new File(uploadFolder, savedName);

		System.out.println(saveFile);
		
//		//임시저장 업로드파일을 새로운 곳으로 복사
//		// (바이트배열, 파일객체)
//		FileCopyUtils.copy(uploadFile.getBytes(), saveFile);
		
		try {
				uploadFile.transferTo(saveFile);
				System.out.println(uploadFile);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
		mv.setViewName("/item/adminItemRegister");
		mv.addObject("savedName",savedName);
		
		return mv;
		}
	
	
//	@PostMapping(value = "/registerAction2")
//	public @ResponseBody Map<String, Object> register2(ItemVo itemvo) throws Exception {
//		System.out.println("아이템 등록 메소드 진입");
//		
//		HashMap<String, Object> registerVoMap = new HashMap<>();
//		ItemVo registerVo2 = itemService.register2(itemvo);
//		
//		registerVoMap.put("registerVo2", registerVo2);
//		
//		System.out.println(((ItemVo) registerVoMap.get("registerVo2")).getPrice());
//		
//		if (registerVo2 == null) {
//			return null;
//
//		} else {
//			return registerVoMap;
//			
//		}
//	}
	
	
	//아이템 삭제
	@GetMapping(value = "/deleteAction")
	@ResponseBody
	public ModelAndView delete(@RequestParam("itemId") Integer itemId) throws Exception {
		ModelAndView mav = new ModelAndView("jsonView");
		System.out.println("아이템 삭제 메소드 진입");
		System.out.println(itemId);
		
		Boolean result = itemService.remove(itemId);
//		Map<String, Object> removeList = new HashMap<>();
		System.out.println(result);
		mav.addObject("flag", result);
		return mav;
	}
	
	
}
