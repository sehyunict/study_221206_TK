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

</body>

<script>

onload=function(){
	$.ajax({
		url: "/pay/seats/"+${timetableId},
		type: "GET",
		dataType: "json",
		success: function(data){
			for(let obj of data.seats){
				if(obj.seatId%10==1){
					$("#seatTable").append("<tr>")
				}
				$("#seatTable").append(
						`
						<td class="seat" value="\${obj.seatId}" data-valid="\${obj.timetableId=="" ? true : false}" style="\${obj.timetableId == "" ? '' : 'background: gray'}">
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
	console.log("e "+e.target.nodeName)
	if(e.target.nodeName=="TD"){
		console.log(e.target.dataset.valid)
		if(e.target.dataset.valid == "false"){
			alert("이미 예약된 좌석입니다.")
			return
		}
		$(e.target).css("background-color", "yellow")
	}
	e.stopPropagation();
})
	

	
</script>
</html>
