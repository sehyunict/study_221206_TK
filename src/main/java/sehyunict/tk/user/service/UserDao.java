package sehyunict.tk.user.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import sehyunict.tk.user.entity.UserVo;

@Mapper
public interface UserDao {
	
	
	//마이페이지-회원정보 조회
	public UserVo getUserInfo(UserVo vo);
	
	//내가 쓴 리뷰 조회
	public List<UserVo> getMyReview(HashMap map);
}