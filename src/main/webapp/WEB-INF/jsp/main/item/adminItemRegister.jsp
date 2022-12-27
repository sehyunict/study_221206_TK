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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js">
/* 	$(document).ready(function(){
		$("#uploadBtn").on("click",function(e){
			
		let formData = new formData();
		
		let inputFile = $("input[name='uploadImg']");
		
		let files = inputFile[0].files;
		
		console.log(files);

		});
		
/* 		//add filedata to formdata
		for (let i = 0; i < files.length; i++) {
			formData.append("uploadImg", files[i]);
		}
		
		$.ajax({
			url: '/adminItemRegister';
			processData: false,
			contentType: false,
			data: formData,
			type: "POST",
			success: function(result){
				alert("Uploaded")
			}
			
		}) 
	});
		*/
</script>

<jsp:include page="../header.jsp"/>
 <section class="itemDetailSection">
	<div id="itemDetailStyle_A1" class="itemDetailStyle">
		<h1 align="center">작품 등록(관리자 페이지)</h1> 
	</div>
		<div id="itemDetailStyle_A2" class="adminItemDetailStyle">
			<table border="1" class="adminDetailTableStyle">
				<tr>
					<td id="imgTd2" rowspan="11">이미지</td>
					<td rowspan="11">
						<div id="container"></div>
						<br>
						<input type="file" name="uploadImg" accept="image/*" onchange="previewImg();">
						<button type="button" id="uploadBtn" onclick="uploadImg();">업로드</button>
					</td>
					<td></td>
					<td>제목</td>
					<td>
						<p><input type="text" id="title" value=""></p>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>감독</td>
					<td>
						<p><input type="text" id="director" value=""></p>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>배우</td>
					<td>
						<p><input type="text" id="actor" value=""></p>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>줄거리</td>
					<td>
						<textarea id="summary" rows="20" cols="40">
						</textarea>
					</td>
				</tr>	
				<tr>
					<td></td>
					<td>러닝타임</td>
					<td>
						<p><input type="text" id="runningtime" value=""></p>
					</td>
				</tr>												
				<tr>
					<td></td>
					<td>주의사항</td>
					<td>
						<p><input type="text" id="caution" value=""></p>
					</td>
				</tr>	
				<tr>
					<td></td>
					<td>상영시작일</td>
					<td>
						<p><input type="date" id="startDay" value=""></p>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>상영종료일</td>
					<td>
						<p><input type="date" id="endDay" value=""></p>
					</td>
				</tr>	
				<tr>
					<td></td>
					<td>카테고리</td>
					<td>
						<p><input type="text" id="categoryId" value=""></p>
					</td>
				</tr>												
				<tr>
					<td></td>
					<td>상영상태</td>
					<td>
						<p><input type="text" id="statusId" value=""></p>
					</td>
				</tr>	
				<tr>
					<td></td>
					<td>장르</td>
					<td>
						<p><input type="text" id="genreId" value=""></p>
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
						<button type="button" class="ticketing_btn" onclick="itemRegister(); return false;">등록하기</button>
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
	//파일추가시 이미지 미리보기
	function previewImg() {
		let reader = new FileReader();
		reader.onload = function(event){
		console.log(event.target.result)
			let insertImg = document.createElement('img');
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
	
	//상품정보 등록/조회
	function itemRegister(){
		console.log("register function 진입..");
		let uploadImg = document.querySelector("uploadImg");
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

//		let price = document.querySelector("#price").value;

		let registerObj = {title : title, director : director, actor : actor, 
 	        		summary : summary, runningtime : runningtime, 
 	        		caution : caution, startDay : startDay, endDay : endDay,
 	        		categoryId : categoryId, statusId : statusId, 
 	        		genreId : genreId};
		console.log(registerObj)

		$.ajax({
			url: '/item/registerAction1',
 	        data : JSON.stringify(registerObj),
			contentType : 'application/json; charset=utf-8',	//서버로 전송하는 데이터형식
	        dataType : 'json', 	//서버에서 반환하는 데이터형식
			type: 'POST',
			
			//응답부
			success: function(registerVoMap){
	//			$("#uploadImg").val(result.imagePath);
				$("#title").val(registerVoMap.registerVo1.title);
				$("#director").val(registerVoMap.registerVo1.director);
				$("#actor").val(registerVoMap.registerVo1.actor);
				$("#summary").val(registerVoMap.registerVo1.summary);
				$("#runningtime").val(registerVoMap.registerVo1.runningtime);
				$("#caution").val(registerVoMap.registerVo1.caution);
				$("#startDay").val(registerVoMap.registerVo1.startDay);
				$("#endDay").val(registerVoMap.registerVo1.endDay);
				$("#categoryId").val(registerVoMap.registerVo1.categoryId);
				$("#statusId").val(registerVoMap.registerVo1.statusId);
				$("#genreId").val(registerVoMap.registerVo1.genreId);
				
				alert("전송 성공!");
				
			},
			error: function(error){
				alert("전송 실패!");
				alert("code: "+error);
			}
		});
		
		/* 
		$.ajax({
			url: '/item/registerAction2',
 	        data : {"price" : price},
	        dataType : "json", 
			type: 'POST',
			
			//응답부
			success: function(registerVoMap){
				console.log("ajax 응답부 진입..");

				$("#price").val(registerVoMap.registerVo2.price);
			},
			error: function(error){
				alert("전송에 실패하였습니다.");
				alert("code: "+error);
			}
		});
		 */
	}
</script>


<jsp:include page="../footer.jsp"/>
