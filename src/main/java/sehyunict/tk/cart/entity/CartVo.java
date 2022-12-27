package sehyunict.tk.cart.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder.Default;
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
	
	private int userId;
	private int no;
	private int cartId;
	private int timetableId;
	private Date startTime;
	private String startTimeStr;
	private Date endTime;
	private String endTimeStr;
	private String itemTitle;
	private String imagePath;
	private int seatId;
	private String seatName;
	private int itemPrice;
	private String itemPriceStr;
}
