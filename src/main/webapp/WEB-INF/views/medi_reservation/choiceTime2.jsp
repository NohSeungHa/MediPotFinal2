<%@page import="com.medi.pot.reservation.model.vo.MemberReservation"%>
<%@page import="java.util.List"%>
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
	String time2=time.substring(0, 10);
	String week=time.substring(11,12);
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
	long lss=ss.getTime();
	long lse=se.getTime();
	long lel=el.getTime();
	long sycleAM=sl.getTime()-ws.getTime();
	long syclePM=we.getTime()-el.getTime();
	long sSycleAM=sl.getTime()-ss.getTime();
	long sSyclePM=se.getTime()-el.getTime();
	int sycleA=(int)(sycleAM/timeI);
	int sycleP=(int)(syclePM/timeI);
	int sSycleA=(int)(sSycleAM/timeI);
	int sSycleP=(int)(sSyclePM/timeI);
	
	List<MemberReservation> list=(List<MemberReservation>)request.getAttribute("mr");
	String checkTi="";
	String checkTi2="";
	for(MemberReservation mr : list){
		checkTi+="§"+mr.getBlockTime()+"§"+mr.getCheckTime()+"§";
		checkTi2+="§"+mr.getBlockTime()+"§";
	}
%>
<style>
	.timebut{
		margin:5px;
		width:72px; height:60px;
		font-size:20px;
		background-color: white;
		border-radius: 5px;
	}
	.timebut:hover{
		background-color: #E6E6E6;
	}
	.ti{
		margin:5px;
		width:72px; height:60px;
		font-size:20px;
		background-color: white;
		border-radius: 5px;
	}
</style>
	<c:if test='<%=!week.equals("토") %>'>
		<div style="border: 2px solid lightgray;padding-left:40px;box-shadow: 3px 3px 5px lightgrey;border-radius:5px;">
			<h1 style="text-align: center;">${time }</h1>
			<h1 style="text-align: center;">오전</h1>
			<%for(int i=0;i<sycleA;i++ ){ 
			%>
			<c:if test="<%=!checkTi.contains(sd.format(lws)) %>">
			<button class="timebut" value="<%=sd.format(lws)%>"><%=sd2.format(lws) %></button>
			</c:if>
			<%for(int j=0;j<list.size();j++){ %>
			<%if(list.get(j).getCheckTime()!=null){ %>
			<c:if test="<%=list.get(j).getCheckTime().contains(sd.format(lws)) %>">
			<button class="ti" value="<%=sd.format(lws)%>" style="background-color:#A6A6A6;color:#FCFCFC;"><%=sd2.format(lws) %><%=list.get(j).getMemberName() %></button>
			</c:if>
			<%} %>
			<%} %>
			<c:if test="<%=checkTi2.contains(sd.format(lws)) %>">
			<button class="ti" value="<%=sd.format(lws)%>" style="background-color:#A6A6A6;color:#FCFCFC;"><%=sd2.format(lws) %></button>
			</c:if>

			<%
			lws=lws+timeI;
			} %>
			<h1 style="text-align: center;">오후</h1>
			<%for(int i=0;i<sycleP;i++ ){ 
			%>
			<c:if test="<%=!checkTi.contains(sd.format(lel)) %>">
			<button class="timebut" value="<%=sd.format(lel)%>"><%=sd2.format(lel) %></button>
			</c:if>
			<%for(int j=0;j<list.size();j++){ %>
			<%if(list.get(j).getCheckTime()!=null){ %>
			<c:if test="<%=list.get(j).getCheckTime().contains(sd.format(lel)) %>">
			<button class="ti" value="<%=sd.format(lel)%>" style="background-color:#A6A6A6;color:#FCFCFC;"><%=sd2.format(lel) %><%=list.get(j).getMemberName() %></button>
			</c:if>
			<%} %>
			<%} %>
			<c:if test="<%=checkTi2.contains(sd.format(lel)) %>">
			<button class="ti" value="<%=sd.format(lel)%>" style="background-color:#A6A6A6;color:#FCFCFC;"><%=sd2.format(lel) %></button>
			</c:if>
			<%
			lel=lel+timeI;
			} %>
			<br><br>
		</div>
	</c:if>
	<c:if test='<%=week.equals("토") %>'>
		<div style="border: 2px solid lightgray;padding-left:40px;box-shadow: 3px 3px 5px lightgrey;">
			<h1 style="text-align: center;">${time }</h1>
			<h1 style="text-align: center;">오전</h1>
			<%for(int i=0;i<sSycleA;i++ ){ 
			%>
			<c:if test="<%=!checkTi.contains(sd.format(lss)) %>">
			<button class="timebut" value="<%=sd.format(lss)%>"><%=sd2.format(lss) %></button>
			</c:if>
			<%for(int j=0;j<list.size();j++){ %>
			<%if(list.get(j).getCheckTime()!=null){ %>
			<c:if test="<%=list.get(j).getCheckTime().contains(sd.format(lss)) %>">
			<button class="ti" value="<%=sd.format(lss)%>" style="background-color:#A6A6A6;color:#FCFCFC;"><%=sd2.format(lss) %><br><%=list.get(j).getMemberName() %></button>
			</c:if>
			<%} %>
			<%} %>
			<c:if test="<%=checkTi2.contains(sd.format(lss)) %>">
			<button class="ti" value="<%=sd.format(lss)%>" style="background-color:#A6A6A6;color:#FCFCFC;"><%=sd2.format(lss) %></button>
			</c:if>
			<%
			lss=lss+timeI;
			} %>
			<h1 style="text-align: center;">오후</h1>
			<%for(int i=0;i<sSycleP;i++ ){ 
			%>
			<c:if test="<%=!checkTi.contains(sd.format(lel)) %>">
			<button class="timebut" value="<%=sd.format(lel)%>"><%=sd2.format(lel) %></button>
			</c:if>
			<%for(int j=0;j<list.size();j++){ %>
			<%if(list.get(j).getCheckTime()!=null){ %>
			<c:if test="<%=list.get(j).getCheckTime().contains(sd.format(lel)) %>">
			<button class="ti" value="<%=sd.format(lel)%>" style="background-color:#A6A6A6;color:#FCFCFC;"><%=sd2.format(lel) %><%=list.get(j).getMemberName() %></button>
			</c:if>
			<%} %>
			<%} %>
			<c:if test="<%=checkTi2.contains(sd.format(lel)) %>">
			<button class="ti" value="<%=sd.format(lel)%>" style="background-color:#A6A6A6;color:#FCFCFC;"><%=sd2.format(lel) %></button>
			</c:if>
			<%
			lel=lel+timeI;
			} %>
			<br><br>
		</div>
	</c:if>
	
	<div style="text-align:center;margin-top:20px;">
		<button id="choiceReser">선택 시간 제외하기</button>
		<button id="blockDate">현재 날짜 제외하기</button>
	</div>
	
	<style>
		#choiceReser{

			width: 49%;
		    height: 100px;
		    font-size: 30px;
		    background:#286090;
		    color:white;
		    border-radius: 10px;
		    box-shadow: 3px 3px 5px lightgrey;
		    
    	}
    	#blockDate{
    		width: 49%;
		    height: 100px;
		    font-size: 30px;
		    background:#286090;
		    color:white;
		    border-radius: 10px;
		    box-shadow: 3px 3px 5px lightgrey;
    	}
    	#choiceReser:hover{
	    	background: #2A5060;
			color:white;
    	
    	}
	</style>
	<script>
		alert('<%=checkTi%>');
		var choiceTime='';
		$('.timebut').click(function () {
			if($(this).css('background-color')=='rgb(40, 96, 144)'){
				$(this).css('background-color','white');
				$(this).css('color','black');
				choiceTime="";
			}else{
				$('.timebut').css('background-color','white');
				$('.timebut').css('color','black');
				$(this).css('background-color','#286090');
				$(this).css('color','white');
				choiceTime=$(this).val();
				alert(choiceTime);
			}
		});
		$('#choiceReser').click(function () {
			if(choiceTime.length<1){
				alert("시간을 선택해 주세요");
			}else{
				alert('<%=time2%>');
				location.href='${path}/medi/insertBlock?docNum=<%=docTime.getDoctorNum()%>&hosNum=<%=docTime.getHospitalNo()%>&time=<%=time2%>&choiceTime='+choiceTime;
			}
		});
	</script>