package sehyunict.tk.pay.service;

import java.util.List;

import sehyunict.tk.pay.entity.PayVo;

public interface PayService {
	
	Integer hasReservedSeat(int timetableId, String seatName) throws Exception;
	
	int save(PayVo payVo) throws Exception;
	
	List<PayVo> getList(int userId, String sortType) throws Exception;
	
	List<PayVo> getSeats(int timetableId) throws Exception;
	
}
