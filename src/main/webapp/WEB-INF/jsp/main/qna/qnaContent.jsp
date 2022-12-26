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
</style>
</head>
<body>

	<header>
		<h2>QNA 작성</h2>
	</header>

	<form id="qnaSaveForm" method="post" action="/qna">
		<div id="qnaSelectBox">
			<ul>

				<li>TITLE <input type="text" name="title"></li>
				<li>CONTENT <input type="text" name="content"></li>
				<li>USER </li>

			</ul>
		</div>
		<button id="qnaSaveBtn">저장</button>
	</form>

</body>

<script>
	//ajax 굳이 필요없을거같아서 삭제
	/* $("#qnaSaveBtn").on("click", function() {

		let formValues = $("#qnaSaveForm").serialize()

		$.ajax({
			url : "/qna",
			type : "post",
			data : formValues,
			dataType : "json",
			success : function(data) {
				location.href = "/qna"
				
			},
			error: function(e){
				alert(e)
			}
		
		})

	}) */
</script>
</html>
