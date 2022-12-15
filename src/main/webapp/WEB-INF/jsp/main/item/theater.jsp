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
					<td><a href="/item/itemDetail"><img class="itemCssList" id="theater_1" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="theater_2" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="theater_3" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="theater_4" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="theater_5" src=""></a></td>
				</tr>
				<tr>
					<td><a href=""><img class="itemCssList" id="theater_6" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="theater_7" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="theater_8" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="theater_9" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="theater_10" src=""></a></td>
					<td rowspan="2">선호장르 추천</td>
					<td rowspan="2">
						<img class="recommendItem" src="">
						<img class="recommendItem" src="">
					</td>
				</tr>
 				<tr>
					<td><a href=""><img class="itemCssList" id="theater_11" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="theater_12" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="theater_13" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="theater_14" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="theater_15" src=""></a></td>
				</tr> 
			</table>
	</section>

<jsp:include page="../footer.jsp"/>

