<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="<%=request.getContextPath() %>"/>
<h2 id="commentMain">댓글</h2>
<c:forEach var='cc' items='${cc2 }' varStatus="vs">
		<p id="commentWriter" readonly>작성자 : ${cc.commentWriter} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;작성일 : ${cc.commentDate }
		<c:if test="${cc.commentCheckPH eq checkPH and checkPH eq 'P'}">
			<c:if test="${cc.commentWriter eq memberLoggedIn.memberId and memberLoggedIn.memberId != 'admin' }">
				<a data-toggle="modal" data-target="#deleteComment" style="color: red;float: right;" onclick="deleteCommentNum(${cc.commentNum})">&nbsp;&nbsp;&nbsp;댓글 삭제</a>
			</c:if>
			<c:if test="${memberLoggedIn.memberId eq 'admin'}">
				<a data-toggle="modal" data-target="#deleteComment" style="color: red;float: right;" onclick="deleteCommentNum(${cc.commentNum})">&nbsp;&nbsp;&nbsp;댓글 삭제</a>
			</c:if>
		</c:if>
		<c:if test="${cc.commentCheckPH eq checkPH and checkPH eq 'H'}">
			<c:if test="${cc.commentWriter eq memberLoggedIn.hospitalId}">
				<a data-toggle="modal" data-target="#deleteComment" style="color: red;float: right;" onclick="deleteCommentNum(${cc.commentNum})">&nbsp;&nbsp;&nbsp;댓글 삭제</a>
			</c:if>
		</c:if>
		</p>
		<p id="commentContent2" name="commentContent2">&nbsp;${cc.commentContent }</p>
  		<hr>
  	</c:forEach>
${pageBar }