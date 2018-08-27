package com.medi.pot.helpZone.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.medi.pot.common.page.PageCreate;
import com.medi.pot.helpZone.service.HelpZoneService;
import com.medi.pot.helpZone.vo.HelpZone;
import com.medi.pot.helpZone.vo.HelpZoneCommentHospital;
import com.medi.pot.helpZone.vo.HelpZoneCommentMember;
import com.medi.pot.member.model.vo.Hospital;
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
	//헬프존 보기
	@RequestMapping("/helpZone/helpZoneView.do")
	public String helpZoneView(HttpServletRequest req,
			@RequestParam(value="no",required=false) int no, 
			@RequestParam(value="cPageMem",required=false,defaultValue="0") int cPageMem,
			@RequestParam(value="cPageHos",required=false,defaultValue="0") int cPageHos){
		HelpZone helpZone = service.selectHelpZone(no);//헬프존 불러오는 메서드
		Member m = service.selectMember(helpZone.getHelpZoneQuestioner());	//작성자 불러오는 메서드
		
		if(cPageMem==0) {
	        req.setAttribute("flagM","0");
	        cPageMem=1;         
        }
        else {
           req.setAttribute("flagM","1");
        }
		
		if(cPageHos==0) {
	        req.setAttribute("flagH","0");
	        cPageHos=1;         
        }
        else {
           req.setAttribute("flagH","1");
        }
		
		//댓글 불러오는 메소드
		int numPerPage=10;
		int totalCountM = service.helpZoneCommentCountM(no);
		int totalCountH = service.helpZoneCommentCountH(no);
		
		List<HelpZoneCommentMember> hzMember2 = service.selectMemberCommentList(cPageMem, numPerPage, no);
		List<HelpZoneCommentHospital> hzHospital2 = service.selectHospitalCommentList(cPageHos, numPerPage, no);
		
		String pageBarM = new PageCreate().getPageBarCommentM2(cPageMem, numPerPage, totalCountM, "helpZoneView.do", no);
		String pageBarH = new PageCreate().getPageBarCommentH2(cPageHos, numPerPage, totalCountH, "helpZoneView.do", no);
		boolean checkchoice = false;
		HelpZoneCommentHospital helpZoneCommentHospital = new HelpZoneCommentHospital();
		
		if(hzHospital2.size() > 0) {
			helpZoneCommentHospital = service.commentchoice(helpZone.getHelpZoneNum());
			if(helpZoneCommentHospital != null) {
				checkchoice=true;								
			}
		}
		
		req.setAttribute("no", no);
		req.setAttribute("helpZone", helpZone);
		req.setAttribute("helpZoneQuestioner", m);
		req.setAttribute("checkchoice", checkchoice);
		req.setAttribute("choiceWriter", helpZoneCommentHospital);
		req.setAttribute("pageBarM", pageBarM);
		req.setAttribute("pageBarH", pageBarH);
		req.setAttribute("cPageMem", cPageMem);
		req.setAttribute("cPageHos", cPageHos);
		req.setAttribute("hzMember2", hzMember2);
		req.setAttribute("hzHospital2", hzHospital2);
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
	
	//댓글 ajax
	@RequestMapping("/helpZone/insertHelpZoneComment.do")
	public String helpZoneCommentInsert(
			int writer,
			String comment,
			int helpZoneNum,
			String checkPH,
			@RequestParam(value="cPageMem",required=false,defaultValue="1") int cPageMem,
			@RequestParam(value="cPageHos",required=false,defaultValue="1") int cPageHos,
			Model model) throws JsonProcessingException,UnsupportedOperationException{
		
		HelpZone helpZone = service.selectHelpZone(helpZoneNum);//헬프존 불러오는 메서드
		Member m = service.selectMember(helpZone.getHelpZoneQuestioner());	//작성자 불러오는 메서드
		
		int numPerPage=10;
		HelpZoneCommentMember hzMember = new HelpZoneCommentMember();
		HelpZoneCommentHospital hzHospital = new HelpZoneCommentHospital();			
		
		
		int totalCountM = 0;
		int totalCountH = 0;
			if(checkPH.trim().equals("P")) {
				hzMember.setHzCommentWriterNumM(writer);
				hzMember.setHzCommentContentM(comment);
				hzMember.setHzNumM(helpZoneNum);
				service.insertCommentMember(hzMember);
				
			}
			else if(checkPH.trim().equals("H")) {
				hzHospital.setHzCommentWriterNumH(writer);
				hzHospital.setHzCommentContentH(comment);
				hzHospital.setHzNumH(helpZoneNum);
				service.insertCommentHospital(hzHospital);
				
			}
			List<HelpZoneCommentMember> hzMember2 = service.selectMemberCommentList(cPageMem, numPerPage, helpZoneNum);
			System.out.println(hzMember2);
			List<HelpZoneCommentHospital> hzHospital2 = service.selectHospitalCommentList(cPageHos, numPerPage, helpZoneNum);
			System.out.println(hzHospital2);
			
			totalCountM = service.helpZoneCommentCountM(helpZoneNum);
			totalCountH = service.helpZoneCommentCountH(helpZoneNum);
			
			String pageBarM = new PageCreate().getPageBarCommentM2(cPageMem, numPerPage, totalCountM, "helpZoneView,do", helpZoneNum);
			String pageBarH = new PageCreate().getPageBarCommentH2(cPageHos, numPerPage, totalCountH, "helpZoneView,do", helpZoneNum);
			
			boolean checkchoice = false;
			HelpZoneCommentHospital helpZoneCommentHospital = new HelpZoneCommentHospital();
			if(hzHospital2.size() > 0) {
				helpZoneCommentHospital = service.commentchoice(helpZoneNum);
				if(helpZoneCommentHospital != null && helpZoneCommentHospital.getHzCommentChoice()==1) {
					checkchoice=true;								
				}
			}	
			/*model.addAttribute("no", helpZoneNum);*/
			model.addAttribute("msg", "댓글 성공");
			model.addAttribute("loc", "/helpZone/helpZoneView.do?no="+helpZoneNum);
			return "common/msg";
	}
	
	@RequestMapping("/helpZone/helpZoneChoice.do")
	public String helpZoneChoice(int hzCommentNumH, int hzNumH, Model model) {
		String msg = "";
		String loc = "/helpZone/helpZoneView.do?no="+hzNumH;
		boolean checkchoice = false;
		
		HelpZoneCommentHospital helpZoneCommentHospital = new HelpZoneCommentHospital();
		helpZoneCommentHospital.setHzCommentNumH(hzCommentNumH);
		helpZoneCommentHospital.setHzNumH(hzNumH);
		int result = service.helpZoneChoice(helpZoneCommentHospital);
		
		if(result > 0) {
			msg = "채택되었습니다.";
			checkchoice = true;
			service.hospitalAddLike(helpZoneCommentHospital);
		} else {
			msg = "채택 중 오류가 발생했습니다.";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("loc", loc);
		model.addAttribute("checkchoice", checkchoice);
		
		return "common/msg";
	}
	
	@RequestMapping("/helpZone/deleteHelpZoneComment.do")
	public String deleteHelpZoneComment(int hzCommentNum, int hzNum, String checkPH, Model model) {
		String msg = "";
		String loc = "/helpZone/helpZoneView.do?no="+hzNum;
		int result = 0;
		HelpZoneCommentMember helpZoneCommentMember = new HelpZoneCommentMember();
		HelpZoneCommentHospital helpZoneCommentHospital = new HelpZoneCommentHospital();
		
		if(checkPH.equals("P")) {
			helpZoneCommentMember.setHzCommentNumM(hzCommentNum);
			helpZoneCommentMember.setHzNumM(hzNum);
			result = service.deleteHelpZoneCommentM(helpZoneCommentMember);
		} else if(checkPH.equals("H")) {
			helpZoneCommentHospital.setHzCommentNumH(hzCommentNum);
			helpZoneCommentHospital.setHzNumH(hzNum);
			result = service.deleteHelpZoneCommentH(helpZoneCommentHospital);
		}
		
		if(result > 0) {
			msg = "댓글 삭제 성공";
		} else {
			msg = "댓글 삭제 실패";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("loc", loc);
		
		return "common/msg";
	}
	
	@RequestMapping("/helpZone/helpZoneSearch.do")
	public String helpZoneSearch(String searchKind, String searchContent,
			@RequestParam(value="cPage",required=false,defaultValue="1") int cPage, Model model) {
		int numPerPage=6;
		int totalCount=0;
		String pageBar=null;
		
		searchContent ="%"+searchContent+"%"; // DB에 입력시 like % a % 라고 입력하기 때문에 변경
		
		List<HelpZone> HelpZoneList = new ArrayList();
		if(searchKind.equals("title")) {
			HelpZoneList = service.selectHelpZoneTitleList(cPage, numPerPage, searchContent);
			totalCount = service.selectTitleSearchCount(searchContent);
		} else {
			HelpZoneList = service.selectHelpZoneContentList(cPage, numPerPage, searchContent);
			totalCount = service.selectContentSearchCount(searchContent);
		}
		pageBar=new PageCreate().getPageBar(cPage, numPerPage,totalCount,searchKind,searchContent,"helpZoneSearch.do");
		searchContent = searchContent.replace("%", "");
		
		model.addAttribute("cPage", cPage);
		model.addAttribute("searchKind", searchKind);
		model.addAttribute("searchContent", searchContent);
		model.addAttribute("list", HelpZoneList);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("pageBar", pageBar);
		
		return "helpZone/helpZoneSearch";
	}
	
}
