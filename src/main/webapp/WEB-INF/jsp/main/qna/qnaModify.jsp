<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
}

li {
}

span {
	display: inline-block;
	width: 100px;
	text-align: left;
}

body {
	text-align: center
}

input {
	font-size: 20px;
	width: 400px;
	padding: 10px;
}

textarea {
	font-size: 20px;
	width: 400px;
	height: 200px;
	resize: none;
	padding: 10px;
}

button {
	padding: 10px 20px;
	margin-top: 20px;
}
</style>
</head>
<body>
<jsp:include page="../header.jsp"/>
<input id="flag" type="hidden" value="${flag}">
	<header>
		<h2>QNA 수정</h2>
	</header>
	<div id="qnaModifyBox">
		<form action="/qna/modify" method="post">	<!-- controller의 @postMapping(/qna/modify) 경로 -->
			<input type="hidden" name="qnaId" value="${qnaVo.qnaId}">	
			<ul>
				<li><span>TITLE</span> <input name="title" value="${qnaVo.title}"></li>
				<li><span>CONTENT</span> <textarea name="content"> ${qnaVo.content}</textarea></li>
				<li><span>USER</span> <input name="userName" value="${qnaVo.userName}" disabled="disabled" style="border:none"></li>
			</ul>
			<button type="submit">수정완료</button>
		</form>

	</div>


</body>

<script>
onload= function(){
	let flag = $('#flag').val();
	if(flag=="false") alert("저장 실패")
}
</script>
</html>
