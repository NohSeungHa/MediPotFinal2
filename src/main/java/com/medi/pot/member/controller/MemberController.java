package com.medi.pot.member.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
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
import com.medi.pot.member.model.vo.DoctorInfos;
import com.medi.pot.member.model.vo.Hospital;
import com.medi.pot.member.model.vo.HospitalInfos;
import com.medi.pot.member.model.vo.Member;
import com.medi.pot.reservation.model.vo.DoctorInfo;
import com.medi.pot.reservation.model.vo.HospitalInfo;


@SessionAttributes(value={"memberLoggedIn", "checkPH", "emailCheck", "H_Info_Count", "InfoCheck", "infoEnter"})

@Controller
public class MemberController {
		
	int H_Info_Count = 1;
	String InfoCheck = "";
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	/* 회원가입을 클릭 */
	@RequestMapping("/member/join.do")
	public String join() {
		System.out.println("회원가입으로 들어옴");
		return "member/join";
	}
	
	
	/* 회원가입(개인)을 클릭 */
	@RequestMapping("/member/joinMember.do")
	public String joinMemeber(Model model) {
		System.out.println("회원가입(개인)으로 들어옴");
		
		return "member/member";
	}
	
	
	/* 회원가입(개인)을 실행 */
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
	
	
	/* 회원가입(병원)을 클릭 */
	@RequestMapping("/member/joinHospitalStart.do")
	public String joinHospital1() {
		System.out.println("회원가입(병원-승인전)으로 들어옴");
		return "member/hospital";
	}
	
	
	/* 회원가입(병원)을 실행 */
	@RequestMapping("/member/hospitalEnrollEnd.do")
	public String joinHospital1(Model model,
			String hospitalId, String hospitalPw, String hospitalName,
			String hospitalTel, String hospitalEmail, String hospitalAddr, String[] professional,
			HttpServletRequest request,@RequestParam(value="hospitalLicense",required=false) MultipartFile hospitalLicense) {
		
		System.out.println("회원가입(병원-승인중)으로 들어옴");

		String msg="";
		String loc="";
		
		Hospital h = new Hospital(
				0, hospitalId, hospitalPw, hospitalName,
				null, null, hospitalTel, hospitalEmail,
				hospitalAddr, null, 0, null, professional);
		
		if(hospitalLicense !=null) {
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
	
	
	/* 병원회원의 사업자번호를 클릭(다운로드) */
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
	
	
	/* 병원회원의 승인 전 화면 */
	@RequestMapping("/member/joinpermission.do")
	public String joinPermission() {
		System.out.println("회원가입(병원-승인중)으로 들어옴");
		return "member/permission";
	}
	
	
	/* 병원회원 화면 확인중... */
	@RequestMapping("/member/joinHospitalEnd.do")
	public String joinHospital2() {
		System.out.println("회원가입(병원-승인중)으로 들어옴");
		return "redirect:/";
	}
	
	
	/* 로그인을 실행 */
	@RequestMapping("/member/memberLogin.do")
	public String login(String PnH, @RequestParam(value="memberId") String memberId,@RequestParam(value="memberPw") String memberPw, Model model, HttpServletRequest req) {
		System.out.println("로그인을 실행.." + PnH + "..." + memberId + "..." + memberPw);
		// P = 개인 (Person)
		// H = 병원 (Hospital)
		String msg = "로그인 실패!";
		String loc = "/";
		H_Info_Count=1;
		
		Member m = new Member();
		Hospital h = new Hospital();
		
		if(PnH.equals("P")) {
			m = service.loginMemberCheck(memberId);
			
			if(m==null) {
				
			}else {
				if(bcrypt.matches(memberPw, m.getMemberPw())) {
					model.addAttribute("memberLoggedIn",m);
					model.addAttribute("checkPH","P");
					msg = "로그인 성공!";
				}
			}
		}
		if(PnH.equals("H")){
			h = service.loginHospitalCheck(memberId);
			if(h==null) {
				
			}else {
				String hos_admi = h.getHospitalAdmission();
				HospitalInfos hospitalInfo = service.selectHospitalInfo(h.getHospitalNum());
				System.out.println("hospitalInfo -> \n" + hospitalInfo);
				if(bcrypt.matches(memberPw, h.getHospitalPw())) {
					model.addAttribute("memberLoggedIn",h);
					model.addAttribute("checkPH","H");
					model.addAttribute("hospitalAdmission",hos_admi);
					if(hospitalInfo != null) {
						InfoCheck = "yes";
						model.addAttribute("InfoCheck",InfoCheck);
					}
					if(hospitalInfo == null){
						InfoCheck = "no";
						model.addAttribute("InfoCheck",InfoCheck);
					}
					
					if(hos_admi.equals("0")) {
						return "member/permission";
					}
					
					model.addAttribute("H_Info_Count", H_Info_Count);
					msg = "로그인 성공!";
					
				}
			}
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("loc", loc);
		return "common/msg";
	}
	
	
	/* 로그아웃을 실행 */
	@RequestMapping("/member/memberLogout.do")
	public String logout(SessionStatus sessionStatus) {
		System.out.println("로그아웃을 진행");
		if(!sessionStatus.isComplete()) {
			// 세션이 진행중이라면 (존재한다면)
			sessionStatus.setComplete();
			// 세션을 완료시킨다 (끝낸다)
		}
		H_Info_Count--;
		
		return "redirect:/";
	}
	
	
	/* 병원정보체크를 위한 카운트 */
	@RequestMapping("/member/infoCount.do")
	public String infoCount(int hospitalNum, Model model) {
		
		boolean infochk = service.loadHospitalInfo(hospitalNum)==1?true:false;
		if(infochk) {
			InfoCheck = "yes";
			model.addAttribute("InfoCheck", InfoCheck);
		}
		H_Info_Count++;
		model.addAttribute("H_Info_Count", H_Info_Count);
		
		return "redirect:/";
	}
	
	
	/* 마이페이지 구별 */
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
				String pro = service.selectHospitalProfessional(user_id);
				String[] profes = pro.split(",");
				ArrayList<String> professional = new ArrayList<String>();
				for(int i = 0; i < profes.length; i++) {
					professional.add(profes[i]);
				}
				view = "member/hospitalPage";
				model.addAttribute("professional", professional);
			}
		}
		
		return view;
	}
	
	
	/* 관리자페이지에 일반회원 목록 */
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
	
	
	/* 관리자페이지에 병원회원 목록 */
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
	
	
	/* 일반회원의 아이디 중복체크 */
	@RequestMapping("/member/PcheckId.do")
	@ResponseBody
	public void membercheckId(String memberId,HttpServletResponse res) throws Exception {
		
		
		boolean check = service.duplicateMemIdCheck(memberId)==0?true:false;
		res.getWriter().print(check);
	}
	
	
	/* 병원회원의 아이디 중복체크 */
	@RequestMapping("/member/HcheckId.do")
	@ResponseBody
	public void hospitalcheckId(String hospitalId,HttpServletResponse res) throws Exception{
		boolean check = service.checkHospitalId(hospitalId)==0?true:false;
		res.getWriter().print(check);
	}
	
	
	/* 일반회원의 마이페이지 수정 */
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
	
	
	/* 일반 회원 탈퇴(회원 삭제시 헬프존 게시물과 함께 삭제(해당 게시물의 병원 댓글도 함께)) */
	@RequestMapping("/member/deleteMember.do")
	public String deleteMember() {
		System.out.println("일반 회원이 탈퇴를 들어옴");
		
		return "member/deleteMember";
	}
	
	
	/* 일반 회원 탈퇴를 실행 */
	@RequestMapping("/member/deleteMemberEnd.do")
	public String deleteMemberEnd(String memberId, String memberPw, Model model, SessionStatus sessionStatus) {
		System.out.println("회원탈퇴를 실행함");
		String msg = "아이디와 비밀번호가 일치하지 않아 삭제하지 못했습니다.";
		String loc = "";
		
		Member m = service.selectMember(memberId);
		if(m != null) {
			if(bcrypt.matches(memberPw, m.getMemberPw())) {
				msg = "삭제 성공";
				int result = service.deleteMember(m.getMemberNum());
				sessionStatus.setComplete();
			}
		}
		else {
			msg = "해당 아이디는 존재하지 않습니다.";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("loc", loc);
		
		return "common/msg";
	}
	
	
	/* 병원회원이 마이페이지 수정을 실행 */
	@RequestMapping("/member/hospitalUpdate.do")
	public String hospitalUpdate(int hospitalNum, String hospitalName, String hospitalTel, String hospitalAddr, String[] professional, Model model,
			HttpServletRequest request,@RequestParam(value="hospitalLicense",required=false) MultipartFile hospitalLicense) {
		System.out.println("병원회원이 수정을 실행함");
		String msg = "수정 실패!";
		String loc = "";
		
		Hospital hospital = service.selectHospital(hospitalNum); 
		
		if(hospitalLicense !=null) {
			// 이전 파일을 삭제
			File deletefile = new File("C:\\Medipot_Git\\MediPotFinal2\\src\\main\\webapp\\resources\\uploadfile\\H_License\\"+hospital.getHospitalReLicense());
			deletefile.delete();
			
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
				hospital.setHospitalLicense(originalFileName);
				hospital.setHospitalReLicense(renamedFileName);
			}
		}
		
		hospital.setHospitalName(hospitalName);
		hospital.setHospitalTel(hospitalTel);
		hospital.setHospitalAddr(hospitalAddr);
		hospital.setHospitalProfessional(professional);
		
		int result = service.hospitalUpdate(hospital);
		
		if(result > 0) {
			msg = "회원 수정 성공!";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("loc", loc);
		
		return "common/msg";
	}
	
	
	/*병원 회원 탈퇴 */
	@RequestMapping("/member/deleteHospital.do")
	public String deleteHospital(Model model) {
		System.out.println("병원 회원이 탈퇴를 들어옴");
		
		return "member/deleteHospital";
	}
	
	
	/*병원회원 탈퇴 실행*/
	@RequestMapping("/member/deleteHospitalEnd.do")
	public String deleteHospitalEnd(String hospitalId, String hospitalPw, Model model, SessionStatus sessionStatus) {
		System.out.println("병원회원탈퇴를 실행함");
		String msg = "아이디와 비밀번호가 일치하지 않아 삭제하지 못했습니다.";
		String loc = "";
		
		Hospital h = service.selectFindHospital(hospitalId);
		if(h != null) {
			if(bcrypt.matches(hospitalPw, h.getHospitalPw())) {
				msg = "삭제 성공";
				String deleteStr1 = service.selectDoctorPhoto(h.getHospitalNum()); // 의사 사진 삭제
				service.deleteDoctors(h.getHospitalNum());
				File deleteFile = new File("C:\\Medipot_Git\\MediPotFinal2\\src\\main\\webapp\\resources\\uploadfile\\dortors\\"+deleteStr1);
				deleteFile.delete();
				
				String deleteStr2 = service.selectHospitalInfoPhoto(h.getHospitalNum()); // 병원 사진 삭제
				service.deleteHospitalInfo(h.getHospitalNum());
				deleteFile = new File("C:\\Medipot_Git\\MediPotFinal2\\src\\main\\webapp\\resources\\uploadfile\\hospitalInfo\\"+deleteStr2);
				deleteFile.delete();
				
				String deleteStr3 = service.selectHospitalLicense(h.getHospitalNum()); // 병원 회원 사업자번호 사진 삭제
				service.updateHospital(h.getHospitalNum());
				deleteFile = new File("C:\\Medipot_Git\\MediPotFinal2\\src\\main\\webapp\\resources\\uploadfile\\H_License\\"+deleteStr3);
				deleteFile.delete();
				
				sessionStatus.setComplete();
			}
		}
		else {
			msg = "해당 아이디는 존재하지 않습니다.";
		}
		model.addAttribute("msg", msg);
		model.addAttribute("loc", loc);
		
		return "common/msg";
	}
	
	
	/* 일반회원의 비밀번호 수정 */
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
	
	
	/* 비밀번호 수정 시 해당 회원의 화면으로 이동(병원, 일반) */
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
	
	
	/* 각 회원의 이메일 인증 */
	@RequestMapping("/member/emailEnd.do")
	public String emailResponse(String UserEmail, Model model) {

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
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(UserEmail)); 

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
			e.printStackTrace();
		} 
		
		model.addAttribute("ra", ra);
		model.addAttribute("UserEmail", UserEmail);
		
		return "member/emailEnd";
	}
	
	
	/* 일반회원의 이메일이 중복인지 체크 */
	@RequestMapping("/member/PcheckEmail.do")
	@ResponseBody
	public void membercheckEmail(String memberEmail,HttpServletResponse res) throws Exception {
		
		boolean check = service.duplicateMemEmailCheck(memberEmail)==0?true:false;
		res.getWriter().print(check);
	}
	
	
	/* 병원회원의 이메일이 중복인지 체크 */
	@RequestMapping("/member/HcheckEmail.do")
	@ResponseBody
	public void HospitalcheckEmail(String hospitalEmail,HttpServletResponse res) throws Exception {
		
		boolean check = service.duplicateMemEmailCheck(hospitalEmail)==0?true:false;
		res.getWriter().print(check);
	}
	
	
	/* 아이디 찾기로 들어옴 */
	@RequestMapping("/member/findId.do")
	public String findid() {
		System.out.println("아이디찾기로 들어옴");
		return "member/findid";
	}
	
	
	/* 비밀번호 찾기로 들어옴 */
	@RequestMapping("/member/findPassword.do")
	public String findpassword() {
		System.out.println("비밀번호찾기로 들어옴");
		return "member/findPassword";
	}
	
	
	/* 찾기 중 입력한 이메일과 정보가 일치한지 */
	@RequestMapping("/member/findCheckEmail.do")
	@ResponseBody
	public void memberFindCheckEmail(String PnH, String memberEmail,HttpServletResponse res) throws Exception {
		boolean check = false;
		if(PnH.equals("P")) {
			check = service.FindMemEmailCheck(memberEmail)==1?true:false;			
		} else {
			check = service.FindHosEmailCheck(memberEmail)==1?true:false;
		}
		res.getWriter().print(check);
	}
	
	
	/* 아이디를 찾은 후 */
	@RequestMapping("/member/memberFindId.do")
	public String FindIdprint(String findname, String UserEmail, String findPnH, Model model) {
		System.out.println("아이디를 찾음");
		String msg = "";
		String loc = "";
		String view="";
		if(findPnH.equals("P")) {
			Member m = service.searchMemberName(findname);
			String findid = service.MemberFindId(m);
			if(m.getMemberEmail().equals(UserEmail)) {
				if(findid.equals(null)) {
					msg = "회원 정보와 일치하는 아이디가 존재하지 않습니다.";
					loc = "member/findid";
					model.addAttribute("msg",msg);
					model.addAttribute("loc",loc);
					view = "common/msg";
					return view;
				}
				else {
					view="member/findidprint";
					model.addAttribute("findid",findid);
				}
			}
		} else {
			Hospital h = service.searchHospitalName(findname);
			String findid = service.HospitalFindId(h);
			if(h.getHospitalEmail().equals(UserEmail)) {
				if(findid.equals(null)) {
					msg = "회원 정보와 일치하는 아이디가 존재하지 않습니다.";
					loc = "member/findid";
					model.addAttribute("msg",msg);
					model.addAttribute("loc",loc);
					view = "common/msg";
					return view;
				}
				else {
					view="member/findidprint";
					model.addAttribute("findid",findid);
				}
			}
		}
		
		return view;
	}
	
	
	/* 비밀번호를 찾음 */
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
	
	
	/* 비밀번호 찾기 후 수정 */
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
	
	
	/* 해당 병원 승인 시 */
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
	
	
	/* 병원정보 입력으로 들어옴 */
	@RequestMapping("/member/hospitalInfo.do")
	public String hospitalInfo(int hospitalNum, Model model) {
		System.out.println("병원정보 입력으로 들어옴!");
		String hospitalName = service.selecthospitalName(hospitalNum);
		model.addAttribute("hospitalName",hospitalName);
		model.addAttribute("hospitalNum", hospitalNum);
		
		return "member/hospitalInfoInsert";
	}
	
	
	/* 병원정보를 등록 */
	@RequestMapping("/member/hospitalInfoInsert.do")
	public String hosinfoInsert(
			int hospitalNum, String hospitalInfoIntro, String hospitalInfoNotice,
			String hospitalInfoUsetime, String hospitalInfoLunchtime,
			Model model, HttpServletRequest request,
			@RequestParam(value="hospitalPhoto",required=false) MultipartFile hospitalPhoto) {
		
		System.out.println("병원정보를 등록");
		HospitalInfos hospitalInfo = new HospitalInfos(
				hospitalNum, hospitalInfoIntro, hospitalInfoNotice, null, null, hospitalInfoUsetime, hospitalInfoLunchtime);
		
		System.out.println(hospitalInfo);
		String msg = "";
		String loc = "";
		
		if(hospitalPhoto != null) {
			//파일 업로드
			//저장위치지정
			String saveDir = request.getSession().getServletContext().getRealPath("/resources/uploadfile/hospitalInfo");
	
			File dir = new File(saveDir);
			if (dir.exists() == false)
				System.out.println(dir.mkdirs());// 폴더생성
			System.out.println(hospitalPhoto);
			if (!hospitalPhoto.isEmpty()) {
				String originalFileName = hospitalPhoto.getOriginalFilename();
	
				// 확장자 구하기
				String ext = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
				int rndNum = (int) (Math.random() * 1000);
				
				String renamedFileName = sdf.format(new Date(System.currentTimeMillis()));
				renamedFileName += "_" + rndNum + "." + ext;
				try {
					hospitalPhoto.transferTo(new File(saveDir + File.separator + renamedFileName));
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				// DB에 저장할 첨부파일에 대한 정보를 구성!
				hospitalInfo.setHospitalPhoto(originalFileName);
				hospitalInfo.setHospitalRePhoto(renamedFileName);
			}
		}
		
		int result = service.hospitalInfoinsert(hospitalInfo);
		
		if(result > 0) {
			msg = "병원정보 등록성공";
		} else {
			msg = "(잘못된 경로)이미 등록된 병원정보가 있습니다.";
		}
		model.addAttribute("infoEnter", "yes");
		model.addAttribute("msg",msg);
		model.addAttribute("loc",loc);
		
		return "common/msg";
	}
	
	
	/* 병원정보 수정으로 들어옴 */
	@RequestMapping("/member/hospitalInfoUpdate.do")
	public String hospitalInfoUpdate(int hospitalNum, Model model) {
		System.out.println("병원정보 수정으로 들어옴");
		
		HospitalInfos hospitalinfo = service.selectHospitalInfo(hospitalNum);
		String hospitalName = service.selecthospitalName(hospitalNum);
		
		model.addAttribute("hospitalName", hospitalName);
		model.addAttribute("hospitalInfo", hospitalinfo);
		
		return "member/hospitalInfoUpdatePage";
	}
	
	
	/* 병원정보 수정을 실행함 */
	@RequestMapping("/member/hospitalInfoUpdateEnd.do")
	public String hospitalInfoUpdateEnd(int hospitalNum, String hospitalInfoIntro,
			String hospitalInfoNotice, String hospitalInfoUsetime, String hospitalInfoLunchtime,
			Model model, HttpServletRequest request,
			@RequestParam(value="hospitalPhoto",required=false, defaultValue="null") MultipartFile hospitalPhoto) {
		System.out.println("병원정보 수정을 실행함");
		String msg = "";
		String loc = "";
		
		HospitalInfos hospitalInfo = service.selectHospitalInfo(hospitalNum);
		
		if(hospitalPhoto != null) {
			// 이전 파일을 삭제
			File deletefile = new File("C:\\Medipot_Git\\MediPotFinal2\\src\\main\\webapp\\resources\\uploadfile\\hospitalInfo\\"+hospitalInfo.getHospitalRePhoto());
			deletefile.delete();
			
			//저장위치지정
			String saveDir = request.getSession().getServletContext().getRealPath("/resources/uploadfile/hospitalInfo");
	
			File dir = new File(saveDir);
			if (dir.exists() == false)
				System.out.println(dir.mkdirs());// 폴더생성
			System.out.println(hospitalPhoto);
			if (!hospitalPhoto.isEmpty()) {
				String originalFileName = hospitalPhoto.getOriginalFilename();
	
				// 확장자 구하기
				String ext = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
				int rndNum = (int) (Math.random() * 1000);
				
				String renamedFileName = sdf.format(new Date(System.currentTimeMillis()));
				renamedFileName += "_" + rndNum + "." + ext;
				try {
					hospitalPhoto.transferTo(new File(saveDir + File.separator + renamedFileName));
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				// DB에 저장할 첨부파일에 대한 정보를 구성!
				hospitalInfo.setHospitalPhoto(originalFileName);
				hospitalInfo.setHospitalRePhoto(renamedFileName);
			}
		}
		
		hospitalInfo.setHospitalInfoIntro(hospitalInfoIntro);
		hospitalInfo.setHospitalInfoNotice(hospitalInfoNotice);
		hospitalInfo.setHospitalInfoUsetime(hospitalInfoUsetime);
		hospitalInfo.setHospitalInfoLunchtime(hospitalInfoLunchtime);
		
		int result = service.updateHospitalInfo(hospitalInfo);
		
		if(result > 0) {
			msg = "병원정보 수정 성공!";
		} else {
			msg = "병원정보 수정 실패";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("loc", loc);
		
		return "common/msg";
	}
	
	/* 의사정보를 입력하는 화면으로 들어옴 */
	@RequestMapping("/member/doctorInfoInsert.do")
	public String doctorInsert(int hospitalNum, Model model) {
		System.out.println("의사등록으로 들어옴");
		System.out.println(hospitalNum);
		Hospital hospital = service.selectHospital(hospitalNum);
		
		model.addAttribute("hospital", hospital);
		
		return "member/doctorInsert";
	}
	
	
	/* 의사정보 입력 */
	@RequestMapping("/member/doctorInfoInsertEnd.do")
	public String doctorInsertEnd(Model model, String doctorName,
			String doctorCareer, int hospitalNum, String[] professional,
			String doctorSlunch, String doctorElunch, String WeekdayStime,
			String WeekdayEtime, String SatStime, String SatEtime,
			String closed, String Specialized, String timeInterval, 
			@RequestParam(value="doctorPhoto", required=false) MultipartFile doctorPhoto,
			HttpServletRequest request) {
		
		System.out.println("의사등록을 실행");
		String msg = "";
		String loc = "";
		
		DoctorInfos doctorInfo = new DoctorInfos(0, doctorName, doctorCareer, hospitalNum, professional, doctorSlunch, doctorElunch, WeekdayStime, WeekdayEtime, SatStime, SatEtime, closed, Specialized, null, null, timeInterval);
		
		if(doctorPhoto != null) {
		
			String saveDir=request.getSession().getServletContext().getRealPath("/resources/uploadfile/dortors");
			
			File dir=new File(saveDir);
			if(dir.exists()==false) System.out.println(dir.mkdirs());//폴더생성
			System.out.println(doctorPhoto);
			if(!doctorPhoto.isEmpty()) {
			String originalFileName=doctorPhoto.getOriginalFilename();
			
			//확장자 구하기
			String ext=originalFileName.substring(originalFileName.lastIndexOf(".")+1);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
			int rndNum=(int)(Math.random()*1000);
			String renamedFileName=sdf.format(new Date(System.currentTimeMillis()));
			renamedFileName+="_"+rndNum+"."+ext;
			try 
			{
				doctorPhoto.transferTo(new File(saveDir+File.separator+renamedFileName));
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
				//DB에 저장할 첨부파일에 대한 정보를 구성!
				doctorInfo.setDoctorPhoto(originalFileName);
				doctorInfo.setDoctorRePhoto(renamedFileName);
			}
		}
		
		int result = service.doctorInfoInsert(doctorInfo);
		
		if(result > 0) {
			msg = "의사정보 추가 성공";
		}
		else {
			msg = "의사정보 추가 실패";
		}
		
		model.addAttribute("msg",msg);
		model.addAttribute("loc",loc);
		
		return "common/msg";
	}
	
	
	/* 의사정보 수정으로 들어옴 */
	@RequestMapping("/member/doctorInfoUpdate.do")
	public String doctorUpdate(int hospitalNum, Model model) {
		System.out.println("의사수정으로 들어옴");
		
		List<DoctorInfos> docinfo = service.selectDoctorInfo(hospitalNum);
		
		model.addAttribute("docinfo", docinfo);
		
		return "member/doctorsPage";
	}
	
	
	/* 의사 사진을 선택해서 의사 수정을 들어감 */
	@RequestMapping("/member/selectdoctor.do")
	public String selectDoctor(int doctorNum, Model model) {
		System.out.println(doctorNum);
		DoctorInfos doctorInfo = service.selectDoctorsPhoto(doctorNum);
		String pro = service.DoctorsProfessional(doctorNum);
		String hospitalName = service.hospitalNameDoctorNum(doctorNum);
		
		String[] professionalArray = pro.split(",");
		ArrayList<String> professional = new ArrayList();
		for(int i = 0; i < professionalArray.length; i++) {
			professional.add(professionalArray[i]);
		}
		
		model.addAttribute("hospitalName", hospitalName);
		model.addAttribute("doctorInfo", doctorInfo);
		model.addAttribute("professional", professional);
		
		return "member/doctorUpdatePage";
	}
	
	
	/* 의사 수정을 실행함 */
	@RequestMapping("/member/doctorInfoUpdateEnd.do")
	public String doctorUpdateEnd(Model model, String doctorName,
			String doctorCareer, String[] professional,
			String doctorSlunch, String doctorElunch, String weekdayStime,
			String weekdayEtime, String satStime, String satEtime,
			String closed, String specialized, String timeInterval, 
			@RequestParam(value="doctorPhoto", required=false, defaultValue="null") MultipartFile doctorPhoto,
			HttpServletRequest request, int doctorNum) {
		
		System.out.println("의사 수정을 실행함");
		String msg = "";
		String loc = "";
		
		DoctorInfos doctorInfo = service.selectDoctorsPhoto(doctorNum);
		
		if(doctorPhoto != null) {
			// 이전 파일을 삭제
			File deletefile = new File("C:\\Medipot_Git\\MediPotFinal2\\src\\main\\webapp\\resources\\uploadfile\\dortors\\"+doctorInfo.getDoctorRePhoto());
			deletefile.delete();
			
			String saveDir=request.getSession().getServletContext().getRealPath("/resources/uploadfile/dortors");
			
			File dir=new File(saveDir);
			if(dir.exists()==false) System.out.println(dir.mkdirs());//폴더생성
			System.out.println(doctorPhoto);
			if(!doctorPhoto.isEmpty()) {
			String originalFileName=doctorPhoto.getOriginalFilename();
			
			//확장자 구하기
			String ext=originalFileName.substring(originalFileName.lastIndexOf(".")+1);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
			int rndNum=(int)(Math.random()*1000);
			String renamedFileName=sdf.format(new Date(System.currentTimeMillis()));
			renamedFileName+="_"+rndNum+"."+ext;
			try 
			{
				doctorPhoto.transferTo(new File(saveDir+File.separator+renamedFileName));
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
				//DB에 저장할 첨부파일에 대한 정보를 구성!
				doctorInfo.setDoctorPhoto(originalFileName);
				doctorInfo.setDoctorRePhoto(renamedFileName);
			}
		}
		
		doctorInfo.setDoctorCareer(doctorCareer);
		doctorInfo.setProfessional(professional);
		doctorInfo.setDoctorSlunch(doctorSlunch);
		doctorInfo.setDoctorElunch(doctorElunch);
		doctorInfo.setWeekdayStime(weekdayStime);
		doctorInfo.setWeekdayEtime(weekdayEtime);
		doctorInfo.setSatStime(satStime);
		doctorInfo.setSatEtime(satEtime);
		doctorInfo.setClosed(closed);
		doctorInfo.setSpecialized(specialized);
		doctorInfo.setTimeInterval(timeInterval);
		
		int result = service.updateDoctorInfo(doctorInfo);
		
		if(result > 0) {
			msg = "의사 정보 수정성공!";
		} else {
			msg = "의사 정보 수정실패!";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("loc", loc);
		
		return "common/msg";
	}
	
}