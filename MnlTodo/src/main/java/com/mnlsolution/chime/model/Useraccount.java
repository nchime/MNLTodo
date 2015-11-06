package com.mnlsolution.chime.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Useraccount {

	@Id
	@GeneratedValue
	private Long userIdx;

	@Column(name = "loginid", unique = true, length = 20)
	private String loginId;

	@Column(name = "passwd", nullable = false, length = 100)
	private String passWd;

	@Column(name = "username", nullable = true, length = 50)
	private String userName;

	@Column(name = "email", nullable = false, length = 50)
	private String eMail;

	@Column(name = "regdate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private String regDate;

	@Column(name = "upddate")
	private String updDate;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassWd() {
		return passWd;
	}

	public void setPassWd(String passWd) {
		this.passWd = passWd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
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

	@Override
	public String toString() {
		return "User [userIdx=" + userIdx + ", loginId=" + loginId + ", passWd=" + passWd + ", userName=" + userName
				+ ", eMail=" + eMail + ", regDate=" + regDate + ", updDate=" + updDate + "]";
	}

}