package com.onegrid.meetmanager.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Units entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Units implements java.io.Serializable {

	// Fields

	private Integer id;
	private UnitsType unitsType;
	private String name;
	private String address;
	private String zip;
	private String connect;
	private String phone;
	private String mail;
	private String site;
	private Set users = new HashSet(0);

	// Constructors

	/** default constructor */
	public Units() {
	}

	/** minimal constructor */
	public Units(String name, String address, String connect, String phone) {
		this.name = name;
		this.address = address;
		this.connect = connect;
		this.phone = phone;
	}

	/** full constructor */
	public Units(UnitsType unitsType, String name, String address, String zip,
			String connect, String phone, String mail, String site, Set users) {
		this.unitsType = unitsType;
		this.name = name;
		this.address = address;
		this.zip = zip;
		this.connect = connect;
		this.phone = phone;
		this.mail = mail;
		this.site = site;
		this.users = users;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UnitsType getUnitsType() {
		return this.unitsType;
	}

	public void setUnitsType(UnitsType unitsType) {
		this.unitsType = unitsType;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getConnect() {
		return this.connect;
	}

	public void setConnect(String connect) {
		this.connect = connect;
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

	public String getSite() {
		return this.site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

}