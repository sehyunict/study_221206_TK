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
	
	@RequestMapping("Mypage.do")
	public String Mypage() {
		return "Mypage";
	}
	
	
	//마이페이지 회원정보조회
	@RequestMapping("MyUserInfo.do")
	public String getUserInfo(UserVo vo, Model model) {
		//로그인기능 없으므로 user id임시부여
		vo.setUser_id(55);
		
		model.addAttribute("user", userService.getUserInfo(vo));
		
		return "MyUserInfo";
	}
	
	//내가 작성한 리뷰 리스트
	@RequestMapping("MyReview.do")
	public String getMyReview(Model model, HttpSession session) {
		
		HashMap map=new HashMap();
		map.put("user_id", (Integer)session.getAttribute("user_id"));
		List<UserVo> myReviewList=userService.getMyReview(map);
		model.addAttribute("myReviewList", myReviewList);
		
		return "MyReview";
	}
}
