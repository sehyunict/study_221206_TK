package Sehyunict.Tk.cart.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Sehyunict.Tk.cart.dao.CartDao;
import Sehyunict.Tk.cart.entity.CartVo;

@Repository
public class CartDaoImpl implements CartDao{

	@Autowired
	private SqlSession sqlSession;
	
	public static String namespace = "sehyun.tk.dao.CartMapper.";
	
	@Override
	public int insert(int userId, CartVo cartVo) throws Exception {
		Map map = new HashMap();
		map.put("userId", userId);
		map.put("timetableId", cartVo.getTimetableId());
		map.put("seatId", cartVo.getSeatId());
		
		return sqlSession.insert(namespace+"insert", map);
	}

	@Override
	public int delete(int userId, CartVo cartVo) throws Exception {
		Map map = new HashMap();
		map.put("userId", userId);
		map.put("timetableId", cartVo.getTimetableId());
		map.put("seatId", cartVo.getSeatId());
		
		return sqlSession.delete(namespace+"delete", map);
	}

	@Override
	public List<CartVo> selectAll(int userId) throws Exception {
		
		return sqlSession.selectList(namespace+"selectAll", userId);
	}

}
