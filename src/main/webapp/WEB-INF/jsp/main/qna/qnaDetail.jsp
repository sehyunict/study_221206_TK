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

</style>
</head>
<body>

	<header>
		<h2>QNA 조회</h2>
	</header>
	<div id="qnaSelectBox">
		<ul>
			<li>No</li>
			<li>TITLE : ${qnaVo.title} </li>
			<li>CONTENT : <span> ${qnaVo.content} </span></li>
			<li>USER : <span> ${qnaVo.userName} </span></li>
			<li>DATE : ${qnaVo.createdAtStr} </li>
		</ul>
		<button><a href="/qna/qnaModify/${qnaVo.qnaId}">수정</a></button>
		<button><a href="/qna/remove/${qnaVo.qnaId}">삭제</a></button>
	</div>
	
	
</body>

<script>
	
</script>
</html>
