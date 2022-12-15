<%@page import="java.sql.Date"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<c:forEach var="member" items="${memberList}">
	<tr>
		<td><a href="/member/modify?id=${member.id}">${member.id}</td>
		<td>${member.name}</td>
		<td>${member.dept}</td>
		<td>${member.duty}</td>
		<td>${member.phone}</td>
		<td>${member.role}</td>
		<td><a href="/remove?id=${member.id}">삭제</a></td>
	</tr>
</c:forEach>


<jsp:include page="../header.jsp"/>

	<section class="memberListSection">
			<h2 align="center">전시회</h2>
			<table border="1"> 
				<tr>
					<td><a href="/item/itemDetail"><img class="itemCssList" id="exhibition_1" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="exhibition_2" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="exhibition_3" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="exhibition_4" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="exhibition_5" src=""></a></td>
				</tr>
				<tr>
					<td><a href=""><img class="itemCssList" id="exhibition_6" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="exhibition_7" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="exhibition_8" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="exhibition_9" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="exhibition_10" src=""></a></td>
					<td rowspan="2">선호장르 추천</td>
					<td rowspan="2">
						<img class="recommendItem" src="">
						<img class="recommendItem" src="">
					</td>
				</tr>
 				<tr>
					<td><a href=""><img class="itemCssList" id="exhibition_11" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="exhibition_12" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="exhibition_13" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="exhibition_14" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="exhibition_15" src=""></a></td>
				</tr> 
				
			</table>
	</section>
<jsp:include page="../footer.jsp"/>
	