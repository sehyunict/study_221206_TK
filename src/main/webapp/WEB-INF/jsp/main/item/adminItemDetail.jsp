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

<%-- <c:set var="a" value="${imagePath}" scope="page"/>
<c:set var="b" value="${title}" scope="page"/>
<c:set var="c" value="${director}" scope="page"/>
<c:set var="d" value="${summary}" scope="page"/> --%>

<!-- ajax사용 위해 라이브러리 추가 -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js">
</script>
 -->

<c:set var="adminDetailVoList" value="${adminDetailVoList}" scope="page"/>


<jsp:include page="../header.jsp"/>
 <section class="itemDetailSection">
	<div id="itemDetailStyle_A1" class="itemDetailStyle">
		<h1 align="center">작품 수정/삭제(관리자 페이지)</h1>
	</div>
		<div id="itemDetailStyle_A2" class="itemDetailStyle">
			<table border="1">
				<tr>
					<td rowspan="11">이미지</td>
					<td id="imgTd" rowspan="11">
						<div id="container">
							<img id="adminItemImg" src="${adminDetailVoList.adminDetailItem.imagePath}">
						</div>
						<input type="file" name="uploadImg" accept="image/*" onchange="previewImg();">
						<button type="button" id="uploadBtn" onclick="uploadImg();">업로드</button>
					</td>
					<td ></td>
					<td>제목</td>
					<td>
						<input type="hidden" id="itemId" value="${adminDetailVoList.adminDetailItem.itemId}">
						<input type="text" id="title" value="${adminDetailVoList.adminDetailItem.title}">
					</td>
				</tr>
				<tr>
					<td></td>
					<td>감독</td>
					<td>
						<input type="text" id="director" value="${adminDetailVoList.adminDetailItem.director}">
					</td>
				</tr>
				<tr>
					<td></td>
					<td>배우</td>
					<td>
						<input type="text" id="actor" value="${adminDetailVoList.adminDetailItem.actor}">
					</td>
				</tr>				
				<tr>
					<td></td>
					<td>줄거리</td>
					<td>
						<textarea id="summary" rows="20" cols="40"> "${adminDetailVoList.adminDetailItem.summary}"
						</textarea>
					</td>
				</tr>	
				<tr>
					<td></td>
					<td>러닝타임</td>
					<td>
						<input type="text" id="runningtime" value="${adminDetailVoList.adminDetailItem.runningtime}">
					</td>
				</tr>												
				<tr>
					<td></td>
					<td>주의사항</td>
					<td>
						<input type="text" id="caution" value="${adminDetailVoList.adminDetailItem.caution}">
					</td>
				</tr>	
				<tr>
					<td></td>
					<td>상영시작일</td>
					<td>
						<input type="date" id="startDay" value="${adminDetailVoList.adminDetailItem.startDayStr}">
					</td>
				</tr>
				<tr>
					<td></td>
					<td>상영종료일</td>
					<td>
						<input type="date" id="endDay" value="${adminDetailVoList.adminDetailItem.endDayStr}">
					</td>
				</tr>	
				<tr>
					<td></td>
					<td>카테고리</td>
					<td>
						<input type="text" id="categoryId" value="${adminDetailVoList.adminDetailItem.categoryId}">
					</td>
				</tr>												
				<tr>
					<td></td>
					<td>상영상태</td>
					<td>
						<input type="text" id="statusId" value="${adminDetailVoList.adminDetailItem.statusId}">
					</td>
				</tr>	
				<tr>
					<td></td>
					<td>장르</td>
					<td>
						<input type="text" id="genreId" value="${adminDetailVoList.adminDetailItem.genreId}">
					</td>
				</tr>	
															
<!-- 				<tr>
					<td></td>
					<td>가격</td>
					<td>
						<p><input type="text" id="price" value=""></p>
					</td>
				</tr>				 -->
									
				<tr>
					<td style= colspan: '4', text-align='center'>
						<button type="button" class="ticketing_btn" onclick="itemModify();">수정하기</button>
						&nbsp;&nbsp;&nbsp;
						<button type="button" class="ticketing_btn" onclick="itemDelete();">삭제하기</button>
					</td>
				</tr>	
				<tr>
					<td colspan="3"></td>
					<td></td>
				</tr>
			</table>
		</div>	
</section>

<script>
	function previewImg() {
		let reader = new FileReader();
		reader.onload = function(event){
		console.log(event.target.result)
			const insertImg = document.createElement('img');
			insertImg.setAttribute("src",event.target.result);
			insertImg.setAttribute("width","360");
			insertImg.setAttribute("height","400");
			
			document.querySelector("#container").appendChild(insertImg);
		};
		
		reader.readAsDataURL(event.target.files[0]);
	}
	
	function uploadImg(){
		let formData = new FormData();
		let inputFile = document.querySelector("input[name='uploadImg']"); 
		
		console.log(inputFile);
		
		// formData에 파일 추가(변수명 / 값)
		formData.append("inputFile", inputFile.files[0]);
		
		$.ajax({
			url: '/item/uploadFile',
			processData : false,
			contentType : false,
			data : formData,
			type : "POST",
			success : function(){
				alert("업로드 성공!");
			},
			error : function(error){
				alert("업로드 실패!");
				alert("code: "+error);
			}
		});
	}
	
	//상품정보 수정
	function itemModify(){
		console.log("modify function 진입..");
		let uploadImg = document.querySelector("uploadImg");
		let itemId = document.querySelector("#itemId").value; 
		let title = document.querySelector("#title").value; 
		let director = document.querySelector("#director").value;
		let actor = document.querySelector("#actor").value;
 		let summary = document.querySelector("#summary").value;
 		let runningtime = document.querySelector("#runningtime").value;
		let caution = document.querySelector("#caution").value;
		let startDay = document.querySelector("#startDay").value;
		let endDay = document.querySelector("#endDay").value;
		let categoryId = document.querySelector("#categoryId").value;
		let statusId = document.querySelector("#statusId").value;
		let genreId = document.querySelector("#genreId").value;
		
		let itemObj = {itemId : itemId, title : title, director : director, actor : actor, 
 	        		summary : summary, runningtime : runningtime, 
 	        		caution : caution, startDay : startDay, endDay : endDay,
 	        		categoryId : categoryId, statusId : statusId, 
 	        		genreId : genreId};

		$.ajax({
			url: '/item/modifyAction',
			contentType : 'application/json',	//서버로 전송하는 데이터형식
 	        data : JSON.stringify(itemObj),		//서버에서 반환하는 데이터형식
// 	        dataType : 'json', 
 			type: 'POST',
			
			//응답부
			//(컨트롤러로 데이터 전송 성공시)
			success: function(){
/* 				$("#uploadImg").val(modifyVoList.modifyVo.imagePath);
  				$("#title").val(modifyVoList.modifyVo.title);
				$("#director").val(modifyVoList.modifyVo.director);
				$("#actor").val(modifyVoList.modifyVo.actor);
				$("#summary").val(modifyVoList.modifyVo.summary);
				$("#runningtime").val(modifyVoList.modifyVo.runningtime);
				$("#caution").val(modifyVoList.modifyVo.caution);
				$("#startDay").val(modifyVoList.modifyVo.startDay);
				$("#endDay").val(modifyVoList.modifyVo.endDay);
				$("#categoryId").val(modifyVoList.modifyVo.categoryId);
				$("#statusId").val(modifyVoList.modifyVo.statusId);
				$("#genreId").val(modifyVoList.modifyVo.genreId);   */
				alert("전송 성공!");
//				location.href = "/item/adminItemDetail?=" + itemId;

			},
			error: function(request, status, errorThrown){
				alert("전송 실패!");
			}
		});
	}
	
	function itemDelete(){
		let itemId = document.querySelector("#itemId").value; 
		console.log("delete function 진입..");
	
		$.ajax({
			url: '/item/deleteAction?itemId=' + itemId+"",
 			type: 'GET',
 			dataType: "json",
		success: function(itemId){
			alert("전송 성공!");
			location.href = "/item/adminItemList";
		},

		error: function(request, status, errorThrown){
			alert("전송 실패!");
		}
		
		});
	}
</script>

<jsp:include page="../footer.jsp"/>
