<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="" name="pageTitle"/>
</jsp:include>

<style>
	.findIdStyle{
		border: 5px solid #00aeef;
		border-top-left-radius: 50px;
		border-bottom-left-radius: 50px;
		border-top-right-radius: 50px;
		border-bottom-right-radius: 50px;
		width: 500px;
		height: 500px;
		margin: 0 auto;
	}
</style>

<div style="height: 100px"></div>

<div class="findIdStyle">
	<h1 style="text-align: center">아이디 찾기 결과</h1>
	&nbsp;<h3>아이디 : <span style="color: #5A2EF4">${findid }</span></h3>
</div>

<div style="height: 100px"></div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>