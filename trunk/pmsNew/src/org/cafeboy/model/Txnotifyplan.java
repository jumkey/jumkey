package org.cafeboy.model;

/**
 * Txnotifyplan entity.
 * 
 * @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
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

	public String getNotifypsid() {
		return this.notifypsid;
	}

	public void setNotifypsid(String notifypsid) {
		this.notifypsid = notifypsid;
	}

	public Txbuildapply getTxbuildapply() {
		return this.txbuildapply;
	}

	public void setTxbuildapply(Txbuildapply txbuildapply) {
		this.txbuildapply = txbuildapply;
	}

	public Long getYear() {
		return this.year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public String getInvestsortid() {
		return this.investsortid;
	}

	public void setInvestsortid(String investsortid) {
		this.investsortid = investsortid;
	}

	public Double getInvestmoney() {
		return this.investmoney;
	}

	public void setInvestmoney(Double investmoney) {
		this.investmoney = investmoney;
	}

}