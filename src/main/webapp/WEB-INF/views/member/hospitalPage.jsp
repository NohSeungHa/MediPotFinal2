<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="병원 회원정보 수정" name="pageTitle"/>
</jsp:include>

<style>
	div#enroll-container{width:400px; margin:0 auto; text-align:center;}
	div#enroll-container input, div#enroll-container select {margin-bottom:10px;}
	div#enroll-container table tr{text-align: left; padding-right:10px; font-family:Do Hyeon; }
	div#enroll-container table tr td{margin-right:30px;}
	div#enroll-container table tr th{padding-right:40px;}
</style>

<style>
.jointab {
	text-align: center;
	border: 1.2px solid darkgray;
	border-top-left-radius: 10px;
	border-bottom-left-radius: 10px;
	border-top-right-radius: 10px;
	border-bottom-right-radius: 10px;
	margin: 0 25%;
}
.jointab b{
	color: orange;
	font-size: 10pt;
}
.tbl td {
	text-align: justify;
	font-size: 13pt;
}
</style>
<style>
    /*중복아이디체크관련*/
    div#hospitalId-container{position:relative; padding:0px;}
    div#hospitalId-container span.guide {display:none;font-size: 12px;position:absolute; top:12px; right:10px;}
    div#hospitalId-container span.ok{color:green;}
    div#hospitalId-container span.error{color:red;}
</style>

<!-- 다음 주소API -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                //document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('address').value = fullRoadAddr;
                //document.getElementById('sample4_jibunAddress').value = data.jibunAddress;

                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    //예상되는 도로명 주소에 조합형 주소를 추가한다.
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    document.getElementById('guide').innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    document.getElementById('guide').innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';

                } else {
                    document.getElementById('guide').innerHTML = '';
                }
            }
        }).open();
    }
</script>
<!-- 다음 주소 API끝 -->


<div style="height: 100px"></div>
<div class="jointab">

		<div id="enroll-container">


		<div style="width: 100%; height: 100px; line-height: 100px; text-align: center">
			<img src="${pageContext.request.contextPath }/resources/img/enroll/hospitalEnrollTop.png"
				style="width: 100%; max-width: 760px; vertical-align: middle" />
		</div>



		
		<h2>병원 회원정보 수정</h2>
		<p><b>(*)</b>는 필수 표시사항 입니다.</p>
			<form name="" action="" method="post" onsubmit="return fn_enroll_validate();" >
				<table>
					<tr>
						<th>병원 아이디<b>(*)</b></th>
						<td>
							<div id="hospitalId-container">
								<input type="text" class="form-control" placeholder="4글자이상" name="hospitalId" id="hospitalId_" value="${hospital.hospitalId }" readonly>
							</div>
						</td>
					</tr>
					<tr>
						<th>병원명<b>(*)</b></th>
						<td>	
						<input type="text" class="form-control" name="hospitalName" id="hospitalName" value="${hospital.hospitalName }" required>
						</td>
					</tr>
					<tr>
						<th>사업자번호<b>(*)</b></th>
						<td>	
						<input type="text" class="form-control" name="hospitalLicense" id="hospitalLicense" 
							maxlength="6" placeholder="6자리로 입력해주십시오." value="${hospital.hospitalLicense }" readonly>
						</td>
					</tr>
					<tr>
						<th>전화번호<b>(*)</b></th>
						<td>	
							<input type="tel" class="form-control" placeholder="(-없이)0212341234" name="phone" id="phone" maxlength="11" valuse="${hospital.hospitalTel }" required>
						</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td>	
							<input type="email" class="form-control" placeholder="abc@xyz.com" name="email" value="${hospital.hospitalEmail }" id="email">
						</td>
					</tr>
					<tr>
						<th>주소</th>
						<td>
							<input type="text" class="form-control" name="address" id="address" placeholder="도로명주소" value="${hospital.hospitalAddr }" readonly>
						</td>
						<td>
							&nbsp;
							<button type="button" onclick="sample4_execDaumPostcode()" class="btn btn-default" style="margin-bottom:10px;">우편번호 찾기</button> 
							<span id="guide" style="color: #999"></span>
						</td>
					</tr>
					<tr>
						<td colspan="3" style="text-align:center;">
							 <input type="submit" class="btn btn-lg btn-default" value="회원정보수정"/>
						</td>
					</tr>
					<tr>
						<td colspan="3" style="text-align:center;">
							<input type="button" onclick="location.href='${path}/'" class="btn btn-lg btn-default" value="비밀번호수정"/>
						</td>
					</tr>
				</table>
			</form>
			<div style="width: 100%; height: 100px; line-height: 100px; text-align: center">
			<img src="${pageContext.request.contextPath }/resources/img/enroll/hospitalEnrollBottom.png"
				style="width: 100%; max-width: 760px; vertical-align: middle" />
		</div>
				<br><br>
		</div>
	</div>
	<div style="height: 100px"></div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>