package com.onegrid.meetmanager.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Awards entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Awards implements java.io.Serializable {

	// Fields

	private Integer id;
	private MeetingInfo meetingInfo;
	private MeetingArrangements meetingArrangements;
	private Units units;
	private String name;
	private String remarks;
	private Double expenses;
	private Double value;
	private String host;
	private String guest;
	private String unitstype;
	private String usertype;
	private String shieldunits;
	private String shielduser;
	private Set lotteryRecords = new HashSet(0);
	private Set awardsPrizes = new HashSet(0);

	// Constructors

	/** default constructor */
	public Awards() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MeetingInfo getMeetingInfo() {
		return meetingInfo;
	}

	public void setMeetingInfo(MeetingInfo meetingInfo) {
		this.meetingInfo = meetingInfo;
	}

	public MeetingArrangements getMeetingArrangements() {
		return meetingArrangements;
	}

	public void setMeetingArrangements(MeetingArrangements meetingArrangements) {
		this.meetingArrangements = meetingArrangements;
	}

	public Units getUnits() {
		return units;
	}

	public void setUnits(Units units) {
		this.units = units;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Double getExpenses() {
		return expenses;
	}

	public void setExpenses(Double expenses) {
		this.expenses = expenses;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getGuest() {
		return guest;
	}

	public void setGuest(String guest) {
		this.guest = guest;
	}

	public String getUnitstype() {
		return unitstype;
	}

	public void setUnitstype(String unitstype) {
		this.unitstype = unitstype;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getShieldunits() {
		return shieldunits;
	}

	public void setShieldunits(String shieldunits) {
		this.shieldunits = shieldunits;
	}

	public String getShielduser() {
		return shielduser;
	}

	public void setShielduser(String shielduser) {
		this.shielduser = shielduser;
	}

	public Set getLotteryRecords() {
		return lotteryRecords;
	}

	public void setLotteryRecords(Set lotteryRecords) {
		this.lotteryRecords = lotteryRecords;
	}

	public Set getAwardsPrizes() {
		return awardsPrizes;
	}

	public void setAwardsPrizes(Set awardsPrizes) {
		this.awardsPrizes = awardsPrizes;
	}

	public Awards(Integer id, MeetingInfo meetingInfo,
			MeetingArrangements meetingArrangements, Units units, String name,
			String remarks, Double expenses, Double value, String host,
			String guest, String unitstype, String usertype,
			String shieldunits, String shielduser, Set lotteryRecords,
			Set awardsPrizes) {
		super();
		this.id = id;
		this.meetingInfo = meetingInfo;
		this.meetingArrangements = meetingArrangements;
		this.units = units;
		this.name = name;
		this.remarks = remarks;
		this.expenses = expenses;
		this.value = value;
		this.host = host;
		this.guest = guest;
		this.unitstype = unitstype;
		this.usertype = usertype;
		this.shieldunits = shieldunits;
		this.shielduser = shielduser;
		this.lotteryRecords = lotteryRecords;
		this.awardsPrizes = awardsPrizes;
	}

	/** full constructor */
}