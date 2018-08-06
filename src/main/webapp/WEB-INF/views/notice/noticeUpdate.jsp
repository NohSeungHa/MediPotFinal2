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
<br>
<div class="container">
	<img class="img-thumbnail"
		src="/pot/resources/img/notice/hnoticeupdate.jpg"
		style="width: 100%;"> <br>
	<br>
	<a id="noticeHv" href="${path}/notice/noticeList.do?checkPH=${chPH}" style="float: right;">공지사항</a>
	<p style="float: right;">
		<b style="margin-right:10px;">></b>
	</p>
	<a id="home" href="${path}" style="float:right;width:70px;"><img
		src="/pot/resources/img/notice/home.jpg"
		style="width: 30%; height: 30%;"> 홈으로</a>
	<form name="noticeUpdateFrm" action="${path}/notice/noticeUpdateEnd.do" method="post" onsubmit="return validate();"  enctype="multipart/form-data" >
		<table class="table table-bordered">
			<tbody>
				<c:if test="${chPH=='H'}">
					<tr>
						<th>제목:</th>
						<td><input type="text" placeholder="제목을 입력하세요.(100자 이내)" name="title" id="title"
							class="form-control" maxlength="40" value="${notice.hospitalNoticeTitle }" /></td>
					</tr>
					<tr>
						<th>작성자:</th>
						<td><input type="text" name="writer"  id="writer" class="form-control"
							value="관리자" style="background-color: white;" readonly /></td>
					</tr>
					<tr>
						<th>내용:</th>
						<td><textarea style="resize: none;" class="form-control" placeholder="내용을 입력하세요.(500자이내)"
								rows="5" id="comment" name="content" onKeyUp="checkLength(this);" onKeyDown="checkLength(this);">${notice.hospitalNoticeContent }</textarea></td>
					</tr>
					<tr>
						<th>첨부파일:</th>
						<td><input type="file" class="form-control-file border" name="newFileName" id="newFileName" accept=".jpg, .png, .bmp">
							<input type="hidden" name="oldFileName" id="oldFileName" value="${notice.hospitalNoticeFile }">
							<input type="hidden" name="oldReFileName" id="oldReFileName" value="${notice.hospitalNoticeRefile }">
						</td>
					</tr>
				</c:if>
				<c:if test="${chPH!='H'}">
					<tr>
						<th>제목:</th>
						<td><input type="text" placeholder="제목을 입력하세요.(100자 이내)" name="title" id="title"
							class="form-control" maxlength="40" value="${notice.memberNoticeTitle }" /></td>
					</tr>
					<tr>
						<th>작성자:</th>
						<td><input type="text" name="writer"  id="writer" class="form-control"
							value="관리자" style="background-color: white;" readonly /></td>
					</tr>
					<tr>
						<th>내용:</th>
						<td><textarea style="resize: none;" class="form-control" placeholder="내용을 입력하세요.(500자이내)"
								rows="5" id="comment" name="content" onKeyUp="checkLength(this);" onKeyDown="checkLength(this);">${notice.memberNoticeContent }</textarea></td>
					</tr>
					<tr>
						<th>첨부파일:</th>
						<td><input type="file" class="form-control-file border" name="newFileName" id="newFileName">
							<input type="hidden" name="oldFileName" id="oldFileName" value="${notice.memberNoticeFile }">
							<input type="hidden" name="oldReFileName" id="oldReFileName" value="${notice.memberNoticeRefile }">
						</td>
					</tr>
				</c:if>
			</tbody>
		</table>
		<input type="hidden" id="no" name="no" value="${num}">
		<input type="hidden" id="checkPH" name="checkPH" value="${chPH}">
		<input type="hidden" id="cPage" name="cPage" value="${cPage}">
		<button type="button" onclick="noticeList()" class="btn btn-danger" style="float: right; margin-left: 10px;">취소</button> 
		<input type="submit" value="수정" onclick="return validate();" class="btn btn-primary" style="float: right;"/>
		</form>
		<button type="button" class="btn btn-success" onclick="noticeList()">목록으로</button>
	</div>
<br>
<script>
	function noticeList(){
		location.href="${path}/notice/noticeList.do?checkPH=${chPH}";
	}
	function checkLength(comment) {
	    if (comment.value.length > 1000 ) {
	        comment.blur();
	        comment.value = comment.value.substring(0, 1000);
	        comment.focus();
	        return false;
	    }
	}
	function validate() {
		var content=$("[name=content]").val();
		var title=$("[name=title]").val();
		if(title.trim().length==0) {
			alert("제목을 입력하세요!");
			return false;
		}else if(content.trim().length==0) {
			alert("내용을 입력하세요!");
			return false;
		}
		return true;
	}
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />