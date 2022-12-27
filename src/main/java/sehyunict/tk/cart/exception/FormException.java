package sehyunict.tk.cart.exception;

import lombok.Getter;
import sehyunict.tk.constant.FormStatus;

@Getter
public class FormException extends ExpectedException{
	
	public FormException() {}

	public FormException(FormStatus status, String message) {
		super(status, message);
	}
}
