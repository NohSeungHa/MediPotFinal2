<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<meta charset="UTF-8">
<title>이메일 인증</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script>
function check(){
    var form = document.authenform;
    var authNum =${ra};
   var check="";
    if(!form.authnum.value){
        alert("인증번호를 입력하세요.");
        return false;
    }
    if(form.authnum.value!=authNum){
        alert("틀린 인증번호입니다. 인증번호를 다시입력해주세요.");
        form.authnum.value="";
        return false;
    }
    if(form.authnum.value==authNum){
        alert("인증완료");    
        $("#successEmail",opener.document).css("display","block");
        $("#emailAuther",opener.document).css("display",'none');
        $('#PHemail',opener.document).attr("readonly",true);
        self.close();
    }
    
}
</script>
<center>
<br /><br />
<h5>인증 번호 4자리를 입력하세요</h5>

<div class="container">
    <form method="POST" name="authenform" onsubmit="return check();">
        <input type="text" class="btn btn-default" name="authnum"><br /><br />
        <input type="submit" class="btn btn-default" value="확인">
    </form>
</div>
</center>
</body>
</html>