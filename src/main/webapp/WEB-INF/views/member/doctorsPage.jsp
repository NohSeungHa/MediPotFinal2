<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="" name="pageTitle"/>
</jsp:include>
<c:forEach var="docs" items="${docinfo }">
	<img src="/pot/resources/uploadfile/dortors/${docs.doctorRePhoto }" style="width: 300px; height: 300px">
</c:forEach>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>