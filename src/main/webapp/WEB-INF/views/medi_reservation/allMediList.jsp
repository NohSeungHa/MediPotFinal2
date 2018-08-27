<%@page import="com.medi.pot.reservation.model.vo.HospitalInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>
<% List<HospitalInfo> list=(List<HospitalInfo>)request.getAttribute("list"); %>
   <c:set var='path' value="<%=request.getContextPath()%>"></c:set>

<jsp:include page="/WEB-INF/views/common/header.jsp">
<jsp:param value="HomeSpring" name="pageTitle"></jsp:param>
</jsp:include>
   <div class="container">
               <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=abdb50b4b74a87e05a2f581cfdc897a8&libraries=services"></script>
               <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services,clusterer,drawing"></script>
               
                <div id="map" style="width:100%;height:800px;margin-bottom:30px;"></div>
               <script>
                  
               
               var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
                   mapOption = {
                       center: new daum.maps.LatLng(36.329030, 127.390334), // 지도의 중심좌표
                       level: 13 // 지도의 확대 레벨
                   };  
               // 지도를 생성합니다    
               var map = new daum.maps.Map(mapContainer, mapOption); 
               
               // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
               var mapTypeControl = new daum.maps.MapTypeControl();

               // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
               // daum.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
               map.addControl(mapTypeControl, daum.maps.ControlPosition.TOPRIGHT);

               // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
               var zoomControl = new daum.maps.ZoomControl();
               map.addControl(zoomControl, daum.maps.ControlPosition.RIGHT);
               // 주소-좌표 변환 객체를 생성합니다
               var geocoder = new daum.maps.services.Geocoder();
               
               // 주소로 좌표를 검색합니다
               <%for(int i=0; i<list.size(); i++){
                  String photo=list.get(i).getHospitalRePhoto();
               %>
               geocoder.addressSearch('<%=list.get(i).getHospitalAddr()%>', function(result, status) {
                  
                   // 정상적으로 검색이 완료됐으면 
                    if (status === daum.maps.services.Status.OK) {
               
                       var coords = new daum.maps.LatLng(result[0].y, result[0].x);
               
                       // 결과값으로 받은 위치를 마커로 표시합니다
                       var marker = new daum.maps.Marker({
                           map: map,
                           position: coords
                       });
               
                       // 인포윈도우로 장소에 대한 설명을 표시합니다
                       var infowindow = new daum.maps.InfoWindow({
                           content: '<div style="width:200px;text-align:center;padding:6px 0;font-size:20px;"><img src="${path }/resources/uploadfile/hospitalInfo/<%=photo%>" width="150px;" height="150px;" /><br><p style="margin-top:10px;"><span style="color:#286090;">병원명</span> <%=list.get(i).getHospitalName()%></p><p><span style="color:#286090;">진료과목</span> <%=list.get(i).getHospitalProfessional()%></p></div>'
                       });
                       
                       daum.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
                       daum.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
            
                   }
                 // 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
                    function makeOverListener(map, marker, infowindow) {
                        return function() {
                            infowindow.open(map, marker);
                        };
                    }

                    // 인포윈도우를 닫는 클로저를 만드는 함수입니다 
                    function makeOutListener(infowindow) {
                        return function() {
                            infowindow.close();
                        };
                    }
                    
                 // 마커에 click 이벤트를 등록합니다
                    daum.maps.event.addListener(marker, 'click', function() {

                        location.href='${path}/medi/mediInfo?no=<%=list.get(i).getHospitalNum()%>';
                    });
                    
               });
               <%}%>
               </script>
   </div>

   

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>