package meetmanager.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Role entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class RoomType implements java.io.Serializable {
	private Integer id;
	private String type;
	private Sysaccount sysaccount;
	private Date createtime;
    private Set<PriceRoomType> priceRoomTypes = new HashSet<PriceRoomType>(0);

	// Constructors

	public RoomType(Integer id, String type, Sysaccount sysaccount,
			Date createtime) {
		super();
		this.id = id;
		this.type = type;
		this.sysaccount = sysaccount;
		this.createtime = createtime;
	}

	/** default constructor */
	public RoomType() {
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
		return sysaccount;
	}

	public void setSysaccount(Sysaccount sysaccount) {
		this.sysaccount = sysaccount;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

    public Set<PriceRoomType> getPriceRoomTypes() {
        return priceRoomTypes;
    }

    public void setPriceRoomTypes(Set<PriceRoomType> priceRoomTypes) {
        this.priceRoomTypes = priceRoomTypes;
    }
}