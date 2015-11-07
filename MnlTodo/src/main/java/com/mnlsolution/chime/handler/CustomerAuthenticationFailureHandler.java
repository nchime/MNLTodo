package com.mnlsolution.chime.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class CustomerAuthenticationFailureHandler implements AuthenticationFailureHandler{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		
		logger.info("************ 사용자 로그인이 실패하였습니다 {} {}", request.getParameter("username"), request.getParameter("password") ); 
		
		response.sendRedirect("/login?error");
	}

}
