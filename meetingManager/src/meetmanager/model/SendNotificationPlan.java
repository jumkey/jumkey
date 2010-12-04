package meetmanager.model;

import java.util.Date;

/**
 * SendNotificationPlan entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class SendNotificationPlan implements java.io.Serializable {

	// Fields

	private Integer id;
	private Units units;
	private Sysaccount sysaccount;
	private User user;
	private Notice notice;
	private Date date;
	private String response;
	private Date responsedate;
	private Integer housenumber;
	private String reachflights;
	private String reachTrain;
	private Date reachtime;
	private RoomType roomtype;
	private Integer issingle;//是否单人间0不是1是
	private String reachman;//接站负责人
	private String reachphone;//接站联系电话
	private String note;

	// Constructors

	/** default constructor */
	public SendNotificationPlan() {
	}

	/** full constructor */
	public SendNotificationPlan(Units units, Sysaccount sysaccount, User user,
			Notice notice, Date date, String response, Date responsedate, Integer housenumber ,String reachflights, String reachTrain, Date reachtime, String note) {
		this.units = units;
		this.sysaccount = sysaccount;
		this.user = user;
		this.notice = notice;
		this.date = date;
		this.response = response;
		this.responsedate = responsedate;
		this.housenumber = housenumber;
		this.reachflights = reachflights;
		this.reachTrain = reachTrain;
		this.reachtime = reachtime;
		this.note = note;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Units getUnits() {
		return this.units;
	}

	public void setUnits(Units units) {
		this.units = units;
	}

	public Sysaccount getSysaccount() {
		return this.sysaccount;
	}

	public void setSysaccount(Sysaccount sysaccount) {
		this.sysaccount = sysaccount;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Notice getNotice() {
		return this.notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getResponse() {
		return this.response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Date getResponsedate() {
		return this.responsedate;
	}

	public void setResponsedate(Date responsedate) {
		this.responsedate = responsedate;
	}

	public Integer getHousenumber() {
		return housenumber;
	}

	public void setHousenumber(Integer housenumber) {
		this.housenumber = housenumber;
	}

	public String getReachflights() {
		return reachflights;
	}

	public void setReachflights(String reachflights) {
		this.reachflights = reachflights;
	}

	public String getReachTrain() {
		return reachTrain;
	}

	public void setReachTrain(String reachTrain) {
		this.reachTrain = reachTrain;
	}

	public Date getReachtime() {
		return reachtime;
	}

	public void setReachtime(Date reachtime) {
		this.reachtime = reachtime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getReachman() {
		return reachman;
	}

	public void setReachman(String reachman) {
		this.reachman = reachman;
	}

    public String getReachphone() {
        return reachphone;
    }

    public void setReachphone(String reachphone) {
        this.reachphone = reachphone;
    }

    public RoomType getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(RoomType roomtype) {
        this.roomtype = roomtype;
    }

    public Integer getIssingle() {
        return issingle;
    }

    public void setIssingle(Integer issingle) {
        this.issingle = issingle;
    }

}