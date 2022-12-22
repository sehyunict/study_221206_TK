<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>


<html>


<head>
<meta charset="UTF-8">

<style>
.star-rating {
	display: flex;
	flex-direction: row-reverse;
	font-size: 2.25rem;
	line-height: 2.5rem;
	justify-content: space-around;
	padding: 0 0.2em;
	text-align: center;
	width: 5em;
}

.star-rating input {
	display: none;
}

.star-rating label {
	-webkit-text-fill-color: transparent;
	/* Will override color (regardless of order) */
	-webkit-text-stroke-width: 2.3px;
	-webkit-text-stroke-color: #2b2a29;
	cursor: pointer;
}

.star-rating :checked ~ label {
	-webkit-text-fill-color: gold;
}

.star-rating label:hover, .star-rating label:hover ~ label {
	-webkit-text-fill-color: #fff58c;
}
/* .star-ratings {
	  color: #aaa9a9; 
	  position: relative;
	  unicode-bidi: bidi-override;
	  width: max-content;
	  -webkit-text-fill-color: transparent; /* Will override color (regardless of order) */
-webkit-text-stroke-width:1.3px;
-webkit-text-stroke-color:#2b2a29;
}
.star-ratings-fill {
	color: #fff58c;
	padding: 0;
	position: absolute;
	z-index: 1;
	display: flex;
	top: 0;
	left: 0;
	overflow: hidden;
	-webkit-text-fill-color: gold;
}

.star-ratings-base {
	z-index: 0;
	padding: 0;
}
*
/
</style>

<title>리뷰 수정 페이지</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>

	<div class="container">
		<h2>리뷰 수정</h2>

		<div class="panel-heading"></div>
		<div class="panel-body">
		<table class="table table-hover table-bordered" border="1" width="1500" height="100">
					<tr align="center">

		
			<form action="/updateReview" method="post">
				제목<input type="text" name="reviewTitle">${reviewTitle}<br> 
				내용<input type="text" name="content">${content}<br>
		

				<div class="star-rating space-x-4 mx-auto">${star}
					<input type="radio" id="5-stars" name="star" value=5
						v-model="ratings" /> <label for="5-stars" class="star pr-4">★</label>
					<input type="radio" id="4-stars" name="star" value=4
						v-model="ratings" /> <label for="4-stars" class="star">★</label>
					<input type="radio" id="3-stars" name="star" value=3
						v-model="ratings" /> <label for="3-stars" class="star">★</label>
					<input type="radio" id="2-stars" name="star" value=2
						v-model="ratings" /> <label for="2-stars" class="star">★</label>
					<input type="radio" id="1-star" name="star" value=1
						v-model="ratings" /> <label for="1-star" class="star">★</label>
				</div>
				<button type="submit">리뷰 수정</button>
			</form>
		</table>

		</div>
	</div>

</body>

<!-- <script>

</script> -->
</html>