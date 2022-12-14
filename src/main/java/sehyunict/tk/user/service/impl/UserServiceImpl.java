package sehyunict.tk.user.service.impl;

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
	
	
}
