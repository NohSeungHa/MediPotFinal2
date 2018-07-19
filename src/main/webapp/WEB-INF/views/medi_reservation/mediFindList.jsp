<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>

	<c:set var='path' value="<%=request.getContextPath() %>"></c:set>
<jsp:include page="/WEB-INF/views/common/header.jsp">
<jsp:param value="HomeSpring" name="pageTitle"></jsp:param>
</jsp:include>
	<div id="searchH">
			<input type="text" size="30">
	</div>
	<style>
		#searchH{
			margin-left:400px;
			text-align:center;
			padding-left:430px;
			padding-top:250px;
			background-image: url("/pot/resources/img/reser/reser.png");
			width:850px;
			height:450px;
			background-size:cover;
			background-repeat:no-repeat;
		
		}
	</style>
	<br><br><br>
	<div style="text-align: center;">
	<button id="searchLoc" class="btn">지역 검색</button>
	</div>
	<div id="locList" style="display: none;text-align: center;border:2px solid lightgray;">
		<button class="btn loc">서울</button>
		<button class="btn loc">인천</button>
		<button class="btn loc">경기도</button>
		<button class="btn loc">강원도</button>
		<button class="btn loc">충청도</button>
		<button class="btn loc">전라도</button>
		<button class="btn loc">경상도</button>
		<button class="btn loc">제주도</button>
	</div>
	<div id="subjectList" style="display: none;text-align: center;border:2px solid lightgray;">
		<button class="btn">내과</button>
		<button class="btn">이빈후과</button>
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
		

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>