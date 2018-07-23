<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>
	<c:set var="path" value="<%=request.getContextPath() %>"/>
     <%
     Date day=new Date();
     SimpleDateFormat today=new SimpleDateFormat("yyyy-MM-dd");
     String today2=today.format(day);%>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="Reser" name="pageTitle"/>
</jsp:include>
<style>
	#docInfo{
		font-size:20px;
	}
	#docInfo th{
		color: #286090;
	}
	#docInfo th{
		text-align:center;
		width:90px;
	}
	#docInfo-div{
		border:2px solid lightgray;
		border-radius:5px;
		box-shadow:2px 2px 5px lightgray;
	}
	#docInfo-div:hover{
		cursor: pointer;
		border: 2px solid #286090;
	}	

</style>

<div style="height:1000px;">
	<div class="col-sm-4">
		<div style="width:100%;height:50px;font-size:20px;text-align:center;background-color:#286090;padding-top:11px;color:white;border-radius:8px;margin-bottom:10px;">
			의료진 정보
		</div>
		<div id="docInfo-div" style="height:auto;margin-bottom:10px;">
			<table id="docInfo">
				<tr>
					<td rowspan="4"><img src="${path }/resources/img/reser/f2.jpg" width="200px;" height="200px;"></td>
					<th>이름</th>
					<td>채슬기</td>
				</tr>
				<tr>
					<th>진료과</th>
					<td>정신과</td>
				</tr>
				<tr>
					<th>전문분야</th>
					<td>청소년 정신치료,분노조절장애 치료</td>
				</tr>
				<tr>
					<th>학력/경력</th>
					<td>한양대 정보융합 졸업<br>
						석사<br>
						굳
					</td>
				</tr>
			</table>
		</div>	
		
	</div>
	<div class="col-sm-4">
		<div style="width:100%;height:50px;font-size:20px;text-align:center;background-color:#286090;padding-top:11px;color:white;border-radius:8px;margin-bottom:10px;">
			날짜 선택
		</div>
		<div>
			<table>
				
			</table>
		</div>
	</div>
	<div class="col-sm-4">
		<div style="width:100%;height:50px;font-size:20px;text-align:center;background-color:#286090;padding-top:11px;color:white;border-radius:8px;margin-bottom:10px;">
			시간 선택
		</div>
	</div>
</div>





<jsp:include page="/WEB-INF/views/common/footer.jsp"/>