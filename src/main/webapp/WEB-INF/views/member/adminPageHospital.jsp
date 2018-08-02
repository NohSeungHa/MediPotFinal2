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
		<h1>병원 회원 관리 페이지</h1>
		*'승인 대기 중' 버튼을 클릭하면 해당 병원을 가입 승인 처리할 수 있습니다.
	</div>




	<table id='tbl-board' class='table table-striped table-hover'>
		<tr>
			<th>회원번호</th>
			<th>아이디</th>
			<th>병원명</th>
			<th>사업자번호</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>병원주소</th>
			<th>가입일</th>
			<th>승인여부</th>			
		</tr>
		<c:if test="${not empty list }">
			<c:forEach var='h' items='${list }' varStatus="vs">
				<tr>
					<td>${h.hospitalNum }</td>
					<td>${h.hospitalId }</td>
					<td>${h.hospitalName }</td>
					<td>${h.hospitalLicense }</td>
					<td>${h.hospitalTel }</td>
					<td>${h.hospitalEmail }</td>
					<td>${h.hospitalAddr }</td>
					<td>${h.hospitalDate }</td>
					<td>
						<c:if test="${h.hospitalAdmission==0}">
							<button class="btn btn-default" onclick="movePage(${h.hospitalNum })">승인 대기중</button>
						</c:if>
						<c:if test="${h.hospitalAdmission==1 }">
							승인완료
						</c:if>
					</td>
				</tr>	
			</c:forEach>
		</c:if>
	</table>
	${pageBar }
	
		<button class="btn btn-default" onclick="movePage2()">돌아가기</button>
	<div style="height:100px"></div>
</section>

<script>
	function movePage(e){
		console.log(e);
		location.href="${pageContext.request.contextPath}/adminPage/admission.do?hospitalNum="+e;
	}
	function movePage2(){
		location.href="${pageContext.request.contextPath}/member/adminPage.jsp";
	}
</script>




<jsp:include page="/WEB-INF/views/common/footer.jsp"/>