package sehyun.tk.dao;

import static org.mockito.ArgumentMatchers.any;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

//github.com/sehyunict/study_221206_TK.git
import sehyunict.tk.cart.entity.CartVo;
import sehyunict.tk.cart.service.CartDao;

@Transactional
@ExtendWith(MockitoExtension.class)
public class CartDaoTest {

	@Mock
	CartDao cartdao;

	@Disabled
	@DisplayName("테스트")
	@Test
	public void givenUserIdAndCartVo_when_then() throws Exception {
		
		CartVo input = null;
		List<CartVo> list = List.of(input);
		
		//given
		//BDDMockito.given(cartdao.selectAll(1)).willReturn(list);
		BDDMockito.given(cartdao.insert(any(CartVo.class))).willReturn(1);
		
		//when

		cartdao.insert(input);
	
		
		//then
		//BDDMockito.then(cartdao).should().insert(1, input);
	}


}
