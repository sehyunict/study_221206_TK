<%@page import="java.sql.Date"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:forEach var="theaterList" items="${theaterList}"/>

<jsp:include page="../header.jsp"/>
	<section class="itemListSection">
			<h2 align="center">연극</h2>
			<table class="itemTableStyle" border="1">
				<tr>
					<td>
						<a href="/item/itemDetail?item_id=${theaterList.get(0).item_id}"><img class="itemCssList" id="theater_1" src="${theaterList.get(0).image_path}"></a>
						<p class="itemTitle"><strong>${theaterList.get(0).title}</strong></p>	
						<p class="itemPeriod">${theaterList.get(0).start_day_str} ~ ${theaterList.get(0).end_day_str}</p>						
					</td>
					<td>
						<a href="/item/itemDetail?item_id=${theaterList.get(1).item_id}"><img class="itemCssList" id="theater_2" src="${theaterList.get(1).image_path}"></a>
						<p class="itemTitle"><strong>${theaterList.get(1).title}</strong></p>	
						<p class="itemPeriod">${theaterList.get(1).start_day_str} ~ ${theaterList.get(1).end_day_str}</p>					
					</td>
					<td>
						<a href="/item/itemDetail?item_id=${theaterList.get(2).item_id}"><img class="itemCssList" id="theater_3" src="${theaterList.get(2).image_path}"></a>
						<p class="itemTitle"><strong>${theaterList.get(2).title}</strong></p>	
						<p class="itemPeriod">${theaterList.get(2).start_day_str} ~ ${theaterList.get(2).end_day_str}</p>						
					</td>
					<td>
						<a href="/item/itemDetail?item_id=${theaterList.get(3).item_id}"><img class="itemCssList" id="theater_4" src="${theaterList.get(3).image_path}"></a>
						<p class="itemTitle"><strong>${theaterList.get(3).title}</strong></p>	
						<p class="itemPeriod">${theaterList.get(3).start_day_str} ~ ${theaterList.get(3).end_day_str}</p>						
					</td>
					<td>
						<a href="/item/itemDetail?item_id=${theaterList.get(4).item_id}"><img class="itemCssList" id="theater_5" src="${theaterList.get(4).image_path}"></a>
						<p class="itemTitle"><strong>${theaterList.get(4).title}</strong></p>	
						<p class="itemPeriod">${theaterList.get(4).start_day_str} ~ ${theaterList.get(4).end_day_str}</p>					
					</td>
				</tr>
				<tr>
					<td><a href="#"><img class="itemCssList" id="theater_6" src="../resources/image/coming_soon.jpg"></a></td>
					<td><a href="#"><img class="itemCssList" id="theater_7" src="../resources/image/coming_soon.jpg"></a></td>
					<td><a href="#"><img class="itemCssList" id="theater_8" src="../resources/image/coming_soon.jpg"></a></td>
					<td><a href="#"><img class="itemCssList" id="theater_9" src="../resources/image/coming_soon.jpg"></a></td>
					<td><a href="#"><img class="itemCssList" id="theater_10" src="../resources/image/coming_soon.jpg"></a></td>
					<td rowspan="2">선호장르 추천</td>
					<td rowspan="2">
						<a href="#"><img class="recommendItem" id="" src=""></a>
						<a href="#"><img class="recommendItem" id="" src=""></a>
					</td>
				</tr>
 				<tr>
					<td>
						<a href="#"><img class="itemCssList" id="theater_11" src="../resources/image/coming_soon.jpg"></a>
						<p class="itemTitle"><strong></strong></p>	
						<p class="itemPeriod"></p>				
					</td>
					<td>
						<a href="#"><img class="itemCssList" id="theater_12" src="../resources/image/coming_soon.jpg"></a>
						<p class="itemTitle"><strong></strong></p>	
						<p class="itemPeriod"></p>				
					</td>
					<td>
						<a href="#"><img class="itemCssList" id="theater_13" src="../resources/image/coming_soon.jpg"></a>
						<p class="itemTitle"><strong></strong></p>	
						<p class="itemPeriod"></p>				
					</td>
					<td>
						<a href="#"><img class="itemCssList" id="theater_14" src="../resources/image/coming_soon.jpg"></a>
						<p class="itemTitle"><strong></strong></p>	
						<p class="itemPeriod"></p>					
					</td>
					<td>
						<a href="#"><img class="itemCssList" id="theater_15" src="../resources/image/coming_soon.jpg"></a>
						<p class="itemTitle"><strong></strong></p>	
						<p class="itemPeriod"></p>					
					</td>
				</tr> 
			</table>
	</section>
<jsp:include page="../footer.jsp"/>

