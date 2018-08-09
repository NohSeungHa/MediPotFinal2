<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="<%=request.getContextPath() %>"/>
<c:forEach var='cc' items='${cc2 }' varStatus="vs">
	<p id="commentWriter" readonly>작성자 : ${cc.commentWriter} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;작성일 : ${cc.commentDate }</p>
	<p id="commentContent2" name="commentContent2">&nbsp;${cc.commentContent }</p>
	<hr>
</c:forEach>
${pageBar }