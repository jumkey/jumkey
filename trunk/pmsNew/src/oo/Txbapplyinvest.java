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
 * Txbapplyinvest entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TXBAPPLYINVEST", schema = "JUMKEY")
public class Txbapplyinvest implements java.io.Serializable {

	// Fields

	private String bapplyiid;
	private Txbuildapply txbuildapply;
	private String projcontent;
	private Double investment;
	private Double thisinvest;
	private Double forwardinvest;

	// Constructors

	/** default constructor */
	public Txbapplyinvest() {
	}

	/** minimal constructor */
	public Txbapplyinvest(Txbuildapply txbuildapply) {
		this.txbuildapply = txbuildapply;
	}

	/** full constructor */
	public Txbapplyinvest(Txbuildapply txbuildapply, String projcontent, Double investment, Double thisinvest, Double forwardinvest) {
		this.txbuildapply = txbuildapply;
		this.projcontent = projcontent;
		this.investment = investment;
		this.thisinvest = thisinvest;
		this.forwardinvest = forwardinvest;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "BAPPLYIID", unique = true, nullable = false, length = 32)
	public String getBapplyiid() {
		return this.bapplyiid;
	}

	public void setBapplyiid(String bapplyiid) {
		this.bapplyiid = bapplyiid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BUILDAPPLYID", nullable = false)
	public Txbuildapply getTxbuildapply() {
		return this.txbuildapply;
	}

	public void setTxbuildapply(Txbuildapply txbuildapply) {
		this.txbuildapply = txbuildapply;
	}

	@Column(name = "PROJCONTENT", length = 200)
	public String getProjcontent() {
		return this.projcontent;
	}

	public void setProjcontent(String projcontent) {
		this.projcontent = projcontent;
	}

	@Column(name = "INVESTMENT", precision = 14)
	public Double getInvestment() {
		return this.investment;
	}

	public void setInvestment(Double investment) {
		this.investment = investment;
	}

	@Column(name = "THISINVEST", precision = 14)
	public Double getThisinvest() {
		return this.thisinvest;
	}

	public void setThisinvest(Double thisinvest) {
		this.thisinvest = thisinvest;
	}

	@Column(name = "FORWARDINVEST", precision = 14)
	public Double getForwardinvest() {
		return this.forwardinvest;
	}

	public void setForwardinvest(Double forwardinvest) {
		this.forwardinvest = forwardinvest;
	}

}