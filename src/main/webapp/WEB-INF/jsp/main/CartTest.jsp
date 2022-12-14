<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>
	tk 메인 화면

	<p>${cartList[0].itemPriceStr}</p>
	<p>${cartList}</p>

	<button id="btn" type="button">겟리스트</button>
</body>
<script>
	
	$("#btn").on("click", function(){
		$.ajax({
			url:"/cart/list",
			type: "get",
			date: {1},
			success: function(result){
				console.log(typeof(result))
			},
			error: function(e){
				console.log(e)
			}
		})
	})
	
 
	console.log(typeof(${cartList}))
</script>
</html>
