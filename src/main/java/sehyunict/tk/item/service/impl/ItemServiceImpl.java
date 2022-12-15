package sehyunict.tk.item.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sehyunict.tk.item.entity.ItemVo;
import sehyunict.tk.item.service.ItemDao;
import sehyunict.tk.item.service.ItemService;

@Service("itemService")
public class ItemServiceImpl implements ItemService{
	@Autowired
	private ItemDao itemdao;

	@Override
	public ItemVo register(ItemVo itemvo) throws Exception {
		itemvo.setReg_date(new Date());
		
		System.out.println("register..." + itemvo);
		ItemVo insertVO = itemdao.insert(itemvo);
		return insertVO;
	}

//	@Override
//	public List<ItemVo> getList() throws Exception {
//		System.out.println("get List...");
//		return itemdao.selectList();
//	}
	
	@Override
	public List<ItemVo> movieGetList() throws Exception {
		System.out.println("movieGetList...");
		return itemdao.movieSelectList();
	}

	@Override
	public List<ItemVo> theaterGetList() throws Exception {
		System.out.println("theaterGetList...");
		return itemdao.theaterSelectList();
	}

	@Override
	public List<ItemVo> exhibitionGetList() throws Exception {
		System.out.println("exhibitionGetList...");
		List<ItemVo> list = itemdao.exhibitionSelectList();
	
		
		return list;
	}	
	

	@Override
	public ItemVo get(int item_id) throws Exception {
		System.out.println("get..." + item_id);
		return itemdao.select(item_id);
	}

	@Override
	public boolean modify(ItemVo itemvo) throws Exception {

		if (itemvo == null) {
			System.out.println("해당 아이템은 존재하지 않습니다.");
			return false;
		} else {
			System.out.println("modify..." + itemvo);
			return itemdao.update(itemvo) == 1;
		}
	}

	@Override
	public boolean remove(int item_id) throws Exception {
		ItemVo readVO = itemdao.select(item_id);	//itemvo 매개변수참조 id get
		if (readVO == null) {
			System.out.println("해당 아이템은 존재하지 않습니다.");
			return false;
		} else {
			System.out.println("remove..." + item_id);
			return itemdao.delete(item_id) == 1;	//1은 true 0은 false
		}
	}


}
