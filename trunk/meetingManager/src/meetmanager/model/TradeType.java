package meetmanager.model;

import java.util.Date;

/**
 * Role entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TradeType implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private Integer id;
	private String name;
	private Integer parentid;
	private UnitsType unitstype;
	private Date createtime;
	private Sysaccount sysaccount;

	// Constructors

	public TradeType(Integer id, String name, Integer parentid,
			UnitsType unitstype, Date createtime, Sysaccount sysaccount) {
		super();
		this.id = id;
		this.name = name;
		this.parentid = parentid;
		this.unitstype = unitstype;
		this.createtime = createtime;
		this.sysaccount = sysaccount;
	}

	/** default constructor */
	public TradeType() {
	}

	/** full constructor */
	
	// Property accessors
	public Integer getId() {
		return this.id;
	}
	
	public Sysaccount getSysaccount() {
		return sysaccount;
	}
	
	public UnitsType getUnitstype() {
		return unitstype;
	}

	public void setUnitstype(UnitsType unitstype) {
		this.unitstype = unitstype;
	}

	public void setSysaccount(Sysaccount sysaccount) {
		this.sysaccount = sysaccount;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
}