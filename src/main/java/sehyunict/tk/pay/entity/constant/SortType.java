package sehyunict.tk.pay.entity.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum SortType {
	
	TICKET("티켓"),
	PAYMENT("결제");
	
	@Getter
	private final String description;
	
}
