<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="병원 등록 절차 1/2" name="pageTitle"/>
</jsp:include>

<style>
.jointab {
	text-align: center;
	border: 1.2px solid darkgray;
	border-top-left-radius: 10px;
	border-bottom-left-radius: 10px;
	border-top-right-radius: 10px;
	border-bottom-right-radius: 10px;
	margin: 0 auto;
	width:80%;
}
.tbl td {
	text-align: justify;
	font-size: 13pt;
}
	div#enroll-container{width:80%; margin:0 auto; text-align:center;}
	div#enroll-container input, div#enroll-container select {margin-bottom:10px;}
	div#enroll-container table tr{text-align: left; padding-right:10px; font-family:Do Hyeon; }
	div#enroll-container table tr td{margin-right:30px;}
	div#enroll-container table tr th{padding-right:30px;}
</style>



<div style="height:100px"></div>
<section id='board-contianer' class='container'>


	<div class="jointab">
			<h1>MediPot에 오신 것을 환영합니다.</h1>
			<h4>*병원 추가정보를 등록해주세요.</h4>
			<h4>*병원 등록 절차 2단계중 1단계입니다.</h4>
		<div class="enroll-container">
			<form action="" method="post">
				<table>
					<tr>
						<td>병원소개를 입력하세요.</td>
						<td><textarea name=""></textarea></td>
					</tr>
					<tr>
						<td>병원 공지사항을 입력하세요.</td>
						<td><textarea name=""></textarea></td>
					</tr>
					<tr>
						<td>병원 운영시간을 입력하세요.</td>
						<td><input type="time" name=""/></td>
					</tr>
					<tr>
						<td>병원 점심시간을 입력하세요.</td>
						<td><input type="time" name=""/></td>
					</tr>
					<tr>
						<td colspan='2'>
							
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>










</section>

<div style="height:100px"></div>


<jsp:include page="/WEB-INF/views/common/footer.jsp"/>