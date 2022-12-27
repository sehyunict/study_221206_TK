<%@page import="java.sql.Date"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<jsp:include page="../header.jsp"/>
	<section class="itemListSection">
			<h2 align="center">연극</h2>
			<table class="itemTableStyle" border="1">
				<tr>
					<td>
						<a href="/item/itemDetail?itemId=${theaterList.get(0).itemId}"><img class="itemCssList" id="theater_1" src="${theaterList.get(0).imagePath}"></a>
						<p class="itemTitle"><strong>${theaterList.get(0).title}</strong></p>	
						<p class="itemPeriod">${theaterList.get(0).startDayStr} ~ ${theaterList.get(0).endDayStr}</p>						
					</td>
					<td>
						<a href="/item/itemDetail?itemId=${theaterList.get(1).itemId}"><img class="itemCssList" id="theater_2" src="${theaterList.get(1).imagePath}"></a>
						<p class="itemTitle"><strong>${theaterList.get(1).title}</strong></p>	
						<p class="itemPeriod">${theaterList.get(1).startDayStr} ~ ${theaterList.get(1).endDayStr}</p>					
					</td>
					<td>
						<a href="/item/itemDetail?itemId=${theaterList.get(2).itemId}"><img class="itemCssList" id="theater_3" src="${theaterList.get(2).imagePath}"></a>
						<p class="itemTitle"><strong>${theaterList.get(2).title}</strong></p>	
						<p class="itemPeriod">${theaterList.get(2).startDayStr} ~ ${theaterList.get(2).endDayStr}</p>						
					</td>
					<td>
						<a href="/item/itemDetail?itemId=${theaterList.get(3).itemId}"><img class="itemCssList" id="theater_4" src="${theaterList.get(3).imagePath}"></a>
						<p class="itemTitle"><strong>${theaterList.get(3).title}</strong></p>	
						<p class="itemPeriod">${theaterList.get(3).startDayStr} ~ ${theaterList.get(3).endDayStr}</p>						
					</td>
					<td>
						<a href="/item/itemDetail?itemId=${theaterList.get(4).itemId}"><img class="itemCssList" id="theater_5" src="${theaterList.get(4).imagePath}"></a>
						<p class="itemTitle"><strong>${theaterList.get(4).title}</strong></p>	
						<p class="itemPeriod">${theaterList.get(4).startDayStr} ~ ${theaterList.get(4).endDayStr}</p>					
					</td>
				</tr>
				<tr>
					<td><a href="#"><img class="itemCssList" id="theater_6" src="../resources/image/coming_soon.jpg"></a></td>
					<td><a href="#"><img class="itemCssList" id="theater_7" src="../resources/image/coming_soon.jpg"></a></td>
					<td><a href="#"><img class="itemCssList" id="theater_8" src="../resources/image/coming_soon.jpg"></a></td>
					<td><a href="#"><img class="itemCssList" id="theater_9" src="../resources/image/coming_soon.jpg"></a></td>
					<td><a href="#"><img class="itemCssList" id="theater_10" src="../resources/image/coming_soon.jpg"></a></td>
				</tr>
 				
			</table>
	</section>
<jsp:include page="../footer.jsp"/>

