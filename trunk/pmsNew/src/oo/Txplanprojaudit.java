package org.cafeboy.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Txplanprojaudit entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TXPLANPROJAUDIT", schema = "JUMKEY")
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
	@Id
	@GeneratedValue
	@Column(name = "PLANPROJAUDITID", unique = true, nullable = false, length = 32)
	public String getPlanprojauditid() {
		return this.planprojauditid;
	}

	public void setPlanprojauditid(String planprojauditid) {
		this.planprojauditid = planprojauditid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PLANPROJID")
	public Txplaninfo getTxplaninfo() {
		return this.txplaninfo;
	}

	public void setTxplaninfo(Txplaninfo txplaninfo) {
		this.txplaninfo = txplaninfo;
	}

	@Column(name = "AUDITPERSONID", length = 32)
	public String getAuditpersonid() {
		return this.auditpersonid;
	}

	public void setAuditpersonid(String auditpersonid) {
		this.auditpersonid = auditpersonid;
	}

	@Column(name = "AUDITRESULT", precision = 1, scale = 0)
	public Long getAuditresult() {
		return this.auditresult;
	}

	public void setAuditresult(Long auditresult) {
		this.auditresult = auditresult;
	}

	@Column(name = "AUDITCOMMENT", length = 500)
	public String getAuditcomment() {
		return this.auditcomment;
	}

	public void setAuditcomment(String auditcomment) {
		this.auditcomment = auditcomment;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "AUDITDATE", length = 7)
	public Date getAuditdate() {
		return this.auditdate;
	}

	public void setAuditdate(Date auditdate) {
		this.auditdate = auditdate;
	}

	@Column(name = "STATE", length = 10)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}