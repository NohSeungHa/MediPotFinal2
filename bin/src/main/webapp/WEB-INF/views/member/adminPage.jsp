<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="관리자 페이지" name="pageTitle"/>
</jsp:include>
<c:if test="${memberLoggedIn.memberId=='admin' }">

<div style="height:100px">
	<h1 style="text-align: center">관리자 페이지(병원회원, 일반회원)</h1>
	<h4 style="text-align: center">병원회원과 일반회원을 한번에 관리할 수 있습니다.</h4>
	<c:if test="${hoscnt!=0}">
		<h4 style="text-align: center">현재 승인 대기중인 병원 회원 : <span id="hoscnttext">${hoscnt}명</span></h4>
	</c:if>
	<c:if test="${hoscnt==0}">
		<h4 style="text-align: center">현재 승인 대기중인 병원 회원 : <span id="hoscnttext">없음</span></h4>
	</c:if>
</div>
<br><br>

<table style="margin: 0 auto;">
	<tr>
		<td>
			<a href="${pageContext.request.contextPath }/adminPage/memberList.do">
				<img src="${pageContext.request.contextPath }/resources/img/member/person.PNG"></a>		
		</td>
		<td>
			<a href="${pageContext.request.contextPath }/adminPage/hospitalList.do">
				<img src="${pageContext.request.contextPath }/resources/img/member/hospital.png"></a>
		</td>
	
	</tr>
</table>

</c:if>

<c:if test="${memberLoggedIn.memberId!='admin' }">
	<script>
		$(function(){
			alert("관리자만 접근이 가능합니다.");
			location.href="${pageContext.request.contextPath}";
		})
	</script>
</c:if>




<div style="height:150px"></div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>