package com.medi.pot.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReservationController {
	
	@RequestMapping("/medi/medireser.do")
	public String reser() {
		
		return "medi_reservation/reservation";
	}

}
