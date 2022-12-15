package sehyunict.tk.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FormStatus implements CustomStatus {
	
	INSERT_OK("성공", true),
	UPDATE_OK("성공", true),
	DELETE_OK("성공", true),
	SELECT_OK("성공", true),
	INSERT_FAIL("실패", false),
	UPDATE_FAIL("실패", false),
	DELETE_FAIL("실패", false),
	SELECT_FAIL("실패", false);

	private final String description;
	private final Boolean status;

}
