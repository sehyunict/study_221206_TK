package sehyunict.tk.qna.service;

import java.util.List;

import sehyunict.tk.qna.entity.QnaVo;

public interface QnaService {
	int save(QnaVo qnaVo) throws Exception;
	
	int modify(QnaVo qnaVo) throws Exception;
	
	int remove(QnaVo qnaVo) throws Exception;
	
	QnaVo getQna(int qnaId) throws Exception;
	
	List<QnaVo> getList() throws Exception;
}
