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

public class MeetingArrangements implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String host;
	private Integer intermission;
	private Integer drawingtime;
	private String recorder;
	private Date recorddate;
	private Time starttime;
	private Time endtime;
	private Date date;
	private MeetingRoom meetingroom;
	private MeetingInfo meetingInfo;
	


	// Constructors

	/** default constructor */
	public MeetingArrangements() {
	}
	public MeetingArrangements(Integer id, String title, String host,
			Integer intermission, Integer drawingtime, String recorder,
			Date recorddate, Time starttime, Time endtime, Date date,
			MeetingRoom meetingroom, MeetingInfo meetingInfo) {
		super();
		this.id = id;
		this.title = title;
		this.host = host;
		this.intermission = intermission;
		this.drawingtime = drawingtime;
		this.recorder = recorder;
		this.recorddate = recorddate;
		this.starttime = starttime;
		this.endtime = endtime;
		this.date = date;
		this.meetingroom = meetingroom;
		this.meetingInfo = meetingInfo;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getHost() {
		return host;
	}



	public void setHost(String host) {
		this.host = host;
	}



	public Integer getIntermission() {
		return intermission;
	}



	public void setIntermission(Integer intermission) {
		this.intermission = intermission;
	}



	public Integer getDrawingtime() {
		return drawingtime;
	}



	public void setDrawingtime(Integer drawingtime) {
		this.drawingtime = drawingtime;
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



	public Time getStarttime() {
		return starttime;
	}



	public void setStarttime(Time starttime) {
		this.starttime = starttime;
	}



	public Time getEndtime() {
		return endtime;
	}



	public void setEndtime(Time endtime) {
		this.endtime = endtime;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public MeetingRoom getMeetingroom() {
		return meetingroom;
	}



	public void setMeetingroom(MeetingRoom meetingroom) {
		this.meetingroom = meetingroom;
	}



	public MeetingInfo getMeetingInfo() {
		return meetingInfo;
	}



	public void setMeetingInfo(MeetingInfo meetingInfo) {
		this.meetingInfo = meetingInfo;
	}



	
}