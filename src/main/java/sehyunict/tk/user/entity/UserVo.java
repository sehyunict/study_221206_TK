package sehyunict.tk.user.entity;

import lombok.Data;
import oracle.sql.DATE;

@Data
public class UserVo {
	
	private int userId;
	private String userName; 
	private String userPwd;
	private String userEmail;
	private String userPhone;
	
	//내가쓴 리뷰를 위한 변수
	private String title;
	private String movieTitle;
	private String content;
	private DATE regdate;
	private int star;
	private int reviewId;
	
	//내가쓴 문의사항을 위한 변수
	private String qnaTitle;
	private String qnaContent;

	
}
