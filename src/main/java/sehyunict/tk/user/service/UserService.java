package sehyunict.tk.user.service;

import java.util.HashMap;
import java.util.List;

import sehyunict.tk.user.entity.UserVo;

public interface UserService {
	
	//회원정보 조회
	UserVo getUserInfo(UserVo vo);
	//내가 쓴 리뷰 조회
	List<UserVo> getMyReview(HashMap map);
}
