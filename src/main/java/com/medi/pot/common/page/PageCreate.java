package com.medi.pot.common.page;

public class PageCreate {
   
   public String getPageBar(int cPage, int numPerPage, int totalCount, String url)
   {
      String pageBar="";
      int pageSize=5;
      
      int totalPage=(int)Math.ceil((double)totalCount/numPerPage);
      int pageNo=((cPage-1)/pageSize)*pageSize+1;
      int pageEnd=pageNo+pageSize-1;
      
      pageBar+="<ul class='pagination' style='display:table;margin-left:auto;margin-right: auto;'>";
      
      //이전
      if(pageNo==1)
      {
         pageBar+="<li class='previous disabled'>";
         pageBar+="<a href='#' tabindex='-1'>이전</a>";
         pageBar+="</li>";
      }
      else 
      {
         pageBar+="<li class='previous'>";
         pageBar+="<a href='javascript:fn_paging("+(pageNo-1)+")'>이전</a>";
         pageBar+="</li>";
      }
      while(!(pageNo>pageEnd||pageNo>totalPage))
      {
         if(cPage==pageNo)
         {
            pageBar+="<li class='active'>";
            pageBar+="<a>"+pageNo+"</a>";
            pageBar+="</li>";
         }
         else
         {
            pageBar += "<li>";
            pageBar += "<a href='javascript:fn_paging("+pageNo+")'>"+pageNo+"</a>";
            pageBar += "</li>";
         }
         pageNo++;
      }
      //다음
      if(pageNo > totalPage){
         pageBar += "<li class='next disabled'>";
         pageBar += "<a href='#'>다음</a>";
         pageBar += "</li>";
         
      } else {
         pageBar += "<li class='next'>";
         pageBar += "<a href='javascript:fn_paging("+pageNo+")'>다음</a> ";
         pageBar += "</li>";
      }
      pageBar+="</ul>";
      
      pageBar+="<script>";
      pageBar+="function fn_paging(cPage, numPerPage){";
      pageBar+="location.href='"+url+"?cPage='+cPage;";
      pageBar+="}";
      pageBar+="</script>";
         
      
      
      return pageBar;
      
      
   }
   //공지사항 (병원,일반) 페이징 처리
   public String getPageBar(int cPage, int numPerPage, int totalCount,String checkPH, String url)
   {
      String pageBar="";
      int pageSize=5;
      
      int totalPage=(int)Math.ceil((double)totalCount/numPerPage);
      int pageNo=((cPage-1)/pageSize)*pageSize+1;
      int pageEnd=pageNo+pageSize-1;
      
      pageBar+="<ul class='pagination' style='display:table;margin-left:auto;margin-right: auto;'>";
      
      //이전
      if(pageNo==1)
      {
         pageBar+="<li class='previous disabled'>";
         pageBar+="<a href='#' tabindex='-1'>이전</a>";
         pageBar+="</li>";
      }
      else 
      {
         pageBar+="<li class='previous'>";
         pageBar+="<a href='javascript:fn_paging("+(pageNo-1)+")'>이전</a>";
         pageBar+="</li>";
      }
      while(!(pageNo>pageEnd||pageNo>totalPage))
      {
         if(cPage==pageNo)
         {
            pageBar+="<li class='active'>";
            pageBar+="<a>"+pageNo+"</a>";
            pageBar+="</li>";
         }
         else
         {
            pageBar += "<li>";
            pageBar += "<a href='javascript:fn_paging("+pageNo+")'>"+pageNo+"</a>";
            pageBar += "</li>";
         }
         pageNo++;
      }
      //다음
      if(pageNo > totalPage){
         pageBar += "<li class='next disabled'>";
         pageBar += "<a href='#'>다음</a>";
         pageBar += "</li>";
         
      } else {
         pageBar += "<li class='next'>";
         pageBar += "<a href='javascript:fn_paging("+pageNo+")'>다음</a> ";
         pageBar += "</li>";
      }
      pageBar+="</ul>";
      
      pageBar+="<script>";
      pageBar+="function fn_paging(cPage, numPerPage){";
      pageBar+="location.href='"+url+"?checkPH="+checkPH+"&cPage='+cPage;";
      pageBar+="}";
      pageBar+="</script>";
         
      
      
      return pageBar;
      
      
   }
   //공지사항 검색 페이징 처리
   public String getPageBar(int cPage, int numPerPage, int totalCount,String checkPH,String searchKind,String searchContent, String url)
   {
      String pageBar="";
      int pageSize=5;
      
      int totalPage=(int)Math.ceil((double)totalCount/numPerPage);
      int pageNo=((cPage-1)/pageSize)*pageSize+1;
      int pageEnd=pageNo+pageSize-1;
      
      pageBar+="<ul class='pagination' style='display:table;margin-left:auto;margin-right: auto;'>";
      
      //이전
      if(pageNo==1)
      {
         pageBar+="<li class='previous disabled'>";
         pageBar+="<a href='#' tabindex='-1'>이전</a>";
         pageBar+="</li>";
      }
      else 
      {
         pageBar+="<li class='previous'>";
         pageBar+="<a href='javascript:fn_paging("+(pageNo-1)+")'>이전</a>";
         pageBar+="</li>";
      }
      while(!(pageNo>pageEnd||pageNo>totalPage))
      {
         if(cPage==pageNo)
         {
            pageBar+="<li class='active'>";
            pageBar+="<a>"+pageNo+"</a>";
            pageBar+="</li>";
         }
         else
         {
            pageBar += "<li>";
            pageBar += "<a href='javascript:fn_paging("+pageNo+")'>"+pageNo+"</a>";
            pageBar += "</li>";
         }
         pageNo++;
      }
      //다음
      if(pageNo > totalPage){
         pageBar += "<li class='next disabled'>";
         pageBar += "<a href='#'>다음</a>";
         pageBar += "</li>";
         
      } else {
         pageBar += "<li class='next'>";
         pageBar += "<a href='javascript:fn_paging("+pageNo+")'>다음</a> ";
         pageBar += "</li>";
      }
      pageBar+="</ul>";
      
      pageBar+="<script>";
      pageBar+="function fn_paging(cPage, numPerPage){";
      pageBar+="location.href='"+url+"?checkPH="+checkPH+"&searchKind="+searchKind+"&searchContent="+searchContent+"&cPage='+cPage;";
      pageBar+="}";
      pageBar+="</script>";
      
      
      
      return pageBar;
      
      
   }
<<<<<<< HEAD
   
=======

>>>>>>> 983868703c227af70440b663527361809c13bb13
   public String getPageBar3(int cPage, int numPerPage, int totalCount, String url,int userNum)
   {
      String pageBar="";
      int pageSize=5;
      
      int totalPage=(int)Math.ceil((double)totalCount/numPerPage);
      int pageNo=((cPage-1)/pageSize)*pageSize+1;
      int pageEnd=pageNo+pageSize-1;
      
      pageBar+="<ul class='pagination' style='display:table;margin-left:auto;margin-right: auto;'>";
      
      //이전
      if(pageNo==1)
      {
         pageBar+="<li class='previous disabled'>";
         pageBar+="<a href='#' tabindex='-1'>이전</a>";
         pageBar+="</li>";
      }
      else 
      {

         pageBar+="<li class='previous active'>";

         pageBar+="<li class='previous'>";

         pageBar+="<a href='javascript:fn_paging("+(pageNo-1)+")'>이전</a>";
         pageBar+="</li>";
      }
      while(!(pageNo>pageEnd||pageNo>totalPage))
      {
         if(cPage==pageNo)
         {
            pageBar+="<li class='active'>";
            pageBar+="<a>"+pageNo+"</a>";
            pageBar+="</li>";
         }
         else
         {
            pageBar += "<li>";
            pageBar += "<a href='javascript:fn_paging("+pageNo+")'>"+pageNo+"</a>";
            pageBar += "</li>";
         }
         pageNo++;
      }
      //다음
      if(pageNo > totalPage){
         pageBar += "<li class='next disabled'>";
         pageBar += "<a href='#'>다음</a>";
         pageBar += "</li>";
         
      } else {
         pageBar += "<li class='next'>";
         pageBar += "<a href='javascript:fn_paging("+pageNo+")'>다음</a> ";
         pageBar += "</li>";
      }
      pageBar+="</ul>";
      
      pageBar+="<script>";
      pageBar+="function fn_paging(cPage, numPerPage){";
      pageBar+="location.href='"+url+"?cPage='+cPage+'&userNum="+userNum+"';";
      pageBar+="}";
      pageBar+="</script>";
         
      
      
      return pageBar;
      
      
   }
<<<<<<< HEAD
=======

>>>>>>> 983868703c227af70440b663527361809c13bb13
   
   //자유게시판 검색 페이징 처리
   public String getPageBar(int cPage, int numPerPage, int totalCount,String searchKind,String searchContent, String url)
   {
      String pageBar="";
      int pageSize=5;
      
      int totalPage=(int)Math.ceil((double)totalCount/numPerPage);
      int pageNo=((cPage-1)/pageSize)*pageSize+1;
      int pageEnd=pageNo+pageSize-1;
      
      pageBar+="<ul class='pagination' style='display:table;margin-left:auto;margin-right: auto;'>";
      
      //이전
      if(pageNo==1)
      {
         pageBar+="<li class='previous disabled'>";
         pageBar+="<a href='#' tabindex='-1'>이전</a>";
         pageBar+="</li>";
      }
      else 
      {
<<<<<<< HEAD
=======

         pageBar+="<li class='previous active'>";
>>>>>>> 983868703c227af70440b663527361809c13bb13
         pageBar+="<li class='previous'>";
         pageBar+="<a href='javascript:fn_paging("+(pageNo-1)+")'>이전</a>";
         pageBar+="</li>";
      }
      while(!(pageNo>pageEnd||pageNo>totalPage))
      {
         if(cPage==pageNo)
         {
            pageBar+="<li class='active'>";
            pageBar+="<a>"+pageNo+"</a>";
            pageBar+="</li>";
         }
         else
         {
            pageBar += "<li>";
            pageBar += "<a href='javascript:fn_paging("+pageNo+")'>"+pageNo+"</a>";
            pageBar += "</li>";
         }
         pageNo++;
      }
      //다음
      if(pageNo > totalPage){
         pageBar += "<li class='next disabled'>";
         pageBar += "<a href='#'>다음</a>";
         pageBar += "</li>";
         
      } else {
         pageBar += "<li class='next'>";
         pageBar += "<a href='javascript:fn_paging("+pageNo+")'>다음</a> ";
         pageBar += "</li>";
      }
      pageBar+="</ul>";
      
      pageBar+="<script>";
      pageBar+="function fn_paging(cPage, numPerPage){";
      pageBar+="location.href='"+url+"?searchKind="+searchKind+"&searchContent="+searchContent+"&cPage='+cPage;";
      pageBar+="}";
      pageBar+="</script>";
      
      
      
      return pageBar;
      
      
   }
   
   //자유게시판 댓글 페이징
   public String getPageBarComment(int cPage, int numPerPage, int totalCount, String url,int no,int cp)
   {
      String pageBar="";
      int pageSize=5;
      
      int totalPage=(int)Math.ceil((double)totalCount/numPerPage);
      int pageNo=((cPage-1)/pageSize)*pageSize+1;
      int pageEnd=pageNo+pageSize-1;
      
      pageBar+="<ul class='pagination' style='display:table;margin-left:auto;margin-right: auto;'>";
      
      //이전
      if(pageNo==1)
      {
         pageBar+="<li class='previous disabled'>";
         pageBar+="<a href='#' tabindex='-1'>이전</a>";
         pageBar+="</li>";
      }
      else 
      {
         pageBar+="<li class='previous'>";
         pageBar+="<a href='javascript:fn_paging("+(pageNo-1)+")'>이전</a>";
         pageBar+="</li>";
      }
      while(!(pageNo>pageEnd||pageNo>totalPage))
      {
         if(cPage==pageNo)
         {
            pageBar+="<li class='active'>";
            pageBar+="<a>"+pageNo+"</a>";
            pageBar+="</li>";
         }
         else
         {
            pageBar += "<li>";
            pageBar += "<a href='javascript:fn_paging("+pageNo+")'>"+pageNo+"</a>";
            pageBar += "</li>";
         }
         pageNo++;
      }
      //다음
      if(pageNo > totalPage){
         pageBar += "<li class='next disabled'>";
         pageBar += "<a href='#'>다음</a>";
         pageBar += "</li>";
         
      } else {
         pageBar += "<li class='next'>";
         pageBar += "<a href='javascript:fn_paging("+pageNo+")'>다음</a> ";
         pageBar += "</li>";
      }
      pageBar+="</ul>";
      
      pageBar+="<script>";
      pageBar+="function fn_paging(cPage, numPerPage){";
      pageBar+="location.href='"+url+"?no="+no+"&cp="+cp+"&cPage='+cPage;";
      pageBar+="}";
      pageBar+="</script>";
         
      
      
      return pageBar;
      
      
   }
   
<<<<<<< HEAD
 //1:1 문의 페이징
   public String getPageBarInquiry(int cPage, int numPerPage, int totalCount, String url,String checkPH,String id)
=======
   //헬프존 댓글 페이징
 //자유게시판 댓글 페이징
   public String getPageBarComment2(int cPage, int numPerPage, int totalCount, String url,int no)
>>>>>>> 983868703c227af70440b663527361809c13bb13
   {
      String pageBar="";
      int pageSize=5;
      
      int totalPage=(int)Math.ceil((double)totalCount/numPerPage);
      int pageNo=((cPage-1)/pageSize)*pageSize+1;
      int pageEnd=pageNo+pageSize-1;
      
      pageBar+="<ul class='pagination' style='display:table;margin-left:auto;margin-right: auto;'>";
      
      //이전
      if(pageNo==1)
      {
         pageBar+="<li class='previous disabled'>";
         pageBar+="<a href='#' tabindex='-1'>이전</a>";
         pageBar+="</li>";
      }
      else 
      {
         pageBar+="<li class='previous'>";
         pageBar+="<a href='javascript:fn_paging("+(pageNo-1)+")'>이전</a>";
         pageBar+="</li>";
      }
      while(!(pageNo>pageEnd||pageNo>totalPage))
      {
         if(cPage==pageNo)
         {
            pageBar+="<li class='active'>";
            pageBar+="<a>"+pageNo+"</a>";
            pageBar+="</li>";
         }
         else
         {
            pageBar += "<li>";
            pageBar += "<a href='javascript:fn_paging("+pageNo+")'>"+pageNo+"</a>";
            pageBar += "</li>";
         }
         pageNo++;
      }
      //다음
      if(pageNo > totalPage){
         pageBar += "<li class='next disabled'>";
         pageBar += "<a href='#'>다음</a>";
         pageBar += "</li>";
         
      } else {
         pageBar += "<li class='next'>";
         pageBar += "<a href='javascript:fn_paging("+pageNo+")'>다음</a> ";
         pageBar += "</li>";
      }
      pageBar+="</ul>";
      
      pageBar+="<script>";
      pageBar+="function fn_paging(cPage, numPerPage){";
<<<<<<< HEAD
      pageBar+="location.href='"+url+"?checkPH="+checkPH+"&id="+id+"&cPage='+cPage;";
=======
      pageBar+="location.href='"+url+"?no="+no+"&cPage='+cPage;";
      pageBar+="}";
      pageBar+="</script>";
         
      
      
      return pageBar;
      
      
   }
   
   public String getPageBarCommentM2(int cPageM, int numPerPage, int totalCount, String url,int no)
   {
      String pageBar="";
      int pageSize=5;
      
      int totalPage=(int)Math.ceil((double)totalCount/numPerPage);
      int pageNo=((cPageM-1)/pageSize)*pageSize+1;
      int pageEnd=pageNo+pageSize-1;
      
      pageBar+="<ul class='pagination' style='display:table;margin-left:auto;margin-right: auto;'>";
      
      //이전
      if(pageNo==1)
      {
         pageBar+="<li class='previous disabled'>";
         pageBar+="<a href='#' tabindex='-1'>이전</a>";
         pageBar+="</li>";
      }
      else 
      {
         pageBar+="<li class='previous'>";
         pageBar+="<a href='javascript:fn_paging("+(pageNo-1)+")'>이전</a>";
         pageBar+="</li>";
      }
      while(!(pageNo>pageEnd||pageNo>totalPage))
      {
         if(cPageM==pageNo)
         {
            pageBar+="<li class='active'>";
            pageBar+="<a>"+pageNo+"</a>";
            pageBar+="</li>";
         }
         else
         {
            pageBar += "<li>";
            pageBar += "<a href='javascript:fn_paging("+pageNo+")'>"+pageNo+"</a>";
            pageBar += "</li>";
         }
         pageNo++;
      }
      //다음
      if(pageNo > totalPage){
         pageBar += "<li class='next disabled'>";
         pageBar += "<a href='#'>다음</a>";
         pageBar += "</li>";
         
      } else {
         pageBar += "<li class='next'>";
         pageBar += "<a href='javascript:fn_paging("+pageNo+")'>다음</a> ";
         pageBar += "</li>";
      }
      pageBar+="</ul>";
      
      pageBar+="<script>";
      pageBar+="function fn_paging(cPageM, numPerPage){";
      pageBar+="location.href='"+url+"?no="+no+"&cPageM='+cPageM;";
      pageBar+="}";
      pageBar+="</script>";
         
      
      
      return pageBar;
      
      
   }
   
   public String getPageBarCommentH2(int cPageH, int numPerPage, int totalCount, String url,int no)
   {
      String pageBar="";
      int pageSize=5;
      
      int totalPage=(int)Math.ceil((double)totalCount/numPerPage);
      int pageNo=((cPageH-1)/pageSize)*pageSize+1;
      int pageEnd=pageNo+pageSize-1;
      
      pageBar+="<ul class='pagination' style='display:table;margin-left:auto;margin-right: auto;'>";
      
      //이전
      if(pageNo==1)
      {
         pageBar+="<li class='previous disabled'>";
         pageBar+="<a href='#' tabindex='-1'>이전</a>";
         pageBar+="</li>";
      }
      else 
      {
         pageBar+="<li class='previous'>";
         pageBar+="<a href='javascript:fn_paging("+(pageNo-1)+")'>이전</a>";
         pageBar+="</li>";
      }
      while(!(pageNo>pageEnd||pageNo>totalPage))
      {
         if(cPageH==pageNo)
         {
            pageBar+="<li class='active'>";
            pageBar+="<a>"+pageNo+"</a>";
            pageBar+="</li>";
         }
         else
         {
            pageBar += "<li>";
            pageBar += "<a href='javascript:fn_paging("+pageNo+")'>"+pageNo+"</a>";
            pageBar += "</li>";
         }
         pageNo++;
      }
      //다음
      if(pageNo > totalPage){
         pageBar += "<li class='next disabled'>";
         pageBar += "<a href='#'>다음</a>";
         pageBar += "</li>";
         
      } else {
         pageBar += "<li class='next'>";
         pageBar += "<a href='javascript:fn_paging("+pageNo+")'>다음</a> ";
         pageBar += "</li>";
      }
      pageBar+="</ul>";
      
      pageBar+="<script>";
      pageBar+="function fn_paging(cPageH, numPerPage){";
      pageBar+="location.href='"+url+"?no="+no+"&cPageH='+cPageH;";
>>>>>>> 983868703c227af70440b663527361809c13bb13
      pageBar+="}";
      pageBar+="</script>";
         
      
      
      return pageBar;
      
      
   }
<<<<<<< HEAD
=======
   
>>>>>>> 983868703c227af70440b663527361809c13bb13
}