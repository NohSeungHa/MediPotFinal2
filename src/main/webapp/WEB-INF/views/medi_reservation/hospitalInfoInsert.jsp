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
		height: 800px;
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

<div style="height: 200px">
	
</div>

<div class="HospitalInsertFrm">
	<h1 style="text-align: center">병 원 정 보 입 력</h1>
	<form action="${path }/medi/hospitalInsert.do" method="post">
		<table class="tblFrm">
			<tr>
				<th>병원 명</th>
				<td>
					<input type="text" class="form-control" style="width: 200px" value="가나다병원" name="hospitalName" readonly>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: 1px dotted lightgray"></td>
			</tr>
			<tr>
				<th>병원소개</th>
				<td><br>
					<textarea name="hospitalInfoIntro" cols="100" rows="10" maxlength="1000" style="width: 800px">
						
					</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: 1px dotted lightgray"></td>
			</tr>
			<tr>
				<th>병원사진</th>
				<td><br>
					<input type="file" name="hospitalPhoto">
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: 1px dotted lightgray"></td>
			</tr>
			<tr>
				<th>병원이용시간</th>
				<td><br>
					<input type="text" name="hospitalInfoUsetime">
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: 1px dotted lightgray"></td>
			</tr>
			<tr>
				<th>병원점심시간</th>
				<td><br>
					<input type="text" name="hospitalInfoLunchtime">
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: 1px dotted lightgray"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="입력">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
</div>

<div style="height: 200px">
	
</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>