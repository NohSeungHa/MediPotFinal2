<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>

	<c:set var='path' value="<%=request.getContextPath() %>"></c:set>
<jsp:include page="/WEB-INF/views/common/header.jsp">
<jsp:param value="Hospital Search" name="pageTitle"></jsp:param>
</jsp:include>
	<div class="container">
	<div id="searchH">
			<img alt="searchImg" src="${path }/resources/img/reser/reser.png" width="60%;" height="380px;">
			<div id="searchH2">
			<form action="${path }/medi/searchMedi">
			<input type="text" name="hName" class="form-control" placeholder="병원이름 검색" style="width:140%;">
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
			border:5px solid white;
		}
		#hlist{
			padding-left:20px;
			padding-top:20px;
		}
		.mediList{
			border:4px solid white;
		}
		.mediList:hover{
			cursor:pointer;
			border:4px solid #286090;
		}
	</style>
	<br>
	<c:if test="${empty nameList }">
	<div style="margin-bottom:10px;position:relative;height:auto;">
	<div style="width:100%;height:50px;font-size:25px;text-align:center;background-color:#286090;padding-top:11px;color:white;border-radius:8px;">
			지역 선택 및 진료과목 선택
	</div>
		<div style="text-align:center;padding-top:5px;font-size:20px;">
			** 지역을 선택 후 진료과목을 선택해 주세요 **
		</div>
		<div id="locList" style="text-align: center;">
			<button class="btn btn-default loc" value="서울">서울</button><br>
			<button class="btn btn-default loc" value="인천">인천</button><br>
			<button class="btn btn-default loc" value="경기">경기도</button><br>
			<button class="btn btn-default loc" value="강원">강원도</button><br>
			<button class="btn btn-default loc" value="충청">충청도</button><br>
			<button class="btn btn-default loc" value="전라">전라도</button><br>
			<button class="btn btn-default loc" value="경상">경상도</button><br>
			<button class="btn btn-default loc" value="제주">제주도</button>
		</div>
		<div id="subjectList" style="text-align: center;">
			<img class="subImg" name="정형외과" src="${path }/resources/img/reser/h1.png" width="140px;" height="140px;">
			<img class="subImg" name="치과" src="${path }/resources/img/reser/h2.png" width="140px;" height="140px;">
			<img class="subImg" name="피부과" src="${path }/resources/img/reser/h3.png" width="140px;" height="140px;">
			<img class="subImg" name="성형외과" src="${path }/resources/img/reser/h4.png" width="140px;" height="140px;">
			<img class="subImg" name="안과" src="${path }/resources/img/reser/h5.png" width="140px;" height="140px;">
			<img class="subImg" name="비뇨기과" src="${path }/resources/img/reser/h6.png" width="140px;" height="140px;">
			<img class="subImg" name="신경외과" src="${path }/resources/img/reser/h7.png" width="140px;" height="140px;">
			<img class="subImg" name="내과" src="${path }/resources/img/reser/h8.png" width="140px;" height="140px;">
			<img class="subImg" name="이비인후과" src="${path }/resources/img/reser/h9.png" width="140px;" height="140px;">
			<img class="subImg" name="한의원" src="${path }/resources/img/reser/h10.png" width="140px;" height="140px;">
			<img class="subImg" name="산부인과" src="${path }/resources/img/reser/h11.png" width="140px;" height="140px;">
		</div>
	
	</div>
	</c:if>
	<c:if test="${not empty nameList }">
	<div style="width:100%;height:50px;font-size:20px;text-align:center;background-color:#286090;padding-top:11px;color:white;border-radius:8px;margin-bottom:10px;">
		병원 리스트
	</div>
	<c:forEach var="list" items="${nameList }" >
	<div class="mediList" id="${list.hospitalNum }" style="display:inline-block;width:49%;margin-right:5px; position:relative;margin-bottom:20px;">
		<div style="display: inline-block;"><img src="${path }/resources/uploadfile/hospitalInfo/${list.hospitalRePhoto}" width="200px;" height="200px;"></div>
		<div id="hlist" style="display: inline-block;position:absolute;">
			<p><span style="font-size:20px;color: #286090">병원명</span>&nbsp;&nbsp;
			<span style="font-size:20px;">${list.hospitalName }</span></p>
			
			<p><span style="font-size:20px;color: #286090">진료과목</span>&nbsp;&nbsp;
			<span style="font-size:20px;">
			${list.hospitalProfessional }
			</span></p>
			
			<p><span style="font-size:20px;color: #286090">전화번호</span>&nbsp;&nbsp;
			<span style="font-size:20px;">${list.hospitalTel }</span></p>
			
			<p><span style="font-size:20px;color: #286090">주소</span>&nbsp;&nbsp;
			<span style="font-size:20px;">${list.hospitalAddr }</span></p>
		</div>
	</div>
	</c:forEach>
	</c:if>
	<script>
		$(function () {
			$(".mediList").click(function () {
				location.href='${path}/medi/mediInfo?no='+$(this).attr('id');
			});
		});
		$(function () {		
			var loc="";
			var sub="";
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
					 
					sub=$(this).attr("name");
					$.ajax({
						url:"${path}/medi/medisearchList",
						data:{loc:loc,sub:sub},
						dataType:"html",
						success:function(data){
							console.log(data);
							$('#mediListAdd').html(data);
						}
					});
					
					 
					/* location.href='${path}/medi/medisearchList?loc='+loc+'&sub='+sub; */
				}else{
					alert("지역을 먼저 선택해 주세요");
				}
			}); 
			
		});
	</script>
	<div style="border:2px solid lightgray;width:100%;"></div>
	<div id="mediListAdd" style="margin:5px;position:relative;margin-bottom:50px;">
	
	</div>

	</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>