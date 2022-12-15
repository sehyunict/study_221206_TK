package sehyunict.tk.user.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sehyunict.tk.user.entity.UserVo;
import sehyunict.tk.user.service.UserDao;
import sehyunict.tk.user.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao; 
	
	//마이페이지에서 회원정보 조회
	@Override
	public UserVo getUserInfo(UserVo vo) {
		return userDao.getUserInfo(vo);
	}
	
	//회원정보 수정
	@Override
	public void updateUserInfo(UserVo vo) {
			userDao.updateUserInfo(vo);
	}
	
	//회원정보 수정시 비밀번호 확인
//	@Override
//	public UserVo pwCheck(UserVo vo) {
//		
//		return null;
//	}

	
	//내가 쓴 리뷰 목록
	@Override
	public List<UserVo> getMyReview(HashMap map) {
		return userDao.getMyReview(map);
	}


	
	
	
	
	
	
}
