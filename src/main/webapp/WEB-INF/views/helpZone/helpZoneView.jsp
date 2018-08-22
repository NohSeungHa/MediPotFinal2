<%@page import="com.medi.pot.member.model.vo.Member"%>
<%@page import="com.medi.pot.helpZone.vo.HelpZoneCommentHospital"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>
	<c:set var="path" value="<%=request.getContextPath() %>"/>
     
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
	<a id="home" href="${path}" style="float:right;width:70px;">
	<img src="${path }/resources/img/notice/home.jpg" style="width: 30%; height: 30%;"> 홈으로</a>
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
						<label class="form-control"><c:out value="${helpZone.helpZoneKeyWord }"/></label>
					
					</td>
				</tr>
				<tr>
					<th>내용:</th>
					<td><textarea style="resize: none; height: 200px;" class="form-control"
							rows="5" id="helpZoneContent" name="helpZoneContent" readonly>${helpZone.helpZoneContent }</textarea>							
					</td>
				</tr>
				<c:if test="${helpZone.helpZoneReFile != null}">
				<tr><!-- 첨부사진 올려주기 -->
					<th>첨부사진:</th>
					<td><img id="imghover" src="${path}/resources/uploadfile/helpZone/${helpZone.helpZoneReFile}" style="width: 300px; height: 200px"></td>
				</tr>
				</c:if>
			</tbody>
		</table>		
		
	<c:if test="${checkPH=='P'}" >
			<c:if test="${memberLoggedIn.memberId == helpZoneQuestioner.memberId }">
				<button type="button" onclick="helpZoneUpdate()" class="btn btn-success btn-lg" style="float: right; margin-left: 10px;">수정</button> 
				<button type="button" onclick="helpZoneDelete()" class="btn btn-danger btn-lg" style="float: right; margin-left: 10px;">삭제</button>
			</c:if>
	</c:if>
<br><br>	
<hr><!-- 1. 댓글등록창 시작 -->
<input type="hidden" id="helpZoneNum" value="${helpZone.helpZoneNum }"/>
<c:if test="${not empty memberLoggedIn }">
	<div class="modal-body" style="border: 1px solid lightgray;">
		<input type="hidden" name="hzCommentNumH" id="hzCommentNumH" value="${helpZone.helpZoneNum }"/>
		<input type="hidden" name="hzCommentNumM" id="hzCommentNumM" value="${helpZone.helpZoneNum }"/>
		<!-- 일반회원으로 로그인했을때  -->
		<c:if test="${checkPH=='P' }">
			<p id="hzCommentWriter">&nbsp;${memberLoggedIn.memberId }</p>
			<input type="hidden" id="hzCommentWriterM" value="${memberLoggedIn.memberNum }"/>
			<input type="hidden" id="checkPH" value="P"/>
			<input type="hidden" id="cPageM" value="${cPageM }"/>
		</c:if>
		<!-- 병원회원으로 로그인했을때 -->
		<c:if test="${checkPH=='H' }">
			<p id="hzCommentWriter">&nbsp;${memberLoggedIn.hospitalId }</p>
			<input type="hidden" id="hzCommentWriterH" value="${memberLoggedIn.hospitalNum}"/>
			<input type="hidden" id="checkPH" value="H"/>
			<input type="hidden" id="cPageH" value="${cPageH }"/>
		</c:if>
		<textarea class="form-control" style="width: 88%;height: 100px;resize: none; float: left; border: 1px solid lightgray;" id="helpZoneComment" name="helpZoneComment" onKeyUp="checkLength(this);" onKeyDown="checkLength(this);" placeholder="댓글을 입력하세요.(500자이내) 불쾌감을 주는 욕설과 악플은 삭제될 수 있습니다."></textarea>
		<button id="helpZoneCommentInsert" type="submit" class="btn btn-success" style="height:100px; width:100px; margin-left: 10px;">댓글 등록</button>			
	</div>
</c:if>
<br>
<!-- 댓글 리스트 나오는곳 -->
<h3>**댓글보기**</h3>
<div id="hzc" class="modal-body">
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
	<c:if test="${not empty hzMember2 }">
	<c:forEach var='hzm' items='${hzMember2 }' varStatus="vs">
		<p id="commentWriter">작성자 : <span id="memberCustomer" style="margin-right: 100px">일반회원</span> 작성일 : ${hzm.hzCommentDateM }
			<c:if test="${checkPH=='P' }">
				<c:if test="${hzm.hzCommentWriterNumM eq memberLoggedIn.memberNum and memberLoggedIn.memberId != 'admin' }">
					<a id="sendNumM${hzm.hzCommentNumM }" data-toggle="modal" data-target="#deleteComment" style="color: red;float: right;" onclick="deleteCommentNum('${hzm.hzCommentNumM}')">&nbsp;&nbsp;&nbsp;댓글 삭제</a>
					<input id="sendDeleteCommentNumM${hzm.hzCommentNumM}" type="hidden" value="${hzm.hzCommentNumM}">
				</c:if>
				<c:if test="${memberLoggedIn.memberId eq 'admin'}">
					<a id="sendNumM${hzm.hzCommentNumM }" data-toggle="modal" data-target="#deleteComment" style="color: red;float: right;" onclick="deleteCommentNum('${hzm.hzCommentNumM}')">&nbsp;&nbsp;&nbsp;댓글 삭제</a>
					<input id="sendDeleteCommentNumM${hzm.hzCommentNumM}" type="hidden" value="${hzm.hzCommentNumM}">
				</c:if>
			</c:if>
		</p>
		<p>&nbsp;${hzm.hzCommentContentM }</p>
  		<hr>
	</c:forEach>
	${pageBarM }
	</c:if>
    </div>
    <div id="hospital" class="tab-pane fade">
    <br><br>
    <c:if test="${empty hzHospital2 }">
      <p>병원회원 댓글이 없습니다.</p>
    </c:if>
    <c:if test="${not empty hzHospital2 }">
	<c:forEach var='hzh' items='${hzHospital2 }' varStatus="vs">
		<p id="commentWriter">작성자 : <span id="hospitalCustomer" style="margin-right: 100px">병원회원</span> 작성일 : ${hzh.hzCommentDateH }
		<c:if test="${checkchoice==true && choiceWriter.hzCommentWriterNumH==hzh.hzCommentWriterNumH && choiceWriter.hzCommentChoice==hzh.hzCommentChoice }">
			<br>
			<span style="color: orange; font-size: 15pt;">채택된 병원회원의 댓글입니다.</span>
		</c:if>
		<c:if test="${checkPH=='P' }">
			<c:if test="${checkchoice==false && helpZoneQuestioner.memberId eq memberLoggedIn.memberId }">
				<a id="choiceFalse${hzh.hzCommentNumH }" data-toggle="modal" data-target="#choiceComment" style="color: red;float: right;" onclick="sendComment('${hzh.hzCommentNumH }')">&nbsp;&nbsp;&nbsp;채택하기</a>
				<input id="sendCommentNum${hzh.hzCommentNumH }" type="hidden" value="${hzh.hzCommentNumH }">
			</c:if>
		</c:if>
			<c:if test="${checkPH=='H' }">
				<c:if test="${hzh.hzCommentWriterNumH eq memberLoggedIn.hospitalNum}">
					<a data-toggle="modal" data-target="#deleteComment" style="color: red;float: right;" onclick="deleteCommentNum('${hzh.hzCommentNumH}')">&nbsp;&nbsp;&nbsp;댓글 삭제</a>
					<input id="sendDeleteCommentNumH${hzh.hzCommentNumH}" type="hidden" value="${hzh.hzCommentNumH}">
				</c:if>
			</c:if>
		</p>
		<p>&nbsp;${hzh.hzCommentContentH }</p>
  		<hr>
	</c:forEach>
	${pageBarH }
	</c:if>
    </div>
	</div>
</div>

</div>
<br><br>

<script>
var flagM=${flagM};
var flagH=${flagH};

if(flagM!=0){
   $(function(){
      $('html, body').animate({
         scrollTop: $('#hzc').offset().top
         }, 'slow');
      });   
}

if(flagH!=0){
   $(function(){
      $('html, body').animate({
         scrollTop: $('#hzc').offset().top
         }, 'slow');
      });   
}

function sendComment(num){
	var checkPH = $('#checkPH').val();
	if(checkPH=='P'){
		var sendCommentNum = $('#sendCommentNum'+num).val();
		$('#receiveCommentNum').val(sendCommentNum);
	}
}


function deleteCommentNum(num){
	var checkPH = $('#checkPH').val();
	if(checkPH=='P'){
		var sendDeleteCommentMNum = $('#sendDeleteCommentNumM'+num).val();
		$('#receiveDeleteCommentNumM').val(sendDeleteCommentMNum);	
	}
	if(checkPH=='H'){
		var sendDeleteCommentHNum = $('#sendDeleteCommentNumH'+num).val();
		$('#receiveDeleteCommentNumH').val(sendDeleteCommentHNum);		
	}
}

$(function(){
	var checkPH = $('#checkPH').val();
	if(checkPH=='P' || checkPH==null ){
		$('#commentM').addClass('active');
		$('#member').addClass('in active');
	}
	if(checkPH=='H'){
		$('#commentH').addClass('active');
		$('#hospital').addClass('in active');
	}
});

/* $(function(){
	var cPageM = $('#cPageM').val();
	var cPageH = $('#cPageH').val();
	var hzc = $('#hzc');
	$('#M'+cPageM).click(function(){
		hzc.offset({top: 800});
	});
	$('#H'+cPageH).click(function(){
		hzc.offset({top: 800});
	});
}); */

/* 게시글 수정 함수 */
function helpZoneUpdate(){
	location.href="${path}/helpZone/updateHelpZone.do?num="+${helpZone.helpZoneNum};
}

/* 게시글 삭제 함수 */
function helpZoneDelete(){
	if(confirm("정말 게시글을 정말 삭제하시겠습니까?")){
		location.href="${path}/helpZone/deleteHelpZone.do?num="+${helpZone.helpZoneNum};
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

/* 댓글작성 메서드 */
$('#helpZoneCommentInsert').click(function() {
	var writer = 0;
	var comment = $('#helpZoneComment').val();
	var helpZoneNum = $('#helpZoneNum').val();
	var checkPH = $('#checkPH').val();
	if(checkPH=='P'){
		writer = $('#hzCommentWriterM').val();
	}
	if(checkPH=='H'){
		writer = $('#hzCommentWriterH').val();
	}
	
	location.href="${path}/helpZone/insertHelpZoneComment.do?writer="+writer+"&comment="+comment+"&helpZoneNum="+helpZoneNum+"&checkPH="+checkPH;
 	
});
</script>

<!-- 채택 modal 시작 -->
<div class="modal fade" id="choiceComment" tabindex="-1" role="dialog"
         aria-labelledby="exampleModalLabel" aria-hidden="true">
         <div class="modal-dialog" role="document">
            <div class="modal-content">
               <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalLabel">채택하기</h5>
                  <button style="margin-top: -25px" type="button" class="close" data-dismiss="modal"
                     aria-label="Close">
                     X
                  </button>
               </div>
               <form action="${path}/helpZone/helpZoneChoice.do" method="post">
                  <div class="modal-body">
                    <br>
					<h3>해당 병원회원의 글을 채택하시겠습니까?</h3>
					<br>
					<input id="receiveCommentNum" type="hidden" name="hzCommentNumH">
					<input type="hidden" name="hzNumH" value="${no }">
                  </div>
                  <div class="modal-footer">
                     
                     <button type="submit" class="btn btn-outline-success">확인</button>
                     <button type="button" class="btn btn-outline-success"
                        data-dismiss="modal">취소</button>
                  </div>
               </form>
            </div>
         </div>
      </div>
      
      <!-- 댓글삭제 modal 시작 -->
	<div class="modal fade" id="deleteComment" tabindex="-1" role="dialog"
         aria-labelledby="exampleModalLabel" aria-hidden="true">
         <div class="modal-dialog" role="document">
            <div class="modal-content">
               <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalLabel">삭제하기</h5>
                  <button style="margin-top: -25px" type="button" class="close" data-dismiss="modal"
                     aria-label="Close">
                     X
                  </button>
               </div>
               <form
                  action="${path}/helpZone/deleteHelpZoneComment.do"
                  method="post">
                  <div class="modal-body">
                    <br>
					<h3>해당 댓글을 삭제하시겠습니까?</h3>
					<br>
					<c:if test="${checkPH=='P' }">
						<input id="receiveDeleteCommentNumM" type="hidden" name="hzCommentNum" value="0">
					</c:if>
					<c:if test="${checkPH=='H' }">
						<input id="receiveDeleteCommentNumH" type="hidden" name="hzCommentNum" value="0">
					</c:if>
					<input type="hidden" name="hzNum" value="${no }">
					<input type="hidden" name="checkPH" value="${checkPH }">
                  </div>
                  <div class="modal-footer">
                     
                     <button type="submit" class="btn btn-outline-success">확인</button>
                     <button type="button" class="btn btn-outline-success"
                        data-dismiss="modal">취소</button>
                  </div>
               </form>
            </div>
         </div>
      </div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>