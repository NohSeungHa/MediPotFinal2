package com.medi.pot.helpZone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelpZoneController {
	
	//헬프존 메인화면 (질문리스트 출력)
	@RequestMapping("/helpZone/helpZoneList.do")
	public String helpZoneList() {
		System.out.println("헬프존 들어오는지 확인이닷!!");
		return "helpZone/helpZoneMain";
	}
}
