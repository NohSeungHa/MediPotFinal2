package com.medi.pot.helpZone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelpZoneController {
	
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
	public ModelAndView helpZoneInsertEnd(){
		return null;
	}
}
