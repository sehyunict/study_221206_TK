package sehyunict.tk.review.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewVo {
		
		private Integer reviewId;	//pk
		private Integer timetableId;	//fk
		private Integer userId;	//fk

		private String reviewTitle;
		private String content;
		private Integer star;
		private Date regdate;
		
		private String userName;
		private String itemTitle;
		
}
