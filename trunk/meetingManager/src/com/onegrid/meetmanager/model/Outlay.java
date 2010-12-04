package com.onegrid.meetmanager.model;

import java.util.Date;

/**
 * Outlay entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Outlay implements java.io.Serializable {

	// Fields

	private Integer id;
	private Units units;
	private MeetingFeeItem meetingFeeItem;
	private User user;
	private Sysaccount sysaccount;
	private Double money;
	private String person;
	private Date createtime;

	// Constructors

	/** default constructor */
	public Outlay() {
	}

	/** full constructor */
	public Outlay(Units units, MeetingFeeItem meetingFeeItem, User user,
			Sysaccount sysaccount, Double money, String person, Date createtime) {
		this.units = units;
		this.meetingFeeItem = meetingFeeItem;
		this.user = user;
		this.sysaccount = sysaccount;
		this.money = money;
		this.person = person;
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

	public String getPerson() {
		return this.person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}