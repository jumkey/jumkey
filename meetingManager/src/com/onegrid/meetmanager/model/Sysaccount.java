package com.onegrid.meetmanager.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Sysaccount entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Sysaccount implements java.io.Serializable {

	// Fields

	private Integer id;
	private Sysaccount sysaccount;
	private Department department;
	private String account;
	private String password;
	private String username;
	private Integer sex;
	private String phone;
	private String zip;
	private String address;
	private Date createtime;
	private Set departments = new HashSet(0);
	private Set sysaccounts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Sysaccount() {
	}

	/** full constructor */
	public Sysaccount(Sysaccount sysaccount, Department department,
			String account, String password, String username, Integer sex,
			String phone, String zip, String address, Date createtime,
			Set departments, Set sysaccounts) {
		this.sysaccount = sysaccount;
		this.department = department;
		this.account = account;
		this.password = password;
		this.username = username;
		this.sex = sex;
		this.phone = phone;
		this.zip = zip;
		this.address = address;
		this.createtime = createtime;
		this.departments = departments;
		this.sysaccounts = sysaccounts;
	}

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

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Set getDepartments() {
		return this.departments;
	}

	public void setDepartments(Set departments) {
		this.departments = departments;
	}

	public Set getSysaccounts() {
		return this.sysaccounts;
	}

	public void setSysaccounts(Set sysaccounts) {
		this.sysaccounts = sysaccounts;
	}

}