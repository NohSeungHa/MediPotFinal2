<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>






<c:set var="path" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="${path }/resources/js/bootstrap.js"></script>


<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width", initial-scale="1">
	<title>메디팟 인덱스</title>
	<link rel="stylesheet" href="${path }/resources/css/bootstrap.css"><!-- 외부 스타일 시트 -->
	<link rel="stylesheet" href="${path }/resources/css/medipotFinal.css">
	<link href="http://fonts.googleapis.com/css?family=Jua" rel="stylesheet">
	
	<!-- Main Javascript 시작-->          
    <script type="text/javascript" src="assets/plugins/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>     
    <script type="text/javascript" src="assets/plugins/stickyfill/dist/stickyfill.min.js"></script>                                                                
    <script type="text/javascript" src="assets/js/main.js"></script>
    <!-- Main Javascript 끝 -->
</head>
<body>
	<style type="text/css">/*내부 스타일 시트 적용*/
		.jumbotron
		{
			background-image: url('/pot/resources/img/common/hopital.jpg'); 
			background-size: cover;
			text-shadow: black 0.2em 0.2em 0.2em;
			color : white;
		}
		*{
			font-family:Jua;
		}
	</style>


	<!-- 3강 네비게이션 바  -->
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" 
						data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<!-- 네비게이션 바 메디팟 로고  -->
				<a class="navbar-brand" href="${path }/"><img src="/pot/resources/img/common/MediPot_logo.png" width="250px" height="60px" style="margin-left:30%;margin-top: 4%;" ></a>
			</div>
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<!-- 검색창 만들기 -->
				<form class="navbar-form navbar-left" style="margin-top: 2%;margin-left:5%;">
					<input type="text" class="form-control" placeholder="병원이름 검색">
					<button type="submit" class="btn btn-default">검색</button>
				</form>
				<!-- 검색창만들기 끝 -->

				<ul class="nav navbar-nav navbar-right" style="margin-top:2.5%;margin-right:1%;">
					<li><a href="reservation.html">로그인</a></li>
					<li><a href="reservation.html">회원가입</a></li>
				</ul>


				<!-- 드롭다운 메뉴 -->
				<ul class="nav navbar-nav navbar-right" style="font-size:35px;margin-top:2.5%;margin-right:2%;">
					<li><a href="${path}/medi/medireser.do">병원예약</a></li>
					<!-- 드랍다운 메뉴 만들기 기본 셋팅-->
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
						고객지원<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">공지사항</a></li>
							<li><a href="#">자주묻는 질문</a></li>
							<li><a href="#">자유게시판</a></li>
						</ul>
					</li>
						<li><a href="#">HELP ZONE</a></li>
				</ul>			
			</div>

		</div>		
	</nav>