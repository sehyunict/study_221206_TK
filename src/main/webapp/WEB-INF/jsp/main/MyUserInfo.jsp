<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
	<h2>회원정보</h2>
	<div class="Mypage_left">
		
			<a href="#">예매내역</a><br>
			<a href="#">장바구니</a><br>
			<a href="#">리뷰관리</a><br>
			<a href="#">질문관리</a><br>
			<a href="MyUserInfo">회원정보</a>
			
			<table>
				<tr>
					<th>이름</th>
					<th>이메일</th>
					<th>핸드폰번호</th>
				</tr>
				<tr>
					<td>${UserInfo.user_name}</td>
					<td>${UserInfo.user_email}</td>
					<td>${UserInfo.user_phone}</td>
				</tr>
				
			</table>
		
	</div>
</body>
</html>