package sehyunict.tk.review.service;

import java.util.List;

import sehyunict.tk.review.entity.ReviewVo;

public interface ReviewService {
	
	//리뷰 전체 조회
	public String reviewAllList();
	
	//리뷰 조회
	public List<ReviewVo> retrieveReviewList(int timetable_id);

	//평균 별점구하기
	public double selectRating(Integer star);

	//리뷰등록
	public boolean RegReview(ReviewVo vo);
	
	//리뷰수정
	public boolean updateReview(ReviewVo vo);
	
	//리뷰 삭제
	public boolean removeReview(ReviewVo vo);
}
