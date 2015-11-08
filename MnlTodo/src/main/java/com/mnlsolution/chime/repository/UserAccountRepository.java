package com.mnlsolution.chime.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mnlsolution.chime.model.Useraccount;


public interface UserAccountRepository extends JpaRepository<Useraccount, Long>{
	
	public Useraccount findByloginId(String loginId);
	
	

}
