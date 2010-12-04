package com.onegrid.meetmanager.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * MeetingFeeItem entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class MeetingFeeItem implements java.io.Serializable {

	// Fields

	private Integer id;
	private MeetingInfo meetingInfo;
	private Sysaccount sysaccount;
	private FeeItem feeItem;
	private Double money;
	private Date createtime;
	private Set meetingFeeItemProperties = new HashSet(0);
	private Set outlaies = new HashSet(0);
	private Set incomes = new HashSet(0);

	// Constructors

	/** default constructor */
	public MeetingFeeItem() {
	}

	/** full constructor */
	public MeetingFeeItem(MeetingInfo meetingInfo, Sysaccount sysaccount,
			FeeItem feeItem, Double money, Date createtime,
			Set meetingFeeItemProperties, Set outlaies, Set incomes) {
		this.meetingInfo = meetingInfo;
		this.sysaccount = sysaccount;
		this.feeItem = feeItem;
		this.money = money;
		this.createtime = createtime;
		this.meetingFeeItemProperties = meetingFeeItemProperties;
		this.outlaies = outlaies;
		this.incomes = incomes;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MeetingInfo getMeetingInfo() {
		return this.meetingInfo;
	}

	public void setMeetingInfo(MeetingInfo meetingInfo) {
		this.meetingInfo = meetingInfo;
	}

	public Sysaccount getSysaccount() {
		return this.sysaccount;
	}

	public void setSysaccount(Sysaccount sysaccount) {
		this.sysaccount = sysaccount;
	}

	public FeeItem getFeeItem() {
		return this.feeItem;
	}

	public void setFeeItem(FeeItem feeItem) {
		this.feeItem = feeItem;
	}

	public Double getMoney() {
		return this.money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Set getMeetingFeeItemProperties() {
		return this.meetingFeeItemProperties;
	}

	public void setMeetingFeeItemProperties(Set meetingFeeItemProperties) {
		this.meetingFeeItemProperties = meetingFeeItemProperties;
	}

	public Set getOutlaies() {
		return this.outlaies;
	}

	public void setOutlaies(Set outlaies) {
		this.outlaies = outlaies;
	}

	public Set getIncomes() {
		return this.incomes;
	}

	public void setIncomes(Set incomes) {
		this.incomes = incomes;
	}

}