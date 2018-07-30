package com.medi.pot.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.medi.pot.reservation.model.service.ReservationService;
import com.medi.pot.reservation.model.vo.HospitalInfo;

@Controller
public class ReservationController {
	
	@Autowired
	private ReservationService service;
	
	@RequestMapping("/medi/medireser.do")
	public String reser() {
		
		return "medi_reservation/mediFindList";
	}
	
	@RequestMapping("/medi/mediInfo")
	public String mediInfo() {
		return "medi_reservation/mediInfo";
	}
	
	@RequestMapping("/medi/reser")
	public String mediReser() {
		
		return "medi_reservation/reservation";
	}
	
	@RequestMapping("/medi/medisearchList")
	public String medisearchList(String loc,String sub,HttpServletRequest req) {
		Map<String,String> map=new HashMap<String, String>();
		map.put("loc", loc);
		map.put("sub", sub);
		List<HospitalInfo> list=service.medisearchList(map);
		req.setAttribute("list", list);
		return "medi_reservation/mediFindList";
	}

}
