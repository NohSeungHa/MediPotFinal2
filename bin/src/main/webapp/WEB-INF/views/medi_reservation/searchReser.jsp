<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>

	<c:set var='path' value="<%=request.getContextPath() %>"></c:set>
<jsp:include page="/WEB-INF/views/common/header.jsp">
<jsp:param value="HomeSpring" name="pageTitle"></jsp:param>
</jsp:include>
<div style="height:auto;">
		<div style="position:relative;height:280px;">
			<div style="position:absolute;left:470px;"><img src="${path }/resources/img/reser/listReser.png" width="1000px;" height="280px;"></div>
			<div style="position: absolute;font-size:70px;left:920px;top:50px;">${date }</div>
		</div>
		<br><br>
		<table id="reserLi" class="table table-hover" style="text-align: center;border-top:2px solid lightgray;">
			<thead>
				<tr>
					<th style="width: 80px;text-align: center;"><h4>의사명</h4></th>
					<th style="text-align: center;width: 80px;"><h4>예약자</h4></th>
					<th style="text-align: center;width: 80px;"><h4>성별</h4></th>
					<th style="width: 90px;text-align: center;"><h4>생년월일</h4></th>
					<th style="width: 90px;text-align: center;"><h4>핸드폰</h4></th>
					<th style="width: 300px;text-align: center;"><h4>주소</h4></th>
					<th style="text-align: center;width: 600px;"><h4>남긴메세지</h4></th>
					<th style="text-align: center;width: 90px;"><h4>예약시간</h4></th>
					<th style="text-align: center;width: 90px;"><h4>예약취소</h4></th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty list }">
					<c:forEach var="resr" items="${list }">
						<tr>
							<td><h4>${resr.doctorName }</h4></td>
							<td><h4>${resr.memberName }</h4></td>
							<td><h4><c:if test="${resr.memberGender eq 'M' }">남자</c:if><c:if test="${resr.memberGender eq 'F' }">여자</c:if></h4></td>
							<td><h4>${resr.memberBirth }</h4></td>
							<td><h4>${resr.memberPhone }</h4></td>
							<td><h4>${resr.memberAddr }</h4></td>
							<td><h4>${resr.sendMsg }</h4></td>
							<td><h4>${fn:substring(resr.checkTime,0,2) }:${fn:substring(resr.checkTime,2,4) }</h4></td>
							<td><button class="btn can" title="${resr.checkNum }" name="${resr.doctorNum }" value="${resr.checkDate }">예약 취소</button></td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${empty list}">
					<tr>
						<td colspan="9" style="text-align: center;"><h4>예약이 존재하지 않습니다.</h4></td>
					</tr>
				</c:if>
			</tbody>
		</table>
		<br>
		<div> ${pageBar }</div>
		<br>
	</div>

<style>
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
		$('.can').click(function () {
			if(confirm('예약을 취소 하겠습니까?')){
				location.href='${path}/medi/deleteSearchReser?num='+$(this).attr("title")+'&docNum='+$(this).attr("name")+'&date='+$(this).val();
			}
		});
		
	});
</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>