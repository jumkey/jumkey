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
 * Txnotifyplan entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TXNOTIFYPLAN", schema = "JUMKEY")
public class Txnotifyplan implements java.io.Serializable {

	// Fields

	private String notifypsid;
	private Txbuildapply txbuildapply;
	private Long year;
	private String investsortid;
	private Double investmoney;

	// Constructors

	/** default constructor */
	public Txnotifyplan() {
	}

	/** full constructor */
	public Txnotifyplan(Txbuildapply txbuildapply, Long year, String investsortid, Double investmoney) {
		this.txbuildapply = txbuildapply;
		this.year = year;
		this.investsortid = investsortid;
		this.investmoney = investmoney;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "NOTIFYPSID", unique = true, nullable = false, length = 32)
	public String getNotifypsid() {
		return this.notifypsid;
	}

	public void setNotifypsid(String notifypsid) {
		this.notifypsid = notifypsid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BUILDAPPLYID")
	public Txbuildapply getTxbuildapply() {
		return this.txbuildapply;
	}

	public void setTxbuildapply(Txbuildapply txbuildapply) {
		this.txbuildapply = txbuildapply;
	}

	@Column(name = "YEAR", precision = 4, scale = 0)
	public Long getYear() {
		return this.year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	@Column(name = "INVESTSORTID", length = 32)
	public String getInvestsortid() {
		return this.investsortid;
	}

	public void setInvestsortid(String investsortid) {
		this.investsortid = investsortid;
	}

	@Column(name = "INVESTMONEY", precision = 20)
	public Double getInvestmoney() {
		return this.investmoney;
	}

	public void setInvestmoney(Double investmoney) {
		this.investmoney = investmoney;
	}

}