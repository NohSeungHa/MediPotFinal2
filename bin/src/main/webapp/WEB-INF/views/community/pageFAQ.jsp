<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="<%=request.getContextPath() %>"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value=" " name="pageTitle" />
</jsp:include>
<style>
 .panel-heading a{
 	text-decoration:none;
 }
 .panel-heading a p{
 	color:red;
 	float:left;
 }
 .panel-body p{
 	color:red;
 	float:left;
 }
 #home{
 	float:right;
    width:70px;
    color: black;
    text-decoration: none;
 }
 #home:hover{
 	color: #18bc9c;
 }
 #faqHv{
 	float:right;
 }
 #faqHv:hover{
 	color: #18bc9c;
 }
</style>
<div class="container" >
  <img class="img-thumbnail" src="${path}/resources/img/community/faqimage.png" style="width: 1200px; height: 300px;"/>
  <br><br>
  <a id="faqHv" href="${path}/PageFAQ/PageFAQ.do" style="float: right;">FAQ</a>
	<p style="float: right;">
		<b style="margin-right:10px;">></b>
	</p>
	<a id="home" href="${path}" style="float:right;width:70px;"><img
		src="${path}/resources/img/notice/home.jpg"
		style="width: 30%; height: 30%;"> 홈으로</a>
	<br><br>
  <div class="panel-group tab-pane fade in active" id="accordion">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse1"><p>Q&nbsp;</p>이메일 인증할 때 이메일이 이미 중복되어 있다고 나옵니다.</a>
        </h4>
      </div>
      <div id="collapse1" class="panel-collapse collapse">
        <div class="panel-body"><p>A&nbsp;</p>이메일 인증시 이미 중복되어 있다고 나오는 경우는 예전에 해당 이메일로 저희 메디팟에 이미 가입하신 경우가 있는 것입니다.<br><br>
            로그인 화면 아래에 아이디/비밀번호 찾기를 이용해보세요.<br><br>
            그래도 모르시겠다면 저희 메디팟으로 문의 주시기 바랍니다.</div>
      </div>
    </div>
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse2"><p>Q&nbsp;</p>당일 사용자취소의 경우도 예약불이행으로 불이익을 받는 건가요?</a>
        </h4>
      </div>
      <div id="collapse2" class="panel-collapse collapse">
        <div class="panel-body"><p>A&nbsp;</p>당일 예약인 경우 예약시간이 지난 상태에서 취소 불가능하고요.<br><br>
        당일 예약시간 이전에 취소하시면 불이익 없습니다.</div>
      </div>
    </div>
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse3"><p>Q&nbsp;</p>아이가 둘 이상인데 한 번에 예약하고 싶어요.</a>
        </h4>
      </div>
      <div id="collapse3" class="panel-collapse collapse">
        <div class="panel-body"><p>A&nbsp;</p>예약하실 의사선생님, 예약하실 날짜, 예약하실 시간을 선택 후 추가로 진료 받을 분을 추가 코멘트에 적어주시면 되겠습니다.</div>
      </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading">
          <h4 class="panel-title">
            <a data-toggle="collapse" data-parent="#accordion" href="#collapse4"><p>Q&nbsp;</p>문의할게 있는데 1:1문의가 안보여요.</a>
          </h4>
        </div>
        <div id="collapse4" class="panel-collapse collapse">
          <div class="panel-body"><p>A&nbsp;</p>메디팟 홈페이지 상단 오른쪽에 고객지원 -> 1:1문의가 있습니다.
              <br><br>
              1:1 문의는 로그인 후 이용이 가능합니다.
          </div>
        </div>
      </div>
      <div class="panel panel-default">
        <div class="panel-heading">
          <h4 class="panel-title">
            <a data-toggle="collapse" data-parent="#accordion" href="#collapse5"><p>Q&nbsp;</p>예약 하려는 병원이 안보입니다.</a>
          </h4>
        </div>
        <div id="collapse5" class="panel-collapse collapse">
          <div class="panel-body"><p>A&nbsp;</p>메디팟 예약서비스를 이용하는 병원만 메디팟에서 예약이 가능합니다.
            <br><br>  
            예약 가능한 병원을 찾으시려면 메인페이지 상단에 병원검색을 이용하시면 됩니다.</div>
        </div>
      </div>
      <div class="panel panel-default">
            <div class="panel-heading">
              <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion" href="#collapse6"><p>Q&nbsp;</p>아이 출생신고가 되지 않아 주민등록번호가 없는데 어떻게 예약하나요?</a>
              </h4>
            </div>
            <div id="collapse6" class="panel-collapse collapse">
              <div class="panel-body"><p>A&nbsp;</p>우선 방문하시려는 병원측에 사정을 말씀하시고, 부모님 이름으로 예약 후 아이 진료를 받을 수 있는지 문의해보세요.</div>
            </div>
       </div>
          <div class="panel panel-default">
                <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse7"><p>Q&nbsp;</p>예약 실패라고 나옵니다.</a>
                  </h4>
                </div>
                <div id="collapse7" class="panel-collapse collapse">
                  <div class="panel-body"><p>A&nbsp;</p>메디팟은 실시간 예약사이트로서 동일한 시간에 대하여 동시에 여러 명이 예약하게 될 경우 예약중복으로 실패될 수 있습니다. 
                      <br><br>다른 예약 가능한 시간으로 다시 예약해보세요.</div>
                </div>
              </div>
  </div>
  <!-- 두번 째 -->
  <div class="panel-group tab-pane fade" id="accordion2"  style="display: none;">
        <div class="panel panel-default">
          <div class="panel-heading">
            <h4 class="panel-title">
              <a data-toggle="collapse" data-parent="#accordion2" href="#collapse8"><p>Q&nbsp;</p>비밀번호를 잊어버렸습니다, 비밀번호 찾기를 했는데 이메일이 오지 않습니다.</a>
            </h4>
          </div>
          <div id="collapse8" class="panel-collapse collapse">
            <div class="panel-body"><p>A&nbsp;</p>메일이 오지 않을 경우는 여러 가지가 있습니다. <br><br>
            이메일 주소가 잘못 되었는지 확인하시고 주소가 맞는다면 혹시 스팸메일로 저장되어 있는지 확인해 주시고 그것도 아니라면 이메일 저장 공간을 확인하시기 바랍니다.<br><br>
            잘 모르시겠다면 메디팟으로 연락주시면 이용에 도움 드리겠습니다.</div>
          </div>
        </div>
        <div class="panel panel-default">
          <div class="panel-heading">
            <h4 class="panel-title">
              <a data-toggle="collapse" data-parent="#accordion2" href="#collapse9"><p>Q&nbsp;</p>예약 취소는 언제 까지 가능한가요?</a>
            </h4>
          </div>
          <div id="collapse9" class="panel-collapse collapse">
            <div class="panel-body"><p>A&nbsp;</p>예약시간 이전까지 취소 가능합니다.<br><br>
            가능한 다른 환자분을 위해서 1시간 이전에는 취소 부탁드립니다.</div>
          </div>
        </div>
        <div class="panel panel-default">
          <div class="panel-heading">
            <h4 class="panel-title">
              <a data-toggle="collapse" data-parent="#accordion2" href="#collapse10"><p>Q&nbsp;</p>예약하고 병원에 갔는데 예약이 안 되어 있다고 합니다.</a>
            </h4>
          </div>
          <div id="collapse10" class="panel-collapse collapse">
            <div class="panel-body"><p>A&nbsp;</p>예약 시, 예약자리스트에 추가 후 반드시 "예약하기"버튼을 누르셔야 합니다.<br><br>
            예약실패의 경우가 있으니 반드시 예약성공 후 부여된 예약번호를 확인하고 병원에 방문해주세요.</div>
          </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
              <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion2" href="#collapse11"><p>Q&nbsp;</p>예약 취소는 어떻게 하나요?</a>
              </h4>
            </div>
            <div id="collapse11" class="panel-collapse collapse">
              <div class="panel-body"><p>A&nbsp;</p>예약 취소는 반드시 예약시간 이전에 하여 주시기 바랍니다.<br><br>
 1. 로그인을 합니다.<br><br>
 2. 이름 탭에서 내 예약 정보를 클릭합니다.<br><br>
 3. 예약된 병원의 예약취소 버튼을 클릭하시면 됩니다.<br><br>
 메디팟으로 연락 주셔도 취소 가능합니다. 
              </div>
            </div>
          </div>
          <div class="panel panel-default">
            <div class="panel-heading">
              <h4 class="panel-title">
                <a data-toggle="collapse" data-parent="#accordion2" href="#collapse12"><p>Q&nbsp;</p>진료예약을 하려 하는데 어떻게 해야 하나요?</a>
              </h4>
            </div>
            <div id="collapse12" class="panel-collapse collapse">
              <div class="panel-body"><p>A&nbsp;</p>1. 회원가입 후 로그인 합니다.<br><br>
 2.예약하기에 들어가서 지역을 선택 후 진료과목을 선택합니다.<br><br>
 3. 진료 받고자 하는 병원을 선택합니다.<br><br>
 4. 진료 받을 의사를 선택합니다.<br><br>
 5. 진료 받을 날짜를 선택합니다.<br><br>
 6. 진료 시간을 선택 후 예약하기를 누르시면 됩니다.<br><br>
 7. 예약시간 5분전에 방문하시기 바랍니다.<br><br>
 8. 병원을 방문하실 수 없을 경우에는 반드시 예약 취소 바랍니다.</div>
            </div>
          </div>
          <div class="panel panel-default">
                <div class="panel-heading">
                  <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion2" href="#collapse13"><p>Q&nbsp;</p>예약서비스를 신청하려면 어떻게 해야 하나요?</a>
                  </h4>
                </div>
                <div id="collapse13" class="panel-collapse collapse">
                  <div class="panel-body"><p>A&nbsp;</p> 1. 병원 회원 가입 후 로그인 <br><br>
 2. 관리자 승인 대기합니다.<br><br>
 3. 관리자 승인 후 병원 정보와 의사 정보를 입력합니다.<br><br>
 4. 서비스를 이용하시면 됩니다.</div>
                </div>
           </div>
      </div> 
  <!-- 페이지 -->
  <ul class="pagination" style="display:table;margin-left: auto;margin-right: auto;">
        <li class="active"><a data-toggle="tab" href="#accordion" onclick="acc1()" id="accor1">1</a></li>
        <li><a data-toggle="tab" href="#accordion2" onclick="acc2()" id="accor2">2</a></li>
    </ul>
</div>
<script>
 function acc1(){
     $('#accordion2').css('display','none');
     $('#accordion').css('display','block');
     for(var i=1; i<8;i++){
        var s= "collapse"+i;
        document.getElementById(s).className = "panel-collapse collapse";
     }
 }
 function acc2(){
     $('#accordion').css('display','none');
     $('#accordion2').css('display','block');
     for(var i=8; i<14;i++){
        var s= "collapse"+i;
        document.getElementById(s).className = "panel-collapse collapse";
     }
 }
</script>



<jsp:include page="/WEB-INF/views/common/footer.jsp" />