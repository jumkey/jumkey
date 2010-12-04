package com.onegrid.meetmanager.model;

/**
 * LotteryRecord entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class LotteryRecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private Lottery lottery;
	private Awards awards;

	// Constructors

	/** default constructor */
	public LotteryRecord() {
	}

	/** full constructor */
	public LotteryRecord(Lottery lottery, Awards awards) {
		this.lottery = lottery;
		this.awards = awards;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Lottery getLottery() {
		return this.lottery;
	}

	public void setLottery(Lottery lottery) {
		this.lottery = lottery;
	}

	public Awards getAwards() {
		return this.awards;
	}

	public void setAwards(Awards awards) {
		this.awards = awards;
	}

}