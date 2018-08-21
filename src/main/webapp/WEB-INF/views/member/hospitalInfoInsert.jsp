<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="" name="pageTitle"/>
</jsp:include>

<style>
	.HospitalInsertFrm{
		margin: 0 auto;
		width: 80%;
		height: 1000px;
	}
	.HospitalInsertFrm .tblFrm{
		margin: 0 auto;
	}
	textarea{
		form-control;
	}
	.tblFrm td{
		padding: 10px;
	}
</style>
<c:if test="${memberLoggedIn == null }">
	<script>
		$(function(){
			alert("잘못된 접근입니다.");
			location.href="${pageContext.request.contextPath}";
		})	
	</script>
</c:if>
<div style="height: 100px">
	
</div>

<div class="HospitalInsertFrm">
	<h1 style="text-align: center">병 원 정 보 입 력</h1>
	<form action="${pageContext.request.contextPath }/member/hospitalInfoInsert.do" method="post" enctype="multipart/form-data">
		<table class="tblFrm">
			<tr>
				<th>병원 명</th>
				<td>
					<input type="text" class="form-control" style="width: 200px" value="${hospitalName }" name="hospitalName" readonly>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: 1px dotted lightgray"></td>
			</tr>
			<tr>
				<th><br>병원소개</th>
				<td><br>
					<textarea name="hospitalInfoIntro" class="form-control" cols="100" rows="10" maxlength="1000" style="width: 800px"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: 1px dotted lightgray"></td>
			</tr>
			<tr>
				<th><br>공지사항</th>
				<td><br>
					<textarea name="hospitalInfoNotice" class="form-control" cols="100" rows="10" maxlength="1000" style="width: 800px"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: 1px dotted lightgray"></td>
			</tr>
			<tr>
				<th><br>병원사진</th>
				<td><br>
					<input type="file" name="hospitalPhoto" id="hospitalPhoto" accept=".jpg, .png, .bmp"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: 1px dotted lightgray"></td>
			</tr>
			<tr>
				<th><br>병원이용시간</th>
				<td><br>
					<input type="text" class="form-control" name="hospitalInfoUsetime">
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: 1px dotted lightgray"></td>
			</tr>
			<tr>
				<th><br>병원점심시간</th>
				<td><br>
					<input type="text" class="form-control" name="hospitalInfoLunchtime">
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: 1px dotted lightgray"></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center">
					<input type="submit" class="btn btn-info btn-lg" value="입력" style="margin-right: 50px">
					<input type="reset" class="btn btn-info btn-lg" value="취소">
					<input type="hidden" value="${hospitalNum }" name="hospitalNum">
				</td>
			</tr>
		</table>
	</form>
</div>

<div style="height: 200px">
	
</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>