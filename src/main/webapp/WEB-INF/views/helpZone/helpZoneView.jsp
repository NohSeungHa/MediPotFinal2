<%@page import="com.medi.pot.member.model.vo.Member"%>
<%@page import="com.medi.pot.helpZone.vo.HelpZoneComment"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>
	<c:set var="path" value="<%=request.getContextPath() %>"/>
	<%List<HelpZoneComment> helpZoneCommentList = (List)request.getAttribute("helpZoneCommentList"); %>
     
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="헬프존 조회" name="pageTitle"/>
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
	<a id="helpZoneHv" href="${path}/helpZone/helpZoneList.do" style="float: right;">헬프존</a>
	<p style="float: right;">
		<b style="margin-right:10px;">></b>
	</p>
	<a id="home" href="${path}" style="float:right;width:70px;"><img
		src="${path }/resources/img/notice/home.jpg"
		style="width: 30%; height: 30%;"> 홈으로</a>
		<br><br>
		
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
					<td><img src="${path}/resources/uploadfile/helpZone/${helpZone.helpZoneReFile}" style="width: 300px; height: 200px"></td>
				</tr>
			</tbody>
		</table>		
		
	<c:if test="${checkPH=='P'}" >
			<c:if test="${memberLoggedIn.memberId == helpZoneQuestioner.memberId }">
				<button type="button" onclick="helpZoneUpdate()" class="btn btn-success btn-lg" style="float: right; margin-left: 10px;">수정</button> 
				<button type="button" onclick="helpZoneDelete()" class="btn btn-danger btn-lg" style="float: right; margin-left: 10px;">삭제</button>
			</c:if>
	</c:if>
	
<hr><!-- 댓글등록창 -->
<div id="comment-container">
	<div id="comment-content-container">
		<table id="tbl-comment">
			<%if(helpZoneCommentList!=null){ 
			for(HelpZoneComment hzComment : helpZoneCommentList) {
				if(hzComment.getHzCommentLevel()==1){%>
				<tr class="level1">
					<td>
						<sub class="comment-writer"><%=hzComment.getHzCommentWriterNum() %></sub>
						<sub class="comment-date"><%=hzComment.getHzCommentDate() %></sub>
						<br><%=hzComment.getHzCommentContent() %>
					</td>
					
					<td>
						<button class='btn-reply' value="<%=hzComment.getHzCommentNum() %>">답글</button>
						<c:if test="${memberLoggedIn.memberId == hzCommentWriterNum.memberId }">
							<button class='btn-delete' value="<%=hzComment.getHzCommentNum()%>">삭제</button>
						</c:if>
					<%} %>
					</td>
				</tr>
				<%} %>
				<%else{ %>
				<tr class="level2">
					<td>
						<sub style="font-size: 15px;font-weight: bold">ㄴ</sub><sub class="comment-writer"><%=hzComment.getHzCommentWriterNum() %></sub>
					</td>
				</tr>
				
		</table>
	</div><!-- comment-content-container -->
</div><!-- comment-container -->


</div>
<br><br>
<script>
/* 게시글 수정 함수 */
function helpZoneUpdate(){
	location.href="${path}/helpZone/updateHelpZone.do?num=${helpZone.helpZoneNum}";
}

/* 게시글 삭제 함수 */
function helpZoneDelete(){
	if(confirm("정말 게시글을 정말 삭제하시겠습니까?")){
	location.href="${path}/helpZone/deleteHelpZone.do?num=${helpZone.helpZoneNum}";
	}else{
		return false;
	}
}

function checkLength(comment) {
    if (comment.value.length > 1000 ) {
        comment.blur();
        comment.value = comment.value.substring(0, 1000);
        comment.focus();
        return false;
    }
}
/* 게시글 작성 메서드 */
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

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>