package meetmanager.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Lottery entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Lottery implements java.io.Serializable {

	// Fields

	private Integer id;
	private MeetingInfo meetingInfo;
	private User owner;
	private Date createdate;
	private Date senddate;
	private Set lotteryRecords = new HashSet(0);

	// Constructors

	/** default constructor */
	public Lottery() {
	}

	/** full constructor */
	public Lottery(MeetingInfo meetingInfo, User owner,
			Date createdate, Date senddate, Set lotteryRecords) {
		this.meetingInfo = meetingInfo;
		this.owner = owner;
		this.createdate = createdate;
		this.senddate = senddate;
		this.lotteryRecords = lotteryRecords;
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

	public User getOwner() {
		return this.owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getSenddate() {
		return this.senddate;
	}

	public void setSenddate(Date senddate) {
		this.senddate = senddate;
	}

	public Set getLotteryRecords() {
		return this.lotteryRecords;
	}

	public void setLotteryRecords(Set lotteryRecords) {
		this.lotteryRecords = lotteryRecords;
	}

}