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
	display: block;
}

#cartListBox li ul {
	display: flex;
	border-bottom: 1px solid gray;
}

#cartListBox li ul li {
	width: 100%
}

.cartCheckbox {
	width: 20px;
	height: 20px;
}

.btnSt {
	padding: 10px 20px;
}
</style>
</head>

<body>
	<div id="centerBox">
		<h1>${msg}</h1>
		<h3>장바구니</h3>
		<ul id="cartListBox">
			<li>
				<ul>
					<li style="width: 10px"><input class="cartCheckbox"
						type="checkbox" value="7"></li>
					<li>No</li>
					<li>사진</li>
					<li>작품명</li>
					<li>관람일</li>
					<li>좌석</li>
					<li>가격</li>
				</ul>
			</li>
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
		success: function(data){
			if(data.status){
				for (let i = 0; i < data.result.length; i++) {
					$("#cartListBox").append(
					`
					 <li>
						<ul>
							<li style="width: 10px"><input class="cartCheckbox" name="cartCheckbox" type="checkbox" value="\${data.result[i].cartId}"></li>
							<li>\${data.result[i].no} </li>
							<li>\${data.result[i].imgPath}</li>
							<li>\${data.result[i].itemTitle}</li>
							<li>\${data.result[i].startTimeStr}-\${data.result[i].endTimeStr}</li>
							<li>\${data.result[i].seatName}</li>
							<li>\${data.result[i].itemPriceStr}원</li>
						</ul>
					</li>
					`
					)
				}
			
			}else{
				console.log(data.msg)
				if(data.msg=="세션만료") alert("다시 로그인하세요")
			}
		},
		error: function(e, t){
			console.log(e+" / "+t);
		}
	})
	
}
$("#deleteBtn").on("click",function(){
	let objArr = $("input[name=cartCheckbox]:checked");
	let ids = [];
	for(let obj of objArr){
		ids.push(obj.value);
	}

	$.ajax({
		url: `/cart?ids=\${ids.toString()}`,
		type: "delete",
		dataType: "json", 
		success: function(data){
			if(data.status){
				console.log(data.msg)
				for(let obj of objArr){
					obj.remove()
				}
			}else{
				console.log(data.msg)
				if(data.msg=="세션만료") alert("다시 로그인 하세요")
			}
		},
		error: function(e,t) {
			console.log(e+" / "+t)
		}
	})
	
})

</script>
</html>
