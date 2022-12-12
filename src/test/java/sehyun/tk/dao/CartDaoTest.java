package sehyun.tk.dao;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import Sehyunict.Tk.User.Dao.userDao;
import Sehyunict.Tk.cart.dao.CartDao;
import Sehyunict.Tk.cart.entity.CartVo;

@Transactional
@ExtendWith(MockitoExtension.class)
public class CartDaoTest {

	@Mock
	CartDao cartDao;

	@DisplayName("��ǰ�� ��ٱ��Ͽ� ������ �����Ѵ�")
	@Test
	public void givenUserIdAndCartVo_when_then() throws Exception {
		
		CartVo input = createCartVo();
		List<CartVo> list = List.of(input);
		
		//given
		//BDDMockito.given(cartDao.selectAll(1)).willReturn(list);
		BDDMockito.given(cartDao.insert(1, any(CartVo.class))).willReturn(1);
		
		//when
		cartDao.insert(1, input);
	
		
		//then
		BDDMockito.then(cartDao).should().insert(1, input);
	}

	private CartVo createCartVo() {
		
		return new CartVo(
				47
				, new Date(2022-10-10)
				, new Date(2022-10-10)
				, "�����"
				, 10
				, "A10"
				, 10000, null );

	}

}
