package org.cafeboy.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Txbuildaudit entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TXBUILDAUDIT", schema = "JUMKEY")
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
	@Id
	@GeneratedValue
	@Column(name = "BUILDAUDITID", unique = true, nullable = false, length = 32)
	public String getBuildauditid() {
		return this.buildauditid;
	}

	public void setBuildauditid(String buildauditid) {
		this.buildauditid = buildauditid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BUILDAPPLYID", nullable = false)
	public Txbuildapply getTxbuildapply() {
		return this.txbuildapply;
	}

	public void setTxbuildapply(Txbuildapply txbuildapply) {
		this.txbuildapply = txbuildapply;
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

	@Column(name = "AUDITTYPE", precision = 1, scale = 0)
	public Long getAudittype() {
		return this.audittype;
	}

	public void setAudittype(Long audittype) {
		this.audittype = audittype;
	}

	@Column(name = "STATE", length = 10)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "txbuildaudit")
	public Set<Txbuildjudge> getTxbuildjudges() {
		return this.txbuildjudges;
	}

	public void setTxbuildjudges(Set<Txbuildjudge> txbuildjudges) {
		this.txbuildjudges = txbuildjudges;
	}

}