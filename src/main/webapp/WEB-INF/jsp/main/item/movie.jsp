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
			<h2 align="center">영화</h2>
			<table border="1">
				<tr>
					<td><a href="/item/itemDetail"><img class="itemCssList" id="movie_1" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="movie_2" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="movie_3" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="movie_4" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="movie_5" src=""></a></td>
				</tr>
				<tr>
					<td><a href=""><img class="itemCssList" id="movie_6" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="movie_7" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="movie_8" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="movie_9" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="movie_10" src=""></a></td>
					<td rowspan="2">선호장르 추천</td>
					<td rowspan="2">
					<td><a href=""><img id="movie_1" src=""></a></td>
					<td><a href=""><img id="movie_1" src=""></a></td>
					</td>
				</tr>
 				<tr>
					<td><a href=""><img class="itemCssList" id="movie_11" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="movie_12" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="movie_13" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="movie_14" src=""></a></td>
					<td><a href=""><img class="itemCssList" id="movie_15" src=""></a></td>
				</tr> 
				
			</table>
				
	</section>
	
<jsp:include page="../footer.jsp"/>

