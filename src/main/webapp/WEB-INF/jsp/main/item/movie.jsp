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
			<h2 align="center">영화</h2>
			<table class="itemTableStyle" border="1">
				<tr>
					<td>
						<a href="/item/itemDetail?itemId=${movieList.get(0).itemId}"><img class="itemCssList" id="movie_1" src="${movieList.get(0).imagePath}"></a>
						<p class="itemTitle"><strong>${movieList.get(0).title}</strong></p>	
						<p class="itemPeriod">${movieList.get(0).startDayStr} ~ ${movieList.get(0).endDayStr}</p>						
					</td>
					<td>
						<a href="/item/itemDetail?itemId=${movieList.get(1).itemId}"><img class="itemCssList" id="movie_2" src="${movieList.get(1).imagePath}"></a>
						<p class="itemTitle"><strong>${movieList.get(1).title}</strong></p>	
						<p class="itemPeriod">${movieList.get(1).startDayStr} ~ ${movieList.get(1).endDayStr}</p>							
					</td>
					<td>
						<a href="/item/itemDetail?itemId=${movieList.get(2).itemId}"><img class="itemCssList" id="movie_3" src="${movieList.get(2).imagePath}"></a>
						<p class="itemTitle"><strong>${movieList.get(2).title}</strong></p>	
						<p class="itemPeriod">${movieList.get(2).startDayStr} ~ ${movieList.get(2).endDayStr}</p>							
					</td>
					<td>
						<a href="/item/itemDetail?itemId=${movieList.get(3).itemId}"><img class="itemCssList" id="movie_4" src="${movieList.get(3).imagePath}"></a>
						<p class="itemTitle"><strong>${movieList.get(3).title}</strong></p>	
						<p class="itemPeriod">${movieList.get(3).startDayStr} ~ ${movieList.get(3).endDayStr}</p>							
					</td>
					<td>
						<a href="/item/itemDetail?itemId=${movieList.get(4).itemId}"><img class="itemCssList" id="movie_5" src="${movieList.get(4).imagePath}"></a>
						<p class="itemTitle"><strong>${movieList.get(4).title}</strong></p>	
						<p class="itemPeriod">${movieList.get(4).startDayStr} ~ ${movieList.get(4).endDayStr}</p>
					</td>
				</tr>
				<tr>
					<td>
						<a href="#"><img class="itemCssList" id="movie_6" src="../resources/image/coming_soon.jpg"></a>
						<p class="itemTitle"><strong></strong></p>	
						<p class="itemPeriod"></p>			
					</td>			
					<td>
						<a href="#"><img class="itemCssList" id="movie_7" src="../resources/image/coming_soon.jpg"></a>
						<p class="itemTitle"><strong></strong></p>	
						<p class="itemPeriod"></p>			
					</td>	
					<td>
						<a href="#"><img class="itemCssList" id="movie_8" src="../resources/image/coming_soon.jpg"></a>
						<p class="itemTitle"><strong></strong></p>	
						<p class="itemPeriod"></p>			
					</td>						
					<td><a href="#"><img class="itemCssList" id="movie_9" src="../resources/image/coming_soon.jpg"></a></td>
					<td><a href="#"><img class="itemCssList" id="movie_10" src="../resources/image/coming_soon.jpg"></a></td>
					
				</tr>
			</table>
	</section>
<jsp:include page="../footer.jsp"/>

