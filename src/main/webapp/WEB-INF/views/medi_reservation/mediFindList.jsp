<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>

	<c:set var='path' value="<%=request.getContextPath() %>"></c:set>
<jsp:include page="/WEB-INF/views/common/header.jsp">
<jsp:param value="HomeSpring" name="pageTitle"></jsp:param>
</jsp:include>
	<div style="text-align: center;">
		<label for="hname">병원 이름으로 검색</label>
		<input type="text" name="hname" id="hname" size="50">
		<button class="btn">검색</button>
	</div>
	<br><br><br>
	<div style="text-align: center;">
	<button id="searchLoc" class="btn">지역 검색</button>
	</div>
	<div id="locList" style="display: none;text-align: center;border:2px solid lightgray;">
		<button class="btn">서울</button>
		<button class="btn">인천</button>
		<button class="btn">경기도</button>
		<button class="btn">강원도</button>
		<button class="btn">충청도</button>
		<button class="btn">전라도</button>
		<button class="btn">경상도</button>
		<button class="btn">제주도</button>
	</div>
	<div>
		<button></button>
	</div>
	<script>
		$(function () {
			$("#searchLoc").click(function () {
				$("#locList").slideToggle(1000);
			});
		});
	</script>
		

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>