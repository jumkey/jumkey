package com.onegrid.meetmanager.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * MeetingInfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class MeetingInfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private Price price;
	private Sysaccount sysaccount;
	private Date date;
	private String title;
	private String author;
	private String address;
	private String desc1;
	private Date rdate;
	private Set registers = new HashSet(0);
	private Set meetingFeeItems = new HashSet(0);
	private Set fetes = new HashSet(0);
	private Set lotteries = new HashSet(0);
	private Set awardses = new HashSet(0);
	private Set notices = new HashSet(0);
	private Set agreements = new HashSet(0);
	private Set activitieses = new HashSet(0);

	// Constructors

	/** default constructor */
	public MeetingInfo() {
	}

	/** full constructor */
	public MeetingInfo(Price price, Sysaccount sysaccount, Date date,
			String title, String author, String address, String desc1,
			Date rdate, Set registers, Set meetingFeeItems, Set fetes, Set lotteries,
			Set awardses, Set notices, Set agreements, Set activitieses) {
		this.price = price;
		this.sysaccount = sysaccount;
		this.date = date;
		this.title = title;
		this.author = author;
		this.address = address;
		this.desc1 = desc1;
		this.rdate = rdate;
		this.registers = registers;
		this.meetingFeeItems = meetingFeeItems;
		this.fetes = fetes;
		this.lotteries = lotteries;
		this.awardses = awardses;
		this.notices = notices;
		this.agreements = agreements;
		this.activitieses = activitieses;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Price getPrice() {
		return this.price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}



	public Sysaccount getSysaccount() {
		return sysaccount;
	}

	public void setSysaccount(Sysaccount sysaccount) {
		this.sysaccount = sysaccount;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDesc1() {
		return this.desc1;
	}

	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}

	public Date getRdate() {
		return this.rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}

	public Set getMeetingFeeItems() {
		return this.meetingFeeItems;
	}

	public Set getRegisters() {
		return this.registers;
	}

	public void setRegisters(Set registers) {
		this.registers = registers;
	}

	public void setMeetingFeeItems(Set meetingFeeItems) {
		this.meetingFeeItems = meetingFeeItems;
	}

	public Set getFetes() {
		return this.fetes;
	}

	public void setFetes(Set fetes) {
		this.fetes = fetes;
	}

	public Set getLotteries() {
		return this.lotteries;
	}

	public void setLotteries(Set lotteries) {
		this.lotteries = lotteries;
	}

	public Set getAwardses() {
		return this.awardses;
	}

	public void setAwardses(Set awardses) {
		this.awardses = awardses;
	}

	public Set getNotices() {
		return this.notices;
	}

	public void setNotices(Set notices) {
		this.notices = notices;
	}

	public Set getAgreements() {
		return this.agreements;
	}

	public void setAgreements(Set agreements) {
		this.agreements = agreements;
	}

	public Set getActivitieses() {
		return this.activitieses;
	}

	public void setActivitieses(Set activitieses) {
		this.activitieses = activitieses;
	}


}