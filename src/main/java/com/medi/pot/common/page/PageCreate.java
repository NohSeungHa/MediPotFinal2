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
   
 //1:1 문의 페이징
   public String getPageBarInquiry(int cPage, int numPerPage, int totalCount, String url,String checkPH,String id)
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
      pageBar+="location.href='"+url+"?checkPH="+checkPH+"&id="+id+"&cPage='+cPage;";
      pageBar+="}";
      pageBar+="</script>";
         
      
      
      return pageBar;
      
      
   }

   
   public String getPageBarCommentM2(int cPageMem, int numPerPage, int totalCount, String url,int no)
   {
      String pageBar="";
      int pageSize=5;
      
      int totalPage=(int)Math.ceil((double)totalCount/numPerPage);
      int pageNo=((cPageMem-1)/pageSize)*pageSize+1;
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
         pageBar+="<a onclick='pagingM("+(pageNo-1)+")'>이전</a>";
         pageBar+="</li>";
      }
      while(!(pageNo>pageEnd||pageNo>totalPage))
      {
         if(cPageMem==pageNo)
         {
            pageBar+="<li class='active'>";
            pageBar+="<a>"+pageNo+"</a>";
            pageBar+="</li>";
         }
         else
         {
            pageBar += "<li>";
            pageBar += "<a id='M"+pageNo+"' onclick='pagingM("+pageNo+")'>"+pageNo+"</a>";
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
         pageBar += "<a onclick='pagingM("+pageNo+")'>다음</a> ";
         pageBar += "</li>";
      }
      pageBar+="</ul>";
      
      pageBar+="<script>";
      pageBar+="function pagingM(cPageMem){";
      pageBar+="location.href='"+url+"?no="+no+"&cPageMem='+cPageMem;";
      pageBar+="}";
      pageBar+="</script>";
         
      
      
      return pageBar;
      
      
   }
   
   public String getPageBarCommentH2(int cPageHos, int numPerPage, int totalCount, String url,int no)
   {
      String pageBar="";
      int pageSize=5;
      
      int totalPage=(int)Math.ceil((double)totalCount/numPerPage);
      int pageNo=((cPageHos-1)/pageSize)*pageSize+1;
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
         pageBar+="<a onclick='pagingH("+(pageNo-1)+")'>이전</a>";
         pageBar+="</li>";
      }
      while(!(pageNo>pageEnd||pageNo>totalPage))
      {
         if(cPageHos==pageNo)
         {
            pageBar+="<li class='active'>";
            pageBar+="<a>"+pageNo+"</a>";
            pageBar+="</li>";
         }
         else
         {
            pageBar += "<li>";
            pageBar += "<a id='H"+pageNo+"' onclick='pagingH("+pageNo+")'>"+pageNo+"</a>";
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
         pageBar += "<a onclick='pagingH("+pageNo+")'>다음</a> ";
         pageBar += "</li>";
      }
      pageBar+="</ul>";
      
      pageBar+="<script>";
      pageBar+="function pagingH(cPageHos){";
      pageBar+="location.href='"+url+"?no="+no+"&cPageHos='+cPageHos;";
      pageBar+="}";
      pageBar+="</script>";
         
      
      
      return pageBar;
      
      
   }
}