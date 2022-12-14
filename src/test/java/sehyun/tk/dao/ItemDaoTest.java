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
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j;
import sehyunict.tk.user.dao.UserDao;
import sehyunict.tk.cart.entity.CartVo;
import sehyunict.tk.cart.service.CartDao;
import sehyunict.tk.item.entity.ItemVo;
import sehyunict.tk.item.service.ItemDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/mybatis-context.xml")
@Log4j
public class ItemDaoTest {
	
	@Autowired
	private ItemDao itemdao;
	
	@Test
	public void insert() {
		ItemVo dao1 = new ItemVo(123, "영화1", "감독1", "배우1", "줄거리요약", "120분", "주의사항1" , "../resources/image/theater_1.jpg", "2022-11-12", "2023-02-01", "2022/10/02", "작가2", "3", 12, 6, 1, 10000, "2022-11-15 22:00", "2022-11-15 24:00", 1);
		ItemVo dao2 = new ItemVo(124, "영화2", "감독2", "배우2", "영화줄거리요약", "120분", "주의사항", "../resources/image/theater_1.jpg", "2022-11-12", "2023-02-01", "2022/10/02", "작가2", "3", 12, 6, 1, 10000, "2022-11-15 22:00", "2022-11-15 24:00", 1);
	}															
	
	
	
}
