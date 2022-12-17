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
		<h2>작성글</h2>
	</header>
	<div id="qnaSelectBox">
		<ul>
			<li>No</li>
			<li>TITLE</li>
			<li>CONTENT</li>
			<li>USER</li>
			<li>DATE</li>
		</ul>
		<button id="updateBtn">수정</button>
		<button id="deleteBtn">삭제</button>
	</div>
	<form id="qnaSaveForm">
		<input type="text" name="userId" value="55">
		<input type="text" name="qnaId">
		<input type="text" name="title">
		<input type="text" name="content">
		<button type="button" id="qnaSaveBtn">저장</button>
	</form>
	
</body>

<script>
$("#qnaSaveBtn").on("click", function(){
	
	let formValues = $("#qnaSaveForm").serialize()
	
	$.ajax({
		url : "/qna",
		type : "post",
		data : formValues,
		dataType : "json",
		success : function (data){
			if(data.status){
				alert("qna 저장되었습니다")
				location.href = "/qna"
			}else{
				alert(data.msg)
			}
		}
	})
	
})	
</script>
</html>
