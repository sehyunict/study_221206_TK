package sehyunict.tk.cart.entity.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FormStatus {
	
	OK("성공", true),
	FAIL("실패", false);

	private final String description;
	
	private final Boolean status;

}
