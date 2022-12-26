package sehyunict.tk.util;

public class QnaPageMaker {
	private int currPageNo;		//현재 페이지 번호 (현재 몇번 페이지 인지)
	private int sizePerPage = 10;//한 페이지당 보여질 게시글 개수 (10개씩)
	private int totalCnt;		//전체 게시글 개수 (101개)
	private int pageCnt;		//전체 페이지 개수 (11개)
	
	private int startList;		//게시판 시작 번호 (1번이려나)
	private int range = 1;		//페이지 범위(1:1~5	2:6~10	3:11~15)
	private int pageSize = 5;	//한 페이지 범위에 보여질 페이지 개수 (밑에 12345 이런식으로) 
	private int startPage;		//각 페이지 범위의 시작 번호	(1 or 6 or 11)
	private int endPage;		//각 페이지 범위 끝 번호	(5 or 10 or 15)
	
	private boolean prev;		//이전 페이지 여부	
	private boolean next;		//다음 페이지 여부
	
	public void pageInfo(int currPageNo, int range, int totalCnt) {		//현재 페이지 번호, 페이지 범위, 전체 게시글 개수
		this.currPageNo = currPageNo;
		this.range = range;
		this.totalCnt = totalCnt;
		
		//전체 페이지 개수 (101/10)=10.1, Math.ceil->11
		this.pageCnt = (int)Math.ceil((double)totalCnt/sizePerPage);	
		//->101개의 게시글을 한 페이지 당 10개씩만 보여줄거니까 전체페이지 개수는 10.1을 올림해서 나타내면 11개
		
		//시작 페이지
		this.startPage = (range - 1) * pageSize +1;		//range가 1 이면 페이지1 부터 시작, range 2면 페이지5 부터 시작
		
		//끝 페이지
		this.endPage = range * pageSize;	//range가 1이면 (1*5)해서 끝페이지는5
		
		//게시판 시작 번호
		this.startList = (currPageNo - 1) * sizePerPage + 1;	//1페이지에 게시판 시작번호 1번 , 2페이지에 게시판 시작번호 11번
		
		//이전 버튼 상태
		this.prev = range ==1 ? false : true;	//range ==1 이면 이전페이지 없는거 false (현재페이지가 1이면 이전페이지가 없는거니까) 
		
		//다음 버튼 상태
		this.next = endPage >= pageCnt ? false : true;	//전체 페이지 개수가 endPage 페이지 끝 번호랑 같거나 크면 다음페이지가 없는거 false (현재페이지가 11이면 다음페이지가 없는거니까)
		if(this.endPage > this.pageCnt) {				//endPage가 pageCnt보다 크면 15(페이지끝번호)>11(전체페이지개수) 보다 크면
			this.endPage = this.pageCnt;				//endPage에 pageCnt 를 대입한다 결국 페이지 끝번호는 11이 되는것임
			this.next = false;							//다음페이지 여부는 false (어차피 페이지 끝번호가 11이니까 다음페이지는 없음)
		}
			
	}	
	
}
