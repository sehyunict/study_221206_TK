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
	<section class="adminItemListSection">
			<h2 align="center">작품 목록(관리자 페이지)</h2>
			<table class="adminItemTableStyle" border="1">
				<tr>
					<th>ID</th>
					<th>제목</th>
					<th>카테고리</th>
					<th>장르</th>
					<th>상영기간</th>
					<th>현재상영여부</th>
				</tr>
				
				<c:forEach var="adminItem" items="${adminItemList}" varStatus="vs" >
				<tr>
					<td>
						<strong><a href="/item/adminItemDetail?itemId=${adminItem.itemId}">${adminItem.itemId}</a></strong>
					</td>	
					<td>
						<p class="title">${adminItem.title}</p>	
					</td>
					<td>
						<p class="codeName">${adminItem.codeName}</p>	
					</td>																														
					<td>	
						<p class="codeName1">${adminItem.codeName1}</p>
					</td>					
					<td>
						<p class="itemPeriod">${adminItem.startDayStr} ~ ${adminItem.endDayStr}</p>
					</td>
					<td>
						<p class="codeName2">${adminItem.codeName2}</p>
					</td>
				</tr>
				</c:forEach>
				<tr align="center">
					<td colspan="7">
						<a href="/item/adminItemRegister">상품등록 페이지</a>
					</td>
				</tr>			
			</table>
			
	</section>
	<script>
		
	</script>
<jsp:include page="../footer.jsp"/>

