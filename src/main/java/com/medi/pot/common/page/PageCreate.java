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
			pageBar+="<li class='previous active'>";
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
		
	
}
