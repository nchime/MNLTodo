package com.mnlsolution.chime.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.mnlsolution.chime.model.Loginhistory;
import com.mnlsolution.chime.service.LoginhistoryService;


public class CustomerAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	
	@Autowired
	LoginhistoryService loginhistoryService;  
	
	
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		logger.info("***** 로그인 기록 {} {}", request.getParameter("loginid"), request.getParameter("password") );
		String loginidVal = request.getParameter("loginid"); 
		
		Loginhistory  loginhistory = new Loginhistory();
		loginhistory.setLoginId(loginidVal);
		loginhistory.setStatusCode("LOGIN");		
		
		loginhistoryService.insertLoginHistory(loginhistory);
		
		response.sendRedirect("/main/todolist");
	}

}
