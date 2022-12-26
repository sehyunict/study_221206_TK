package sehyunict.tk.pay.service.impl;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import sehyunict.tk.cart.entity.CartVo;
import sehyunict.tk.pay.entity.PayVo;
import sehyunict.tk.pay.service.PayDao;
import sehyunict.tk.pay.service.PayService;
import sehyunict.tk.util.Pagination;
import sehyunict.tk.util.PriceConverter;

@Service("payService")
public class PayServiceImpl implements PayService {

	@Autowired
	private PayDao payDao;

	//사용자가 요청한 좌석이 예약테이블에 있는지 조회 후 반환, 리턴값이 0이 아니라면 예약불가
	@Override
	public Integer hasReservedSeat(int timetableId, int[] seatIds) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("timetableId", timetableId);
		map.put("seatIds", seatIds);

		return payDao.selectReservedSeat(map);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public int save(PayVo payVo, int[] seatIds) throws Exception {
		
		payDao.insertPayAndReturnId(payVo);
		for(int seatId : seatIds) {
			System.out.println("seatid"+seatId);
			payVo.setSeatId(seatId);
			payDao.insertOrder(payVo);
			payDao.insertReservedSeat(payVo);
		}
		return 1;
	}
	
	@Override
	public List<PayVo> getList(int userId, String sortType, Pagination page) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
		List<PayVo> payList = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", page);
		map.put("userId", userId);

		if (sortType.equals("ticket"))
			payList = payDao.selectAllByTicket(map);
		else if (sortType.equals("payment"))
			payList = payDao.selectAllByPayment(map);
		else
			new RuntimeException("정렬 타입이 적합하지 않습니다");

		for (PayVo payVo : payList) {
			payVo.setStartTimeStr(sdf.format(payVo.getStartTime()));
			payVo.setEndTimeStr(sdf2.format(payVo.getEndTime()));
			payVo.setItemPriceStr(PriceConverter.toChar(payVo.getItemPrice()));
			payVo.setPayDateStr(sdf.format(payVo.getPayDate()));
		}

		return payList;
	}

	@Override
	public List<PayVo> getSeats(int timetableId) throws Exception {
		return payDao.selectAllSeat(timetableId);
	}

	@Override
	public int getOrderTotalCount(int userId) throws Exception {
		return payDao.selectOrderTotalCount(userId);
	}

}
