package com.medi.pot.inquiry.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.medi.pot.inquiry.vo.Inquiry;
import com.medi.pot.common.page.PageCreate;
import com.medi.pot.inquiry.service.InquiryService;

@Controller
public class InquiryController {
	
	@Autowired
	private InquiryService service;
	
	//1:1 문의 List
	@RequestMapping("/Inquiry/InquiryList.do")
	public ModelAndView Inquiry(@RequestParam(value="cPage",required=false,defaultValue="1") int cPage,String checkPH,String id) {
		ModelAndView mv=new ModelAndView();
		int numPerPage=10;
		int totalCount=0;
		String pageBar=null;
		if(checkPH==null) {
			String msg="로그인 후 이용해 주세요.";
			mv.addObject("msg",msg);
			mv.setViewName("common/msg");
			return mv;
		}else {
			Map<String, String> map = new HashMap();
			List<Inquiry> list = new ArrayList();
			if(checkPH.equals("P")) {
				if(id.equals("admin")) {
					System.out.println("admin 온다?");
					list = service.InquiryAdminList(cPage,numPerPage);
					totalCount = service.InquiryAdminListTotalCount();
					pageBar=new PageCreate().getPageBarInquiry(cPage, numPerPage,totalCount,"InquiryList.do",checkPH,id);
				}else {
					map.put("id", id);
					map.put("checkPH", checkPH);
					list = service.InquiryList(map,cPage,numPerPage);
					totalCount = service.InquiryListTotalCount(map);
					pageBar=new PageCreate().getPageBarInquiry(cPage, numPerPage,totalCount,"InquiryList.do",checkPH,id);
				}
			}
			else {
				map.put("id", id);
				map.put("checkPH", checkPH);
				list = service.InquiryList(map,cPage,numPerPage);
				totalCount = service.InquiryListTotalCount(map);
				pageBar=new PageCreate().getPageBarInquiry(cPage, numPerPage,totalCount,"InquiryList.do",checkPH,id);
			}
			
			System.out.println("list : "+list);
			mv.addObject("id", id);
			mv.addObject("list", list);
			mv.addObject("pageBar", pageBar);
			mv.addObject("cPage", cPage);
			mv.addObject("totalCount", totalCount);
			mv.setViewName("inquiry/inquiryList");
			
			return mv;
		}

	}
	
	@RequestMapping("/inquiry/insertInquiry.do")
	public ModelAndView insertInquiry(String checkPH,String id, String title, String content, HttpServletRequest req) {
		System.out.println("id : "+id);
		System.out.println("chPH : "+checkPH);
		System.out.println("title : "+title);
		System.out.println("content : "+content);
		ModelAndView mv=new ModelAndView();
		
		Map<String, String> map = new HashMap();
		map.put("id", id);
		map.put("checkPH", checkPH);
		map.put("title", title);
		map.put("content", content);
		
		int result = service.insertInquiry(map);
		String msg="";
		if(result>0) {
			msg="1:1 문의를 하였습니다.";
		}
		else {
			msg="1:1 문의를 실패하였습니다.";
		}
		
		
		mv.addObject("msg",msg);
		mv.addObject("loc", "/Inquiry/InquiryList.do?id="+id+"&checkPH="+checkPH);
		mv.setViewName("common/msg");
		
		return mv;
	}
	
	//문의 하기
	@RequestMapping("/inquiry/answerInquiry.do")
	public ModelAndView answerInquiry(String checkPH,String id,String answerNo,String answerContent) {
		ModelAndView mv=new ModelAndView();
		
		Map<String, Object> map = new HashMap();
		map.put("answerNo", Integer.parseInt(answerNo));
		map.put("answerContent", answerContent);
		
		int result = service.answerInquiry(map);
		String msg="";
		if(result>0) {
			msg="문의에 대한 답변을 하였습니다.";
		}
		else {
			msg="문의에 대한 답변을 실패하였습니다.";
		}
		
		mv.addObject("msg",msg);
		mv.addObject("loc", "/Inquiry/InquiryList.do?id="+id+"&checkPH="+checkPH);
		mv.setViewName("common/msg");
		return mv;
	}

	//문의 삭제
	@RequestMapping("/inquiry/deleteInquiry.do")
	public ModelAndView deleteInquiry(String checkPH,String id,int no) {
		ModelAndView mv=new ModelAndView();
		
		int result = service.deleteInquiry(no);
		String msg="";
		if(result>0) {
			msg="문의를 삭제 하였습니다.";
		}
		else {
			msg="문의를 삭제에 실패하였습니다.";
		}
		
		mv.addObject("msg",msg);
		mv.addObject("loc", "/Inquiry/InquiryList.do?id="+id+"&checkPH="+checkPH);
		mv.setViewName("common/msg");
		return mv;
	}
	
	//문의 수정
	@RequestMapping("/inquiry/updateInquiry.do")
	public ModelAndView updateInquiry(String checkPH,String id,String updateNo,String updateContent) {
		ModelAndView mv=new ModelAndView();
		
		Map<String, Object> map = new HashMap();
		map.put("updateNo", Integer.parseInt(updateNo));
		map.put("updateContent", updateContent);
		
		int result = service.updateInquiry(map);
		String msg="";
		if(result>0) {
			msg="문의를 수정 하였습니다.";
		}
		else {
			msg="문의수정을 실패 하였습니다.";
		}
		
		mv.addObject("msg",msg);
		mv.addObject("loc", "/Inquiry/InquiryList.do?id="+id+"&checkPH="+checkPH);
		mv.setViewName("common/msg");
		return mv;
	}
}
