<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ taglib prefix='fn' uri="http://java.sun.com/jsp/jstl/functions"%>
	<c:set var="path" value="<%=request.getContextPath() %>"/>
     
<body>
	<div class="container">
		<form id="commentForm" name="commentForm" method="post">
			<br><br>
			<div>
				<div>
					<span style="font-size: 20px"><strong>**답글**</strong></span> <span id="cCnt"></span>
				</div>
				<div>
					<table class="table">
						<tr>
							<td>
								<textarea style="font-size:20px; resize: none; width:1120px; height: 150px" rows="3" cols="30" id="comment" name="comment" 
								placeholder="병원회원님! 회원님을 위해 소중한 답글을 남겨주세요!"></textarea>
								<br>
								<div>
									<a href="#" onClick="fn_comment('${result.code}')" class="btn btn-lg pull-right btn-info">등록</a>
								</div>
							</td>
						</tr>
					</table>
				</div>
			</div>
			<input type="hidden" id="b_code" name="b_code" value="${result.code }"/>
		</form>
	</div>
	<div class="container">
		<form id="commentListForm" name="commentListForm" method="post">
			<div id="commentList">
			</div>
		</form>
	</div>
	
	<script>
	<!-- 댓글 등록하기 -->
	function fn_comment(code) {
		$.ajax({
			type:'POST',
			url : "<c:url value='${path}/helpZone/helpZoneComment.do'/>",
			data:$("#commentForm").serialize(),
			success : function(data) {
				if(data=="success"){
					getCommentList();
					$("#comment").val("");
				}
			},
			error:function(request,status,error){
	            //alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	            //이건 모르겠다!!
	       }
		});
	}
	/* 
	초기 페이지 로딩시 댓글 불러오기 */
	$(function(){
		getCommentList();
	});
	
	/* 댓글 불러오기(Ajax) */
	function getCommentList() {
		$.ajax({
			type:'GET',
			url : "<c:url value='${path}/helpZone/helpZoneList.do'/>",
			dataType : "json",
			data:$("#commentForm").serialize(),
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			success : function(data){
				 var html = "";
		            var cCnt = data.length;
		            
		            if(data.length > 0){
		                
		                for(i=0; i<data.length; i++){
		                    html += "<div>";
		                    html += "<div><table class='table'><h6><strong>"+data[i].writer+"</strong></h6>";
		                    html += data[i].comment + "<tr><td></td></tr>";
		                    html += "</table></div>";
		                    html += "</div>";
		                }
		                
		            } else {
		                
		                html += "<div>";
		                html += "<div><table class='table'><h6><strong>등록된 댓글이 없습니다.</strong></h6>";
		                html += "</table></div>";
		                html += "</div>";
		                
		            }
		            
		            $("#cCnt").html(cCnt);
		            $("#commentList").html(html);
		            
		        },
		        error:function(request,status,error){
		            
		       }
		        
		    });
		}
		 
		</script>
	
	
	
</body>