package sehyunict.tk.cart.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sehyunict.tk.cart.service.CartDao;
import sehyunict.tk.cart.entity.CartVo;
import sehyunict.tk.cart.service.CartService;
import sehyunict.tk.util.PriceConverter;

@Service("cartService")
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartDao cartDao;
	
	@Override
	public int save(int userId, CartVo cartVo) throws Exception {
		cartVo.setUserId(userId);
		
		return cartDao.insert(cartVo);
	}

	@Override
	public int delete(int userId, CartVo cartVo) throws Exception {
		cartVo.setUserId(userId);
		return cartDao.delete(cartVo);
	}

	@Override
	public List<CartVo> getList(int userId) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
		List<CartVo> list = cartDao.selectAll(userId);
		for(CartVo cartVo : list) {
			cartVo.setStartTimeStr(sdf.format(cartVo.getStartTime()));
			cartVo.setEndTimeStr(sdf2.format(cartVo.getEndTime()));
			cartVo.setItemPriceStr(PriceConverter.toChar(cartVo.getItemPrice()));
		}
		return list;
	}

}
