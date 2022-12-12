package sehyunict.tk.pay.dao;

import java.util.List;

import sehyunict.tk.pay.entity.PayVo;

public interface PayDao {
	//결제시 pay에 insert, pay_id받아오고 order insert 이후 reserced_seats 에 insert
	//TIMETABLE_ID, SEAT_NAME 받아서 예약여부 확인 후 반환, seat_name받아서 id확인하고 해당 아이디로 조회
	//예매내역 티켓별조회
	//예매내역 결제별 조회
	
	Integer selectReservedSeat(int timetableId, String seatName) throws Exception;
	
	int insertpayAndReturnId(PayVo payVo) throws Exception;
	
	int insertOrder(PayVo payVo, int payId) throws Exception;
	
	int insertReservedSeats(PayVo payVo) throws Exception;
	
	List<PayVo> selectAllByTicket(int userId) throws Exception;
	
	List<PayVo> selectAllBypayment(int userId) throws Exception;
	
	
	
}
