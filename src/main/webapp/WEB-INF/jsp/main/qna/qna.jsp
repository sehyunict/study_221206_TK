<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QNA</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<style type="text/css">
ul {
	list-style: none;
	width: 100%;
	height: 100%;
	display: flex;
	justify-content: space-between;
	border-bottom: 1px solid gray;
	padding: 5px;
}

.titleSt {
	text-align: left;
}
button{
padding:10px;
}
input{
padding:10px;
font-size: 18px;
}

</style>
</head>
<body>
	<jsp:include page="../header.jsp" />

	<header>
		<h2>QNA 게시판</h2>
	</header>
	<button id="getListBtn" type="button">목록</button>
	<button>
		<a href="/qna/qnaContent">글쓰기</a>
	</button>

	<ul>
		<li>No</li>
		<li>TITLE</li>
		<li>USER</li>
	</ul>

	<div id="qnaListBox">
		<c:forEach var="qnaVo" items="${ list }" varStatus="status">
			<!-- jstl -> jsp에서 반복처리 할수있는 기능 -->
			<ul>
				<li>${ status.count }</li>
				<li><a href="/qna/${ qnaVo.qnaId }">${ qnaVo.title } </a></li>
				<li>${ qnaVo.userName }</li>
			</ul>


		</c:forEach>
	</div>


	<form action="/qna/" method="get">
		<div class="search">
			<input name="keyWord" type="text" placeHolder="검색어를 입력해주세요"
				id="keyWord"></input>
			<button type="button" id="searchBtn">검색하기</button>
		</div>
	</form>
</body>


<script>
	

	$("#searchBtn").click(function(){
		let input = $("input[name=keyWord]").val()
		location.href="/qna/search?kw="+input+""	//kw -> key값 input-> value값 controller에 있는 @RequestParam("kw")랑 같음
	})
		
		

	$("#getListBtn").on("click", function() {

		$.ajax({
			url : "/qna/list", //url (리스트 뽑을거니까 /qna/list)
			type : "GET", //(type:요청하는타입)get요청을 하겠다 
			dataType : "json", //서버에서 반환되는 데이터형식 json  (받을때 json)
			success : function(data) {	//data = qnaList
				$("#qnaListBox").children().remove();	
				console.log(data)
				for (let i = 0; i < 10; i++) {	//일단 10개만 보여주려고
					$("#qnaListBox").append(	//qnaListBox 밑으로 덧붙여라			
					`
					<ul>
						<li>\${i+1}</li>	
						<li><a class="titleSt" href="/qna/\${data[i].qnaId}">\${data[i].title}</a></li>	
						<li>\${data[i].userName}</li>	
					</ul>
					`	
					)
					
				}
			},
			error: function(e, t) {
				console.log(e+" / "+t)
			}
		})
	})
</script>
</html>
