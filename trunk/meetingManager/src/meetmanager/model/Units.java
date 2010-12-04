package meetmanager.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Units entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Units implements java.io.Serializable {

	// Fields

	private Integer id;
	private UnitsType unitsType;
	private String name;
	private String address;
	private String zip;
	private String site;
	private TradeType tradetype;
	private Set outlaies = new HashSet(0);
	private Set incomes = new HashSet(0);
	private Set users = new HashSet(0);
	private Set sendNotificationPlans = new HashSet(0);
	private Set users_1 = new HashSet(0);

	public Units(Integer id, UnitsType unitsType, String name, String address,
			String zip, String site, TradeType tradetype, Set outlaies,
			Set incomes, Set users, Set sendNotificationPlans, Set users_1) {
		super();
		this.id = id;
		this.unitsType = unitsType;
		this.name = name;
		this.address = address;
		this.zip = zip;
		this.site = site;
		this.tradetype = tradetype;
		this.outlaies = outlaies;
		this.incomes = incomes;
		this.users = users;
		this.sendNotificationPlans = sendNotificationPlans;
		this.users_1 = users_1;
	}

	/** default constructor */
	public Units() {
	}

	/** minimal constructor */
	public Units(String name, String address) {
		this.name = name;
		this.address = address;
	}

	/** full constructor */
	
	// Property accessors
	public Integer getId() {
		return this.id;
	}
	
	public TradeType getTradetype() {
		return tradetype;
	}

	public void setTradetype(TradeType tradetype) {
		this.tradetype = tradetype;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UnitsType getUnitsType() {
		return this.unitsType;
	}

	public void setUnitsType(UnitsType unitsType) {
		this.unitsType = unitsType;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getSite() {
		return this.site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Set getOutlaies() {
		return this.outlaies;
	}

	public void setOutlaies(Set outlaies) {
		this.outlaies = outlaies;
	}

	public Set getIncomes() {
		return this.incomes;
	}

	public void setIncomes(Set incomes) {
		this.incomes = incomes;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

	public Set getSendNotificationPlans() {
		return this.sendNotificationPlans;
	}

	public void setSendNotificationPlans(Set sendNotificationPlans) {
		this.sendNotificationPlans = sendNotificationPlans;
	}

	public Set getUsers_1() {
		return this.users_1;
	}

	public void setUsers_1(Set users_1) {
		this.users_1 = users_1;
	}
}