package com.onegrid.meetmanager.model;

/**
 * FeeItemProperty entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class FeeItemProperty implements java.io.Serializable {

	// Fields

	private Integer id;
	private FeeItem feeItem;
	private String title;
	private String value;

	// Constructors

	/** default constructor */
	public FeeItemProperty() {
	}

	/** full constructor */
	public FeeItemProperty(FeeItem feeItem, String title, String value) {
		this.feeItem = feeItem;
		this.title = title;
		this.value = value;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public FeeItem getFeeItem() {
		return this.feeItem;
	}

	public void setFeeItem(FeeItem feeItem) {
		this.feeItem = feeItem;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}