<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
		width: 90%;
	
	}
	
	a{
		font-size:20px;
		color:black;
	}
</style>
</head>
<body>
	<h2>나의 문의사항</h2>
	
	<div class="Mypage_left">
		
			<a href="#">예매내역</a>
			<a href="#">장바구니</a>
			<a href="MyReview.do">리뷰관리</a>
			<a href="MyQna.do">문의사항</a>
			<a href="MyUserInfo.do">회원정보</a>
	</div>
	<hr>		
	<section class="Mypage_section">
			<c:if test="${empty myReviewList}">
				<p>작성한 문의사항이 없습니다.</p>
			</c:if>
			<c:if test="${not empty myReviewList}">
				
					<table class="Mypage_table">
					
						<tr>
							<th>제목</th>
							<th>내용</th>
							<th>수정/삭제</th>
						</tr>
					<c:forEach items="${myReviewList}" var="RList">
						<tr>
							<td>${RList.userName}</td>
							<td>${RList.title}</td>
							<td>${RList.content}</td>
							<td>
								<button>수정</button><button>삭제</button>
							</td>
						
						</tr>
					</c:forEach>
				
					</table>
				</c:if>
	</section>
</body>
</html>