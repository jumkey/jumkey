package org.cafeboy.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Msspec entity.
 * 
 * @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
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

	public String getSpecid() {
		return this.specid;
	}

	public void setSpecid(String specid) {
		this.specid = specid;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortname() {
		return this.shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public Set<Txpprojedition> getTxpprojeditions() {
		return this.txpprojeditions;
	}

	public void setTxpprojeditions(Set<Txpprojedition> txpprojeditions) {
		this.txpprojeditions = txpprojeditions;
	}

	public Set<Txplanproj> getTxplanprojs() {
		return this.txplanprojs;
	}

	public void setTxplanprojs(Set<Txplanproj> txplanprojs) {
		this.txplanprojs = txplanprojs;
	}

	public Set<Txplangather> getTxplangathers() {
		return this.txplangathers;
	}

	public void setTxplangathers(Set<Txplangather> txplangathers) {
		this.txplangathers = txplangathers;
	}

	public Set<Txplangedition> getTxplangeditions() {
		return this.txplangeditions;
	}

	public void setTxplangeditions(Set<Txplangedition> txplangeditions) {
		this.txplangeditions = txplangeditions;
	}

}