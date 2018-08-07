package com.medi.pot.helpZone.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.medi.pot.helpZone.service.HelpZoneService;
import com.medi.pot.helpZone.vo.HelpZone;

@Controller
public class HelpZoneController {
	
	@Autowired
	private HelpZoneService service;
	
	//헬프존 메인화면 (질문리스트 출력)
	@RequestMapping("/helpZone/helpZoneList.do")
	public String helpZoneList() {		
		System.out.println("헬프존 메인으로 고고");
		return "helpZone/helpZoneMain";
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
	      System.out.println(helpZoneFile);
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
}
