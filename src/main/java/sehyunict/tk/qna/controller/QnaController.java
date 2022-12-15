package sehyunict.tk.qna.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sehyunict.tk.cart.entity.constant.FormStatus;
import sehyunict.tk.qna.entity.QnaVo;
import sehyunict.tk.qna.service.QnaService;

@RequestMapping("/qna")
@RestController
public class QnaController {

	@Autowired
	private QnaService qnaService; // qnaService 쓰겠다

	@PostMapping
	private String save(QnaVo qnaVo, HttpSession session) {
			//save메서드 실행시 성공실패 나타낼때 예외처리
		try {
			int userId = 55;
			// 성공한 행의 개수를 1로 반환
			// save된거면 1로 반환,qnaService.save(userId, qnaVo) 1이 아니면 저장이 안된거고
			// 에러를 던져준다 = throw
			if (qnaService.save(userId, qnaVo) != 1) 
				throw new Exception("qna save error");
			// qnaService.save(userId, qnaVo) 1이면 저장이 잘 된거니 아래 print문이 실행된다

		} catch (Exception e) { // 에러 캐치
			e.printStackTrace();
		}

		return "qna";

	}

	@PostMapping
	public String modify(QnaVo qnaVo, HttpSession session) {
		
		try {
			int userId = 55;
			if(qnaService.modify(userId, qnaVo) !=1) 
				throw new Exception ("qna modify error");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "qna";
	}

	@GetMapping
	public String remove(QnaVo qnaVo, HttpSession session) {
		
		try {
			int userId = 55;
			if(qnaService.remove(userId, qnaVo) !=1)
				throw new Exception ("qna remove error");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "qna";
	}

	@GetMapping
	public QnaVo getQna(int qnaId) {
		QnaVo qnaVo = null;
		try {
			qnaVo = qnaService.getQna(qnaId);	//qnaId만 가지고 qna게시글 볼 수 있게??
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return qnaVo;
	}

	@GetMapping("/list")
	public List<QnaVo> getList() {
		List<QnaVo> qnaList = null;	//qna list는 로그인 없어도 볼 수 있으니까??
		
		return qnaList;
	}

}
