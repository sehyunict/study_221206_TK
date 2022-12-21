package sehyunict.tk.constant;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT )
public interface BaseStatus {
	
	String getDescription();
	Boolean getFlag();

}
