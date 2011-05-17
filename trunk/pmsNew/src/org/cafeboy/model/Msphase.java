package org.cafeboy.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Msphase entity.
 * 
 * @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Msphase implements java.io.Serializable {

	// Fields

	private String phaseid;
	private String name;
	private String description;
	private Set<Sypermission> sypermissions = new HashSet<Sypermission>(0);

	// Constructors

	/** default constructor */
	public Msphase() {
	}

	/** full constructor */
	public Msphase(String name, String description, Set<Sypermission> sypermissions) {
		this.name = name;
		this.description = description;
		this.sypermissions = sypermissions;
	}

	// Property accessors

	public String getPhaseid() {
		return this.phaseid;
	}

	public void setPhaseid(String phaseid) {
		this.phaseid = phaseid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Sypermission> getSypermissions() {
		return this.sypermissions;
	}

	public void setSypermissions(Set<Sypermission> sypermissions) {
		this.sypermissions = sypermissions;
	}

}