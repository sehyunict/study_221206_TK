package sehyunict.tk.user.entity;

import lombok.Data;

@Data
public class UserVo {
	
	private int user_id;
	private String user_name;
	private String user_pwd;
	private String user_email;
	private String user_phone;
}
