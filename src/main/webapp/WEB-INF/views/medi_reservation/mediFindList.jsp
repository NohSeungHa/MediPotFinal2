<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>

	<c:set var='path' value="<%=request.getContextPath() %>"></c:set>
<jsp:include page="/WEB-INF/views/common/header.jsp">
<jsp:param value="HomeSpring" name="pageTitle"></jsp:param>
</jsp:include>
	<div class="container">
	<div id="searchH">
			<img alt="searchImg" src="/pot/resources/img/reser/reser.png" width="60%;" height="380px;">
			<div id="searchH2">
			<form action="${path }/reservation/searchMedi">
			<input type="text" name="Hname" class="form-control" placeholder="병원이름 검색" style="width:140%;">
			<br>
			<button type="submit" class="btn btn-default" style="margin-left:40%;width:50%">검색</button>
			</form>
			</div>
	</div>
	<style>
		#searchH{
			position:relative;
			text-align: center;
		}
		#searchH2{
			position:absolute;
			top:53%;
			left:57%; 
		}
		
		#locList 
		{
			width: 26%;
			height: auto;
			padding: 10px;
			background-color:#BEBEBE;
			-webkit-border-radius: 10px;
			-moz-border-radius: 10px;
			border-radius: 10px;
			margin-top:5px;
			display:inline-block;
		}
		
		
		.loc,.sub{
			margin:5px;
			width:90%;
			height:50px;
			font-size:20px;
		}
		
		
		#subjectList 
		{
			width: 72.5%;
			height: auto;
			padding: 10px;
			-webkit-border-radius: 10px;
			-moz-border-radius: 10px;
			border-radius: 10px;
			margin-top:5px;
			margin-left:1.5%;
			display:inline-block;
			position:absolute;
			border: 2px solid #BEBEBE;
		}
		#subjectList>img{
			margin:9px;
		}
		#subjectList>img:hover{
			cursor:pointer;
			border:4px solid #BEBEBE;
		}
	</style>
	<br><br><br>
	<div style="margin-bottom:10px;position:relative;height:auto;">
	<div style="width:100%;height:50px;font-size:20px;text-align:center;background-color:#286090;padding-top:11px;color:white;border-radius:8px;">
		지역 선택 및 진료과목 선택
	</div>
		<div id="locList" style="text-align: center;">
			<button class="btn btn-default loc" value="S1">서울</button><br>
			<button class="btn btn-default loc" value="I1">인천</button><br>
			<button class="btn btn-default loc">경기도</button><br>
			<button class="btn btn-default loc">강원도</button><br>
			<button class="btn btn-default loc">충청도</button><br>
			<button class="btn btn-default loc">전라도</button><br>
			<button class="btn btn-default loc">경상도</button><br>
			<button class="btn btn-default loc">제주도</button>
		</div>
		<div id="subjectList" style="text-align: center;">
			<img class="subImg" src="${path }/resources/img/reser/h1.png" width="140px;" height="140px;">
			<img class="subImg" src="${path }/resources/img/reser/h2.png" width="140px;" height="140px;">
			<img class="subImg" src="${path }/resources/img/reser/h3.png" width="140px;" height="140px;">
			<img class="subImg" src="${path }/resources/img/reser/h4.png" width="140px;" height="140px;">
			<img class="subImg" src="${path }/resources/img/reser/h5.png" width="140px;" height="140px;">
			<img class="subImg" src="${path }/resources/img/reser/h6.png" width="140px;" height="140px;">
			<img class="subImg" src="${path }/resources/img/reser/h7.png" width="140px;" height="140px;">
			<img class="subImg" src="${path }/resources/img/reser/h8.png" width="140px;" height="140px;">
			<img class="subImg" src="${path }/resources/img/reser/h9.png" width="140px;" height="140px;">
			<img class="subImg" src="${path }/resources/img/reser/h10.png" width="140px;" height="140px;">
			<img class="subImg" src="${path }/resources/img/reser/h11.png" width="140px;" height="140px;">
		</div>
	
	</div>
	<script>
		$(function () {		
			var loc="";
			$('.loc').click(function () {
				if($(this).attr('class').indexOf("btn-primary")>0){
					$(this).removeClass("btn-primary");
					$(this).addClass("btn-default");
					loc="";
				}else{
					$(".loc").removeClass("btn-primary");
					$(".loc").addClass("btn-default");
					$(this).removeClass("btn-default");
					$(this).addClass("btn-primary");
					loc=$(this).val();
				}
			});
			$(".subImg").click(function () {
				if(loc.length>0){
					alert("지역선택 완료");
				}else{
					alert("지역을 먼저 선택해 주세요");
				}
			}); 
			
		});
	</script>
	<div style="border:2px solid lightgray;width:100%;"></div>
		
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>