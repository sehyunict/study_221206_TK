package Sehyunict.Tk.cart.entity;

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
public class CartVo {
	
	private int timetable_id;
	private Date start_time;
	private Date end_time;
	private String title;
	private int seat_id;
	private String seat_name;
	private int price;
	private String price_str;
	
	

}
