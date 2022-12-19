package sehyunict.tk.qna.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import sehyunict.tk.qna.entity.QnaVo;

@Mapper
public interface QnaDao {
	
	public int insert(QnaVo qnaVo) throws Exception;
		 //필요한 정보 "userId" "title" "content" "qnaId"
	public int update(QnaVo qnavo) throws Exception;
	
	public int delete(Map<String, Integer> map) throws Exception; 
	
	public QnaVo select(int qnaId) throws Exception;
	
	public List<QnaVo> selectAll() throws Exception;
	
	
// mapper.xml에 정의한 쿼리문을 실행하는 메소드
// 메소드의 매개변수는 mapper 쿼리문에 필요한 데이터를 고려해서 매개변수 설정 
// 
}
