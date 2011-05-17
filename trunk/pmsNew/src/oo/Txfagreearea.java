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
 * Txfagreearea entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TXFAGREEAREA", schema = "JUMKEY")
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
	@Id
	@GeneratedValue
	@Column(name = "FAGREEAREAID", unique = true, nullable = false, length = 32)
	public String getFagreeareaid() {
		return this.fagreeareaid;
	}

	public void setFagreeareaid(String fagreeareaid) {
		this.fagreeareaid = fagreeareaid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FEASIYRECORDID")
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
	@Column(name = "PCOMPANYAD", length = 7)
	public Date getPcompanyad() {
		return this.pcompanyad;
	}

	public void setPcompanyad(Date pcompanyad) {
		this.pcompanyad = pcompanyad;
	}

	@Column(name = "PCOMPANYAM", precision = 14)
	public Double getPcompanyam() {
		return this.pcompanyam;
	}

	public void setPcompanyam(Double pcompanyam) {
		this.pcompanyam = pcompanyam;
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

	@Column(name = "APIDEA", precision = 2, scale = 0)
	public Long getApidea() {
		return this.apidea;
	}

	public void setApidea(Long apidea) {
		this.apidea = apidea;
	}

}