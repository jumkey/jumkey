package meetmanager.model;

import java.util.Date;

/**
 * MeetingFeeItemProperty entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class MeetingFeeItemProperty implements java.io.Serializable {

	// Fields

	private Integer id;
	private MeetingFeeItem meetingFeeItem;
	private Sysaccount sysaccount;
	private String name;
	private String value;
	private Date createtime;

	// Constructors

	/** default constructor */
	public MeetingFeeItemProperty() {
	}

	/** full constructor */
	public MeetingFeeItemProperty(MeetingFeeItem meetingFeeItem,
			Sysaccount sysaccount, String name, String value, Date createtime) {
		this.meetingFeeItem = meetingFeeItem;
		this.sysaccount = sysaccount;
		this.name = name;
		this.value = value;
		this.createtime = createtime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MeetingFeeItem getMeetingFeeItem() {
		return this.meetingFeeItem;
	}

	public void setMeetingFeeItem(MeetingFeeItem meetingFeeItem) {
		this.meetingFeeItem = meetingFeeItem;
	}

	public Sysaccount getSysaccount() {
		return this.sysaccount;
	}

	public void setSysaccount(Sysaccount sysaccount) {
		this.sysaccount = sysaccount;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}