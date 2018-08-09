<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>



<c:set var="path" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="${path }/resources/js/bootstrap.js"></script>


<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width", initial-scale="1">
	<title>${param.pageTitle }</title>
	<link rel="stylesheet" href="${path }/resources/css/bootstrap.css"><!-- 외부 스타일 시트 -->
	<link rel="stylesheet" href="${path }/resources/css/medipotFinal.css">
	<link href="http://fonts.googleapis.com/css?family=Jua" rel="stylesheet">
	
	<!-- Main Javascript 시작-->          
    <script type="text/javascript" src="assets/plugins/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>     
    <script type="text/javascript" src="assets/plugins/stickyfill/dist/stickyfill.min.js"></script>                                                                
    <script type="text/javascript" src="assets/js/main.js"></script>
    <!-- Main Javascript 끝 -->
</head>
<body>
	<style type="text/css">/*내부 스타일 시트 적용*/
		*{
			font-family:Jua;
		}
	</style>


	<!-- 3강 네비게이션 바  -->
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" 
						data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<!-- 네비게이션 바 메디팟 로고  -->
				<a class="navbar-brand" href="${path }/"><img src="${path }/resources/img/common/MediPot_logo.png" width="250px" height="60px" style="margin-left:30%;margin-top: 4%;" ></a>
			</div>
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<!-- 검색창 만들기 -->
				<form class="navbar-form navbar-left" style="margin-top: 2%;margin-left:5%;">
					<input type="text" class="form-control" placeholder="병원이름 검색">
					<button type="submit" class="btn btn-default">검색</button>
				</form>
				<!-- 검색창만들기 끝 -->


				<!-- 로그인 전 -->
				<c:if test="${memberLoggedIn==null }">
				<ul class="nav navbar-nav navbar-right" style="margin-top:2.5%;margin-right:1%;">
					<li><a href="${pageContext.request.contextPath }/member/memberLogin.do" data-toggle="modal" data-target="#loginModal">로그인</a></li>
					<li><a href="${pageContext.request.contextPath }/member/join.do">회원가입</a></li>
				</ul>
				</c:if>
				<!-- 로그인 후 -->
				<c:if test="${memberLoggedIn!=null }">
					
				<ul class="nav navbar-nav navbar-right" style="margin-top:2.5%;margin-right:1%;">
				
					<c:if test="${checkPH=='P' }">
						<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${memberLoggedIn.memberName }&nbsp;님 환영합니다.<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="${pageContext.request.contextPath }/member/mypage.do?user_id=${memberLoggedIn.memberId}&checkPH=${checkPH}">마이페이지</a></li>
							<li><a href="${pageContext.request.contextPath }/member/MemberReservation.do?user_id=${memberLoggedIn.memberId}&checkPH=${checkPH }">진료예약확인</a></li>
						</ul>
						</li>
					</c:if>
					
					<c:if test="${checkPH=='H' }">
						<c:if test="${hospitalAdmission=='0' }">
							<li><a style="text-decoration:none">승인대기 중입니다.</a></li>
						</c:if>	
						<c:if test="${hospitalAdmission!='0' }">
							<c:if test="${H_Info_Count==2}">
								<c:if test="${infoEnter=='yes' }">
									<script>
										
										location.href="${path}/member/infoCount.do?hospitalNum="+${memberLoggedIn.hospitalNum};
										
									</script>
								</c:if>								
							</c:if>
							<c:if test="${H_Info_Count==1 }">
								<c:if test="${InfoCheck=='no' }">
									<script>
										alert("병원정보를 등록 후 이용해주시기 바랍니다.");
										alert("병원정보는 병원이름탭 - 병원정보입력에서 등록하시면 됩니다.");
										location.href="${path}/member/infoCount.do?hospitalNum="+${memberLoggedIn.hospitalNum};
									</script>
								</c:if>
								<c:if test="${H_Info_Count==1 }">
									<script>
										
										location.href="${path}/member/infoCount.do?hospitalNum="+${memberLoggedIn.hospitalNum};
									</script>
								</c:if>
							</c:if>
							
							<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${memberLoggedIn.hospitalName }&nbsp;님 환영합니다.<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="${pageContext.request.contextPath }/member/mypage.do?user_id=${memberLoggedIn.hospitalId}&checkPH=${checkPH}">마이페이지</a></li>
								<c:if test="${InfoCheck=='no' }">
									<li><a href="${pageContext.request.contextPath }/member/hospitalInfo.do?hospitalNum=${memberLoggedIn.hospitalNum}">병원정보입력</a></li>
								</c:if>
								<c:if test="${InfoCheck=='yes' or infoEnter=='yes' }">
									<li><a href="${pageContext.request.contextPath }/member/hospitalInfoUpdate.do?hospitalNum=${memberLoggedIn.hospitalNum}">병원정보수정</a></li>
								</c:if>
								<li><a href="${pageContext.request.contextPath }/member/doctorInfoInsert.do?hospitalNum=${memberLoggedIn.hospitalNum}">의사 추가</a></li>
								<c:if test="${InfoCheck=='yes' }">
									<li><a href="${pageContext.request.contextPath }/member/doctorInfoUpdate.do?hospitalNum=${memberLoggedIn.hospitalNum}">의사 수정</a></li>
								</c:if>
							</ul>
							</li>
						</c:if>
					</c:if>
					
					<li><a href="${pageContext.request.contextPath }/member/memberLogout.do">로그아웃</a></li>
				
				</ul>
				</c:if>



				<!-- 드롭다운 메뉴 -->
				<ul class="nav navbar-nav navbar-right" style="font-size:35px;margin-top:2.5%;margin-right:2%;">
					<li><a href="${path}/medi/medireser.do">병원예약</a></li>
					<!-- 드랍다운 메뉴 만들기 기본 셋팅-->
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
						고객지원<span class="caret"></span></a>
						<ul class="dropdown-menu">
						<c:if test="${checkPH=='P' }">
							<c:if test="${memberLoggedIn.memberId=='admin' }">
								<li><a href="${path}/notice/noticeList.do?checkPH=H&id=${memberLoggedIn.memberId}">병원 공지사항</a></li>
								<li><a href="${path}/notice/noticeList.do?checkPH=P&id=${memberLoggedIn.memberId}">일반 공지사항</a></li>
							</c:if>
							<c:if test="${memberLoggedIn.memberId!='admin' }">
								<li><a href="${path}/notice/noticeList.do?checkPH=${checkPH}">공지사항</a></li>
							</c:if>
						</c:if>
						<c:if test="${checkPH=='H' }">
							<li><a href="${path}/notice/noticeList.do?checkPH=${checkPH}">공지사항</a></li>
						</c:if>
						
						<li><a href="${path}/notice/noticeList.do?checkPH=P" id="bemember" style="display: block">공지사항</a></li>
						
							<li><a href="#">자주묻는 질문</a></li>
							<li><a href="${path}/community/communityList.do">자유게시판</a></li>
						</ul>
					</li>
						<li><a href="${path}/helpZone/helpZoneList.do">HELP ZONE</a></li>
				</ul>
				<script>
					$(function () {
						$('.dropdown-toggle').click(function () {
							$('.dropdown-toggle').css("background-color","#2C3E50");
							
						});
						
					});
					
					$(function(){
						if(${checkPH=='P'} || ${checkPH=='H'}){
							$('#bemember').css("display","none");														
						}
					});
				</script>	
			</div>
		</div>		
		
		
		<!-- 로그인 모달 시작 -->
		</div>
		<div class="modal fade" id="loginModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">로그인</h5>
						<button style="margin-top: -25px" type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							X
						</button>
					</div>
					<form
						action="${pageContext.request.contextPath}/member/memberLogin.do"
						method="post">
						<div class="modal-body">
							<input type="radio" class="radio-inline" name="PnH" value="P"
								style="font-size: 20" checked>개인 <input type="radio"
								class="radio-inline" name="PnH" value="H" style="font-size: 20">병원
							<br>
							<br> <input type="text" class="form-control" name="memberId"
								placeholder="아이디" required> <br> <input
								type="password" class="form-control" name="memberPw"
								placeholder="비밀번호" required>
						</div>
						<div class="modal-footer">
							<a href="${pageContext.request.contextPath}/member/findId.do" style="color: #000F75">아이디 찾기</a>
							<a href="${pageContext.request.contextPath}/member/findPassword.do" style="margin-right: 300px; color: #000F75">비밀번호 찾기</a>
							<button type="submit" class="btn btn-outline-success">로그인</button>
							<button type="button" class="btn btn-outline-success"
								data-dismiss="modal">취소</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- 로그인 모달 끝 -->






	</nav>