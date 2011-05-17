package org.cafeboy.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Txplaninfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TXPLANINFO", schema = "JUMKEY")
public class Txplaninfo implements java.io.Serializable {

	// Fields

	private String planinfoid;
	private Long year;
	private String area;
	private Long state;
	private Set<Txplangedition> txplangeditions = new HashSet<Txplangedition>(0);
	private Set<Txplangather> txplangathers = new HashSet<Txplangather>(0);
	private Set<Txpprojedition> txpprojeditions = new HashSet<Txpprojedition>(0);
	private Set<Txplanproj> txplanprojs = new HashSet<Txplanproj>(0);
	private Set<Txplanprojaudit> txplanprojaudits = new HashSet<Txplanprojaudit>(0);

	// Constructors

	/** default constructor */
	public Txplaninfo() {
	}

	/** full constructor */
	public Txplaninfo(Long year, String area, Long state, Set<Txplangedition> txplangeditions, Set<Txplangather> txplangathers, Set<Txpprojedition> txpprojeditions, Set<Txplanproj> txplanprojs, Set<Txplanprojaudit> txplanprojaudits) {
		this.year = year;
		this.area = area;
		this.state = state;
		this.txplangeditions = txplangeditions;
		this.txplangathers = txplangathers;
		this.txpprojeditions = txpprojeditions;
		this.txplanprojs = txplanprojs;
		this.txplanprojaudits = txplanprojaudits;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "PLANINFOID", unique = true, nullable = false, length = 32)
	public String getPlaninfoid() {
		return this.planinfoid;
	}

	public void setPlaninfoid(String planinfoid) {
		this.planinfoid = planinfoid;
	}

	@Column(name = "YEAR", precision = 4, scale = 0)
	public Long getYear() {
		return this.year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	@Column(name = "AREA", length = 20)
	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "STATE", precision = 1, scale = 0)
	public Long getState() {
		return this.state;
	}

	public void setState(Long state) {
		this.state = state;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "txplaninfo")
	public Set<Txplangedition> getTxplangeditions() {
		return this.txplangeditions;
	}

	public void setTxplangeditions(Set<Txplangedition> txplangeditions) {
		this.txplangeditions = txplangeditions;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "txplaninfo")
	public Set<Txplangather> getTxplangathers() {
		return this.txplangathers;
	}

	public void setTxplangathers(Set<Txplangather> txplangathers) {
		this.txplangathers = txplangathers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "txplaninfo")
	public Set<Txpprojedition> getTxpprojeditions() {
		return this.txpprojeditions;
	}

	public void setTxpprojeditions(Set<Txpprojedition> txpprojeditions) {
		this.txpprojeditions = txpprojeditions;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "txplaninfo")
	public Set<Txplanproj> getTxplanprojs() {
		return this.txplanprojs;
	}

	public void setTxplanprojs(Set<Txplanproj> txplanprojs) {
		this.txplanprojs = txplanprojs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "txplaninfo")
	public Set<Txplanprojaudit> getTxplanprojaudits() {
		return this.txplanprojaudits;
	}

	public void setTxplanprojaudits(Set<Txplanprojaudit> txplanprojaudits) {
		this.txplanprojaudits = txplanprojaudits;
	}

}