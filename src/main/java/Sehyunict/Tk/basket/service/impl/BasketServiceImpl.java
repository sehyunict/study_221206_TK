package Sehyunict.Tk.basket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sehyunict.Tk.basket.dao.BasketDao;
import Sehyunict.Tk.basket.entity.BasketVo;
import Sehyunict.Tk.basket.service.BasketService;

@Service
public class BasketServiceImpl implements BasketService{

	@Autowired
	private BasketDao basketDao;
	
	@Override
	public int put(int userId, BasketVo basketVo) throws Exception {
		
		return basketDao.insert(userId, basketVo);
	}

	@Override
	public int delete(int userId, int basketId) throws Exception {
		return basketDao.delete(userId, basketId);
	}

	@Override
	public List<BasketVo> getList(int userId) throws Exception {
		return basketDao.selectAll(userId);
	}

}
