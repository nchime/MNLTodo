package com.mnlsolution.chime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnlsolution.chime.model.Loginhistory;
import com.mnlsolution.chime.repository.LoginhistoryRepository;

@Service
public class LoginhistoryService {
	
	
	@Autowired
	private LoginhistoryRepository lhRepository;
	
	
	public void insertLoginHistory(Loginhistory loginhistory) { 

		lhRepository.save(loginhistory); 
		
	}

	


}
