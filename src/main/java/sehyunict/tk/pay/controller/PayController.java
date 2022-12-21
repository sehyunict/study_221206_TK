package sehyunict.tk.pay.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import sehyunict.tk.constant.CustomStatus;
import sehyunict.tk.constant.FormStatus;
import sehyunict.tk.constant.UserStatus;
import sehyunict.tk.pay.entity.PayVo;
import sehyunict.tk.pay.service.PayService;
import sehyunict.tk.util.Pagination;

@RequestMapping("/pay")
@RestController
public class PayController {

	@Autowired
	private PayService payService;
	
	@GetMapping("/{timetableId}")
	public ModelAndView seatMain(@PathVariable int timetableId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("timetableId", timetableId);
		mav.setViewName("pay/seat");
		return mav;
	}

	@GetMapping("/seat?timetableId={timetableId}&seatName={saetName}")
	public String hasReservedSeat(
			@PathVariable int timetableId
			, @PathVariable String seatName
			) {
		ModelMap mm = new ModelMap();
			
		try {
			mm.addAttribute("result", payService.hasReservedSeat(timetableId, seatName));
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
	public ModelAndView save(PayVo payVo, Integer[] seatIds, HttpSession session) {
		
		ModelAndView mav = new ModelAndView("jsonView");
		mav.setViewName("jsonView");
		ModelMap mm = new ModelMap();
		/*
		 * try { int userId = hasUserId(session); payVo.setUserId(userId);
		 * if(payService.save(payVo, seatIds)!=1) throw new
		 * RuntimeException("save error"); mav.addObject("status",
		 * FormStatus.INSERT_OK);
		 * 
		 * } catch (Exception e) { mav.addObject("status", FormStatus.INSERT_FAIL);
		 * mav.setViewName("error/error"); e.getMessage(); e.printStackTrace(); }
		 */
		return mav;
	}
	
	@GetMapping("/list")
	public ModelAndView getListSorted(
			@RequestParam("st") String sortType,
			@RequestParam("pa") int curPageNum,
			@RequestParam("po") int curPostNum,
			HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		Pagination page = null;
		List<PayVo> payList = null;
		
		try {
			int userId = hasUserId(session);
			page = new Pagination(5);
			page.setCurPageNum(curPageNum);
			page.setCurPostNum(curPostNum);
			page.setTotalPostNum(payService.getOrderTotalCount(userId));
			payList = payService.getList(userId, sortType, page);
	
			mav.setViewName("pay/myOrderList");
			mav.addObject("payList", payList);
			mav.addObject("page", page);
		}catch (NullPointerException e) {
			e.printStackTrace();
			mav.setViewName("error/error");
			mav.setStatus(HttpStatus.GATEWAY_TIMEOUT);
			mav.addObject("status", UserStatus.SESSION_FAIL);
		}catch (Exception e) {
			mav.setViewName("error/error");
			e.printStackTrace();
		}
		return mav;
	}
	

	private int hasUserId(HttpSession session) throws NullPointerException {
		Object userId = session.getAttribute("userId");
		if (userId == null)
			throw new NullPointerException("session hasn't userId");
		return (int) userId;
	}

}
