package sehyunict.tk.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum FormStatus implements CustomStatus {
	
	INSERT_OK("성공", true),
	UPDATE_OK("성공", true),
	DELETE_OK("성공", true),
	SELECT_OK("성공", true),
	INSERT_FAIL("알 수 없는 오류로 실패했습니다", false),
	INSERT_FAIL_COUNT_OVER("장바구니에 상품은 최대 10개입니다", false),
	UPDATE_FAIL("실패", false),
	DELETE_FAIL("실패", false),
	SELECT_FAIL("실패", false);

	private final String description;
	private final Boolean status;

}
