package sehyunict.tk.cart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sehyunict.tk.cart.entity.CartVo;
import sehyunict.tk.cart.service.CartDao;
import sehyunict.tk.cart.service.CartService;
import sehyunict.tk.util.PriceConverter;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private CartDao cartDao;
	
	@Override
	public int put(int userId, CartVo cartVo) throws Exception {
		
		return cartDao.insert(userId, cartVo);
	}

	@Override
	public int delete(int userId, CartVo cartVo) throws Exception {
		return cartDao.delete(userId, cartVo);
	}

	@Override
	public List<CartVo> getList(int userId) throws Exception {
		
		List<CartVo> list = cartDao.selectAll(userId);
		for(CartVo cartVo : list) {
			cartVo.setItemPriceStr(PriceConverter.toChar(cartVo.getItemPrice()));
		}
		
		return list;
	}

}
