package sehyunict.tk.user.service;

import java.util.HashMap;
import java.util.List;

import sehyunict.tk.user.entity.UserVo;

public interface UserService {
	
	//회원정보 조회
	UserVo getUserInfo(UserVo vo);
	//회원정보 수정
	void updateUserInfo(UserVo vo);
	//내가 쓴 리뷰 조회
	List<UserVo> getMyReview(HashMap map);
	//마이페이지에서 리뷰수정
	void updateMyReview(UserVo vo);
	//마이페이지에서 리뷰삭제
	void deleteMyReview(UserVo vo);
	
}
