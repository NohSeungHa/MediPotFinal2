<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="" name="pageTitle"/>
</jsp:include>

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

<div style="height: 100px"></div>


<div class="jointab">
		<div id="enroll-container">
		<div style="width: 100%; height: 100px; line-height: 100px; text-align: center">
			<img src="${pageContext.request.contextPath }/resources/img/enroll/personEnrollTop.png"
				style="width: 100%; max-width: 760px; vertical-align: middle" />
		</div>
		<br><br><br>
		<br><br><br>
		<h2>새로운 비밀번호를 입력하세요</h2>
		<p>비밀번호는 영문(대소문자구분)</p>
		<p>숫자,특수문자(~!@#$%^&*()-_? 만 허용)</p>
		<p>를 혼용하여 8~16자를 입력해주세요.</p>
			<form action="${pageContext.request.contextPath }/member/FindPwUpdate.do" method="post" onsubmit="return fn_enroll_validate();" >
				<table style="margin: 0 auto">
					<tr>
						<th>새로운 비밀번호</th>
						<td style="width: 20px"></td>
						<td>
							<input type="password" class="form-control" name="newPw" id="newPw" required>
						</td>
					</tr>
					<tr>
						<th>새로운 비밀번호확인</th>
						<td style="width: 20px"></td>
						<td>	
							<input type="password" class="form-control" id="newPw2" required>
						</td>
					</tr>  
					
				</table>
				
				<br><br>
					 <button type="submit" class="btn btn-lg btn-default">비밀번호 변경</button>
					 <br>
					 <input type="hidden" value="${findid }" name="memberId">
			</form>
			<div style="width: 100%; height: 100px; line-height: 100px; text-align: center">
			<img src="${pageContext.request.contextPath }/resources/img/enroll/personEnrollBottom.png"
				style="width: 100%; max-width: 760px; vertical-align: middle" />
		</div>
				<br><br><br>
		</div>
	</div>
	
<script>
$(function(){
      $("#newPw").blur(function(){
         var p1=$("#newPw").val();
         if(p1.length==0){
            
         }
         else{
            if(p1.length<8 || !p1.match(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~,-])|([!,@,#,$,%,^,&,*,?,_,~,-].*[a-zA-Z0-9])/)) {
                alert("비밀번호는 영문(대소문자구분),숫자,특수문자(~!@#$%^&*()-_? 만 허용)를 혼용하여 8~16자를 입력해주세요.");
                $("#newPw").val("");
                $("#newPw").focus();
               return false;
              }
         }
         return true;
         
      });
      $("#newPw2").blur(function(){
         var p1=$("#newPw").val();
         var p2=$("#newPw2").val();
           if(p1!=p2)
            {
               alert("패스워드가 일치하지 않습니다.");
               $("#newPw").focus();
               $("#newPw").val("");
               $("#newPw2").val("");
            }   
      });
   });
   
$(function(){
	
	$("#newPw2").blur(function(){
		var p1=$("#newPw").val(), p2=$("#newPw2").val();
		if(p1!=p2){
			alert("패스워드가 일치하지 않습니다.");
			$("#newPw").focus();
		}
	});
	
});

</script>


<div style="height: 100px"></div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>