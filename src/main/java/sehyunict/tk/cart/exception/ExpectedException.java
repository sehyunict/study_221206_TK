package sehyunict.tk.cart.exception;

import lombok.Getter;
import sehyunict.tk.constant.BaseStatus;

@Getter
public class ExpectedException extends RuntimeException{
	
	private BaseStatus status;
	
	ExpectedException(){}
	
	ExpectedException(BaseStatus status, String message){
		super(message);
		this.status = status;
	}

	@Override
	public synchronized Throwable fillInStackTrace() {
		return this;
		//return  new Throwable("stack trace delete");
	}
}
