package com.medi.pot.member.controller;

import java.awt.Window;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.medi.pot.common.page.PageCreate;
import com.medi.pot.member.model.service.MemberService;
import com.medi.pot.member.model.vo.Hospital;
import com.medi.pot.member.model.vo.Member;

@SessionAttributes(value={"memberLoggedIn", "checkPH", "emailCheck"})

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@RequestMapping("/member/join.do")
	public String join() {
		System.out.println("회원가입으로 들어옴");
		return "member/join";
	}

	@RequestMapping("/member/joinMember.do")
	public String joinMemeber() {
		System.out.println("회원가입(개인)으로 들어옴");
		return "member/member";
	}
	
	@RequestMapping("/member/memberEnrollEnd.do")
	public String joinMemberEnd(Member m, Model model) {
		System.out.println("회원가입(개인)을 실행함");
		String msg = "";
		String loc = "";
		
		boolean checkid = service.checkId(m.getMemberId())==0?true:false;
		
		if(!checkid) {
			msg = "해당 아이디는 사용이 불가능합니다.";
			
			model.addAttribute("msg", msg);
			model.addAttribute("loc", loc);
			
			return "common/msg";
		}
		String oldpw = m.getMemberPw();
		
		System.out.println("암호화 전 : " + oldpw);
		
		m.setMemberPw(bcrypt.encode(oldpw));
		
		System.out.println("암호화 후 : " + m.getMemberPw());
		
		int result = service.insertMember(m);
		
		if(result > 0) {
			msg = "회원가입 성공!";
		} else {
			msg = "회원가입 실패!";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("loc", loc);
		
		return "common/msg";
	}

	@RequestMapping("/member/joinHospitalStart.do")
	public String joinHospital1() {
		return "member/hospital";
	}
	
	
	@RequestMapping("/member/hospitalEnrollEnd.do")
	public String joinHospital1(Hospital h, Model model) {
		System.out.println("회원가입(병원-승인중)으로 들어옴");

		String msg="";
		String loc="";

		boolean checkid = service.checkHospitalId(h.getHospitalId())==0?true:false;

		if(!checkid) {
			msg = "해당 아이디는 사용이 불가능합니다.";

			model.addAttribute("msg", msg);
			model.addAttribute("loc", loc);

			return "common/msg";
		}
		String oldpw = h.getHospitalPw();

		System.out.println("암호화 전 : " + oldpw);

		h.setHospitalPw(bcrypt.encode(oldpw));

		System.out.println("암호화 후 : " + h.getHospitalPw());

		int result = service.insertHospital(h);

		if(result > 0) {
			msg = "회원가입이 신청되었습니다. 관리자의 승인을 기다려주십시오.";
		} else {
			msg = "회원가입 실패!";
		}

		model.addAttribute("msg", msg);
		model.addAttribute("loc", loc);

		return "common/msg";

	}
	
	@RequestMapping("/member/joinpermission.do")
	public String joinPermission() {
		System.out.println("회원가입(병원-승인전)으로 들어옴");
		return "member/permission";
	}
	
	@RequestMapping("/member/joinHospitalEnd.do")
	public String joinHospital2() {
		System.out.println("회원가입(병원-승인중)으로 들어옴");
		return "redirect:/";
	}
	
	@RequestMapping("/member/findId.do")
	public String findid() {
		System.out.println("아이디찾기로 들어옴");
		return "member/findid";
	}
	
	@RequestMapping("/member/findPassword.do")
	public String findpassword() {
		System.out.println("비밀번호찾기로 들어옴");
		return "member/findpassword";
	}
	
	@RequestMapping("/member/memberLogin.do")
	public String login(String PnH, String memberId, String memberPw, Model model, HttpServletRequest req) {
		System.out.println("로그인을 실행.." + PnH + "..." + memberId + "..." + memberPw);
		// P = 개인 (Person)
		// H = 병원 (Hospital)
		String msg = "";
		String loc = "/";
		boolean PnHcheck = false;
		
		Member m = new Member();
		Hospital h = new Hospital();

		if(PnH.equals("P")) {
			m = service.loginMemberCheck(memberId);
			
			if(m==null) {
				
			}else {
				if(bcrypt.matches(memberPw, m.getMemberPw())) {
					model.addAttribute("memberLoggedIn",m);
					model.addAttribute("checkPH","P");
					PnHcheck = true;
				}
			}
			
		} else{
			h = service.loginHospitalCheck(memberId);
			if(h==null) {
				
			}else {
				String hos_admi = h.getHospitalAdmission();
				
				if(bcrypt.matches(memberPw, h.getHospitalPw())) {
					model.addAttribute("memberLoggedIn",h);
					model.addAttribute("checkPH","H");
					model.addAttribute("hospitalAdmission",hos_admi);
					PnHcheck = true;
					if(hos_admi.equals("0")) {
						return "member/permission";
					}
				}
			}
		}
		
		if(PnHcheck) {
			msg = "로그인 성공!";
		} else {
			msg = "로그인 실패!";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("loc", loc);
		return "common/msg";
	}
	
	@RequestMapping("/member/memberLogout.do")
	public String logout(SessionStatus sessionStatus) {
		System.out.println("로그아웃을 진행");
		if(!sessionStatus.isComplete()) {
			// 세션이 진행중이라면(존재한다면)
			sessionStatus.setComplete();
			// 세션을 완료시킨다(끝낸다)
		}
		
		return "redirect:/";
	}
	
	@RequestMapping("/member/mypage.do")
	public String adminPage(String user_id) {
		System.out.println("마이페이지 들어옴");
		String view = "";
		if(user_id.equals("admin")) {
			view = "member/adminPage";
		} else {
			view = "member/memberPage";
		}
		
		return view;
	}
	
	@RequestMapping("/member/PcheckId.do")
	@ResponseBody
	public void membercheckId(String memberId,HttpServletResponse res) throws Exception {
		
		
		boolean check = service.duplicateMemIdCheck(memberId)==0?true:false;
		res.getWriter().print(check);
	}
	
	@RequestMapping("/member/HcheckId.do")
	@ResponseBody
	public void hospitalcheckId(String hospitalId,HttpServletResponse res) throws Exception{
		boolean check = service.checkHospitalId(hospitalId)==0?true:false;
		res.getWriter().print(check);
	}
	
	/*@RequestMapping("/member/HcheckId.do")
	public String hospitalcheckId(String memberId) throws Exception {
		Map map = new HashMap();
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonstr = "";
		
		boolean check = service.duplicateIdHosCheck(memberId)==0?true:false;
		
		map.put("check", check);
		
		jsonstr = mapper.writeValueAsString(map);
		return jsonstr;
	}*/
	
	@RequestMapping("/member/memberPageUpdate.do")
	public String memberPageUpdate(Member m, Model model) {
		String msg = "수정 실패!";
		String loc = "";
		int result = service.memberPageUpdate(m);
		
		if(result > 0) {
			msg = "수정 성공!";
			model.addAttribute("memberLoggedIn", m);
		}
		
		model.addAttribute("msg",msg);
		model.addAttribute("loc",loc);
		
		return "common/msg";
	}
	
	@RequestMapping("/member/memberPwUpdate.do")
	public String memberPwUpate(String originPw, String newPw, String memberId, Model model) {
		String msg = "";
		String loc = "";
		
		Member m = service.selectMember(memberId);
		Map<String, String> idpw = new HashMap<String, String>();
		
		if(bcrypt.matches(originPw, m.getMemberPw())) {
			String newPassword = bcrypt.encode(newPw);
			idpw.put("memberId", memberId);
			idpw.put("newPassword",	newPassword);
			int result = service.memberPwUpdate(idpw);
			if(result > 0) {
				msg = "비밀번호 수정 성공!";	
			} else {
				msg = "비밀번호 수정 실패!";
			}
		} else {
			msg = "현재 비밀번호가 일치하지 않습니다.";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("loc", loc);
		
		return "common/msg";
	}
	
	@RequestMapping("/member/pwEdit.do")
	public String pwEdit(String check) {
		String view = "";
		
		if(check.equals("P")) {
			view = "member/memberPwEdit";
		} else if(check.equals("H")) {
			view = "member/hospitalPwEdit";
		} else {
			System.exit(1);
		}
		
		return view;
	}
	
	@RequestMapping("/member/emailCodeResponse.do")
	public String emailResponse() {


		return "redirect:/";
	}
	
	@RequestMapping("/adminPage/memberList.do")
	public ModelAndView memberList(@RequestParam(value="cPage",required=false,defaultValue="1") int cPage) {
		ModelAndView mv=new ModelAndView();
		int numPerPage=10;
		List<Member> list=service.selectMemberList(cPage,numPerPage);
		
		int totalCount=service.selectCount();
		
		String pageBar=new PageCreate().getPageBar(cPage, numPerPage,totalCount,"memberList.do");
		
		mv.addObject("pageBar", pageBar);
		mv.addObject("list",list);
		mv.addObject("cPage", cPage);
		mv.addObject("totalCount", totalCount);
		mv.setViewName("/member/adminPageMember");		
		
		return mv;
	}
	
	@RequestMapping("/adminPage/hospitalList.do")
	public ModelAndView hospitalList(@RequestParam(value="cPage",required=false,defaultValue="1") int cPage) {
		ModelAndView mv=new ModelAndView();
		int numPerPage=10;
		List<Hospital> list=service.selectHospitalList(cPage,numPerPage);
		
		int totalCount=service.selectHospitalCount();
		
		String pageBar=new PageCreate().getPageBar(cPage, numPerPage,totalCount,"hospitalList.do");
		
		mv.addObject("pageBar", pageBar);
		mv.addObject("list",list);
		mv.addObject("cPage", cPage);
		mv.addObject("totalCount", totalCount);
		mv.setViewName("/member/adminPageHospital");		
		
		return mv;
	}
	
}
