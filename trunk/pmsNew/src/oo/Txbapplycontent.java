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
 * Txbapplycontent entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TXBAPPLYCONTENT", schema = "JUMKEY")
public class Txbapplycontent implements java.io.Serializable {

	// Fields

	private String bapplycid;
	private Txbuildapply txbuildapply;
	private String ccontent;
	private String scale;
	private String term;
	private String cycle;

	// Constructors

	/** default constructor */
	public Txbapplycontent() {
	}

	/** minimal constructor */
	public Txbapplycontent(Txbuildapply txbuildapply) {
		this.txbuildapply = txbuildapply;
	}

	/** full constructor */
	public Txbapplycontent(Txbuildapply txbuildapply, String ccontent, String scale, String term, String cycle) {
		this.txbuildapply = txbuildapply;
		this.ccontent = ccontent;
		this.scale = scale;
		this.term = term;
		this.cycle = cycle;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "BAPPLYCID", unique = true, nullable = false, length = 32)
	public String getBapplycid() {
		return this.bapplycid;
	}

	public void setBapplycid(String bapplycid) {
		this.bapplycid = bapplycid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BUILDAPPLYID", nullable = false)
	public Txbuildapply getTxbuildapply() {
		return this.txbuildapply;
	}

	public void setTxbuildapply(Txbuildapply txbuildapply) {
		this.txbuildapply = txbuildapply;
	}

	@Column(name = "CCONTENT", length = 200)
	public String getCcontent() {
		return this.ccontent;
	}

	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}

	@Column(name = "SCALE", length = 500)
	public String getScale() {
		return this.scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	@Column(name = "TERM", length = 50)
	public String getTerm() {
		return this.term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	@Column(name = "CYCLE", length = 20)
	public String getCycle() {
		return this.cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

}