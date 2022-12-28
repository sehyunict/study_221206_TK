<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="detailList" value="${detailList}" scope="page"/>


<jsp:include page="../header.jsp"/>
 <section class="itemDetailSection">
	<div id="itemDetailStyle_A1" class="itemDetailStyle">
		<h1 align="center">상세페이지</h1>
	</div>
		<div id="itemDetailStyle_A2" class="itemDetailStyle">
			<table class="itemDetailTableStyle" border="1">
				<tr>
					<td rowspan="3">
						<img id="itemImg" src="${detailList.get(0).imagePath}">
					</td>
					<td>제목</td>
					<td>
						<p id="title"> ${detailList.get(0).title} </p>
					</td>
				</tr>
				<tr>
					<td>감독</td>
					<td>
						<p id="director"> ${detailList.get(0).director} </p>
					</td>
				</tr>
				<tr>
					<td>줄거리</td>
					<td>
						<p id="summary"> ${detailList.get(0).summary} </p>
					</td>
				</tr>	
				
				<tr>
					<td colspan="4"><strong>상영일시</strong></td>
				</tr>
					
				<c:forEach var="detailList" items="${detailList}" varStatus="vs" >
				<tr>
					<td colspan="4">  ${detailList.startTime} ~ ${detailList.endTime}</td>
				</tr>
				</c:forEach>
				
			</table>
		</div>	
</section>
</body>

<jsp:include page="../footer.jsp"/>
