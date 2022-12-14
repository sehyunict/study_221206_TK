package sehyunict.tk.item.service;

import java.util.List;

import sehyunict.tk.item.entity.ItemVo;


public interface ItemDao {
	
	//item 등록
	ItemVo insert(ItemVo itemvo) throws Exception;
	
	//item 목록조회
	List<ItemVo> selectList() throws Exception;
	
	//item 상세조회
	ItemVo select(int item_id) throws Exception;
	
	//item 수정
	int update(ItemVo itemvo);
	
	//item 삭제
	int delete(int item_id) throws Exception;
	
	
}
