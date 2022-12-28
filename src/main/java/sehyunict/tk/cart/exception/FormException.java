package sehyunict.tk.cart.exception;

import sehyunict.tk.constant.FormStatus;

public class FormException extends ExpectedException{
	
	public FormException() {}

	public FormException(FormStatus status, String message) {
		super(status, message);
	}
}
