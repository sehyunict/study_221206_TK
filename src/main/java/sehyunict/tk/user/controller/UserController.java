package sehyunict.tk.user.controller;

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
		//로그인기능 없으므로 user id=1임시부여
		vo.setUser_id(1);
		
		model.addAttribute("user", userService.getUserInfo(vo));
		
		return "MyUserInfo";
	}
}
