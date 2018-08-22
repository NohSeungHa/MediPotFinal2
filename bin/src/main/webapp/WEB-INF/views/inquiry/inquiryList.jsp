<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="<%=request.getContextPath() %>"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value=" " name="pageTitle" />
</jsp:include>
<link href="https://fonts.googleapis.com/css?family=Do Hyeon" rel="stylesheet" type="text/css">
<style>
	tbody tr td:nth-child(2){
		width: 60%;
	}
	#home{
    	float:right;
        width:70px;
        color: black;
        text-decoration: none;
    }
    #home:hover{
    	color: #18bc9c;
    }
    #inquiryHv{
    	float:right;
    }
    #inquiryHv:hover{
    	color: #18bc9c;
    }
    #txt_line{ 
		overflow: hidden; 
		text-overflow: ellipsis;
		white-space: nowrap; 
		width: 500px;
  	}
	th{
		height: 19.556px;
	}
	.panel-heading a{
		text-decoration:none;
	}
	.panel-heading a p{
		color:red;
		float:left;
	}
</style>
<div class="container">
	<img class="img-thumbnail" src="${path}/resources/img/inquiry/inquiryMain.png" style="width: 1200px; height: 300px;"/>
	<br><br>
	<a id="inquiryHv" href="${path}/inquiry/inquiryList.do" style="float: right;">1:1 문의</a>
	<p style="float: right;">
		<b style="margin-right:10px;">></b>
	</p>
	<a id="home" href="${path}" style="float:right;width:70px;"><img
		src="${path}/resources/img/notice/home.jpg"
		style="width: 30%; height: 30%;"> 홈으로</a>
	<br><br>
	<c:if test="${checkPH=='P' and id!='admin' }">
		<c:if test="${not empty memberLoggedIn.memberId}">
			<input type="button" value="1:1문의하기" class="btn btn-success" style="float: right;margin-left: 10px;" data-toggle="modal" data-target="#insertModal"/>
		</c:if>
	</c:if>
	<c:if test="${checkPH=='H' }">
		<c:if test="${not empty memberLoggedIn.hospitalId}">
			<input type="button" value="1:1문의하기" class="btn btn-success" style="float: right;margin-left: 10px;" data-toggle="modal" data-target="#insertModal"/>
		</c:if>
	</c:if>
	<br><br>
	<c:if test="${id!='admin' }">
		<c:if test="${empty list}">
			<h4>1:1 문의가 없습니다.</h4>
		</c:if>
		<c:if test="${not empty list}">
		<div class="panel-group tab-pane fade in active" id="accordion">
			<c:forEach var='inquiry' items='${list }' varStatus="vs">
		    	<div class="panel panel-default">
		      		<div class="panel-heading">
		        		<h4 class="panel-title">
		          			<a data-toggle="collapse" data-parent="#accordion" href="#collapse${inquiry.inquiryNum}">
		          			<c:if test="${inquiry.inquiryAnswerCheck eq 'N' }">
		          				<span class="glyphicon glyphicon-envelope" style="color:#5bc0de; "></span>
		          			</c:if>
		          			<c:if test="${inquiry.inquiryAnswerCheck eq 'Y' }">
		          				<span class="glyphicon glyphicon-envelope" style="color:red; "></span>
		          			</c:if>
		          			&nbsp;${inquiry.inquiryTitle}
		          			<c:if test="${inquiry.inquiryAnswerCheck eq 'N' }">
		          				<span style="float: right;color: #5bc0de;">문의 대기중..</span>
		          			</c:if>
		          			<c:if test="${inquiry.inquiryAnswerCheck eq 'Y' }">
		          				<span style="float: right;color:red;">답변 완료</span>
		          			</c:if>
		          			</a>
		        		</h4>
		      		</div>
		      		<div id="collapse${inquiry.inquiryNum}" class="panel-collapse collapse">
		       			<div class="panel-body">${inquiry.inquiryContent }<br>
		       			<button type="button" class="btn btn-danger btn-sm" style="float: right;margin-left: 10px;" onclick="deleteInquiry('${inquiry.inquiryNum}','${checkPH}','${id}')">문의 삭제하기</button>
		       			<c:if test="${inquiry.inquiryAnswerCheck eq 'N' }">
		          			<button type="button" class="btn btn-warning btn-sm" style="float: right;margin-left: 10px;" data-toggle="modal" data-target="#updateModal" onclick="updateInquiry('${inquiry.inquiryNum}','${inquiry.inquiryTitle}','${inquiry.inquiryContent}')">문의 수정하기</button>
		          		</c:if><br>
		       			<c:if test="${inquiry.inquiryAnswerCheck eq 'Y' }">
		       			<hr>
		       				<span style="color: red;">안녕하십니까, 메디팟입니다.</span><br>
		          			${inquiry.inquiryAnswer }<br>
		          			<span>질문해 주신 문의에 대한 답변은 이상입니다.</span><br>
		          			<span>메디팟을 이용해 주셔서 감사합니다.</span>
		          		</c:if>
		       			</div>
		      		</div>
		    	</div>
	    	</c:forEach>
	  	</div>
	  	</c:if>
  	</c:if>
  	<c:if test="${id=='admin' }">
		<c:if test="${empty list}">
			<h4>1:1 문의가 없습니다.</h4>
		</c:if>
		<c:if test="${not empty list}">
		<div class="panel-group tab-pane fade in active" id="accordion">
			<c:forEach var='inquiry' items='${list }' varStatus="vs">
		    	<div class="panel panel-default">
		      		<div class="panel-heading">
		        		<h4 class="panel-title">
		          			<a data-toggle="collapse" data-parent="#accordion" href="#collapse${inquiry.inquiryNum}">
		          			<c:if test="${inquiry.inquiryAnswerCheck eq 'N' }">
		          				<span class="glyphicon glyphicon-envelope" style="color:#5bc0de; "></span>
		          			</c:if>
		          			<c:if test="${inquiry.inquiryAnswerCheck eq 'Y' }">
		          				<span class="glyphicon glyphicon-envelope" style="color:red; "></span>
		          			</c:if>
		          			&nbsp;${inquiry.inquiryTitle}
		          			<c:if test="${inquiry.inquiryAnswerCheck eq 'N' }">
		          				<span style="float: right;color: #5bc0de;">문의 대기중..</span>
		          			</c:if>
		          			<c:if test="${inquiry.inquiryAnswerCheck eq 'Y' }">
		          				<span style="float: right;color:red;">답변 완료</span>
		          			</c:if>
		          			</a>
		        		</h4>
		      		</div>
		      		<div id="collapse${inquiry.inquiryNum}" class="panel-collapse collapse">
		       			<div class="panel-body">${inquiry.inquiryContent }<br>
		       			<button type="button" class="btn btn-danger btn-sm" style="float: right;margin-left: 10px;" onclick="deleteInquiry('${inquiry.inquiryNum}','${checkPH}','${id}')">문의 삭제하기</button>
		       			<c:if test="${inquiry.inquiryAnswerCheck eq 'N' }">
		          			<button type="button" class="btn btn-success btn-sm" style="float: right;margin-left: 10px;" data-toggle="modal" data-target="#answerModal" onclick="answerInquiry('${inquiry.inquiryNum}','${inquiry.inquiryTitle}')">문의 답변하기</button>
		          		</c:if><br>
		       			<c:if test="${inquiry.inquiryAnswerCheck eq 'Y' }">
		       			<hr>
		       				<span style="color: red;">안녕하십니까, 메디팟입니다.</span><br>
		          			${inquiry.inquiryAnswer }<br>
		          			<span>질문해 주신 문의에 대한 답변은 이상입니다.</span><br>
		          			<span>메디팟을 이용해 주셔서 감사합니다.</span>
		          		</c:if>
		       			</div>
		      		</div>
		    	</div>
	    	</c:forEach>
	  	</div>
	  	</c:if>
  	</c:if>
  	${pageBar }
	<hr>
	<br>
</div>
<script>
function answerInquiry(no,title) {
	$('#answerTitle').val(title);
	$('#answerNo').val(no);
}
function updateInquiry(no,title,content){
	$('#updateTitle').val(title);
	$('#updateNo').val(no);
	$('#updateContent').val(content);
}
function deleteInquiry(no,checkPH,id){
	var del = confirm("해당 문의를 삭제 하시겠습니까?");
	if(del){
		location.href="${path}/inquiry/deleteInquiry.do?no="+no+"&checkPH="+checkPH+"&id="+id;
	}
}
</script>
	<!-- 1:1 문의 하기 -->
		<div class="modal fade" id="insertModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
			<br><br><br><br>
				<div class="modal-content"  style="width: 500px;margin-left: 50px;">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">1:1 문의 하기</h5>
					</div>
					<form action="${path}/inquiry/insertInquiry.do" method="post">
						<div class="modal-body">
							<h4>1:1 문의 제목</h4>
							<h4><input type="text" maxlength="40" id="title" name="title" placeholder="제목을 입력하세요." style="width: 100%;height: 50px;"></h4>
							<h4>1:1 문의 내용</h4>
							<h4><textarea rows="5" id="content" name="content" placeholder="문의 하실 내용을 입력하세요." style="width: 100%;height: 200px;resize: none;" onKeyUp="checkLength(this);" onKeyDown="checkLength(this);"></textarea></h4>
						</div>
						<input type="hidden" value="${checkPH}" id="checkPH" name="checkPH"/>
						<input type="hidden" value="${id}" id="id" name="id"/>
						<div class="modal-footer">
							<button type="submit" class="btn btn-success" onclick="validate()">보내기</button>
							<button type="button" class="btn" data-dismiss="modal">취소</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- 1:1 문의 답변 하기 -->
		<div class="modal fade" id="answerModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
			<br><br><br><br>
				<div class="modal-content"  style="width: 500px;margin-left: 50px;">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">문의에 대한 답변 작성</h5>
					</div>
					<form action="${path}/inquiry/answerInquiry.do" method="post">
						<div class="modal-body">
							<h4>1:1 문의 제목</h4>
							<input type="text" id="answerTitle" name="answerTitle" style="width: 100%;height: 50px;" readonly/>
							<input type="hidden" id="answerNo" name="answerNo"/>
							<h4>1:1 답변 내용</h4>
							<h4><textarea rows="5" id="answerContent" name="answerContent" placeholder="문의 답변을 작성하세요." style="width: 100%;height: 200px;resize: none;" onKeyUp="checkLength(this);" onKeyDown="checkLength(this);"></textarea></h4>
						</div>
						<input type="hidden" value="${checkPH}" id="checkPH" name="checkPH"/>
						<input type="hidden" value="${id}" id="id" name="id"/>
						<div class="modal-footer">
							<button type="submit" class="btn btn-success" onclick="validate2()">답변 하기</button>
							<button type="button" class="btn" data-dismiss="modal">취소</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- 1:1 문의 수정 하기 -->
		<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
			<br><br><br><br>
				<div class="modal-content"  style="width: 500px;margin-left: 50px;">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">1:1 문의 수정</h5>
					</div>
					<form action="${path}/inquiry/updateInquiry.do" method="post">
						<div class="modal-body">
							<h4>1:1 문의 제목</h4>
							<input type="text" id="updateTitle" name="updateTitle" style="width: 100%;height: 50px;" readonly/>
							<input type="hidden" id="updateNo" name="updateNo"/>
							<h4>1:1 답변 내용</h4>
							<h4><textarea rows="5" id="updateContent" name="updateContent" placeholder="문의 하실 내용을 입력하세요." style="width: 100%;height: 200px;resize: none;" onKeyUp="checkLength(this);" onKeyDown="checkLength(this);"></textarea></h4>
						</div>
						<input type="hidden" value="${checkPH}" id="checkPH" name="checkPH"/>
						<input type="hidden" value="${id}" id="id" name="id"/>
						<div class="modal-footer">
							<button type="submit" class="btn btn-success" onclick="updateDate()">수정 하기</button>
							<button type="button" class="btn" data-dismiss="modal">취소</button>
						</div>
					</form>
				</div>
			</div>
		</div>
<script>
function checkLength(comment) {
    if (comment.value.length > 1000 ) {
        comment.blur();
        comment.value = comment.value.substring(0, 1000);
        comment.focus();
        return false;
    }
}
function validate() {
	var content=$("[name=content]").val();
	var title=$("[name=title]").val();
	if(title.trim().length==0) {
		alert("제목을 입력하세요!");
		return false;
	}else if(content.trim().length==0) {
		alert("내용을 입력하세요!");
		return false;
	}
	return true;
}
function validate2() {
	var content=$("[name=answerContent]").val();
	if(content.trim().length==0) {
		alert("내용을 입력하세요!");
		return false;
	}
	return true;
}
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />