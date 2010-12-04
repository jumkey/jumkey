package com.onegrid.meetmanager.model;

/**
 * AwardsPrize entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class AwardsPrize implements java.io.Serializable {

	// Fields

	private Integer id;
	private Awards awards;
	private String name;
	private String sponsors;

	// Constructors

	/** default constructor */
	public AwardsPrize() {
	}

	/** full constructor */
	public AwardsPrize(Awards awards, String name, String sponsors) {
		this.awards = awards;
		this.name = name;
		this.sponsors = sponsors;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Awards getAwards() {
		return this.awards;
	}

	public void setAwards(Awards awards) {
		this.awards = awards;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSponsors() {
		return this.sponsors;
	}

	public void setSponsors(String sponsors) {
		this.sponsors = sponsors;
	}

}