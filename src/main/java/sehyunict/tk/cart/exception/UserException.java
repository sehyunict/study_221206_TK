package sehyunict.tk.cart.exception;

import sehyunict.tk.constant.UserStatus;

public class UserException extends ExpectedException{

	public UserException() {
	}
	
	public UserException(UserStatus status, String message) {
		super(status, message);
	}
}
