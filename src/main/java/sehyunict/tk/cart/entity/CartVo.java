package sehyunict.tk.cart.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartVo {
	
	private int userId;
	private int timetableId;
	private Date startTime;
	private Date endTime;
	private String itemTitle;
	private int seatId;
	private String seatName;
	private int itemPrice;
	private String itemPriceStr;

}
