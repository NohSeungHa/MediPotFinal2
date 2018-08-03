<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="병원회원 비밀번호 변경" name="pageTitle"/>
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
function fn_update_password() {
    
    var url="<%=request.getContextPath()%>/updatePasswordEnd";
    var status="left=500px, top=200px, width=400px, height=210px";
    var title="updatePassword";
    
    var popup=window.open(url,title,status);
    
 }
</script>





<div style="height: 100px"></div>
<div class="jointab">
		<div id="enroll-container">
		<div style="width: 100%; height: 100px; line-height: 100px; text-align: center">
			<img src="${pageContext.request.contextPath }/resources/img/enroll/hospitalEnrollTop.png"
				style="width: 100%; max-width: 760px; vertical-align: middle" />
		</div>
		
		<h2>비밀번호 변경</h2>
		<p>비밀번호는 영문(대소문자구분)</p>
		<p>숫자,특수문자(~!@#$%^&*()-_? 만 허용)</p>
		<p>를 혼용하여 8~16자를 입력해주세요.</p>
			<form name="" action="" method="post" onsubmit="return fn_enroll_validate();" >
				<table>
					<tr>
						<th>현재 비밀번호 입력</th>
						<td>
							<input type="password" class="form-control" name="originPw" id="originPw" required>
						</td>
					</tr>
					<tr>
						<th>변경할 비밀번호</th>
						<td>
							<input type="password" class="form-control" name="newPw" id="newPw" required>
						</td>
					</tr>
					<tr>
						<th>변경할 비밀번호확인</th>
						<td>	
							<input type="password" class="form-control" id="newPw2" required>
						</td>
					</tr>  
					
				</table>
				<br><br>
					 <button type="submit" class="btn btn-lg btn-default">비밀번호 변경</button>
					 <br>
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



<jsp:include page="/WEB-INF/views/common/footer.jsp"/>