package Sehyunict.Tk.cart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sehyunict.Tk.cart.dao.CartDao;
import Sehyunict.Tk.cart.entity.CartVo;
import Sehyunict.Tk.cart.service.CartService;
import Sehyunict.Tk.util.PriceConverter;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private CartDao basketDao;
	
	@Override
	public int put(int userId, CartVo cartVo) throws Exception {
		
		return basketDao.insert(userId, cartVo);
	}

	@Override
	public int delete(int userId, CartVo cartVo) throws Exception {
		return basketDao.delete(userId, cartVo);
	}

	@Override
	public List<CartVo> getList(int userId) throws Exception {
		PriceConverter pc = new PriceConverter();
		
		List<CartVo> list = basketDao.selectAll(userId);
		for(CartVo cartVo : list) {
			cartVo.setPrice_str(pc.toChar(cartVo.getPrice()));
		}
		
		return list;
	}

}
