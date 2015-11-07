package com.mnlsolution.chime.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class LoginController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/")
	public String home() {
		logger.info(">>>>>> root Controller");		
		return "redirect:/login";
	}
	
	@RequestMapping("/login")
	public String login() {
		logger.info(">>>>>> login Controller");
		
		return "login";
	}
	
	
	@RequestMapping("/main/todolist")
	public String todolist() {
		logger.info(">>>>>> todolist Controller");
		
		return "todolist";
	}

	
	@RequestMapping("/logout")
	public void logout() {
		logger.info(">>>>>> logout Controller");
		
	}

	
	
	
	
	
	
	
	
	
	@Value("${korname}")
	String korName;
	
	@Value("${engname}")
	String engName; 
	
	@RequestMapping("/test.do")
		public String root() {
		logger.info(" ************ root page");
		logger.info("==> {}", korName );
		logger.info("==> {}", engName );
		
		return "login"; 
	}

}
