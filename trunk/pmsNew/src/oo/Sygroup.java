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
 * Sygroup entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SYGROUP", schema = "JUMKEY")
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
	@Id
	@GeneratedValue
	@Column(name = "GROUPID", unique = true, nullable = false, length = 32)
	public String getGroupid() {
		return this.groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	@Column(name = "GROUPNAME", nullable = false, length = 100)
	public String getGroupname() {
		return this.groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	@Column(name = "GDELETES", nullable = false, precision = 1, scale = 0)
	public Long getGdeletes() {
		return this.gdeletes;
	}

	public void setGdeletes(Long gdeletes) {
		this.gdeletes = gdeletes;
	}

	@Column(name = "GROUPTYPE", precision = 1, scale = 0)
	public Long getGrouptype() {
		return this.grouptype;
	}

	public void setGrouptype(Long grouptype) {
		this.grouptype = grouptype;
	}

	@Column(name = "DEPARTMENT", length = 32)
	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sygroup")
	public Set<Syuser> getSyusers() {
		return this.syusers;
	}

	public void setSyusers(Set<Syuser> syusers) {
		this.syusers = syusers;
	}

}