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
 * Syrole entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SYROLE", schema = "JUMKEY")
public class Syrole implements java.io.Serializable {

	// Fields

	private String roleid;
	private String rolename;
	private String roledescription;
	private Set<Syuser> syusers = new HashSet<Syuser>(0);
	private Set<Sypermission> sypermissions = new HashSet<Sypermission>(0);

	// Constructors

	/** default constructor */
	public Syrole() {
	}

	/** minimal constructor */
	public Syrole(String rolename) {
		this.rolename = rolename;
	}

	/** full constructor */
	public Syrole(String rolename, String roledescription, Set<Syuser> syusers, Set<Sypermission> sypermissions) {
		this.rolename = rolename;
		this.roledescription = roledescription;
		this.syusers = syusers;
		this.sypermissions = sypermissions;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ROLEID", unique = true, nullable = false, length = 32)
	public String getRoleid() {
		return this.roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	@Column(name = "ROLENAME", nullable = false, length = 50)
	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	@Column(name = "ROLEDESCRIPTION", length = 100)
	public String getRoledescription() {
		return this.roledescription;
	}

	public void setRoledescription(String roledescription) {
		this.roledescription = roledescription;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "syrole")
	public Set<Syuser> getSyusers() {
		return this.syusers;
	}

	public void setSyusers(Set<Syuser> syusers) {
		this.syusers = syusers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "syrole")
	public Set<Sypermission> getSypermissions() {
		return this.sypermissions;
	}

	public void setSypermissions(Set<Sypermission> sypermissions) {
		this.sypermissions = sypermissions;
	}

}