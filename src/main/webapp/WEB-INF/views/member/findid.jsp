<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="" name="pageTitle"/>
</jsp:include>

<style>
	.findid{
		border: 1px solid lightgray;
		width: 500px;
		height: 700px;
		margin: 0 auto;
	}
	
	.findid table{
		font-size: 1.2em;
	}
	
</style>

<div style="height: 200px"></div>


<div class="findid">
	<br><br><br><br>
	<table style="margin: 0 auto;">
	<tr>
		<td>
		</td>
		<td>
			<b>이름</b>
		</td>
		<td>
			&nbsp;:&nbsp;
		</td>
		<td>		
			<input class="form-control" type="text">
		</td>
		<td>
		</td>
	</tr>
	<tr>
		<td colspan="5">
			<br><br>
		</td>
	</tr>
	<tr>
		<td>
		</td>
		<td>
			<b>이메일</b>
		</td>
		<td>
			&nbsp;:&nbsp;
		</td>
		<td>
			<input class="form-control" type="email">
		</td>
		<td style="width: 100px">
		</td>
	</tr>	
	<tr>
		<td colspan="5">
			<br><br><br><br><br>
		</td>
	</tr>
	<tr>
		<td colspan="5">
			<a href="${pageContext.request.contextPath }" style="float: right;">■ 보안코드 전송</a>
		</td>
	</tr>
	<tr>
		<td colspan="5">
			<br><br>
		</td>
	</tr>
	<tr>
		<td></td>
		<td><b>보안코드번호</b></td>
		<td>&nbsp;:&nbsp;</td>
		<td><input class="form-control" type="text"></td>
		<td></td>
	</tr>
	<tr>
		<td colspan="5" style="text-align: center; color: #a0a0a0;">
			인증번호는 6자리로 된 숫자입니다.
		</td>
	</tr>
	<tr>
		<td colspan="5">
			<br><br>
		</td>
	</tr>
	<tr>
		<td colspan="5" style="text-align: center;">
			<input class="btn btn-info btn-lg" type="submit" value="확인" style="margin-right: 70px">
			<input class="btn btn-info btn-lg" type="reset" value="취소">
		</td>
	</tr>
	<tr>
		<td colspan="5" style="text-align: right;">
			<br><br>
			<a href="${pageContext.request.contextPath }">비밀번호를 잃어버리셨나요?</a>
		</td>
	</tr>
	</table>
</div>


<div style="height: 200px"></div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>