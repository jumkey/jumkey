package com.onegrid.meetmanager.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Role entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Role implements java.io.Serializable {

	// Fields

	private Integer id;
	private Sysaccount sysaccount;
	private String name;
	private Date createtime;
	private Set roleLimits = new HashSet(0);
	private Set sysaccounts = new HashSet(0);

	// Constructors
	public Role(Integer id, Sysaccount sysaccount, String name,
			Date createtime, Set roleLimits, Set sysaccounts) {
		super();
		this.id = id;
		this.sysaccount = sysaccount;
		this.name = name;
		this.createtime = createtime;
		this.roleLimits = roleLimits;
		this.sysaccounts = sysaccounts;
	}

	/** default constructor */
	public Role() {
	}

	/** full constructor */

	// Property accessors
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Sysaccount getSysaccount() {
		return this.sysaccount;
	}

	public void setSysaccount(Sysaccount sysaccount) {
		this.sysaccount = sysaccount;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Set getRoleLimits() {
		return this.roleLimits;
	}

	public void setRoleLimits(Set roleLimits) {
		this.roleLimits = roleLimits;
	}

	public Set getSysaccounts() {
		return this.sysaccounts;
	}

	public void setSysaccounts(Set sysaccounts) {
		this.sysaccounts = sysaccounts;
	}

}