<%@page import="java.sql.Date"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../header.jsp"/>

	<section class="memberListSection">
			<h2 align="center">연극</h2>
			<table border="1">
				<tr>
					<td><a href="/item/itemDetail"><img class="itemCssList" id="theater_1" src="../resources/image/theater_1.jpg"></a></td>
					<td><a href=""><img class="itemCssList" id="theater_1" src="../resources/image/theater_1.jpg"></a></td>
					<td><a href=""><img class="itemCssList" id="theater_1" src="../resources/image/theater_1.jpg"></a></td>
					<td><a href=""><img class="itemCssList" id="theater_1" src="../resources/image/theater_1.jpg"></a></td>
					<td><a href=""><img class="itemCssList" id="theater_1" src="../resources/image/theater_1.jpg"></a></td>
				</tr>
				<tr>
					<td><a href=""><img class="itemCssList" id="theater_1" src="../resources/image/theater_1.jpg"></a></td>
					<td><a href=""><img class="itemCssList" id="theater_1" src="../resources/image/theater_1.jpg"></a></td>
					<td><a href=""><img class="itemCssList" id="theater_1" src="../resources/image/theater_1.jpg"></a></td>
					<td><a href=""><img class="itemCssList" id="theater_1" src="../resources/image/theater_1.jpg"></a></td>
					<td><a href=""><img class="itemCssList" id="theater_1" src="../resources/image/theater_1.jpg"></a></td>
					<td rowspan="2">선호장르 추천</td>
					<td rowspan="2">
						<img class="recommendItem" src="../resources/image/theater_1.jpg">
						<img class="recommendItem" src="../resources/image/theater_1.jpg">
					</td>
				</tr>
 				<tr>
					<td><a href=""><img class="itemCssList" id="theater_1" src="../resources/image/theater_1.jpg"></a></td>
					<td><a href=""><img class="itemCssList" id="theater_1" src="../resources/image/theater_1.jpg"></a></td>
					<td><a href=""><img class="itemCssList" id="theater_1" src="../resources/image/theater_1.jpg"></a></td>
					<td><a href=""><img class="itemCssList" id="theater_1" src="../resources/image/theater_1.jpg"></a></td>
					<td><a href=""><img class="itemCssList" id="theater_1" src="../resources/image/theater_1.jpg"></a></td>
					<td><a href=""><img class="itemCssList" id="theater_1" src="../resources/image/theater_1.jpg"></a></td>
				</tr> 
				
			</table>
				
	</section>

<jsp:include page="../footer.jsp"/>

