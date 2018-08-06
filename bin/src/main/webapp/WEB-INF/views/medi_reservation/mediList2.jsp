<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>

	<c:set var='path' value="<%=request.getContextPath() %>"></c:set>
<c:forEach var="list" items="${list }" >
	<div class="mediList" id="${list.hospitalNum }" style="display:inline-block;width:49%;margin-right:5px; position:relative;margin-bottom:20px;">
		<div style="display: inline-block;"><img src="${path }/resources/img/reser/${list.hospitalPhoto}" width="200px;" height="200px;"></div>
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
	${pageBar}
	
	<script>
	$(function () {
		$(".mediList").click(function () {
			location.href='${path}/medi/mediInfo?no='+$(this).attr('id');
		});
	});
	</script>