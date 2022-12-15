package sehyunict.tk.pay.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sehyunict.tk.pay.entity.PayVo;
import sehyunict.tk.pay.service.PayService;

@RequestMapping("/pay")
@RestController
public class PayController {

	@Autowired
	private PayService payService;

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
	
	@PostMapping()
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
	public String getList(@PathVariable String sortType, Model m, HttpSession session) {
		int userId = (int) session.getAttribute("userId");
		userId = 1;
		
		try {
			List<PayVo> payList = payService.getList(userId, sortType);
			if(payList==null)
				throw new RuntimeException("paylist null");
			m.addAttribute("payList", payList);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
			
		}
		
		return "pay";
	}
	

}
