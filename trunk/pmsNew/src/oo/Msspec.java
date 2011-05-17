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
 * Msspec entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "MSSPEC", schema = "JUMKEY")
public class Msspec implements java.io.Serializable {

	// Fields

	private String specid;
	private String code;
	private String name;
	private String shortname;
	private Set<Txpprojedition> txpprojeditions = new HashSet<Txpprojedition>(0);
	private Set<Txplanproj> txplanprojs = new HashSet<Txplanproj>(0);
	private Set<Txplangather> txplangathers = new HashSet<Txplangather>(0);
	private Set<Txplangedition> txplangeditions = new HashSet<Txplangedition>(0);

	// Constructors

	/** default constructor */
	public Msspec() {
	}

	/** full constructor */
	public Msspec(String code, String name, String shortname, Set<Txpprojedition> txpprojeditions, Set<Txplanproj> txplanprojs, Set<Txplangather> txplangathers, Set<Txplangedition> txplangeditions) {
		this.code = code;
		this.name = name;
		this.shortname = shortname;
		this.txpprojeditions = txpprojeditions;
		this.txplanprojs = txplanprojs;
		this.txplangathers = txplangathers;
		this.txplangeditions = txplangeditions;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "SPECID", unique = true, nullable = false, length = 32)
	public String getSpecid() {
		return this.specid;
	}

	public void setSpecid(String specid) {
		this.specid = specid;
	}

	@Column(name = "CODE", length = 50)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "NAME", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "SHORTNAME", length = 50)
	public String getShortname() {
		return this.shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "msspec")
	public Set<Txpprojedition> getTxpprojeditions() {
		return this.txpprojeditions;
	}

	public void setTxpprojeditions(Set<Txpprojedition> txpprojeditions) {
		this.txpprojeditions = txpprojeditions;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "msspec")
	public Set<Txplanproj> getTxplanprojs() {
		return this.txplanprojs;
	}

	public void setTxplanprojs(Set<Txplanproj> txplanprojs) {
		this.txplanprojs = txplanprojs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "msspec")
	public Set<Txplangather> getTxplangathers() {
		return this.txplangathers;
	}

	public void setTxplangathers(Set<Txplangather> txplangathers) {
		this.txplangathers = txplangathers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "msspec")
	public Set<Txplangedition> getTxplangeditions() {
		return this.txplangeditions;
	}

	public void setTxplangeditions(Set<Txplangedition> txplangeditions) {
		this.txplangeditions = txplangeditions;
	}

}