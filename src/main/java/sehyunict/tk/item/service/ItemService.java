package sehyunict.tk.item.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import sehyunict.tk.item.entity.ItemVo;

public interface ItemService {
	//item 등록
	ItemVo register(ItemVo itemvo) throws Exception;
	
//	//item 목록조회
//	List<ItemVo> getList() throws Exception;

	//목록페이지-영화
	List<ItemVo> movieGetList() throws Exception;

	//목록페이지-연극
	List<ItemVo> theaterGetList() throws Exception;
	
	//목록페이지-전시회
	List<ItemVo> exhibitionGetList() throws Exception;	
	
	//item 상세조회
	List<ItemVo> getDetailList(int item_id) throws Exception;
	
	//item 수정
	boolean modify(ItemVo itemvo) throws Exception;
	
	//item 삭제
	boolean remove(int item_id) throws Exception;	
}
