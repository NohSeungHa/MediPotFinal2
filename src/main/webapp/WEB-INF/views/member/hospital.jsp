<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="병원 회원가입" name="pageTitle"/>
</jsp:include>

<style>
	div#enroll-container{width:400px; margin:0 auto; text-align:center;}
	div#enroll-container input, div#enroll-container select {margin-bottom:10px;}
	div#enroll-container table tr{text-align: left; padding-right:10px; font-family:Do Hyeon; }
	div#enroll-container table tr td{margin-right:30px;}
	div#enroll-container table tr th{padding-right:30px;}
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
    div#hospitalId-container span.guide {display:none;font-size: 12px;}
    div#hospitalId-container span.ok{color:green;}
    div#hospitalId-container span.error{color:red;}
</style>

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

<script>
<!-- 비밀번호 유효성 검사 시작 -->
$(function(){
   $("#hospitalPw").blur(function(){
         var p1=$("#hospitalPw").val();
         if(p1.length!=0){
            if(p1.length<8 || !p1.match(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~,-])|([!,@,#,$,%,^,&,*,?,_,~,-].*[a-zA-Z0-9])/)) {
                 alert("비밀번호는 영문(대소문자구분),숫자,특수문자(~!@#$%^&*()-_? 만 허용)를 혼용하여 8~16자를 입력해주세요.");
                 $("#hospitalPw").val("");
                 $("#hospitalPw").focus();
                return false;
               }
         }
         return true;
         
    });
   <!-- 비밀번호 유효성 검사 끝 -->
   
<!-- 비밀번호 일치 여부 확인 -->
   $("#password2").blur(function(){
      var p1=$("#hospitalPw").val();
      var p2=$("#password2").val();
        if(p1!=p2)
         {
            alert("패스워드가 일치하지 않습니다.");
            $("#hospitalPw").focus();
            $("#hospitalPw").val("");
            $("#password2").val("");
         }   
   });
});
<!-- 비밀번호 일치 여부 확인 -->


<!-- 아이디 잘 못 입력시 ajax이용한 출력문 스크립트 시작 -->
	$(function(){
		$('#hospitalId').on("keyup",function(){
			var memberId=$(this).val().trim().length;
			if(memberId<4){
				$(".guide").hide();
				$("#idDuplicateCheck").val(0);
				return;
			}
			$.ajax({
				url:"${pageContext.request.contextPath}/member/HcheckId.do",
				data:{memberId:$(this).val()},
				success:function(data){
					if(data.trim()=='true'){
						$(".guide.error").hide();
						$(".guide.ok").show();
						$("#idDuplicateCheck").val(1);
					}else{
						$(".guide.error").show();
						$(".guide.ok").hide();
						$("#idDuplicateCheck").val(0);
					}
				},
				error:function(jpxhr, textStatus, errormsg){
					console.log("ajax전송실패");
					console.log(jpxhr);
					console.log(textStatus);
					console.log(errormsg);
				}
			})
		});
	});
	<!-- 아이디 잘 못 입력시 ajax이용한 출력문 스크립트 끝 -->



</script>

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
                document.getElementById('hospitalAddr').value = fullRoadAddr;
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
   <!-- 다음 주소 API끝 -->
</script>


<div style="height: 100px"></div>
<div class="jointab">

		<div id="enroll-container">


		<div style="width: 100%; height: 100px; line-height: 100px; text-align: center">
			<img src="${pageContext.request.contextPath }/resources/img/enroll/hospitalEnrollTop.png"
				style="width: 100%; max-width: 760px; vertical-align: middle" />
		</div>



		
		<h2>병원 회원가입</h2>
		<p><b>(*)</b>는 필수 표시사항 입니다.</p>
			<form name="" action="${pageContext.request.contextPath }/member/hospitalEnrollEnd.do" method="post" onsubmit="return fn_enroll_validate();" >
				<table>
					<tr>
						<th>병원 아이디<b>(*)</b></th>
						<td>
							<input type="text" class="form-control" placeholder="4글자이상" name="hospitalId" id="hospitalId" required>
						</td>
					</tr>
					<tr>
						<td>
						</td>
						<td colspan="3">
							<div id="hospitalId-container">
								<span class="guide ok">해당 아이디는 사용가능 합니다.</span>
								<span class="guide error">해당 아이디는 사용불가능 합니다.</span>
								<input type="hidden" name="idDuplicateCheck" id="idDuplicateCheck" value=0/>
							</div>
						</td>
					</tr>
					<tr>
						<th>비밀번호<b>(*)</b></th>
						<td>
							<input type="password" class="form-control" name="hospitalPw" id="hospitalPw" placeholder="8글자 이상(영문,숫자,특수문자)" required>
						</td>
					</tr>
					<tr>
						<th>비밀번호확인<b>(*)</b></th>
						<td>	
							<input type="password" class="form-control" id="password2" required>
						</td>
					</tr>  
					<tr>
						<th>병원명<b>(*)</b></th>
						<td>	
						<input type="text" class="form-control" name="hospitalName" id="hospitalName" required>
						</td>
					</tr>
					<tr>
						<th>사업자번호<b>(*)</b></th>
						<td>	
						<input type="text" class="form-control" name="hospitalLicense" id="hospitalLicense" 
							maxlength="6" placeholder="6자리로 입력해주십시오." required>
						</td>
					</tr>
					<tr>
						<th>전화번호<b>(*)</b></th>
						<td>	
							<input type="tel" class="form-control" placeholder="(-없이)0212341234" name="hospitalTel" id="hospitalTel" maxlength="11" required>
						</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td>	
							<input type="email" class="form-control" placeholder="abc@xyz.com" name="hospitalEmail" id="hospitalEmail">
						</td>
					</tr>
					<tr>
						<th>주소</th>
						<td>
							<input type="text" class="form-control" name="hospitalAddr" id="hospitalAddr" placeholder="도로명주소" readonly>
						</td>
						<td>
							&nbsp;
							<button type="button" onclick="sample4_execDaumPostcode()" class="btn btn-default" style="margin-bottom:10px;">우편번호 찾기</button> 
							<span style="display: none" id="guide" style="color: #999"></span>
						</td>
					</tr>
				</table>
				<br><br>
					 <button type="submit" class="btn btn-lg btn-default">회원가입</button>
					 <br><br>
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