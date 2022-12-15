package sehyunict.tk.user.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sehyunict.tk.user.entity.UserVo;
import sehyunict.tk.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/mypage/Mypage.do")
	public String Mypage() {
		return "/mypage/Mypage";
	}
	
	
	//마이페이지 회원정보조회
	@RequestMapping(value="/mypage/MyUserInfo.do")
	public String getUserInfo(UserVo vo, Model model, HttpSession session) {
		//세션에서 user id 가져오기
		int userId=(int)session.getAttribute("userId");
		vo.setUser_id(userId);
		
		model.addAttribute("user", userService.getUserInfo(vo));
		
		return "MyUserInfo";
	}
	
	
	//수정페이지로 이동
	@RequestMapping(value="/mypage/MyUserInfoUpdate.do")
	public String goUserInfoUpdate(UserVo vo, Model model, HttpSession session) {
		//세션에서 user id 가져오기
		int userId=(int)session.getAttribute("userId");
		vo.setUser_id(userId);
		
		model.addAttribute("user", userService.getUserInfo(vo));
		
		return "MyUserInfoUpdate";
	}
	
	//회원정보 수정하기
	@RequestMapping(value="updateForm.do")
	public String UserInfoUpdate(UserVo vo,Model model) {
		userService.updateUserInfo(vo);
		return "redirect:MyUserInfo.do";
	}
	
	
	//내가 작성한 리뷰 리스트
	@RequestMapping(value="/MyReview.do")
	public String getMyReview(Model model, HttpSession session) {
		
		HashMap map=new HashMap();
		int userId=(int)session.getAttribute("userId");
		
		map.put("user_id", userId);
		List<UserVo> myReviewList=userService.getMyReview(map);
		model.addAttribute("myReviewList", myReviewList);
		
		return "MyReview";
	}
	
	
}
