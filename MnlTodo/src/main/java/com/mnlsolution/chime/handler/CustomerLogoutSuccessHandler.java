package com.mnlsolution.chime.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.mnlsolution.chime.model.Loginhistory;
import com.mnlsolution.chime.service.LoginhistoryService;

public class CustomerLogoutSuccessHandler implements LogoutSuccessHandler  {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	LoginhistoryService loginhistoryService;  
	

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		logger.info("***** 로그아웃 기록 {}", authentication.getName() );
		
		String loginidVal = authentication.getName();
		
		Loginhistory  loginhistory = new Loginhistory();
		loginhistory.setLoginId(loginidVal);
		loginhistory.setStatusCode("LOGOUT");		
		
		loginhistoryService.insertLoginHistory(loginhistory);
		
		response.sendRedirect("/");

		
		
	}

}
