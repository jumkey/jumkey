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
 * Txprojchanging entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TXPROJCHANGING", schema = "JUMKEY")
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
	@Id
	@GeneratedValue
	@Column(name = "PROJCHANGINGID", unique = true, nullable = false, length = 32)
	public String getProjchangingid() {
		return this.projchangingid;
	}

	public void setProjchangingid(String projchangingid) {
		this.projchangingid = projchangingid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECTID")
	public Txproject getTxproject() {
		return this.txproject;
	}

	public void setTxproject(Txproject txproject) {
		this.txproject = txproject;
	}

	@Column(name = "CHINGTYPE", precision = 1, scale = 0)
	public Long getChingtype() {
		return this.chingtype;
	}

	public void setChingtype(Long chingtype) {
		this.chingtype = chingtype;
	}

	@Column(name = "ORIGINALMONEY", precision = 14)
	public Double getOriginalmoney() {
		return this.originalmoney;
	}

	public void setOriginalmoney(Double originalmoney) {
		this.originalmoney = originalmoney;
	}

	@Column(name = "AFTCMONEY", precision = 14)
	public Double getAftcmoney() {
		return this.aftcmoney;
	}

	public void setAftcmoney(Double aftcmoney) {
		this.aftcmoney = aftcmoney;
	}

	@Column(name = "STATE", length = 10)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}