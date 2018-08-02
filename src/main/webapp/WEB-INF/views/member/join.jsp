<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="" name="pageTitle"/>
</jsp:include>

<div style="height: 100px"></div>

<div><h1 style="text-align:center;">MediPot에 오신 것을 환영합니다!</h1></div>
<br><br>

<div style="text-align: center">
	<a href="${pageContext.request.contextPath }/member/joinMember.do">
		<img alt="개인" src="${pageContext.request.contextPath }/resources/img/member/person.PNG">
	</a>
	<%-- <img style="width: 200px"alt="공백" src="${pageContext.request.contextPath }/resources/img/member/white.PNG"> --%>
	<a href="${pageContext.request.contextPath }/member/joinHospitalStart.do">
		<img alt="병원" src="${pageContext.request.contextPath }/resources/img/member/hospital.png">	
	</a>
</div>

<div style="height: 200px"></div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>