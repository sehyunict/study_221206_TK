package Sehyunict.Tk.basket.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Sehyunict.Tk.basket.dao.BasketDao;
import Sehyunict.Tk.basket.entity.BasketVo;

@Repository
public class BasketDaoImpl implements BasketDao{

	@Autowired
	private SqlSession sqlSession;
	
	public static String namespace = "Sehyun.Tk.basket.dao.mapper.";
	
	@Override
	public int insert(int userId, BasketVo basketVo) throws Exception {
		Map map = new HashMap();
		map.put("userId", userId);
		map.put("basketVo", basketVo);
		
		return sqlSession.insert(namespace+"insert", map);
	}

	@Override
	public int delete(int userId, int basketId) throws Exception {
		Map map = new HashMap();
		map.put("userId", userId);
		map.put("basketId", basketId);
		
		return sqlSession.delete(namespace+"delete", map);
	}

	@Override
	public List<BasketVo> selectAll(int userId) throws Exception {
		
		return sqlSession.selectList(namespace+"selectAll", userId);
	}

}
