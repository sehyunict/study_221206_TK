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
			<h2 align="center">전시회</h2>
			<table class="itemTableStyle" border="1"> 
				<tr>
					<td>
						<a href="/item/itemDetail?itemId=${exhibitionList.get(0).itemId}"><img class="itemCssList" id="exhibition_1" src="${exhibitionList.get(0).imagePath}"></a>
						<p class="itemTitle"><strong>${exhibitionList.get(0).title}</strong></p>	
						<p class="itemPeriod">${exhibitionList.get(0).startDayStr} ~ ${exhibitionList.get(0).endDayStr}</p>	
					</td>
					<td>
						<a href=""><img class="itemCssList" id="exhibition_2" src="../resources/image/coming_soon.jpg"></a>
						<p class="itemTitle"><strong></strong></p>	
						<p class="itemPeriod"></p>	
					</td>
					<td>
						<a href=""><img class="itemCssList" id="exhibition_3" src="../resources/image/coming_soon.jpg"></a>
						<p class="itemTitle"><strong></strong></p>	
						<p class="itemPeriod"></p>			
					</td>
					<td>
						<a href=""><img class="itemCssList" id="exhibition_4" src="../resources/image/coming_soon.jpg"></a>
						<p class="itemTitle"><strong></strong></p>	
						<p class="itemPeriod"></p>							
					</td>
					<td>
						<a href=""><img class="itemCssList" id="exhibition_5" src="../resources/image/coming_soon.jpg"></a>
						<p class="itemTitle"><strong></strong></p>	
						<p class="itemPeriod"></p>					
					</td>
				</tr>
				<tr>
					<td>
						<a href=""><img class="itemCssList" id="exhibition_6" src="../resources/image/coming_soon.jpg"></a>
						<p class="itemTitle"><strong></strong></p>	
						<p class="itemPeriod"></p>					
					</td>
					<td>
						<a href=""><img class="itemCssList" id="exhibition_7" src="../resources/image/coming_soon.jpg"></a>
						<p class="itemTitle"><strong></strong></p>	
						<p class="itemPeriod"></p>					
					</td>
					<td>
						<a href=""><img class="itemCssList" id="exhibition_8" src="../resources/image/coming_soon.jpg"></a>
						<p class="itemTitle"><strong></strong></p>	
						<p class="itemPeriod"></p>					
					</td>
					<td>
						<a href=""><img class="itemCssList" id="exhibition_9" src="../resources/image/coming_soon.jpg"></a>
						<p class="itemTitle"><strong></strong></p>	
						<p class="itemPeriod"></p>	
					</td>
					<td>
						<a href=""><img class="itemCssList" id="exhibition_10" src="../resources/image/coming_soon.jpg"></a>
						<p class="itemTitle"><strong></strong></p>	
						<p class="itemPeriod"></p>					
					</td>
					<td rowspan="2">선호장르 추천</td>
					<td rowspan="2">
						<a href="#"><img class="recommendItem" id="" src=""></a>
						<a href="#"><img class="recommendItem" id="" src=""></a>
					</td>
				</tr>
			</table>
	</section>
<jsp:include page="../footer.jsp"/>
	