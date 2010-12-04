package com.onegrid.meetmanager.model;

import java.util.Date;

/**
 * Income entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Income implements java.io.Serializable {

	// Fields

	private Integer id;
	private Units units;
	private MeetingFeeItem meetingFeeItem;
	private User user;
	private Sysaccount sysaccount;
	private Double money;
	private Date date;
	private Date createtime;

	// Constructors

	/** default constructor */
	public Income() {
	}

	/** full constructor */
	public Income(Units units, MeetingFeeItem meetingFeeItem, User user,
			Sysaccount sysaccount, Double money, Date date, Date createtime) {
		this.units = units;
		this.meetingFeeItem = meetingFeeItem;
		this.user = user;
		this.sysaccount = sysaccount;
		this.money = money;
		this.date = date;
		this.createtime = createtime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Units getUnits() {
		return this.units;
	}

	public void setUnits(Units units) {
		this.units = units;
	}

	public MeetingFeeItem getMeetingFeeItem() {
		return this.meetingFeeItem;
	}

	public void setMeetingFeeItem(MeetingFeeItem meetingFeeItem) {
		this.meetingFeeItem = meetingFeeItem;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Sysaccount getSysaccount() {
		return this.sysaccount;
	}

	public void setSysaccount(Sysaccount sysaccount) {
		this.sysaccount = sysaccount;
	}

	public Double getMoney() {
		return this.money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}