package com.medi.pot.common.page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.medi.pot.member.model.vo.Hospital;
import com.medi.pot.member.model.vo.Member;

public class Interceptor2 extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session=request.getSession();
		
		Member m=null;
		Hospital h=null;
		if(session.getAttribute("memberLoggedIn") instanceof Member ) {
			m=(Member)session.getAttribute("memberLoggedIn");
		}else {
			h=(Hospital)session.getAttribute("memberLoggedIn");
		}

		if(m==null && h==null) {
			request.setAttribute("msg", "로그인 후 이용 가능 합니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
			return false;
		}else if(m==null && h!=null ) {
			request.setAttribute("msg", "병원 회원은 예약이 불가능합니다.");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
			return false;
		}
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
	
	

}
