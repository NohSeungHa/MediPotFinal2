<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="비밀번호찾기" name="pageTitle"/>
</jsp:include>

<style>
	.findid{
		border: 5px solid #00aeef;
		border-top-left-radius: 50px;
		border-bottom-left-radius: 50px;
		border-top-right-radius: 50px;
		border-bottom-right-radius: 50px;
		width: 500px;
		height: 550px;
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
	<h2 class="center">비밀번호 찾기</h2>
	<br><br><br>
	<form action="${pageContext.request.contextPath }/member/memberFindPw.do">
	<table style="margin: 0 auto;">
	<tr>
		<td></td>
		<td>
			<input type="radio" value="P" id="findP" name="findPnH" checked>개인
			<input type="radio" value="H" name="findPnH">병원
		</td>
	</tr>
	<tr>
		<td colspan="5">
			<br><br>
		</td>
	</tr>
	<tr>
		<td> </td>
		<td> <b>아이디</b> </td>
		<td> &nbsp; : &nbsp; </td>
		<td> <input class="form-control" type="text" placeholder="아이디를 입력해주세요." style="width: 250px" maxlength="30" id="findid" name="findid"> </td>
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
		<td> <input class="form-control" type="email" placeholder="abc@xyz.com" maxlength="50" id="UserEmail" name="UserEmail"> </td>
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
			<a href="${pageContext.request.contextPath }/member/join.do">회원이 아니신가요?</a>
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
			data:{memberEmail:$('#UserEmail').val()},
			success:function(data){
				if(email.length > 0){
					if(data == 'true'){
						alert("등록된 이메일과 일치합니다");
						if($('#successEmail').css("display")=='none'){
							$('#emailAuther').css("display","block");					
						} else {
							$('#emailAuther').css("display","none");
						}
						return true;
					} else{
						alert("등록되지 않은 이메일입니다.");
						$("#UserEmail").val("");
		                $("#UserEmail").focus();
		                return false;
					}
				}
			}
         })
	});
	
	// 아이디 유효성검사
	$(function(){
		$('#findId').on("keyup",function(){
			var memberId=$('#findId').val();
			if(memberId.length!=0){
				if(memberId.match(/([ㄱ-ㅎ|가-힣]|([!,@,#,$,%,^,&,*,?,_,~,-]))/) || (memberId.match(/([0-9])/) && (memberId.match(/([a-zA-Z])/))==null)){
					alert("아이디는 영문과 숫자로 입력해야합니다.");
					$('#findId').val("");
					$('#findId').focus();
					return;
				}
			}
			$.ajax({
				url:"${pageContext.request.contextPath}/member/PcheckId.do",
				data:{memberId:$(this).val()},
				success:function(data){
					if(data == 'true'){
						alert("아이디가 존재하지 않습니다.");
					}else{
						alert("아이디가 존재합니다.");
					}
				}
			})
		});
	});
	
	function emailAuther(){
		var nowemail = $('#UserEmail').val();
		var url="${pageContext.request.contextPath }/member/emailEnd.do?memberEmail="+nowemail;
		var title="emailAuther";
		var status="left=500px, top=100px, width=600px, height=200px";
		var popup=window.open(url,title,status);
	}
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/>