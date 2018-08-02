<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="관리자 페이지" name="pageTitle"/>
</jsp:include>







<style>
	input#btn-add {float:right; margin:0 0 15px;}
</style>
<section id='board-contianer' class='container'>


	<div style="height:100px">
		<h1>일반 회원 관리 페이지</h1>
	</div>


	<table id='tbl-board' class='table table-striped table-hover'>
		<tr>
			<th>회원번호</th>
			<th>아이디</th>
			<th>이름</th>
			<th>성별</th>
			<th>생일</th>
			<th>휴대전화</th>
			<th>이메일</th>
			<th>주소</th>
			<th>가입일</th>			
		</tr>
		<c:if test="${not empty list }">
			<c:forEach var='m' items='${list }' varStatus="vs">
				<tr>
					<td>${m.memberNum }</td>
					<td>${m.memberId }</td>
					<td>${m.memberName }</td>
					<td>${m.memberGender }</td>
					<td>${m.memberBirth }</td>
					<td>${m.memberPhone }</td>
					<td>${m.memberEmail }</td>
					<td>${m.memberAddr }</td>
					<td>${m.memberDate }</td>
				</tr>	
			</c:forEach>
		</c:if>
	</table>
	${pageBar }
	<div style="height:100px"></div>
</section>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>