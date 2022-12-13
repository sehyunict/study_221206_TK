<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	tk 메인 화면
	
		<p> ${cartList[0].itemPriceStr} </p>

		<p> ${cartList} </p>

</body>
</html>
<script>

	console.log(typeof(${cartList}))
</script>