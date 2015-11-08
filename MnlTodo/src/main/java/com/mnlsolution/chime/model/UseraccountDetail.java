package com.mnlsolution.chime.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UseraccountDetail extends User {

	String eMail;
	String userName;
	String regDate;
	String updDate;

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getUpdDate() {
		return updDate;
	}

	public void setUpdDate(String updDate) {
		this.updDate = updDate;
	}

	public UseraccountDetail(Useraccount useraccount) {
		super(useraccount.getLoginId(), useraccount.getPassWd(), authorities(useraccount));
		// TODO Auto-generated constructor stub
	}

	private static Collection<? extends GrantedAuthority> authorities(Useraccount useraccount) {
		List<GrantedAuthority> authorities = new ArrayList<>();
//		authorities.add(new SimpleGrantedAuthority(useraccount.getRole()));
		authorities.add(new SimpleGrantedAuthority("ADMIN"));
		return authorities;
		
	}

}
