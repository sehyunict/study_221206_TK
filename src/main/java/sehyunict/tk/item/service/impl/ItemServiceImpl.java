package sehyunict.tk.item.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import sehyunict.tk.item.entity.ItemVo;
import sehyunict.tk.item.service.ItemDao;
import sehyunict.tk.item.service.ItemService;

@Service("itemService")
public class ItemServiceImpl implements ItemService{
	@Autowired
	private ItemDao itemdao;


	//목록페이지-영화
	@Override
	public List<ItemVo> movieGetList() throws Exception {
		System.out.println("movieGetList...");
		SimpleDateFormat a1 = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat a2 = new SimpleDateFormat("yyyy/MM/dd HH24:mm");
		
		List<ItemVo> list = itemdao.movieSelectList();

		for(ItemVo itemVo : list) {
			itemVo.setStartDayStr(a1.format(itemVo.getStartDay()));
			itemVo.setEndDayStr(a1.format(itemVo.getEndDay()));
		}
		
		return list;
	}

	//목록페이지-연극
	@Override
	public List<ItemVo> theaterGetList() throws Exception {
		System.out.println("theaterGetList...");
		SimpleDateFormat a1 = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat a2 = new SimpleDateFormat("yyyy/MM/dd HH24:mm");
		
		List<ItemVo> list = itemdao.theaterSelectList();

		for(ItemVo itemVo : list) {
			itemVo.setStartDayStr(a1.format(itemVo.getStartDay()));
			itemVo.setEndDayStr(a1.format(itemVo.getEndDay()));
		}
		
		return list;
	}

	//목록페이지-전시회
	@Override
	public List<ItemVo> exhibitionGetList() throws Exception {
		System.out.println("exhibitionGetList...");
		SimpleDateFormat a1 = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat a2 = new SimpleDateFormat("yyyy/MM/dd HH24:mm");
		
		List<ItemVo> list = itemdao.exhibitionSelectList();

		for(ItemVo itemVo : list) {
			itemVo.setStartDayStr(a1.format(itemVo.getStartDay()));
			itemVo.setEndDayStr(a1.format(itemVo.getEndDay()));
		}
		
		return list;
	}	
	

	//item 상세조회
	@Override
	public List<ItemVo> getDetailList(Integer itemId) throws Exception {
		System.out.println("get..." + itemId );
		
		
		return itemdao.itemDetailList(itemId);
	}

	//목록페이지-관리자
	@Override
	public List<ItemVo> adminGetList() throws Exception {
		System.out.println("adminItemGetList...");
		SimpleDateFormat a1 = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat a2 = new SimpleDateFormat("yyyy/MM/dd HH24:mm");
		
		List<ItemVo> list = itemdao.adminSelectList();

		for(ItemVo itemVo : list) {
			if(itemVo.getStartDay()==null||itemVo.getEndDay()==null) {
				continue;
			}
			itemVo.setStartDayStr(a1.format(itemVo.getStartDay()));
			itemVo.setEndDayStr(a1.format(itemVo.getEndDay()));
		}
		
		return list;
	}

	//item 상세조회 - 관리자
	@Override
	public ItemVo adminItemDetail(Integer itemId) throws Exception {
		System.out.println("get..." + itemId );
		
		SimpleDateFormat a1 = new SimpleDateFormat("yyyy-MM-dd");
		
		ItemVo itemVo = itemdao.adminItemDetail(itemId);
		
		System.out.println(itemVo.getStartDay() + " " + itemVo.getEndDay());
		if(itemVo.getStartDay()==null||itemVo.getEndDay()==null) {
			return itemVo;
		}
		itemVo.setStartDayStr(a1.format(itemVo.getStartDay()));
		itemVo.setEndDayStr(a1.format(itemVo.getEndDay()));
		
		System.out.println(itemVo.getStartDayStr());
		System.out.println(itemVo.getEndDayStr());
		
		return itemVo;
	}
	
	//item 등록
	@Transactional
	@Override
	public ItemVo register(ItemVo itemvo) throws Exception {
		itemvo.setRegDate(new Date());
		
		System.out.println("register..." + itemvo);
		itemdao.insert(itemvo);
		
//		System.out.println("register2... " + itemvo);
//		itemdao.insert2(itemvo);
		
		return itemvo;
	}

	//time테이블 등록	
	@Override
	public ItemVo register2(ItemVo itemvo) throws Exception {
		
		return itemvo;
	}
	
	
	//item 수정 처리 
	@Override
	public boolean modify(ItemVo itemvo) throws Exception {
		
		if (itemvo == null) {
			System.out.println("수정할 내용이 없습니다.");
			return false;
		} else {
			System.out.println("modify..." + itemvo);
			return itemdao.update(itemvo) == 1;
		}
	}
	
	//item 삭제 처리
	@Override
	public boolean remove(int itemId) throws Exception {
		ItemVo readVo = itemdao.adminItemDetail(itemId);	//itemvo 매개변수참조 id get
		if (readVo == null) {
			System.out.println("삭제할 내용이 존재하지 않습니다.");
			return false;
		} else {
			System.out.println("remove..." + itemId);
			return itemdao.delete(itemId) == 1;	//1은 true 0은 false		return false;
	}
}

}
