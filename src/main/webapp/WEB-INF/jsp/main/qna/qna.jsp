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
	display: flex;
	justify-content: space-between;
	border-bottom: 1px solid gray;
	padding: 5px;
}
</style>
</head>
<body>

	<header>
		<h2>QNA 게시판</h2>
	</header>
	<button id="getListBtn" type="button">리스트 목록</button>
	<div id="qnaListBox">

		<ul>
			<li>No</li>
			<li>TITLE</li>
			<li>USER</li>
		</ul>



	</div>
</body>

<script>
	$("#getListBtn").on("click", function() {

		$.ajax({
			url : "/qna/list", //요청할 url (리스트 뽑을거니까 /qna/list)
			type : "GET", //list 가져올거니까 get 타입으로 가져오겠다
			dataType : "json", //서버에서 반환되는 데이터형식 json 
			success : function(data) {
				console.log(data)
				for (let i = 0; i < 10; i++) {
					$("#qnaListBox").append(
					`
					<ul>
						<li>\${i+1}</li>
						<li><a href="/qna/\${data[i].qnaId}">\${data[i].title}</a></li>	
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
