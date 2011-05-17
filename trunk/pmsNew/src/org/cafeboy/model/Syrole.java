package org.cafeboy.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Syrole entity.
 * 
 * @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
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

	public String getRoleid() {
		return this.roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRoledescription() {
		return this.roledescription;
	}

	public void setRoledescription(String roledescription) {
		this.roledescription = roledescription;
	}

	public Set<Syuser> getSyusers() {
		return this.syusers;
	}

	public void setSyusers(Set<Syuser> syusers) {
		this.syusers = syusers;
	}

	public Set<Sypermission> getSypermissions() {
		return this.sypermissions;
	}

	public void setSypermissions(Set<Sypermission> sypermissions) {
		this.sypermissions = sypermissions;
	}

}