package com.onegrid.meetmanager.model;

import java.util.HashSet;
import java.util.Set;

/**
 * UnitsType entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class UnitsType implements java.io.Serializable {

	// Fields

	private Integer id;
	private String typeName;
	private Set unitses = new HashSet(0);

	// Constructors

	/** default constructor */
	public UnitsType() {
	}

	/** minimal constructor */
	public UnitsType(String typeName) {
		this.typeName = typeName;
	}

	/** full constructor */
	public UnitsType(String typeName, Set unitses) {
		this.typeName = typeName;
		this.unitses = unitses;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Set getUnitses() {
		return this.unitses;
	}

	public void setUnitses(Set unitses) {
		this.unitses = unitses;
	}

}