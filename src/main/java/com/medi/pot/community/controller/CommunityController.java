package com.medi.pot.community.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.medi.pot.common.page.PageCreate;
import com.medi.pot.community.service.CommunityService;
import com.medi.pot.community.vo.Community;

@Controller
public class CommunityController {

	@Autowired
	private CommunityService service;
	
	//자유게시판 List 불러오기
	@RequestMapping("/community/communityList.do")
	public ModelAndView communityList(@RequestParam(value="cPage",required=false,defaultValue="1") int cPage) {
		ModelAndView mv=new ModelAndView();
		int numPerPage=10;
		
		List<Community> list = service.selectList(cPage,numPerPage);
		int totalCount=service.selectCount();
		String pageBar=new PageCreate().getPageBar(cPage, numPerPage,totalCount,"communityList.do");
		
		mv.addObject("list",list);
		mv.addObject("pageBar", pageBar);
		mv.addObject("cPage", cPage);
		mv.addObject("totalCount", totalCount);
		mv.setViewName("community/communityList");
		
		return mv;
	}
	
	//자유게시판 글쓰기
	@RequestMapping("/community/communityInsert.do")
	public String communityInsert() {
		return "community/communityInsert";
	}
	
	@RequestMapping("/community/communityInsertEnd.do")
	public ModelAndView noticeInsertEnd(String title, String writer, String content,@RequestParam(value="fileName",required=false) MultipartFile fileName, HttpServletRequest request,String checkPH) {
		System.out.println(title);
		System.out.println(writer);
		System.out.println(content);
		
		//파일 업로드
		//저장위치지정
		String saveDir=request.getSession().getServletContext().getRealPath("/resources/uploadfile/community");
		Community com=new Community();
		File dir=new File(saveDir);
		if(dir.exists()==false) System.out.println(dir.mkdirs());//폴더생성
		System.out.println(fileName);
		if(!fileName.isEmpty()) {
		String originalFileName=fileName.getOriginalFilename();
		//확장자 구하기
		String ext=originalFileName.substring(originalFileName.lastIndexOf(".")+1);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
		int rndNum=(int)(Math.random()*1000);
		String renamedFileName=sdf.format(new Date(System.currentTimeMillis()));
		renamedFileName+="_"+rndNum+"."+ext;
		try 
		{
			fileName.transferTo(new File(saveDir+File.separator+renamedFileName));
		}
		catch(IOException e)
		{e.printStackTrace();}
		
			//DB에 저장할 첨부파일에 대한 정보를 구성!
			com.setCommunityFile(originalFileName);
			com.setCommunityRefile(renamedFileName);
		}
	
			com.setCommunityTitle(title);
			com.setCommunityWriter(writer);
			com.setCommunityCheckPH(checkPH);
			com.setCommunityContent(content);
				
		int result=service.insertCommunity(com);
		
		ModelAndView mv=new ModelAndView();
		String msg="";
		if(result==1) {
			msg="게시글 등록을 완료하였습니다.";
		}
		else {
			msg="게시글 등록을 실패하였습니다.";
		}
		mv.addObject("msg",msg);
		mv.addObject("loc", "/community/communityList.do");
		mv.setViewName("common/msg");
		
		return mv;
	}
	@RequestMapping("/community/fileDownload.do")
	public void fileDownload(String oName, String rName, HttpServletRequest request, HttpServletResponse response)
	{
		//스트림 생성
		BufferedInputStream bis=null;
		ServletOutputStream sos=null;
		//저장경로
		String savedDir=request.getSession().getServletContext().getRealPath("/resources/uploadfile/community");
		File savedFile=new File(savedDir+"/"+rName);
		try {
			FileInputStream fis=new FileInputStream(savedFile);
			bis=new BufferedInputStream(fis);
			sos=response.getOutputStream();
			
			String resFilename="";
			//브라우저 분기
			boolean isMSIE=request.getHeader("user-agent").indexOf("MSIE")!=-1
					||request.getHeader("user-agent").indexOf("Trident")!=-1;
			if(isMSIE) {
				resFilename=URLEncoder.encode(oName, "UTF-8");
				resFilename=resFilename.replaceAll("\\", "%20");
			}
			else {
				resFilename=new String(oName.getBytes("UTF-8"),"ISO-8859-1");
			}
			response.setContentType("application/otect-stream;charset=UTF-8");
			response.setHeader("Content-Disposition", "attachment;filename=\""+resFilename+"\"");
			response.setContentLength((int)savedFile.length());
			//파일 읽어와서 전송하기
			int read=-1;
			while((read=bis.read())!=-1) {
				sos.write(read);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				sos.close();
				bis.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//자유게시판 view
	@RequestMapping("/community/communityView.do")
	public String communityView(int no,Model model,HttpServletResponse response, HttpServletRequest request,int cp,String searchKind,String searchContent) {
		//조회수 증가
		Cookie[] cookie=request.getCookies();
		String communityCookieVal="";
		boolean hasRead=false;

		if(cookie!=null) { 
			outter:  
				for(Cookie c : cookie) {
					String name=c.getName();
					String value=c.getValue(); 
							
					if("communityCookie".equals(name)) { 
						communityCookieVal=value;
						if(value.contains("|"+no+"|")) {
							hasRead=true;
							break outter;
						}
					}
				}
			}
			if(!hasRead) {
				service.updateCount(no);
			}
			
			
			Cookie c=new Cookie("communityCookie", communityCookieVal+"|"+no+"|");
			c.setMaxAge(-1); // 유효기간, 브라우저를 닫는 경우 삭제(-1)
			response.addCookie(c);
			
			Community com=service.selectOneCommunity(no);
			Community communityBefore=null;
			Community communityNext=null;
			
			if(searchContent!=null) {
				searchContent="%"+searchContent+"%";
				if(searchKind.equals("title")) {
					List communityNumber=service.searchTitleNumber(searchContent);
					for(int i=0; i<communityNumber.size();i++) {
						int num=(Integer) communityNumber.get(i);
						if(num==no) {
							if(i>=1) {
								communityBefore=service.selectOneCommunity((Integer)communityNumber.get(i-1));
							}
							if(i<communityNumber.size()-1) {
								communityNext=service.selectOneCommunity((Integer)communityNumber.get(i+1));
							}
						}
					}
				}else if(searchKind.equals("content")) {
					List communityNumber=service.searchContentNumber(searchContent);
					for(int i=0; i<communityNumber.size();i++) {
						int num=(Integer) communityNumber.get(i);
						if(num==no) {
							if(i>=1) {
								communityBefore=service.selectOneCommunity((Integer)communityNumber.get(i-1));
							}
							if(i<communityNumber.size()-1) {
								communityNext=service.selectOneCommunity((Integer)communityNumber.get(i+1));
							}
						}
					}
				}
				else {
					List communityNumber=service.searchWriterNumber(searchContent);
					for(int i=0; i<communityNumber.size();i++) {
						int num=(Integer) communityNumber.get(i);
						if(num==no) {
							if(i>=1) {
								communityBefore=service.selectOneCommunity((Integer)communityNumber.get(i-1));
							}
							if(i<communityNumber.size()-1) {
								communityNext=service.selectOneCommunity((Integer)communityNumber.get(i+1));
							}
						}
					}
				}
				searchContent=searchContent.replace("%", "");
			}else {
				List communityNumber=service.selectCommunityNumber();
				for(int i=0; i<communityNumber.size();i++) {
					int num=(Integer) communityNumber.get(i);
					if(num==no) {
						if(i>=1) {
							communityBefore=service.selectOneCommunity((Integer)communityNumber.get(i-1));
						}
						if(i<communityNumber.size()-1) {
							communityNext=service.selectOneCommunity((Integer)communityNumber.get(i+1));
						}
					}
				}
			}
			
			System.out.println("communityBefore : "+communityBefore);
			System.out.println("communityNext : "+communityNext);
			model.addAttribute("cp",cp);
			model.addAttribute("searchKind", searchKind);
			model.addAttribute("searchContent", searchContent);
			model.addAttribute("com",com);
			model.addAttribute("communityBefore",communityBefore);
			model.addAttribute("communityNext",communityNext);
			return "community/communityView";
	}
	
	//자유게시판 글 삭제
	@RequestMapping("/community/deleteCommunity.do")
	public ModelAndView deleteCommunity(int no,String refile,HttpServletRequest request) {
		int result=service.deleteCommunity(no);
		
		String savedDir=request.getSession().getServletContext().getRealPath("/resources/uploadfile/community");
		File file=new File(savedDir+"/"+refile);
		
		ModelAndView mv=new ModelAndView();
		String msg="";
		if(result==1) {
			msg="게시글삭제 완료!";
			file.delete();
		}
		else {
			msg="게시글삭제 실패!";
		}
		mv.addObject("msg",msg);
		mv.addObject("loc", "/community/communityList.do");
		mv.setViewName("common/msg");
		
		return mv;
	}
	
	
	@RequestMapping("/community/communityUpdate.do")
	public String communityUpdate(int cPage,int no,Model model) {
		Community com = service.selectOneCommunity(no);
		model.addAttribute("com", com);
		model.addAttribute("num",no);
		model.addAttribute("cPage",cPage);
		return "community/communityUpdate";
	}
	
	@RequestMapping("/community/communityUpdateEnd.do")
	public ModelAndView communityUpdateEnd(String title,String writer,String content,@RequestParam(value="newFileName",required=false) MultipartFile newFileName,String oldFileName,String oldReFileName,String checkPH,int cPage,int no,HttpServletRequest request){
		
		//파일 업로드
		//저장위치지정
		String saveDir=request.getSession().getServletContext().getRealPath("/resources/uploadfile/community");
		Community com=new Community();
		if(newFileName!=null) {
			File dir=new File(saveDir);
			File file=new File(saveDir+"/"+oldReFileName);
			System.out.println("전파일 삭제 시작");
			file.delete();
			System.out.println("전파일 삭제 완료");
			if(dir.exists()==false) System.out.println(dir.mkdirs());//폴더생성
			System.out.println(newFileName);
			if(!newFileName.isEmpty()) {
			String originalFileName=newFileName.getOriginalFilename();
			//확장자 구하기
			String ext=originalFileName.substring(originalFileName.lastIndexOf(".")+1);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
			int rndNum=(int)(Math.random()*1000);
			String renamedFileName=sdf.format(new Date(System.currentTimeMillis()));
			renamedFileName+="_"+rndNum+"."+ext;
			try 
			{
				newFileName.transferTo(new File(saveDir+File.separator+renamedFileName));
			}
			catch(IOException e)
			{e.printStackTrace();}
					
				//DB에 저장할 첨부파일에 대한 정보를 구성!
				com.setCommunityFile(originalFileName);
				com.setCommunityRefile(renamedFileName);
			}
		}else {
			com.setCommunityFile(oldFileName);
			com.setCommunityRefile(oldReFileName);
		}
		com.setCommunityNum(no);
		com.setCommunityTitle(title);
		com.setCommunityWriter(writer);
		com.setCommunityContent(content);
		int result=service.updateCommunity(com);
				
		ModelAndView mv=new ModelAndView();
		String msg="";
		if(result==1) {
			msg="수정 완료!";
		}
		else {
			msg="수정 실패!";
		}
		mv.addObject("msg",msg);
		mv.addObject("loc", "/community/communityView.do?no="+no+"&cp="+cPage+"");
		mv.setViewName("common/msg");
		
		return mv;
	}
}
