package meetmanager.model;

/**
 * Relatives entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Relatives implements java.io.Serializable {

	// Fields

	private Integer id;
	private User userByUserid;
	private User userByTheirid;
	private String type;

	// Constructors

	/** default constructor */
	public Relatives() {
	}

	/** full constructor */
	public Relatives(User userByUserid, User userByTheirid, String type) {
		this.userByUserid = userByUserid;
		this.userByTheirid = userByTheirid;
		this.type = type;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUserByUserid() {
		return this.userByUserid;
	}

	public void setUserByUserid(User userByUserid) {
		this.userByUserid = userByUserid;
	}

	public User getUserByTheirid() {
		return this.userByTheirid;
	}

	public void setUserByTheirid(User userByTheirid) {
		this.userByTheirid = userByTheirid;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}