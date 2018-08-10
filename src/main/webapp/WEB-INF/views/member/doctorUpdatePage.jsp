<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="" name="pageTitle"/>
</jsp:include>

<style>
	.DoctorInsertFrm{
		margin: 0 auto;
		width: 80%;
		height: 1300px;
	}
	.DoctorInsertFrm .tblFrm{
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

<div class="DoctorInsertFrm">
	<h1 style="text-align: center">의 사 정 보 수 정</h1>
	<form action="${pageContext.request.contextPath }/member/doctorInfoUpdateEnd.do" method="post" enctype="multipart/form-data">
		<table class="tblFrm">
			<tr>
				<th><br>의사 명</th>
				<td><br>
					<input type="text" class="form-control" style="width: 200px" name="doctorName" value="${doctorInfo.doctorName }" readonly>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: 1px dotted lightgray"></td>
			</tr>
			<tr>
				<th><br>의사이력</th>
				<td><br>
					<textarea name="doctorCareer" cols="100" rows="10" maxlength="1000" style="width: 800px">${doctorInfo.doctorCareer }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: 1px dotted lightgray"></td>
			</tr>
			<tr>
				<th><br>병원 명</th>
				<td><br>
					<input type="text" class="form-control" style="width: 200px" name="hospitalName" value="${hospitalName }" readonly>
					<input type="hidden" class="form-control" name="hospitalNum" value="${hospital.hospitalNum }" readonly>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: 1px dotted lightgray"></td>
			</tr>
			<tr>
				<th><br>진료과목</th>
				<td><br>
				<c:forEach var="docpro" items="${professional }" varStatus="vs">
					<input type="checkbox" name="professional" id="J1" value="정형외과"
					<c:if test="${docpro=='정형외과' }">checked</c:if> >
					<label for="J1">정형외과&nbsp;&nbsp;</label>
					<input type="checkbox" name="professional" id="C1" value="치과"
					<c:if test="${docpro=='치과' }">checked</c:if> >
					<label for="C1">치과&nbsp;&nbsp;</label>
					<input type="checkbox" name="professional" id="P1" value="피부과"
					<c:if test="${docpro=='피부과' }">checked</c:if> >
					<label for="P1">피부과&nbsp;&nbsp;</label>
					<input type="checkbox" name="professional" id="S1" value="성형외과"
					<c:if test="${docpro=='성형외과' }">checked</c:if> >
					<label for="S1">성형외과</label><br>
					
					<input type="checkbox" name="professional" id="A1" value="안과"
					<c:if test="${docpro=='안과' }">checked</c:if> >
					<label for="A1">안과&nbsp;&nbsp;</label>
					<input type="checkbox" name="professional" id="B1" value="비뇨기과"
					<c:if test="${docpro=='비뇨기과' }">checked</c:if> >
					<label for="B1">비뇨기과&nbsp;&nbsp;</label>
					<input type="checkbox" name="professional" id="S2" value="신경외과"
					<c:if test="${docpro=='신경외과' }">checked</c:if> >
					<label for="S2">신경외과&nbsp;&nbsp;</label>
					<input type="checkbox" name="professional" id="N1" value="내과"
					<c:if test="${docpro=='내과' }">checked</c:if> >
					<label for="N1">내과</label><br>
					
					<input type="checkbox" name="professional" id="E1" value="이비인후과"
					<c:if test="${docpro=='이비인후과' }">checked</c:if> >
					<label for="E1">이비인후과&nbsp;&nbsp;</label>
					<input type="checkbox" name="professional" id="H1" value="한의원"
					<c:if test="${docpro=='한의원' }">checked</c:if> >
					<label for="H1">한의원&nbsp;&nbsp;</label>
					<input type="checkbox" name="professional" id="SB1" value="산부인과"
					<c:if test="${docpro=='산부인과' }">checked</c:if> >
					<label for="SB1">산부인과</label><br>
				</c:forEach>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: 1px dotted lightgray"></td>
			</tr>
			<tr>
				<th><br>점심시간 (예 : 1200 ~ 1300)</th>
				<td><br>
					<input type="text" name="doctorSlunch" id="doctorSlunch" value="${doctorInfo.doctorSlunch }"> ~ <input type="text" name="doctorElunch" id="doctorElunch" value="${doctorInfo.doctorElunch }"> 
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: 1px dotted lightgray"></td>
			</tr>
			<tr>
				<th><br>평일시간 (예 : 0900 ~ 1700)</th>
				<td><br>
					<input type="text" name="weekdayStime" id="weekdayStime" value="${doctorInfo.weekdayStime }"/> ~ <input type="text" name="weekdayEtime" id="weekdayEtime" value="${doctorInfo.weekdayEtime }"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: 1px dotted lightgray"></td>
			</tr>
			<tr>
				<th><br>토요일시간 (예 : 0900 ~ 1200)</th>
				<td><br>
					<input type="text" name="satStime" id="satStime" value="${doctorInfo.satStime }"> ~ <input type="text" name="satEtime" id="satEtime" value="${doctorInfo.satEtime }">
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: 1px dotted lightgray"></td>
			</tr>
			<tr>
				<th><br>휴무일 (예: 월요일)</th>
				<td><br>
					<input type="text" class="form-control" style="width: 200px" name="closed" value="${doctorInfo.closed }">
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: 1px dotted lightgray"></td>
			</tr>
			<tr>
				<th><br>전문분야</th>
				<td><br>
					<input type="text" class="form-control" style="width: 200px" name="specialized" value="${doctorInfo.specialized }" required>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: 1px dotted lightgray"></td>
			</tr>
			<tr>
				<th><br>의사사진</th>
				<td><br>
					<input type="file" name="doctorPhoto" id="doctorPhoto" accept=".jpg, .png, .bmp" style="width: 200px" required>
					<input type="hidden" name="olddoctorPhoto" id="olddoctorPhoto" style="width: 200px" value="${doctorInfo.doctorPhoto }" required>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: 1px dotted lightgray"></td>
			</tr>
			<tr>
				<th><br>진료간격 (예: (분단위로 입력) 15)</th>
				<td><br>
					<input type="text" name="timeInterval" class="form-control" style="width: 200px" value="${doctorInfo.timeInterval }" required>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: 1px dotted lightgray"></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center">
					<input type="submit" class="btn btn-info btn-lg" value="수정" style="margin-right: 50px">
					<input type="reset" class="btn btn-info btn-lg" value="취소">
					<input type="hidden" name="doctorNum" value="${doctorInfo.doctorNum }">
				</td>
			</tr>
		</table>
	</form>
</div>

<div style="height: 200px">
	
</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>