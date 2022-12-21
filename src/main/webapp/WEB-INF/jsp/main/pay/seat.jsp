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

#priceBox {
	position: relative;
}
</style>
</head>

<body>
	<div id="centerBox">
		<table id="seatTable">
			<%-- 
			<c:forEach var="payVo" items="${mm}">
				<c:if test="${(payVo.seatId%10) == 1}">
					<tr>
				</c:if>
				<td class="seat" name="${payVo.seatId}">"${payVo.seatName}"</td>

				<c:if test="${(payVo.seatId%10) == 1}">
					</tr>
				</c:if>
			</c:forEach> --%>
		</table>
	</div>
	<form id="priceForm" action="/pay/save" method="POST">
		<div id="priceBox"
			style="border: 1px solid black; width: 300px; height: 500px; margin-left: 600px; position: relative;">
			<div id="pickSeats">
				<h4>선택한 좌석</h4>
			</div>
			<div style="position: absolute; bottom: 60px; left: 30px">
				<input type="radio" id="card" name="methodId" value="14"><label for="card">카드</label>
				<input type="radio" id="phone" name="methodId" value="15"><label for="phone">휴대폰</label>
				<input type="radio" id="account" name="methodId" value="16"><label for="account">무통장입금</label>
			</div>

			<p style="position: absolute; bottom: 20px; left:50px;">
				<input id="totalPrice" name="totalprice" readonly="readonly" style="border:none; width:50px;">원
			</p>

			<button id="doPayBtn" type="button"
				style="position: absolute; bottom: 10px; padding: 10px; right: 10px;">결제하기</button>
		</div>
		
	</form>
</body>

<script>

onload=function(){
	$.ajax({
		url: "/pay/seats/"+${timetableId},
		type: "GET",
		dataType: "json",
		success: function(data){
			$("#priceForm").append(`
					<input type="hidden" name="timetableId" value="\${data.seats[0].timetableId}">
					`)
			for(let obj of data.seats){
				if(obj.seatId%10==1){
					$("#seatTable").append("<tr>")
				}
				$("#seatTable").append(
						`
						<td class="seat" data-val="\${obj.seatId}" data-valid="\${obj.timetableId=="" ? true : false}" style="\${obj.timetableId == "" ? '' : 'background: gray'}">
						\${obj.seatName}
						</td>
						`)
				if(obj.seatId%10==0){
					$("#seatTable").append("</tr>")
				}
			}
		},
		error: function(e, t) {
			alert(e+"/"+t)
		}
	})
}

$("body").on("click", function(e){
	if(e.target.nodeName=="TD"){
		if(e.target.dataset.valid == "false"){
			alert("이미 예약된 좌석입니다.")
			return
		}
		$(e.target).toggleClass("back-yellow")
		if($(e.target).hasClass("back-yellow")){
			console.log("val:"+$("#totalPrice").val())
			$("#pickSeats").append(
					`
					<p name="pickSeat" data-val="\${$(e.target).data('val')}">\${$(e.target).text()} </p>
					<input type="hidden" name="seatIds" value="\${$(e.target).data('val')}" >
					
					`)
			$("#totalPrice").val(Number($("#totalPrice").val())+10000);
			
		}else{
			for(let obj of \$("#priceBox").children()){
				console.log(obj.value)
			}
		}
	}
	e.stopPropagation();
})

$("#doPayBtn").on("click",function(){
	let arr = $("input[name=seatIds]")
	let ids=[]
	for(let obj of arr){
		ids.push(obj.value)
	}
	
	$("#seatIds").val(ids.toString())
	
	let formValues = $("#priceForm").serialize();
	
	
	$.ajax({
		url:"/pay",
		dataType: "json",
		type:"POST",
		data: formValues,
		success: function(data){
			console.log("seccess")
		},
		error: function(e, t) {
			alert(e+" / "+t)
		}
		
	})
	
	
})

	
</script>
</html>
