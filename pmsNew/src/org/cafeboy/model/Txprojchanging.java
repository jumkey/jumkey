package org.cafeboy.model;

/**
 * Txprojchanging entity.
 * 
 * @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Txprojchanging implements java.io.Serializable {

	// Fields

	private String projchangingid;
	private Txproject txproject;
	private Long chingtype;
	private Double originalmoney;
	private Double aftcmoney;
	private String state;
	private String description;

	// Constructors

	/** default constructor */
	public Txprojchanging() {
	}

	/** full constructor */
	public Txprojchanging(Txproject txproject, Long chingtype, Double originalmoney, Double aftcmoney, String state, String description) {
		this.txproject = txproject;
		this.chingtype = chingtype;
		this.originalmoney = originalmoney;
		this.aftcmoney = aftcmoney;
		this.state = state;
		this.description = description;
	}

	// Property accessors

	public String getProjchangingid() {
		return this.projchangingid;
	}

	public void setProjchangingid(String projchangingid) {
		this.projchangingid = projchangingid;
	}

	public Txproject getTxproject() {
		return this.txproject;
	}

	public void setTxproject(Txproject txproject) {
		this.txproject = txproject;
	}

	public Long getChingtype() {
		return this.chingtype;
	}

	public void setChingtype(Long chingtype) {
		this.chingtype = chingtype;
	}

	public Double getOriginalmoney() {
		return this.originalmoney;
	}

	public void setOriginalmoney(Double originalmoney) {
		this.originalmoney = originalmoney;
	}

	public Double getAftcmoney() {
		return this.aftcmoney;
	}

	public void setAftcmoney(Double aftcmoney) {
		this.aftcmoney = aftcmoney;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}