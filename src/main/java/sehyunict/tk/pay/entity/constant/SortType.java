package sehyunict.tk.pay.entity.constant;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SortType {
	
	TICKET("티켓"),
	PAYMENT("결제");
	
	
	private final String description;
	
}
