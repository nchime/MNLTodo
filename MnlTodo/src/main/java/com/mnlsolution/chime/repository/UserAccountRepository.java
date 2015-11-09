package com.mnlsolution.chime.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mnlsolution.chime.model.Useraccount;


public interface UserAccountRepository extends JpaRepository<Useraccount, Long>{
	
	public Useraccount findByloginId(String loginId);

	// native qyuery sample  
	@Query(value="select loginid from (select loginid, currenttime from (select loginid, regdate, now() as currenttime  from useraccount  where loginid = ?1) as mem) as test", nativeQuery = true)
	public String findByCustomQueryName(String name);  
	

}
