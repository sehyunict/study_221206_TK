package sehyunict.tk.item.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemVo {
	
	//TN_TK_ITEM 테이블
	private int itemId;
	private String title;
	private String director;
	private String actor;
	private String summary;
	private String runningtime;
	private String caution;
//	private String originImagePath;	//업로드 전 이미지 경로
	private String imagePath;	//db에 저장될 이미지 경로(../resources/image/xxx.jpg) 

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDay;
	private String startDayStr;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDay;
	private String endDayStr;
	private Date regDate;
	private String writer;
	private String categoryId;
	private int statusId;
	private int genreId;
	
	//TN_TK_TIMETABLE 테이블
	private int timetableId;
	private int price;
	private String startTime;
	private String endTime;
	private int userId;
//	private int itemId2;
	
	//TC_TK_CODE 테이블
	private String codeName;
	private String codeName1;
	private String codeName2;
	

	//TN_TK_LIKE_GENRE 테이블
//	private int user_id;
//	private int genre_id;
	
	
	//	private String title;
//	private int seat_id;
//	private String seat_name;
//	private int price;
//	private String price_str;
}
