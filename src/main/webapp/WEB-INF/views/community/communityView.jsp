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
  <img class="img-thumbnail" src="/pot/resources/img/community/communityMain.jpg" style="width:100%; height:270px;">
	<br><br>
	<a id="noticeHv" href="${path}/community/communityList.do" style="float: right;">자유게시판</a>
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
 	<c:if test="${empty searchContent }">
		<button type="button" class="btn btn-success" onclick="list()">목록으로</button>
	</c:if>
	<c:if test="${not empty searchContent }">
		<button type="button" class="btn btn-success" onclick="searchList()">목록으로</button>
	</c:if>
	<c:if test="${memberLoggedIn.memberId eq com.communityWriter or memberLoggedIn.memberId=='admin' }">
		<input type="button" value="삭제" class="btn btn-danger" style="float: right;margin-left: 10px;" data-toggle="modal" data-target="#deleteModal"/>
  		<button type="button" class="btn btn-warning" style="float: right;margin-left: 10px;" onclick="crystal()">수정</button>
		<script>
			function crystal(){
				location.href="${path}/community/communityUpdate.do?cPage=${cp}&no=${com.communityNum}";
			}
		</script>
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
	
	
</script>
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">게시물 삭제 확인</h5>
					</div>
					<form
						action="${path}/community/deleteCommunity.do"
						method="post">
						<div class="modal-body">
							<h1>게시물을 삭제 하시겠습니까?</h1>
							<h3 style="color: red;">주의) 삭제한 게시물은 복구 할 수 없습니다.</h3>
							<h3 style="color: red;">&nbsp;&nbsp;&nbsp;&nbsp;게시물의 업로드 파일도 같이 삭제 됩니다.</h3>
							<input type="hidden" name="no" value="${com.communityNum}"/>
							<input type="hidden" name="refile" value="${com.communityRefile}"/>
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