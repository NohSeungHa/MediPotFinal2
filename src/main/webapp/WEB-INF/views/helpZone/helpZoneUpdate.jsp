<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>
	<c:set var="path" value="<%=request.getContextPath() %>"/>
     
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="헬프존수정" name="pageTitle"/>
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
		
	<form name="helpZoneUpdateFrm" action="${path}/helpZone/helpZoneUpdateEnd.do" method="post" enctype="multipart/form-data" >	
	<table class="table table-bordered">
			<tbody>
				<tr>
					<th>제목:</th>
					<td><input type="text" name="helpZoneTitle" id="helpZoneTitle" value="${helpZone.helpZoneTitle }" class="form-control" maxlength="40" /></td>
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
						<c:if test="${helpZone.helpZoneKeyWord eq '건강' }">
							<label class="checkbox-inline"><input type="radio" value="건강"  id="helpZoneKeyWord" checked>건강</label>
							<label class="checkbox-inline"><input type="radio" value="치료" id="helpZoneKeyWord">치료</label>
							<label class="checkbox-inline"><input type="radio" value="기타"  id="helpZoneKeyWord">기타</label>
						</c:if>
						<c:if test="${helpZone.helpZoneKeyWord eq '치료' }">
							<label class="checkbox-inline"><input type="radio" value="건강"  id="helpZoneKeyWord">건강</label>
							<label class="checkbox-inline"><input type="radio" value="치료"  id="helpZoneKeyWord" checked>치료</label>
							<label class="checkbox-inline"><input type="radio" value="기타"  id="helpZoneKeyWord">기타</label>
						</c:if>	
						<c:if test="${helpZone.helpZoneKeyWord eq '기타' }">
							<label class="checkbox-inline"><input type="radio" value="건강"  id="helpZoneKeyWord">건강</label>
							<label class="checkbox-inline"><input type="radio" value="치료"  id="helpZoneKeyWord">치료</label>
							<label class="checkbox-inline"><input type="radio" value="기타"  id="helpZoneKeyWord" checked>기타</label>
						</c:if>
						<input type="hidden" value="${helpZone.helpZoneKeyWord }" name="helpZoneKeyWord"/>
					</td>
				</tr>
				<tr>
					<th>내용:</th>
					<td><textarea style="resize: none; height: 200px;" class="form-control" rows="5" id="helpZoneContent" name="helpZoneContent" onKeyUp="checkLength(this);" onKeyDown="checkLength(this);">${helpZone.helpZoneContent }</textarea>							
					</td>
				</tr>
				<tr><!-- 첨부사진 -->
					<th>첨부사진:</th>
					<td>
						<img src="${path}/resources/uploadfile/helpZone/${helpZone.helpZoneReFile}" style="width: 300px; height: 200px">
						<input type="file" class="form-control-file border" name="newFileName" id="newFileName">
						<input type="hidden" name="oldFileName" id="oldFileName" value="${helpZone.helpZoneFile }">
						<input type="hidden" name="oldReFileName" id="oldReFileName" value="${helpZone.helpZoneReFile }">
					</td>
				</tr>
			</tbody>
		</table>

		<input type="hidden" id="helpZoneQuestioner" name="helpZoneQuestioner" value="${helpZone.helpZoneQuestioner}">
		<input type="hidden" id="num" name="num" value="${helpZone.helpZoneNum}">

	<c:if test="${checkPH=='P'}" >
			<c:if test="${memberLoggedIn.memberId == helpZoneQuestioner.memberId }">
				<input type="submit" value="완료" onclick="return validate();" class="btn btn-info btn-lg" style="float: right; margin-left: 10px;"/>
				<button type="button" onclick="helpZoneList()" class="btn btn-danger btn-lg" style="float: right; margin-left: 10px;">취소</button> 
			</c:if>
	</c:if>
	</form>
		<button type="button" class="btn btn-success btn-lg" onclick="helpZoneList()">목록으로</button>
	
</div>
</body>
<br><br>
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
	var content=$("[name=helpZoneContent]").val();
	var title=$("[name=helpZoneTitle]").val();
	if(title.trim().length==0) {
		alert("제목을 입력하세요!");
		return false;
	}else if(content.trim().length==0) {
		alert("내용을 입력하세요!");
		return false;
	}
	return true;
}

/* 게시글 리스트 출력 함수 */
function helpZoneList() {
	location.href="${path}/helpZone/helpZoneList.do";
}
</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>