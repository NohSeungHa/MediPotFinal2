<%@page import="java.util.Locale"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
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
     Calendar cal=new GregorianCalendar(Locale.KOREA);
     cal.setTime(new Date());
     SimpleDateFormat today=new SimpleDateFormat("yyyy-MM-dd E");
     String dt=today.format(day);
     String mon=dt.substring(5,7);
     String d=dt.substring(8, 10);
     String e=dt.substring(11,12);
     int dd=cal.get(Calendar.DAY_OF_MONTH);
     cal.add(Calendar.DAY_OF_YEAR, 1);
     int dd2=cal.get(Calendar.DAY_OF_MONTH);
     cal.add(Calendar.DAY_OF_YEAR, 1);
     int dd3=cal.get(Calendar.DAY_OF_MONTH);
     cal.add(Calendar.DAY_OF_YEAR, 1);
     int dd4=cal.get(Calendar.DAY_OF_MONTH);
     cal.add(Calendar.DAY_OF_YEAR, 1);
     int dd5=cal.get(Calendar.DAY_OF_MONTH);
     cal.add(Calendar.DAY_OF_YEAR, 1);
     int dd6=cal.get(Calendar.DAY_OF_MONTH);
     cal.add(Calendar.DAY_OF_YEAR, 1);
     int dd7=cal.get(Calendar.DAY_OF_MONTH);
     cal.add(Calendar.DAY_OF_YEAR, 1);
     int dd8=cal.get(Calendar.DAY_OF_MONTH);
     cal.add(Calendar.DAY_OF_YEAR, 1);
     int dd9=cal.get(Calendar.DAY_OF_MONTH);
     cal.add(Calendar.DAY_OF_YEAR, 1);
     int dd10=cal.get(Calendar.DAY_OF_MONTH);
     cal.add(Calendar.DAY_OF_YEAR, 1);
     int dd11=cal.get(Calendar.DAY_OF_MONTH);
     cal.add(Calendar.DAY_OF_YEAR, 1);
     int dd12=cal.get(Calendar.DAY_OF_MONTH);
     cal.add(Calendar.DAY_OF_YEAR, 1);
     int dd13=cal.get(Calendar.DAY_OF_MONTH);
     cal.add(Calendar.DAY_OF_YEAR, 1);
     int dd14=cal.get(Calendar.DAY_OF_MONTH);
     %>

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
	#tbl-cal{
		text-align:center;
		font-size:30px;
	}
	#tbl-cal th{
	text-align:center;
		width:70px;
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
			<table id="tbl-cal" align="center">
				<tr>
					<th colspan="7"><%=mon %>월</th>
				</tr>
				<tr>
					<th><span style="color: red;">일</span></th>
					<th>월</th>
					<th>화</th>
					<th>수</th>
					<th>목</th>
					<th>금</th>
					<th>토</th>
				</tr>
				<c:if test='<%=e.equals("일")%>'>
				<tr>
					<td><%=dd %></td>
					<td><%=dd2 %></td>
					<td><%=dd3 %></td>
					<td><%=dd4 %></td>
					<td><%=dd5 %></td>
					<td><%=dd6 %></td>
					<td><%=dd7 %></td>
				</tr>
				<tr>
					<td><%=dd8%></td>
					<td><%=dd9 %></td>
					<td><%=dd10 %></td>
					<td><%=dd11 %></td>
					<td><%=dd12 %></td>
					<td><%=dd13 %></td>
					<td><%=dd14 %></td>
				</tr>
				</c:if>
				<c:if test='<%=e.equals("월")%>'>
				<tr>
					<td></td>
					<td><%=dd %></td>
					<td><%=dd2 %></td>
					<td><%=dd3 %></td>
					<td><%=dd4 %></td>
					<td><%=dd5 %></td>
					<td><%=dd6 %></td>
				</tr>
				<tr>
					<td><%=dd7%></td>
					<td><%=dd8 %></td>
					<td><%=dd9 %></td>
					<td><%=dd10 %></td>
					<td><%=dd11 %></td>
					<td><%=dd12 %></td>
					<td><%=dd13 %></td>
				</tr>
				<tr>
					<td><%=dd14 %></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				</c:if>
				<c:if test='<%=e.equals("화")%>'>
				<tr>
					<td></td>
					<td></td>
					<td><%=dd %></td>
					<td><%=dd2 %></td>
					<td><%=dd3 %></td>
					<td><%=dd4 %></td>
					<td><%=dd5 %></td>
				</tr>
				<tr>
					<td><%=dd6%></td>
					<td><%=dd7 %></td>
					<td><%=dd8 %></td>
					<td><%=dd9 %></td>
					<td><%=dd10 %></td>
					<td><%=dd11 %></td>
					<td><%=dd12 %></td>
				</tr>
				<tr>
					<td><%=dd13 %></td>
					<td><%=dd14 %></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				</c:if>
				<c:if test='<%=e.equals("수")%>'>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td><%=dd %></td>
					<td><%=dd2 %></td>
					<td><%=dd3 %></td>
					<td><%=dd4 %></td>
				</tr>
				<tr>
					<td><%=dd5%></td>
					<td><%=dd6 %></td>
					<td><%=dd7 %></td>
					<td><%=dd8 %></td>
					<td><%=dd9 %></td>
					<td><%=dd10 %></td>
					<td><%=dd11 %></td>
				</tr>
				<tr>
					<td><%=dd12 %></td>
					<td><%=dd13 %></td>
					<td><%=dd14 %></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				</c:if>
				<c:if test='<%=e.equals("목")%>'>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td><%=dd %></td>
					<td><%=dd2 %></td>
					<td><%=dd3 %></td>
				</tr>
				<tr>
					<td><%=dd4%></td>
					<td><%=dd5 %></td>
					<td><%=dd6 %></td>
					<td><%=dd7 %></td>
					<td><%=dd8 %></td>
					<td><%=dd9 %></td>
					<td><%=dd10 %></td>
				</tr>
				<tr>
					<td><%=dd11 %></td>
					<td><%=dd12 %></td>
					<td><%=dd13 %></td>
					<td><%=dd14 %></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				</c:if>
				<c:if test='<%=e.equals("금")%>'>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td><%=dd %></td>
					<td><%=dd2 %></td>
				</tr>
				<tr>
					<td><%=dd3%></td>
					<td><%=dd4 %></td>
					<td><%=dd5 %></td>
					<td><%=dd6 %></td>
					<td><%=dd7 %></td>
					<td><%=dd8 %></td>
					<td><%=dd9 %></td>
				</tr>
				<tr>
					<td><%=dd10 %></td>
					<td><%=dd11 %></td>
					<td><%=dd12 %></td>
					<td><%=dd13 %></td>
					<td><%=dd14 %></td>
					<td></td>
					<td></td>
				</tr>
				</c:if>
				<c:if test='<%=e.equals("토")%>'>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td><%=dd %></td>
				</tr>
				<tr>
					<td><%=dd2%></td>
					<td><%=dd3 %></td>
					<td><%=dd4 %></td>
					<td><%=dd5 %></td>
					<td><%=dd6 %></td>
					<td><%=dd7 %></td>
					<td><%=dd8 %></td>
				</tr>
				<tr>
					<td><%=dd9 %></td>
					<td><%=dd10 %></td>
					<td><%=dd11 %></td>
					<td><%=dd12 %></td>
					<td><%=dd13 %></td>
					<td><%=dd14 %></td>
					<td></td>
				</tr>
				</c:if>
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