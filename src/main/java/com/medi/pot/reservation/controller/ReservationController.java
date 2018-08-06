package com.medi.pot.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.medi.pot.common.page.PageCreate2;
import com.medi.pot.reservation.model.service.ReservationService;
import com.medi.pot.reservation.model.vo.DoctorInfo;
import com.medi.pot.reservation.model.vo.DoctorSchedule;
import com.medi.pot.reservation.model.vo.HospitalInfo;
import com.medi.pot.reservation.model.vo.MemberReservation;
import com.medi.pot.reservation.model.vo.ReserList;
import com.medi.pot.common.page.PageCreate2;

@Controller
public class ReservationController {
	
	@Autowired
	private ReservationService service;
	
	@RequestMapping("/medi/medireser.do")
	public String reser() {
		
		return "medi_reservation/mediFindList";
	}
	
	@RequestMapping("/medi/mediInfo")
	public String mediInfo(String no,HttpServletRequest req) {
		int num=Integer.parseInt(no);
		HospitalInfo hi=service.mediInfo(num);
		req.setAttribute("hi", hi);
		return "medi_reservation/mediInfo";
	}
	
	@RequestMapping("/medi/reser")
	public String mediReser(String no,HttpServletRequest req) {
		int num=Integer.parseInt(no);
		List<DoctorInfo> list=service.selectDoctorList(num);
		req.setAttribute("list", list);
		return "medi_reservation/reservation";
	}
	
	@RequestMapping("/medi/medisearchList")
	public String medisearchList(@RequestParam(value="cPage", required=false,defaultValue="1") int cPage, String loc,String sub,HttpServletRequest req) {
		Map<String,String> map=new HashMap<String, String>();
		map.put("loc", loc);
		map.put("sub", sub);
		int numPerPage=6;
		List<HospitalInfo> list=service.medisearchList(map,cPage,numPerPage);
		int totalCount=service.selectCount(map);
		String pageBar=new PageCreate2().getPageBar(cPage, numPerPage,totalCount,req.getContextPath()+"/medi/medisearchList2",loc,sub);
		req.setAttribute("pageBar", pageBar);
		req.setAttribute("list", list);
		req.setAttribute("cPage", cPage);
		return "medi_reservation/mediList";
	}
	
	@RequestMapping("/medi/medisearchList2")
	public String medisearchList2(@RequestParam(value="cPage", required=false,defaultValue="1") int cPage, String loc,String sub,HttpServletRequest req) {
		Map<String,String> map=new HashMap<String, String>();
		map.put("loc", loc);
		map.put("sub", sub);
		int numPerPage=6;
		List<HospitalInfo> list=service.medisearchList(map,cPage,numPerPage);
		int totalCount=service.selectCount(map);
		String pageBar=new PageCreate2().getPageBar(cPage, numPerPage,totalCount,req.getContextPath()+"/medi/medisearchList2",loc,sub);
		req.setAttribute("pageBar", pageBar);
		req.setAttribute("list", list);
		req.setAttribute("cPage", cPage);
		return "medi_reservation/mediList2";
	}
	
	@RequestMapping("/medi/searchMedi")
	public String searchMedi(String hName, HttpServletRequest req) {
		List<HospitalInfo> nameList=service.mediNameSearch(hName);
		System.out.println(nameList);
		req.setAttribute("nameList", nameList);
		return "medi_reservation/mediFindList";
	}
	
	@RequestMapping("/medi/doctorS")
	public String doctorSca(String docNum,String hosNum,HttpServletRequest req) {
		int num=Integer.parseInt(hosNum);
		int docNo=Integer.parseInt(docNum);
		List<DoctorInfo> list=service.selectDoctorList(num);
		DoctorInfo doctor=service.selectDoctor(docNo);
		DoctorSchedule docSche=service.selectDocSche(docNo);
		req.setAttribute("list", list);
		req.setAttribute("doctor", doctor);
		req.setAttribute("docSche", docSche);
		
		return "medi_reservation/reservation";
	}
	@RequestMapping("/medi/mediChoice")
	public String mediChoice(String docNum,String time, HttpServletRequest req) {
		Map<String,Object> map=new HashMap<String, Object>();
		int num=Integer.parseInt(docNum);
		String chDate=time.substring(0, 10);
		map.put("num", docNum);
		map.put("chDate", chDate);
		DoctorInfo doctor=service.selectDoctor(num);
		List<MemberReservation> mr=service.selectReser(map);
		
		req.setAttribute("doctor", doctor);
		req.setAttribute("mr", mr);
		req.setAttribute("time", time);
		return "medi_reservation/choiceTime";
	}
	
	@RequestMapping("/medi/insertReser")
	public String insertReser(MemberReservation mr,HttpServletRequest req) {
		int result=service.insertReser(mr);
		String msg="";
		if(result>0) {
			msg="예약 성공";
		}else {
			msg="예약 실패";
		}
		req.setAttribute("msg", msg);
		req.setAttribute("loc", "/");
		return "common/msg";
	}
	
	@RequestMapping("/medi/reserList")
	public String reserList(String userNum,HttpServletRequest req) {
		int num=Integer.parseInt(userNum);
		List<ReserList> list=service.reserList(num);
		return "";
	}
	

}
