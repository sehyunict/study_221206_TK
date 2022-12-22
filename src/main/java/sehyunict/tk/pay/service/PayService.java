package sehyunict.tk.pay.service;

import java.util.List;

import sehyunict.tk.pay.entity.PayVo;
import sehyunict.tk.util.Pagination;

public interface PayService {
	
	Integer hasReservedSeat(int timetableId, int[] seatIds) throws Exception;
	
	int save(PayVo payVo, int[] seatIds) throws Exception;
	
	List<PayVo> getList(int userId, String sortType, Pagination page) throws Exception;
	
	List<PayVo> getSeats(int timetableId) throws Exception;
	
	int getOrderTotalCount(int userId) throws Exception;
	
}
