<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<style>
	table, th, td{
		border: 1px solid;
		text-align: center;
		border-collapse: collapse;
		padding: 5px;
		margin: 10px;
		
	}
</style>
</head>
<body>
	<h2>회원정보</h2>
	<div class="Mypage_left">
		
			<a href="#">예매내역</a><br>
			<a href="#">장바구니</a><br>
			<a href="#">리뷰관리</a><br>
			<a href="#">질문관리</a><br>
			<a href="MyUserInfo">회원정보</a>
			
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
		
	</div>
</body>
</html>