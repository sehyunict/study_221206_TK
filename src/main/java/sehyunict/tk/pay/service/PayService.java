package sehyunict.tk.pay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sehyunict.tk.pay.entity.PayVo;

public interface PayService {
	
	Integer hasReservedSeat(int timetableId, String seatName) throws Exception;
	
	int save(PayVo payVo) throws Exception;
	
	List<PayVo> getListByTicket(int userId) throws Exception;
	
	List<PayVo> getListByPayment(int userId) throws Exception;
	
}
