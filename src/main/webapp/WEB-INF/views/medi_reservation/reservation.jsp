<%@page import="java.util.List"%>
<%@page import="com.medi.pot.reservation.model.vo.DoctorSchedule"%>
<%@page import="com.medi.pot.reservation.model.vo.DoctorInfo"%>
<%@page import="java.util.Locale"%>
<%@page import="com.ibm.icu.util.ChineseCalendar"%>
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
     String close="";
     String bDate="";
     DoctorInfo docInfo=null;
     List<DoctorSchedule> docSche=null;
     if((DoctorInfo)request.getAttribute("doctor")!=null){
     docInfo=(DoctorInfo)request.getAttribute("doctor");
     close=docInfo.getClosed();
     }
     if((List<DoctorSchedule>)request.getAttribute("docSche")!=null){
     docSche=(List<DoctorSchedule>)request.getAttribute("docSche");
     }
     
     Date day=new Date();
     Calendar cal=new GregorianCalendar(Locale.KOREA);
     cal.setTime(new Date());
     SimpleDateFormat today=new SimpleDateFormat("yyyy-MM-dd E");
     SimpleDateFormat tod2=new SimpleDateFormat("yyyy-MM-dd");
     SimpleDateFormat tod=new SimpleDateFormat("yyyy-MM-dd E");
     SimpleDateFormat tod3=new SimpleDateFormat("E");
     String dt=today.format(day);
     String mon=dt.substring(5,7);
     String d=dt.substring(8, 10);
     String e=dt.substring(11,12);
     
     int dd=cal.get(Calendar.DAY_OF_MONTH);
     String hd=tod2.format(cal.getTime());
     String y=tod.format(cal.getTime());
     String daye=tod3.format(cal.getTime());
     boolean checkDate=false;
     if(docSche!=null){
	     for(DoctorSchedule ds : docSche){
	    	 checkDate=ds.getBlockDate().equals(hd);
	    	 if(checkDate){
	    		 break;
	    	 }
	     }
     }
     boolean check=close.contains(daye);
     boolean hdc=eTest(hd);
     boolean hdce=yTest(hd);
     
     cal.add(Calendar.DAY_OF_YEAR, 1); 
     int dd2=cal.get(Calendar.DAY_OF_MONTH);
     String hd2=tod2.format(cal.getTime());
     String y2=tod.format(cal.getTime());
     String daye2=tod3.format(cal.getTime());
     boolean checkDate2=false;
     if(docSche!=null){
	     for(DoctorSchedule ds : docSche){
	    	 checkDate2=ds.getBlockDate().equals(hd2);
	    	 if(checkDate2){
	    		 break;
	    	 }
	     }
     }
     boolean check2=close.contains(daye2);
     boolean hdc2=eTest(hd2);
     boolean hdce2=yTest(hd2);
     
     cal.add(Calendar.DAY_OF_YEAR, 1);
     int dd3=cal.get(Calendar.DAY_OF_MONTH);
     String hd3=tod2.format(cal.getTime());
     String y3=tod.format(cal.getTime());
     String daye3=tod3.format(cal.getTime());
     boolean checkDate3=false;
     if(docSche!=null){
	     for(DoctorSchedule ds : docSche){
	    	 checkDate3=ds.getBlockDate().equals(hd3);
	    	 if(checkDate3){
	    		 break;
	    	 }
	     }
     }
     boolean check3=close.contains(daye3);
     boolean hdc3=eTest(hd3);
     boolean hdce3=yTest(hd3);
     
     cal.add(Calendar.DAY_OF_YEAR, 1);
     int dd4=cal.get(Calendar.DAY_OF_MONTH);
     String hd4=tod2.format(cal.getTime());
     String y4=tod.format(cal.getTime());
     String daye4=tod3.format(cal.getTime());
     boolean checkDate4=false;
     if(docSche!=null){
	     for(DoctorSchedule ds : docSche){
	    	 checkDate4=ds.getBlockDate().equals(hd4);
	    	 if(checkDate4){
	    		 break;
	    	 }
	     }
     }
     boolean check4=close.contains(daye4);
     boolean hdc4=eTest(hd4);
     boolean hdce4=yTest(hd4);
   
     cal.add(Calendar.DAY_OF_YEAR, 1);    
     int dd5=cal.get(Calendar.DAY_OF_MONTH);
     String hd5=tod2.format(cal.getTime());
     String y5=tod.format(cal.getTime());
     String daye5=tod3.format(cal.getTime());
     boolean checkDate5=false;
     if(docSche!=null){
	     for(DoctorSchedule ds : docSche){
	    	 checkDate5=ds.getBlockDate().equals(hd5);
	    	 if(checkDate5){
	    		 break;
	    	 }
	     }
     }
     boolean check5=close.contains(daye5);
     boolean hdc5=eTest(hd5);
     boolean hdce5=yTest(hd5);
     
     cal.add(Calendar.DAY_OF_YEAR, 1); 
     int dd6=cal.get(Calendar.DAY_OF_MONTH);
     String hd6=tod2.format(cal.getTime());
     String y6=tod.format(cal.getTime());
     String daye6=tod3.format(cal.getTime());
     boolean checkDate6=false;
     if(docSche!=null){
	     for(DoctorSchedule ds : docSche){
	    	 checkDate6=ds.getBlockDate().equals(hd6);
	    	 if(checkDate6){
	    		 break;
	    	 }
	     }
     }
     boolean check6=close.contains(daye6);
     boolean hdc6=eTest(hd6);
     boolean hdce6=yTest(hd6);
     
     cal.add(Calendar.DAY_OF_YEAR, 1);     
     int dd7=cal.get(Calendar.DAY_OF_MONTH);
     String hd7=tod2.format(cal.getTime());
     String y7=tod.format(cal.getTime());
     String daye7=tod3.format(cal.getTime());
     boolean checkDate7=false;
     if(docSche!=null){
	     for(DoctorSchedule ds : docSche){
	    	 checkDate7=ds.getBlockDate().equals(hd7);
	    	 if(checkDate7){
	    		 break;
	    	 }
	     }
     }
     boolean check7=close.contains(daye7);
     boolean hdc7=eTest(hd7);
     boolean hdce7=yTest(hd7);
     
     cal.add(Calendar.DAY_OF_YEAR, 1);     
     int dd8=cal.get(Calendar.DAY_OF_MONTH);
     String hd8=tod2.format(cal.getTime());
     String y8=tod.format(cal.getTime());
     String daye8=tod3.format(cal.getTime());
     boolean checkDate8=false;
     if(docSche!=null){
	     for(DoctorSchedule ds : docSche){
	    	 checkDate8=ds.getBlockDate().equals(hd8);
	    	 if(checkDate8){
	    		 break;
	    	 }
	     }
     }
     boolean check8=close.contains(daye8);
     boolean hdc8=eTest(hd8);
     boolean hdce8=yTest(hd8);
     
     cal.add(Calendar.DAY_OF_YEAR, 1);   
     int dd9=cal.get(Calendar.DAY_OF_MONTH);
     String hd9=tod2.format(cal.getTime());
     String y9=tod.format(cal.getTime());
     String daye9=tod3.format(cal.getTime());
     boolean checkDate9=false;
     if(docSche!=null){
	     for(DoctorSchedule ds : docSche){
	    	 checkDate9=ds.getBlockDate().equals(hd9);
	    	 if(checkDate9){
	    		 break;
	    	 }
	     }
     }
     boolean check9=close.contains(daye9);
     boolean hdc9=eTest(hd9);
     boolean hdce9=yTest(hd9);
     
     cal.add(Calendar.DAY_OF_YEAR, 1);  
     int dd10=cal.get(Calendar.DAY_OF_MONTH);
     String hd10=tod2.format(cal.getTime());
     String y10=tod.format(cal.getTime());
     String daye10=tod3.format(cal.getTime());
     boolean checkDate10=false;
     if(docSche!=null){
	     for(DoctorSchedule ds : docSche){
	    	 checkDate10=ds.getBlockDate().equals(hd10);
	    	 if(checkDate10){
	    		 break;
	    	 }
	     }
     }
     boolean check10=close.contains(daye10);
     boolean hdc10=eTest(hd10);
     boolean hdce10=yTest(hd10);
     
     cal.add(Calendar.DAY_OF_YEAR, 1);
     int dd11=cal.get(Calendar.DAY_OF_MONTH);
     String hd11=tod2.format(cal.getTime());
     String y11=tod.format(cal.getTime());
     String daye11=tod3.format(cal.getTime());
     boolean checkDate11=false;
     if(docSche!=null){
	     for(DoctorSchedule ds : docSche){
	    	 checkDate11=ds.getBlockDate().equals(hd11);
	    	 if(checkDate11){
	    		 break;
	    	 }
	     }
     }
     boolean check11=close.contains(daye11);
     boolean hdc11=eTest(hd11);
     boolean hdce11=yTest(hd11);
     
     cal.add(Calendar.DAY_OF_YEAR, 1);   
     int dd12=cal.get(Calendar.DAY_OF_MONTH);
     String hd12=tod2.format(cal.getTime());
     String y12=tod.format(cal.getTime());
     String daye12=tod3.format(cal.getTime());
     boolean checkDate12=false;
     if(docSche!=null){
	     for(DoctorSchedule ds : docSche){
	    	 checkDate12=ds.getBlockDate().equals(hd12);
	    	 if(checkDate12){
	    		 break;
	    	 }
	     }
     }
     boolean check12=close.contains(daye12);
     boolean hdc12=eTest(hd12);
     boolean hdce12=yTest(hd12);
     
     cal.add(Calendar.DAY_OF_YEAR, 1);   
     int dd13=cal.get(Calendar.DAY_OF_MONTH);
     String hd13=tod2.format(cal.getTime());
     String y13=tod.format(cal.getTime());
     String daye13=tod3.format(cal.getTime());
     boolean checkDate13=false;
     if(docSche!=null){
	     for(DoctorSchedule ds : docSche){
	    	 checkDate13=ds.getBlockDate().equals(hd13);
	    	 if(checkDate13){
	    		 break;
	    	 }
	     }
     }
     boolean check13=close.contains(daye13);
     boolean hdc13=eTest(hd13);
     boolean hdce13=yTest(hd13);
     
     cal.add(Calendar.DAY_OF_YEAR, 1);
     int dd14=cal.get(Calendar.DAY_OF_MONTH);
     String hd14=tod2.format(cal.getTime());
     String y14=tod.format(cal.getTime());
     String daye14=tod3.format(cal.getTime());
     boolean checkDate14=false;
     if(docSche!=null){
	     for(DoctorSchedule ds : docSche){
	    	 checkDate14=ds.getBlockDate().equals(hd14);
	    	 if(checkDate14){
	    		 break;
	    	 }
	     }
     }
     boolean check14=close.contains(daye14);
     boolean hdc14=eTest(hd14);
     boolean hdce14=yTest(hd14);
     %>
     <%! public boolean eTest(String dt){
    	 boolean check=false;
         
	        // 음력 공휴일 목록
	        String[] arrLunar = {
	                 
	                "01-01"     // 설날 2
	                , "01-02"   // 설날 3
	                , "04-08"   // 부처님 오신날
	                , "08-14"   // 추석 1
	                , "08-15"   // 추석 2
	                , "08-16"   // 추석 3
	                , "12-31"   // 설날 1
	        };
	         
	         
	        ChineseCalendar chinaCal = new ChineseCalendar();
	        Calendar cal = Calendar.getInstance();
	         
	        cal.set(Calendar.YEAR, Integer.parseInt(dt.substring(0, 4)));
	        cal.set(Calendar.MONTH, Integer.parseInt(dt.substring(5, 7)) - 1);
	        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dt.substring(8,10)));
	        chinaCal.setTimeInMillis(cal.getTimeInMillis());
	         
	 
	        int chinaYY = chinaCal.get(ChineseCalendar.EXTENDED_YEAR) - 2637 ;
	        int chinaMM = chinaCal.get(ChineseCalendar.MONTH) + 1;
	        int chinaDD = chinaCal.get(ChineseCalendar.DAY_OF_MONTH);
	         
	         
	         
	         
	        String chinaDate = "" ;     // 음력 날짜
	         
	         
	        if(chinaMM < 10)         // 월
	            chinaDate += "0" + Integer.toString(chinaMM) ;
	        else
	            chinaDate += Integer.toString(chinaMM) ;
	         
	         
	        chinaDate += "-" ;          // 날짜 구분자
	         
	         
	        if(chinaDD < 10)         // 일
	            chinaDate += "0" + Integer.toString(chinaDD) ;
	        else
	            chinaDate += Integer.toString(chinaDD) ;
	         
	         
	         
	        // 음력 공휴일 목록과 변환한 음력날짜가 일치하는지 비교
	        for(int i=0; i < arrLunar.length; i++){
	            String tmpLunar = arrLunar[i] ;
	             
	            if(tmpLunar.equals(chinaDate)){
	                check = true ;
	                 
	            }
	 
	        }
    	 return check; 
     }
     	public boolean yTest(String dt){
     		boolean check=false;
    		
    		String[] arrLunar = {
                    
                    "01-01"     // 신정
                    , "03-01"   // 삼일절
                    , "05-05"   // 어린이날
                    , "05-22"   // 석가탄신일
                    , "06-06"   // 현충일
                    , "08-15"   // 광복절
                    , "10-03"   // 개천절
                    ,"10-09"	//한글날
                    ,"12-25"	//크리스마스
            };
    		
    		String date=dt.substring(5,10);
    		
    		for(int i=0; i < arrLunar.length; i++){
                String tmpLunar = arrLunar[i] ;
                 
                if(tmpLunar.equals(date)){
                    check = true ;
                }
            }
     		return check;
     		
     	}
     
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
	#tbl-cal button {
		border-radius:5px;
		width:50px;
		margin:5px;
		background-color:white;
	}
	#tbl-cal button:hover{
		background-color: #E6E6E6;
	}
	#tbl-cal{
		width:100%;
		
		
	}
	#calList{
		display:none;
		border:2px solid lightgray;
		border-radius:5px;
		box-shadow:2px 2px 5px lightgray;
	}
	#calList2{
		display:none;
	}
	#calList3{
		display:none;
	}
</style>

<div style="height:1000px;">
	<div class="col-sm-4">
		<div style="width:100%;height:50px;font-size:25px;text-align:center;background-color:#286090;padding-top:11px;color:white;border-radius:8px;margin-bottom:10px;">
			의료진 정보
		</div>
		<div id="docInfoEx" style="text-align:center;font-size:20px;">
			** 의사를 먼저 선택해 주세요 **
		</div>
		<c:if test="${empty list }">
		<div style="text-align:center;">
			<img alt="doctorIMG" src="${path }/resources/img/reser/d1.png" height="340px">
		</div>
		</c:if>
		<c:forEach var="list" items="${list }">
		<div id="docInfo-div" style="height:auto;margin-bottom:10px;" class="${list.doctorNum }">
			<table id="docInfo" class="${list.hospitalNo }">
				<tr>
					<td rowspan="4"><img src="${path }/resources/img/reser/${list.doctorPhoto }" width="200px;" height="250px;"></td>
					<th>이름</th>
					<td>${list.doctorName }</td>
				</tr>
				<tr>
					<th>진료과</th>
					<td>${list.professional }</td>
				</tr>
				<tr>
					<th>전문분야</th>
					<td>${list.specialized }</td>
				</tr>
				<tr>
					<th>학력/경력</th>
					<td>
					 <c:forEach var="s" items="${fn:split(list.doctorCareer, ',')}">
					 ${s }<br>
					 </c:forEach>
					</td>
				</tr>
			</table>
		</div>	
		</c:forEach>
		
	</div>
	<div class="col-sm-4">
		<div style="width:100%;height:50px;font-size:20px;text-align:center;background-color:#286090;padding-top:11px;color:white;border-radius:8px;margin-bottom:10px;">
			날짜 선택
		</div>
		<div id="calList2" style="text-align:center;font-size:20px;">
			** 원하는 날짜를 선택해 주세요 **
		</div>
		<div id="calList">
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
					<td style="color: red;"><%if(!hdc && !hdce){ %><%=dd %><% }else {%><span style="color: red;"><%=dd %></span><%} %></td>
					<td><%if(!hdc2 && !hdce2 && !check2 && !checkDate2){ %><button class="calb" value="<%=y2%>"><%=dd2 %></button><% }else if(check2 || checkDate2) {%><%=dd2 %><% }else {%><span style="color: red;"><%=dd2 %></span><%} %></td>
					<td><%if(!hdc3 && !hdce3 && !check3 && !checkDate3){ %><button class="calb" value="<%=y3%>"><%=dd3 %></button><% }else if(check3 || checkDate3) {%><%=dd3 %><% }else {%><span style="color: red;"><%=dd3 %></span><%} %></td>
					<td><%if(!hdc4 && !hdce4 && !check4 && !checkDate4){ %><button class="calb" value="<%=y4%>"><%=dd4 %></button><% }else if(check4 || checkDate4) {%><%=dd4 %><% }else {%><span style="color: red;"><%=dd4 %></span><%} %></td>
					<td><%if(!hdc5 && !hdce5 && !check5 && !checkDate5){ %><button class="calb" value="<%=y5%>"><%=dd5 %></button><% }else if(check5 || checkDate5) {%><%=dd5 %><% }else {%><span style="color: red;"><%=dd5 %></span><%} %></td>
					<td><%if(!hdc6 && !hdce6 && !check6 && !checkDate6){ %><button class="calb" value="<%=y6%>"><%=dd6 %></button><% }else if(check6 || checkDate6) {%><%=dd6 %><% }else {%><span style="color: red;"><%=dd6 %></span><%} %></td>
					<td><%if(!hdc7 && !hdce7 && !check7 && !checkDate7){ %><button class="calb" value="<%=y7%>"><%=dd7 %></button><% }else if(check7 || checkDate7) {%><%=dd7 %><% }else {%><span style="color: red;"><%=dd7 %></span><%} %></td>
				</tr>
				<tr>
					<td style="color: red;"><%if(!hdc8 && !hdce8 && !check8 && !checkDate8){ %><%=dd8 %><% }else {%><span style="color: red;"><%=dd8 %></span><%} %></td>
					<td><%if(!hdc9 && !hdce9 && !check9 && !checkDate9){ %><button class="calb" value="<%=y9%>"><%=dd9 %></button><% }else if(check9 || checkDate9) {%><%=dd9 %><% }else {%><span style="color: red;"><%=dd9 %></span><%} %></td>
					<td><%if(!hdc10 && !hdce10 && !check10 && !checkDate10){ %><button class="calb" value="<%=y10%>"><%=dd10 %></button><% }else if(check10 || checkDate10) {%><%=dd10 %><% }else {%><span style="color: red;"><%=dd10 %></span><%} %></td>
					<td><%if(!hdc11 && !hdce11 && !check11 && !checkDate11){ %><button class="calb" value="<%=y11%>"><%=dd11 %></button><% }else if(check11 || checkDate11) {%><%=dd11 %><% }else {%><span style="color: red;"><%=dd11 %></span><%} %></td>
					<td><%if(!hdc12 && !hdce12 && !check12 && !checkDate12){ %><button class="calb" value="<%=y12%>"><%=dd12 %></button><% }else if(check12 || checkDate12) {%><%=dd12 %><% }else {%><span style="color: red;"><%=dd12 %></span><%} %></td>
					<td><%if(!hdc13 && !hdce13 && !check13 && !checkDate13){ %><button class="calb" value="<%=y13%>"><%=dd13 %></button><% }else if(check13 || checkDate13) {%><%=dd13 %><% }else {%><span style="color: red;"><%=dd13 %></span><%} %></td>
					<td><%if(!hdc14 && !hdce14 && !check14 && !checkDate14){ %><button class="calb" value="<%=y14%>"><%=dd14 %></button><% }else if(check14 || checkDate14) {%><%=dd14 %><% }else {%><span style="color: red;"><%=dd14 %></span><%} %></td>
				</tr>
				</c:if>
				<c:if test='<%=e.equals("월")%>'>
				<tr>
					<td></td>
					<td><%if(!hdc && !hdce){ %><%=dd %><% }else {%><span style="color: red;"><%=dd %></span><%} %></td>
					<td><%if(!hdc2 && !hdce2 && !check2 && !checkDate2){ %><button class="calb" value="<%=y2 %>"><%=dd2 %></button><% }else if(check2 || checkDate2) {%><%=dd2 %><% }else {%><span style="color: red;"><%=dd2 %></span><%} %></td>
					<td><%if(!hdc3 && !hdce3 && !check3 && !checkDate3){ %><button class="calb" value="<%=y3%>"><%=dd3 %></button><% }else if(check3 || checkDate3) {%><%=dd3 %><% }else {%><span style="color: red;"><%=dd3 %></span><%} %></td>
					<td><%if(!hdc4 && !hdce4 && !check4 && !checkDate4){ %><button class="calb" value="<%=y4%>"><%=dd4 %></button><% }else if(check4 || checkDate4) {%><%=dd4 %><% }else {%><span style="color: red;"><%=dd4 %></span><%} %></td>
					<td><%if(!hdc5 && !hdce5 && !check5 && !checkDate5){ %><button class="calb" value="<%=y5%>"><%=dd5 %></button><% }else if(check5 || checkDate5) {%><%=dd5 %><% }else {%><span style="color: red;"><%=dd5 %></span><%} %></td>
					<td><%if(!hdc6 && !hdce6 && !check6 && !checkDate6){ %><button class="calb" value="<%=y6%>"><%=dd6 %></button><% }else if(check6 || checkDate6) {%><%=dd6 %><% }else {%><span style="color: red;"><%=dd6 %></span><%} %></td>

				</tr>
				<tr>
					<td style="color: red;"><%if(!hdc7 && !hdce6){ %><%=dd7 %><% }else {%><span style="color: red;"><%=dd7 %></span><%} %></td>
					<td><%if(!hdc8 && !hdce8 && !check8 && !checkDate8){ %><button class="calb" value="<%=y8%>"><%=dd8 %></button><% }else if(check8 || checkDate8) {%><%=dd8 %><% }else {%><span style="color: red;"><%=dd8 %></span><%} %></td>
					<td><%if(!hdc9 && !hdce9 && !check9 && !checkDate9){ %><button class="calb" value="<%=y9%>"><%=dd9 %></button><% }else if(check9 || checkDate9) {%><%=dd9 %><% }else {%><span style="color: red;"><%=dd9 %></span><%} %></td>
					<td><%if(!hdc10 && !hdce10 && !check10 && !checkDate10){ %><button class="calb" value="<%=y10%>"><%=dd10 %></button><% }else if(check10 || checkDate10) {%><%=dd10 %><% }else {%><span style="color: red;"><%=dd10 %></span><%} %></td>
					<td><%if(!hdc11 && !hdce11 && !check11 && !checkDate11){ %><button class="calb" value="<%=y11%>"><%=dd11 %></button><% }else if(check11 || checkDate11) {%><%=dd11 %><% }else {%><span style="color: red;"><%=dd11 %></span><%} %></td>
					<td><%if(!hdc12 && !hdce12 && !check12 && !checkDate12){ %><button class="calb" value="<%=y12%>"><%=dd12 %></button><% }else if(check12 || checkDate12) {%><%=dd12 %><% }else {%><span style="color: red;"><%=dd12 %></span><%} %></td>
					<td><%if(!hdc13 && !hdce13 && !check13 && !checkDate13){ %><button class="calb" value="<%=y13%>"><%=dd13 %></button><% }else if(check13 || checkDate13) {%><%=dd13 %><% }else {%><span style="color: red;"><%=dd13 %></span><%} %></td>
				</tr>
				<tr>
					<td style="color: red;"><%if(!hdc14 && !hdce14 && !check14 && !checkDate14){ %><%=dd14 %><% }else {%><span style="color: red;"><%=dd14 %></span><%} %></td>
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
					<td><%if(!hdc && !hdce){ %><%=dd %><% }else {%><span style="color: red;"><%=dd %></span><%} %></td>
					<td><%if(!hdc2 && !hdce2 && !check2 && !checkDate2){ %><button class="calb" value="<%=y2 %>"><%=dd2 %></button><% }else if(check2 || checkDate2) {%><%=dd2 %><% }else {%><span style="color: red;"><%=dd2 %></span><%} %></td>
					<td><%if(!hdc3 && !hdce3 && !check3 && !checkDate3){ %><button class="calb" value="<%=y3%>"><%=dd3 %></button><% }else if(check3 || checkDate3) {%><%=dd3 %><% }else {%><span style="color: red;"><%=dd3 %></span><%} %></td>
					<td><%if(!hdc4 && !hdce4 && !check4 && !checkDate4){ %><button class="calb" value="<%=y4%>"><%=dd4 %></button><% }else if(check4 || checkDate4) {%><%=dd4 %><% }else {%><span style="color: red;"><%=dd4 %></span><%} %></td>
					<td><%if(!hdc5 && !hdce5 && !check5 && !checkDate5){ %><button class="calb" value="<%=y5%>"><%=dd5 %></button><% }else if(check5 || checkDate5) {%><%=dd5 %><% }else {%><span style="color: red;"><%=dd5 %></span><%} %></td>
				</tr>
				<tr>
					<td style="color: red;"><%if(!hdc6 && !hdce6 && !check6 && !checkDate6){ %><%=dd6 %><% }else {%><span style="color: red;"><%=dd6 %></span><%} %></td>
					<td><%if(!hdc7 && !hdce7 && !check7 && !checkDate7){ %><button class="calb" value="<%=y7%>"><%=dd7 %></button><% }else if(check7 || checkDate7) {%><%=dd7 %><% }else {%><span style="color: red;"><%=dd7 %></span><%} %></td>
					<td><%if(!hdc8 && !hdce8 && !check8 && !checkDate8){ %><button class="calb" value="<%=y8%>"><%=dd8 %></button><% }else if(check8 || checkDate8) {%><%=dd8 %><% }else {%><span style="color: red;"><%=dd8 %></span><%} %></td>
					<td><%if(!hdc9 && !hdce9 && !check9 && !checkDate9){ %><button class="calb" value="<%=y9%>"><%=dd9 %></button><% }else if(check9 || checkDate9) {%><%=dd9 %><% }else {%><span style="color: red;"><%=dd9 %></span><%} %></td>
					<td><%if(!hdc10 && !hdce10 && !check10 && !checkDate10){ %><button class="calb" value="<%=y10%>"><%=dd10 %></button><% }else if(check10 || checkDate10) {%><%=dd10 %><% }else {%><span style="color: red;"><%=dd10 %></span><%} %></td>
					<td><%if(!hdc11 && !hdce11 && !check11 && !checkDate11){ %><button class="calb" value="<%=y11%>"><%=dd11 %></button><% }else if(check11 || checkDate11) {%><%=dd11 %><% }else {%><span style="color: red;"><%=dd11 %></span><%} %></td>
					<td><%if(!hdc12 && !hdce12 && !check12 && !checkDate12){ %><button class="calb" value="<%=y12%>"><%=dd12 %></button><% }else if(check12 || checkDate12) {%><%=dd12 %><% }else {%><span style="color: red;"><%=dd12 %></span><%} %></td>
			
				</tr>
				<tr>
					<td style="color: red;"><%if(!hdc13 && !hdce13 && !check13 && !checkDate13){ %><%=dd13 %><% }else {%><span style="color: red;"><%=dd13 %></span><%} %></td>
					<td><%if(!hdc14 && !hdce14 && !check14 && !checkDate14){ %><button class="calb" value="<%=y14%>"><%=dd14 %></button><% }else if(check14 || checkDate14) {%><%=dd14 %><% }else {%><span style="color: red;"><%=dd14 %></span><%} %></td>
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
					<td><%if(!hdc && !hdce){ %><%=dd %><% }else {%><span style="color: red;"><%=dd %></span><%} %></td>
					<td><%if(!hdc2 && !hdce2 && !check2 && !checkDate2){ %><button class="calb" value="<%=y2 %>"><%=dd2 %></button><% }else if(check2 || checkDate2) {%><%=dd2 %><% }else {%><span style="color: red;"><%=dd2 %></span><%} %></td>
					<td><%if(!hdc3 && !hdce3 && !check3 && !checkDate3){ %><button class="calb" value="<%=y3%>"><%=dd3 %></button><% }else if(check3 || checkDate3) {%><%=dd3 %><% }else {%><span style="color: red;"><%=dd3 %></span><%} %></td>
					<td><%if(!hdc4 && !hdce4 && !check4 && !checkDate4){ %><button class="calb" value="<%=y4%>"><%=dd4 %></button><% }else if(check4 || checkDate4) {%><%=dd4 %><% }else {%><span style="color: red;"><%=dd4 %></span><%} %></td>
				</tr>
				<tr>
					<td style="color: red;"><%if(!hdc5 && !hdce5 && !check5 && !checkDate5){ %><%=dd5 %><% }else {%><span style="color: red;"><%=dd5 %></span><%} %></td>
					<td><%if(!hdc6 && !hdce6 && !check6 && !checkDate6){ %><button class="calb" value="<%=y6%>"><%=dd6 %></button><% }else if(check6 || checkDate6) {%><%=dd6 %><% }else {%><span style="color: red;"><%=dd6 %></span><%} %></td>
					<td><%if(!hdc7 && !hdce7 && !check7 && !checkDate7){ %><button class="calb" value="<%=y7%>"><%=dd7 %></button><% }else if(check7 || checkDate7) {%><%=dd7 %><% }else {%><span style="color: red;"><%=dd7 %></span><%} %></td>
					<td><%if(!hdc8 && !hdce8 && !check8 && !checkDate8){ %><button class="calb" value="<%=y8%>"><%=dd8 %></button><% }else if(check8 || checkDate8) {%><%=dd8 %><% }else {%><span style="color: red;"><%=dd8 %></span><%} %></td>
					<td><%if(!hdc9 && !hdce9 && !check9 && !checkDate9){ %><button class="calb" value="<%=y9%>"><%=dd9 %></button><% }else if(check9 || checkDate9) {%><%=dd9 %><% }else {%><span style="color: red;"><%=dd9 %></span><%} %></td>
					<td><%if(!hdc10 && !hdce10 && !check10 && !checkDate10){ %><button class="calb" value="<%=y10%>"><%=dd10 %></button><% }else if(check10 || checkDate10) {%><%=dd10 %><% }else {%><span style="color: red;"><%=dd10 %></span><%} %></td>
					<td><%if(!hdc11 && !hdce11 && !check11 && !checkDate11){ %><button class="calb" value="<%=y11%>"><%=dd11 %></button><% }else if(check11 || checkDate11) {%><%=dd11 %><% }else {%><span style="color: red;"><%=dd11 %></span><%} %></td>
				</tr>
				<tr>
					<td style="color: red;"><%if(!hdc12 && !hdce12 && !check12 && !checkDate12){ %><%=dd12 %><% }else {%><span style="color: red;"><%=dd12 %></span><%} %></td>
					<td><%if(!hdc13 && !hdce13 && !check13 && !checkDate13){ %><button class="calb" value="<%=y13%>"><%=dd13 %></button><% }else if(check13 || checkDate13) {%><%=dd13 %><% }else {%><span style="color: red;"><%=dd13 %></span><%} %></td>
					<td><%if(!hdc14 && !hdce14 && !check14 && !checkDate14){ %><button class="calb" value="<%=y14%>"><%=dd14 %></button><% }else if(check14 || checkDate14) {%><%=dd14 %><% }else {%><span style="color: red;"><%=dd14 %></span><%} %></td>
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
					<td><%if(!hdc && !hdce){ %><%=dd %><% }else {%><span style="color: red;"><%=dd %></span><%} %></td>
					<td><%if(!hdc2 && !hdce2 && !check2 && !checkDate2){ %><button class="calb" value="<%=y2 %>"><%=dd2 %></button><% }else if(check2 || checkDate2) {%><%=dd2 %><% }else {%><span style="color: red;"><%=dd2 %></span><%} %></td>
					<td><%if(!hdc3 && !hdce3 && !check3 && !checkDate3){ %><button class="calb" value="<%=y3%>"><%=dd3 %></button><% }else if(check3 || checkDate3) {%><%=dd3 %><% }else {%><span style="color: red;"><%=dd3 %></span><%} %></td>
				</tr>
				<tr>
					<td style="color: red;"><%if(!hdc4 && !hdce4 && !check4 && !checkDate4){ %><%=dd4 %><% }else {%><span style="color: red;"><%=dd4 %></span><%} %></td>
					<td><%if(!hdc5 && !hdce5 && !check5 && !checkDate5){ %><button class="calb" value="<%=y5%>"><%=dd5 %></button><% }else if(check5 || checkDate5) {%><%=dd5 %><% }else {%><span style="color: red;"><%=dd5 %></span><%} %></td>
					<td><%if(!hdc6 && !hdce6 && !check6 && !checkDate6){ %><button class="calb" value="<%=y6%>"><%=dd6 %></button><% }else if(check6 || checkDate6) {%><%=dd6 %><% }else {%><span style="color: red;"><%=dd6 %></span><%} %></td>
					<td><%if(!hdc7 && !hdce7 && !check7 && !checkDate7){ %><button class="calb" value="<%=y7%>"><%=dd7 %></button><% }else if(check7 || checkDate7) {%><%=dd7 %><% }else {%><span style="color: red;"><%=dd7 %></span><%} %></td>
					<td><%if(!hdc8 && !hdce8 && !check8 && !checkDate8){ %><button class="calb" value="<%=y8%>"><%=dd8 %></button><% }else if(check8 || checkDate8) {%><%=dd8 %><% }else {%><span style="color: red;"><%=dd8 %></span><%} %></td>
					<td><%if(!hdc9 && !hdce9 && !check9 && !checkDate9){ %><button class="calb" value="<%=y9%>"><%=dd9 %></button><% }else if(check9 || checkDate9) {%><%=dd9 %><% }else {%><span style="color: red;"><%=dd9 %></span><%} %></td>
					<td><%if(!hdc10 && !hdce10 && !check10 && !checkDate10){ %><button class="calb" value="<%=y10%>"><%=dd10 %></button><% }else if(check10 || checkDate10) {%><%=dd10 %><% }else {%><span style="color: red;"><%=dd10 %></span><%} %></td>
				</tr>
				<tr>
					<td style="color: red;"><%if(!hdc11 && !hdce11 && !check11 && !checkDate11){ %><%=dd11 %><% }else {%><span style="color: red;"><%=dd11 %></span><%} %></td>
					<td><%if(!hdc12 && !hdce12 && !check12 && !checkDate12){ %><button class="calb" value="<%=y12%>"><%=dd12 %></button><% }else if(check12 || checkDate12) {%><%=dd12 %><% }else {%><span style="color: red;"><%=dd12 %></span><%} %></td>
					<td><%if(!hdc13 && !hdce13 && !check13 && !checkDate13){ %><button class="calb" value="<%=y13%>"><%=dd13 %></button><% }else if(check13 || checkDate13) {%><%=dd13 %><% }else {%><span style="color: red;"><%=dd13 %></span><%} %></td>
					<td><%if(!hdc14 && !hdce14 && !check14 && !checkDate14){ %><button class="calb" value="<%=y14%>"><%=dd14 %></button><% }else if(check14 || checkDate14) {%><%=dd14 %><% }else {%><span style="color: red;"><%=dd14 %></span><%} %></td>
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
					<td><%if(!hdc && !hdce){ %><%=dd %><% }else {%><span style="color: red;"><%=dd %></span><%} %></td>
					<td><%if(!hdc2 && !hdce2 && !check2 && !checkDate2){ %><button class="calb" value="<%=y2 %>"><%=dd2 %></button><% }else if(check2 || checkDate2) {%><%=dd2 %><% }else {%><span style="color: red;"><%=dd2 %></span><%} %></td>
				</tr>
				<tr>
					<td style="color: red;"><%if(!hdc3 && !hdce3 && !check3 && !checkDate3){ %><%=dd3 %><% }else {%><span style="color: red;"><%=dd3 %></span><%} %></td>
					<td><%if(!hdc4 && !hdce4 && !check4 && !checkDate4){ %><button class="calb" value="<%=y4%>"><%=dd4 %></button><% }else if(check4 || checkDate4) {%><%=dd4 %><% }else {%><span style="color: red;"><%=dd4 %></span><%} %></td>
					<td><%if(!hdc5 && !hdce5 && !check5 && !checkDate5){ %><button class="calb" value="<%=y5%>"><%=dd5 %></button><% }else if(check5 || checkDate5) {%><%=dd5 %><% }else {%><span style="color: red;"><%=dd5 %></span><%} %></td>
					<td><%if(!hdc6 && !hdce6 && !check6 && !checkDate6){ %><button class="calb" value="<%=y6%>"><%=dd6 %></button><% }else if(check6 || checkDate6) {%><%=dd6 %><% }else {%><span style="color: red;"><%=dd6 %></span><%} %></td>
					<td><%if(!hdc7 && !hdce7 && !check7 && !checkDate7){ %><button class="calb" value="<%=y7%>"><%=dd7 %></button><% }else if(check7 || checkDate7) {%><%=dd7 %><% }else {%><span style="color: red;"><%=dd7 %></span><%} %></td>
					<td><%if(!hdc8 && !hdce8 && !check8 && !checkDate8){ %><button class="calb" value="<%=y8%>"><%=dd8 %></button><% }else if(check8 || checkDate8) {%><%=dd8 %><% }else {%><span style="color: red;"><%=dd8 %></span><%} %></td>
					<td><%if(!hdc9 && !hdce9 && !check9 && !checkDate9){ %><button class="calb" value="<%=y9%>"><%=dd9 %></button><% }else if(check9 || checkDate9) {%><%=dd9 %><% }else {%><span style="color: red;"><%=dd9 %></span><%} %></td>
				</tr>
				<tr>
					<td style="color: red;"><%if(!hdc10 && !hdce10 && !check10 && !checkDate10){ %><%=dd10 %><% }else {%><span style="color: red;"><%=dd10 %></span><%} %></td>
					<td><%if(!hdc11 && !hdce11 && !check11 && !checkDate11){ %><button class="calb" value="<%=y11%>"><%=dd11 %></button><% }else if(check11 || checkDate11) {%><%=dd11 %><% }else {%><span style="color: red;"><%=dd11 %></span><%} %></td>
					<td><%if(!hdc12 && !hdce12 && !check12 && !checkDate12){ %><button class="calb" value="<%=y12%>"><%=dd12 %></button><% }else if(check12 || checkDate12) {%><%=dd12 %><% }else {%><span style="color: red;"><%=dd12 %></span><%} %></td>
					<td><%if(!hdc13 && !hdce13 && !check13 && !checkDate13){ %><button class="calb" value="<%=y13%>"><%=dd13 %></button><% }else if(check13 || checkDate13) {%><%=dd13 %><% }else {%><span style="color: red;"><%=dd13 %></span><%} %></td>
					<td><%if(!hdc14 && !hdce14 && !check14 && !checkDate14){ %><button class="calb" value="<%=y14%>"><%=dd14 %></button><% }else if(check14 || checkDate14) {%><%=dd14 %><% }else {%><span style="color: red;"><%=dd14 %></span><%} %></td>
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
					<td><%if(!hdc && !hdce){ %><%=dd %><% }else {%><span style="color: red;"><%=dd %></span><%} %></td>
				</tr>
				<tr>
					<td style="color: red;"><%if(!hdc2 && !hdce2 && !check2 && !checkDate2){ %><%=dd2 %><% }else {%><span style="color: red;"><%=dd2 %></span><%} %></td>
					<td><%if(!hdc3 && !hdce3 && !check3 && !checkDate3){ %><button class="calb" value="<%=y3%>"><%=dd3 %></button><% }else if(check3 || checkDate3) {%><%=dd3 %><% }else {%><span style="color: red;"><%=dd3 %></span><%} %></td>
					<td><%if(!hdc4 && !hdce4 && !check4 && !checkDate4){ %><button class="calb" value="<%=y4%>"><%=dd4 %></button><% }else if(check4 || checkDate4) {%><%=dd4 %><% }else {%><span style="color: red;"><%=dd4 %></span><%} %></td>
					<td><%if(!hdc5 && !hdce5 && !check5 && !checkDate5){ %><button class="calb" value="<%=y5%>"><%=dd5 %></button><% }else if(check5 || checkDate5) {%><%=dd5 %><% }else {%><span style="color: red;"><%=dd5 %></span><%} %></td>
					<td><%if(!hdc6 && !hdce6 && !check6 && !checkDate6){ %><button class="calb" value="<%=y6%>"><%=dd6 %></button><% }else if(check6 || checkDate6) {%><%=dd6 %><% }else {%><span style="color: red;"><%=dd6 %></span><%} %></td>
					<td><%if(!hdc7 && !hdce7 && !check7 && !checkDate7){ %><button class="calb" value="<%=y7%>"><%=dd7 %></button><% }else if(check7 || checkDate7) {%><%=dd7 %><% }else {%><span style="color: red;"><%=dd7 %></span><%} %></td>
					<td><%if(!hdc8 && !hdce8 && !check8 && !checkDate8){ %><button class="calb" value="<%=y8%>"><%=dd8 %></button><% }else if(check8 || checkDate8) {%><%=dd8 %><% }else {%><span style="color: red;"><%=dd8 %></span><%} %></td>
				</tr>
				<tr>
					<td style="color: red;"><%if(!hdc9 && !hdce9 && !check9 && !checkDate9){ %><%=dd9 %><% }else {%><span style="color: red;"><%=dd9 %></span><%} %></td>
					<td><%if(!hdc10 && !hdce10 && !check10 && !checkDate10){ %><button class="calb" value="<%=y10%>"><%=dd10 %></button><% }else if(check10 || checkDate10) {%><%=dd10 %><% }else {%><span style="color: red;"><%=dd10 %></span><%} %></td>
					<td><%if(!hdc11 && !hdce11 && !check11 && !checkDate11){ %><button class="calb" value="<%=y11%>"><%=dd11 %></button><% }else if(check11 || checkDate11) {%><%=dd11 %><% }else {%><span style="color: red;"><%=dd11 %></span><%} %></td>
					<td><%if(!hdc12 && !hdce12 && !check12 && !checkDate12){ %><button class="calb" value="<%=y12%>"><%=dd12 %></button><% }else if(check12 || checkDate12) {%><%=dd12 %><% }else {%><span style="color: red;"><%=dd12 %></span><%} %></td>
					<td><%if(!hdc13 && !hdce13 && !check13 && !checkDate13){ %><button class="calb" value="<%=y13%>"><%=dd13 %></button><% }else if(check13 || checkDate13) {%><%=dd13 %><% }else {%><span style="color: red;"><%=dd13 %></span><%} %></td>
					<td><%if(!hdc14 && !hdce14 && !check14 && !checkDate14){ %><button class="calb" value="<%=y14%>"><%=dd14 %></button><% }else if(check14 || checkDate14) {%><%=dd14 %><% }else {%><span style="color: red;"><%=dd14 %></span><%} %></td>
					<td></td>
				</tr>
				</c:if>
			</table>
		</div>
		<div id="calPhoto" style="text-align:center;">
			<img alt="달력사진" src="${path }/resources/img/reser/reserCalendar.png" height="300px;">
		</div>
		
	</div>
	<div class="col-sm-4">
		<div style="width:100%;height:50px;font-size:20px;text-align:center;background-color:#286090;padding-top:11px;color:white;border-radius:8px;margin-bottom:10px;">
			시간 선택
		</div>
		<div id="calList3" style="text-align:center;font-size:20px;">
			** 원하는 시간을 선택 후 예약하기 버튼을 눌러주세요  **
		</div>
		<div id="timeImg" style="text-align:center;">
			<img alt="달력사진" src="${path }/resources/img/reser/reserTime.png" height="300px;"></div>
		<div id="timeChoice"></div>
	</div>
</div>
<script>
	
	$(function () {
		var docNum=${doctor.doctorNum }
		$('.calb').click(function () {
			$('.calb').css('background-color','white');
			$('.calb').css('color','black');
			$(this).css('background-color','#286090');
			$(this).css('color','white');
			$.ajax({
				url:"${path}/medi/mediChoice",
				data:{docNum:docNum,time:$(this).val()},
				dataType:"html",
				success:function(data){
					$('#timeImg').css("display",'none');
					$('#calList2').css("display",'none');
					$('#calList3').css("display",'block');
					$('#timeChoice').html(data);
				}
			});
		});
		$('#docInfo-div').click(function () {
			alert('들어가기전');
			location.href='${path}/medi/doctorS?docNum='+$(this).attr('class')+'&hosNum='+$('#docInfo').attr('class');
		});
		
		
	});
	if(<%=docInfo!=null%>||<%=docSche!=null%>){
		$('#calList').css('display','block');
		$('#calList2').css('display','block');
		$('#docInfoEx').css('display','none');
		$('#calPhoto').css('display','none');
		
	}
</script>



<jsp:include page="/WEB-INF/views/common/footer.jsp"/>