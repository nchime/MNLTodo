package com.mnlsolution.chime.service;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.net.ntp.TimeStamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.mnlsolution.chime.model.Loginhistory;
import com.mnlsolution.chime.model.Useraccount;
import com.mnlsolution.chime.model.UseraccountDetail;
import com.mnlsolution.chime.repository.LoginhistoryRepository;
import com.mnlsolution.chime.repository.UserAccountRepository;

@Service
public class LoginhistoryService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private LoginhistoryRepository lhRepository;
	
	@Autowired
	private UserAccountRepository uaRepository; 
	
	public void insertLoginHistory(Loginhistory loginhistory, Authentication authentication) { 
		
/*		// 로그인 성공시에만 useraccount 날짜 정보 업데이트 
*/
		if(loginhistory.getStatusCode().equals("LOGIN")) { 
			
//			UseraccountDetail userDetail =  (UseraccountDetail) authentication.getPrincipal();
			Useraccount useraccount = uaRepository.findByloginId(loginhistory.getLoginId());
			
			Date date = new Date();
			Timestamp timestamp = new Timestamp(date.getTime());  
			useraccount.setUpdDate(timestamp);

			logger.info("-------------{} {} {}", useraccount.getLoginId(), useraccount.getRegDate(), timestamp);
			uaRepository.save(useraccount); 
			
		}
		
		// loginhistory 추가
		lhRepository.save(loginhistory); 
	}


}
