package sehyunict.tk.pay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sehyunict.tk.pay.entity.PayVo;
import sehyunict.tk.pay.service.PayDao;
import sehyunict.tk.pay.service.PayService;

@Service
public class PayServiceImpl implements PayService{

	@Override
	public Integer hasReservedSeat(int timetableId, String seatName) throws Exception {
		
		return null;
	}

	@Override
	public int save(PayVo payVo) throws Exception {
		
		return 0;
	}

	@Override
	public List<PayVo> getListByTicket(int userId) throws Exception {
		
		return null;
	}

	@Override
	public List<PayVo> getListByPayment(int userId) throws Exception {
		
		return null;
	}
	
//	@Autowired
//	private PayDao payDao;
//
//	@Override
//	public Integer hasReservedSeat(int timetableId, String seatName) throws Exception {
//		
//		return payDao.selectReservedSeat(timetableId, seatName);
//	}
//
//	@Override
//	@Transactional(rollbackFor = Exception.class)
//	public int save(PayVo payVo) throws Exception {
//		
//		int payId = payDao.insertPayAndReturnId(payVo);
//		payDao.insertOrder(payVo, payId);
//		payDao.insertReservedSeats(payVo);
//		
//		return 0;
//	}
//
//	@Override
//	public List<PayVo> getListByTicket(int userId) throws Exception {
//		
//		return payDao.selectAllByTicket(userId);
//	}
//
//	@Override
//	public List<PayVo> getListByPayment(int userId) throws Exception {
//		
//		return payDao.selectAllByPayment(userId);
//	}

	
}
