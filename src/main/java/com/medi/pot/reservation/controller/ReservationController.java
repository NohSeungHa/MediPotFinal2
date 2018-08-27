package com.medi.pot.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.medi.pot.common.page.PageCreate;
import com.medi.pot.common.page.PageCreate2;
import com.medi.pot.reservation.model.service.ReservationService;
import com.medi.pot.reservation.model.vo.DoctorInfo;
import com.medi.pot.reservation.model.vo.DoctorSchedule;
import com.medi.pot.reservation.model.vo.HospitalInfo;
import com.medi.pot.reservation.model.vo.MemberReservation;
import com.medi.pot.reservation.model.vo.ReserList;
import com.medi.pot.reservation.model.vo.SearchReserList;
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
	public String mediInfo(@RequestParam(value = "no")String no,HttpServletRequest req) {
		int num=Integer.parseInt(no);
		HospitalInfo hi=service.mediInfo(num);
		req.setAttribute("hi", hi);
		return "medi_reservation/mediInfo";
	}
	
	@RequestMapping("/medi/reser")
	public String mediReser(@RequestParam(value = "no")String no,HttpServletRequest req) {
		int num=Integer.parseInt(no);
		List<DoctorInfo> list=service.selectDoctorList(num);
		req.setAttribute("list", list);
		return "medi_reservation/reservation";
	}
	
	@RequestMapping("/medi/medisearchList")
	public String medisearchList(@RequestParam(value="cPage", required=false,defaultValue="1") int cPage, @RequestParam(value = "loc")String loc,@RequestParam(value = "sub")String sub,HttpServletRequest req) {
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
	public String medisearchList2(@RequestParam(value="cPage", required=false,defaultValue="1") int cPage, @RequestParam(value = "loc")String loc,@RequestParam(value = "sub")String sub,HttpServletRequest req) {
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
	public String searchMedi(@RequestParam(value = "hName")String hName, HttpServletRequest req) {
		List<HospitalInfo> nameList=service.mediNameSearch(hName);
		req.setAttribute("nameList", nameList);
		String ch="";
		if(nameList.size()<1) {
			ch="none";
		}
		req.setAttribute("ch", ch);
		return "medi_reservation/mediFindList";
	}
	
	@RequestMapping("/medi/doctorS")
	public String doctorSca(@RequestParam(value = "docNum")String docNum,@RequestParam(value = "hosNum")String hosNum,HttpServletRequest req) {
		int num=Integer.parseInt(hosNum);
		int docNo=Integer.parseInt(docNum);
		List<DoctorInfo> list=service.selectDoctorList(num);
		DoctorInfo doctor=service.selectDoctor(docNo);
		List<DoctorSchedule> docSche=service.selectDocSche(docNo);
		req.setAttribute("list", list);
		req.setAttribute("doctor", doctor);
		req.setAttribute("docSche", docSche);
		
		return "medi_reservation/reservation";
	}
	@RequestMapping("/medi/mediChoice")
	public String mediChoice(@RequestParam(value = "docNum")String docNum,@RequestParam(value = "time")String time, HttpServletRequest req) {
		Map<String,Object> map=new HashMap<String, Object>();
		int num=Integer.parseInt(docNum);
		String chDate=time.substring(0, 10);
		map.put("num", docNum);
		map.put("chDate", chDate);
		System.out.println("확인하기 : "+docNum);
		System.out.println("확인하기 : "+chDate);
		DoctorInfo doctor=service.selectDoctor(num);
		List<MemberReservation> mr=service.selectReser(map);
		System.out.println("list : "+mr);
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
	public String reserList(@RequestParam(value="cPage", required=false,defaultValue="1") int cPage, String userNum,HttpServletRequest req) {
		int num=Integer.parseInt(userNum);
		int numPerPage=10;
		List<ReserList> list=service.reserList(num,cPage,numPerPage);
		int totalCount=service.reserCount(num);
		System.out.println("확인확인"+totalCount);
		String pageBar=new PageCreate().getPageBar3(cPage, numPerPage, totalCount, req.getContextPath()+"/medi/reserList", num);
		req.setAttribute("pageBar", pageBar);
		req.setAttribute("list", list);
		req.setAttribute("cPage", cPage);
		return "medi_reservation/reserList";
	}
	
	@RequestMapping("/medi/reserDelete")
	public String reserDelete(@RequestParam(value="cPage", required=false,defaultValue="1") int cPage,String no,String userNum,HttpServletRequest req) {
		int chNum=Integer.parseInt(no);
		int numPerPage=10;
		int result=service.reserDelete(chNum);
		String msg=null;
		if(result>0) {
			msg="삭제 되었습니다.";
		}else {
			msg="삭제 실패";
		}
		
		int num=Integer.parseInt(userNum);
		List<ReserList> list=service.reserList(num,cPage,numPerPage);
		int totalCount=service.reserCount(num);
		String pageBar=new PageCreate().getPageBar3(cPage, numPerPage, totalCount, req.getContextPath()+"/medi/reserList", num);
		req.setAttribute("pageBar", pageBar);
		req.setAttribute("list", list);
		req.setAttribute("msg", msg);
		req.setAttribute("cPage", cPage);
		return "medi_reservation/reserList";
	}
	@RequestMapping("/medi/reser2")
	public String mediReser2(String no,HttpServletRequest req) {
		int num=Integer.parseInt(no);
		List<DoctorInfo> list=service.selectDoctorList(num);
		req.setAttribute("list", list);
		return "medi_reservation/reservation2";
	}
	
	@RequestMapping("/medi/doctorS2")
	public String doctorSca2(String docNum,String hosNum,HttpServletRequest req) {
		int num=Integer.parseInt(hosNum);
		int docNo=Integer.parseInt(docNum);
		List<DoctorInfo> list=service.selectDoctorList(num);
		DoctorInfo doctor=service.selectDoctor(docNo);
		List<DoctorSchedule> docSche=service.selectDocSche(docNo);
		req.setAttribute("list", list);
		req.setAttribute("doctor", doctor);
		req.setAttribute("docSche", docSche);
		
		return "medi_reservation/reservation2";
	}
	
	@RequestMapping("/medi/mediChoice2")
	public String mediChoice2(String docNum,String hos,String time, HttpServletRequest req) {
		Map<String,Object> map=new HashMap<String, Object>();
		int num=Integer.parseInt(docNum);
		int num2=Integer.parseInt(hos);
		String chDate=time.substring(0, 10);
		System.out.println("값 확인11111: "+docNum);
		System.out.println("값 확인2222 : "+hos);
		map.put("num", docNum);
		map.put("num2", num2);
		map.put("chDate", chDate);
		DoctorInfo doctor=service.selectDoctor(num);
		List<MemberReservation> mr=service.selectReser(map);
		
		System.out.println("값 확인 : "+mr);
		
		req.setAttribute("doctor", doctor);
		req.setAttribute("mr", mr);
		req.setAttribute("time", time);
		return "medi_reservation/choiceTime2";
	}
	
	@RequestMapping("/medi/insertBlock")
	public String insertBlock(@RequestParam(value = "docNum")String docNum,@RequestParam(value = "hosNum")String hosNum,@RequestParam(value = "choiceTime")String choiceTime,@RequestParam(value = "time")String time,HttpServletRequest req) {
		int num=Integer.parseInt(hosNum);
		int docNo=Integer.parseInt(docNum);
		int result=0;
		String [] cho=choiceTime.split(",");
		for(int i=0;i<cho.length;i++) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("docNum", docNo);
		map.put("hosNum", num);
		map.put("time", time);
		map.put("choiceTime",cho[i]);
		result=service.insertBlock(map);
		}
		String msg="";
		if(result>0) {
			msg="제외 처리가 되었습니다.";
		}else {
			msg="제외 처리가 실패 하였습니다.";
		}
		
		List<DoctorInfo> list=service.selectDoctorList(num);
		DoctorInfo doctor=service.selectDoctor(docNo);
		List<DoctorSchedule> docSche=service.selectDocSche(docNo);
		req.setAttribute("list", list);
		req.setAttribute("doctor", doctor);
		req.setAttribute("docSche", docSche);
		req.setAttribute("msg", msg);
		
		return "medi_reservation/reservation2";
	}
	
	@RequestMapping("/medi/hDeleteReser")
	public String hDeleteReser(@RequestParam(value = "docNum")String docNum,@RequestParam(value = "hosNum")String hosNum,@RequestParam(value = "memberNum")int memberNum,@RequestParam(value = "reserDate")String reserDate,String reserTime,HttpServletRequest req) {
		int num=Integer.parseInt(hosNum);
		int docNo=Integer.parseInt(docNum);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("num", memberNum);
		map.put("date", reserDate);
		map.put("time", reserTime);
		map.put("docNum", docNo);
		int result=service.hDeleteReser(map);
		String msg="";
		if(result>0) {
			msg="예약이 삭제 되었습니다.";
		}else {
			msg="예약 삭제 실패 하였습니다.";
		}
		
		List<DoctorInfo> list=service.selectDoctorList(num);
		DoctorInfo doctor=service.selectDoctor(docNo);
		List<DoctorSchedule> docSche=service.selectDocSche(docNo);
		req.setAttribute("list", list);
		req.setAttribute("doctor", doctor);
		req.setAttribute("docSche", docSche);
		req.setAttribute("msg", msg);
		
		return "medi_reservation/reservation2";
	}
	
	@RequestMapping("/medi/bDeleteReser")
	public String bDeleteReser(@RequestParam(value = "docNum")String docNum,@RequestParam(value = "hosNum")String hosNum,@RequestParam(value = "reserDate")String reserDate,@RequestParam(value = "reserTime")String reserTime,HttpServletRequest req) {
		int num=Integer.parseInt(hosNum);
		int docNo=Integer.parseInt(docNum);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("date", reserDate);
		map.put("time", reserTime);
		map.put("docNum", docNo);
		int result=service.bDeleteReser(map);
		String msg="";
		if(result>0) {
			msg="제외처리가 취소 되었습니다.";
		}else {
			msg="제외처리 취소에 실패 하였습니다.";
		}
		
		List<DoctorInfo> list=service.selectDoctorList(num);
		DoctorInfo doctor=service.selectDoctor(docNo);
		List<DoctorSchedule> docSche=service.selectDocSche(docNo);
		req.setAttribute("list", list);
		req.setAttribute("doctor", doctor);
		req.setAttribute("docSche", docSche);
		req.setAttribute("msg", msg);
		
		return "medi_reservation/reservation2";
	}
	
	@RequestMapping("/medi/hBlockDate")
	public String hBlockDate (@RequestParam(value = "docNum")String docNum,@RequestParam(value = "hosNum")String hosNum,@RequestParam(value = "date")String date,HttpServletRequest req) {
		int num=Integer.parseInt(hosNum);
		int docNo=Integer.parseInt(docNum);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("docNum", docNo);
		map.put("hosNum", num);
		map.put("date", date);
		int result=service.hBlockDate(map);
		String msg="";
		if(result>0) {
			msg="날짜가 제외 처리 되었습니다.";
		}else {
			msg="날짜 제외 처리에 실패 하였습니다.";
		}
		
		List<DoctorInfo> list=service.selectDoctorList(num);
		DoctorInfo doctor=service.selectDoctor(docNo);
		List<DoctorSchedule> docSche=service.selectDocSche(docNo);
		req.setAttribute("list", list);
		req.setAttribute("doctor", doctor);
		req.setAttribute("docSche", docSche);
		req.setAttribute("msg", msg);
		
		return "medi_reservation/reservation2";
	}
	
	@RequestMapping("/medi/deleteDateCan")
	public String deleteDateCan(@RequestParam(value = "docNum")String docNum,@RequestParam(value = "hosNum")String hosNum,@RequestParam(value = "blockD")String blockD,HttpServletRequest req) {
		int num=Integer.parseInt(hosNum);
		int docNo=Integer.parseInt(docNum);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("docNum", docNo);
		map.put("hosNum", num);
		map.put("date", blockD);
		int result=service.deleteDateCan(map);
		String msg="";
		if(result>0) {
			msg="날짜 제외처리가 취소 되었습니다.";
		}else {
			msg="날짜 제외처리 취소에 실패하였습니다.";
		}
		
		List<DoctorInfo> list=service.selectDoctorList(num);
		DoctorInfo doctor=service.selectDoctor(docNo);
		List<DoctorSchedule> docSche=service.selectDocSche(docNo);
		req.setAttribute("list", list);
		req.setAttribute("doctor", doctor);
		req.setAttribute("docSche", docSche);
		req.setAttribute("msg", msg);
		
		return "medi_reservation/reservation2";
	}

	@RequestMapping("/medi/searchReserM")
	public String searchReserM(@RequestParam(value="cPage", required=false,defaultValue="1") int cPage,@RequestParam(value = "docNum")int docNum,@RequestParam(value = "date")String date,HttpServletRequest req) {
		Map<String, Object> map=new HashMap<String, Object>();
		int numPerPage=10;
		map.put("docNum", docNum);
		map.put("date", date);
		
		List<SearchReserList> list=service.searchReserM(map,cPage,numPerPage);
		int totalCount=service.searchReserCount(map);
		String pageBar=new PageCreate2().getPageBar(cPage, numPerPage, totalCount, req.getContextPath()+"/medi/searchReserM",docNum,date );
		req.setAttribute("pageBar", pageBar);
		req.setAttribute("list", list);
		req.setAttribute("cPage", cPage);
		req.setAttribute("list", list);
		req.setAttribute("date", date);
		return "medi_reservation/searchReser";
	}
	
	@RequestMapping("/medi/deleteSearchReser")
	public String deleteSearchReser(@RequestParam(value="cPage", required=false,defaultValue="1") int cPage,@RequestParam(value = "num")int num,@RequestParam(value = "docNum")int docNum,@RequestParam(value = "date")String date, HttpServletRequest req) {
		int result=service.deleteSearchReser(num);
		String msg="";
		if(result>0) {
			msg="예약이 취소 되었습니다.";
		}else {
			msg="예약 취소에 실패 하였습니다.";
		}
		
		Map<String, Object> map=new HashMap<String, Object>();
		int numPerPage=10;
		map.put("docNum", docNum);
		map.put("date", date);
		
		List<SearchReserList> list=service.searchReserM(map,cPage,numPerPage);
		int totalCount=service.searchReserCount(map);
		String pageBar=new PageCreate2().getPageBar(cPage, numPerPage, totalCount, req.getContextPath()+"/medi/searchReserM",docNum,date);
		req.setAttribute("pageBar", pageBar);
		req.setAttribute("list", list);
		req.setAttribute("cPage", cPage);
		req.setAttribute("msg", msg);
		req.setAttribute("date", date);
		return "medi_reservation/searchReser";
	}
	
	@RequestMapping("/medi/searchReserMember")
	public String searchReserMember(@RequestParam(value="cPage", required=false,defaultValue="1") int cPage,@RequestParam(value = "no")int no,HttpServletRequest req) {
		int numPerPage=10;
		int totalCount=0;
		String pageBar=new PageCreate2().getPageBar(cPage, numPerPage, totalCount, req.getContextPath()+"/medi/searchReserMember");
		req.setAttribute("pageBar", pageBar);
		req.setAttribute("hosNum", no);
		return "medi_reservation/searchReserMember";
	}
	
	@RequestMapping("/medi/searchReserMem")
	public String searchReserMem(@RequestParam(value="cPage", required=false,defaultValue="1") int cPage,@RequestParam(value = "hosNum")int hosNum,@RequestParam(value = "searchKind") String searchKind,@RequestParam(value = "search") String search, HttpServletRequest req) {
		int numPerPage=10;
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("hosNum", hosNum);
		map.put("kind", searchKind);
		map.put("search", search);
		List<SearchReserList> list=service.searchReserMem(map,cPage,numPerPage);
		int totalCount=service.searchReserMemCount(map);
		String pageBar=new PageCreate2().getPageBar2(cPage, numPerPage, totalCount, req.getContextPath()+"/medi/searchReserMem",hosNum,searchKind,search);
		req.setAttribute("pageBar", pageBar);
		req.setAttribute("list", list);
		req.setAttribute("cPage", cPage);
		
		req.setAttribute("hosNum", hosNum);
		req.setAttribute("kind", searchKind);
		req.setAttribute("search", search);
		return "medi_reservation/searchReserMember";
	}
	
	@RequestMapping("/medi/deleteSearchReserMember")
	public String deleteSearchReserMember(@RequestParam(value="cPage", required=false,defaultValue="1") int cPage,@RequestParam(value = "num")int num,@RequestParam(value = "hosNum")int hosNum,@RequestParam(value = "searchKind") String searchKind,@RequestParam(value = "search") String search, HttpServletRequest req) {
		int result=service.deleteSearchReserMember(num);
		String msg="";
		if(result>0) {
			msg="예약이 취소 되었습니다.";
		}else {
			msg="예약 취소에 실패 하였습니다.";
		}

	
		int numPerPage=10;
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("hosNum", hosNum);
		map.put("kind", searchKind);
		map.put("search", search);
		List<SearchReserList> list=service.searchReserMem(map,cPage,numPerPage);
		int totalCount=service.searchReserMemCount(map);
		String pageBar=new PageCreate2().getPageBar2(cPage, numPerPage, totalCount, req.getContextPath()+"/medi/searchReserMem",hosNum,searchKind,search);
		req.setAttribute("pageBar", pageBar);
		req.setAttribute("list", list);
		req.setAttribute("cPage", cPage);
		
		req.setAttribute("hosNum", hosNum);
		req.setAttribute("kind", searchKind);
		req.setAttribute("search", search);
		req.setAttribute("msg", msg);
		return "medi_reservation/searchReserMember";
	}
	
	@RequestMapping("/")
	public String hosList(HttpServletRequest req) {
		List<HospitalInfo> list=service.selectHosList();
		String str="";
		for(HospitalInfo h : list) {
			if(h.getHospitalLike()>0) {
				str="ok";
			}
		}
		if(!str.equals("ok")) {
			list=null;
		}
		req.setAttribute("list", list);
		System.out.println("list : "+list);
		return "index";
	}
	
	@RequestMapping("/medi/mediAll")
	   public String mediAll(HttpServletRequest req) {
	      List<HospitalInfo> list=service.selectAll();
	      System.out.println("list 확인 : "+list);
	      req.setAttribute("list", list);
	      return "medi_reservation/allMediList";
	   }


}
