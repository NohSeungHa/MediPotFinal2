<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>
	<c:set var="path" value="<%=request.getContextPath() %>"/>
     
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="헬프존 질문등록" name="pageTitle"/>
</jsp:include>
	<style>
	.jumbotron {
      margin-bottom: 0;
      background-image : url('${path}/resources/img/helpZone/jumbotron2.jpg');
      background-size: cover;
    }
	.btn1 {
      padding: 10px 20px;
      color: #f1f1f1;
      border-radius: 1;
      transition: .2s;
 	}
  	.btn1:hover, .btn1:focus {
      background-color: #fff;
      color: #000;
  	}
  	.container2 h1,h2{
  		color: white;
  		
  	}

  </style>
	
	
<body>
<!-- 점보트론 -->
<div class="jumbotron">
  <div class="container2">
	  <h1 class="text-center">WelCome to HelpZone!</h1>
	  <br><br>
  </div>
</div>
<br><br>

<!-- Container (Contact Section) -->
<div class="container">
	<br>
	<a id="noticeHv" href="${path}/helpZone/helpZoneList.do" style="float: right;">공지사항</a>
	<p style="float: right;">
		<b style="margin-right:10px;">></b>
	</p>
	<a id="home" href="${path}" style="float:right;width:70px;"><img
		src="/pot/resources/img/notice/home.jpg"
		style="width: 30%; height: 30%;"> 홈으로</a>
	<form name="helpZoneFrm" action="${path}/helpZone/helpZoneInsertEnd.do" method="post" onsubmit="return validate();"  enctype="multipart/form-data" >
		<table class="table table-bordered">
			<tbody>
				<tr>
					<th>제목:</th>
					<td><input type="text" name="helpZoneTitle" id="helpZoneTitle" value="${helpZone.helpZoneTitle }" class="form-control" maxlength="40"  readonly/></td>
				</tr>
				<tr>
					<th>작성자:</th>
					<td><input type="text" name="writer"  id="writer" value="${helpZoneQuestioner.memberId }" class="form-control"
						style="background-color: white;" readonly />
					</td>
				</tr>
				<tr>
					<th>키워드</th>
					<td>
						<label class="form-control" readonly><c:out value="${helpZone.helpZoneKeyWord }"/></label>
					
					</td>
				</tr>
				<tr>
					<th>내용:</th>
					<td><textarea style="resize: none; height: 200px;" class="form-control"
							rows="5" id="helpZoneContent" name="helpZoneContent" readonly>${helpZone.helpZoneContent }</textarea>							
					</td>
				</tr>
				<tr><!-- 첨부사진 올려주기 -->
					<th>첨부사진:</th>
					<td></td>
				</tr>
			</tbody>
		</table>
			
		</form>
		<button type="button" class="btn btn-success btn-lg" onclick="helpZoneList()">목록으로</button>
	<c:if test="${checkPH=='P'}" >
			<c:if test="${memberLoggedIn.memberId == helpZoneQuestioner.memberId }">
				<button type="button" onclick="helpZoneUpdate()" class="btn btn-success btn-lg" style="float: right; margin-left: 10px;">수정</button> 
				<!-- <button type="button" onclick="helpZoneDelete()" class="btn btn-danger btn-lg" style="float: right; margin-left: 10px;">삭제</button>  -->
				<input type="button" value="삭제" class="btn btn-danger btn-lg" style="float: right; margin-left: 10px;" data-toggle="modal" data-target="#deleteModal"/>
			</c:if>
	</c:if>
	
	<c:if test="${checkPH=='H'}">
	</c:if>
</div>
<br><br>
<script>
function helpZoneList() {
	location.href="${path}/helpZone/helpZoneList.do";
}
function helpZoneDelete() {
	location.href="${path}/helpZone/helpZoneDelete.do";
}
function checkLength(comment) {
    if (comment.value.length > 1000 ) {
        comment.blur();
        comment.value = comment.value.substring(0, 1000);
        comment.focus();
        return false;
    }
}
function validate(){
	var content=$("[name=helpZoneContent]").val();
	var title=$("[name=helpZoneTitle]").val();
	if(title.trim().length==0){
		alert("제목을 입력하세요!");
		return false;
	}else if(content.trim().length==0){
		alert("내용을 입력하세요!");
		return false;
	}
	return true;
}
</script>
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">게시물 삭제 확인</h5>
					</div>
					<form
						action="${path}/helpZone/deleteHelpZone.do"
						method="post">
						<div class="modal-body">
							<h1>게시물을 삭제 하시겠습니까?</h1>
							<h3 style="color: red;">주의) 삭제한 게시물은 복구 할 수 없습니다.</h3>
							<h3 style="color: red;">&nbsp;&nbsp;&nbsp;&nbsp;게시물의 업로드 파일도 같이 삭제 됩니다.</h3>
							<c:if test="${ckPH=='H' }">
							<input type="hidden" name="no" value="${helpZone.helpZoneNum}"/>
							<input type="hidden" name="refile" value="${helpZone.helpZoneRefile}"/>
							</c:if>
							<c:if test="${ckPH=='P' }">
							<input type="hidden" name="no" value="${helpZone.helpZoneNum}"/>
							<input type="hidden" name="refile" value="${helpZone.helpZoneRefile}"/>
							</c:if>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-danger">삭제</button>
							<button type="button" class="btn"
								data-dismiss="modal">취소</button>
						</div>
					</form>
				</div>
			</div>
		</div>




<jsp:include page="/WEB-INF/views/common/footer.jsp"/>