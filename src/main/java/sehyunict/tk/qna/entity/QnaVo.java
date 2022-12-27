package sehyunict.tk.qna.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class QnaVo {
	
	private int qnaId;
	private String title;
	private String content;
	private int userId;
	private String userName;
	private Date createdAt; 
	private String createdAtStr;

}
