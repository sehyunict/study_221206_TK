package sehyunict.tk;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	
	@GetMapping(value = "/")
	public String home(Locale locale, Model model, HttpSession session) {
		
		session.setAttribute("userId", 55);
		System.out.println("home왔따감");
		
		return "home";
	}
	
}
