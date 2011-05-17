package org.cafeboy.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Txbuildaudit entity.
 * 
 * @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Txbuildaudit implements java.io.Serializable {

	// Fields

	private String buildauditid;
	private Txbuildapply txbuildapply;
	private String auditpersonid;
	private Long auditresult;
	private String auditcomment;
	private Date auditdate;
	private Long audittype;
	private String state;
	private Set<Txbuildjudge> txbuildjudges = new HashSet<Txbuildjudge>(0);

	// Constructors

	/** default constructor */
	public Txbuildaudit() {
	}

	/** minimal constructor */
	public Txbuildaudit(Txbuildapply txbuildapply) {
		this.txbuildapply = txbuildapply;
	}

	/** full constructor */
	public Txbuildaudit(Txbuildapply txbuildapply, String auditpersonid, Long auditresult, String auditcomment, Date auditdate, Long audittype, String state, Set<Txbuildjudge> txbuildjudges) {
		this.txbuildapply = txbuildapply;
		this.auditpersonid = auditpersonid;
		this.auditresult = auditresult;
		this.auditcomment = auditcomment;
		this.auditdate = auditdate;
		this.audittype = audittype;
		this.state = state;
		this.txbuildjudges = txbuildjudges;
	}

	// Property accessors

	public String getBuildauditid() {
		return this.buildauditid;
	}

	public void setBuildauditid(String buildauditid) {
		this.buildauditid = buildauditid;
	}

	public Txbuildapply getTxbuildapply() {
		return this.txbuildapply;
	}

	public void setTxbuildapply(Txbuildapply txbuildapply) {
		this.txbuildapply = txbuildapply;
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

	public Long getAudittype() {
		return this.audittype;
	}

	public void setAudittype(Long audittype) {
		this.audittype = audittype;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Set<Txbuildjudge> getTxbuildjudges() {
		return this.txbuildjudges;
	}

	public void setTxbuildjudges(Set<Txbuildjudge> txbuildjudges) {
		this.txbuildjudges = txbuildjudges;
	}

}