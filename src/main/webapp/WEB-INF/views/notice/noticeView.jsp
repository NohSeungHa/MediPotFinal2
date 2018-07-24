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
        tbody tr th{
            background-color: #2c3e50;
            color:white;
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
        #noticeHv{
            float:right;
        }
        #noticeHv:hover{
            color: #18bc9c;
        }
    </style>
<div class="container">
  <br><br>
  <img class="img-thumbnail" src="/pot/resources/img/notice/hnoticeMain.jpg" style="width:100%; height:270px;">
	<br><br>
	<a id="noticeHv" href="${path}/notice/noticeList.do" style="float: right;">공지사항</a>
	<p style="float: right;">
		<b style="margin-right:10px;">></b>
	</p>
	<a id="home" href="${path}" style="float:right;width:70px;"><img
		src="/pot/resources/img/notice/home.jpg"
		style="width: 30%; height: 30%;"> 홈으로</a>
	<table class="table table-bordered">
		<tbody>
      <tr>
        <th><h4>작성일</h4></th>
        <td><h4>${notice.hospitalNoticeDate}</h4></td>
        <th><h4>조회수</h4></th>
        <td><h4>${notice.hospitalNoticeReadcount}</h4></td>
    </tr>
      <tr>
        <th><h4>작성자</h4></th>
        <td colspan="3"><h4>${notice.hospitalNoticeWriter}</h4></td>
      </tr>
      <tr>
        <th><h4>제목</h4></th>
        <td colspan="3"><h4>${notice.hospitalNoticeTitle}</h4></td>
      </tr>
      <tr>
        <td colspan="4" style="height: 300px; max-height: 700px;max-width:300px;max-height:700px;"><h4 style="word-break:break-all;">${notice.hospitalNoticeContent}</h4></td>
      </tr>
      <c:if test="${notice.hospitalNoticeFile!=null}">
      	<tr>
      		<th><h4>첨부파일</h4></th>
      		<td colspan="3"><h4>${notice.hospitalNoticeFile}</h4></td>
      	</tr>
      </c:if>
    </tbody>
  </table>
  <hr>
	<button type="button" class="btn btn-success" onclick="list()">목록으로</button>
	<input type="button" value="삭제" class="btn btn-danger" style="float: right;margin-left: 10px;"/>
  <br><br>
  <table class="table table-bordered table-sm" style="border: 2px solid lightgray;">
        <tbody>
        	<c:if test="${noticeBefore!=null}">
            <tr>
                <td style="width: 10%;text-align:center;"><h4> <b>∧</b> 이전</h4></td>
                <td><h4><a href='${path}/notice/noticeView.do?no=${noticeBefore.hospitalNoticeNum }'> ${noticeBefore.hospitalNoticeTitle }</a></h4></td>
            </tr>
            </c:if>
            <c:if test="${noticeNext!=null}">
            <tr>
                <td style="width: 10%;text-align:center;"><h4> <b>∨</b> 다음</h4></td>
                <td><h4><a href='${path}/notice/noticeView.do?no=${noticeNext.hospitalNoticeNum }'> ${noticeNext.hospitalNoticeTitle }</a></h4></td>
            </tr>
            </c:if>
        </tbody>
      </table>
</div>
<br>
<script>
	function list(){
		location.href="${path}/notice/noticeList.do";
	}
</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp" />