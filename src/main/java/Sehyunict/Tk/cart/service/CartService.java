package Sehyunict.Tk.cart.service;

import java.util.List;

import Sehyunict.Tk.cart.entity.CartVo;

public interface CartService {

	int put(int userId, CartVo basketVo) throws Exception;
	
	int delete(int userId, CartVo cartVo) throws Exception;
	
	List<CartVo> getList(int userId) throws Exception;

}
