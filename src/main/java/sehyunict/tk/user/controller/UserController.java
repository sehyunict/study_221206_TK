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
	

	//마이페이지 회원정보조회
	@RequestMapping("/mypage/MyUserInfo.do")
	public String getUserInfo(UserVo vo, Model model, HttpSession session) {
		//세션에서 user id 가져오기
		int currentId=(int)session.getAttribute("userId");
		vo.setUserId(currentId);
		
		model.addAttribute("user", userService.getUserInfo(vo));
		
		return "/mypage/MyUserInfo";
	}
	
	
	//수정페이지로 이동
	@RequestMapping("/mypage/MyUserInfoUpdate.do")
	public String goUserInfoUpdate(UserVo vo, Model model, HttpSession session) {
		//세션에서 user id 가져오기
		int currentId=(int)session.getAttribute("userId");
		vo.setUserId(currentId);
		
		model.addAttribute("user", userService.getUserInfo(vo));
		
		return "/mypage/MyUserInfoUpdate";
	}
	
	//회원정보 수정하기
	@RequestMapping("/mypage/updateForm.do")
	public String UserInfoUpdate(UserVo vo,Model model) {
		userService.updateUserInfo(vo);
		return "redirect:/mypage/MyUserInfo.do";
	}
	
	
	//내가 작성한 리뷰 리스트
	@RequestMapping("/mypage/MyReview.do")
	public String getMyReview(Model model, HttpSession session) {
		
		HashMap map=new HashMap();
		int currentId=(int)session.getAttribute("userId");
		
		map.put("userId", currentId);
		List<UserVo> myReviewList=userService.getMyReview(map);
		model.addAttribute("myReviewList", myReviewList);
		
		return "/mypage/MyReview";
	}
	
	
	//마이페이지에서 나의 리뷰 수정페이지로 이동
	@RequestMapping("/mypage/MyReviewUpdate.do")
	public String goMyReviewUpdate(UserVo vo,Model model,HttpSession session) {
		
		return "/mypage/MyReviewUpdate";
	}
	
	
	//마이페이지에서 리뷰 수정 (제목,내용 변경가능)
	
	//마이페이지에서 리뷰 삭제
	@RequestMapping("/mypage/deleteMyReview.do")
	public String deleteMyReview(UserVo vo) {
		userService.deleteMyReview(vo);
		return "redirect:/mypage/MyReview.do";
	}
	
	
	
}
