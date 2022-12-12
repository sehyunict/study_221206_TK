package Sehyunict.Tk.cart.dao;

import java.util.List;

import Sehyunict.Tk.cart.entity.CartVo;

public interface CartDao {
	//?ž¥ë°”êµ¬?‹ˆ insert
	//?ž¥ë°”êµ¬?‹ˆ delete
	//select ?ž¥ë°”êµ¬?‹ˆ ë¦¬ìŠ¤?Š¸
	int insert(int userId, CartVo cartVo) throws Exception;
	
	int delete(int userId, CartVo cartVo) throws Exception;
	
	List<CartVo> selectAll(int userId) throws Exception;
	
}
