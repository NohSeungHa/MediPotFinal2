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
	<jsp:param value="" name="pageTitle"/>
</jsp:include>
 <link href='${path }/resources/css/fullcalendar.min.css' rel='stylesheet' />
<link href='${path }/resources/css/fullcalendar.print.min.css' rel='stylesheet' media='print' />
<script src='${path }/resources/js/moment.min.js'></script>
<script src='${path }/resources/js/jquery.min.js'></script>
<script src='${path }/resources/js/gcal.js'></script>
<script src='${path }/resources/js//lang-all.js'></script>
<script src='${path }/resources/js/fullcalendar.min.js'></script>
<script>

  $(document).ready(function() {

    $('#calendar').fullCalendar({
      header: {
        left: 'prev,next today',
        center: 'title',
        right: 'month' /* ,agendaWeek,agendaDay,listWeek */
      },
      defaultDate: '<%=today2%>',
      navLinks: true, // can click day/week names to navigate views
      lang:"ko",
      editable: true,
      eventLimit: true, // allow "more" link when too many events
      googleCalendarApiKey:"AIzaSyDcnW6WejpTOCffshGDDb4neIrXVUA1EAE",
      events: [
    	// 대한민국의 공휴일
          {
                googleCalendarId : "ko.south_korea#holiday@group.v.calendar.google.com"
              , className : "koHolidays"
              , color : "#FF0000"
              , textColor : "#FFFFFF"
          },
        {
          title: 'All Day Event',
          start: '2018-03-01',
        },
        {
          title: 'Long Event',
          start: '2018-03-07',
          end: '2018-03-10'
        },
        {
          id: 999,
          title: 'Repeating Event',
          start: '2018-03-09T16:00:00'
        },
        {
          id: 999,
          title: 'Repeating Event',
          start: '2018-03-16T16:00:00'
        },
        {
          title: 'Conference',
          start: '2018-03-11',
          end: '2018-03-13'
        },
        {
          title: 'Meeting',
          start: '2018-03-12T10:30:00',
          end: '2018-03-12T12:30:00'
        },
        {
          title: 'Lunch',
          start: '2018-03-12T12:00:00'
        },
        {
          title: 'Meeting',
          start: '2018-03-12T14:30:00'
        },
        {
          title: 'Happy Hour',
          start: '2018-03-12T17:30:00'
        },
        {
          title: 'Dinner',
          start: '2018-03-12T20:00:00'
        },
        {
          title: 'Birthday Party',
          start: '2018-03-13T07:00:00'
        },
        {
          title: 'Click for Google',
          url: 'http://google.com/',
          start: '2018-03-28'
        }
      ]
    });

  });

</script>

<style>


  #calendar {
    max-width: 400px;
    margin: 0 auto;
  }

</style>

<br><br><br><br><br><br><br>
  <div id='calendar'></div>
<br><br><br><br><br><br><br>




<jsp:include page="/WEB-INF/views/common/footer.jsp"/>