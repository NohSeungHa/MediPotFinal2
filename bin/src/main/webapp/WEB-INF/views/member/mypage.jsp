<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="" name="pageTitle"/>
</jsp:include>

<c:if test="${checkPH=='P' }">
	<h2>개인회원의 마이페이지</h2>
	
</c:if>

<!-- 마이페이지를 나눔 -->

<c:if test="${checkPH=='H' }">
	<h2>병원회원의 마이페이지</h2>
	
</c:if>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>