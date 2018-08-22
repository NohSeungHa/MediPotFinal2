<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="" name="pageTitle"/>
</jsp:include>

<style>
	.deleteMember{
		margin: 0 auto;
		height: 600px;
		text-align: center;
	}
	
	.deletetbl{
		border: 1px solid lightgray;
		margin: 0 auto;
		width: 350px;
		height: 150px
	}
	
	.deletetbl th{
		padding: 20px;
	}
	
	.deletetbl td{
		padding: 20px;
	}
</style>

<div style="height: 100px">
</div>

<div class="deleteMember">
	<h1>회원 탈퇴</h1>
	<p>
		<h3>정말로 회원 탈퇴를 하시겠습니까?</h3>
		<h4>** 회원 가입시 입력한 아이디와 비밀번호를 입력해주세요. **</h4>
		<h4>** 일치하지 않는다면 회원 탈퇴가 되지 않습니다. **</h4>
	</p>
	<br>
	<form action="${pageContext.request.contextPath }/member/deleteMemberEnd.do">
	<table class="deletetbl">
		<tr>
			<th>아이디 : </th>
			<td><input type="text" name="memberId" class="form-control"></td>
		</tr>
		<tr>
			<th>비밀번호 : </th>
			<td><input type="password" name="memberPw" class="form-control"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" class="btn btn-lg btn-info" value="확인" style="margin-right: 50px">
				<input type="reset" class="btn btn-lg btn-info" value="취소">
			</td>
		</tr>
	</table>
	</form>
</div>

<div style="height: 100px">
</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>