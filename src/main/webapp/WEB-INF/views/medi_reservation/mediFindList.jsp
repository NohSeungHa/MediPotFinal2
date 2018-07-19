<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>

	<c:set var='path' value="<%=request.getContextPath() %>"></c:set>
<jsp:include page="/WEB-INF/views/common/header.jsp">
<jsp:param value="HomeSpring" name="pageTitle"></jsp:param>
</jsp:include>
	<div class="container">
	<div id="searchH">
			<img alt="searchImg" src="/pot/resources/img/reser/reser.png" width="60%;" height="380px;">
			<div id="searchH2">
			<form action="${path }/reservation/searchMedi">
			<input type="text" name="Hname" class="form-control" placeholder="병원이름 검색" style="width:140%;">
			<br>
			<button type="submit" class="btn btn-default" style="margin-left:40%;width:50%">검색</button>
			</form>
			</div>
	</div>
	<style>
		#searchH{
			position:relative;
			text-align: center;
		}
		#searchH2{
			position:absolute;
			top:53%;
			left:57%; 
		}
		
		#locList 
		{
			position: relative;
			width: 100%;
			height: 80px;
			padding: 10px;
			background: #FFFFFF;
			-webkit-border-radius: 10px;
			-moz-border-radius: 10px;
			border-radius: 10px;
			border: #00AAFF solid 3px;
			margin-top:10px;
		}
		
		#locList:after 
		{
			content: '';
			position: absolute;
			border-style: solid;
			border-width: 0 22px 14px;
			border-color: #FFFFFF transparent;
			display: block;
			width: 0;
			z-index: 1;
			top: -14px;
			left: 33px;
		}
		
		#locList:before 
		{
			content: '';
			position: absolute;
			border-style: solid;
			border-width: 0 24px 16px;
			border-color: #00AAFF transparent;
			display: block;
			width: 0;
			z-index: 0;
			top: -19px;
			left: 31px;
		}
		.loc,.sub{
			width:100px;
			height:50px;
			font-size:20px;
		}
		
		
		#subjectList 
		{
			position: relative;
			width: 100%;
			height: 80px;
			padding: 10px;
			background: #FFFFFF;
			-webkit-border-radius: 10px;
			-moz-border-radius: 10px;
			border-radius: 10px;
			border: #00AAFF solid 3px;
			margin-top:2px;
		}
		
		#subjectList:after 
		{
			content: '';
			position: absolute;
			border-style: solid;
			border-width: 0 22px 14px;
			border-color: #FFFFFF transparent;
			display: block;
			width: 0;
			z-index: 1;
			top: -14px;
			left: 175px;
		}
		
		#subjectList:before 
		{
			content: '';
			position: absolute;
			border-style: solid;
			border-width: 0 24px 16px;
			border-color: #00AAFF transparent;
			display: block;
			width: 0;
			z-index: 0;
			top: -19px;
			left: 173px;
		}
	</style>
	<br><br><br>
	<div style="margin-bottom:50px;">
	<div>
	<button id="searchLoc" class="btn btn-primary" style="margin-left:1%;width:100px;height:50px;font-size:20px;">지역 검색</button>
	</div>
	<div id="locList" style="display: none;text-align: center;">
		<button class="btn loc">서울</button>
		<button class="btn loc">인천</button>
		<button class="btn loc">경기도</button>
		<button class="btn loc">강원도</button>
		<button class="btn loc">충청도</button>
		<button class="btn loc">전라도</button>
		<button class="btn loc">경상도</button>
		<button class="btn loc">제주도</button>
	</div>
	<div id="subjectList" style="display: none;text-align: center;">
		<button class="btn sub">내과</button>
		<button class="btn sub">이빈후과</button>
	</div>
	</div>
	<script>
		$(function () {
			$("#searchLoc").click(function () {
				$("#subjectList").css("display","none");
				$("#locList").slideToggle(1000);
			});
			
			$(".loc").click(function () {
				$("#subjectList").css("display","none");
				$("#subjectList").slideToggle(1000);
			});
		});
	</script>
		
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>