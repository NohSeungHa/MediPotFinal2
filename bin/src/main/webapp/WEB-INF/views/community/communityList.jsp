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
        #communityHv{
            float:right;
        }
        #communityHv:hover{
            color: #18bc9c;
        }
        #txt_line{ 
	        overflow: hidden; 
			text-overflow: ellipsis;
		 	white-space: nowrap; 
			width: 500px;
        }
        th{
        	height: 19.556px;
        }
        
	</style>
<div class="container">
	<br> 
	<img class="img-thumbnail" src="${path}/resources/img/community/communityMain.jpg" style="width: 1200px; height: 300px;"> 
	<br>
	<br>
	<a id="communityHv" href="${path}/community/communityList.do" style="float: right;">자유게시판</a>
	<p style="float: right;">
		<b style="margin-right:10px;">></b>
	</p>
	<a id="home" href="${path}" style="float:right;width:70px;"><img
		src="${path}/resources/img/notice/home.jpg"
		style="width: 30%; height: 30%;"> 홈으로</a>
	<br><br>
	<c:if test="${checkPH=='P' }">
		<c:if test="${not empty memberLoggedIn.memberId}">
			<button class="btn btn-primary btn-sm" type="submit" style="float: right;" onclick="insert()">글쓰기</button>
		</c:if>
	</c:if>
	<c:if test="${checkPH=='H' }">
		<c:if test="${not empty memberLoggedIn.hospitalId}">
			<button class="btn btn-primary btn-sm" type="submit" style="float: right;" onclick="insert()">글쓰기</button>
		</c:if>
	</c:if>
	<table class="table table-hover">
		<thead>
			<tr>
				<th style="width: 49.778px;"><h4>번호</h4></th>
				<th style="text-align: center;width: 667.556px;"><h4>제목</h4></th>
				<th style="width: 90.667px;"><h4>첨부파일</h4></th>
				<th style="width: 71.111px;"><h4>작성자</h4></th>
				<th style="width: 50.667px;"><h4>조회</h4></th>
				<th style="text-align: center;width: 113.778px;"><h4>작성일</h4></th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${not empty list }">
				<c:forEach var='community' items='${list }' varStatus="vs">
					<tr>
						<td><h4>${community.communityNum }</h4></td>
						<td><h4 id="txt_line" ><a href='${path}/community/communityView.do?no=${community.communityNum }&cp=${cPage}'>${community.communityTitle }</a></h4></td>
						<c:if test="${community.communityFile!=null }">
							<td>&nbsp;<img src="${path}/resources/img/notice/fileImge1.jpg" style="margin-left:10px; width: 20px;height: 20px;"></td>
						</c:if>
						<c:if test="${community.communityFile==null }">
							<td></td>
						</c:if>
						<td><h4>${community.communityWriter }</h4></td>	
						<td><h4>${community.communityReadcount }</h4></td>
						<td><h4>${community.communityDate }</h4></td>
					</tr>	
				</c:forEach>
			</c:if>
			<c:if test="${empty list}">
				<td colspan="6" style="text-align: center;"><h4>게시글이 존재하지 않습니다.</h4></td>
			</c:if>
		</tbody>
	</table>
	<hr>
	<form name="communitySearchFrm" action="${path}/community/communitySearch.do" method="get">
      	<select name="searchKind" class="form-control" style="width: 85px;height:35px;float: left;">
        	<option value="title">제목</option>
        	<option value="content">내용</option>
        	<option value="writer">작성자</option>
      	</select>
		<input class="form-control mr-sm-2" type="text" placeholder="Search" name="searchContent" style="width: 15%; float: left; margin-left: 5px;">
		<button class="btn btn-info" type="submit" style="margin-left: 5px;">검색</button>
	</form>
	<br>
	  ${pageBar }
</div>
<script>
	function insert(){
		location.href="${path}/community/communityInsert.do";
	}
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />