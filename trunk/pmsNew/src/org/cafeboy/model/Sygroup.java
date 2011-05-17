package org.cafeboy.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Sygroup entity.
 * 
 * @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Sygroup implements java.io.Serializable {

	// Fields

	private String groupid;
	private String groupname;
	private Long gdeletes;
	private Long grouptype;
	private String department;
	private Set<Syuser> syusers = new HashSet<Syuser>(0);

	// Constructors

	/** default constructor */
	public Sygroup() {
	}

	/** minimal constructor */
	public Sygroup(String groupname, Long gdeletes) {
		this.groupname = groupname;
		this.gdeletes = gdeletes;
	}

	/** full constructor */
	public Sygroup(String groupname, Long gdeletes, Long grouptype, String department, Set<Syuser> syusers) {
		this.groupname = groupname;
		this.gdeletes = gdeletes;
		this.grouptype = grouptype;
		this.department = department;
		this.syusers = syusers;
	}

	// Property accessors

	public String getGroupid() {
		return this.groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public String getGroupname() {
		return this.groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public Long getGdeletes() {
		return this.gdeletes;
	}

	public void setGdeletes(Long gdeletes) {
		this.gdeletes = gdeletes;
	}

	public Long getGrouptype() {
		return this.grouptype;
	}

	public void setGrouptype(Long grouptype) {
		this.grouptype = grouptype;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Set<Syuser> getSyusers() {
		return this.syusers;
	}

	public void setSyusers(Set<Syuser> syusers) {
		this.syusers = syusers;
	}

}