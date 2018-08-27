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
			var hospitalId=$(this).val().trim();
			if(hospitalId.length<4){
				$(".guide").hide();
				$("#idDuplicateCheck").val(0);
				return;
			} else {
				if(hospitalId.match(/([ㄱ-ㅎ|가-힣]|([!,@,#,$,%,^,&,*,?,_,~,-]))/) || (hospitalId.match(/([0-9])/) && (hospitalId.match(/([a-zA-Z])/))==null)){
					alert("아이디는 영문과 숫자로 입력해야합니다.");
					$('#hospitalId').val("");
					$('#hospitalId').focus();
					return;
				}
			}
			$.ajax({
				url:"${pageContext.request.contextPath}/member/HcheckId.do",
				data:{hospitalId:$(this).val()},
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

	$(function(){
		$('#hospitalTel').on("keyup",function(){
			var hospitalTel=$('#hospitalTel').val().trim();
			if(hospitalTel.length==11){
				if(!hospitalTel.match(/([0-9])/) || hospitalTel.match(/([ㄱ-ㅎ|가-힣]|([!,@,#,$,%,^,&,*,?,_,~,-]))/) || hospitalTel.match(/([a-zA-Z])/)){
					alert("전화번호는 숫자만 입력이 가능합니다.");
					$('#hospitalTel').val("");
					$('#hospitalTel').focus();
					$('#telCommentOne').css("display","block");
					$('#telCommentTwo').css("display","block");
					return false;
				} else if(hospitalTel.match(/([0-9])/) ){
					return true;
				}
			} else {
				if(!hospitalTel.match(/([0-9])/) || hospitalTel.match(/([ㄱ-ㅎ|가-힣]|([!,@,#,$,%,^,&,*,?,_,~,-]))/) || hospitalTel.match(/([a-zA-Z])/)){
					alert("전화번호는 숫자만 입력이 가능합니다.");
					$('#hospitalTel').val("");
					$('#hospitalTel').focus();
					$('#telCommentOne').css("display","block");
					$('#telCommentTwo').css("display","block");
					return false;
				}
				
			}

		});
	});

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
			<form action="${pageContext.request.contextPath }/member/hospitalEnrollEnd.do" method="post" onsubmit="return fn_enroll_validate();" enctype="multipart/form-data" >
				<table>
					<tr>
						<th style="min-width: 115px">병원 아이디<b>(*)</b></th>
						<td>
							<input type="text" class="form-control" placeholder="4글자이상" name="hospitalId" id="hospitalId" required>
						</td>
					</tr>
					<tr>
						<td>
						</td>
						<td>
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
						<input type="file" name="hospitalLicense" id="hospitalLicense" accept=".jpg, .png, .bmp" style="width: 280px" required>
						</td>
					</tr>
					<tr>
						<th>전화번호<b>(*)</b></th>
						<td>	
							<input type="tel" class="form-control" placeholder="(-없이)0212341234" name="hospitalTel" id="hospitalTel" maxlength="11" required><br>
							<h4 id="telCommentOne" style="font-size: 8pt; color: red; display:none;">* 정확한 전화번호를 입력해주시기 바랍니다.</h4>
							<h4 id="telCommentTwo" style="font-size: 8pt; color: red; display:none;">* 번호가 다를 시 원활한 이용이 불가능할수도 있습니다.</h4>
						</td>
					</tr>
					<tr>
						<th>이메일<b>(*)</b></th>
						<td>	
							<input type="email" class="form-control" placeholder="abc@xyz.com" name="hospitalEmail" id="UserEmail">
						</td>
						<td style="text-align: center">
						
						<a id="emailAuther" style="display: none" onclick="emailRequest()">이메일 인증</a>
							
						<span id="successEmail" style="display: none"><b>인증 완료!</b></span>
						
						</td>
					</tr>
					<tr>
						<th>주소</th>
						<td>
							<input type="text" class="form-control" name="hospitalAddr" id="hospitalAddr" placeholder="도로명주소" readonly>
						</td>
						<td>
							<button type="button" onclick="sample4_execDaumPostcode()" class="btn btn-default" style="margin: 0 0 10px 10px">우편번호 찾기</button>
							<span style="display: none" id="guide" style="color: #999"></span>
						</td>
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
				</table>
				<br><br>
					 <button onclick="return emailcheck()" type="submit" class="btn btn-lg btn-default">회원가입</button>
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
	<script>
	$("#UserEmail").blur(function(){
	      var email=$("#UserEmail").val();
	         if(email.length!=0){
	            if(email.match(/([@])/)){
					if($('#successEmail').css("display")=="none"){
		            	$("#emailAuther").css("display","block");								
					} else{
						$("#emailAuther").css("display","none");
					}
	            } 
	         	else if(email.match(/([!,#,$,%,^,&,*,?,~,-])/)) {
					alert("온전하지 못한 이메일입니다. ('@'를 제외한 특수문자가 존재합니다.)");
					$("#UserEmail").val("");
	                $("#UserEmail").focus();
	                return false;
	            } else {
	            	alert("온전하지 못한 이메일입니다. 다시 한 번 입력해주세요.");
	            	$("#UserEmail").val("");
	                $("#UserEmail").focus();
	            }
	         }
	         return true;
	         $.ajax({
				url:"${pageContext.request.contextPath}/member/HcheckEmail.do",
				data:{hospitalEmail:$('#UserEmail').val()},
				success:function(data){
					if(data == 'true'){
						alert("사용가능한 이메일입니다.");
					} else{
						alert("이메일이 중복되었습니다. 다른 이메일을 입력해주세요.");
						$("#UserEmail").val("");
		                $("#UserEmail").focus();
					}
				}
	         })
	    });
	
	function emailRequest(){
		var nowemail = $('#UserEmail').val();
		var url="${pageContext.request.contextPath }/member/emailEnd.do?UserEmail="+nowemail;
		var title="emailAuther";
		var status="left=500px, top=100px, width=600px, height=200px";
		var popup=window.open(url,title,status);
	}
	
	function emailcheck(){
		if($('#successEmail').css("display") == 'none'){
			alert("이메일을 인증해주세요.");
			return false;
		}
		if($('#J1').prop('checked') || $('#C1').prop('checked') || $('#P1').prop('checked') || $('#S1').prop('checked') ||
	            $('#A1').prop('checked') || $('#B1').prop('checked') || $('#S2').prop('checked') || $('#N1').prop('checked') ||
	            $('#E1').prop('checked') || $('#H1').prop('checked') || $('#SB1').prop('checked')){
	         
	        return true;
	     }
	     else {
	        alert("진료과목을 체크해주세요.");
	        return false;
	     }
		return true;
	}
	</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>