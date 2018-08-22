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
	<c:forEach var='hzm' items='${hzMember2 }' varStatus="vs">
		<p id="commentWriter">작성자 : <span id="memberCustomer" style="margin-right: 100px">일반회원</span> 작성일 : ${hzm.hzCommentDateM }
			<c:if test="${checkPH=='P' }">
				<c:if test="${hzm.hzCommentWriterNumM eq memberLoggedIn.memberNum and memberLoggedIn.memberId != 'admin' }">
					<a data-toggle="modal" data-target="#deleteComment" style="color: red;float: right;" onclick="deleteCommentNum('${hzm.hzCommentNumM}')">&nbsp;&nbsp;&nbsp;댓글 삭제</a>
					<input id="sendDeleteCommentNumM${hzm.hzCommentNumM}" type="hidden" value="${hzm.hzCommentNumM}">
				</c:if>
				<c:if test="${memberLoggedIn.memberId eq 'admin'}">
					<a data-toggle="modal" data-target="#deleteComment" style="color: red;float: right;" onclick="deleteCommentNum('${hzm.hzCommentNumM}')">&nbsp;&nbsp;&nbsp;댓글 삭제</a>
					<input id="sendDeleteCommentNumM${hzm.hzCommentNumM}" type="hidden" value="${hzm.hzCommentNumM}">
				</c:if>
			</c:if>
		</p>
		<p>&nbsp;${hzm.hzCommentContentM }</p>
  		<hr>
	</c:forEach>
  	${pageBarM }
  	</div>
  	<div id="hospital" class="tab-pane fade">
    <br><br>
    <c:if test="${empty hzHospital2 }">
      <p>병원회원 댓글이 없습니다.</p>
    </c:if>
    <c:forEach var='hzh' items='${hzHospital2 }' varStatus="vs">
		<p id="commentWriter">작성자 : <span id="hospitalCustomer" style="margin-right: 100px">병원회원</span> 작성일 : ${hzh.hzCommentDateH }
		<c:if test="${checkchoice==true && choiceWriter.hzCommentWriterNumH==hzh.hzCommentWriterNumH && choiceWriter.hzCommentChoice==hzh.hzCommentChoice }">
			<br>
			<span style="color: orange; font-size: 15pt;">채택된 병원회원의 댓글입니다.</span>
		</c:if>
		<c:if test="${checkPH=='P' }">
			<c:if test="${checkchoice==false }">
				<a id="choiceFalse" data-toggle="modal" data-target="#choiceComment" style="color: red;float: right;" onclick="sendComment('${hzh.hzCommentNumH }')">&nbsp;&nbsp;&nbsp;채택하기</a>
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
    </div>
    </div>
    
    <script>
    var flagM=${flagM};
    var flagH=${flagH};

    if(flagM!=0){
       $(function(){
          $('html, body').animate({
             scrollTop: $('#commentMain').offset().top
             }, 'slow');
          });   
    }

    if(flagH!=0){
       $(function(){
          $('html, body').animate({
             scrollTop: $('#commentMain').offset().top
             }, 'slow');
          });   
    }
    
    function sendComment(num){
    	$('#sendCommentNum'+num).click(function(){
    		var sendCommentNum = $('#sendCommentNum'+num).val();
    		$('#receiveCommentNum').val(sendCommentNum);
    	});
    }

    function deleteCommentNum(num){
    	$('#sendDeleteCommentNumM'+num).click(function(){
    		var sendDeleteCommentNum = $('#sendDeleteCommentNumM'+num).val();
    		$('#receiveDeleteCommentNumM').val(sendCommentNum);
    	});
    	$('#sendDeleteCommentNumH'+num).click(function(){
    		var sendDeleteCommentNum = $('#sendDeleteCommentNumH'+num).val();
    		$('#receiveDeleteCommentNumH').val(sendCommentNum);
    	});
    }
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
               <form
                  action="${pageContext.request.contextPath}/helpZone/helpZoneChoice.do"
                  method="post">
                  <div class="modal-body">
                     <br><br>
					<h3>해당 병원회원의 글을 채택하시겠습니까?</h3>
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
                  action="${pageContext.request.contextPath}/helpZone/deleteHelpZoneComment.do"
                  method="post">
                  <div class="modal-body">
                     <br><br>
					<h3>해당 댓글을 삭제하시겠습니까?</h3>
					<c:if test="${checkPH=='P' }">
						<input id="receiveDeleteCommentNumM" type="hidden" name="hzCommentNum">
					</c:if>
					<c:if test="${checkPH=='H' }">
						<input id="receiveDeleteCommentNumH" type="hidden" name="hzCommentNum">
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