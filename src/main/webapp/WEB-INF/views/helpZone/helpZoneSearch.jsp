<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>
	<c:set var="path" value="<%=request.getContextPath() %>"/>
     
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value=" " name="pageTitle"/>
</jsp:include>

<head>  
  <style>
       
    /* Remove the jumbotron's default bottom margin */ 
     .jumbotron {
      margin-bottom: 0;
      background-image : url('${path}/resources/img/helpZone/jumbotron2.jpg');
      background-size: cover;
    }

    .jumbotron p{
    	color: white;
    	font-size: 2em;
    }
    .jumbotron h1{
    	color: white;
    	font-size: 7em;
    }
    .search_btn {
    	display: inline-block;
    }
    

  </style>
</head>

<body>
<div class="jumbotron">
  <div class="container text-center">
    <h1>Help Zone</h1>
    <p>안녕하세요 헬프존입니다. 의학전문가에게 무엇이든 물어보세요!</p>
  </div>
</div>

<br><br>
<hr>



<div class="container">	

		<div>
			<a id="helpZoneHv" href="${path}/helpZone/helpZoneList.do" style="float: right;">헬프존</a>
			<p style="float: right;">
				<b style="margin-right: 10px;">></b>
			</p>
			<a id="home" href="${path}" style="float: right; width: 70px;">
			<img src="/pot/resources/img/notice/home.jpg" style="width: 30%; height:30%;"> 홈으로</a>		
		</div>
		<br><br><br>

		
<!-- 검색창 부분입니다. -->
		<form action="#{path }/helpZone/helpZoneSearch.do">
			<select name="searchKind" class="form-control" style="width: 85px; height: 45px; float: left; font-size: 12px;">
				<option value="title" <c:if test="${searchKind=='title' }">selected</c:if> >제목</option>
				<option value="content" <c:if test="${searchKind=='content' }">selected</c:if>>내용</option>
			</select>
			<input name="searchContent" class="form-control mr-sm-2" type="text" value="${searchContent }" style="width: 280px; height: 45px; float: left;">
			<button class="btn btn-info btn-lg" type="submit" style="margin-left: 3px;">검색</button>
		</form>
		
<!-- 일반회원일때만 질문하기 버튼이 출력됩니다. -->	
		<c:if test="${checkPH=='P' }">
		<button class="btn btn-success btn-lg" style="float: right;" type="submit" onclick="insert()">질문 하기</button>
		</c:if>
	
	<br><br>
		
	<!-- 질문글 시작 -->
	
	<div class="row">
	<c:forEach var="list" items="${list }">
		<div class="col-sm-4" style="display: inline-block">
	      <div class="panel panel-success">
	        <div class="panel-heading"><c:out value="${list.helpZoneTitle}"/> </div>
	        <c:if test="${list.helpZoneKeyWord eq '건강'}">
	        <div class="panel-body"><a href="${path }/helpZone/helpZoneView.do?no=${list.helpZoneNum}"><img src="${path }/resources/img/helpZone/fitness.jpg" class="img-responsive" style="width:100%;height:140px" alt="Image"></a></div>        
	        </c:if>
	        
	        <c:if test="${list.helpZoneKeyWord eq '치료'}">
	        <div class="panel-body"><a href="${path }/helpZone/helpZoneView.do?no=${list.helpZoneNum}"><img src="${path }/resources/img/helpZone/treatment.jpg" class="img-responsive" style="width:100%;height:140px" alt="Image"></a></div>
	        </c:if>
	        
	        <c:if test="${list.helpZoneKeyWord eq '기타'}">
	        <div class="panel-body"><a href="${path }/helpZone/helpZoneView.do?no=${list.helpZoneNum}"><img src="${path }/resources/img/helpZone/other.jpg" class="img-responsive" style="width:100%;height:140px" alt="Image"></a></div>        
	        </c:if>
	        
	        <div class="panel-footer">현재 답글수 : ${list.helpZoneCommentCount }</div>
	      </div>
	    </div>
	</c:forEach>
	</div>

<br>            
	  ${pageBar }
</div><br><br><!-- container끝 -->
</body>

<script>
	function insert() {
		location.href="${path}/helpZone/helpZoneInsert.do";
	}
</script>
<script>
	$("searchKind").change(function(){
	});
</script>



<jsp:include page="/WEB-INF/views/common/footer.jsp"/>