package com.onegrid.meetmanager.model;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private Units units;
	private User user;
	private String name;
	private String usertype;
	private Integer sex;
	private String phone;
	private String mail;
	private String cellphone;
	private String address;
	private String zip;
	private String zwei;
	private String zwu;
	private Set users = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String name) {
		this.name = name;
	}

	/** full constructor */
	public User(Units units, User user, String name, String usertype,
			Integer sex, String phone, String mail, String cellphone,
			String address, String zip, String zwei, String zwu, Set users) {
		this.units = units;
		this.user = user;
		this.name = name;
		this.usertype = usertype;
		this.sex = sex;
		this.phone = phone;
		this.mail = mail;
		this.cellphone = cellphone;
		this.address = address;
		this.zip = zip;
		this.zwei = zwei;
		this.zwu = zwu;
		this.users = users;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Units getUnits() {
		return this.units;
	}

	public void setUnits(Units units) {
		this.units = units;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsertype() {
		return this.usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
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

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getCellphone() {
		return this.cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getZwei() {
		return this.zwei;
	}

	public void setZwei(String zwei) {
		this.zwei = zwei;
	}

	public String getZwu() {
		return this.zwu;
	}

	public void setZwu(String zwu) {
		this.zwu = zwu;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

}