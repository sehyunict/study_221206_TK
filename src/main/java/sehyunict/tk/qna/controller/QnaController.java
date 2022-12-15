package sehyunict.tk.qna.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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

	@PostMapping("/modify")
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

	@GetMapping("/remove")
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

	@GetMapping("/{qnaId}")
	public QnaVo getQna(@PathVariable int qnaId) {
		QnaVo qnaVo = null;	
		try {
			qnaVo = qnaService.getQna(qnaId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return qnaVo;
	}
//save랑 delete처럼 !=1 안해줘도 되는이유는 성공한 행의 개수를 반환하기보다는 데이터를 가져오는것이기때문에 안해도된다	
// qnaVo를 qnaService로 보내고 select해서 가져온 데이터들을 예외가 안뜨면 view로 보내는과정?
	
	@GetMapping("/list")
	public List<QnaVo> getList() {
		List<QnaVo> qnaList = null;	
		try {
			qnaList = qnaService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qnaList;
	}
	@GetMapping
	public ModelAndView getQnaMain() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("qna/qna");
		return mav;
	}

}
