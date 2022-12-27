package sehyunict.tk.cart.exception.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import sehyunict.tk.cart.exception.ExpectedException;

@RestControllerAdvice({"sehyunict.tk.cart","sehyunict.tk.pay"})
public class GlobalExceptionHandler {
	
	private ModelAndView mav;

	@ExceptionHandler
	public ModelAndView handleExpectedException(ExpectedException e) {
		e.printStackTrace();
		System.out.println("Form Description : "+e.getStatus().getDescription());
		mav = new ModelAndView("jsonView");
		mav.addObject("status", e.getStatus());
		return mav;
	}
}
