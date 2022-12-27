package sehyunict.tk.qna.service.impl;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sehyunict.tk.qna.entity.QnaVo;
import sehyunict.tk.qna.service.QnaDao;
import sehyunict.tk.qna.service.QnaService;

@Service("qnaService") //서비스 어노테이션이 선언된 클래스는 스프링이 인스턴스를 생성 후 빈으로 관리하게 된다
public class QnaServiceImpl implements QnaService{
	
	@Autowired	// 빈을 주입한다
	private QnaDao qnaDao;	//qnaDao를 쓰겠다
	
	@Override
	public int save(int userId, QnaVo qnaVo) throws Exception {
		qnaVo.setUserId(userId);
		//qnaVo의 setUserId메소드에 세션에서 관리하는 userId 넣은 상태로 qnaVo에 전달 
		//현재 qnaVo 에는 userId가 변수선언만 되었을뿐이지 userId는 관리하는 다른 세션이 존재한다 (이건아직모름) 
		//qnaVo는 실제 데이터의 주소값을 참조하는 참조변수이다
		//setUserId() 호출 시 qnaVo의 주소값은 변동이 없고 해당 주소의 실제데이터만 변경되는 것이다
		return qnaDao.insert(qnaVo);
		//위에서 qnaVo에 정보를 다 넣은후에 그 qnaVo를 가지고 qnaDao의 insert메소드에 qnaVo 넣는다
		//결국 save메소드에서는 정보들을 넣어서 Dao에 insert 메서드로 전달
	}

	@Override
	public int modify(int userId, QnaVo qnaVo) throws Exception {
		qnaVo.setUserId(userId);
		return qnaDao.update(qnaVo);
	}

	@Override
	public int remove(int userId, int qnaId) throws Exception {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("userId", userId);	//key값인 "userId" (String)을 부르면 value인 userId (integer) 호출할수있다 
		map.put("qnaId", qnaId);	//("qnaId" -> key, qnaId -> value) jsp에서 "qnaId" key값을 호출해서 value값인 qnaId를 쓸 수 있다
		
		return qnaDao.delete(map);
	}

	@Override
	public QnaVo getQna(int qnaId) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		//SimpleDateFormat클래스를 이용해서 "yyyy/MM/dd" 형식으로 날짜 포맷
		QnaVo qnaVo = qnaDao.select(qnaId); 
		//qnaDao의 select메서드에 qnaID넣은걸 QnaVo 참조변수타입의 qnaVo변수에 담는다		
		String tmp = sdf.format(qnaVo.getCreatedAt());	//  "2022/12/12"
		//qnaVo의 getter getCreatedAt()로 가져와서 날짜포맷변수인sdf의 format메서드에 담는다 그리고 그것을 또 tmp에 담는다 
		qnaVo.setCreatedAtStr(tmp);
		//tmp를 set으로 넣는다
		return qnaVo; 
		}

	@Override
	public List<QnaVo> getList() throws Exception {	//매개변수 없는이유 로그인 안해도 qna목록 볼수있게하려고
		List<QnaVo> list = qnaDao.selectAll();
		return list;
	}
	
	@Override
	public List<QnaVo> search(String keyWord) throws Exception {
		List<QnaVo> list = qnaDao.selectSearch(keyWord);
		return list;
	}
}
