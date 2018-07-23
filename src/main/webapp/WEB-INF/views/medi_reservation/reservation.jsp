<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>
	<c:set var="path" value="<%=request.getContextPath() %>"/>
     <%
     Date day=new Date();
     SimpleDateFormat today=new SimpleDateFormat("yyyy-MM-dd");
     String today2=today.format(day);%>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="" name="pageTitle"/>
</jsp:include>
 <link href='${path }/resources/css/fullcalendar.min.css' rel='stylesheet' />
<link href='${path }/resources/css/fullcalendar.print.min.css' rel='stylesheet' media='print' />
<script src='${path }/resources/js/moment.min.js'></script>
<script src='${path }/resources/js/jquery.min.js'></script>
<script src='${path }/resources/js/gcal.js'></script>
<script src='${path }/resources/js//lang-all.js'></script>
<script src='${path }/resources/js/fullcalendar.min.js'></script>










<jsp:include page="/WEB-INF/views/common/footer.jsp"/>