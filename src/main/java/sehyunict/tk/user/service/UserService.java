package sehyunict.tk.user.service;

import sehyunict.tk.user.entity.UserVo;

public interface UserService {
	
	//회원정보 조회
	UserVo getUserInfo(UserVo vo);
}
