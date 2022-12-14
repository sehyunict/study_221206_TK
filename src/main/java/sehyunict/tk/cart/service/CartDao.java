package sehyunict.tk.cart.service;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;

import sehyunict.tk.cart.entity.CartVo;

@Mapper
public interface CartDao{
	
	int insert(CartVo cartVo) throws Exception;
	
	List<CartVo> selectAll(int userId) throws Exception;
	
	int delete(CartVo cartVo) throws Exception;

}
