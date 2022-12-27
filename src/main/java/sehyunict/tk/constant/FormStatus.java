package sehyunict.tk.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum FormStatus implements BaseStatus {
	
	OK(200, true, "OK"),
	FAIL(400, false, "FAIL"),
	INSERT_FAIL_MAX_OVER(301, false, "INSERT_FAIL_MAX_OVER");

	private final int code;
	private final Boolean flag;
	private final String description;

}
