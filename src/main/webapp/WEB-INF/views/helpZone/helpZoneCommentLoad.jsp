<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>
	<c:set var="path" value="<%=request.getContextPath() %>"/>
	
	<c:if test="${checkPH==P }">
		<input type="hidden" id="checkPH" value="P"/>
	</c:if>
	<c:if test="${checkPH==H }">
		<input type="hidden" id="checkPH" value="H"/>
	</c:if>
	<ul class="nav nav-tabs">
    <li id="commentM"><a data-toggle="tab" href="#member">일반회원 댓글만 보기</a></li>
    <li id="commentH"><a data-toggle="tab" href="#hospital">병원회원 댓글만 보기</a></li>
  </ul>
  <div class="tab-content">
  <div id="member" class="tab-pane fade">
  <br><br>
  <c:if test="${empty hzMember2 }">
  	<p>일반회원 댓글이 없습니다.</p>
  </c:if>
<c:forEach var='hz' items='${hzMember2 }' varStatus="vs">
		<p id="commentWriter" readonly>작성자 : 일반회원 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;작성일 : ${hz.hzCommentDateM }
			<c:if test="${checkPH=='P' }">
			<c:if test="${hz.hzCommentWriterNumM eq memberLoggedIn.memberNum and memberLoggedIn.memberId != 'admin' }">
				<a data-toggle="modal" data-target="#deleteComment" style="color: red;float: right;" onclick="deleteCommentNum(${hz.hzCommentM})">&nbsp;&nbsp;&nbsp;댓글 삭제</a>
			</c:if>
			<c:if test="${memberLoggedIn.memberId eq 'admin'}">
				<a data-toggle="modal" data-target="#deleteComment" style="color: red;float: right;" onclick="deleteCommentNum(${hz.hzCommentM})">&nbsp;&nbsp;&nbsp;댓글 삭제</a>
			</c:if>
			</c:if>
		</p>
		<p id="commentContent2" name="commentContent2">&nbsp;${hz.hzCommentContentM }</p>
  		<hr>
  	</c:forEach>
  	${pageBarM }
  	</div>
  	<div id="hospital" class="tab-pane fade">
    <br><br>
    <c:if test="${empty hzHospital2 }">
      <p>병원회원 댓글이 없습니다.</p>
    </c:if>
    <c:forEach var='hz' items='${hzHospital2 }' varStatus="vs">
		<p id="commentWriter" readonly>작성자 : 병원회원 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;작성일 : ${hz.hzCommentDateH }
			<c:if test="${checkPH=='H' }">
			<c:if test="${hz.hzCommentWriterNumH eq memberLoggedIn.hospitalNum}">
				<a data-toggle="modal" data-target="#deleteComment" style="color: red;float: right;" onclick="deleteCommentNum(${hz.hzCommentContentH})">&nbsp;&nbsp;&nbsp;댓글 삭제</a>
			</c:if>
			</c:if>
		</p>
		<p id="commentContent2" name="commentContent2">&nbsp;${hz.hzCommentContentH }</p>
  		<hr>
  	</c:forEach>
  	${pageBarH }
    </div>
    </div>
    
    <script>
	$(function(){
		var checkPH = $('#checkPH').val();
		if(checkPH=='P'){
			$('#commentM').addClass('active');
			$('#member').addClass('in active');
		}
		if(checkPH=='H'){
			$('#commentH').addClass('active');
			$('#hospital').addClass('in active');
		}
	})
	</script>