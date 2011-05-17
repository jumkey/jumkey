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
 * Txfaprovince entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TXFAPROVINCE", schema = "JUMKEY")
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
	@Id
	@GeneratedValue
	@Column(name = "FAPID", unique = true, nullable = false, length = 32)
	public String getFapid() {
		return this.fapid;
	}

	public void setFapid(String fapid) {
		this.fapid = fapid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FRECORDID")
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
	@Column(name = "GCAGREEDATE", length = 7)
	public Date getGcagreedate() {
		return this.gcagreedate;
	}

	public void setGcagreedate(Date gcagreedate) {
		this.gcagreedate = gcagreedate;
	}

	@Column(name = "GCAGREEMONEY", precision = 14)
	public Double getGcagreemoney() {
		return this.gcagreemoney;
	}

	public void setGcagreemoney(Double gcagreemoney) {
		this.gcagreemoney = gcagreemoney;
	}

	@Column(name = "GCAGREEIDEA", length = 500)
	public String getGcagreeidea() {
		return this.gcagreeidea;
	}

	public void setGcagreeidea(String gcagreeidea) {
		this.gcagreeidea = gcagreeidea;
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

	@Column(name = "GREEIDEA", precision = 2, scale = 0)
	public Long getGreeidea() {
		return this.greeidea;
	}

	public void setGreeidea(Long greeidea) {
		this.greeidea = greeidea;
	}

}