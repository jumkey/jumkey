package org.cafeboy.model;

import java.util.Date;

/**
 * Txfaprovince entity.
 * 
 * @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Txfaprovince implements java.io.Serializable {

	// Fields

	private String fapid;
	private Txfeasirecord txfeasirecord;
	private String projectid;
	private Date gcagreedate;
	private Double gcagreemoney;
	private String gcagreeidea;
	private Long creatorid;
	private Date creatordate;
	private Long state;
	private Long greeidea;

	// Constructors

	/** default constructor */
	public Txfaprovince() {
	}

	/** minimal constructor */
	public Txfaprovince(Long state) {
		this.state = state;
	}

	/** full constructor */
	public Txfaprovince(Txfeasirecord txfeasirecord, String projectid, Date gcagreedate, Double gcagreemoney, String gcagreeidea, Long creatorid, Date creatordate, Long state, Long greeidea) {
		this.txfeasirecord = txfeasirecord;
		this.projectid = projectid;
		this.gcagreedate = gcagreedate;
		this.gcagreemoney = gcagreemoney;
		this.gcagreeidea = gcagreeidea;
		this.creatorid = creatorid;
		this.creatordate = creatordate;
		this.state = state;
		this.greeidea = greeidea;
	}

	// Property accessors

	public String getFapid() {
		return this.fapid;
	}

	public void setFapid(String fapid) {
		this.fapid = fapid;
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

	public Date getGcagreedate() {
		return this.gcagreedate;
	}

	public void setGcagreedate(Date gcagreedate) {
		this.gcagreedate = gcagreedate;
	}

	public Double getGcagreemoney() {
		return this.gcagreemoney;
	}

	public void setGcagreemoney(Double gcagreemoney) {
		this.gcagreemoney = gcagreemoney;
	}

	public String getGcagreeidea() {
		return this.gcagreeidea;
	}

	public void setGcagreeidea(String gcagreeidea) {
		this.gcagreeidea = gcagreeidea;
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

	public Long getGreeidea() {
		return this.greeidea;
	}

	public void setGreeidea(Long greeidea) {
		this.greeidea = greeidea;
	}

}