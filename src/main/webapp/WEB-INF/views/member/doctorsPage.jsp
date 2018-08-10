<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="" name="pageTitle"/>
</jsp:include>
<div><h1 style="text-align: center">의사정보</h1></div>
<hr>
<c:if test="${memberLoggedIn == null }">
	<script>
		$(function(){
			alert("잘못된 접근입니다.");
			location.href="${pageContext.request.contextPath}";
		})	
	</script>
</c:if>
<c:forEach var="docs" items="${docinfo }" varStatus="vs">
	<div style="display: inline-block; margin: 0 0 0 30px">
		<img class="bj" src="/pot/resources/uploadfile/dortors/${docs.doctorRePhoto }" style="width: 300px; height: 300px" onclick="selectdoctor()">
		<input type='hidden' value='${docs.doctorNum }'>
		<h3 style="margin-left: 85px">의사 :&nbsp;${docs.doctorName } </h3>
	</div>
	
	<script>
		$('.bj').click(function(){
			var num = $(this).next().attr("value");
			location.href="${pageContext.request.contextPath}/member/selectdoctor.do?doctorNum="+num;
		})
	</script>
</c:forEach>




<jsp:include page="/WEB-INF/views/common/footer.jsp"/>