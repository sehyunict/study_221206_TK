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
}

table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
#seatTable{
	margin-top: 100px;
	margin-left: 100px;
}
</style>
</head>

<body>
	<div id="centerBox">
		<table id="seatTable">
			<tr>
				<td>dd</td>

				<td>dd</td>
			</tr>

			<c:forEach var="payVo" items="${mm}">
				<c:if test="${(payVo.seatId%10) == 1}">
					<tr>
				</c:if>
				<td class="seat" name="${payVo.seatId}">"${payVo.seatName}"</td>

				<c:if test="${(payVo.seatId%10) == 1}">
					</tr>
				</c:if>
			</c:forEach>
		</table>
	</div>

</body>

<script>
	
</script>
</html>
