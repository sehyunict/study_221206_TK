<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
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

#centerBox {
	
	text-align: center;
}

#cartListBox {

	display:block;
}

#cartListBox li ul{
display: flex;
border-bottom: 1px solid gray;
}
#cartListBox li ul li{
width: 100%
}
.cartCheckbox{
width:20px;
height:20px;
}
.btnSt{
padding: 10px 20px;
}
</style>
</head>

<body>

	<div id="centerBox">
		<h3>장바구니</h3>
		<ul id="cartListBox">
		</ul>
		<button class="btnSt" id="payBtn">결제</button>
		<button class="btnSt" id="deleteBtn">삭제</button>
	</div>
	 

	<div style="padding: 50px 0"></div>
	<form action="/cart" method="post">
		<input type="text" name="userId" value="1"> <input type="text"
			name="timetableId" value="48"> <input type="text"
			name="seatId" value="9">
		<button>장바구니 저장</button>
	</form>

	<form action="/cart" method="post">
		<input type="hidden" name="_method" value="DELETE"> <input
			type="text" name="userId" value="1"> <input type="text"
			name="timetableId" value="47"> <input type="text"
			name="seatId" value="7">

		<button>장바구니 삭제</button>
	</form>


</body>

<script>
onload= function(){
	$.ajax({
		url:"/cart/list",
		type: "GET",
		dataType: "json",
		success: function(res){
			//console.log(typeof(res)+"/"+res.length)
			console.log(res[0].itemTitle)
			$("#cartListBox").append(
				`
				<li>
					<ul>
						<li style="width: 10px"><input class="cartCheckbox" type="checkbox"></li>
						<li>No</li>
						<li>사진</li>
						<li>작품명</li>
						<li>관람일</li>
						<li>좌석</li>
						<li>가격</li>
					</ul>
				</li>
				`
			)
			
			for (let i = 0; i < res.length; i++) {
				$("#cartListBox").append(
				`
				 <li>
					<ul>
						<li style="width: 10px"><input class="cartCheckbox" name="cartCheckbox" type="checkbox" value="\${res[i].cartId}"></li>
						<li>\${res[i].no} </li>
						<li>\${res[i].imgPath}</li>
						<li>\${res[0].itemTitle}</li>
						<li>\${res[0].startTimeStr}-\${res[i].endTimeStr}</li>
						<li>\${res[i].seatName}</li>
						<li>\${res[i].itemPriceStr}원</li>
					</ul>
				</li>
				`
				)
			}
		},
		error: function(e){
			console.log("list : "+e);
		}
	})
	
	$("#deleteBtn").on("click",function(){
		let arr = $("input[name=cartCheckbox]:checked");
		
		console.log(arr[0].value)
		
		$("input[name=cartCheckbox]:checked").each(function(){
		})
	})
}


</script>
</html>
