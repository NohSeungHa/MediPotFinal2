<%@page import="com.medi.pot.reservation.model.vo.ReserList"%>
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
	<div style="height:auto;">
		<div><img src="${path }/resources/img/reser/f1.jpg" width="100%" height="200px;"></div>
		<br><br>
		<table id="reserLi" class="table table-hover" style="text-align: center;border-top:2px solid lightgray;">
			<thead>
				<tr>
					<th style="width: 100px;text-align: center;"><h4>병원 이름</h4></th>
					<th style="text-align: center;width: 500px;"><h4>병원 주소</h4></th>
					<th style="width: 180px;text-align: center;"><h4>전화번호</h4></th>
					<th style="width: 90px;text-align: center;"><h4>진료과목</h4></th>
					<th style="width: 150px;text-align: center;"><h4>예약날짜</h4></th>
					<th style="text-align: center;width: 90px;"><h4>예약시간</h4></th>
					<th style="text-align: center;width: 90px;"><h4>예약취소</h4></th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty list }">
					<c:forEach var="resr" items="${list }">
						<tr>
							<td class="hospiName" title="${resr.hospitalNum }"><h4>${resr.hospitalName }</h4></td>
							<td><h4>${resr.hospitalAddr }</h4></td>
							<td><h4>${resr.hospitalTel }</h4></td>
							<td><h4>${resr.hospitalProfessional }</h4></td>
							<td><h4>${resr.checkDate }</h4></td>
							<td><h4>${fn:substring(resr.checkTime,0,2) }:${fn:substring(resr.checkTime,2,4) }</h4></td>
							<td><button class="btn can" title="${resr.checkNum }">예약 취소</button></td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty list}">
					<tr>
						<td colspan="7" style="text-align: center;"><h4>게시글이 존재하지 않습니다.</h4></td>
					</tr>
				</c:if>
			</tbody>
		</table>
		<div>${pageBar }</div>
	</div>
</div>
<style>
	.hospiName{
		color:#286090;
	}
	.hospiName:hover{
		cursor: pointer;
		color:#2A5060;
		text-decoration:underline;
	}
	.can:hover{
		background-color:red;
		color:white;
	}
</style>
<script>
	$(function () {
		if(${msg!=null}){
			alert('${msg}');
		}
		$('.hospiName').click(function () {
			location.href='${path}/medi/mediInfo?no='+$(this).attr('title');
		});
		$('.can').click(function () {
			if(confirm('예약을 취소 하시겠습니까?')){
				alert($(this).attr('title'));
				location.href='${path}/medi/reserDelete?no='+$(this).attr('title')+'&userNum=${memberLoggedIn.memberNum}&cPage=${cPage}';
			}
		});
	});
</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>