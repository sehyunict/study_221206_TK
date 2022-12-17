package sehyunict.tk.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserStatus implements CustomStatus{
	
	SESSION_OK("세션 유효", true),
	SESSION_FAIL("로그인이 필요합니다", false);
	
	private final String description;
	private final Boolean status;

}
