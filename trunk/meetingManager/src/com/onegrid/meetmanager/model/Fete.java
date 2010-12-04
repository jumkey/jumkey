package com.onegrid.meetmanager.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Fete entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Fete implements java.io.Serializable {

	// Fields

	private Integer id;
	private MeetingInfo meetingInfo;
	private String address;
	private Date date;
	private Integer cost;
	private Integer number;
	private Integer desknumber;
	private Integer unitprice;
	private Integer othercost;
	private Units units;
	private Integer outlays;
	private Set feteRecords = new HashSet(0);


	public Fete(Integer id, MeetingInfo meetingInfo, String address, Date date,
			Integer cost, Integer number, Integer desknumber,
			Integer unitprice, Integer othercost, Units units, Integer outlays,
			Set feteRecords) {
		super();
		this.id = id;
		this.meetingInfo = meetingInfo;
		this.address = address;
		this.date = date;
		this.cost = cost;
		this.number = number;
		this.desknumber = desknumber;
		this.unitprice = unitprice;
		this.othercost = othercost;
		this.units = units;
		this.outlays = outlays;
		this.feteRecords = feteRecords;
	}

	// Constructors
	/** default constructor */
	public Fete() {
	}

	/** full constructor */
	
	// Property accessors
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getDesknumber() {
		return desknumber;
	}

	public void setDesknumber(Integer desknumber) {
		this.desknumber = desknumber;
	}

	public Integer getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(Integer unitprice) {
		this.unitprice = unitprice;
	}

	public Integer getOthercost() {
		return othercost;
	}

	public void setOthercost(Integer othercost) {
		this.othercost = othercost;
	}

	public Integer getOutlays() {
		return outlays;
	}

	public void setOutlays(Integer outlays) {
		this.outlays = outlays;
	}

	public MeetingInfo getMeetingInfo() {
		return this.meetingInfo;
	}

	public void setMeetingInfo(MeetingInfo meetingInfo) {
		this.meetingInfo = meetingInfo;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set getFeteRecords() {
		return this.feteRecords;
	}

	public void setFeteRecords(Set feteRecords) {
		this.feteRecords = feteRecords;
	}

	public Units getUnits() {
		return units;
	}

	public void setUnits(Units units) {
		this.units = units;
	}

}