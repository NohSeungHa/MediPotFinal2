package com.medi.pot.notice.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.medi.pot.common.page.PageCreate;
import com.medi.pot.notice.service.NoticeService;
import com.medi.pot.notice.vo.HospitalNotice;
import com.medi.pot.notice.vo.MemberNotice;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	
	@RequestMapping("/notice/noticeList.do")
	public ModelAndView noticeList(@RequestParam(value="cPage",required=false,defaultValue="1") int cPage,String checkPH,String id) {
		ModelAndView mv=new ModelAndView();
		int numPerPage=10;
		int totalCount=0;
		String pageBar=null;
		if(id=="admin") {
			if(checkPH.equals("H")) {
				checkPH="H";
			}
			if(checkPH.equals("P")) {
				checkPH="P";
			}
		}
		System.out.println(checkPH);
		if(checkPH.equals("H")) {
			List<HospitalNotice> list = service.selectList(cPage,numPerPage);
			totalCount=service.selectCount();
			pageBar=new PageCreate().getPageBar(cPage, numPerPage,totalCount,checkPH,"noticeList.do");
			checkPH="H";
			mv.addObject("list",list);
		}else {
			List<MemberNotice> list = service.selectMemberList(cPage,numPerPage);
			totalCount=service.selectMemberCount();
			pageBar=new PageCreate().getPageBar(cPage, numPerPage,totalCount,checkPH,"noticeList.do");
			checkPH="P";
			mv.addObject("list",list);
		}
		
		mv.addObject("ckPH",checkPH);
		mv.addObject("pageBar", pageBar);
		mv.addObject("cPage", cPage);
		mv.addObject("totalCount", totalCount);
		mv.setViewName("notice/noticeList");
		
		return mv;
	}
	
	@RequestMapping("/notice/noticeView.do")
	public String noticeView(int no,Model model,HttpServletResponse response, HttpServletRequest request,String checkPH,int cp,String searchKind,String searchContent) {
		//조회수 증가
		Cookie[] cookie=request.getCookies();
		String noticeCookieVal="";
		boolean hasRead=false;
		//사이트 방문시에는 아무런 쿠키를 갖고있지 않느면 cookie값은 null이 나옴
		if(cookie!=null) {  //쿠키값이 있으면 실행
			outter:  
				for(Cookie c : cookie) {  //쿠키는 여러개가 올수 있기에 for문에서 실행(전체불러옴)
					String name=c.getName();  //쿠키의 키
					String value=c.getValue();  //쿠키의 값
							
					if("noticeCookie".equals(name)) {  //boardCookie를 찾는다.
						noticeCookieVal=value; //boardCookieVal에 value값을 넣어준다.
						if(value.contains("|"+no+"|")) {  //|글번호| |글번호| ,|23| |24|
							hasRead=true;
							break outter;
						}
					}
				}
		}
		if(!hasRead) {
				if(checkPH.equals("H")) {
					service.updateCount(no);
				}else {
					service.updateMemberCount(no);
				}
			
			
			Cookie c=new Cookie("noticeCookie", noticeCookieVal+"|"+no+"|");
			c.setMaxAge(-1); // 유효기간, 브라우저를 닫는 경우 삭제(-1)
			response.addCookie(c);
		}
		if(checkPH.equals("H")) {
			HospitalNotice notice=service.selectOneNotice(no);
			System.out.println("병원회원");
			HospitalNotice noticeBefore=null;
			HospitalNotice noticeNext=null;
			
			if(searchContent!=null) {
				searchContent="%"+searchContent+"%";
				if(searchKind.equals("title")) {
					List noticeNumber=service.searchTitleNumber(searchContent);
					System.out.println("noticeNumber : "+noticeNumber);
					for(int i=0; i<noticeNumber.size();i++) {
						int num=(Integer) noticeNumber.get(i);
						if(num==no) {
							if(i>=1) {
								noticeBefore=service.selectOneNotice((Integer)noticeNumber.get(i-1));
							}
							if(i<noticeNumber.size()-1) {
								noticeNext=service.selectOneNotice((Integer)noticeNumber.get(i+1));
							}
						}
					}
				}else {
					List noticeNumber=service.searchContentNumber(searchContent);
					for(int i=0; i<noticeNumber.size();i++) {
						int num=(Integer) noticeNumber.get(i);
						if(num==no) {
							if(i>=1) {
								noticeBefore=service.selectOneNotice((Integer)noticeNumber.get(i-1));
							}
							if(i<noticeNumber.size()-1) {
								noticeNext=service.selectOneNotice((Integer)noticeNumber.get(i+1));
							}
						}
					}
				}
				searchContent=searchContent.replace("%", "");
			}else {
				List noticeNumber=service.selectNoticeNumber();
				for(int i=0; i<noticeNumber.size();i++) {
					int num=(Integer) noticeNumber.get(i);
					if(num==no) {
						if(i>=1) {
							noticeBefore=service.selectOneNotice((Integer)noticeNumber.get(i-1));
						}
						if(i<noticeNumber.size()-1) {
							noticeNext=service.selectOneNotice((Integer)noticeNumber.get(i+1));
						}
					}
				}
			}
			System.out.println("noticeBefore : "+noticeBefore);
			System.out.println("noticeNext : "+noticeNext);
			model.addAttribute("ckPH",checkPH);
			model.addAttribute("cp",cp);
			model.addAttribute("searchKind", searchKind);
			model.addAttribute("searchContent", searchContent);
			model.addAttribute("notice",notice);
			model.addAttribute("noticeBefore",noticeBefore);
			model.addAttribute("noticeNext",noticeNext);
		}else {
			MemberNotice notice=service.selectOneMemberNotice(no);
			System.out.println("일반회원");
			MemberNotice noticeBefore=null;
			MemberNotice noticeNext=null;
			if(searchContent!=null) {
				searchContent="%"+searchContent+"%";
				if(searchKind.equals("title")) {
					List noticeNumber=service.searchMtitleNumber(searchContent);
					for(int i=0; i<noticeNumber.size();i++) {
						int num=(Integer) noticeNumber.get(i);
						if(num==no) {
							if(i>=1) {
								noticeBefore=service.selectOneMemberNotice((Integer)noticeNumber.get(i-1));
							}
							if(i<noticeNumber.size()-1) {
								noticeNext=service.selectOneMemberNotice((Integer)noticeNumber.get(i+1));
							}
						}
					}
				}else {
					List noticeNumber=service.searchMcontentNumber(searchContent);
					for(int i=0; i<noticeNumber.size();i++) {
						int num=(Integer) noticeNumber.get(i);
						if(num==no) {
							if(i>=1) {
								noticeBefore=service.selectOneMemberNotice((Integer)noticeNumber.get(i-1));
							}
							if(i<noticeNumber.size()-1) {
								noticeNext=service.selectOneMemberNotice((Integer)noticeNumber.get(i+1));
							}
						}
					}
				}
				searchContent=searchContent.replace("%", "");
				}else {
				List noticeNumber=service.selectMemberNoticeNumber();
				for(int i=0; i<noticeNumber.size();i++) {
					int num=(Integer) noticeNumber.get(i);
					if(num==no) {
						if(i>=1) {
							noticeBefore=service.selectOneMemberNotice((Integer)noticeNumber.get(i-1));
						}
						if(i<noticeNumber.size()-1) {
							noticeNext=service.selectOneMemberNotice((Integer)noticeNumber.get(i+1));
						}
						
					}
				}
			}
			
			System.out.println(notice);
			model.addAttribute("ckPH",checkPH);
			model.addAttribute("cp",cp);
			model.addAttribute("searchKind", searchKind);
			model.addAttribute("searchContent", searchContent);
			model.addAttribute("notice",notice);
			model.addAttribute("noticeBefore",noticeBefore);
			model.addAttribute("noticeNext",noticeNext);
		}
		return "notice/noticeView";
	}
	
	@RequestMapping("/notice/noticeInsert.do")
	public String noticeInsert(String checkPH, Model model) {
		model.addAttribute("chPH",checkPH);
		return "notice/noticeInsert";
	}
	
	@RequestMapping("notice/noticeInsertEnd.do")
	public ModelAndView noticeInsertEnd(String title, String writer, String content,@RequestParam(value="fileName",required=false) MultipartFile fileName, HttpServletRequest request,String checkPH) {
		System.out.println(title);
		System.out.println(writer);
		System.out.println(content);
		
		//파일 업로드
		//저장위치지정
		String saveDir=request.getSession().getServletContext().getRealPath("/resources/uploadfile/notice");
		HospitalNotice notice=new HospitalNotice();
		MemberNotice mNotice=new MemberNotice();
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
			if(checkPH.equals("H")) {
				notice.setHospitalNoticeFile(originalFileName);
				notice.setHospitalNoticeRefile(renamedFileName);
			}else {
				mNotice.setMemberNoticeFile(originalFileName);
				mNotice.setMemberNoticeRefile(renamedFileName);
			}
		}
		if(checkPH.equals("H")) {
			notice.setHospitalNoticeTitle(title);
			notice.setHospitalNoticeWriter(writer);
			notice.setHospitalNoticeContent(content);
		}else {
			System.out.println("여기 들어온다?2");
			mNotice.setMemberNoticeTitle(title);
			mNotice.setMemberNoticeWriter(writer);
			mNotice.setMemberNoticeContent(content);
		}
		System.out.println("mNotice : "+mNotice);
		int result=0;
		if(checkPH.equals("H")) {
			result=service.insertNotice(notice);
		}else {
			System.out.println("여기 들어온다?3");
			result=service.insertMemberNotice(mNotice);
		}
		
		
		ModelAndView mv=new ModelAndView();
		String msg="";
		if(result==1) {
			msg="등록!";
		}
		else {
			msg="실패!";
		}
		mv.addObject("msg",msg);
		mv.addObject("loc", "/notice/noticeList.do?checkPH="+checkPH+"");
		mv.setViewName("common/msg");
		
		return mv;
	}
	@RequestMapping("/notice/fileDownload.do")
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
	
	@RequestMapping("/notice/deleteNotice.do")
	public ModelAndView deleteNotice(String checkPH,int no,String refile,HttpServletRequest request) {
		int result=0;
		if(checkPH.equals("H")) {
			result=service.deleteHospitalNotice(no);
		}else {
			result=service.deleteMemberNotice(no);
		}
		String savedDir=request.getSession().getServletContext().getRealPath("/resources/uploadfile/notice");
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
		mv.addObject("loc", "/notice/noticeList.do?checkPH="+checkPH+"");
		mv.setViewName("common/msg");
		
		return mv;
	}
	
	@RequestMapping("/notice/noticeSearch.do")
	public ModelAndView noticeSearch(@RequestParam(value="cPage",required=false,defaultValue="1") int cPage,String searchKind,String searchContent,String checkPH) {
		ModelAndView mv=new ModelAndView();
		int numPerPage=10;
		int totalCount=0;
		String pageBar=null;
		
		searchContent ="%"+searchContent+"%";
		if(checkPH.equals("H")) {
			List<HospitalNotice> list = new ArrayList();
			if(searchKind.equals("title")) {
				list=service.selectTitleSearch(cPage,numPerPage,searchContent);
				totalCount=service.selectTitleSearchCount(searchContent);
			}else {
				list=service.selectContentSearch(cPage,numPerPage,searchContent);
				totalCount=service.selectContentSearchCount(searchContent);
			}
			searchContent=searchContent.replace("%", "");
			pageBar=new PageCreate().getPageBar(cPage, numPerPage,totalCount,checkPH,searchKind,searchContent,"noticeSearch.do");
			mv.addObject("list",list);
		}else {
			List<MemberNotice> list = new ArrayList();
			if(searchKind.equals("title")) {
				list=service.selectMtitleSearch(cPage,numPerPage,searchContent);
				totalCount=service.selectMtitleSearchCount(searchContent);
			}else {
				list=service.selectMcontentSearch(cPage,numPerPage,searchContent);
				totalCount=service.selectMcontentSearchCount(searchContent);
			}
			searchContent=searchContent.replace("%", "");
			pageBar=new PageCreate().getPageBar(cPage, numPerPage,totalCount,checkPH,searchKind,searchContent,"noticeSearch.do");
			mv.addObject("list",list);
		}
		
		String sContent=searchContent;
		
		mv.addObject("ckPH",checkPH);
		mv.addObject("pageBar", pageBar);
		mv.addObject("cPage", cPage);
		mv.addObject("totalCount", totalCount);
		mv.addObject("searchKind",searchKind);
		mv.addObject("searchContent",sContent);
		mv.setViewName("notice/noticeSearch");
		
		return mv;
	}
	
	@RequestMapping("/notice/noticeUpdate.do")
	public String noticeUpdate(String checkPH,int cPage,int no,Model model) {
		if(checkPH.equals("H")) {
			HospitalNotice notice = service.selectOneNotice(no);
			model.addAttribute("notice", notice);			
		}else {
			MemberNotice notice = service.selectOneMemberNotice(no);
			model.addAttribute("notice", notice);
		}
		model.addAttribute("num",no);
		model.addAttribute("chPH",checkPH);
		model.addAttribute("cPage",cPage);
		return "notice/noticeUpdate";
	}
	
	@RequestMapping("/notice/noticeUpdateEnd.do")
	public ModelAndView noticeUpdateEnd(String title,String writer,String content,@RequestParam(value="newFileName",required=false) MultipartFile newFileName,String oldFileName,String oldReFileName,String checkPH,int cPage,int no,HttpServletRequest request){
		
		//파일 업로드
		//저장위치지정
		String saveDir=request.getSession().getServletContext().getRealPath("/resources/uploadfile/notice");
		HospitalNotice notice=new HospitalNotice();
		MemberNotice mNotice=new MemberNotice();
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
				if(checkPH.equals("H")) {
					notice.setHospitalNoticeFile(originalFileName);
					notice.setHospitalNoticeRefile(renamedFileName);
				}else {
					mNotice.setMemberNoticeFile(originalFileName);
					mNotice.setMemberNoticeRefile(renamedFileName);
				}
			}
		}else {
			if(checkPH.equals("H")) {
				notice.setHospitalNoticeFile(oldFileName);
				notice.setHospitalNoticeRefile(oldReFileName);
			}else {
				mNotice.setMemberNoticeFile(oldFileName);
				mNotice.setMemberNoticeRefile(oldReFileName);
			}
		}
		if(checkPH.equals("H")) {
			notice.setHospitalNoticeNum(no);
			notice.setHospitalNoticeTitle(title);
			notice.setHospitalNoticeWriter(writer);
			notice.setHospitalNoticeContent(content);
		}else {
			System.out.println("여기 들어온다?2");
			mNotice.setMemberNoticeNum(no);
			mNotice.setMemberNoticeTitle(title);
			mNotice.setMemberNoticeWriter(writer);
			mNotice.setMemberNoticeContent(content);
		}
		System.out.println("mNotice : "+mNotice);
		int result=0;
		if(checkPH.equals("H")) {
			result=service.updateNotice(notice);
		}else {
			System.out.println("여기 들어온다?3");
			result=service.updateMemberNotice(mNotice);
		}
				
				
		ModelAndView mv=new ModelAndView();
		String msg="";
		if(result==1) {
			msg="수정 완료!";
		}
		else {
			msg="수정 실패!";
		}
		mv.addObject("msg",msg);
		mv.addObject("loc", "/notice/noticeView.do?no="+no+"&checkPH="+checkPH+"&cp="+cPage+"");
		mv.setViewName("common/msg");
		
		return mv;
	}
	
}
