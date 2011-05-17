package org.cafeboy.model;

import java.util.Date;

/**
 * Txplanprojaudit entity.
 * 
 * @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Txplanprojaudit implements java.io.Serializable {

	// Fields

	private String planprojauditid;
	private Txplaninfo txplaninfo;
	private String auditpersonid;
	private Long auditresult;
	private String auditcomment;
	private Date auditdate;
	private String state;

	// Constructors

	/** default constructor */
	public Txplanprojaudit() {
	}

	/** full constructor */
	public Txplanprojaudit(Txplaninfo txplaninfo, String auditpersonid, Long auditresult, String auditcomment, Date auditdate, String state) {
		this.txplaninfo = txplaninfo;
		this.auditpersonid = auditpersonid;
		this.auditresult = auditresult;
		this.auditcomment = auditcomment;
		this.auditdate = auditdate;
		this.state = state;
	}

	// Property accessors

	public String getPlanprojauditid() {
		return this.planprojauditid;
	}

	public void setPlanprojauditid(String planprojauditid) {
		this.planprojauditid = planprojauditid;
	}

	public Txplaninfo getTxplaninfo() {
		return this.txplaninfo;
	}

	public void setTxplaninfo(Txplaninfo txplaninfo) {
		this.txplaninfo = txplaninfo;
	}

	public String getAuditpersonid() {
		return this.auditpersonid;
	}

	public void setAuditpersonid(String auditpersonid) {
		this.auditpersonid = auditpersonid;
	}

	public Long getAuditresult() {
		return this.auditresult;
	}

	public void setAuditresult(Long auditresult) {
		this.auditresult = auditresult;
	}

	public String getAuditcomment() {
		return this.auditcomment;
	}

	public void setAuditcomment(String auditcomment) {
		this.auditcomment = auditcomment;
	}

	public Date getAuditdate() {
		return this.auditdate;
	}

	public void setAuditdate(Date auditdate) {
		this.auditdate = auditdate;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}