package sehyunict.tk.pay.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sehyunict.tk.pay.entity.PayVo;
import sehyunict.tk.pay.service.PayDao;
import sehyunict.tk.pay.service.PayService;

@Service("payService")
public class PayServiceImpl implements PayService{
	
	@Autowired
	private PayDao payDao;

	@Override
	public Integer hasReservedSeat(int timetableId, String seatName) throws Exception {
		Map map = new HashMap();
		map.put("timetableId", timetableId);
		map.put("seatName", seatName);
		
		return payDao.selectReservedSeat(map);
	}

	@Override
	@Transactional
	public int save(PayVo payVo) throws Exception {
		try {
			payDao.insertPayAndReturnId(payVo);
			payDao.insertOrder(payVo);
			payDao.insertReservedSeats(payVo);
			
		} catch (Exception e) {
			throw new RuntimeException("pay insert fail, rollback");
		}
		return 0;
	}

	@Override
	public List<PayVo> getList(int userId, String sortType) throws Exception {
		if(sortType.equals("ticket")) 
			return payDao.selectAllByTicket(userId);
		else if(sortType.equals("payment"))
			return payDao.selectAllByPayment(userId);
		else 
			return null;
	}

}
