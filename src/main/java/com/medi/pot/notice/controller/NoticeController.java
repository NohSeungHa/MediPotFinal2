package com.medi.pot.notice.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	//공지사항 페이징처리 메서드
	@RequestMapping("/notice/noticeList.do")
	public ModelAndView noticeList(@RequestParam(value="cPage",required=false,defaultValue="1") int cPage) {
		ModelAndView mv=new ModelAndView();
		int numPerPage=10;
		List<HospitalNotice> list = service.selectList(cPage,numPerPage);
		int totalCount=service.selectCount();
		String pageBar=new PageCreate().getPageBar(cPage, numPerPage,totalCount,"noticeList.do");
		
		mv.addObject("pageBar", pageBar);
		mv.addObject("list",list);
		mv.addObject("cPage", cPage);
		mv.addObject("totalCount", totalCount);
		mv.setViewName("notice/hospital_notice");
		
		return mv;
	}
	
	@RequestMapping("/notice/noticeView.do")
	public String noticeView(int no,Model model,HttpServletResponse response, HttpServletRequest request) {
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
			service.updateCount(no);
			
			Cookie c=new Cookie("noticeCookie", noticeCookieVal+"|"+no+"|");
			c.setMaxAge(-1); // 유효기간, 브라우저를 닫는 경우 삭제(-1)
			response.addCookie(c);
		}
		HospitalNotice notice=service.selectOneNotice(no);
		System.out.println("여기까지 들어온다!");
		HospitalNotice noticeBefore=null;
		HospitalNotice noticeNext=null;
		List noticeNumber=service.selectNoticeNumber();

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
		
		System.out.println(notice);
		model.addAttribute("notice",notice);
		model.addAttribute("noticeBefore",noticeBefore);
		model.addAttribute("noticeNext",noticeNext);
		return "notice/noticeView";
	}
	
	@RequestMapping("/notice/noticeInsert.do")
	public String noticeinsert() {
		return "notice/noticeinsert";
	}
	
	@RequestMapping("notice/noticeInsertEnd.do")
	public ModelAndView noticeInsertEnd(String title, String writer, String content,@RequestParam(value="fileName",required=false) MultipartFile fileName, HttpServletRequest request) {
		System.out.println(title);
		System.out.println(writer);
		System.out.println(content);
		
		//파일 업로드
		//저장위치지정
		String saveDir=request.getSession().getServletContext().getRealPath("/resources/uploadfile/notice");
		HospitalNotice notice=new HospitalNotice();
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
			notice.setHospitalNoticeFile(originalFileName);
			notice.setHospitalNoticeRefile(renamedFileName);
		}
		if(writer.equals("관리자")) {
			notice.setHospitalNoticeTitle(title);
			notice.setHospitalNoticeWriter(writer);
			notice.setHospitalNoticeContent(content);
			
		}
		int result=service.insertNotice(notice);
		
		ModelAndView mv=new ModelAndView();
		String msg="";
		if(result==1) {
			msg="등록!";
		}
		else {
			msg="실패!";
		}
		mv.addObject("msg",msg);
		mv.addObject("loc", "/notice/noticeList.do");
		mv.setViewName("common/msg");
		
		return mv;
	}
}
