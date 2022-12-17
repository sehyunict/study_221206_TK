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
		<button class="btnSt" id="payBtn" type="button">결제</button>
		<button class="btnSt" id="deleteBtn" type="button">삭제</button>
	</div>


	<div style="padding: 50px 0"></div>
	<form id="cartSaveForm">
		<input type="text" name="userId" value="55"
			placeholder="유저 고유 아이디 1~100"> <input type="text"
			name="timetableId" placeholder="타임테이블 47~91"> <input
			type="text" name="seatId" placeholder="좌석 아이디 1~30">
		<button type="button" id="cartSaveBtn">장바구니 저장</button>
	</form>

	<!-- 	<form action="/cart" method="post">
		<input type="hidden" name="_method" value="DELETE"> <input
			type="text" name="userId" value="1"> <input type="text"
			name="timetableId" value="47"> <input type="text"
			name="seatId" value="7">

		<button>장바구니 삭제</button>
	</form>
 -->

</body>

<script>
$("#payBtn").on("click", function(){
	let objArr = $("input[name=cartCheckbox]:checked");
	let timetableId;
	let set = new Set();
	
	if(objArr.length == 0){
		alert("선택된 항목이 없습니다")
		return
	}
	
	for(let obj of objArr){
		timetableId = obj.dataset.timetableid
		set.add(timetableId)
	}
	
	if(set.size!=1){
		alert("같이 결제하려는 작품은 하나여야합니다")
		return
	}
	
	 location.href="/pay/"+timetableId;
})

onload= function getList(){
	$.ajax({
		url:"/cart/list",
		type: "GET",
		dataType: "json",
		success: function(data){
			if(data.status){
				for (let i = 0; i < data.result.length; i++) {
					$("#cartListBox").append(
					`
					 <li name="cartList">
						<ul>
							<li style="width: 10px"><input class="cartCheckbox" name="cartCheckbox" type="checkbox" value="\${data.result[i].cartId}" data-timetableid="\${data.result[i].timetableId}"></li>
							<li>\${data.result[i].no} </li>
							<li>\${data.result[i].imgPath}</li>
							<li>\${data.result[i].timetableId} -- \${data.result[i].itemTitle==null?"현재는 판매가 중지된 상품입니다":data.result[i].itemTitle}</li>
							<li>\${data.result[i].startTimeStr}-\${data.result[i].endTimeStr}</li>
							<li>\${data.result[i].seatName}</li>
							<li>\${data.result[i].itemPriceStr}원</li>
						</ul>
					</li>
					`
					)
				}
			}else{
				alert(data.msg)
			}
		},
		error: function(e, t){
			console.log(e+" / "+t);
		}
	})
	$("#deleteBtn").on("click",function(){
	let objArr = $("input[name=cartCheckbox]:checked");
	if(objArr.length == 0){
		alert("선택된 항목이 없습니다")
		return
	}
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
				$("li[name=cartList]").remove()
				
				/* for(let obj of objArr){
					obj.parentNode.parentNode.remove()
				} 
				location.href="/cart" */
				getList()
			}else{
				alert(data.msg)
			}
		},
		error: function(e,t) {
			console.log(e+" / "+t)
		}
	})
	
})

$("#cartSaveBtn").on("click", function(){
	
	let formValues = $("#cartSaveForm").serialize()
	
	$.ajax({
		url: "/cart",
		type: "post",
		data: formValues,
		dataType: "json",
		success: function (data) {
			if(data.status){
				alert("장바구니에 잘 담겼습니다")
				location.href="/cart"
			}else{
				alert(data.msg)
			}
		}
	})
})
	
}


</script>
</html>
