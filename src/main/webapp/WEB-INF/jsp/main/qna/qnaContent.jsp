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
	text-align: center;
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
	justify-content: center;
}
</style>
</head>
<body>
<input id="flag" type="hidden" value="${flag}">
	<jsp:include page="../header.jsp" />
	<header>
		<h2>QNA 작성</h2>
	</header>

	<form id="qnaSaveForm" method="post" action="/qna">
		<div id="qnaSelectBox">
			<ul>
				<li><span>TITLE</span> <input type="text" name="title"></li>
				<li><span>CONTENT</span> <textarea name="content"></textarea></li>
				<!-- <li><span>USER</span></li> -->

			</ul>
		</div>
		<button id="qnaSaveBtn">저장</button>
	</form>
</body>

<script>
onload= function(){
	let flag = $('#flag').val();
	if(flag=="false") alert("저장 실패")
}
	
</script>
</html>
