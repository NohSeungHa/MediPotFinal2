<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="일반 회원가입" name="pageTitle"/>
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
    div#memberId-container{position:relative; padding:0px;}
    div#memberId-container span.guide {display:none;font-size: 12px;}
    div#memberId-container span.ok{color:green;}
    div#memberId-container span.error{color:red;}
</style>

<script>
<!-- 비밀번호 유효성 검사 시작 -->
$(function(){
   $("#memberPw").blur(function(){
         var p1=$("#memberPw").val();
         if(p1.length!=0){
            if(p1.length<8 || !p1.match(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~,-])|([!,@,#,$,%,^,&,*,?,_,~,-].*[a-zA-Z0-9])/)) {
                 alert("비밀번호는 영문(대소문자구분),숫자,특수문자(~!@#$%^&*()-_? 만 허용)를 혼용하여 8~16자를 입력해주세요.");
                 $("#memberPw").val("");
                 $("#memberPw").focus();
                return false;
               }
         }
         return true;
         
    });
   <!-- 비밀번호 유효성 검사 끝 -->
   
	<!-- 비밀번호 일치 여부 확인 -->
   $("#password2").blur(function(){
      var p1=$("#memberPw").val();
      var p2=$("#password2").val();
        if(p1!=p2)
         {
            alert("패스워드가 일치하지 않습니다.");
            $("#memberPw").focus();
            $("#memberPw").val("");
            $("#password2").val("");
         }   
   });
});
<!-- 비밀번호 일치 여부 확인 -->
$(function(){
<!-- 이름 유효성 검사 시작 -->
    $("#memberName").blur(function(){
      var name=$("#memberName").val();
         if(name.length!=0){
            if(name.match(/([0-9])|([!,@,#,$,%,^,&,*,?,_,~,-])/)) {
                 alert("이름은 영문과 한글만 입력 가능합니다.");
                 $("#memberName").val("");
                 $("#memberName").focus();
                return false;
               }
         }
         return true;
    });
});
<!-- 아이디 유효성 검사 끝 -->

<!-- 아이디 잘 못 입력시 ajax이용한 출력문 스크립트 시작 -->
	$(function(){
		$('#memberId').on("keyup",function(){
			var memberId=$(this).val().trim();
			if(memberId.length<4){
				$(".guide").hide();
				$("#idDuplicateCheck").val(0);
				return;
			} else {
				if(memberId.match(/([ㄱ-ㅎ|가-힣]|([!,@,#,$,%,^,&,*,?,_,~,-]))/) || (memberId.match(/([0-9])/) && (memberId.match(/([a-zA-Z])/))==null)){
					alert("아이디는 영문과 숫자로 입력해야합니다.");
					$('#memberId').val("");
					$('#memberId').focus();
					return;
				}
			}
			$.ajax({
				url:"${pageContext.request.contextPath}/member/PcheckId.do",
				data:{memberId:$(this).val()},
				success:function(data){
					if(data == 'true'){
						$(".guide.error").hide();
						$(".guide.ok").show();
						$("#idDuplicateCheck").val(1);
					}else{
						$(".guide.ok").hide();
						$(".guide.error").show();
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
                document.getElementById('memberAddr').value = fullRoadAddr;
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
			<img src="${pageContext.request.contextPath }/resources/img/enroll/personEnrollTop.png"
				style="width: 100%; max-width: 760px; vertical-align: middle" />
		</div>



		
		<h2>일반 회원가입</h2>
		<p><b>(*)</b>는 필수 표시사항 입니다.</p>
			<form name="memberEnrollFrm" action="${pageContext.request.contextPath }/member/memberEnrollEnd.do" method="post">
				<table>
					<tr>
						<th>아이디<b>(*)</b></th>
						<td>
							<input type="text" class="form-control" placeholder="4글자이상" name="memberId" id="memberId" required>
						</td>
					</tr>
					<tr>
						<td>
						</td>
						<td colspan="3">
							<div id="memberId-container">
								<span class="guide ok">해당 아이디는 사용가능 합니다.</span>
								<span class="guide error">해당 아이디는 사용불가능 합니다.</span>
								<input type="hidden" name="idDuplicateCheck" id="idDuplicateCheck" value=0/>
							</div>
						</td>
					</tr>
					<tr>
						<th>비밀번호<b>(*)</b></th>
						<td>
							<input type="password" class="form-control" name="memberPw" id="memberPw" placeholder="8글자 이상(영문,숫자,특수문자)" required>
						</td>
					</tr>
					<tr>
						<th>비밀번호확인<b>(*)</b></th>
						<td>	
							<input type="password" class="form-control" id="password2" required>
						</td>
					</tr>  
					<tr>
						<th>이름<b>(*)</b></th>
						<td>	
						<input type="text" class="form-control" name="memberName" id="memberName" required>
						</td>
					</tr>
					<tr>
						<th>생년월일<b>(*)</b></th>
						<td>	
						<input type="text" class="form-control" name="memberBirth" id="memberBirth" 
							maxlength="6" placeholder="6자리로 입력해주십시오." required>
						</td>
					</tr>
					<tr>
						<th>성별</th>
						<td>
							<div class="form-check form-check-inline">
								<input type="radio" class="form-check-input" name="memberGender" id="gender0" value="M" checked>
								<label for="gender0">남</label>
								<input type="radio" class="form-check-input" name="memberGender" id="gender1" value="F">
								<label for="gender1">여</label>
							</div>
						</td>
					</tr>
					<tr>
						<th>휴대폰<b>(*)</b></th>
						<td>	
							<input type="tel" class="form-control" placeholder="(-없이)01012345678" name="memberPhone" id="phone" maxlength="11" required>
						</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td>	
							<input type="email" class="form-control" placeholder="abc@xyz.com" name="memberEmail" id="UserEmail">
						</td>
						<td style="text-align: center">
							
								<%-- <a href="${pageContext.request.contextPath }/member/emailEnd.do" data-toggle="modal" data-target="#emailModal" id="emailAuther" style="display: none">이메일 인증</a> --%>
								<a id="emailAuther" style="display: none" onclick="emailRequest()">이메일 인증</a>
							
								<span id="successEmail" style="display: none"><b>인증 완료!</b></span>
							
						</td>
					</tr>
					<tr>
						<th>주소</th>
						<td>
							<input type="text" class="form-control" name="memberAddr" id="memberAddr" placeholder="도로명주소" readonly>
						</td>
						<td>
							<button type="button" onclick="sample4_execDaumPostcode()" class="btn btn-default" style="margin: 0px 0px 10px 10px;">우편번호 찾기</button> 
							<span style="display: none" id="guide" style="color: #999"></span>
						</td>
					</tr>
				</table>
				<br><br>
					 <button onclick="return joincheck()" type="submit" class="btn btn-lg btn-default">회원가입</button>
					 <br><br>
			</form>
			<div style="width: 100%; height: 100px; line-height: 100px; text-align: center">
			<img src="${pageContext.request.contextPath }/resources/img/enroll/personEnrollBottom.png"
				style="width: 100%; max-width: 760px; vertical-align: middle" />
		</div>
				<br><br>
		</div>
	</div>	
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
					url:"${pageContext.request.contextPath}/member/PcheckEmail.do",
					data:{memberEmail:$('#UserEmail').val()},
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
		
		function joincheck(){
			if($('#successEmail').css("display") == 'none'){
				alert("이메일을 인증해주세요.");
				return false;
			}
			if($('#memberId').val().trim().length < 4){
				alert("아이디는 4글자 이상 입력해야 합니다.");
				return false;
			}
			return true;
		}
		</script>
		
<div style="height: 100px"></div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>