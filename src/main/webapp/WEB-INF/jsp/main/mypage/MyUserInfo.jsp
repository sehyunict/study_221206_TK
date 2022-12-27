<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>


<title>마이페이지</title>
<style>
	.Mypage_left , .Mypage_section{
		display: inline;
		margin-top : 20px;
		text-align:center;
	}
	


	td{
		border-right: 1px solid grey;
		text-align: center;
		border-collapse: collapse;
		border-spacing:none;
		padding: 10px;
		margin: 10px;
		border-bottom: 1px solid grey;
	}
	
	input{
		width:300px;
	}
	
	.cell{
		background-color: lightgrey;
		width: 130px;
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
<jsp:include page="../header.jsp"/>
	<h2>회원정보</h2>
	
	<div class="Mypage_left">
		
			<a href="#">예매내역</a>
			<a href="#">장바구니</a>
			<a href="MyReview.do">리뷰관리</a>
			<a href="#">질문관리</a>
			<a href="MyUserInfo.do">회원정보</a>
	</div>
	<hr>
	<section>
		
			<table class="Mypage_table">	
				<tr>
					<td class="cell">이름</td>
					<td>${user.userName}</td>
				</tr>
				<tr>
					<td class="cell">이메일</td>
					<td>${user.userEmail}</td>
				</tr>
				<tr>
					<td class="cell">핸드폰번호</td>
					<td>${user.userPhone}</td>
				</tr>
				<tr>
					<td colspan="4" >
					<a href="MyUserInfoUpdate.do">
						<button id="updateBtn"> 회원정보 수정하기 </button></a>
					</td>
				</tr>
			</table>

	</section>
</body>

</html>