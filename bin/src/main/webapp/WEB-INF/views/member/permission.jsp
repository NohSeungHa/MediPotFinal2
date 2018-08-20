<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="" name="pageTitle"/>
</jsp:include>
<style>
	.permission{
		width: 500px;
		height: 500px;
	}
	.border-div{		
		border: 20px solid #00aeef;
		border-top-left-radius: 100px;
		border-bottom-left-radius: 100px;
		border-top-right-radius: 100px;
		border-bottom-right-radius: 100px;
		margin-left: 25%;
		margin-right: 25%;
	}
	.tbl-body{
		margin: 0 auto;
	}
	.tbl-body ._body{
		font-size: 2.2em;
		padding: 50px;
	}
	.tbl-body ._permi{
		text-align: center;
		font-size: 4.0em;
	}
	
</style>

<div style="height: 200px">

</div>
<div class="border-div">
<br><br><br>
<table class="tbl-body">
	<tr class="_permi">
		<td>
			<img class="permission" src="${pageContext.request.contextPath }/resources/img/member/permi.gif">
			<br>
			승  인  요  청  중  . . .
		</td>
	</tr>
	<tr>
		<td class="_body" colspan="3">
			<ul>
				<li>
					관리자의 승인이 되지않아 서비스 이용이 <b>불가능</b>합니다.
				</li>
				<br>
				<li>
					관리자의 승인은 회원가입 후 <b>72</b>시간이내에 관리자가 승인을 실시합니다.
				</li>
				<br>
				<li style="white-space:pre-wrap;">승인이 완료되면 추가로 병원의 정보를 입력 한 후에 
<b>㈜MediPot</b> 의 서비스를 이용할 수 있습니다.
				</li>
			</ul>
		</td>
	</tr>
	
</table>
</div>

<div style="height: 200px">

</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>