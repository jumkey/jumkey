package org.cafeboy.model;

import java.util.Date;

/**
 * Txfeasijudge entity.
 * 
 * @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
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

	public String getFeasijudgeid() {
		return this.feasijudgeid;
	}

	public void setFeasijudgeid(String feasijudgeid) {
		this.feasijudgeid = feasijudgeid;
	}

	public Txfeasirecord getTxfeasirecord() {
		return this.txfeasirecord;
	}

	public void setTxfeasirecord(Txfeasirecord txfeasirecord) {
		this.txfeasirecord = txfeasirecord;
	}

	public String getProjectid() {
		return this.projectid;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}

	public Date getPcagreedate() {
		return this.pcagreedate;
	}

	public void setPcagreedate(Date pcagreedate) {
		this.pcagreedate = pcagreedate;
	}

	public Double getPcagreemoney() {
		return this.pcagreemoney;
	}

	public void setPcagreemoney(Double pcagreemoney) {
		this.pcagreemoney = pcagreemoney;
	}

	public String getPcagreeidea() {
		return this.pcagreeidea;
	}

	public void setPcagreeidea(String pcagreeidea) {
		this.pcagreeidea = pcagreeidea;
	}

	public Long getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(Long creatorid) {
		this.creatorid = creatorid;
	}

	public Date getCreatordate() {
		return this.creatordate;
	}

	public void setCreatordate(Date creatordate) {
		this.creatordate = creatordate;
	}

	public Long getState() {
		return this.state;
	}

	public void setState(Long state) {
		this.state = state;
	}

	public Long getJudgeidea() {
		return this.judgeidea;
	}

	public void setJudgeidea(Long judgeidea) {
		this.judgeidea = judgeidea;
	}

}