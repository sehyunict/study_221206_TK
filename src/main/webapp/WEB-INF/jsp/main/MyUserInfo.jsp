<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<style>
	.Mypage_left , .Mypage_section{
		display: inline;
		margin-top : 20px;
		text-align:center;
	}
	


	th,td{
		border-right: 1px solid grey;
		text-align: center;
		border-collapse: collapse;
		border-spacing:none;
		padding: 10px;
		margin: 10px;
		border-bottom: 1px solid grey;
	}
	
	th{
		background-color: lightgrey;
	}
	
	table{
		border-top:1px solid grey;
		border-left:1px solid grey;
		border-spacing: 0px;
		width: 800px;
	
	}
	
	a{
		font-size:20px;
		color:black;
	}
</style>
</head>
<body>
	<h2>회원정보</h2>
	<hr>
	<div class="Mypage_left">
		
			<a href="#">예매내역</a>
			<a href="#">장바구니</a>
			<a href="#">리뷰관리</a>
			<a href="#">질문관리</a>
			<a href="MyUserInfo.do">회원정보</a>
	</div>

	<section>
			<table class="Mypage_table">
				<tr>
					<th>이름</th>
					<th>이메일</th>
					<th>핸드폰번호</th>
				</tr>
				<tr>
					<td>${user.user_name}</td>
					<td>${user.user_email}</td>
					<td>${user.user_phone}</td>
				</tr>
				<tr>
					<td colspan="3" ><input type="button" value="회원정보 수정하기"></td>
				</tr>
				
			</table>
	</section>
</body>
</html>