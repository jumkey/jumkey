package meetmanager.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Notice entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Notice implements java.io.Serializable {

	// Fields

	private Integer id;
	private MeetingInfo meetingInfo;
	private Date date;
	private Integer number;
	private Set sendNotificationPlans = new HashSet(0);

	// Constructors

	/** default constructor */
	public Notice() {
	}

	/** full constructor */
	public Notice(MeetingInfo meetingInfo, Date date, Integer number,
			Set sendNotificationPlans) {
		this.meetingInfo = meetingInfo;
		this.date = date;
		this.number = number;
		this.sendNotificationPlans = sendNotificationPlans;
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

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Set getSendNotificationPlans() {
		return this.sendNotificationPlans;
	}

	public void setSendNotificationPlans(Set sendNotificationPlans) {
		this.sendNotificationPlans = sendNotificationPlans;
	}

}