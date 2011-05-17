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
 * Txfeasijudge entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TXFEASIJUDGE", schema = "JUMKEY")
public class Txfeasijudge implements java.io.Serializable {

	// Fields

	private String feasijudgeid;
	private Txfeasirecord txfeasirecord;
	private String projectid;
	private Date pcagreedate;
	private Double pcagreemoney;
	private String pcagreeidea;
	private Long creatorid;
	private Date creatordate;
	private Long state;
	private Long judgeidea;

	// Constructors

	/** default constructor */
	public Txfeasijudge() {
	}

	/** minimal constructor */
	public Txfeasijudge(Long state) {
		this.state = state;
	}

	/** full constructor */
	public Txfeasijudge(Txfeasirecord txfeasirecord, String projectid, Date pcagreedate, Double pcagreemoney, String pcagreeidea, Long creatorid, Date creatordate, Long state, Long judgeidea) {
		this.txfeasirecord = txfeasirecord;
		this.projectid = projectid;
		this.pcagreedate = pcagreedate;
		this.pcagreemoney = pcagreemoney;
		this.pcagreeidea = pcagreeidea;
		this.creatorid = creatorid;
		this.creatordate = creatordate;
		this.state = state;
		this.judgeidea = judgeidea;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "FEASIJUDGEID", unique = true, nullable = false, length = 32)
	public String getFeasijudgeid() {
		return this.feasijudgeid;
	}

	public void setFeasijudgeid(String feasijudgeid) {
		this.feasijudgeid = feasijudgeid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FEASIRECORDID")
	public Txfeasirecord getTxfeasirecord() {
		return this.txfeasirecord;
	}

	public void setTxfeasirecord(Txfeasirecord txfeasirecord) {
		this.txfeasirecord = txfeasirecord;
	}

	@Column(name = "PROJECTID", length = 32)
	public String getProjectid() {
		return this.projectid;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "PCAGREEDATE", length = 7)
	public Date getPcagreedate() {
		return this.pcagreedate;
	}

	public void setPcagreedate(Date pcagreedate) {
		this.pcagreedate = pcagreedate;
	}

	@Column(name = "PCAGREEMONEY", precision = 14)
	public Double getPcagreemoney() {
		return this.pcagreemoney;
	}

	public void setPcagreemoney(Double pcagreemoney) {
		this.pcagreemoney = pcagreemoney;
	}

	@Column(name = "PCAGREEIDEA", length = 500)
	public String getPcagreeidea() {
		return this.pcagreeidea;
	}

	public void setPcagreeidea(String pcagreeidea) {
		this.pcagreeidea = pcagreeidea;
	}

	@Column(name = "CREATORID", precision = 20, scale = 0)
	public Long getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(Long creatorid) {
		this.creatorid = creatorid;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATORDATE", length = 7)
	public Date getCreatordate() {
		return this.creatordate;
	}

	public void setCreatordate(Date creatordate) {
		this.creatordate = creatordate;
	}

	@Column(name = "STATE", nullable = false, precision = 2, scale = 0)
	public Long getState() {
		return this.state;
	}

	public void setState(Long state) {
		this.state = state;
	}

	@Column(name = "JUDGEIDEA", precision = 2, scale = 0)
	public Long getJudgeidea() {
		return this.judgeidea;
	}

	public void setJudgeidea(Long judgeidea) {
		this.judgeidea = judgeidea;
	}

}