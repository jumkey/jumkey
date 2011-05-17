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
 * Msphase entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "MSPHASE", schema = "JUMKEY")
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
	@Id
	@GeneratedValue
	@Column(name = "PHASEID", unique = true, nullable = false, length = 32)
	public String getPhaseid() {
		return this.phaseid;
	}

	public void setPhaseid(String phaseid) {
		this.phaseid = phaseid;
	}

	@Column(name = "NAME", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DESCRIPTION", length = 500)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "msphase")
	public Set<Sypermission> getSypermissions() {
		return this.sypermissions;
	}

	public void setSypermissions(Set<Sypermission> sypermissions) {
		this.sypermissions = sypermissions;
	}

}