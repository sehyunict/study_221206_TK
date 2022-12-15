package sehyunict.tk.item.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import sehyunict.tk.item.entity.ItemVo;

@Mapper
public interface ItemDao {
	
	//item 등록
	ItemVo insert(ItemVo itemvo) throws Exception;
	
	
	//목록페이지-영화
	List<ItemVo> movieSelectList() throws Exception;

	//목록페이지-연극
	List<ItemVo> theaterSelectList() throws Exception;
	
	//목록페이지-전시회
	List<ItemVo> exhibitionSelectList() throws Exception;
	
	
	//item 상세조회
	ItemVo select(int item_id) throws Exception;
	
	//item 수정
	int update(ItemVo itemvo);
	
	//item 삭제
	int delete(int item_id) throws Exception;
	
	
}
