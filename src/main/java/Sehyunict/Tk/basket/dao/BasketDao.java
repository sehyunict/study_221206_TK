package Sehyunict.Tk.basket.dao;

import java.util.List;

import Sehyunict.Tk.basket.entity.BasketVo;

public interface BasketDao {
	//장바구니 insert
	//장바구니 delete
	//select 장바구니 리스트
	int insert(int userId, BasketVo basketVo) throws Exception;
	
	int delete(int userId, int basketId) throws Exception;
	
	List<BasketVo> selectAll(int userId) throws Exception;
	
}
