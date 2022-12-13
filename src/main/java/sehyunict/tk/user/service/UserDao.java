package sehyunict.tk.user.service;

import org.apache.ibatis.annotations.Mapper;

import sehyunict.tk.user.entity.UserVo;

@Mapper
public interface UserDao {
	
	//mapper의 메소드명은 mapper.xml 파일의 id와 맞춰줘야 한다
	
	//마이페이지-회원정보 조회
	public UserVo getUserInfo(UserVo vo);
	
}
