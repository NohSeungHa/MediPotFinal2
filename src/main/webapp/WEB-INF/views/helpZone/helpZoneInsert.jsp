<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>
	<c:set var="path" value="<%=request.getContextPath() %>"/>
     
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="헬프존 질문등록" name="pageTitle"/>
</jsp:include>






<jsp:include page="/WEB-INF/views/common/footer.jsp"/>