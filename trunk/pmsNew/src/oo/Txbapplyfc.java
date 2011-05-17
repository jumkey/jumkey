package org.cafeboy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Txbapplyfc entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TXBAPPLYFC", schema = "JUMKEY")
public class Txbapplyfc implements java.io.Serializable {

	// Fields

	private String bapplyfid;
	private Txbuildapply txbuildapply;
	private String mainres;
	private String totalcapacity;
	private String usedcapacity;
	private Double ration;
	private String forehayearc;
	private String foreyearc;

	// Constructors

	/** default constructor */
	public Txbapplyfc() {
	}

	/** minimal constructor */
	public Txbapplyfc(Txbuildapply txbuildapply) {
		this.txbuildapply = txbuildapply;
	}

	/** full constructor */
	public Txbapplyfc(Txbuildapply txbuildapply, String mainres, String totalcapacity, String usedcapacity, Double ration, String forehayearc, String foreyearc) {
		this.txbuildapply = txbuildapply;
		this.mainres = mainres;
		this.totalcapacity = totalcapacity;
		this.usedcapacity = usedcapacity;
		this.ration = ration;
		this.forehayearc = forehayearc;
		this.foreyearc = foreyearc;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "BAPPLYFID", unique = true, nullable = false, length = 32)
	public String getBapplyfid() {
		return this.bapplyfid;
	}

	public void setBapplyfid(String bapplyfid) {
		this.bapplyfid = bapplyfid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BUILDAPPLYID", nullable = false)
	public Txbuildapply getTxbuildapply() {
		return this.txbuildapply;
	}

	public void setTxbuildapply(Txbuildapply txbuildapply) {
		this.txbuildapply = txbuildapply;
	}

	@Column(name = "MAINRES", length = 100)
	public String getMainres() {
		return this.mainres;
	}

	public void setMainres(String mainres) {
		this.mainres = mainres;
	}

	@Column(name = "TOTALCAPACITY", length = 50)
	public String getTotalcapacity() {
		return this.totalcapacity;
	}

	public void setTotalcapacity(String totalcapacity) {
		this.totalcapacity = totalcapacity;
	}

	@Column(name = "USEDCAPACITY", length = 50)
	public String getUsedcapacity() {
		return this.usedcapacity;
	}

	public void setUsedcapacity(String usedcapacity) {
		this.usedcapacity = usedcapacity;
	}

	@Column(name = "RATION", precision = 5)
	public Double getRation() {
		return this.ration;
	}

	public void setRation(Double ration) {
		this.ration = ration;
	}

	@Column(name = "FOREHAYEARC", length = 50)
	public String getForehayearc() {
		return this.forehayearc;
	}

	public void setForehayearc(String forehayearc) {
		this.forehayearc = forehayearc;
	}

	@Column(name = "FOREYEARC", length = 50)
	public String getForeyearc() {
		return this.foreyearc;
	}

	public void setForeyearc(String foreyearc) {
		this.foreyearc = foreyearc;
	}

}