package sehyunict.tk.qna.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import sehyunict.tk.qna.entity.QnaVo;

@Repository
public class QnaDao {
	
	private SqlSession sqlSession;
	
	public static String namespace = "sehyun.tk.dao.qnaMapper.";
	
	public int insert(int userId, QnaVo qnaVo) throws Exception {
		 //필요한 정보 "userId" "title" "content" "qnaId"
	}
		
	
	public int update(int userId, QnaVo qnavo) throws Exception {
		//필요한 정보 "userId" "title" "content" "qnaId"
	}
	
	
	public int delete(int userId, QnaVo qnavo) throws Exception {
		//필요한 정보 "userId" "title" "content" "qnaId"
	}
	
	
	public List<QnaVo> selectAll (int userId) throws Exception {
		return sqlSession.selectList(namespace+"selectAll", userId);
	}
}
