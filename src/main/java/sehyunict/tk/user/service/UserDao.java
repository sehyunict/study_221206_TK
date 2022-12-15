package sehyunict.tk.user.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import sehyunict.tk.user.entity.UserVo;

@Mapper
public interface UserDao {
	
	
	//마이페이지-회원정보 조회
	public UserVo getUserInfo(UserVo vo);
	//회원정보 수정
	void updateUserInfo(UserVo vo);
//	//비밀번호 체크
//	public UserVo pwCheck(UserVo vo);
	//내가 쓴 리뷰 조회
	public List<UserVo> getMyReview(HashMap map);
}
