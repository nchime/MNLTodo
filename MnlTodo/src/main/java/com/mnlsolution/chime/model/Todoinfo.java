package com.mnlsolution.chime.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Todoinfo {

	@Id
	@GeneratedValue
	@Column(name = "tdidx")
	private Long tdIdx;

	@Column(name = "loginid", nullable = false, length = 20)
	private String loginId;

	/**
	 * 00 : 신규 등록, 01 : 완료 처리, 02 : 삭제
	 */
	@Column(name = "statuscode", nullable = false, length = 2)
	private String statusCode;

	@Column(name = "taskcontents", nullable = false, length = 100)
	private String taskContents;

	@Column(name = "regdate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date regDate;

	@Column(name = "upddate")
	private Date updDate;

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

	public String getTaskContents() {
		return taskContents;
	}

	public void setTaskContents(String taskContents) {
		this.taskContents = taskContents;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getUpdDate() {
		return updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	@Override
	public String toString() {
		return "Todoinfo [tdIdx=" + tdIdx + ", loginId=" + loginId + ", statusCode=" + statusCode + ", taskContents="
				+ taskContents + ", regDate=" + regDate + ", updDate=" + updDate + "]";
	}

}
