package sehyunict.tk.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserStatus implements CustomStatus{
	
	SESSION_OK("세션 유효", true),
	SESSION_FAIL("세션이 만료되었습니다. 다시 로그인해주세요", false);
	
	private final String description;
	private final Boolean status;

}
