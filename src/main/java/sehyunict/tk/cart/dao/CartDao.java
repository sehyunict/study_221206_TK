package sehyunict.tk.cart.dao;

import java.util.List;

import sehyunict.tk.cart.entity.CartVo;

public interface CartDao {
	//?��바구?�� insert
	//?��바구?�� delete
	//select ?��바구?�� 리스?��
	int insert(int userId, CartVo cartVo) throws Exception;
	
	int delete(int userId, CartVo cartVo) throws Exception;
	
	List<CartVo> selectAll(int userId) throws Exception;
	
}
