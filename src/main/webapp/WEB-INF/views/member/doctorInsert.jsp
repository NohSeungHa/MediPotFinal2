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
<c:if test="${memberLoggedIn == null }">
	<script>
		$(function(){
			alert("잘못된 접근입니다.");
			location.href="${pageContext.request.contextPath}";
		})	
	</script>
</c:if>
<div style="height: 200px">
	
</div>

<div class="DoctorInsertFrm">
	<h1 style="text-align: center">의 사 정 보 입 력</h1>
	<form action="${pageContext.request.contextPath }/member/doctorInfoInsertEnd.do" method="post" enctype="multipart/form-data">
		<table class="tblFrm">
			<tr>
				<th><br>의사 명</th>
				<td><br>
					<input type="text" class="form-control" style="width: 200px" name="doctorName" placeholder="의사명을 입력해주세요." required>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: 1px dotted lightgray"></td>
			</tr>
			<tr>
				<th><br>의사이력</th>
				<td><br>
					<textarea name="doctorCareer" class="form-control" cols="100" rows="10" maxlength="1000" style="width: 800px" placeholder="의사의 이력을 입력해주세요."></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: 1px dotted lightgray"></td>
			</tr>
			<tr>
				<th><br>병원 명</th>
				<td><br>
					<input type="text" class="form-control" style="width: 200px" name="hospitalName" value="${hospital.hospitalName }" readonly>
					<input type="hidden" class="form-control" name="hospitalNum" value="${hospital.hospitalNum }" readonly>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: 1px dotted lightgray"></td>
			</tr>
			<tr>
				<th><br>진료과목</th>
				<td><br>
					<input type="checkbox" name="professional" id="J1" value="정형외과">
					<label for="J1">정형외과&nbsp;&nbsp;</label>
					<input type="checkbox" name="professional" id="C1" value="치과">
					<label for="C1">치과&nbsp;&nbsp;</label>
					<input type="checkbox" name="professional" id="P1" value="피부과">
					<label for="P1">피부과&nbsp;&nbsp;</label>
					<input type="checkbox" name="professional" id="S1" value="성형외과">
					<label for="S1">성형외과</label><br>
					
					<input type="checkbox" name="professional" id="A1" value="안과">
					<label for="A1">안과&nbsp;&nbsp;</label>
					<input type="checkbox" name="professional" id="B1" value="비뇨기과">
					<label for="B1">비뇨기과&nbsp;&nbsp;</label>
					<input type="checkbox" name="professional" id="S2" value="신경외과">
					<label for="S2">신경외과&nbsp;&nbsp;</label>
					<input type="checkbox" name="professional" id="N1" value="내과">
					<label for="N1">내과</label><br>
					
					<input type="checkbox" name="professional" id="E1" value="이비인후과">
					<label for="E1">이비인후과&nbsp;&nbsp;</label>
					<input type="checkbox" name="professional" id="H1" value="한의원">
					<label for="H1">한의원&nbsp;&nbsp;</label>
					<input type="checkbox" name="professional" id="SB1" value="산부인과">
					<label for="SB1">산부인과</label><br>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: 1px dotted lightgray"></td>
			</tr>
			<tr>
				<th><br>점심시간 (예 : 1200 ~ 1300)</th>
				<td><br>
					<input type="text" class="form-control" style="width: 150px; display: inline-block" name="doctorSlunch" id="doctorSlunch"> ~ <input type="text" class="form-control" style="width: 150px; display: inline-block" name="doctorElunch" id="doctorElunch"> 
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: 1px dotted lightgray"></td>
			</tr>
			<tr>
				<th><br>평일시간 (예 : 0900 ~ 1700)</th>
				<td><br>
					<input type="text" class="form-control" style="width: 150px; display: inline-block" name="WeekdayStime" id="WeekdayStime"> ~ <input type="text" class="form-control" style="width: 150px; display: inline-block" name="WeekdayEtime" id="WeekdayEtime">
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: 1px dotted lightgray"></td>
			</tr>
			<tr>
				<th><br>토요일시간 (예 : 0900 ~ 1200)</th>
				<td><br>
					<input type="text" class="form-control" style="width: 150px; display: inline-block" name="SatStime" id="SatStime"> ~ <input type="text" class="form-control" style="width: 150px; display: inline-block" name="SatEtime" id="SatEtime">
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: 1px dotted lightgray"></td>
			</tr>
			<tr>
				<th><br>휴무일 (예: 월요일)</th>
				<td><br>
					<input type="text" class="form-control" style="width: 200px" name="closed" placeholder="휴무일을 입력해주세요.">
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: 1px dotted lightgray"></td>
			</tr>
			<tr>
				<th><br>전문분야</th>
				<td><br>
					<input type="text" class="form-control" style="width: 200px" name="Specialized" placeholder="전문분야를 입력해주세요." required>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: 1px dotted lightgray"></td>
			</tr>
			<tr>
				<th><br>의사사진</th>
				<td><br>
					<input type="file" name="doctorPhoto" id="doctorPhoto" accept=".jpg, .png, .bmp" style="width: 200px" required>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: 1px dotted lightgray"></td>
			</tr>
			<tr>
				<th><br>진료간격 (예: (분단위로 입력) 15)</th>
				<td><br>
					<input type="text" name="timeInterval" class="form-control" style="width: 200px" placeholder="시간간격을 입력해주세요." required>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="border-bottom: 1px dotted lightgray"></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center">
					<input type="submit" class="btn btn-info btn-lg" value="입력" style="margin-right: 50px">
					<input type="reset" class="btn btn-info btn-lg" value="취소">
				</td>
			</tr>
		</table>
	</form>
</div>

<div style="height: 200px">
	
</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>