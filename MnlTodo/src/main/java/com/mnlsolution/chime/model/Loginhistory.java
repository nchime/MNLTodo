package com.mnlsolution.chime.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Loginhistory {
	

	@Id
	@GeneratedValue
	@Column(name = "lhidx")
	private Long lhIdx;

	@Column(name = "loginid", nullable=false, length = 20)
	private String loginId;
	
	
	/**
	 * login, logout 
	 */
	@Column(name = "statuscode", nullable=false, length = 10)
	private String statusCode;
	
	
	@Column(name = "regdate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private String regDate;


	public String getLoginId() {
		return loginId;
	}
	

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}


	public String getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}


	public String getRegDate() {
		return regDate;
	}


	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	@Override
	public String toString() {
		return "Loginhistory [lhIdx=" + lhIdx + ", loginId=" + loginId + ", statusCode=" + statusCode + ", regDate="
				+ regDate + "]";
	}
	

}
