<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="<%=request.getContextPath() %>"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value=" " name="pageTitle" />
</jsp:include>
<link href="https://fonts.googleapis.com/css?family=Do Hyeon" rel="stylesheet" type="text/css">
<style>
	tbody tr td:nth-child(2){
		width: 60%;
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
        #txt_line{ 
	        overflow: hidden; 
			text-overflow: ellipsis;
		 	white-space: nowrap; 
			width: 500px;
        }
        /* ul{
       		display: table; 
       		margin-left: auto; 
       		margin-right: auto;
        } */
	</style>
<div class="container">
	<br> 
	<img class="img-thumbnail" src="/pot/resources/img/notice/hnoticeMain.jpg" style="width: 100%;"> 
	<br>
	<br>
	<a id="noticeHv" href="${path}/notice/noticeList.do?checkPH=${ckPH}" style="float: right;">공지사항</a>
	<p style="float: right;">
		<b style="margin-right:10px;">></b>
	</p>
	<a id="home" href="${path}" style="float:right;width:70px;"><img
		src="/pot/resources/img/notice/home.jpg"
		style="width: 30%; height: 30%;"> 홈으로</a>
	<br><br>
	<c:if test="${memberLoggedIn.memberId=='admin' }">
	<button class="btn btn-primary btn-sm" type="submit" style="float: right;" onclick="insert()">글쓰기</button>
	</c:if>
	<table class="table table-hover">
		<thead>
			<tr>
				<th><h4>번호</h4></th>
				<th style="text-align: center;"><h4>제목</h4></th>
				<th><h4>첨부파일</h4></th>
				<th><h4>작성자</h4></th>
				<th><h4>조회</h4></th>
				<th style="text-align: center;width: 130px;"><h4>작성일</h4></th>
			</tr>
		</thead>
		<tbody>
		<c:if test="${ckPH=='H'}">
			<c:if test="${not empty list }">
				<c:forEach var='hnotice' items='${list }' varStatus="vs">
					<tr>
						<td><h4>${hnotice.hospitalNoticeNum }</h4></td>
						<td><h4 id="txt_line" ><a href='${path}/notice/noticeView.do?no=${hnotice.hospitalNoticeNum }&checkPH=${ckPH}&id=${memberLoggedIn.memberId}&cp=${cPage}&searchKind=${searchKind}&searchContent=${searchContent}'>${hnotice.hospitalNoticeTitle }</a></h4></td>
						<c:if test="${hnotice.hospitalNoticeFile!=null }">
							<td>&nbsp;<img src="/pot/resources/img/notice/fileImge1.jpg" style="margin-left:10px; width: 20px;height: 20px;"></td>
						</c:if>
						<c:if test="${hnotice.hospitalNoticeFile==null }">
							<td></td>
						</c:if>
						<td><h4>${hnotice.hospitalNoticeWriter }</h4></td>	
						<td><h4>${hnotice.hospitalNoticeReadcount }</h4></td>
						<td><h4>${hnotice.hospitalNoticeDate }</h4></td>
					</tr>	
				</c:forEach>
			</c:if>
			<c:if test="${empty list}">
				<td colspan="6" style="text-align: center;"><h4>검색결과가 존재하지 않습니다.</h4></td>
			</c:if>
		</c:if>
		<c:if test="${ckPH!='H'}">
			<c:if test="${not empty list }">
				<c:forEach var='mnotice' items='${list }' varStatus="vs">
					<tr>
						<td><h4>${mnotice.memberNoticeNum }</h4></td>
						<td><h4 id="txt_line" ><a href='${path}/notice/noticeView.do?no=${mnotice.memberNoticeNum }&checkPH=${ckPH}&id=${memberLoggedIn.memberId}&cp=${cPage}&searchKind=${searchKind}&searchContent=${searchContent}'>${mnotice.memberNoticeTitle }</a></h4></td>
						<c:if test="${mnotice.memberNoticeFile!=null }">
							<td>&nbsp;<img src="/pot/resources/img/notice/fileImge1.jpg" style="margin-left:10px; width: 20px;height: 20px;"></td>
						</c:if>
						<c:if test="${mnotice.memberNoticeFile==null }">
							<td></td>
						</c:if>
						<td><h4>${mnotice.memberNoticeWriter }</h4></td>	
						<td><h4>${mnotice.memberNoticeReadcount }</h4></td>
						<td><h4>${mnotice.memberNoticeDate }</h4></td>
					</tr>	
				</c:forEach>
			</c:if>
			<c:if test="${empty list}">
				<td colspan="6" style="text-align: center;"><h4>검색결과가 존재하지 않습니다.</h4></td>
			</c:if>
		</c:if>
		</tbody>
	</table>
	<hr>
	<form name="noticeSearchFrm" action="${path}/notice/noticeSearch.do" method="get">
	     <select name="searchKind" class="form-control" style="width: 85px;height:35px;float: left;">
	       	<c:if test="${searchKind=='title' }">
	       		<option value="title" selected>제목</option>
	       		<option value="content">내용</option>	
	       	</c:if>
	       	<c:if test="${searchKind=='content' }">
	       		<option value="title">제목</option>
	       		<option value="content" selected>내용</option>	
	       	</c:if>
	     </select>
      	
      	<input type="hidden" name="checkPH" value="${ckPH}">
		<input class="form-control mr-sm-2" type="text" placeholder="Search" name="searchContent" style="width: 15%; float: left; margin-left: 5px;" value="${searchContent}">
		<button class="btn btn-info" type="submit" style="margin-left: 5px;">검색</button>
	</form>
	<br>            
	  ${pageBar }
</div>
<script>
	function insert(){
		location.href="${path}/notice/noticeInsert.do?checkPH=${ckPH}";
	}
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />