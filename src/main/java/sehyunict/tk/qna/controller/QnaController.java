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
	private ModelAndView save(QnaVo qnaVo, HttpSession session) {
		//ModelAndView 경로를 담을 수 있는
		//ModelAndView로 저장하고 나면 다시 리스트 목록을 보여주려고 qna/qna(리스트 목록 있는 jsp경로) 경로 지정	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("qna/qna");
		
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

		return mav;

	}

	@PostMapping("/modify")
	public ModelAndView modify(QnaVo qnaVo, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("qna/qna");
		
		try {
			int userId = 55;
			qnaVo.setUserId(userId);
			if(qnaService.modify(userId, qnaVo) !=1) 
				throw new Exception ("qna modify error");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;	 
	}
	
	
	@GetMapping("/remove/{qnaId}")
	public ModelAndView remove(@PathVariable int qnaId, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("qna/qna");
		

		try {
			int userId = 55;
			if(qnaService.remove(userId,qnaId) !=1)
				throw new Exception ("qna remove error");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav; 
	}

	
	@GetMapping("/{qnaId}")
	public ModelAndView getQna(@PathVariable int qnaId, ModelAndView mav) {
		
		mav.setViewName("qna/qnaDetail");
		try {
			QnaVo qnaVo = qnaService.getQna(qnaId);	//넘겨준qnaId랑 일치하는 qnaId를 가지고 있는 qnaVo를 리턴
			mav.addObject("qnaVo", qnaVo);	//리턴값을 키와벨류 형태로 추가 (키로 jsp에서 값을 불러옴)
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
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
//ModelAndView -> 데이터와 이동하고자 하는 View Page를 같이 저장
//ModelandView 쓸때 페이지 이동값은 setViewName으로 페이지 세팅한다
//GetMapping일때의 경로 지정(selectAll()은 getmapping)
//getQnaMain()메서드는 그냥 메서드명
//mav변수의 setViewName객체에 qna/qna (jsp경로를 넣어준다)
//Getmapping으로 selectAll()해서 받은 데이터들을 qna.jsp로 경로를 지정함
//qna.jsp로 가는 경로
	@GetMapping("/qnaContent")
	public ModelAndView getQnaContent() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("qna/qnaContent");
		return mav;
	}
//GetMapping으로 getQna()해서 받은 데이터들을 qnaContent.jsp으로 경로 지정함	
//qna/qnaContent 
//qnaContent.jsp로 가는 경로

	@GetMapping("/qnaModify/{qnaId}")	//이미 작성된글을 수정하는거니까 SELECT 조회데이터가 들어있어야함 (qnaId를 넣어서 조회하려고)
	public ModelAndView modifyQna(@PathVariable int qnaId) {	//@PathVariable 패스값 줄때 {} 이렇게된 매개변수가 필요 (세트)
		ModelAndView mav = new ModelAndView();	//일회용
		mav.setViewName("qna/qnaModify");	//경로는 qna/qnaModify 지정
		QnaVo qnaVo = null;	//qnaVo 비어져있는상태
		
		try {
			qnaVo = qnaService.getQna(qnaId);	//넘겨준qnaId랑 일치하는 qnaId를 가지고 있는 qnaVo를 리턴
			mav.addObject("qnaVo", qnaVo);		//리턴값을 키와벨류 형태로 추가 (키로 jsp에서 값을 불러옴)
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;		//예외안뜨면 view에 리턴값보낸다
	}
//게시물을 수정하는 페이지로 넘어가는 경우에는 get방식을, 내용을 수정해서 수정버튼을 누르는 경우에는 post방식이 사용된다


}