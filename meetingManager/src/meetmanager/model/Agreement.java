package meetmanager.model;

import java.util.Date;

/**
 * Agreement entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Agreement implements java.io.Serializable {

	// Fields

	private Integer id;
	private MeetingInfo meetingInfo;
	private Date date;
	private Date mdate;
	private String travelContact;	//旅行社联系人
	private String travelPhone;	//旅行社电话
	private String hotelContacts;	//酒店联系人
	private String hotelPhone;	//酒店电话
	private Double hoteldeposit;	//酒店押金(浮点数)

	// Constructors

	/** default constructor */
	public Agreement() {
	}

	/** full constructor */
	public Agreement(MeetingInfo meetingInfo, Date date, Date mdate) {
		this.meetingInfo = meetingInfo;
		this.date = date;
		this.mdate = mdate;
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

	public Date getMdate() {
		return this.mdate;
	}

	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}

	public String getTravelContact() {
		return travelContact;
	}

	public void setTravelContact(String travelContact) {
		this.travelContact = travelContact;
	}

	public String getTravelPhone() {
		return travelPhone;
	}

	public void setTravelPhone(String travelPhone) {
		this.travelPhone = travelPhone;
	}

	public String getHotelContacts() {
		return hotelContacts;
	}

	public void setHotelContacts(String hotelContacts) {
		this.hotelContacts = hotelContacts;
	}

	public String getHotelPhone() {
		return hotelPhone;
	}

	public void setHotelPhone(String hotelPhone) {
		this.hotelPhone = hotelPhone;
	}

	public Double getHoteldeposit() {
		return hoteldeposit;
	}

	public void setHoteldeposit(Double hoteldeposit) {
		this.hoteldeposit = hoteldeposit;
	}

}