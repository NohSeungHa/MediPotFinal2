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
        #noticeHv{
            float:right;
        }
        #noticeHv:hover{
            color: #18bc9c;
        }
        .fileAction:hover{
        	color:red;
        }
    </style>
<div class="container">
  <br><br>
  <img class="img-thumbnail" src="${path}/resources/img/notice/hnoticeMain.jpg" style="width:100%; height:270px;">
	<br><br>
	<a id="noticeHv" href="${path}/notice/noticeList.do?checkPH=${ckPH}" style="float: right;">공지사항</a>
	<p style="float: right;">
		<b style="margin-right:10px;">></b>
	</p>
	<a id="home" href="${path}" style="float:right;width:70px;"><img
		src="${path}/resources/img/notice/home.jpg"
		style="width: 30%; height: 30%;"> 홈으로</a>
	<table class="table table-bordered">
		<tbody>
		<c:if test="${ckPH=='H'}">
      <tr>
        <th><h4>작성일</h4></th>
        <td><h4>${notice.hospitalNoticeDate}</h4></td>
        <th><h4>조회수</h4></th>
        <td><h4>${notice.hospitalNoticeReadcount}</h4></td>
    </tr>
      <tr>
        <th><h4>작성자</h4></th>
        <td colspan="3"><h4>관리자</h4></td>
      </tr>
      <tr>
        <th><h4>제목</h4></th>
        <td colspan="3"><h4>${notice.hospitalNoticeTitle}</h4></td>
      </tr>
      <tr>
        <td colspan="4" style="height: 300px; max-height: 700px;max-width:300px;max-height:700px;"><h4 style="word-break:break-all;">${notice.hospitalNoticeContent}</h4></td>
      </tr>
	      <c:if test="${notice.hospitalNoticeFile!=null}">
	      	<tr>
	      		<th><h4>첨부파일</h4></th>
	      		<td colspan="3"><img src="${path}/resources/img/notice/fileImge1.jpg" style="margin-left:10px;margin-top:-10px; width: 20px;height:20px;display: inline-block;">&nbsp;<h4 class="fileAction" style="display: inline-block;cursor: pointer;" onclick="fileDownload('${notice.hospitalNoticeFile}','${notice.hospitalNoticeRefile }')">${notice.hospitalNoticeFile}</h4></td>
	      	</tr>
	      </c:if>
      </c:if>
      <c:if test="${ckPH!='H'}">
      	<tr>
        <th><h4>작성일</h4></th>
        <td><h4>${notice.memberNoticeDate}</h4></td>
        <th><h4>조회수</h4></th>
        <td><h4>${notice.memberNoticeReadcount}</h4></td>
    </tr>
      <tr>
        <th><h4>작성자</h4></th>
        <td colspan="3"><h4>관리자</h4></td>
      </tr>
      <tr>
        <th><h4>제목</h4></th>
        <td colspan="3"><h4>${notice.memberNoticeTitle}</h4></td>
      </tr>
      <tr>
        <td colspan="4" style="height: 300px; max-height: 700px;max-width:300px;max-height:700px;"><h4 style="word-break:break-all;">${notice.memberNoticeContent}</h4></td>
      </tr>
	      <c:if test="${notice.memberNoticeFile!=null}">
	      	<tr>
	      		<th><h4>첨부파일</h4></th>
	      		<td colspan="3"><img src="${path}/resources/img/notice/fileImge1.jpg" style="margin-left:10px;margin-top:-10px; width: 20px;height: 20px;display: inline-block;"><h4 class="fileAction" style="display: inline-block;cursor: pointer;" onclick="fileDownload('${notice.memberNoticeFile}','${notice.memberNoticeRefile }')">${notice.memberNoticeFile}</h4></td>
	      	</tr>
	      </c:if>
      </c:if>
    </tbody>
  </table>
  <hr>
 	<c:if test="${empty searchContent }">
		<button type="button" class="btn btn-success" onclick="list()">목록으로</button>
	</c:if>
	<c:if test="${not empty searchContent }">
		<button type="button" class="btn btn-success" onclick="searchList()">목록으로</button>
	</c:if>
	<c:if test="${checkPH=='P' }">
	<c:if test="${memberLoggedIn.memberId=='admin' }">
		<input type="button" value="삭제" class="btn btn-danger" style="float: right;margin-left: 10px;" data-toggle="modal" data-target="#deleteModal"/>
  		<c:if test="${ckPH=='H'}">
  			<button type="button" class="btn btn-warning" style="float: right;margin-left: 10px;" onclick="crystalH()">수정</button>
			<script>
				function crystalH(){
					location.href="${path}/notice/noticeUpdate.do?checkPH=${ckPH}&cPage=${cp}&no=${notice.hospitalNoticeNum}";
				}
			</script>
		</c:if>
		<c:if test="${ckPH!='H'}">
  			<button type="button" class="btn btn-warning" style="float: right;margin-left: 10px;" onclick="crystalM()">수정</button>
			<script>
				function crystalM(){
					location.href="${path}/notice/noticeUpdate.do?checkPH=${ckPH}&cPage=${cp}&no=${notice.memberNoticeNum}";
				}
			</script>
		</c:if>
  	</c:if>
  	</c:if>
  <br><br>
  <table class="table table-bordered table-sm" style="border: 2px solid lightgray;">
        <tbody>
        	<c:if test="${empty searchContent }">
	        	<c:if test="${noticeBefore!=null}">
	            	<c:if test="${ckPH=='H'}">
	            		<tr>
	                		<td style="width: 10%;text-align:center;"><h4> <b>∧</b> 이전</h4></td>
	                		<td><h4><a href='${path}/notice/noticeView.do?no=${noticeBefore.hospitalNoticeNum }&checkPH=${ckPH}&cp=${cp}'> ${noticeBefore.hospitalNoticeTitle }</a></h4></td>
	            		</tr>
	            	</c:if>
	            	<c:if test="${ckPH!='H'}">
	            		<tr>
	                		<td style="width: 10%;text-align:center;"><h4> <b>∧</b> 이전</h4></td>
	                		<td><h4><a href='${path}/notice/noticeView.do?no=${noticeBefore.memberNoticeNum }&checkPH=${ckPH}&cp=${cp}'> ${noticeBefore.memberNoticeTitle }</a></h4></td>
	            		</tr>
	            	</c:if>
	            </c:if>
	            <c:if test="${noticeNext!=null}">
		            <c:if test="${ckPH=='H'}">
			            <tr>
			                <td style="width: 10%;text-align:center;"><h4> <b>∨</b> 다음</h4></td>
			                <td><h4><a href='${path}/notice/noticeView.do?no=${noticeNext.hospitalNoticeNum }&checkPH=${ckPH}&cp=${cp}'> ${noticeNext.hospitalNoticeTitle }</a></h4></td>
			            </tr>
			        </c:if>
			        <c:if test="${ckPH!='H'}">
			            <tr>
			                <td style="width: 10%;text-align:center;"><h4> <b>∨</b> 다음</h4></td>
			                <td><h4><a href='${path}/notice/noticeView.do?no=${noticeNext.memberNoticeNum }&checkPH=${ckPH}&cp=${cp}'> ${noticeNext.memberNoticeTitle }</a></h4></td>
			            </tr>
			        </c:if>
	            </c:if>
            </c:if>
            <c:if test="${not empty searchContent }">
	        	<c:if test="${noticeBefore!=null}">
	            	<c:if test="${ckPH=='H'}">
	            		<tr>
	                		<td style="width: 10%;text-align:center;"><h4> <b>∧</b> 이전</h4></td>
	                		<td><h4><a href='${path}/notice/noticeView.do?no=${noticeBefore.hospitalNoticeNum }&checkPH=${ckPH}&cp=${cp}&searchKind=${searchKind}&searchContent=${searchContent}'> ${noticeBefore.hospitalNoticeTitle }</a></h4></td>
	            		</tr>
	            	</c:if>
	            	<c:if test="${ckPH!='H'}">
	            		<tr>
	                		<td style="width: 10%;text-align:center;"><h4> <b>∧</b> 이전</h4></td>
	                		<td><h4><a href='${path}/notice/noticeView.do?no=${noticeBefore.memberNoticeNum }&checkPH=${ckPH}&cp=${cp}&searchKind=${searchKind}&searchContent=${searchContent}'> ${noticeBefore.memberNoticeTitle }</a></h4></td>
	            		</tr>
	            	</c:if>
	            </c:if>
	            <c:if test="${noticeNext!=null}">
		            <c:if test="${ckPH=='H'}">
			            <tr>
			                <td style="width: 10%;text-align:center;"><h4> <b>∨</b> 다음</h4></td>
			                <td><h4><a href='${path}/notice/noticeView.do?no=${noticeNext.hospitalNoticeNum }&checkPH=${ckPH}&cp=${cp}&searchKind=${searchKind}&searchContent=${searchContent}'> ${noticeNext.hospitalNoticeTitle }</a></h4></td>
			            </tr>
			        </c:if>
			        <c:if test="${ckPH!='H'}">
			            <tr>
			                <td style="width: 10%;text-align:center;"><h4> <b>∨</b> 다음</h4></td>
			                <td><h4><a href='${path}/notice/noticeView.do?no=${noticeNext.memberNoticeNum }&checkPH=${ckPH}&cp=${cp}&searchKind=${searchKind}&searchContent=${searchContent}'> ${noticeNext.memberNoticeTitle }</a></h4></td>
			            </tr>
			        </c:if>
	            </c:if>
            </c:if>
        </tbody>
      </table>
</div>
<br>
<script>
	function list(){
		location.href="${path}/notice/noticeList.do?checkPH=${ckPH}&cPage=${cp}";
	}
	function searchList(){
		location.href="${path}/notice/noticeSearch.do?checkPH=${ckPH}&cPage=${cp}&searchKind=${searchKind}&searchContent=${searchContent}";
	}
	function fileDownload(oName, rName){
        //한글파일명이 있을 수 있으므로, 명시적으로 encoding
	    oName = encodeURIComponent(oName);
        location.href="${path}/notice/fileDownload.do?oName="+oName+"&rName="+rName;
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
						action="${path}/notice/deleteNotice.do?checkPH=${ckPH}"
						method="post">
						<div class="modal-body">
							<h1>게시물을 삭제 하시겠습니까?</h1>
							<h3 style="color: red;">주의) 삭제한 게시물은 복구 할 수 없습니다.</h3>
							<h3 style="color: red;">&nbsp;&nbsp;&nbsp;&nbsp;게시물의 업로드 파일도 같이 삭제 됩니다.</h3>
							<c:if test="${ckPH=='H' }">
							<input type="hidden" name="no" value="${notice.hospitalNoticeNum}"/>
							<input type="hidden" name="refile" value="${notice.hospitalNoticeRefile}"/>
							</c:if>
							<c:if test="${ckPH=='P' }">
							<input type="hidden" name="no" value="${notice.memberNoticeNum}"/>
							<input type="hidden" name="refile" value="${notice.memberNoticeRefile}"/>
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
<jsp:include page="/WEB-INF/views/common/footer.jsp" />