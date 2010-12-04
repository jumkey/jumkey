package com.onegrid.meetmanager.model;

import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * MeetingInfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ArrangementsSeminars implements java.io.Serializable {

	// Fields
	private Integer id;
	private Integer number;
	private Integer timelength;
	private String recorder;
	private Date recorddate;
	private MeetingArrangements meetingArrangements;
	private Lecture lecture;

	// Constructors

	/** default constructor */
	public ArrangementsSeminars() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getTimelength() {
		return timelength;
	}

	public void setTimelength(Integer timelength) {
		this.timelength = timelength;
	}

	public String getRecorder() {
		return recorder;
	}

	public void setRecorder(String recorder) {
		this.recorder = recorder;
	}

	public Date getRecorddate() {
		return recorddate;
	}

	public void setRecorddate(Date recorddate) {
		this.recorddate = recorddate;
	}

	public MeetingArrangements getMeetingArrangements() {
		return meetingArrangements;
	}

	public void setMeetingArrangements(MeetingArrangements meetingArrangements) {
		this.meetingArrangements = meetingArrangements;
	}

	public Lecture getLecture() {
		return lecture;
	}

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}

	public ArrangementsSeminars(Integer id, Integer number, Integer timelength,
			String recorder, Date recorddate,
			MeetingArrangements meetingArrangements, Lecture lecture) {
		super();
		this.id = id;
		this.number = number;
		this.timelength = timelength;
		this.recorder = recorder;
		this.recorddate = recorddate;
		this.meetingArrangements = meetingArrangements;
		this.lecture = lecture;
	}

}