package sehyunict.tk.pay.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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

	@GetMapping("/seats/{timetableId}")
	public ModelAndView getSeats(@PathVariable int timetableId) {
		ModelAndView mav = new ModelAndView("jsonView");
		try {
			mav.addObject("seats", payService.getSeats(timetableId));

		} catch (Exception e) {
		}
		return mav;
	}

	@PostMapping
	public ModelAndView save(PayVo payVo, int[] seatIds, HttpSession session) {
		ModelAndView mav = new ModelAndView("jsonView");

		try {
			int userId = getUserId(session);

			int result = payService.hasReservedSeat(payVo.getTimetableId(), seatIds);
			if (result != 0)
				return mav.addObject("status", FormStatus.SELECT_FAIL);

			payVo.setUserId(userId);
			if (payService.save(payVo, seatIds) != 1) 
				throw new RuntimeException("pay save error");
			mav.addObject("status", FormStatus.INSERT_OK);

		} catch (Exception e) {
			mav.addObject("status", FormStatus.INSERT_FAIL);
			e.printStackTrace();
		}
		return mav;
	}

	@GetMapping("/list")
	public ModelAndView getListSorted(
			@RequestParam(value="st", required = false, defaultValue = "ticket") String sortType
			, @RequestParam(value = "pa", required = false, defaultValue = "1") int curPageNum
			, @RequestParam(value = "po", required = false, defaultValue = "1") int curPostNum
			, HttpSession session) {

		ModelAndView mav = new ModelAndView();
		Pagination page = null;
		List<PayVo> payList = null;

		try {
			int userId = getUserId(session);
			page = new Pagination(5);
			page.setCurPageNum(curPageNum);
			page.setCurPostNum(curPostNum);
			page.setTotalPostNum(payService.getOrderTotalCount(userId));
			payList = payService.getList(userId, sortType, page);
			mav.setViewName("pay/myOrderList");
			mav.addObject("payList", payList);
			mav.addObject("page", page);

		} catch (NullPointerException e) {
			e.printStackTrace();
			mav.addObject("status", UserStatus.SESSION_FAIL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	private int getUserId(HttpSession session) throws NullPointerException {
		Object userId = session.getAttribute("userId");
		if (userId == null)
			throw new NullPointerException("session hasn't userId");
		return (int) userId;
	}

}
