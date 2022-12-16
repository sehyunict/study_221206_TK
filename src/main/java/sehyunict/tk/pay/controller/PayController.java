package sehyunict.tk.pay.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import sehyunict.tk.pay.entity.PayVo;
import sehyunict.tk.pay.service.PayService;

@RequestMapping("/pay")
@RestController
public class PayController {

	@Autowired
	private PayService payService;
	
	@GetMapping("/{timetableId}")
	public ModelAndView seatMain(@PathVariable int timetableId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("timetableId", timetableId);
		mav.setViewName("pay/pay");
		return mav;
	}

	@GetMapping("/seat?timetableId={timetableId}&seatName={saetName}")
	public String hasReservedSeat(@PathVariable int timetableId
			, @PathVariable String seatName
			, Model m) {

		try {
			m.addAttribute("result", payService.hasReservedSeat(timetableId, seatName));
		} catch (Exception e) {
			
		}

		return "seat";
	}
	
	@GetMapping("/seats/{timetableId}")
	public ModelMap getSeats(@PathVariable int timetableId) {
		ModelMap mm = new ModelMap();
		try {
		  mm.addAttribute("seats", payService.getSeats(timetableId));
			
		} catch (Exception e) {
		}
		return mm;
	}
	
	
	@PostMapping
	public String save(PayVo payVo, Model  m) {
		try {
			if(payService.save(payVo)!=1) 
				throw new RuntimeException("save error");
			m.addAttribute("msg","pay_ok");
		} catch (Exception e) {
			e.getMessage();
			m.addAttribute("msg","pay_fail");
		}
		
		return "pay";
	}
	
	@GetMapping("/list?sort={sortType}")
	public String getList(@PathVariable String sortType, HttpSession session) {
		ModelMap mm = new ModelMap();
		
		int userId = (int) session.getAttribute("userId");
		userId = 1;
		
		try {
			List<PayVo> payList = payService.getList(userId, sortType);
			if(payList==null)
				throw new RuntimeException("paylist null");
			mm.addAttribute("payList", payList);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
			
		}
		
		return "pay";
	}

}
