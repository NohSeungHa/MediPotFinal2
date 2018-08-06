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

		<div>
			<a id="noticeHv" href="${path}/helpZone/helpZoneList.do" style="float: right;">목록으로</a>
			<p style="float: right;">
				<b style="margin-right: 10px;">></b>
			</p>
			<a id="home" href="${path}" style="float: right; width: 70px;">
			<img src="/pot/resources/img/notice/home.jpg" style="width: 30%; height:30%;"> 홈으로</a>
			
		</div>


  <div class="row">    
    <div class="col-md-12">
      <div class="row">
        <div class="col-sm-3 form-group">
          <input class="form-control" id="memberId" name="memberId" placeholder="ID" type="text" readonly>
        </div>
        <div class="col-sm-9 form-group">
          <input class="form-control" id="helpZoneTitle" name="helpZoneTitle" placeholder="질문 제목" type="email" required>
        </div>
      </div>

      <textarea class="form-control" id="helpZoneContent" name="helpZoneContent" placeholder="질문 내용을 작성해주세요. (500자 이내)" 
      rows="15" id="content" style="resize: none;" name="content" onKeyUp="checkLength(this);" onKeyDown="checkLength(this);"></textarea>

      <br>
      <div class="row">
        <div class="col-md-12 form-group">
          <button class="btn btn1 btn-danger pull-right" type="submit">취소</button>
          <button class="btn btn1 btn-info pull-right" style="margin-right:3px"type="submit">등록</button>
          <button class="btn btn1 btn-info pull-left" data-toggle="modal" data-target="#fileModal">첨부파일</button>
     
     
     
          
  <!-- file Modal시작 -->
  <div class="modal fade" id="fileModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Help Zone</h4>
        </div>
        <!-- 첨부파일 등록 버튼-->
        <div class="modal-body">
        <p>질문에 참고될 파일을 등록해주세요.</p>
          <p><input type="file" class="form-control-file border" name="fileName" id="fileName"></p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
       
          
          
          
        </div>
      </div>
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
</script>





<jsp:include page="/WEB-INF/views/common/footer.jsp"/>