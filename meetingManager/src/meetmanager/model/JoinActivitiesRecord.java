package meetmanager.model;

/**
 * JoinActivitiesRecord entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class JoinActivitiesRecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private Activities activities;
	private User user;
	private Integer expendamount;
	private Integer expenditures;

	// Constructors

	public JoinActivitiesRecord(Integer id, Activities activities, User user,
			Integer expendamount, Integer expenditures) {
		super();
		this.id = id;
		this.activities = activities;
		this.user = user;
		this.expendamount = expendamount;
		this.expenditures = expenditures;
	}

	/** default constructor */
	public JoinActivitiesRecord() {
	}

	/** full constructor */
	
	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Activities getActivities() {
		return this.activities;
	}

	public void setActivities(Activities activities) {
		this.activities = activities;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getExpendamount() {
		return expendamount;
	}

	public void setExpendamount(Integer expendamount) {
		this.expendamount = expendamount;
	}

	public Integer getExpenditures() {
		return expenditures;
	}

	public void setExpenditures(Integer expenditures) {
		this.expenditures = expenditures;
	}

}