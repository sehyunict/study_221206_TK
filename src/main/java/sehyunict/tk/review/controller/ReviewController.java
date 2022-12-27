package sehyunict.tk.review.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sehyunict.tk.review.entity.ReviewVo;
import sehyunict.tk.review.service.ReviewService;

//@RequestMapping("/home")
@Controller

public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	// 전체 리뷰 조회
	@GetMapping("/ReviewList")
	public String reviewAllList() {

		return "/ReviewList";
	}

	// 리뷰 조회
	@GetMapping("/selectReview")
	public String reviewList(@RequestParam(defaultValue = "55") int timetableId, Model model, ReviewVo vo, HttpSession session) {

		List<ReviewVo> list = reviewService.retrieveReviewList(timetableId);
		double rating = reviewService.selectRating(timetableId);
	
		model.addAttribute("rating", rating);
		model.addAttribute("list", list);
		System.out.println(list);

		return "/selectReview";
	}


	// 리뷰 등록
	@RequestMapping("/RegReview")
	public String RegReview(ReviewVo vo, Model model, HttpSession session) {

		
		Integer userId = (Integer)session.getAttribute("userId");
		
		//vo.setTimetableId(timetableId);
		
		
		vo.setTimetableId(55);
		vo.setUserId(userId);

		
		//System.out.println(userId);
		reviewService.RegReview(vo);
		//System.out.println(vo);

		return "redirect:/selectReview";
	}

	// 리뷰 수정
	@PostMapping("/updateReview")
	public String updateReview(ReviewVo vo, Model model, HttpSession session) {
		Integer userId = (Integer)session.getAttribute("userId");
		vo.setTimetableId(55);
		vo.setUserId(userId);
		
		reviewService.updateReview(vo);
		
		return "redirect:/selectReview";
	}
	

	// 리뷰 삭제
	@GetMapping("/deleteReview")
	public String deleteReview(@RequestParam("id") int reviewId, HttpSession session) {
		
		System.out.println("rrr"+reviewId);
		
		ReviewVo vo = new ReviewVo();
		vo.setReviewId(reviewId);
		Integer userId = (Integer)session.getAttribute("userId");
		//Integer reviewId = (Integer)session.getAttribute("userId");
		
		//vo.setReviewId(reviewId);
		vo.setTimetableId(55);
		vo.setUserId(userId);
		reviewService.removeReview(vo);
		
		
		return "redirect:/selectReview";
	}
	
}
