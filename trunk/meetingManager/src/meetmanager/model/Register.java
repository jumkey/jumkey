package meetmanager.model;

import java.util.Date;

/**
 * Register entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Register implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;//关联用户
	private MeetingInfo meetingid;
	private String payment;
	private Integer stayday;
	private Integer stayroomnumber;
	private Integer sign;
	private String photo;
	private String code;
	private Integer receive;
	private String award;//编号奖券号
	private String meal;
	private Double deposit;
	private Date depositDate;
	private Date reachDate;
	private String roomNo;
	private Date chargeDate;
	
	private Integer personalOptions;//个人选项 代表、专家、家属、特殊免交、特殊暂缓
	private String userName;//用户姓名
	private Double personalFee;//个人会务费 XXX 发现没用了
	private Double groupsFee;//团体会务费 XXX 发现没用了
	private Integer isReceipt;//是否已开收据

	// Constructors

	/** default constructor */
	public Register() {
	}

	/** full constructor */
	public Register(User user, MeetingInfo meetingid, String payment,
			Integer stayday, Integer stayroomnumber, Integer sign,
			String photo, String code, Integer receive, String award,
			String meal) {
		this.user = user;
		this.meetingid = meetingid;
		this.payment = payment;
		this.stayday = stayday;
		this.stayroomnumber = stayroomnumber;
		this.sign = sign;
		this.photo = photo;
		this.code = code;
		this.receive = receive;
		this.award = award;
		this.meal = meal;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public MeetingInfo getMeetingid() {
		return meetingid;
	}

	public void setMeetingid(MeetingInfo meetingid) {
		this.meetingid = meetingid;
	}

	public String getPayment() {
		return this.payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public Integer getStayday() {
		return this.stayday;
	}

	public void setStayday(Integer stayday) {
		this.stayday = stayday;
	}

	public Integer getStayroomnumber() {
		return this.stayroomnumber;
	}

	public void setStayroomnumber(Integer stayroomnumber) {
		this.stayroomnumber = stayroomnumber;
	}

	public Integer getSign() {
		return this.sign;
	}

	public void setSign(Integer sign) {
		this.sign = sign;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getReceive() {
		return this.receive;
	}

	public void setReceive(Integer receive) {
		this.receive = receive;
	}

	public String getAward() {
		return this.award;
	}

	public void setAward(String award) {
		this.award = award;
	}

	public String getMeal() {
		return this.meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public Double getDeposit() {
		return deposit;
	}

	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}

	public Date getDepositDate() {
		return depositDate;
	}

	public void setDepositDate(Date depositDate) {
		this.depositDate = depositDate;
	}

	public Date getReachDate() {
		return reachDate;
	}

	public void setReachDate(Date reachDate) {
		this.reachDate = reachDate;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public Date getChargeDate() {
		return chargeDate;
	}

	public void setChargeDate(Date chargeDate) {
		this.chargeDate = chargeDate;
	}

    public Integer getPersonalOptions() {
        return personalOptions;
    }

    public void setPersonalOptions(Integer personalOptions) {
        this.personalOptions = personalOptions;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getPersonalFee() {
        return personalFee;
    }

    public void setPersonalFee(Double personalFee) {
        this.personalFee = personalFee;
    }

    public Double getGroupsFee() {
        return groupsFee;
    }

    public void setGroupsFee(Double groupsFee) {
        this.groupsFee = groupsFee;
    }

    public Integer getIsReceipt() {
        return isReceipt;
    }

    public void setIsReceipt(Integer isReceipt) {
        this.isReceipt = isReceipt;
    }

}