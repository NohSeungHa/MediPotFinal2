<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.medi.pot.reservation.model.vo.DoctorInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var='path' value="<%=request.getContextPath() %>"></c:set>
<%
	DoctorInfo docTime=(DoctorInfo)request.getAttribute("doctor");
	long timeI=Integer.parseInt(docTime.getTimeInterval())*60*1000;
	String time=(String)request.getAttribute("time");
	SimpleDateFormat sd=new SimpleDateFormat("HHmm");
	SimpleDateFormat sd2=new SimpleDateFormat("HH:mm");
	Date ws=sd.parse(docTime.getWeekdayStime());
	Date we=sd.parse(docTime.getWeekdayEtime());
	Date sl=sd.parse(docTime.getDoctorSlunch());
	Date el=sd.parse(docTime.getDoctorElunch());
	Date ss=sd.parse(docTime.getSatStime());
	Date se=sd.parse(docTime.getSatEtime());
	long lws=ws.getTime();
	long lwe=we.getTime();
	long lel=el.getTime();
	long sycleAM=sl.getTime()-ws.getTime();
	long syclePM=we.getTime()-el.getTime();
	int sycleA=(int)(sycleAM/timeI);
	int sycleP=(int)(syclePM/timeI);
%>
<style>
	.timebut{
		margin:5px;
		width:72px; height:50px;
		font-size:20px;
		background-color: white;
		border-radius: 5px;
	}
	.timebut:hover{
		background-color: #286090;
		color:white;
	}
</style>
	<h1 style="text-align: center;">오전</h1>
	<%for(int i=0;i<sycleA;i++ ){ 
	%>
	<button class="timebut" value="<%=sd.format(lws)%>"><%=sd2.format(lws) %></button>
	<%
	lws=lws+timeI;
	} %>
	<h1 style="text-align: center;">오후</h1>
	<%for(int i=0;i<sycleP;i++ ){ 
	%>
	<button class="timebut" value="<%=sd.format(lel)%>"><%=sd2.format(lel) %></button>
	<%
	lel=lel+timeI;
	} %>