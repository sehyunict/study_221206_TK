package sehyunict.tk.item.entity;

import java.util.Date;

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
	private int item_id;
	private String title;
	private String director;
	private String actor;
	private String summary;
	private String runningtime;
	private String caution;
	private String image_path;
	private Date start_day;
	private Date end_day;
	private Date reg_date;
	private String writer;
	private String category_id;
	private int status_id;
	private int genre_id;
	
	//TN_TK_TIMETABLE 테이블
	private int timetable_id;
	private int price;
	private String start_time;
	private String end_time;
	private int user_id;
//	private int item_id;
	

	//TN_TK_LIKE_GENRE 테이블
//	private int user_id;
//	private int genre_id;
	
	
	//	private String title;
//	private int seat_id;
//	private String seat_name;
//	private int price;
//	private String price_str;
}
