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
		String saveDir=request.getSession().getServletContext().getRealPath("/resources/uploadfile/notice");
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
			com.setCommunityContent(content);
				
		/*int result=service.insertNotice(com);*/
		
		ModelAndView mv=new ModelAndView();
		String msg="";
		/*if(result==1) {
			msg="등록!";
		}
		else {
			msg="실패!";
		}*/
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
		String savedDir=request.getSession().getServletContext().getRealPath("/resources/uploadfile/notice");
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
}
