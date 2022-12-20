package sehyunict.tk.review.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import sehyunict.tk.review.entity.ReviewVo;

@Mapper
public interface ReviewDao {
	
	//리뷰 전체 조회
	public String reviewAllList();
	
	//리뷰 조회
	public List<ReviewVo> selectReviewList(int timetable_id);
	
	//평균별점 구하기
	public double selectRating(Integer star);
	
	//리뷰 등록
	public boolean RegReview(ReviewVo vo);
	
	//리뷰 수정
	public boolean updateReview(ReviewVo vo);
	
	//리뷰 삭제
	public boolean deleteReview(ReviewVo vo); 
}
