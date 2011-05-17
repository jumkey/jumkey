package org.cafeboy.model;

/**
 * Txbapplycontent entity.
 * 
 * @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
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

	public String getBapplycid() {
		return this.bapplycid;
	}

	public void setBapplycid(String bapplycid) {
		this.bapplycid = bapplycid;
	}

	public Txbuildapply getTxbuildapply() {
		return this.txbuildapply;
	}

	public void setTxbuildapply(Txbuildapply txbuildapply) {
		this.txbuildapply = txbuildapply;
	}

	public String getCcontent() {
		return this.ccontent;
	}

	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}

	public String getScale() {
		return this.scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getTerm() {
		return this.term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getCycle() {
		return this.cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

}