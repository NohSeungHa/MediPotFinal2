<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="<%=request.getContextPath() %>"/>
<c:forEach var='cc' items='${cc2 }' varStatus="vs">
		<p id="commentWriter" readonly>작성자 : ${cc.commentWriter} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;작성일 : ${cc.commentDate }
		<c:if test="${checkPH=='P'}">
			<c:if test="${cc.commentWriter eq memberLoggedIn.memberId and memberLoggedIn.memberId != 'admin' }">
				<a data-toggle="modal" data-target="#deleteComment" style="color: red;float: right;">&nbsp;&nbsp;&nbsp;댓글 삭제</a>
			</c:if>
			<c:if test="${memberLoggedIn.memberId eq 'admin'}">
				<a data-toggle="modal" data-target="#deleteComment" style="color: red;float: right;">&nbsp;&nbsp;&nbsp;댓글 삭제</a>
			</c:if>
		</c:if>
		<c:if test="${checkPH=='H'} ">
			<c:if test="${cc.commentWriter eq memberLoggedIn.hospitalId}">
				<a data-toggle="modal" data-target="#deleteComment" style="color: red;float: right;">&nbsp;&nbsp;&nbsp;댓글 삭제</a>
			</c:if>
		</c:if>
		</p>
		<p id="commentContent2" name="commentContent2">&nbsp;${cc.commentContent }</p>
  		<hr>
  		<!-- 댓글 삭제 modal -->
		<div class="modal fade" id="deleteComment" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">댓글 삭제 확인</h5>
					</div>
					<form action="${path}/community/deleteComment.do" method="post">
						<div class="modal-body">
							<h1>댓글을 삭제 하시겠습니까?</h1>
							<h3 style="color: red;">주의) 삭제한 댓글은 복구 할 수 없습니다.</h3>
							<input type="hidden" id="no2" name="no2" value="${no2}"/>
							<input type="hidden" id="cp2" name="cp2" value="${cp2}"/>
							<input type="hidden" id="commentNum" name="commentNum" value="${cc.commentNum}"/>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-danger">삭제</button>
							<button type="button" class="btn" data-dismiss="modal">취소</button>
						</div>
					</form>
				</div>
			</div>
		</div>
  	</c:forEach>
${pageBar }