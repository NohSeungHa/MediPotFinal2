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
    <p>(테스트멘트)안녕하세요 헬프존입니다. 의학전문가에게 무엇이든 물어보세요!</p>
  </div>
</div>

<br><br>
<hr>


<!--첫번째줄) 1줄에 3개씩 -->
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
			<select name="searchKind" class="form-control" style="width: 85px; height: 45px; float: left; font-size: 12px;">
				<option value="title">제목</option>
				<option value="content">내용</option>
			</select>
		<input class="form-control mr-sm-2" type="text" placeholder="원하시는 검색 내용을 적어주세요" style="width: 280px; height: 45px; float: left;">
		<button class="btn btn-info btn-lg" type="submit" style="margin-left: 3px;">검색</button>
		
<!-- 일반회원일때만 질문하기 버튼이 출력됩니다. -->	
		<c:if test="${checkPH=='P' }">
		<button class="btn btn-success btn-lg" style="float: right;" type="submit" onclick="insert()">질문 하기</button>
		</c:if>
	
	<br><br>
		
	<!-- 질문글 시작 -->
	
	<div class="row">
    <div class="col-sm-4">
      <div class="panel panel-success">
        <div class="panel-heading"><c:out value="${list[0].helpZoneTitle}"/> </div>
        <c:if test="${list[0].helpZoneKeyWord eq '건강'}">
        <div class="panel-body"><a href="${path }/helpZone/helpZoneView.do?no=${list[0].helpZoneNum}"><img src="${path }/resources/img/helpZone/fitness.jpg" class="img-responsive" style="width:100%;height:140px" alt="Image"></a></div>        
        </c:if>
        
        <c:if test="${list[0].helpZoneKeyWord eq '치료'}">
        <div class="panel-body"><a href="${path }/helpZone/helpZoneView.do?no=${list[0].helpZoneNum}"><img src="${path }/resources/img/helpZone/treatment.jpg" class="img-responsive" style="width:100%;height:140px" alt="Image"></a></div>
        </c:if>
        
        <c:if test="${list[0].helpZoneKeyWord eq '기타'}">
        <div class="panel-body"><a href="${path }/helpZone/helpZoneView.do?no=${list[0].helpZoneNum}"><img src="${path }/resources/img/helpZone/other.jpg" class="img-responsive" style="width:100%;height:140px" alt="Image"></a></div>        
        </c:if>
        
        <div class="panel-footer">현재 답글수</div>
        <div class="panel-footer">좋아요</div>
      </div>
    </div>
    <div class="col-sm-4"> 
      <div class="panel panel-danger">
        <div class="panel-heading"><c:out value="${list[1].helpZoneTitle}"/> </div>
         <c:if test="${list[1].helpZoneKeyWord eq '건강'}">
        <div class="panel-body"><a href="${path }/helpZone/helpZoneView.do?no=${list[1].helpZoneNum}"><img src="${path }/resources/img/helpZone/fitness.jpg" class="img-responsive" style="width:100%;height:140px" alt="Image"></a></div>        
        </c:if>
        
        <c:if test="${list[1].helpZoneKeyWord eq '치료'}">
        <div class="panel-body"><a href="${path }/helpZone/helpZoneView.do?no=${list[1].helpZoneNum}"><img src="${path }/resources/img/helpZone/treatment.jpg" class="img-responsive" style="width:100%;height:140px" alt="Image"></a></div>
        </c:if>
        
        <c:if test="${list[1].helpZoneKeyWord eq '기타'}">
        <div class="panel-body"><a href="${path }/helpZone/helpZoneView.do?no=${list[1].helpZoneNum}"><img src="${path }/resources/img/helpZone/other.jpg" class="img-responsive" style="width:100%;height:140px" alt="Image"></a></div>        
        </c:if>
        
        <div class="panel-footer">현재 답글수</div>
        <div class="panel-footer">좋아요</div>
      </div>
    </div>
    <div class="col-sm-4"> 
      <div class="panel panel-success">
        <div class="panel-heading"><c:out value="${list[2].helpZoneTitle}"/> </div>
        <c:if test="${list[2].helpZoneKeyWord eq '건강'}">
        <div class="panel-body"><a href="${path }/helpZone/helpZoneView.do?no=${list[2].helpZoneNum}"><img src="${path }/resources/img/helpZone/fitness.jpg" class="img-responsive" style="width:100%;height:140px" alt="Image"></a></div>        
        </c:if>
        
        <c:if test="${list[2].helpZoneKeyWord eq '치료'}">
        <div class="panel-body"><a href="${path }/helpZone/helpZoneView.do?no=${list[2].helpZoneNum}"><img src="${path }/resources/img/helpZone/treatment.jpg" class="img-responsive" style="width:100%;height:140px" alt="Image"></a></div>
        </c:if>
        
        <c:if test="${list[2].helpZoneKeyWord eq '기타'}">
        <div class="panel-body"><a href="${path }/helpZone/helpZoneView.do?no=${list[2].helpZoneNum}"><img src="${path }/resources/img/helpZone/other.jpg" class="img-responsive" style="width:100%;height:140px" alt="Image"></a></div>        
        </c:if>
        
        <div class="panel-footer">현재 답글수</div>
        <div class="panel-footer">좋아요</div>
      </div>
    </div>
  </div>
</div><br>

<!--두번째줄 -->
<div class="container">    
  <div class="row">
    <div class="col-sm-4">
      <div class="panel panel-danger">
        <div class="panel-heading"><c:out value="${list[3].helpZoneTitle}"/> </div>
        <c:if test="${list[3].helpZoneKeyWord eq '건강'}">
        <div class="panel-body"><a href="${path }/helpZone/helpZoneView.do?no=${list[3].helpZoneNum}"><img src="${path }/resources/img/helpZone/fitness.jpg" class="img-responsive" style="width:100%;height:140px" alt="Image"></a></div>        
        </c:if>        
        <c:if test="${list[3].helpZoneKeyWord eq '치료'}">
        <div class="panel-body"><a href="${path }/helpZone/helpZoneView.do?no=${list[3].helpZoneNum}"><img src="${path }/resources/img/helpZone/treatment.jpg" class="img-responsive" style="width:100%;height:140px" alt="Image"></a></div>
        </c:if>        
        <c:if test="${list[3].helpZoneKeyWord eq '기타'}">
        <div class="panel-body"><a href="${path }/helpZone/helpZoneView.do?no=${list[3].helpZoneNum}"><img src="${path }/resources/img/helpZone/other.jpg" class="img-responsive" style="width:100%;height:140px" alt="Image"></a></div>        
        </c:if>
        
        
        <div class="panel-footer">현재 답글수</div>
        <div class="panel-footer">좋아요</div>
      </div>
    </div>
    <div class="col-sm-4"> 
      <div class="panel panel-success">
        <div class="panel-heading"><c:out value="${list[4].helpZoneTitle}"/> </div>
         <c:if test="${list[4].helpZoneKeyWord eq '건강'}">
        <div class="panel-body"><a href="${path }/helpZone/helpZoneView.do?no=${list[4].helpZoneNum}"><img src="${path }/resources/img/helpZone/fitness.jpg" class="img-responsive" style="width:100%;height:140px" alt="Image"></a></div>        
        </c:if>
        
        <c:if test="${list[4].helpZoneKeyWord eq '치료'}">
        <div class="panel-body"><a href="${path }/helpZone/helpZoneView.do?no=${list[4].helpZoneNum}"><img src="${path }/resources/img/helpZone/treatment.jpg" class="img-responsive" style="width:100%;height:140px" alt="Image"></a></div>
        </c:if>
        
        <c:if test="${list[4].helpZoneKeyWord eq '기타'}">
        <div class="panel-body"><a href="${path }/helpZone/helpZoneView.do?no=${list[4].helpZoneNum}"><img src="${path }/resources/img/helpZone/other.jpg" class="img-responsive" style="width:100%;height:140px" alt="Image"></a></div>        
        </c:if>
        
        <div class="panel-footer">현재 답글수</div>
        <div class="panel-footer">좋아요</div>
      </div>
    </div>
    <div class="col-sm-4"> 
      <div class="panel panel-danger">
        <div class="panel-heading"><c:out value="${list[5].helpZoneTitle}"/> </div>
         <c:if test="${list[5].helpZoneKeyWord eq '건강'}">
        <div class="panel-body"><a href="${path }/helpZone/helpZoneView.do?no=${list[5].helpZoneNum}"><img src="${path }/resources/img/helpZone/fitness.jpg" class="img-responsive" style="width:100%;height:140px" alt="Image"></a></div>        
        </c:if>
        
        <c:if test="${list[5].helpZoneKeyWord eq '치료'}">
        <div class="panel-body"><a href="${path }/helpZone/helpZoneView.do?no=${list[5].helpZoneNum}"><img src="${path }/resources/img/helpZone/treatment.jpg" class="img-responsive" style="width:100%;height:140px" alt="Image"></a></div>
        </c:if>
        
        <c:if test="${list[5].helpZoneKeyWord eq '기타'}">
        <div class="panel-body"><a href="${path }/helpZone/helpZoneView.do?no=${list[5].helpZoneNum}"><img src="${path }/resources/img/helpZone/other.jpg" class="img-responsive" style="width:100%;height:140px" alt="Image"></a></div>        
        </c:if>
        
        <div class="panel-footer">현재 답글수</div>
        <div class="panel-footer">좋아요</div>
      </div>
    </div>
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