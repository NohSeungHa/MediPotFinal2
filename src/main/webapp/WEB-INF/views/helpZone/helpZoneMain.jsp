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
      background-image : url('/pot/resources/img/helpZone/jumbotron2.jpg');
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

  </style>
</head>
<body>

<!--헤더부분 추가하기 -->


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
			<img src="/pot/resources/img/notice/home.jpg" style="width: 30%; height: 30%;"> 홈으로</a>
		</div>
		<br> <br>

		<div class="row">
    <div class="col-sm-4">
      <div class="panel panel-success">
        <div class="panel-heading">1)BLACK FRIDAY DEAL</div>
        <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer">Buy 50 mobiles and get a gift card</div>
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
</div><br><br>


<!--푸터 부분 -->
<footer class="container-fluid text-center">

</footer>


<br>            
	  ${pageBar }
</body>



<jsp:include page="/WEB-INF/views/common/footer.jsp"/>