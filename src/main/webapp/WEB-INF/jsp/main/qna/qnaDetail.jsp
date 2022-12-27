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
</style>
</head>
<body>

	<header>
		<h2>QNA 조회</h2>
	</header>
	<div id="qnaSelectBox">
		<ul>
			<li>TITLE : ${qnaVo.title}</li>
			<li>CONTENT : ${qnaVo.content}</li>
			<li>USER : ${qnaVo.userName}</li>
			<li>DATE : ${qnaVo.createdAtStr}</li>
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
