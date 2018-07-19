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
			<img alt="searchImg" src="/pot/resources/img/reser/reser.png" width="60%;" height="400px;">
			<div id="searchH2">
			<input type="text" class="form-control" placeholder="병원이름 검색" style="width:10%;">
			<br>
			<button type="submit" class="btn btn-default">검색</button>
			</div>
	</div>
	<style>
		#searchH{
			position:relative;
		}
		#searchH2{
			position:absolute;
			top:60%;
			left:35%; 
		}
	</style>
	<br><br><br>
	<div>
	<button id="searchLoc" class="btn btn-primary">지역 검색</button>
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
		
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>