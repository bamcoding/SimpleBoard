package com.ktds.common.intercepter;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ktds.user.vo.UserVO;

public class LoginIntercepter extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

			HttpSession session = request.getSession();
			UserVO user = (UserVO) session.getAttribute("_USER_");
			if(user == null){
				PrintWriter out = response.getWriter();
				out.write("<script>");
				out.write("alert('Need your login!');");
				out.write("location.href='/SimpleBoard/login';");
				out.write("</script>");
				out.flush();
				out.close();
			}
		
		return super.preHandle(request, response, handler);
	}
}
