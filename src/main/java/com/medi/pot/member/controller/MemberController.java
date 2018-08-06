package com.medi.pot.member.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.ServletOutputStream;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.medi.pot.common.page.PageCreate;
import com.medi.pot.member.model.service.MemberService;
import com.medi.pot.member.model.vo.Hospital;
import com.medi.pot.member.model.vo.Member;
import com.medi.pot.reservation.model.vo.DoctorInfo;
import com.medi.pot.reservation.model.vo.HospitalInfo;


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
	public String joinMemeber(Model model) {
		System.out.println("회원가입(개인)으로 들어옴");
		
		return "member/member";
	}
	
	@RequestMapping("/member/memberEnrollEnd.do")
	public String joinMemberEnd(Member m, Model model) {
		System.out.println("회원가입(개인)을 실행함");
		String msg = "";
		String loc = "";
		
		boolean checkid = service.checkId(m.getMemberId())==0?true:false;
		boolean checkemail = service.checkEmail(m.getMemberEmail())==0?true:false;
		
		if(!checkid) {
			msg = "해당 아이디는 이미 존재합니다.";
			
			model.addAttribute("msg", msg);
			model.addAttribute("loc", loc);
			
			return "common/msg";
		}
		
		if(!checkemail) {
			msg = "해당 이메일은 이미 존재합니다.";
			
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
			msg = "회원가입성공!";
		} else {
			msg = "회원가입실패!";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("loc", loc);
		
		return "common/msg";
	}

	@RequestMapping("/member/joinHospitalStart.do")
	public String joinHospital1() {
		System.out.println("회원가입(병원-승인전)으로 들어옴");
		return "member/hospital";
	}
	
	@RequestMapping("/member/hospitalEnrollEnd.do")
	public String joinHospital1(Model model,
			String hospitalId, String hospitalPw, String hospitalName,
			String hospitalTel, String hospitalEmail, String hospitalAddr,
			HttpServletRequest request,@RequestParam(value="hospitalLicense",required=false) MultipartFile hospitalLicense) {
		
		System.out.println("회원가입(병원-승인중)으로 들어옴");

		String msg="";
		String loc="";
		
		Hospital h = new Hospital(
				0, hospitalId, hospitalPw, hospitalName,
				null, null, hospitalTel, hospitalEmail,
				hospitalAddr, null, 0, null, null);
		
		//파일 업로드
		//저장위치지정
		String saveDir=request.getSession().getServletContext().getRealPath("/resources/uploadfile/H_License");
		
		File dir=new File(saveDir);
		if(dir.exists()==false) System.out.println(dir.mkdirs());//폴더생성
		System.out.println(hospitalLicense);
		if(!hospitalLicense.isEmpty()) {
		String originalFileName=hospitalLicense.getOriginalFilename();
		
		//확장자 구하기
		String ext=originalFileName.substring(originalFileName.lastIndexOf(".")+1);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
		int rndNum=(int)(Math.random()*1000);
		String renamedFileName=sdf.format(new Date(System.currentTimeMillis()));
		renamedFileName+="_"+rndNum+"."+ext;
		try 
		{
			hospitalLicense.transferTo(new File(saveDir+File.separator+renamedFileName));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
			//DB에 저장할 첨부파일에 대한 정보를 구성!
			h.setHospitalLicense(originalFileName);
			h.setHospitalReLicense(renamedFileName);
		}
		
		boolean checkid = service.checkHospitalId(h.getHospitalId())==0?true:false;
		boolean checkemail = service.checkHospitalEmail(h.getHospitalEmail())==0?true:false;
		
		if(!checkid) {
			msg = "해당 아이디는 사용이 불가능합니다.";

			model.addAttribute("msg", msg);
			model.addAttribute("loc", loc);

			return "common/msg";
		}
		if(!checkemail) {
			msg = "해당 이메일은 이미 존재합니다.";
			
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
	
	@RequestMapping("/member/hospitalFileDownload.do")
	public void fileDownload(String oName, String rName, HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("원본파일 : " + oName + "\n사본파일 : " + rName);
		oName = oName.trim();
		rName = rName.trim();
		//스트림 생성
		BufferedInputStream bis=null;
		ServletOutputStream sos=null;
		//저장경로
		String savedDir=request.getSession().getServletContext().getRealPath("/resources/uploadfile/H_License");
		File savedFile=new File(savedDir+File.separator+rName);
		System.out.println("경로확인 : " + savedDir);
		try {
			FileInputStream fis=new FileInputStream(savedFile);
			bis=new BufferedInputStream(fis);
			sos=response.getOutputStream();
			
			String resFilename="";
			//브라우저 분기
			boolean isMSIE=request.getHeader("user-agent").indexOf("MSIE")!=-1
					||request.getHeader("user-agent").indexOf("Trident")!=-1;
			if(isMSIE) {
				resFilename=URLEncoder.encode(oName, "UTF-8");
				resFilename=resFilename.replaceAll("\\", "%20");
			}
			else {
				resFilename=new String(oName.getBytes("UTF-8"),"ISO-8859-1");
			}
			response.setContentType("application/otect-stream;charset=UTF-8");
			response.setHeader("Content-Disposition", "attachment;filename=\""+resFilename+"\"");
			response.setContentLength((int)savedFile.length());
			//파일 읽어와서 전송하기
			int read=-1;
			while((read=bis.read())!=-1) {
				sos.write(read);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				sos.close();
				bis.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	@RequestMapping("/member/joinpermission.do")
	public String joinPermission() {
		System.out.println("회원가입(병원-승인중)으로 들어옴");
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
		return "member/findPassword";
	}
	
	@RequestMapping("/member/memberLogin.do")
	public String login(String PnH, @RequestParam(value="memberId") String memberId,@RequestParam(value="memberPw") String memberPw, Model model, HttpServletRequest req) {
		System.out.println("로그인을 실행.." + PnH + "..." + memberId + "..." + memberPw);
		// P = 개인 (Person)
		// H = 병원 (Hospital)
		String msg = "";
		String loc = "/";
		boolean PnHcheck = false;
		
		Member m = new Member();
		Hospital h = new Hospital();
		System.out.println(service.loginMemberCheck(memberId));
		
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
		}
		if(PnH.equals("H")){
			h = service.loginHospitalCheck(memberId);
			if(h==null) {
				
			}else {
				String hos_admi = h.getHospitalAdmission();
				HospitalInfo hospitalInfo = null; //service.selectHospitalInfo(h.getHospitalNum());
				DoctorInfo doctorInfo = null; //service.selectDoctorInfo(h.getHospitalNum());
				
				if(bcrypt.matches(memberPw, h.getHospitalPw())) {
					model.addAttribute("memberLoggedIn",h);
					model.addAttribute("checkPH","H");
					model.addAttribute("hospitalAdmission",hos_admi);
					model.addAttribute("hospitalInfo",hospitalInfo);
					model.addAttribute("doctorInfo",doctorInfo);
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
			// 세션이 진행중이라면 (존재한다면)
			sessionStatus.setComplete();
			// 세션을 완료시킨다 (끝낸다)
		}
		
		return "redirect:/";
	}
	
	@RequestMapping("/member/mypage.do")
	public String adminPage(String user_id, String checkPH, Model model) {
		System.out.println("마이페이지 들어옴");
		String view = "";
		if(user_id.equals("admin")) {
			view = "member/adminPage";
			int result = service.hospitalCount();
			model.addAttribute("hoscnt",result);
		} else {
			if(checkPH.equals("P")) {
				view = "member/memberPage";
			}else {
				view = "member/hospitalPage";
			}
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
	
	@RequestMapping("/member/memberPageUpdate.do")
	public String memberPageUpdate(Member m, Model model) {
		String msg = "수정 실패";
		String loc = "";
		int result = service.memberPageUpdate(m);
		
		if(result > 0) {
			msg = "수정 성공";
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
			idpw.put("newPassword", newPassword);
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
	
	@RequestMapping("/member/emailEnd.do")
	public String emailResponse(String memberEmail, Model model) {

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", 465);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("ppj1017@gmail.com", "ahfmrqhd1!a");
			}
		});
		int ra=0;
	      
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("ppj1017@gmail.com",MimeUtility.encodeText("MediPot 관리자","UTF-8","B")));
	            

			//수신자메일주소
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(memberEmail)); 

			// Subject
			message.setSubject("MediPot 메일 인증"); //메일 제목을 입력

			// Text
	               
			while(true) {
				ra=(int)(Math.random()*10000);
				if(ra>1000) {
					break;
				}
			}
			//메일 내용을 입력
			message.setContent(
					"<img src='https://postfiles.pstatic.net/MjAxODA4MDZfMzgg/MDAxNTMzNTMzNTY5NzIz.NvFjNK3gSOcpuQgDt1_-ParNMjv5nunUq2ixh-kO6yMg.91NYgDKHmA_UkPSzzAK5lC7cYehF23PQvmj6hIP2cLwg.PNG.ahfmrqhd/MediPot_logo.png?type=w966'>"
					+ "<br><h3>MediPot 인증번호 [<b style='color: red'>" + ra + "</b>]</h3>"
					, "text/html; charset=UTF-8");
			
			
			
			// send the message
			Transport.send(message); ////전송
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		model.addAttribute("ra", ra);
		
		return "member/emailEnd";
	}
	
	@RequestMapping("/member/PcheckEmail.do")
	@ResponseBody
	public void membercheckEmail(String memberEmail,HttpServletResponse res) throws Exception {
		
		boolean check = service.duplicateMemEmailCheck(memberEmail)==0?true:false;
		res.getWriter().print(check);
	}
	
	@RequestMapping("/member/HcheckEmail.do")
	@ResponseBody
	public void HospitalcheckEmail(String hospitalEmail,HttpServletResponse res) throws Exception {
		
		boolean check = service.duplicateMemEmailCheck(hospitalEmail)==0?true:false;
		res.getWriter().print(check);
	}
	
	@RequestMapping("/member/findCheckEmail.do")
	@ResponseBody
	public void memberFindCheckEmail(String PnH, String memberEmail,HttpServletResponse res) throws Exception {
		boolean check = false;
		if(PnH.equals("P")) {
			check = service.FindMemEmailCheck(memberEmail)==1?true:false;			
		} else {
			//check = service.FindHosmEmailCheck(memberEmail)==1?true:false;
		}
		res.getWriter().print(check);
	}
	
	@RequestMapping("/member/FindemailEnd.do")
	public String FindemailResponse(String memberEmail, Model model) {

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", 465);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("ppj1017@gmail.com", "ahfmrqhd1!a");
			}
		});
		int ra=0;
	      
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("ppj1017@gmail.com",MimeUtility.encodeText("MediPot 관리자","UTF-8","B")));
	            

			//수신자메일주소
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(memberEmail)); 

			// Subject
			message.setSubject("MediPot 메일 인증"); //메일 제목을 입력

			// Text
	               
			while(true) {
				ra=(int)(Math.random()*10000);
				if(ra>1000) {
					break;
				}
			}
			
			message.setText("인증번호[ "+ra+" ]");    //메일 내용을 입력
			
			
			// send the message
			Transport.send(message); ////전송
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		model.addAttribute("ra", ra);
		
		return "member/emailEnd";
	}
	
	@RequestMapping("/member/memberFindId.do")
	public String FindIdprint(String findname, String findemail, Model model) {
		System.out.println("아이디를 찾음");
		String view="";
		Member m = service.searchName(findname);
		String findid = service.FindId(m);
		
		if(findid.equals(null)) {
			String msg = "회원 정보와 일치하는 아이디가 존재하지 않습니다.";
			String loc = "member/findid";
			model.addAttribute("msg",msg);
			model.addAttribute("loc",loc);
			view = "common/msg";
			return view;
		}
		else {
			view="member/findidprint";
		}
		
		model.addAttribute("findid",findid);
		
		return view;
	}
	
	@RequestMapping("/member/memberFindPw.do")
	public String memberFindPw(String findid, String findemail, Model model) {
		System.out.println("비밀번호를 찾음");
		String view="";
		System.out.println("아이디는?? " + findid);
		Member m = service.searchID(findid);
		
		if(m.getMemberEmail().equals(findemail)) {
			System.out.println("회원정보가 일치");
			view = "member/findPasswordprint";
			model.addAttribute("findid",findid);
			return view;
		}
		else {
			String msg = "회원정보가 일치하지 않습니다.\n이유 : 이메일이 다르다거나, 아이디가 다름";
			String loc = "member/findPassword";
			model.addAttribute("msg",msg);
			model.addAttribute("loc",loc);
			view="common/msg";
		}
		
		return view;
	}
	
	@RequestMapping("/member/FindPwUpdate.do")
	public String FindPwUpdate(String newPw, String memberId, Model model) {
		System.out.println("비밀번호 찾을 때 가져온 아이디 : " + memberId);
		Member m = service.searchID(memberId);
		System.out.println("새로운 비밀번호 : " + newPw);
		m.setMemberPw(bcrypt.encode(newPw));
		
		String msg = "";
		String loc = "";
		
		int result = service.MemberUpdate(m);
		
		if(result>0) {
			msg = "이제 로그인 하시면 됩니다.";
		}
		else {
			msg = "새로운 비밀번호를 받는 도중에 오류가 발생했습니다.";
		}
		
		model.addAttribute("msg",msg);
		model.addAttribute("loc",loc);
		
		return "common/msg";
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
	
	@RequestMapping("/adminPage/admission.do")
	public String admission(int hospitalNum, Model model) {
		int result = service.updateAdmission(hospitalNum);
		String msg="";
		String loc="adminPage/hospitalList.do";
		
		if(result>0) {
			msg="해당 병원을 승인하였습니다.";
		}else {
			msg="병원 승인에 실패하였습니다.";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("loc", loc);
		
		return "common/msg";
	}
	
}