package sehyunict.tk.qna.service;

import java.util.List;

import sehyunict.tk.qna.entity.QnaVo;

public interface QnaService {
	int save(int userId, QnaVo qnaVo) throws Exception;	
	//userId는 id만 관리하는 세션에서 관리하니까 QnaVo안에는 userId는 null 값이다
	
	int modify(int userId, QnaVo qnaVo) throws Exception;
	
	int remove(int userId, int qnaId) throws Exception;
	
	QnaVo getQna(int qnaId) throws Exception;
	
	List<QnaVo> getList() throws Exception;
	
	List<QnaVo> search(String keyWord) throws Exception;
}
