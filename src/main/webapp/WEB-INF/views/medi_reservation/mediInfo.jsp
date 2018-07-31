<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>

	<c:set var='path' value="<%=request.getContextPath() %>"></c:set>
<jsp:include page="/WEB-INF/views/common/header.jsp">
<jsp:param value="Hospital Info" name="pageTitle"></jsp:param>
</jsp:include>
<style>
	#mediInfo{
			width: 100%;
			height: auto;
			padding: 20px;
			-webkit-border-radius: 10px;
			-moz-border-radius: 10px;
			border-radius: 10px;
			margin-top:5px;
			display:inline-block;
			border:2px solid lightgray;
			box-shadow:3px 3px 5px lightgray;
			margin-bottom:100px;
			
	}
	#tblInfo{
		font-size:25px;
		max-width:900px;
	}
	#notice{
		width:500px;
		height:230px;
		background-color:#1A8156;
		border-radius:5px;
		border:8px solid lightgray;
		padding:5px;
		
	}
	#tblInfo th{
		color: #286090;
		text-align:center;
	}
	#reser{
		width:400px;
		height:100px;
		font-size:30px;
		background-color:white;
		border:2px solid lightgray;
		border-radius:5px;
		box-shadow:3px 3px 5px lightgray;
		
	}
	#reser:hover{
		background-color:#286090;
		color:white;
	}
</style>
	<div class="container">	
		<div style="width:100%;height:50px;font-size:20px;text-align:center;background-color:#286090;padding-top:11px;color:white;border-radius:8px;margin-bottom:10px;">
			병원 정보
		</div>
		<div id="mediInfo">
			<table id="tblInfo" align="center">
				<tr>
					<th style="width:350px;"><img src="${path }/resources/img/reser/${hi.hospitalPhoto }" width="300px;" height="230px;"></th>
					<td style="text-align:center;"><div id="notice"><p style="color: black;"><공 지></p><p style="color:white;">${hi.hospitalInfoNotice }</p></div></td>
				</tr>
				<tr>
					<td colspan="2"><hr style="border:1px solid lightgray;"></td>
				</tr>
				<tr>
					<th>병원명</th>
					<td>${hi.hospitalName }</td>
				</tr>
				<tr>
					<td colspan="2"><hr style="border:1px solid lightgray;"></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td>${hi.hospitalTel }</td>
				</tr>
				<tr>
					<td colspan="2"><hr style="border:1px solid lightgray;"></td>
				</tr>
				<tr>
					<th>주소</th>
					<td>${hi.hospitalAddr }</td>
				</tr>
				<tr>
					<td colspan="2"><hr style="border:1px solid lightgray;"></td>
				</tr>
				<tr>
					<th>진료과목</th>
					<td>${hi.hospitalProfessional }</td>
				</tr>
				<tr>
					<td colspan="2"><hr style="border:1px solid lightgray;"></td>
				</tr>
				<tr>
					<th>진료시간</th>
					<td>${hi.hospitalInfoUsetime }</td>
				</tr>
				<tr>
					<td colspan="2"><hr style="border:1px solid lightgray;"></td>
				</tr>
				<tr>
					<th>점심시간</th>
					<td>${hi.hospitalInfoLunchtime }</td>
				</tr>
				<tr>
					<td colspan="2"><hr style="border:1px solid lightgray;"></td>
				</tr>
				<tr>
					<th>병원 소개</th>
					<td>${hi.hospitalInfoIntro }</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center;height:150px;"><button id="reser">예약하러가기</button></td>
				</tr>
			</table>
		</div>
	</div>
<script>
	$(function () {
		$('#reser').click(function () {
			location.href='${path}/medi/reser?no='+${hi.hospitalNum}
		});
	});
</script>
		

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>