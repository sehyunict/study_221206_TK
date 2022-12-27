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
					<td ></td>
					<td>제목</td>
					<td>
						<p id="title"> ${detailList.get(0).title} </p>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>감독</td>
					<td>
						<p id="director"> ${detailList.get(0).director} </p>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>줄거리</td>
					<td>
						<p id="summary"> ${detailList.get(0).summary} </p>
					</td>
				</tr>	
				
				<tr>
					<td colspan="3">리뷰하기</td>
					<td>
						<button class="ticketing_btn" onclick="">예매하기</button>&nbsp;&nbsp;<button class="ticketing_btn" onclick="">찜하기</button>
						
					</td>
				</tr>	
				<tr>
					<td colspan="3"></td>
					<td></td>
				</tr>
				
			</table>
		</div>	
	
<%-- 	
	<form name="allTaxForm">		
		<input type="hidden" id="id" name="id" value="${memberDto.getId()}"> 
		<!--1. 특정 id값을 참조해 값을 보낼때 최초페이지(값을 입력하는 페이지)에서 form 안에 name이 id인 input이 있어줘야 됨.  -->
		<!--2. input disabled 속성을 사용하면 값이 다음페이지로 넘어가지 않음. 값넘길때 disabled 쓰지말기.   -->
		
		<div id="taxMainStyle_A2_1" class="taxMainStyle">
			<span style="color: white"><strong>※ 연말정산 가이드(필독) ※</strong></span>&nbsp; <span style="color: blue;" id="foldingInfo" onclick="informFolding();">▲접기</span>

			<div id=inform_menu>
				<menu>
					<ul align="center">
						<li id="guide" class="toInform">▶개요(클릭해주세요)</li>	
						<!-- 이부분을 a링크로 하면 아래 onclick이 중복되서 ref를 두번타는 문제 발생.. -->
					</ul>
				</menu>
			</div>
			<div id="inform" style="display: block">
				<script>
					$(document).ready(
									function inform1() {
										$(".toInform").click(
														function inform1_1() {
															//console.log("event");   //진입확인
															
															let guide = document.getElementById("guide");
							
															let payment1 = document.getElementById("payment1");
															let payment2 = document.getElementById("payment2");
															let payment3 = document.getElementById("payment3");
															let payment4 = document.getElementById("payment4");
															let payment5 = document.getElementById("payment5");
															let payment6 = document.getElementById("payment6");
															let payment7 = document.getElementById("payment7");
															
															let incomeDeduction1 = document.getElementById("incomeDeduction1");
															let incomeDeduction2 = document.getElementById("incomeDeduction2");
															let incomeDeduction3 = document.getElementById("incomeDeduction3");
															let incomeDeduction4 = document.getElementById("incomeDeduction4");
															let incomeDeduction5 = document.getElementById("incomeDeduction5");
															let incomeDeduction6 = document.getElementById("incomeDeduction6");
															let incomeDeduction7 = document.getElementById("incomeDeduction7");
															let incomeDeduction8 = document.getElementById("incomeDeduction8");
															let incomeDeduction9 = document.getElementById("incomeDeduction9");
															let incomeDeduction10 = document.getElementById("incomeDeduction10");
															let incomeDeduction11 = document.getElementById("incomeDeduction11");
															let incomeDeduction12 = document.getElementById("incomeDeduction12");
															let incomeDeduction13 = document.getElementById("incomeDeduction13");
															let incomeDeduction14 = document.getElementById("incomeDeduction14");
															let incomeDeduction15 = document.getElementById("incomeDeduction15");
															let incomeDeduction16 = document.getElementById("incomeDeduction16");
															let incomeDeduction17 = document.getElementById("incomeDeduction17");
															
															let taxDeduction1 = document.getElementById("taxDeduction1");
															let taxDeduction2 = document.getElementById("taxDeduction2");
															let taxDeduction3 = document.getElementById("taxDeduction3");
															let taxDeduction4 = document.getElementById("taxDeduction4");
															let taxDeduction5 = document.getElementById("taxDeduction5");
															let taxDeduction6 = document.getElementById("taxDeduction6");
															let taxDeduction7 = document.getElementById("taxDeduction7");
															let taxDeduction8 = document.getElementById("taxDeduction8");
															let taxDeduction9 = document.getElementById("taxDeduction9");
															let taxDeduction10 = document.getElementById("taxDeduction10");
															let taxDeduction11 = document.getElementById("taxDeduction11");
															let taxDeduction12 = document.getElementById("taxDeduction12");
															let taxDeduction13 = document.getElementById("taxDeduction13");
															let taxDeduction14 = document.getElementById("taxDeduction14");
															let taxDeduction15 = document.getElementById("taxDeduction15");
															let taxDeduction16 = document.getElementById("taxDeduction16");


															switch ($(this).attr("id")) {	
															//클릭한 속성이 id일경우 각 id마다 불러올 정보

															case "guide":
																$("#inform").load("/information #taxGuide");
																return false;
																break;

															case "payment1":
																$("#inform").load("/information #payment_1");
																return false;
																break;

															case "payment2":
																$("#inform").load("/information #payment_2");
																return false;
																break;
															case "payment3":
																$("#inform").load("/information #payment_3");
																return false;
																break;
															case "payment4":
																$("#inform").load("/information #payment_4");
																return false;
																break;
															case "payment5":
																$("#inform").load("/tax/information #payment_5");
																return false;
																break;
															case "payment6":
																$("#inform").load("/tax/information #payment_6");
																return false;
																break;
															case "payment7":
																$("#inform").load("/tax/information #payment_7");
																return false;
																break;
															case "incomeDeduction1":
																$("#inform").load("/tax/information #incomeDeduction_1");
																return false;
																break;
															case "incomeDeduction2":
																$("#inform").load("/tax/information #incomeDeduction_2");
																return false;
																break;
															case "incomeDeduction3":
																$("#inform").load("/tax/information #incomeDeduction_3");
																return false;
																break;
															case "incomeDeduction4":
																$("#inform").load("/tax/information #incomeDeduction_4");
																return false;
																break;
															case "incomeDeduction5":
																$("#inform").load("/tax/information #incomeDeduction_5");
																return false;
																break;
															case "incomeDeduction6":
																$("#inform").load("/tax/information #incomeDeduction_6");
																return false;
																break;
															case "incomeDeduction7":
																$("#inform").load("/tax/information #incomeDeduction_7");
																return false;
																break;
															case "incomeDeduction8":
																$("#inform").load("/tax/information #incomeDeduction_8");
																return false;
																break;
															case "incomeDeduction9":
																$("#inform").load("/tax/information #incomeDeduction_9");
																return false;
																break;
															case "incomeDeduction10":
																$("#inform").load("/tax/information #incomeDeduction_10");
																return false;
																break;
															case "incomeDeduction11":
																$("#inform").load("/tax/information #incomeDeduction_11");
																return false;
																break;
															case "incomeDeduction12":
																$("#inform").load("/tax/information #incomeDeduction_12");
																return false;
																break;
															case "incomeDeduction13":
																$("#inform").load("/tax/information #incomeDeduction_13");
																return false;
																break;
															case "incomeDeduction14":
																$("#inform").load("/tax/information #incomeDeduction_14");
																return false;
																break;
															case "incomeDeduction15":
																$("#inform").load("/tax/information #incomeDeduction_15");
																return false;
																break;
															case "incomeDeduction16":
																$("#inform").load("/tax/information #incomeDeduction_16");
																return false;
																break;
															case "incomeDeduction17":
																$("#inform").load("/tax/information #incomeDeduction_17");
																return false;
																break;
																
															case "taxDeduction1":
																$("#inform").load("/tax/information #taxDeduction_1");
																return false;
																break;
															case "taxDeduction2":
																$("#inform").load("/tax/information #taxDeduction_2");
																return false;
																break;
															case "taxDeduction3":
																$("#inform").load("/tax/information #taxDeduction_3");
																return false;
																break;
															case "taxDeduction4":
																$("#inform").load("/tax/information #taxDeduction_4");
																return false;
																break;
															case "taxDeduction5":
																$("#inform").load("/tax/information #taxDeduction_5");
																return false;
																break;
															case "taxDeduction6":
																$("#inform").load("/tax/information #taxDeduction_6");
																return false;
																break;
															case "taxDeduction7":
																$("#inform").load("/tax/information #taxDeduction_7");
																return false;
																break;
															case "taxDeduction8":
																$("#inform").load("/tax/information #taxDeduction_8");
																return false;
																break;
															case "taxDeduction9":
																$("#inform").load("/tax/information #taxDeduction_9");
																return false;
																break;
															case "taxDeduction10":
																$("#inform").load("/tax/information #taxDeduction_10");
																return false;
																break;
															case "taxDeduction11":
																$("#inform").load("/tax/information #taxDeduction_11");
																return false;
																break;
															case "taxDeduction12":
																$("#inform").load("/tax/information #taxDeduction_12");
																return false;
																break;
															case "taxDeduction13":
																$("#inform").load("/tax/information #taxDeduction_13");
																return false;
																break;
															case "taxDeduction14":
																$("#inform").load("/tax/information #taxDeduction_14");
																return false;
																break;
															case "taxDeduction15":
																$("#inform").load("/tax/information #taxDeduction_15");
																return false;
																break;
															case "taxDeduction16":
																$("#inform").load("/tax/information #taxDeduction_16");
																return false;
																break;
															}
														});
									})

					function informFolding() {
						//console.log("event");
						let foldingInfo = document.querySelector("#foldingInfo");
						let inform = document.querySelector("#inform");

						if (inform.style.display === "block") { 
							//비교해서 값이 block일땐
							inform.style.display = "none"; 
							//none 값 할당
							foldingInfo.innerText = "▼펼치기";

						} else if (inform.style.display === "none") {
							inform.style.display = "block";
							foldingInfo.innerText = "▲접기";
						}
					}	

				</script>							
			</div>
		</div>		


		<div id="taxMainStyle_A3" class="taxMainStyle">

		</div>
		<br>
		<hr>
		<br>
			<div id="taxMainStyle_A3_2">
			<p>☞ 소득공제 &nbsp;&nbsp;<input type="button" onclick="incomeDeductionCal();return false;" value="소득공제계산"></p>
			<br>
			<table border="1" id="taxMain_table2">
				<tr>
					<th colspan="2">공제 항목</th>
					<th>공제 금액</th>
				</tr>
				<tr class="incomeDeductionTr">
					<td colspan="2">
						<button type="button" class="folding" id="folding0">-</button>
						인적공제
					</td>
					<td>
						<input type="text" name="incomeDeductionValue0" id="incomeDeductionValue0" class="incomeDeductionValue" value='${taxDto.incomeDeductionValue0}'>
					</td>
				</tr>
				<tr class="incomeDeductionTr">
					<td colspan="2">
						<a href="#" id="incomeDeduction1" class="toInform">&nbsp;&nbsp;&nbsp;&nbsp;- 기본공제</a>
					</td>
					<td>
						<input type="text" name="incomeDeductionValue1" id="incomeDeductionValue1" class="incomeDeductionValue" value='${taxDto.incomeDeductionValue1}'>
					</td>
				</tr>
				<tr class="incomeDeductionTr">
					<td colspan="2">
						<a href="#" id="incomeDeduction2" class="toInform">&nbsp;&nbsp;&nbsp;&nbsp;- 추가공제</a>
					</td>
					<td>
						<input type="text" name="incomeDeductionValue2" id="incomeDeductionValue2" class="incomeDeductionValue" value='${taxDto.incomeDeductionValue2}'>
					</td>
				</tr>
				<tr class="incomeDeductionTr">
					<td colspan="2">
						<a href="#" id="incomeDeduction3" class="toInform">연금보험료공제</a>
					</td>
					<td>
						<input type="text" name="incomeDeductionValue3" id="incomeDeductionValue3" class="incomeDeductionValue" value='${taxDto.incomeDeductionValue3}'>
					</td>
				</tr>
				<tr class="incomeDeductionTr">
					<td colspan="2">
						<button type="button" class="folding" id="folding1">-</button>
						특별소득공제
					</td>
					<td>
						<input type="text" name="incomeDeductionValue4" id="incomeDeductionValue4" class="incomeDeductionValue" value='${taxDto.incomeDeductionValue4}'>
					</td>
				</tr>
				<tr class="incomeDeductionTr">
					<td colspan="2">
						<a href="#" id="incomeDeduction4" class="toInform">&nbsp;&nbsp;&nbsp;&nbsp;- 건강보험료 등</a>
					</td>
					<td>
						<input type="text" name="incomeDeductionValue5" id="incomeDeductionValue5" class="incomeDeductionValue" value='${taxDto.incomeDeductionValue5}'>
					</td>
				</tr>
				<tr class="incomeDeductionTr">
					<td colspan="2">
						<button type="button" class="folding" id="folding2">-</button>
						<a href="#" id="incomeDeduction5" class="toInform">주택자금</a>
					</td>
					<td>
						<input type="text" name="incomeDeductionValue6" id="incomeDeductionValue6" class="incomeDeductionValue" value='${taxDto.incomeDeductionValue6}'>
					</td>
				</tr>
				<tr class="incomeDeductionTr">
					<td colspan="2">
						<a href="#" id="incomeDeduction6" class="toInform">&nbsp;&nbsp;&nbsp;&nbsp;- 주택임차 차입금<br>&nbsp;&nbsp;&nbsp;&nbsp;원리금상환액<br>&nbsp;&nbsp;&nbsp;&nbsp;대출기관
						</a>
					</td>
					<td>
						<input type="text" name="incomeDeductionValue7" id="incomeDeductionValue7" class="incomeDeductionValue" value='${taxDto.incomeDeductionValue7}'>
					</td>
				</tr>
				<tr class="incomeDeductionTr">
					<td colspan="2">
						<a href="#" id="incomeDeduction7" class="toInform">&nbsp;&nbsp;&nbsp;&nbsp;- 주택임차 차입금<br>&nbsp;&nbsp;&nbsp;&nbsp;원리금상환액<br>&nbsp;&nbsp;&nbsp;&nbsp;거주자
						</a>
					</td>
					<td>
						<input type="text" name="incomeDeductionValue8" id="incomeDeductionValue8" class="incomeDeductionValue" value='${taxDto.incomeDeductionValue8}'>
					</td>
				</tr>
				<tr class="incomeDeductionTr">
					<td colspan="2">
						<a href="#" id="incomeDeduction8" class="toInform">&nbsp;&nbsp;&nbsp;&nbsp;- 장기주택 저당<br>&nbsp;&nbsp;&nbsp;&nbsp;차입금 이자<br>&nbsp;&nbsp;&nbsp;&nbsp;상환액
						</a>
					</td>
					<td>
						<input type="text" name="incomeDeductionValue9" id="incomeDeductionValue9" class="incomeDeductionValue" value='${taxDto.incomeDeductionValue9}'>
					</td>
				</tr>
				<tr class="incomeDeductionTr">
					<td colspan="2">
						<a href="#" id="incomeDeduction9" class="toInform">기부금(이월분)</a>
					</td>
					<td>
						<input type="text" name="incomeDeductionValue10" id="incomeDeductionValue10" class="incomeDeductionValue" value='${taxDto.incomeDeductionValue10}'>
					</td>
				</tr>
				<tr class="incomeDeductionTr">
					<td colspan="2">
						<button type="button" class="folding" id="folding3">-</button>
						그 밖의 소득공제
					</td>
					<td>
						<input type="text" name="incomeDeductionValue11" id="incomeDeductionValue11" class="incomeDeductionValue" value='${taxDto.incomeDeductionValue11}'>
					</td>
				</tr>
				<tr class="incomeDeductionTr">
					<td colspan="2">
						<a href="#" id="incomeDeduction10" class="toInform">&nbsp;&nbsp;&nbsp;&nbsp;- 개인연금저축</a>
					</td>
					<td>
						<input type="text" name="incomeDeductionValue12" id="incomeDeductionValue12" class="incomeDeductionValue" value='${taxDto.incomeDeductionValue12}'>
					</td>
				</tr>
				<tr class="incomeDeductionTr">
					<td colspan="2">
						<a href="#" id="incomeDeduction11" class="toInform">&nbsp;&nbsp;&nbsp;&nbsp;- 소기업/소상공인<br>&nbsp;&nbsp;&nbsp;&nbsp;공제부금
						</a>
					</td>
					<td>
						<input type="text" name="incomeDeductionValue13" id="incomeDeductionValue13" class="incomeDeductionValue" value='${taxDto.incomeDeductionValue13}'>
					</td>
				</tr>
				<tr class="incomeDeductionTr">
					<td colspan="2">
						<a href="#" id="incomeDeduction12" class="toInform">&nbsp;&nbsp;&nbsp;&nbsp;- 주택마련저축</a>
					</td>
					<td>
						<input type="text" name="incomeDeductionValue14" id="incomeDeductionValue14" class="incomeDeductionValue" value='${taxDto.incomeDeductionValue14}'>
					</td>
				</tr>
				<tr class="incomeDeductionTr">
					<td colspan="2">
						<a href="#" id="incomeDeduction13" class="toInform">&nbsp;&nbsp;&nbsp;&nbsp;- 투자조합출자 등</a>
					</td>
					<td>
						<input type="text" name="incomeDeductionValue15" id="incomeDeductionValue15" class="incomeDeductionValue" value='${taxDto.incomeDeductionValue15}'>
					</td>
				</tr>
				<tr class="incomeDeductionTr">
					<td colspan="2">
						<a href="#" id="incomeDeduction14" class="toInform">&nbsp;&nbsp;&nbsp;&nbsp;- 신용카드 등</a>
					</td>
					<td>
						<input type="text" name="incomeDeductionValue16" id="incomeDeductionValue16" class="incomeDeductionValue" value='${taxDto.incomeDeductionValue16}'>
					</td>
				</tr>
				<tr class="incomeDeductionTr">
					<td colspan="2">
						<a href="#" id="incomeDeduction15" class="toInform">&nbsp;&nbsp;&nbsp;&nbsp;- 우리사주조합<br>&nbsp;&nbsp;&nbsp;&nbsp;출연금
						</a>
					</td>
					<td>
						<input type="text" name="incomeDeductionValue17" id="incomeDeductionValue17" class="incomeDeductionValue" value='${taxDto.incomeDeductionValue17}'>
					</td>
				<tr class="incomeDeductionTr">
					<td colspan="2">
						<a href="#" id="incomeDeduction16" class="toInform">&nbsp;&nbsp;&nbsp;&nbsp;- 고용유지 중소<br>&nbsp;&nbsp;&nbsp;&nbsp;기업 근로자
						</a>
					</td>
					<td>
						<input type="text" name="incomeDeductionValue18" id="incomeDeductionValue18" class="incomeDeductionValue" value='${taxDto.incomeDeductionValue18}'>
					</td>
				</tr>
				<tr class="incomeDeductionTr">
					<td colspan="2">
						<a href="#" id="incomeDeduction17" class="toInform">&nbsp;&nbsp;&nbsp;&nbsp;- 장기집합투자<br>&nbsp;&nbsp;&nbsp;&nbsp;증권 저축
						</a>
					</td>
					<td>
						<input type="text" name="incomeDeductionValue19" id="incomeDeductionValue19" class="incomeDeductionValue" value='${taxDto.incomeDeductionValue19}'>
					</td>
				</tr>
				<tr class="incomeDeductionTr">
					<td colspan="2">소계</td>
					<td>
						<input type="text" name="incomeDeductionValue20" id="incomeDeductionValue20" class="incomeDeductionValue" value='${taxDto.incomeDeductionValue20}'>
					</td>
				</tr>
			</table>
			</div>
			

		<div id="taxMainStyle_A8" class="taxMainStyle">
			<input type="button" onclick="finalCalculation();return false;"	value="최종 계산">&nbsp;
			<input type="reset" value="계산 초기화">&nbsp;
			<!-- <input type="submit" onclick="loadTax();return false;" value="불러오기">&nbsp; --> 
			<input type="submit" onclick="submitTax();return false;" value="제출하기">
			<input type="button" onclick="window.print();" value="인쇄하기">&nbsp;
		</div>

	</form>
	</div> --%>
</section>
<script>
	
	//기본정보(입력일자 세팅)
	document.getElementById('defaultInfo4').value = new Date().toISOString().substring(0,10);

	//공제항목 접기, 펼치기(소득공제, 세액공제 항목)
	let folding = document.querySelectorAll(".folding");
	let incomeDeductionTr = document.querySelectorAll(".incomeDeductionTr");
	let taxDeductionTr = document.querySelectorAll(".taxDeductionTr");

	for (let i = 0; i < folding.length; i++) {
		folding[i].addEventListener("click", function() {

			if (folding[i] == folding[0]) {
				if (folding[0].innerText === '-') { 
					incomeDeductionTr[1].style.display = "none";
					incomeDeductionTr[2].style.display = "none";
					folding[0].innerText = '+';

				} else if (folding[0].innerText === '+') {
					incomeDeductionTr[1].style.display = "";
					incomeDeductionTr[2].style.display = "";
					folding[0].innerText = '-';
				}

			} else if (folding[i] == folding[1]) {
				if (folding[1].innerText === '-') {
					incomeDeductionTr[5].style.display = "none";
					incomeDeductionTr[6].style.display = "none";
					incomeDeductionTr[7].style.display = "none";
					incomeDeductionTr[8].style.display = "none";
					incomeDeductionTr[9].style.display = "none";
					incomeDeductionTr[10].style.display = "none";
					folding[1].innerText = '+';

				} else if (folding[1].innerText === '+') {
					incomeDeductionTr[5].style.display = "";
					incomeDeductionTr[6].style.display = "";
					incomeDeductionTr[7].style.display = "";
					incomeDeductionTr[8].style.display = "";
					incomeDeductionTr[9].style.display = "";
					incomeDeductionTr[10].style.display = "";
					folding[1].innerText = '-';
				}

			} else if (folding[i] == folding[2]) {
				if (folding[2].innerText === '-') {
					incomeDeductionTr[7].style.display = "none";
					incomeDeductionTr[8].style.display = "none";
					incomeDeductionTr[9].style.display = "none";
					folding[2].innerText = '+';

				} else if (folding[2].innerText === '+') {
					incomeDeductionTr[7].style.display = "";
					incomeDeductionTr[8].style.display = "";
					incomeDeductionTr[9].style.display = "";
					folding[2].innerText = '-';
				}

			} else if (folding[i] == folding[3]) {
				if (folding[3].innerText === '-') {
					incomeDeductionTr[12].style.display = "none";
					incomeDeductionTr[13].style.display = "none";
					incomeDeductionTr[14].style.display = "none";
					incomeDeductionTr[15].style.display = "none";
					incomeDeductionTr[16].style.display = "none";
					incomeDeductionTr[17].style.display = "none";
					incomeDeductionTr[18].style.display = "none";
					incomeDeductionTr[19].style.display = "none";
					folding[3].innerText = '+';

				} else if (folding[3].innerText === '+') {
					incomeDeductionTr[12].style.display = "";
					incomeDeductionTr[13].style.display = "";
					incomeDeductionTr[14].style.display = "";
					incomeDeductionTr[15].style.display = "";
					incomeDeductionTr[16].style.display = "";
					incomeDeductionTr[17].style.display = "";
					incomeDeductionTr[18].style.display = "";
					incomeDeductionTr[19].style.display = "";
					folding[3].innerText = '-';
				}

			} else if (folding[i] == folding[4]) {
				if (folding[4].innerText === '-') {
					taxDeductionTr[3].style.display = "none";
					taxDeductionTr[4].style.display = "none";
					folding[4].innerText = '+';

				} else if (folding[4].innerText === '+') {
					taxDeductionTr[3].style.display = "";
					taxDeductionTr[4].style.display = "";
					folding[4].innerText = '-';
				}

			} else if (folding[i] == folding[5]) {
				if (folding[5].innerText === '-') {
					taxDeductionTr[6].style.display = "none";
					taxDeductionTr[7].style.display = "none";
					taxDeductionTr[8].style.display = "none";
					folding[5].innerText = '+';

				} else if (folding[5].innerText === '+') {
					taxDeductionTr[6].style.display = "";
					taxDeductionTr[7].style.display = "";
					taxDeductionTr[8].style.display = "";
					folding[5].innerText = '-';
				}

			} else if (folding[i] == folding[6]) {
				if (folding[6].innerText === '-') {
					taxDeductionTr[10].style.display = "none";
					taxDeductionTr[11].style.display = "none";
					taxDeductionTr[12].style.display = "none";
					taxDeductionTr[13].style.display = "none";
					taxDeductionTr[14].style.display = "none";
					folding[6].innerText = '+';

				} else if (folding[6].innerText === '+') {
					taxDeductionTr[10].style.display = "";
					taxDeductionTr[11].style.display = "";
					taxDeductionTr[12].style.display = "";
					taxDeductionTr[13].style.display = "";
					taxDeductionTr[14].style.display = "";
					folding[6].innerText = '-';
				}
			}
		});
	} //괄호닫는 순서 주의

	//함수기능 호출시 ; 나오고 일반적인 선언으로 괄호닫을때는 ;없어야 됨

	//도움말 접기, 펼치기
	function informFolding() {
		console.log("Event");
		let foldingInfo = document.querySelector("#foldingInfo");
		let inform = document.querySelector("#inform");

		if (inform.style.display === "block") {
			inform.style.display = "none"; 
			foldingInfo.innerText = "▼펼치기";

		} else if (inform.style.display === "none") {
			inform.style.display = "block";
			foldingInfo.innerText = "▲접기";
		}
	}

	//총급여,기납부세액 수정 팝업창
	function paymentPopup() {
		var taxPopup1 = window.open("/tax/paymentTaxCalcPopup",
				"paymentTaxCalcPopup", "width=500,height=300");

		if (taxPopup1 == null) {
			alert("팝업이 차단되어 있습니다. 팝업차단을 해제하고 새로고침해 주세요.");
		}
	}

	//소득공제 계산식
	function incomeDeductionCal() {
		let incomeDeductionValue = document
				.querySelectorAll(".incomeDeductionValue");

		incomeDeductionValue[0].value = Number(incomeDeductionValue[1].value)
				+ Number(incomeDeductionValue[2].value);
		incomeDeductionValue[6].value = Number(incomeDeductionValue[7].value)
				+ Number(incomeDeductionValue[8].value)
				+ Number(incomeDeductionValue[9].value);
		incomeDeductionValue[4].value = Number(incomeDeductionValue[5].value)
				+ Number(incomeDeductionValue[6].value)
				+ Number(incomeDeductionValue[10].value);

		let etcSum = 0; //반복문 돌리기전 변수초기화(그밖의소득공제 합계부분 계산)
		for (let i = 12; i < 20; i++) {
			etcSum += Number(incomeDeductionValue[i].value);
		}
		;

		incomeDeductionValue[11].value = etcSum;
		incomeDeductionValue[20].value = Number(incomeDeductionValue[0].value)
				+ Number(incomeDeductionValue[4].value)
				+ Number(incomeDeductionValue[11].value);

	}

	//세액공제 계산식
	function taxDeductionCal() {
		let paymentValue = document.querySelectorAll(".paymentValue");
		let incomeDeductionValue = document
				.querySelectorAll(".incomeDeductionValue");
		let taxDeductionValue = document.querySelectorAll(".taxDeductionValue");

		//근로소득 세액공제 계산식(if~else if문 + if else문+if문)
		//1.산출세액이 130만원 이하일때
		if (Number(paymentValue[3].value) >= 0 && Number(paymentValue[3].value) <= 1300000) {
			taxDeductionValue[1].value = Math
					.round(Number(paymentValue[3].value) * 0.55); // 기본식 세팅(산출세액 130만원 이하)

			if (Number(paymentValue[0].value) <= 33000000) { //그 중 총급여가 3300만원 이하일때
				if (Number(taxDeductionValue[1].value) > 740000) { //구한 세액공제값이 74만원 초과라면
					taxDeductionValue[1].value = 740000; //최대 공제액은 74만원으로 처리
				}
			} else if (Number(paymentValue[0].value) > 33000000
					&& Number(paymentValue[0].value) <= 70000000) { //총급여가 3300~7000일때
				if ((740000 - (Number(paymentValue[0].value) - 33000000) * 0.008) < 660000) { //해당구간 최대한도액 계산결과가 최저한도에 못미치면
					taxDeductionValue[1].value = 660000; //최저한도액 보장
				} else { //한도액 식 적용(최대한도)
					if (Number(taxDeductionValue[1].value) > 740000 - (Number(paymentValue[0].value) - 33000000) * 0.008) { //공제액이 최대한도를 초과하면 
						taxDeductionValue[1].value = 740000 - Math
								.round((Number(paymentValue[0].value) - 33000000) * 0.008); //공제액=최대한도액 적용
					}
				}
			} else { // 총급여 7000만원 초과일때
				if ((660000 - (Number(paymentValue[0].value) - 70000000) * 0.5) < 500000) { //해당구간 한도액 계산결과<최저한도이면
					taxDeductionValue[1].value = 500000; //최저한도액 보장
				} else {
					if (Number(taxDeductionValue[1].value) > 660000 - (Number(paymentValue[0].value) - 70000000) * 0.5) { //공제액이 최대한도 초과하면
						taxDeductionValue[1].value = 660000 - Math
								.round((Number(paymentValue[0].value) - 70000000) * 0.5); //공제액=최대한도액 적용
					}
				}
			}
			//2.산출세액이 130만원 초과일때
		} else if(Number(paymentValue[3].value) > 1300000) {
			taxDeductionValue[1].value = 715000 + Math
					.round((Number(paymentValue[3].value) - 1300000) * 0.3); // 기본식 세팅(산출세액이 130만원 초과일때)

			if (Number(paymentValue[0].value) <= 33000000) { //그 중 총급여가 3300만원 이하일때
				if (Number(taxDeductionValue[1].value) > 740000) { //구한 세액공제값이 74만원 초과라면
					taxDeductionValue[1].value = 740000; //최대 공제액은 74만원으로 처리
				}
			} else if (Number(paymentValue[0].value) > 33000000
					&& Number(paymentValue[0].value) <= 70000000) { //총급여가 3300~7000일때
				if ((740000 - (Number(paymentValue[0].value) - 33000000) * 0.008) < 660000) { //해당구간 최대한도액 계산결과가 최저한도에 못미치면
					taxDeductionValue[1].value = 660000; //최저한도액 보장
				} else { //한도액 식 적용(최대한도)
					if (Number(taxDeductionValue[1].value) > 740000 - (Number(paymentValue[0].value) - 33000000) * 0.008) { //공제액이 최대한도를 초과하면 
						taxDeductionValue[1].value = 740000 - Math
								.round((Number(paymentValue[0].value) - 33000000) * 0.008); //공제액=최대한도액 적용
					}
				}
			} else { // 총급여 7000만원 초과일때
				if ((660000 - (Number(paymentValue[0].value) - 70000000) * 0.5) < 500000) { //해당구간 한도액 계산결과<최저한도이면
					taxDeductionValue[1].value = 500000; //최저한도액 보장
				} else {
					if (Number(taxDeductionValue[1].value) > 660000 - (Number(paymentValue[0].value) - 70000000) * 0.5) { //공제액이 최대한도 초과하면
						taxDeductionValue[1].value = 660000 - Math
								.round((Number(paymentValue[0].value) - 70000000) * 0.5); //공제액=최대한도액 적용
					}
				}
			}
		} else{
			taxDeductionValue[1].value = 0;
		}

		taxDeductionValue[2].value = Number(taxDeductionValue[3].value)
				+ Number(taxDeductionValue[4].value);
		taxDeductionValue[5].value = Number(taxDeductionValue[6].value)
				+ Number(taxDeductionValue[7].value)
				+ Number(taxDeductionValue[8].value);

		//표준세액 공제 적용 여부(전체 완성 이후 수정)		
		if ((Number(incomeDeductionValue[4].value)
				+ Number(taxDeductionValue[10].value)
				+ Number(taxDeductionValue[11].value)
				+ Number(taxDeductionValue[12].value)
				+ Number(taxDeductionValue[13].value) + Number(taxDeductionValue[18].value)) < 130000) {
			taxDeductionValue[14].value = 130000; //값이 숫자인데 굳이 Number함수로 덧씌울필요 없음.
			incomeDeductionValue[4].value = 0;
			//			taxDeductionValue[9].value=0;
			taxDeductionValue[18].value = 0;
		} else {
			taxDeductionValue[14].value = 0;
		}

		let specialSum = 0;
		for (let j = 10; j < 15; j++) {
			specialSum += Number(taxDeductionValue[j].value);
		}

		taxDeductionValue[9].value = specialSum;

		//세액공제 합계식
		taxDeductionValue[19].value = Number(taxDeductionValue[0].value)
				+ Number(taxDeductionValue[1].value)
				+ Number(taxDeductionValue[2].value)
				+ Number(taxDeductionValue[5].value)
				+ Number(taxDeductionValue[9].value)
				+ Number(taxDeductionValue[15].value)
				+ Number(taxDeductionValue[16].value)
				+ Number(taxDeductionValue[17].value)
				+ Number(taxDeductionValue[18].value);

	};

	//최종 계산식(①~⑧)
	function finalCalculation() {
		let paymentValue = document.querySelectorAll(".paymentValue");
		let incomeDeductionValue = document.querySelectorAll(".incomeDeductionValue");
		let taxDeductionValue = document.querySelectorAll(".taxDeductionValue");

		//③과세표준 식(소득공제 종합 한도초과액 있는지 여부에 따른 처리구분)

		 if ((Number(incomeDeductionValue[4].value)
				+ Number(incomeDeductionValue[13].value)
				+ Number(incomeDeductionValue[14].value)
				+ Number(incomeDeductionValue[15].value)
				+ Number(incomeDeductionValue[16].value)
				+ Number(incomeDeductionValue[17].value) + Number(incomeDeductionValue[19].value)) > 25000000) {

			//case1 : 과세표준=근로소득금액(②)-소득공제합+소득공제한도초과액
			if(Number(paymentValue[1].value)
					- Number(incomeDeductionValue[20].value)
					+ ((Number(incomeDeductionValue[4].value)
							+ Number(incomeDeductionValue[13].value)
							+ Number(incomeDeductionValue[14].value)
							+ Number(incomeDeductionValue[15].value)
							+ Number(incomeDeductionValue[16].value)
							+ Number(incomeDeductionValue[17].value) + Number(incomeDeductionValue[19].value)) - 25000000) > 0){
				paymentValue[2].value = Number(paymentValue[1].value)
						- Number(incomeDeductionValue[20].value)
						+ ((Number(incomeDeductionValue[4].value)
								+ Number(incomeDeductionValue[13].value)
								+ Number(incomeDeductionValue[14].value)
								+ Number(incomeDeductionValue[15].value)
								+ Number(incomeDeductionValue[16].value)
								+ Number(incomeDeductionValue[17].value) + Number(incomeDeductionValue[19].value)) - 25000000);
			} else{
				paymentValue[2].value = 0;		   	//과세표준 값이 0 미만일때 처리 
			}
			//소득공제공제한도초과액=특별공제(주택자금공제)+중소기업창업투자조합 출자등에 대한 소득공제(15년 이후 개인이 벤처기업,벤처조합 직접출자분은 제외)+소기업소상공인 공제부금에 대한 소득공제+청약저축,주택청약종합저축에 대한 소득공제+우리사주조합 출자에 대한 소득공제
			//+장기집합투자증권저축 소득공제+신용카드 등 사용금액에 대한 소득공제 	
			
			//case2 : 과세표준=근로소득금액(②)-소득공제합
		} else {
			if(Number(paymentValue[1].value)
					- Number(incomeDeductionValue[20].value) > 0){			
				paymentValue[2].value = Number(paymentValue[1].value)
						- Number(incomeDeductionValue[20].value);
			}else{
				paymentValue[2].value = 0;    		//과세표준 값이 0 미만일때 처리 

			}
		}
		 
		//④산출세액 식(과세표준 구간별 처리 구분)
		/* 		 console.log(paymentValue[2].value);
		 //나중에 음수에 관한 식도 추가해주기(0원 미만일때 처리), 영문이나 한글 등 문자입력할때 입력이 안되는 기능도 추가필요 */
		 if (Number(paymentValue[2].value) > 0 && Number(paymentValue[2].value) <= 12000000 ) {
			paymentValue[3].value = Math
					.round(Number(paymentValue[2].value) * 0.06);
		} else if (Number(paymentValue[2].value) > 12000000
				&& Number(paymentValue[2].value) <= 46000000) {
			paymentValue[3].value = 720000 + Math
					.round((Number(paymentValue[2].value) - 12000000) * 0.15);
		} else if (Number(paymentValue[2].value) > 46000000
				&& Number(paymentValue[2].value) <= 88000000) {
			paymentValue[3].value = 5820000 + Math
					.round((Number(paymentValue[2].value) - 46000000) * 0.24);
		} else if (Number(paymentValue[2].value) > 88000000
				&& Number(paymentValue[2].value) <= 150000000) {
			paymentValue[3].value = 15900000 + Math
					.round((Number(paymentValue[2].value) - 88000000) * 0.35);
		} else if (Number(paymentValue[2].value) > 150000000
				&& Number(paymentValue[2].value) <= 300000000) {
			paymentValue[3].value = 37600000 + Math
					.round((Number(paymentValue[2].value) - 150000000) * 0.38);
		} else if (Number(paymentValue[2].value) > 300000000
				&& Number(paymentValue[2].value) <= 500000000) {
			paymentValue[3].value = 94600000 + Math
					.round((Number(paymentValue[2].value) - 300000000) * 0.4);
		} else if (Number(paymentValue[2].value) > 500000000
				&& Number(paymentValue[2].value) <= 1000000000) {
			paymentValue[3].value = 174600000 + Math
					.round((Number(paymentValue[2].value) - 500000000) * 0.42);
		} else if (Number(paymentValue[2].value) > 1000000000) {
			paymentValue[3].value = 384600000 + Math
					.round((Number(paymentValue[2].value) - 1000000000) * 0.45);
		} else {
			paymentValue[3].value = 0;
 		} 

		//⑤결정세액 식(산출세액-세액감면,세액공제)
		if(Number(paymentValue[3].value)
				- Number(taxDeductionValue[19].value) >= 0){
			paymentValue[4].value = Number(paymentValue[3].value)
			- Number(taxDeductionValue[19].value);
		}else{
			alert("결정세액은 0원 미만일 수 없습니다.")
			paymentValue[4].value = 0;
		}

		//⑥기납부소득세액=paymentValue[5] (총급여 팝업에서 이미 기입해 불러옴)
		//⑦차가감징수납부(환급)예상세액(⑤-⑥)  
		paymentValue[6].value = Number(paymentValue[4].value)
				- Number(paymentValue[5].value);
		//농어촌특별세는 계산 제외함.
	};


	function submitTax() {
		let id = document.querySelector("#id");		//value 빼먹지말기!
		let paymentValue = document.querySelectorAll(".paymentValue");
		let incomeDeductionValue = document.querySelectorAll(".incomeDeductionValue");
		let taxDeductionValue = document.querySelectorAll(".taxDeductionValue");
		
		
		if (Number(paymentValue[0].value == 0) || paymentValue[0].length == 0) {
			alert("필수 계산항목(총급여 및 기납부세액 창)을 입력해주세요!");
			return;
		} else {
			let transYesNo = confirm("입력한 양식을 제출하시겠습니까?");
			if (transYesNo) {
				allTaxForm.method = "post";		//컨트롤러 등록처리와 방식을 맞춰줘야 데이터 전송됨!!!!
				allTaxForm.action = "/tax/register";
				allTaxForm.submit();
			} else {
				alert("취소합니다.");
				return;
			}

		}
	}
</script>

</body>

<jsp:include page="../footer.jsp"/>
