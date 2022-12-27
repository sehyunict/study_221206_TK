package sehyunict.tk.item.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import sehyunict.tk.item.entity.ItemVo;

@Mapper
public interface ItemDao {
	
	//목록페이지-영화
	List<ItemVo> movieSelectList() throws Exception;

	//목록페이지-연극
	List<ItemVo> theaterSelectList() throws Exception;
	
	//목록페이지-전시회
	List<ItemVo> exhibitionSelectList() throws Exception;
	
	//item 상세조회(1영화당 여러 상영시간표)
	List<ItemVo> itemDetailList(@Param("itemId") Integer itemId) throws Exception;

	//목록페이지-관리자
	List<ItemVo> adminSelectList() throws Exception;
	
	//item 상세조회 - 관리자
	ItemVo adminItemDetail(@Param("itemId") Integer itemId) throws Exception;
	
	//관리자 item 등록
	int insert(ItemVo itemvo) throws Exception;

	//관리자 timetable 등록
	ItemVo insert2(ItemVo itemvo) throws Exception;
	
	//관리자 item 수정
	int update(ItemVo itemvo) throws Exception;
	
	//관리자 item 삭제
	int delete(@Param("itemId") Integer itemId) throws Exception;
	
	
	
}
