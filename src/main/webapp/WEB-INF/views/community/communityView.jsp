<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="<%=request.getContextPath() %>"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value=" " name="pageTitle" />
</jsp:include>
<style>
        tbody tr th{
            background-color: #2c3e50;
            color:white;
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
        #communityHv{
            float:right;
        }
        #communityHv:hover{
            color: #18bc9c;
        }
        .fileAction:hover{
        	color:red;
        }
    </style>
<div class="container">
  <br><br>
  <img class="img-thumbnail" src="/pot/resources/img/community/communityMain.jpg" style="width:100%; height:270px;">
	<br><br>
	<a id="communityHv" href="${path}/community/communityList.do" style="float: right;">자유게시판</a>
	<p style="float: right;">
		<b style="margin-right:10px;">></b>
	</p>
	<a id="home" href="${path}" style="float:right;width:70px;"><img
		src="/pot/resources/img/notice/home.jpg"
		style="width: 30%; height: 30%;"> 홈으로</a>
	<table class="table table-bordered">
		<tbody>
      <tr>
        <th><h4>작성일</h4></th>
        <td><h4>${com.communityDate}</h4></td>
        <th><h4>조회수</h4></th>
        <td><h4>${com.communityReadcount}</h4></td>
    </tr>
      <tr>
        <th><h4>작성자</h4></th>
        <td colspan="3"><h4>${com.communityWriter }</h4></td>
      </tr>
      <tr>
        <th><h4>제목</h4></th>
        <td colspan="3"><h4>${com.communityTitle}</h4></td>
      </tr>
      <tr>
        <td colspan="4" style="height: 300px; max-height: 700px;max-width:300px;max-height:700px;"><h4 style="word-break:break-all;">${com.communityContent}</h4></td>
      </tr>
	  <c:if test="${com.communityFile!=null}">
	  <tr>
	  	<th><h4>첨부파일</h4></th>
	    <td colspan="3"><img src="/pot/resources/img/notice/fileImge1.jpg" style="margin-left:10px;margin-top:-10px; width: 20px;height:20px;display: inline-block;">&nbsp;<h4 class="fileAction" style="display: inline-block;cursor: pointer;" onclick="fileDownload('${com.communityFile}','${com.communityRefile }')">${com.communityFile}</h4></td>
	  </tr>
	  </c:if>
    </tbody>
  </table>
  <hr>
  <input type="hidden" id="communityNum" value="${com.communityNum}"/>
  <input type="hidden" id="cp" value="${cp}"/>
  <c:if test="${not empty memberLoggedIn}">
  <!-- 댓글modal -->
		<div class="modal-body" style="border: 1px solid lightgray;">
		<input type="hidden" name="commentNo" id="commentNo" value="${com.communityNum}"/>
			<c:if test="${checkPH=='P'}">
				<p type="text" id="commentPwriter" readonly>&nbsp;${memberLoggedIn.memberId}</p>
				<input type="hidden" id="commentPwriter2" value="${memberLoggedIn.memberId}"/>
			</c:if>
			<c:if test="${checkPH=='H'}">
				<p type="text" id="commentHwriter" readonly>&nbsp;${memberLoggedIn.hospitalId}</p>
				<input type="hidden" id="commentHwriter2" value="${memberLoggedIn.hospitalId}"/>
			</c:if>
			<textarea class="form-control" style="width: 88%;height: 100px;resize: none; float: left; border: 1px solid lightgray;" id="commentContent" name="commentContent" onKeyUp="checkLength(this);" onKeyDown="checkLength(this);" placeholder="댓글을 입력하세요.(500자이내) 불쾌감을 주는 욕설과 악플은 삭제될 수 있습니다."></textarea>
			<button id="communityInsert" type="submit" class="btn btn-success" style="height:100px; width:100px; margin-left: 10px;">댓글 등록</button>
		</div>
	</c:if>
  	<br>
  	<!-- 댓글  -->
  	<h2>댓글</h2>
  
  <div id="cc2s" class="modal-body" >
  <c:if test="${not empty cc2}">
  	<c:forEach var='cc' items='${cc2 }' varStatus="vs">
		<p id="commentWriter" readonly>작성자 : ${cc.commentWriter} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;작성일 : ${cc.commentDate }</p>
		<p id="commentContent2" name="commentContent2">&nbsp;${cc.commentContent }</p>
  		<hr>
  	</c:forEach>
  	${pageBar }
  	</c:if>
  	</div>
  	
 	<c:if test="${empty searchContent }">
		<button type="button" class="btn btn-success" onclick="list()">목록으로</button>
	</c:if>
	<c:if test="${not empty searchContent }">
		<button type="button" class="btn btn-success" onclick="searchList()">목록으로</button>
	</c:if>
	<c:if test="${checkPH=='P'}">
		<c:if test="${memberLoggedIn.memberId eq com.communityWriter and com.communityCheckPH eq 'P' or memberLoggedIn.memberId eq 'admin'}">
			<input type="button" value="삭제" class="btn btn-danger" style="float: right;margin-left: 10px;" data-toggle="modal" data-target="#deleteModal"/>
	  		<c:if test="${memberLoggedIn.memberId eq com.communityWriter}">
		  		<button type="button" class="btn btn-warning" style="float: right;margin-left: 10px;" onclick="crystal()">수정</button>
				<script>
					function crystal(){
						location.href="${path}/community/communityUpdate.do?cPage=${cp}&no=${com.communityNum}";
					}
				</script>
			</c:if>
	  	</c:if>
  	</c:if>
  	<c:if test="${checkPH=='H'}">
		<c:if test="${memberLoggedIn.hospitalId eq com.communityWriter and com.communityCheckPH eq 'H' or memberLoggedIn.memberId eq 'admin'}">
			<input type="button" value="삭제" class="btn btn-danger" style="float: right;margin-left: 10px;" data-toggle="modal" data-target="#deleteModal"/>
	  		<c:if test="${memberLoggedIn.hospitalId eq com.communityWriter}">
	  			<button type="button" class="btn btn-warning" style="float: right;margin-left: 10px;" onclick="crystal()">수정</button>
				<script>
					function crystal(){
						location.href="${path}/community/communityUpdate.do?cPage=${cp}&no=${com.communityNum}";
					}
				</script>
			</c:if>
	  	</c:if>
  	</c:if>
  <br><br>
  <table class="table table-bordered table-sm" style="border: 2px solid lightgray;">
        <tbody>
        	<c:if test="${empty searchContent }">
	        	<c:if test="${communityBefore!=null}">
	            		<tr>
	                		<td style="width: 10%;text-align:center;"><h4> <b>∧</b> 이전</h4></td>
	                		<td><h4><a href='${path}/community/communityView.do?no=${communityBefore.communityNum }&cp=${cp}'> ${communityBefore.communityTitle }</a></h4></td>
	            		</tr>
	            </c:if>
	            <c:if test="${communityNext!=null}">
			            <tr>
			                <td style="width: 10%;text-align:center;"><h4> <b>∨</b> 다음</h4></td>
			                <td><h4><a href='${path}/community/communityView.do?no=${communityNext.communityNum }&cp=${cp}'> ${communityNext.communityTitle }</a></h4></td>
			            </tr>
	            </c:if>
            </c:if>
            <c:if test="${not empty searchContent }">
	        	<c:if test="${communityBefore!=null}">
	            		<tr>
	                		<td style="width: 10%;text-align:center;"><h4> <b>∧</b> 이전</h4></td>
	                		<td><h4><a href='${path}/community/communityView.do?no=${communityBefore.communityNum }&cp=${cp}&searchKind=${searchKind}&searchContent=${searchContent}'> ${communityBefore.communityTitle }</a></h4></td>
	            		</tr>
	            </c:if>
	            <c:if test="${communityNext!=null}">
			            <tr>
			                <td style="width: 10%;text-align:center;"><h4> <b>∨</b> 다음</h4></td>
			                <td><h4><a href='${path}/community/communityView.do?no=${communityNext.communityNum }&cp=${cp}&searchKind=${searchKind}&searchContent=${searchContent}'> ${communityNext.communityTitle }</a></h4></td>
			            </tr>
	            </c:if>
            </c:if>
        </tbody>
      </table>
</div>
<br>
<script>
	function list(){
		location.href="${path}/community/communityList.do?cPage=${cp}";
	}
	function searchList(){
		location.href="${path}/community/communitySearch.do?cPage=${cp}&searchKind=${searchKind}&searchContent=${searchContent}";
	}
	function fileDownload(oName, rName){
        //한글파일명이 있을 수 있으므로, 명시적으로 encoding
	    oName = encodeURIComponent(oName);
        location.href="${path}/community/fileDownload.do?oName="+oName+"&rName="+rName;
    }
	function checkLength(comment) {
	    if (comment.value.length > 500 ) {
	        comment.blur();
	        comment.value = comment.value.substring(0, 500);
	        comment.focus();
	        return false;
	    }
	}
	$('#communityInsert').click( function() {
		var writer =null;
		var comment = $('#commentContent').val();
		var communityNum = $('#communityNum').val();
		var cp = $('#cp').val();
		if(${checkPH=='P'}){
			writer = $('#commentPwriter2').val();
		}
		if(${checkPH=='H'}){
			writer = $('#commentHwriter2').val();
		}
		  
		var allData = { "writer": writer, "comment": comment, "communityNum":communityNum, "cp":cp };
		  $.ajax({
				url:"${path}/community/insertCommunityComment.do",
				type:'post',
				data: allData,
				dataType:"html",
				success:function(data){
					alert("댓글 등록 완료!");
				   	$('#commentContent').val("");
				   	$('#cc2s').html(data);
				}
	   	})
	   	
	});
</script>
<!-- 삭제 modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">게시물 삭제 확인</h5>
			</div>
			<form action="${path}/community/deleteCommunity.do" method="post">
				<div class="modal-body">
					<h1>게시물을 삭제 하시겠습니까?</h1>
					<h3 style="color: red;">주의) 삭제한 게시물은 복구 할 수 없습니다.</h3>
					<h3 style="color: red;">&nbsp;&nbsp;&nbsp;&nbsp;게시물의 업로드 파일도 같이 삭제 됩니다.</h3>
					<input type="hidden" name="no" value="${com.communityNum}"/>
					<input type="hidden" name="refile" value="${com.communityRefile}"/>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-danger">삭제</button>
					<button type="button" class="btn" data-dismiss="modal">취소</button>
				</div>
			</form>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />