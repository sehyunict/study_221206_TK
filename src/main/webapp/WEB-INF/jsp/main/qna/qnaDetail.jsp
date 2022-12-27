<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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
.contentSt{
	display: inline-block;
	width: 300px;
	border:1px solid gray;
	margin:5px;
	padding:10px;
}
</style>
</head>
<body>
<jsp:include page="../header.jsp"/>
	<header>
		<h2>QNA 조회</h2>
	</header>
	<div id="qnaSelectBox">
		<ul>
			<li><span>TITLE</span>  <div class="contentSt"> ${qnaVo.title}</div></li>
			<li><span>CONTENT</span> <div class="contentSt">${qnaVo.content}</div> </li>
			<li><span>USER</span> <div class="contentSt">${qnaVo.userName}</div></li>
			<li><span>DATE</span>  <div class="contentSt">${qnaVo.createdAtStr}</div></li>
		</ul>
		<c:if test="${userId == qnaVo.userId }">
			<button>
				<a href="/qna/qnaModify/${qnaVo.qnaId}">수정</a>
			</button>
			<button>
				<a href="/qna/remove/${qnaVo.qnaId}">삭제</a>
			</button>
		</c:if>

	</div>


</body>

<script>
	
</script>
</html>
