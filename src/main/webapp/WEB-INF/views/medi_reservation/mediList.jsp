<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>

	<c:set var='path' value="<%=request.getContextPath() %>"></c:set>
	

	<div id="listId" style="width:100%;height:50px;font-size:20px;text-align:center;background-color:#286090;padding-top:11px;color:white;border-radius:8px;margin-bottom:10px;">
		병원 리스트
	</div>
	<div id="changeList">
	<c:if test="${empty list }"><h1 style="text-align: center;">검색 결과가 없습니다.</h1></c:if>
	<c:forEach var="list" items="${list }" >
	<div class="mediList" id="${list.hospitalNum }" style="display:inline-block;width:49%;margin-right:5px; position:relative;margin-bottom:20px;height:230px;padding:5px;">
		<div style="display: inline-block;"><img src="${path }/resources/uploadfile/hospitalInfo/${list.hospitalRePhoto}" width="200px;" height="210px;"></div>
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
			<button class="reser" name="${list.hospitalNum }">바로 예약하러가기</button>
		</div>
	</div>
		
	</c:forEach>
		${pageBar }
	</div>
	<style>
		.reser{
		width:250px;
		height:40px;
		font-size:20px;
		background-color:white;
		border:2px solid lightgray;
		border-radius:5px;
		box-shadow:3px 3px 5px lightgray;
		
	}
	 .reser:hover{
		background-color:#286090;
		color:white;
	} 
	</style>
	<script>
		$('.reser').click(function (event) {
			location.href='${path}/medi/reser?no='+$(this).attr('name');
			event.stopPropagation();
		});
		$('.reser').mouseover(function () {
			$(this).parent().parent('.mediList').css("border","");
			event.stopPropagation();
		});
		$('.reser').mouseout(function () {
			$(this).parent().parent('.mediList').css("border","4px solid #286090");
		});
		$(".mediList").mouseover(function () {
			$(this).css("border","4px solid #286090");
			$(this).css("cursor","pointer");
		});
		$(".mediList").mouseout(function () {
			$(this).css("border","4px solid white");
		});		
	</script>
	<script>
	
		$(function () {
			var offset = $("#listId").offset();
			$('html, body').animate({scrollTop : offset.top}, 600);
			
			$(".mediList").click(function () {
				location.href='${path}/medi/mediInfo?no='+$(this).attr('id');
			});
		});
		function fn_paging(cPage,loc,sub){
			$.ajax({
				url:"${path}/medi/medisearchList2",
				data:{loc:loc,sub:sub,cPage:cPage},
				dataType:"html",
				success:function(data){
					console.log(data);
					$('#changeList').html(data);
				}
			});
		}
	</script>