<%@page import="java.sql.Date"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<c:forEach var="movieList" items="${movieList}"/>

<jsp:include page="../header.jsp"/>
	<section class="itemListSection">
			<h2 align="center">영화</h2>
			<table class="itemTableStyle" border="1">
				<tr>
					<td>
						<a href="/item/itemDetail?item_id=${movieList.get(0).item_id}"><img class="itemCssList" id="movie_1" src="${movieList.get(0).image_path}"></a>
						<p class="itemTitle"><strong>${movieList.get(0).title}</strong></p>	
						<p class="itemPeriod">${movieList.get(0).start_day_str} ~ ${movieList.get(0).end_day_str}</p>						
					</td>
					<td>
						<a href="/item/itemDetail?item_id=${movieList.get(1).item_id}"><img class="itemCssList" id="movie_2" src="${movieList.get(1).image_path}"></a>
						<p class="itemTitle"><strong>${movieList.get(1).title}</strong></p>	
						<p class="itemPeriod">${movieList.get(1).start_day_str} ~ ${movieList.get(1).end_day_str}</p>							
					</td>
					<td>
						<a href="/item/itemDetail?item_id=${movieList.get(2).item_id}"><img class="itemCssList" id="movie_3" src="${movieList.get(2).image_path}"></a>
						<p class="itemTitle"><strong>${movieList.get(2).title}</strong></p>	
						<p class="itemPeriod">${movieList.get(2).start_day_str} ~ ${movieList.get(2).end_day_str}</p>							
					</td>
					<td>
						<a href="/item/itemDetail?item_id=${movieList.get(3).item_id}"><img class="itemCssList" id="movie_4" src="${movieList.get(3).image_path}"></a>
						<p class="itemTitle"><strong>${movieList.get(3).title}</strong></p>	
						<p class="itemPeriod">${movieList.get(3).start_day_str} ~ ${movieList.get(3).end_day_str}</p>							
					</td>
					<td>
						<a href="/item/itemDetail?item_id=${movieList.get(4).item_id}"><img class="itemCssList" id="movie_5" src="${movieList.get(4).image_path}"></a>
						<p class="itemTitle"><strong>${movieList.get(4).title}</strong></p>	
						<p class="itemPeriod">${movieList.get(4).start_day_str} ~ ${movieList.get(4).end_day_str}</p>
					</td>
				</tr>
				<tr>
					<td>
						<a href="/item/itemDetail?item_id=${movieList.get(5).item_id}"><img class="itemCssList" id="movie_6" src="${movieList.get(5).image_path}"></a>
						<p class="itemTitle"><strong>${movieList.get(5).title}</strong></p>	
						<p class="itemPeriod">${movieList.get(5).start_day_str} ~ ${movieList.get(5).end_day_str}</p>							
					</td>
					<td>
						<a href="/item/itemDetail?item_id=${movieList.get(6).item_id}"><img class="itemCssList" id="movie_7" src="${movieList.get(6).image_path}"></a>
						<p class="itemTitle"><strong>${movieList.get(6).title}</strong></p>	
						<p class="itemPeriod">${movieList.get(6).start_day_str} ~ ${movieList.get(6).end_day_str}</p>							
					</td>
					<td>
						<a href="/item/itemDetail?item_id=${movieList.get(7).item_id}"><img class="itemCssList" id="movie_8" src="${movieList.get(7).image_path}"></a>
						<p class="itemTitle"><strong>${movieList.get(7).title}</strong></p>	
						<p class="itemPeriod">${movieList.get(7).start_day_str} ~ ${movieList.get(7).end_day_str}</p>							
					</td>
					<td><a href="#"><img class="itemCssList" id="movie_9" src="../resources/image/coming_soon.jpg"></a></td>
					<td><a href="#"><img class="itemCssList" id="movie_10" src="../resources/image/coming_soon.jpg"></a></td>
					<td rowspan="2">선호장르 추천</td>
					<td rowspan="2">
						<a href="#"><img class="recommendItem" id="" src=""></a>
						<a href="#"><img class="recommendItem" id="" src=""></a>
					</td>
				</tr>
 				<tr>
					<td>
						<a href="#"><img class="itemCssList" id="movie_11" src="../resources/image/coming_soon.jpg"></a>
						<p class="itemTitle"><strong></strong></p>	
						<p class="itemPeriod"></p>			
					</td>
					<td>
						<a href="#"><img class="itemCssList" id="movie_12" src="../resources/image/coming_soon.jpg"></a>
						<p class="itemTitle"><strong></strong></p>	
						<p class="itemPeriod"></p>				
					</td>
					<td>
						<a href="#"><img class="itemCssList" id="movie_13" src="../resources/image/coming_soon.jpg"></a>
						<p class="itemTitle"><strong></strong></p>	
						<p class="itemPeriod"></p>				
					</td>
					<td>
						<a href="#"><img class="itemCssList" id="movie_14" src="../resources/image/coming_soon.jpg"></a>
						<p class="itemTitle"><strong></strong></p>	
						<p class="itemPeriod"></p>				
					</td>
					<td>
						<a href="#"><img class="itemCssList" id="movie_15" src="../resources/image/coming_soon.jpg"></a>
						<p class="itemTitle"><strong></strong></p>	
						<p class="itemPeriod"></p>				
					</td>
				</tr> 
			</table>
	</section>
<jsp:include page="../footer.jsp"/>

