package sehyunict.tk.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserStatus implements CustomStatus{
	
	SESSION_OK("세션유효", true),
	SESSION_FAIL("세션만료", false);
	
	private final String description;
	private final Boolean status;

}
