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
			<a id="noticeHv" href="${path}/helpZone/helpZoneList.do" style="float: right;">헬프존</a>
			<p style="float: right;">
				<b style="margin-right: 10px;">></b>
			</p>
			<a id="home" href="${path}" style="float: right; width: 70px;">
			<img src="/pot/resources/img/notice/home.jpg" style="width: 30%; height:30%;"> 홈으로</a>
			
		</div>
		<br><br>
		

		<input class="form-control mr-sm-2" type="text" placeholder="키워드로 검색하기" style="width: 280px; height: 45px; float: left;">
		<button class="btn btn-info btn-lg" type="submit" style="margin-left: 5px;">검색</button>
		
		<button class="btn btn-info btn-lg pull-right" type="submit" onclick="insert()">질문 등록</button>

		<br><br>
		
	<!-- 질문글 시작 -->
	<div class="row">
    <div class="col-sm-4">
      <div class="panel panel-success">
        <div class="panel-heading">질문 제목이 들어갈 부분입니다.</div>
        <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">질문자가 선택한 키워드가 들어가는 부분입니다.</div>
      </div>
    </div>
    <div class="col-sm-4"> 
      <div class="panel panel-danger">
        <div class="panel-heading">2.BLACK FRIDAY DEAL</div>
        <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Buy 50 mobiles and get a gift card</div>
      </div>
    </div>
    <div class="col-sm-4"> 
      <div class="panel panel-success">
        <div class="panel-heading">3.BLACK FRIDAY DEAL</div>
        <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Buy 50 mobiles and get a gift card</div>
      </div>
    </div>
  </div>
</div><br>

<!--두번째줄 -->
<div class="container">    
  <div class="row">
    <div class="col-sm-4">
      <div class="panel panel-danger">
        <div class="panel-heading">BLACK FRIDAY DEAL</div>
        <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Buy 50 mobiles and get a gift card</div>
      </div>
    </div>
    <div class="col-sm-4"> 
      <div class="panel panel-success">
        <div class="panel-heading">BLACK FRIDAY DEAL</div>
        <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Buy 50 mobiles and get a gift card</div>
      </div>
    </div>
    <div class="col-sm-4"> 
      <div class="panel panel-danger">
        <div class="panel-heading">BLACK FRIDAY DEAL</div>
        <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Buy 50 mobiles and get a gift card</div>
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
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>