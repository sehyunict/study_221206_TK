package sehyunict.tk.user.entity;

import lombok.Data;
import oracle.sql.DATE;

@Data
public class UserVo {
	
	private int user_id;
	private String user_name;
	private String user_pwd;
	private String user_email;
	private String user_phone;
	
	//내가쓴 리뷰 목록을 위한 변수
	private String title;
	private String content;
	private DATE regdate;
	private int star;
	
}
