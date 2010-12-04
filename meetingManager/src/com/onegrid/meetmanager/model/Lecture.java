package com.onegrid.meetmanager.model;

import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Activities entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Lecture implements java.io.Serializable {

	// Fields

	private Integer id;
	private MeetingInfo meetingInfo;
	private Units units;
	private String subject;
	private User speakers;
	private String agreement;
	private Double expertsfee;
	private Double seminarfee;
	// Constructors

	/** default constructor */
	public Lecture() {
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

	public Units getUnits() {
		return units;
	}

	public void setUnits(Units units) {
		this.units = units;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public User getSpeakers() {
		return speakers;
	}

	public void setSpeakers(User speakers) {
		this.speakers = speakers;
	}

	public String getAgreement() {
		return agreement;
	}

	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}

	public Double getExpertsfee() {
		return expertsfee;
	}

	public void setExpertsfee(Double expertsfee) {
		this.expertsfee = expertsfee;
	}

	public Double getSeminarfee() {
		return seminarfee;
	}

	public void setSeminarfee(Double seminarfee) {
		this.seminarfee = seminarfee;
	}

	public Lecture(Integer id, MeetingInfo meetingInfo, Units units,
			String subject, User speakers, String agreement, Double expertsfee,
			Double seminarfee) {
		super();
		this.id = id;
		this.meetingInfo = meetingInfo;
		this.units = units;
		this.subject = subject;
		this.speakers = speakers;
		this.agreement = agreement;
		this.expertsfee = expertsfee;
		this.seminarfee = seminarfee;
	}

}