package sehyunict.tk.pay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sehyunict.tk.pay.service.PayService;

@RequestMapping("/pay")
@RestController
public class PayController {
	
	@Autowired
	private PayService payService;
	
	@GetMapping("?timetableId={timetableId}&seatName={saetName}")
	public String hasReservedSeat(
			@PathVariable int timetableId
			, @PathVariable String seatName) {
	
		try {
			payService.hasReservedSeat(timetableId, seatName);
		} catch (Exception e) {
			
		}
		
		return "";
	}
	
	
	
	
	
}
