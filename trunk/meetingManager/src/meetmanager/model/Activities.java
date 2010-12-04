package meetmanager.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Activities entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Activities implements java.io.Serializable {

	// Fields

	private Integer id;
	private MeetingInfo meetingInfo;
	private String name;
	private Date date;
	private String person;
	private String desc1;
	private Integer day;
	private String phone;
	private Integer mobilephone;
	private Set joinActivitiesRecords = new HashSet(0);

	// Constructors


	public Activities(Integer id, MeetingInfo meetingInfo, String name,
			Date date, String person, String desc1, Integer day, String phone,
			Integer mobilephone, Set joinActivitiesRecords) {
		super();
		this.id = id;
		this.meetingInfo = meetingInfo;
		this.name = name;
		this.date = date;
		this.person = person;
		this.desc1 = desc1;
		this.day = day;
		this.phone = phone;
		this.mobilephone = mobilephone;
		this.joinActivitiesRecords = joinActivitiesRecords;
	}

	/** default constructor */
	public Activities() {
	}

	/** full constructor */
		

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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPerson() {
		return this.person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getDesc1() {
		return this.desc1;
	}

	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}

	public Set getJoinActivitiesRecords() {
		return this.joinActivitiesRecords;
	}

	public void setJoinActivitiesRecords(Set joinActivitiesRecords) {
		this.joinActivitiesRecords = joinActivitiesRecords;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(Integer mobilephone) {
		this.mobilephone = mobilephone;
	}
	
}