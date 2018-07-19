package com.medi.pot.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {


		
		@RequestMapping("/member.do")
		public String join() {
			System.out.println("들어옴");
			return "redirect:/";
		}



}
