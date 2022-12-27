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
		<h2>QNA 수정</h2>
	</header>
	<div id="qnaModifyBox">
		<form action="/qna/modify" method="post">	<!-- controller의 @postMapping(/qna/modify) 경로 -->
			<input type="hidden" name="qnaId" value="${qnaVo.qnaId}">	
			<ul>
				<li>TITLE :<input name="title" value="${qnaVo.title}"></li>
				<li>CONTENT :<input name="content" value="${qnaVo.content}"></li>
				<li>USER :<input name="userName" value="${qnaVo.userName}" readonly="readonly" style="border:none"></li>
			</ul>
			<button type="submit">수정완료</button>
		</form>

	</div>


</body>

<script>
	
</script>
</html>