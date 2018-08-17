package com.medi.pot.helpZone.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.medi.pot.common.page.PageCreate;
import com.medi.pot.helpZone.service.HelpZoneService;
import com.medi.pot.helpZone.vo.HelpZone;
import com.medi.pot.member.model.vo.Member;

@Controller
public class HelpZoneController {
	
	@Autowired
	private HelpZoneService service;
	
	//헬프존 메인화면 (질문리스트 출력)
	@RequestMapping("/helpZone/helpZoneList.do")
	public ModelAndView helpZoneList(@RequestParam(value="cPage", required=false,defaultValue="1") int cPage) {
		ModelAndView mv = new ModelAndView();
		int numPerPage=6;		
		List<HelpZone> list = service.selectHelpZoneList(cPage,numPerPage);
		System.out.println("list : "+list);
		
		int totalCount=service.selectCount();
		
		String pageBar=new PageCreate().getPageBar(cPage, numPerPage,totalCount,"helpZoneList.do");
		mv.addObject("pageBar",pageBar);
		mv.addObject("list",list);
		mv.addObject("cPage",cPage);
		mv.addObject("totalCount",totalCount);
		mv.setViewName("/helpZone/helpZoneMain");
		return mv;
	}
	
	
	//헬프존 글쓰기 버튼 클릭 메서드
	@RequestMapping("/helpZone/helpZoneInsert.do")
	public String helpZoneInsert() {
		return "helpZone/helpZoneInsert";
	}
	
	
	//헬프존 글쓰기 완료 메서드
	@RequestMapping("/helpZone/helpZoneInsertEnd.do")
	public ModelAndView helpZoneInsertEnd(String helpZoneTitle, int helpZoneQuestioner, String helpZoneKeyWord, String helpZoneContent,@RequestParam(value="helpZoneFile",required=false) MultipartFile helpZoneFile, HttpServletRequest request ){
		/*System.out.println("helpZoneTitle :" + helpZoneTitle);
		System.out.println("helpZoneQuestioner :" + helpZoneQuestioner);
		System.out.println("helpZoneKeyword :" + helpZoneKeyWord);
		System.out.println("helpZoneContent :" + helpZoneContent);*/
		//파일업로드
		//저장 위치 지정
		String saveDir=request.getSession().getServletContext().getRealPath("/resources/uploadfile/helpZone");
		HelpZone helpZone = new HelpZone();
	    File dir=new File(saveDir);
	      if(dir.exists()==false) System.out.println(dir.mkdirs());//폴더생성
	      if(!helpZoneFile.isEmpty()) {
	      String originalFileName=helpZoneFile.getOriginalFilename();
	      //확장자 구하기
	      String ext=originalFileName.substring(originalFileName.lastIndexOf(".")+1);
	      SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
	      int rndNum=(int)(Math.random()*1000);
	      String renamedFileName=sdf.format(new Date(System.currentTimeMillis()));
	      renamedFileName+="_"+rndNum+"."+ext;
	      try 
	      {
	    	  helpZoneFile.transferTo(new File(saveDir+File.separator+renamedFileName));
	      }
	      catch(IOException e)
	      {e.printStackTrace();}
	      
	         //DB에 저장할 첨부파일에 대한 정보를 구성!
	      helpZone.setHelpZoneFile(originalFileName);
	      helpZone.setHelpZoneReFile(renamedFileName);
	      }
	      
	      helpZone.setHelpZoneTitle(helpZoneTitle);
	      helpZone.setHelpZoneContent(helpZoneContent);
	      helpZone.setHelpZoneQuestioner(helpZoneQuestioner);
	      helpZone.setHelpZoneKeyWord(helpZoneKeyWord);
	      
	      int result = service.insertHelpZone(helpZone);
	      
	      ModelAndView mv = new ModelAndView();
	      String msg = "";
	      if(result==1) {
	          msg="게시글 등록을 완료하였습니다.";
	       }
	       else {
	          msg="게시글 등록을 실패하였습니다.";
	       }
	      mv.addObject("msg",msg);
	      mv.addObject("loc", "/helpZone/helpZoneList.do");
	      mv.setViewName("common/msg");
	      
	      return mv;
	}
	
	@RequestMapping("/helpZone/helpZoneView.do")
	public String helpZoneView(int helpZoneNum, HttpServletRequest req){
		HelpZone helpZone = service.selectHelpZone(helpZoneNum);//헬프존 불러오는 메서드
		Member m = service.selectMember(helpZone.getHelpZoneQuestioner());	//작성자 불러오는 메서드
		req.setAttribute("helpZone", helpZone);
		req.setAttribute("helpZoneQuestioner", m);
		return "helpZone/helpZoneView";
	}
	
	@RequestMapping("/helpZone/deleteHelpZone.do")
	public ModelAndView deleteHelpZone(int num, String refile, HttpServletRequest request) 
	{
		int result = 0;
		result = service.deleteHelpZone(num);
				
		String savedDir = request.getSession().getServletContext().getRealPath("/resources/uploadfile/helpZone");
		File file = new File(savedDir+"/"+refile);
		
		ModelAndView mv = new ModelAndView();
		String msg = "";
		if(result==1) {
			msg="삭제를 완료하였습니다.";
			file.delete();
		}
		else {
			msg="삭제 실패";
		}
		mv.addObject("msg",msg);
		mv.addObject("loc", "/helpZone/helpZoneList.do");
		mv.setViewName("common/msg");
		
		return mv;
	}
	
	@RequestMapping("/helpZone/updateHelpZone.do")
	public String updateHelpZone(int num, Model model){
		HelpZone helpZone = service.selectHelpZone(num);
		Member m = service.selectMember(helpZone.getHelpZoneQuestioner());	//작성자 불러오는 메서드
		
		model.addAttribute("helpZone", helpZone);
		model.addAttribute("num",num);
		model.addAttribute("helpZoneQuestioner", m);
		return "helpZone/helpZoneUpdate";
	}
	
	@RequestMapping("/helpZone/helpZoneUpdateEnd.do")
	public ModelAndView helpZoneUpdateEnd(String helpZoneTitle,
											int helpZoneQuestioner,
											String helpZoneKeyWord,
											String helpZoneContent, 
											@RequestParam(value="newFileName",required=false) MultipartFile newFileName,
											String oldFileName,String oldReFileName,
											int num,
											HttpServletRequest request) {
		//파일 업로드
		//저장 위치 지정
		String saveDir = request.getSession().getServletContext().getRealPath("/resources/uploadfile/helpZone");
		HelpZone helpZone = new HelpZone();
		if(newFileName !=null) 
		{
			File dir = new File(saveDir);
			File file = new File(saveDir+"/"+oldReFileName);
			System.out.println("전에 파일을 삭제합니다.");
			file.delete();
			System.out.println("전에 파일을 삭제 완료하였습니다.");
			if(dir.exists()==false) System.out.println(dir.mkdirs());//폴더생성
			System.out.println(newFileName);
			if(!newFileName.isEmpty()) {
				String originalFileName = newFileName.getOriginalFilename();
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
					helpZone.setHelpZoneFile(originalFileName);
					helpZone.setHelpZoneReFile(renamedFileName);
			}
		}
		
		helpZone.setHelpZoneNum(num);
		helpZone.setHelpZoneTitle(helpZoneTitle);
		helpZone.setHelpZoneQuestioner(helpZoneQuestioner);
		helpZone.setHelpZoneContent(helpZoneContent);
		helpZone.setHelpZoneKeyWord(helpZoneKeyWord);
		
		System.out.println("헬프존 업데이트에서 헬프존 확인 : "+helpZone);
		
		int result = service.updateHelpZone(helpZone);
		ModelAndView mv = new ModelAndView();
		String msg = "";
		if(result ==1) {
			msg = "수정 완료";
		}
		else {
			msg = "수정 실패";
		}
		mv.addObject("msg", msg);
		mv.addObject("loc", "helpZone/helpZoneView.do?helpZoneNum="+num);
		mv.setViewName("common/msg");
		
		return mv;
	} 
	
}
