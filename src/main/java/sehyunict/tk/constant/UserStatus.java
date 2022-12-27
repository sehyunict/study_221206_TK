package sehyunict.tk.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserStatus implements BaseStatus{
	
	SESSION_OK(200, true, "세션 유효"),
	SESSION_FAIL(401, false, "세션 만료");

	private final int code;
	private final Boolean flag;
	private final String description;

}
