package sehyunict.tk.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter 
public class Pagination {
	
	private int curPageNum;
	private int curPostNum;
	private int totalPageNum;
	private int totalPostNum;
	private final int size;
	
	public Pagination(int size) {
		this.size= size;
	}
	public void setCurPageNum(int curPageNum) {
		this.curPageNum = curPageNum+1;
	}
	public void setCuPostNum(int curPageNum) {
		this.curPostNum = curPostNum+size;
	}
	public void setTotalPostNum(int totalPostNum) {
		this.totalPostNum = totalPostNum;
		if(totalPostNum%size == 0) {
			totalPageNum = totalPostNum/size;
		}else {
			totalPageNum = totalPostNum/size+1;
		}
	}
	
}
