package sehyunict.tk.pay.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sehyunict.tk.pay.entity.PayVo;

@Repository
public class PayDaoImpl {
	
	@Autowired
	private SqlSession sqlSession;
	private static String namespace = "sehyun.tk.dao.payMapper.";

	public Integer selectReservedSeat(int timetableId, String seatName) throws Exception {
		Map map = new HashMap();
		map.put("timetableId", timetableId);
		map.put("seatName", seatName);
		return sqlSession.selectOne(namespace+"selectReservedSeat", map);
	}

	public int insertpayAndReturnId(PayVo payVo) throws Exception {
		
		Map map = new HashMap();
		map.put("totalprice", payVo.getTotalprice());
		map.put("mothodId", payVo.getMethodName());
		map.put("userId", payVo.getUserId());
		sqlSession.insert(namespace+"insertpay", map);
		
		return (int) map.get("payId");
	}
	
	public int insertOrder(PayVo payVo, int payId) throws Exception {
		Map map = new HashMap();
		map.put("seatId", payVo.getSeatId());
		map.put("itemPrice", payVo.getItemPrice());
		map.put("timetableId", payVo.getTimetableId());
		map.put("payId", payId);
		map.put("userId", payVo.getUserId());
		
		return sqlSession.insert(namespace+"insertOrder",map);
	}

	public int insertReservedSeats(PayVo payVo) throws Exception {
		
		Map map = new HashMap();
		map.put("timetableId", payVo.getTimetableId());
		map.put("seatId", payVo.getSeatId());
		
		return sqlSession.insert(namespace+"insertReservedSeat", map);
	}

	public List<PayVo> selectAllByTicket(int userId) throws Exception {
		
		return sqlSession.selectList(namespace+"selectAllByTicket", userId);
	}

	public List<PayVo> selectAllBypayment(int userId) throws Exception {
		
		return sqlSession.selectList(namespace+"selectAllBypayment", userId);
	}

	
}
