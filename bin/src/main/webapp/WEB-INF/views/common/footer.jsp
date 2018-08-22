<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="<%=request.getContextPath() %>"/>

	<!-- 푸터 공간입니다. -->
	<footer style="background-color: #2c3e50; color:#ffffff">
		<div class="container">
			<br>
			<div class="row">
				<!-- col-sm은 12개로 나뉘어져 있따. -->
				<div class="col-sm-2" style="text-align: center;"><img src="${path }/resources/img/common/MediPot_logo.png" width="180" height="40px" style="margin-top:30px;"></div>
			<div class="col-sm-7" style="text-align: center;"><table style="color:white;" align="center">
					<tr>
						<td>회사소개 | 제휴문의 | 약관보기 | 개인정보처리방침 | 전자우편 | 사업자정보공개사이트 | 사이트맵<br><br></td>
					</tr>
					<tr>
						<td>MediPot(주) 사업자번호 : 123-45-6789 통신판매업신고번호 : 제 2018-서울강남-1800호 </td>
					</tr>
					<tr>
						<td>대표 : 가디언즈 사업자 : MediPot(주)</td>
					</tr>
					<tr>
						<td>서울시 강남구 테헤란로 14길 6 남도빌딩 F층 고객센터:010-7912-0395 </td>
					</tr>
					<tr>
						<td>Copyright © Netmarble Corp. All Rights Reserved.</td>
					</tr>
				</table></div>

					<div class="col-sm-3">
								<div style="margin-left:40px;">
								<h4>□&nbsp; 채슬기 seul gi Chae</h4>
								<h4>□&nbsp; 노승하 seung ha Noh</h4>
								<h4>□&nbsp; 이동혁 dong hyuk Lee</h4>
								<h4>□&nbsp; 박정현 jeong hyen Park</h4>
								<h4>□&nbsp; 박봉주 bong ju Park</h4>
								</div>
					</div>
				</div>
			</div>	
	</footer>

	<!-- 모달 적용부분입니다. -->
	<div class="row">
		<div class="modal" id="modal" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header"><!-- 모달의 제목창 -->
						메디팟 서비스의 특징
						<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body" style="text-align: center;">
						MediPot 서비스의 특징은 바로, 전국 병원을 예약할 수 있다는 점입니다.<br>
						<img src="images/hopital.jpg" id="imagepreview" style="width:500px; height:256px;">
					</div>
			</div>
		</div>
	</div>
	<!-- 모달 적용 끝 ! -->




</body>
</html>