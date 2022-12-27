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

import sehyunict.tk.cart.exception.FormException;
import sehyunict.tk.cart.exception.UserException;
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
	private ModelAndView mav;

	@GetMapping("/{timetableId}")
	public ModelAndView seatMain(@PathVariable int timetableId) throws Exception {
		mav = new ModelAndView();
		mav.addObject("timetableId", timetableId);
		mav.setViewName("pay/seat");
		return mav;
	}

	@GetMapping("/seats/{timetableId}")
	public ModelAndView getSeats(@PathVariable int timetableId) throws Exception{
		mav = new ModelAndView("jsonView");
		mav.addObject("seats", payService.getSeats(timetableId));
		return mav;
	}

	@PostMapping
	public ModelAndView save(PayVo payVo, int[] seatIds, HttpSession session) throws Exception{
		mav = new ModelAndView("jsonView");

		int userId = getUserId(session);

		int result = payService.hasReservedSeat(payVo.getTimetableId(), seatIds);
		if (result != 0)
			throw new FormException(FormStatus.FAIL, "[PAY SEAT FIAL] - 이미 예약된 좌석이 존재");
	
		payVo.setUserId(userId);
		if (payService.save(payVo, seatIds) != 1) 
			throw new FormException(FormStatus.FAIL, "[PAY SAVE ERROR] - 정상 삽입된 행이 없음");
		
		mav.addObject("status", FormStatus.OK);

		return mav;
	}

	@GetMapping("/list")
	public ModelAndView getListSorted(
			@RequestParam(value="st", required = false, defaultValue = "ticket") String sortType
			, @RequestParam(value = "pa", required = false, defaultValue = "1") int curPageNum
			, @RequestParam(value = "po", required = false, defaultValue = "1") int curPostNum
			, HttpSession session) throws Exception{

		mav = new ModelAndView();
		Pagination page = null;
		List<PayVo> payList = null;

		int userId = getUserId(session);
		page = new Pagination(5);
		page.setCurPageNum(curPageNum);
		page.setCurPostNum(curPostNum);
		page.setTotalPostNum(payService.getOrderTotalCount(userId));
		payList = payService.getList(userId, sortType, page);
		mav.setViewName("pay/myOrderList");
		mav.addObject("payList", payList);
		mav.addObject("page", page);

		return mav;
	}

	private int getUserId(HttpSession session) throws UserException {
		Object userId = session.getAttribute("userId");
		if (userId == null)
			throw new UserException(UserStatus.SESSION_FAIL,"Session hasn't userId");
		return (int) userId;
	}

}
