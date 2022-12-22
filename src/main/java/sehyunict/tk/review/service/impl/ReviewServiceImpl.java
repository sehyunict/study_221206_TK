package sehyunict.tk.review.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sehyunict.tk.review.entity.ReviewVo;
import sehyunict.tk.review.service.ReviewDao;
import sehyunict.tk.review.service.ReviewService;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	ReviewDao reviewDao;
	
	//리뷰 전체조회
	@Override
	public String reviewAllList() {
		
		return reviewAllList();
	}
	
	
	//리뷰 조회
	@Override
	public List<ReviewVo> retrieveReviewList(int timetable_id) {
		
		return reviewDao.selectReviewList(timetable_id);
	}
	
	//리뷰 등록
	@Override
	public boolean RegReview(ReviewVo vo) {
		
		return reviewDao.RegReview(vo);
	}
	
	//리뷰 삭제
	@Override
	public boolean removeReview(ReviewVo vo) {
		
		return reviewDao.deleteReview(vo);
	}

	//평균 별점 구하기
	@Override
	public double selectRating(Integer star) {
		
		return reviewDao.selectRating(star);
	}

	//리뷰 수정
	@Override
	public boolean updateReview(ReviewVo vo) {
		
		return reviewDao.updateReview(vo);
	}

	
	
	
	
	
	
}
