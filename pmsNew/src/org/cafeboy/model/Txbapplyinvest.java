package org.cafeboy.model;

/**
 * Txbapplyinvest entity.
 * 
 * @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
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

	public String getBapplyiid() {
		return this.bapplyiid;
	}

	public void setBapplyiid(String bapplyiid) {
		this.bapplyiid = bapplyiid;
	}

	public Txbuildapply getTxbuildapply() {
		return this.txbuildapply;
	}

	public void setTxbuildapply(Txbuildapply txbuildapply) {
		this.txbuildapply = txbuildapply;
	}

	public String getProjcontent() {
		return this.projcontent;
	}

	public void setProjcontent(String projcontent) {
		this.projcontent = projcontent;
	}

	public Double getInvestment() {
		return this.investment;
	}

	public void setInvestment(Double investment) {
		this.investment = investment;
	}

	public Double getThisinvest() {
		return this.thisinvest;
	}

	public void setThisinvest(Double thisinvest) {
		this.thisinvest = thisinvest;
	}

	public Double getForwardinvest() {
		return this.forwardinvest;
	}

	public void setForwardinvest(Double forwardinvest) {
		this.forwardinvest = forwardinvest;
	}

}