package meetmanager.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Limit entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Limit implements java.io.Serializable {

	// Fields

	private Integer id;
	private Sysaccount sysaccount;
	private String name;
	private String code;
	private Date createtime;
	private Set roleLimits = new HashSet(0);

	// Constructors

	public Limit(Integer id, Sysaccount sysaccount, String name, String code,
			Date createtime, Set roleLimits) {
		super();
		this.id = id;
		this.sysaccount = sysaccount;
		this.name = name;
		this.code = code;
		this.createtime = createtime;
		this.roleLimits = roleLimits;
	}

	/** default constructor */
	public Limit() {
	}

	/** full constructor */
	

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Set getRoleLimits() {
		return this.roleLimits;
	}

	public void setRoleLimits(Set roleLimits) {
		this.roleLimits = roleLimits;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}