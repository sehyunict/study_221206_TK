package sehyunict.tk.pay.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PayVo {
	
	private int no;
	private Integer payId;
	private int userId;
	private int itemId;
	private int timetableId;
	private int methodId;
	private int totalprice;
	private String totalpriceStr;
	private int seatId;
	private String seatName;
	private String itemTitle;
	private int itemPrice;
	private String itemPriceStr;
	private String imagePath;
	private Date startTime;
	private String startTimeStr;
	private Date endTime;
	private String endTimeStr;
	private Date payDate;
	private String payDateStr;
	private String methodName;

}
