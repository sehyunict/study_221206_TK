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

import sehyunict.tk.user.dao.UserDao;
import sehyunict.tk.cart.dao.CartDao;
import sehyunict.tk.cart.entity.CartVo;

@Transactional
@ExtendWith(MockitoExtension.class)
public class CartDaoTest {

	@Mock
	CartDao cartdao;

	@DisplayName("테스트")
	@Test
	public void givenUserIdAndCartVo_when_then() throws Exception {
		
		CartVo input = createCartVo();
		List<CartVo> list = List.of(input);
		
		//given
		//BDDMockito.given(cartdao.selectAll(1)).willReturn(list);
		BDDMockito.given(cartdao.insert(1, any(CartVo.class))).willReturn(1);
		
		//when
		cartdao.insert(1, input);
	
		
		//then
		BDDMockito.then(cartdao).should().insert(1, input);
	}

	private CartVo createCartVo() {
		
		return new CartVo(
				47
				, new Date(2022-10-10)
				, new Date(2022-10-10)
				, "어밴저스"
				, 10
				, "A10"
				, 10000, null );

	}

}
