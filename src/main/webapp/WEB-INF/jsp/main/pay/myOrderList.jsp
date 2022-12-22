<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예매</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<style type="text/css">
body {
	text-align: center;
}

* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
	letter-spacing: 2px;
	word-spacing: 3px;
	font-family: "Noto Sans KR", sans-serif;
}

li {
	list-style: none;
	padding: 10px 30px;
	width: 100%;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

td {
	padding: 10px
}

#seatTable {
	margin-top: 100px;
	margin-left: 100px;
}

.back-yellow {
	background: yellow;
}

ul {
	display: flex
}
img{
width:150px;
height:100px;
}
</style>
</head>

<body>
	<div id="centerBox">
		<ul>
			<li>No</li>
			<li>결제날짜</li>
			<li>상품 이미지</li>
			<li>상품명</li>
			<li>관람일</li>
			<li>좌석명</li>
			<li>금액</li>
		</ul>
		<c:forEach var="payVo" items="${payList}" varStatus="status">
			<ul>
				<li>${page.curPostNum + status.count-1}</li>
				<li>${payVo.payDateStr}</li>
				<li><img alt="" src="../${payVo.imagePath}"></li>
				<li>${payVo.itemTitle==null?"현재는 판매가 중지된 상품입니다":payVo.itemTitle}</li>
				<li>${payVo.startTimeStr}-${payVo.endTimeStr}</li>
				<li>${payVo.seatName}</li>
				<li>${payVo.itemPriceStr}원</li>
			</ul>
		</c:forEach>

		<c:forEach var="i" begin="1" end="${page.totalPageNum}">
			<a>${i}</a>
		</c:forEach>
	</div>
</body>
</html>
