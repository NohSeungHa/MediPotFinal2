<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="아이디찾기" name="pageTitle"/>
</jsp:include>

<style>
	.findid{
		border: 5px solid #00aeef;
		border-top-left-radius: 50px;
		border-bottom-left-radius: 50px;
		border-top-right-radius: 50px;
		border-bottom-right-radius: 50px;
		width: 500px;
		height: 700px;
		margin: 0 auto;
	}
	
	.findid table{
		font-size: 1.2em;
	}
	.center{
		text-align: center;
	}
	
</style>

<div style="height: 200px"></div>


<div class="findid">
	<br>
	<h2 class="center">아이디 찾기</h2>
	<br><br><br>
	<form action="${pageContext.request.contextPath }/member/memberFindId.do">
	<table style="margin: 0 auto;">
	<tr>
		<td colspan="5" class="center">
			<input type="radio" value="P" id="findP" name="findPnH" checked>개인
			<input type="radio" value="H" name="findPnH" style="margin-left: 50px">병원
		</td>
	</tr>
	<tr>
		<td colspan="5">
			<br><br>
		</td>
	</tr>
	<tr>
		<td> </td>
		<td> <b>이름</b> </td>
		<td> &nbsp; : &nbsp; </td>
		<td> <input class="form-control" type="text" placeholder="이름을 입력해주세요." style="width: 250px" maxlength="15" id="findname" name="findname"> </td>
		<td> </td>
	</tr>
	<tr>
		<td colspan="5">
			<br><br>
		</td>
	</tr>
	<tr>
		<td> </td>
		<td> <b>이메일</b> </td>
		<td> &nbsp;:&nbsp; </td>
		<td> <input class="form-control" type="email" placeholder="abc@xyz.com" maxlength="30" id="UserEmail" name="UserEmail"> </td>
		<td style="width: 100px"> </td>
	</tr>	
	<tr>
		<td colspan="5">
			<br><br><br><br>
		</td>
	</tr>
	<tr>
		<td colspan="5">
			<a onclick="emailAuther()" style="float: right; color:#000F75; display:none;" id="emailAuther">■ 보안코드 전송</a>
			<span style="display: none" id="successEmail"><b>인증완료</b></span>
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
			<a href="${pageContext.request.contextPath }/member/findPassword.do">비밀번호를 잃어버리셨나요?</a>
		</td>
	</tr>
	</table>
	</form>
</div>


<div style="height: 200px"></div>
<script>
	// 이메일 유효성검사
	$("#UserEmail").blur(function(){
		var email = $('#UserEmail').val();
		if(email.length!=0) {
			if(email.match(/([@])/)){
				if($('#successEmail').css("display")=='none'){
					$('#emailAuther').css("display","block");					
				} else {
					$('#emailAuther').css("display","none");
				}
			}
			else if(email.match(/([!,#,$,%,^,&,*,?,~,-])/)) {
				alert("온전하지 못한 이메일입니다. ('@'를 제외한 특수문자가 존재합니다.)");
				$("#UserEmail").val("");
                $("#UserEmail").focus();
                return false;
			}
			else {
				alert("온전하지 못한 이메일입니다. 다시 한 번 입력해주세요.");
				$("#UserEmail").val("");
                $("#UserEmail").focus();
                return false;
			}
		}
		return true;
		$.ajax({
			url:"${pageContext.request.contextPath}/member/findCheckEmail.do?PnH="+$('#findP').val(),
			data:{UserEmail:$('#UserEmail').val()},
			success:function(data){
				if(data == 'true'){
					alert("등록된 이메일과 일치합니다");
					if($('#successEmail').css("display")=='none'){
						$('#emailAuther').css("display","block");					
					} else {
						$('#emailAuther').css("display","none");
					}
				} else{
					alert("등록되지 않은 이메일입니다.");
					$("#UserEmail").val("");
	                $("#UserEmail").focus();
				}
			}
         })
	});
	
	// 이름 유효성검사
    $("#findname").blur(function(){
      var name=$("#findname").val();
         if(name.length!=0){
            if(name.match(/([0-9])|([!,@,#,$,%,^,&,*,?,_,~,-])/)) {
                 alert("이름은 영문과 한글만 입력 가능합니다.");
                 $("#findname").val("");
                 $("#findname").focus();
                return false;
               }
         }
         return true;
    });
	
	function emailAuther(){
		var nowemail = $('#UserEmail').val();
		var url="${pageContext.request.contextPath }/member/emailEnd.do?UserEmail="+nowemail;
		var title="emailAuther";
		var status="left=500px, top=100px, width=600px, height=200px";
		var popup=window.open(url,title,status);
	}
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>