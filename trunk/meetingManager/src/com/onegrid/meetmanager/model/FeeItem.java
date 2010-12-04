package com.onegrid.meetmanager.model;

import java.util.HashSet;
import java.util.Set;

/**
 * FeeItem entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class FeeItem implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String type;
	private String startfee;
	private String nature;
	private Set feeItemProperties = new HashSet(0);
	private Set meetingFeeItems = new HashSet(0);

	// Constructors

	/** default constructor */
	public FeeItem() {
	}

	/** full constructor */
	public FeeItem(String name, String type, String startfee, String nature,
			Set feeItemProperties, Set meetingFeeItems) {
		this.name = name;
		this.type = type;
		this.startfee = startfee;
		this.nature = nature;
		this.feeItemProperties = feeItemProperties;
		this.meetingFeeItems = meetingFeeItems;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStartfee() {
		return this.startfee;
	}

	public void setStartfee(String startfee) {
		this.startfee = startfee;
	}

	public String getNature() {
		return this.nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public Set getFeeItemProperties() {
		return this.feeItemProperties;
	}

	public void setFeeItemProperties(Set feeItemProperties) {
		this.feeItemProperties = feeItemProperties;
	}

	public Set getMeetingFeeItems() {
		return this.meetingFeeItems;
	}

	public void setMeetingFeeItems(Set meetingFeeItems) {
		this.meetingFeeItems = meetingFeeItems;
	}

}