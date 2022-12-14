package sehyunict.tk.cart.service;

import java.util.List;

import sehyunict.tk.cart.entity.CartVo;

public interface CartService {

	int save(int userId, CartVo cartVo) throws Exception;
	
	int delete(int userId, CartVo cartVo) throws Exception;
	
	List<CartVo> getList(int userId) throws Exception;

}
