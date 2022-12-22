package sehyunict.tk.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum FormStatus implements BaseStatus {
	
	INSERT_OK("성공", true),
	UPDATE_OK("성공", true),
	DELETE_OK("성공", true),
	SELECT_OK("성공", true),
	INSERT_FAIL("실패", false),
	INSERT_FAIL_COUNT_OVER("장바구니 안 상품은 최대 10개입니다", false),
	UPDATE_FAIL("실패", false),
	DELETE_FAIL("실패", false),
	SELECT_FAIL("실패", false);

	private final String description;
	private final Boolean flag;

}
