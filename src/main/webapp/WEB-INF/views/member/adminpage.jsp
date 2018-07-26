<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="" name="pageTitle"/>
</jsp:include>
<c:if test="${memberLoggedIn.memberId=='admin' }">
<table>
	<tr>
		<td>
			<img src="${pageContext.request.contextPath }/resources/img/member/person.PNG">		
		</td>
		<td>
			<h2>관리자</h2>
		</td>
	</tr>
	<tr>
		<td>
			<img src="${pageContext.request.contextPath }/resources/img/member/hospital.png">
		</td>
		<td rowspan="5">
			<img src="${pageContext.request.contextPath }/resources/img/member/permi.gif">
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

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>