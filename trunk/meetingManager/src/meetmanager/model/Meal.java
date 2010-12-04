package meetmanager.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Fete entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Meal implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer type;
	private Double money;
	private Double drinkscost;
	private Double expenses;
	private Integer mealtime;
	private Integer number;
	private String address;
	private MeetingInfo meetingInfo;
	private Date date;


	// Constructors

	/** default constructor */
	public Meal() {
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getType() {
		return type;
	}


	public void setType(Integer type) {
		this.type = type;
	}


	public Double getMoney() {
		return money;
	}


	public void setMoney(Double money) {
		this.money = money;
	}


	public Double getDrinkscost() {
		return drinkscost;
	}


	public void setDrinkscost(Double drinkscost) {
		this.drinkscost = drinkscost;
	}


	public Double getExpenses() {
		return expenses;
	}


	public void setExpenses(Double expenses) {
		this.expenses = expenses;
	}


	public Integer getMealtime() {
		return mealtime;
	}


	public void setMealtime(Integer mealtime) {
		this.mealtime = mealtime;
	}


	public Integer getNumber() {
		return number;
	}


	public void setNumber(Integer number) {
		this.number = number;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public MeetingInfo getMeetingInfo() {
		return meetingInfo;
	}


	public void setMeetingInfo(MeetingInfo meetingInfo) {
		this.meetingInfo = meetingInfo;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Meal(Integer id, Integer type, Double money, Double drinkscost,
			Double expenses, Integer mealtime, Integer number, String address,
			MeetingInfo meetingInfo, Date date) {
		super();
		this.id = id;
		this.type = type;
		this.money = money;
		this.drinkscost = drinkscost;
		this.expenses = expenses;
		this.mealtime = mealtime;
		this.number = number;
		this.address = address;
		this.meetingInfo = meetingInfo;
		this.date = date;
	}

	/** full constructor */
	
}