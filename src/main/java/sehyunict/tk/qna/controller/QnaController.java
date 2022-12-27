package sehyunict.tk.qna.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import sehyunict.tk.qna.entity.QnaVo;
import sehyunict.tk.qna.service.QnaService;

@RequestMapping("/qna")
@RestController
public class QnaController {

	@Autowired
	private QnaService qnaService; // qnaService 쓰겠다

	
	//qna.jsp에서 글쓰기 버튼 누르면 qnaContent.jsp로 이동
	@GetMapping("/qnaContent")
	public ModelAndView getQnaContent() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("qna/qnaContent");
		return mav;
	}
	
	
	//저장 기능
	@PostMapping
	private ModelAndView save(QnaVo qnaVo, HttpSession session) {
		//ModelAndView-> controller처리 결과 후 응답할 view나 view에 전달할 값을 저장 및 전달하는 클래스(데이터와 뷰를 동시에 설정가능)
		//ModelAndView로 저장하고 나면 다시 리스트 목록을 보여주려고 qna/qna(리스트 목록 있는 jsp경로) 경로 지정	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("qna/qna");	//데이터보낼 view 경로
		//save메서드 실행시 성공실패 나타낼때 예외처리
		try {
			//int userId = (int)session.getAttribute("userId");
			int userId = 55;
			// 성공한 행의 개수를 1로 반환, save된거면 1로 반환,qnaService.save(userId, qnaVo) 1이 아니면 저장이 안된거고
			// 요청한곳으로 에러를 던져준다 = throw (controller에서는 view가 될거고 service에서는 controller가 되는건가)
			if (qnaService.save(userId, qnaVo) != 1) 
				throw new Exception("qna save error");

		} catch (Exception e) { // 에러 캐치
			e.printStackTrace();
		}

		return mav;

	}
	
	
	//qnaDetail.jsp에서 수정 버튼 누르면 qnaModify.jsp 이동
	//게시물을 수정하는 페이지로 넘어가는 경우에는 get방식을, 내용을 수정해서 수정버튼을 누르는 경우에는 post방식이 사용된다
	@GetMapping("/qnaModify/{qnaId}")	//이미 작성된글을 수정하는거니까 SELECT 조회데이터가 들어있어야함 (qnaId를 넣어서 조회하려고)
	public ModelAndView modifyQna(@PathVariable int qnaId) {	//@PathVariable 패스값 줄때 {} 이렇게된 매개변수가 필요 (세트)
		ModelAndView mav = new ModelAndView();	
		mav.setViewName("qna/qnaModify");	//경로는 qna/qnaModify 지정
		QnaVo qnaVo = null;	//qnaVo 비어져있는상태
		
		try {
			qnaVo = qnaService.getQna(qnaId);	//넘겨준qnaId랑 일치하는 qnaId를 가지고 있는 qnaVo를 리턴
			mav.addObject("qnaVo", qnaVo);		//리턴값을 키와벨류 형태로 추가 (키로 jsp에서 값을 불러올수있음)
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;		//예외안뜨면 view에 리턴값보낸다
	}
	
	
	
	
	//수정 기능
	@PostMapping("/modify")
	public ModelAndView modify(QnaVo qnaVo, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("qna/qna");
		
		try {
			//int userId = (int)session.getAttribute("userId");
			int userId = 55;
			qnaVo.setUserId(userId);
			if(qnaService.modify(userId, qnaVo) !=1) 
				throw new Exception ("qna modify error");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav;	 
	}
	
	
	//삭제 기능
	@GetMapping("/remove/{qnaId}")
	public ModelAndView remove(@PathVariable int qnaId, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("qna/qna");
		

		try {
			//int userId = (int)session.getAttribute("userId");
			int userId = 55;
			if(qnaService.remove(userId,qnaId) !=1)
				throw new Exception ("qna remove error");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mav; 
	}

	
	//개별 게시글로 보기
	@GetMapping("/{qnaId}")
	public ModelAndView getQna(@PathVariable int qnaId) {
		ModelAndView mav = new ModelAndView();
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
	//qnaVo를 qnaService로 보내고 select해서 가져온 데이터들을 예외가 안뜨면 view로 보내는과정
	
	
	//전체 게시글 목록으로 보기
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
	
	
	//qna 메인페이지 경로
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
	
	
	@GetMapping("/search")
	public ModelAndView searchQna(@RequestParam("kw") String keyWord) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("qna/qna");
		System.out.println(keyWord);
		try {
			List<QnaVo> list = qnaService.search(keyWord);	
			mav.addObject("list", list);		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
		
	}
}
//	@GetMapping("/list")
//	public ModelAndView qnaPageList(ModelAndView mav, 
//			@RequestParam(value = "currPageNo", required = false, defaultValue = "1") String tmpcurrPageNo, 
//   	 		@RequestParam(value = "range", required = false, defaultValue = "1") String tmprange) {
//		
//		int currPageNo = 0;
//		int range = 0;
//		
//		try {			
//			currPageNo = Integer.parseInt(tmpcurrPageNo);
//			range = Integer.parseInt(tmprange);
//			
//		} catch(NumberFormatException e) {
//			currPageNo = 1;
//			range = 1;			
//		}
//	
//	}
//	

