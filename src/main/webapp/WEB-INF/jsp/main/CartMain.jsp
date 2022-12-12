<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	TK 메인 화면
	
	<form action="/cart" method="post">
		<input type="text" name="userId" value="1">
		<input type="text" name="timetableId" value="47">
		<input type="text" name="seatId" value="7">
		<button>장바구니 저장</button>
	</form>
	
	<form action="/cart" method="post">
	<input type="hidden" name="_method" value="DELETE">
		<input type="text" name="userId" value="1">
		<input type="text" name="timetableId" value="47">
		<input type="text" name="seatId" value="7">
	
	<button>장바구니 삭제</button>
	</form>
	

</body>
</html>