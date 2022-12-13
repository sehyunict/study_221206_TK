//package sehyunict.tk.item.service;
//
//import java.util.List;
//
//import org.apache.ibatis.session.SqlSession;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.springframework.stereotype.Repository;
//
//import sehyunict.tk.item.entity.ItemVo;
//
//@Repository
//public class ItemDao {
//	
//	private SqlSession mybatis;
//	
//	public ItemDao() {
//		mybatis = SqlSessionFactoryBean. getSqlSessionInstance();
//	}
//	
//	public void insert(ItemDao itemvo) throws Exception{
//		mybatis.insert("", itemvo); // 네임스페이스.아이디 형태로 mapper에 있는 쿼리문을 호출할 수 있다.
//		mybatis.commit();		//HashMap, Map, List, Integer, String
//	}
//	
//	public void update(ItemDao itemvo) {
//		mybatis.update("", itemvo);
//		mybatis.commit();
//	}
//	
//	public void delete(ItemDao itemvo) {
//		mybatis.delete("", itemvo);
//		mybatis.commit();
//	}
//	
//	public ItemDao select(ItemDao itemvo) {
//		return (ItemDao) mybatis.selectOne("", itemvo);
//	}
//	
//	public List<ItemDao> getBoardList(ItemDao itemvo) {
//		return mybatis.selectList("", itemvo);
//	}
//
//	
//	//item 등록
//	ItemVo insert(ItemVo itemvo) throws Exception {
//		if (itemvo == null) {
//			return null;
//		} else {
//
//			return itemvo;
//		}
//	}
//	
////	//item 목록조회
////	List<ItemVo> selectList() throws Exception {
////		
////		return selectList();
////	}
////	
////	//item 상세조회
////	ItemVo select(int item_id) throws Exception {
////		ItemVo itemvo = item_id
////		
////		return ;
////	}
////	
////	//item 수정
////	int update(ItemVo itemvo) {
////		if (itemvo == null) {
////			
////			return 0;
////		}else {
////			
////			return 1;
////		}
////	}
////	
////	//item 삭제
////	int delete(int item_id) throws Exception {
////		if (item_id == null) {
////			
////			return 0;
////		}else {
////			
////			return 1;
////		}	}
//}
