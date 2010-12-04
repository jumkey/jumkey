package meetmanager.model;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private Units units;
	private User user;
	private String name;
	private String usertype;
	private Integer sex;
	private String phone;
	private String mail;
	private String cellphone;
	private String zwu;
	private String fax;
	private String photo;
	private Set registers = new HashSet(0);
	private Set users = new HashSet(0);
	private Set incomes = new HashSet(0);
	private Set users_1 = new HashSet(0);
	private Set outlaies = new HashSet(0);
	private Set relativesesForTheirid = new HashSet(0);
	private Set feteRecords = new HashSet(0);
	private Set sendNotificationPlans = new HashSet(0);
	private Set relativesesForUserid = new HashSet(0);
	private Set joinActivitiesRecords = new HashSet(0);
	private Set lotteries = new HashSet(0);

	// Constructors

	public User(Integer id, Units units, User user, String name,
			String usertype, Integer sex, String phone, String mail,
			String cellphone, String zwu,
			String fax, String photo, Set registers, Set users, Set incomes,
			Set users_1, Set outlaies, Set relativesesForTheirid,
			Set feteRecords, Set sendNotificationPlans,
			Set relativesesForUserid, Set joinActivitiesRecords, Set lotteries) {
		super();
		this.id = id;
		this.units = units;
		this.user = user;
		this.name = name;
		this.usertype = usertype;
		this.sex = sex;
		this.phone = phone;
		this.mail = mail;
		this.cellphone = cellphone;
		this.zwu = zwu;
		this.fax = fax;
		this.photo = photo;
		this.registers = registers;
		this.users = users;
		this.incomes = incomes;
		this.users_1 = users_1;
		this.outlaies = outlaies;
		this.relativesesForTheirid = relativesesForTheirid;
		this.feteRecords = feteRecords;
		this.sendNotificationPlans = sendNotificationPlans;
		this.relativesesForUserid = relativesesForUserid;
		this.joinActivitiesRecords = joinActivitiesRecords;
		this.lotteries = lotteries;
	}

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String name) {
		this.name = name;
	}

	/** full constructor */
	
	
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

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsertype() {
		return this.usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getCellphone() {
		return this.cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getZwu() {
		return this.zwu;
	}

	public void setZwu(String zwu) {
		this.zwu = zwu;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Set getRegisters() {
		return this.registers;
	}

	public void setRegisters(Set registers) {
		this.registers = registers;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

	public Set getIncomes() {
		return this.incomes;
	}

	public void setIncomes(Set incomes) {
		this.incomes = incomes;
	}

	public Set getUsers_1() {
		return this.users_1;
	}

	public void setUsers_1(Set users_1) {
		this.users_1 = users_1;
	}

	public Set getOutlaies() {
		return this.outlaies;
	}

	public void setOutlaies(Set outlaies) {
		this.outlaies = outlaies;
	}

	public Set getRelativesesForTheirid() {
		return this.relativesesForTheirid;
	}

	public void setRelativesesForTheirid(Set relativesesForTheirid) {
		this.relativesesForTheirid = relativesesForTheirid;
	}

	public Set getFeteRecords() {
		return this.feteRecords;
	}

	public void setFeteRecords(Set feteRecords) {
		this.feteRecords = feteRecords;
	}

	public Set getSendNotificationPlans() {
		return this.sendNotificationPlans;
	}

	public void setSendNotificationPlans(Set sendNotificationPlans) {
		this.sendNotificationPlans = sendNotificationPlans;
	}

	public Set getRelativesesForUserid() {
		return this.relativesesForUserid;
	}

	public void setRelativesesForUserid(Set relativesesForUserid) {
		this.relativesesForUserid = relativesesForUserid;
	}

	public Set getJoinActivitiesRecords() {
		return this.joinActivitiesRecords;
	}

	public void setJoinActivitiesRecords(Set joinActivitiesRecords) {
		this.joinActivitiesRecords = joinActivitiesRecords;
	}

	public Set getLotteries() {
		return this.lotteries;
	}

	public void setLotteries(Set lotteries) {
		this.lotteries = lotteries;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

}