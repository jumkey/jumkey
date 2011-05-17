package org.cafeboy.model;

/**
 * Txbapplyfc entity.
 * 
 * @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
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

	public String getBapplyfid() {
		return this.bapplyfid;
	}

	public void setBapplyfid(String bapplyfid) {
		this.bapplyfid = bapplyfid;
	}

	public Txbuildapply getTxbuildapply() {
		return this.txbuildapply;
	}

	public void setTxbuildapply(Txbuildapply txbuildapply) {
		this.txbuildapply = txbuildapply;
	}

	public String getMainres() {
		return this.mainres;
	}

	public void setMainres(String mainres) {
		this.mainres = mainres;
	}

	public String getTotalcapacity() {
		return this.totalcapacity;
	}

	public void setTotalcapacity(String totalcapacity) {
		this.totalcapacity = totalcapacity;
	}

	public String getUsedcapacity() {
		return this.usedcapacity;
	}

	public void setUsedcapacity(String usedcapacity) {
		this.usedcapacity = usedcapacity;
	}

	public Double getRation() {
		return this.ration;
	}

	public void setRation(Double ration) {
		this.ration = ration;
	}

	public String getForehayearc() {
		return this.forehayearc;
	}

	public void setForehayearc(String forehayearc) {
		this.forehayearc = forehayearc;
	}

	public String getForeyearc() {
		return this.foreyearc;
	}

	public void setForeyearc(String foreyearc) {
		this.foreyearc = foreyearc;
	}

}