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
	  <h2 class="text-center">질문 등록 중....</h2>
  </div>
</div>
<br><br>

<!-- Container (Contact Section) -->
<div class="container">
	<br>
	<a id="noticeHv" href="${path}/notice/noticeList.do?checkPH=${chPH}" style="float: right;">공지사항</a>
	<p style="float: right;">
		<b style="margin-right:10px;">></b>
	</p>
	<a id="home" href="${path}" style="float:right;width:70px;"><img
		src="/pot/resources/img/notice/home.jpg"
		style="width: 30%; height: 30%;"> 홈으로</a>
	<form name="noticeFrm" action="${path}/notice/noticeInsertEnd.do?checkPH=${chPH}" method="post" onsubmit="return validate();"  enctype="multipart/form-data" >
		<table class="table table-bordered">
			<tbody>
				<tr>
					<th>제목:</th>
					<td><input type="text" placeholder="제목을 입력하세요.(100자 이내)" name="title" id="title"
						class="form-control" maxlength="40" /></td>
				</tr>
				<tr>
					<th>작성자:</th>
					<td><input type="text" name="writer"  id="writer" class="form-control"
						value="${memberLoggedIn.memberId }" style="background-color: white;" readonly /></td>
				</tr>
				<tr>
					<th>키워드</th>
					<td>
						<label class="checkbox-inline"><input type="checkbox" value="건강" name="">건강</label>
						<label class="checkbox-inline"><input type="checkbox" value="치료" name="">치료</label>
						<label class="checkbox-inline"><input type="checkbox" value="기타" name="">기타</label>
					</td>
				</tr>
				<tr>
					<th>내용:</th>
					<td><textarea style="resize: none; height: 350px;" class="form-control" placeholder="내용을 입력하세요.(500자이내)"
							rows="5" id="comment" name="content" onKeyUp="checkLength(this);" onKeyDown="checkLength(this);"></textarea></td>
				</tr>
				<tr>
					<th>첨부파일:</th>
					<td><input type="file" class="form-control-file border"
						name="fileName" id="fileName"></td>
				</tr>
			</tbody>
		</table>
		<button type="button" onclick="noticeList()" class="btn btn-danger btn-lg" style="float: right; margin-left: 10px;">취소</button> 
		<input type="submit" value="등록" onclick="return validate();" class="btn btn-primary btn-lg" style="float: right;"/>
		</form>
		<button type="button" class="btn btn-success btn-lg" onclick="helpZoneList()">목록으로</button>
</div>
<br><br>
<script>
function helpZoneList() {
	location.href="${path}/helpZone/helpZoneList.do";
}
function checkLength(comment) {
    if (comment.value.length > 1000 ) {
        comment.blur();
        comment.value = comment.value.substring(0, 1000);
        comment.focus();
        return false;
    }
}
</script>





<jsp:include page="/WEB-INF/views/common/footer.jsp"/>