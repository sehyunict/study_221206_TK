<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
	<h2>내가 쓴 리뷰</h2>
	<div class="Mypage_left">
		
			<a href="#">예매내역</a><br>
			<a href="#">장바구니</a><br>
			<a href="MyReview.do">리뷰관리</a><br>
			<a href="#">질문관리</a><br>
			<a href="MyUserInfo.do">회원정보</a>
			
			<c:if test="${empty MyReviewList}">
				<p>작성한 리뷰가 없습니다.</p>
			</c:if>
			<c:if test="${not empty MyReviewList}">
				
					<table class="Mypage_table">
					
						<tr>
							<th>이름</th>
							<th>작품</th>
							<th>제목</th>
							<th>내용</th>
							<th>평점</th>
						</tr>
					<c:forEach items="${MyReviewList}" var="RList"></c:forEach>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
				
					</table>
				
			</c:if>
	</div>
</body>
</html>