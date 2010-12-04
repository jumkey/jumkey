package com.onegrid.meetmanager.model;

import java.util.Date;

/**
 * FeteRecord entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class FeteRecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private Fete fete;

	// Constructors

	/** default constructor */
	public FeteRecord() {
	}

	/** full constructor */
	public FeteRecord(User user, Fete fete) {
		this.user = user;
		this.fete = fete;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Fete getFete() {
		return this.fete;
	}

	public void setFete(Fete fete) {
		this.fete = fete;
	}

}