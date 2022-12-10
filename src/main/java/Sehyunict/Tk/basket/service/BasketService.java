package Sehyunict.Tk.basket.service;

import java.util.List;

import Sehyunict.Tk.basket.entity.BasketVo;

public interface BasketService {

	int put(int userId, BasketVo basketVo) throws Exception;
	
	int delete(int userId, int basketId) throws Exception;
	
	List<BasketVo> getList(int userId) throws Exception;
}
