package org.cafeboy.model;

import java.util.Date;

/**
 * Txfagreearea entity.
 * 
 * @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Txfagreearea implements java.io.Serializable {

	// Fields

	private String fagreeareaid;
	private Txfeasirecord txfeasirecord;
	private String projectid;
	private Date pcompanyad;
	private Double pcompanyam;
	private String pcagreeidea;
	private Long creatorid;
	private Date creatordate;
	private Long state;
	private Long apidea;

	// Constructors

	/** default constructor */
	public Txfagreearea() {
	}

	/** minimal constructor */
	public Txfagreearea(Long state) {
		this.state = state;
	}

	/** full constructor */
	public Txfagreearea(Txfeasirecord txfeasirecord, String projectid, Date pcompanyad, Double pcompanyam, String pcagreeidea, Long creatorid, Date creatordate, Long state, Long apidea) {
		this.txfeasirecord = txfeasirecord;
		this.projectid = projectid;
		this.pcompanyad = pcompanyad;
		this.pcompanyam = pcompanyam;
		this.pcagreeidea = pcagreeidea;
		this.creatorid = creatorid;
		this.creatordate = creatordate;
		this.state = state;
		this.apidea = apidea;
	}

	// Property accessors

	public String getFagreeareaid() {
		return this.fagreeareaid;
	}

	public void setFagreeareaid(String fagreeareaid) {
		this.fagreeareaid = fagreeareaid;
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

	public Date getPcompanyad() {
		return this.pcompanyad;
	}

	public void setPcompanyad(Date pcompanyad) {
		this.pcompanyad = pcompanyad;
	}

	public Double getPcompanyam() {
		return this.pcompanyam;
	}

	public void setPcompanyam(Double pcompanyam) {
		this.pcompanyam = pcompanyam;
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

	public Long getApidea() {
		return this.apidea;
	}

	public void setApidea(Long apidea) {
		this.apidea = apidea;
	}

}