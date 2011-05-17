package org.cafeboy.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TxbuildsplitId entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Embeddable
public class TxbuildsplitId implements java.io.Serializable {

	// Fields

	private String buildapplyid;
	private String parentid;

	// Constructors

	/** default constructor */
	public TxbuildsplitId() {
	}

	/** full constructor */
	public TxbuildsplitId(String buildapplyid, String parentid) {
		this.buildapplyid = buildapplyid;
		this.parentid = parentid;
	}

	// Property accessors

	@Column(name = "BUILDAPPLYID", nullable = false, length = 32)
	public String getBuildapplyid() {
		return this.buildapplyid;
	}

	public void setBuildapplyid(String buildapplyid) {
		this.buildapplyid = buildapplyid;
	}

	@Column(name = "PARENTID", nullable = false, length = 32)
	public String getParentid() {
		return this.parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TxbuildsplitId))
			return false;
		TxbuildsplitId castOther = (TxbuildsplitId) other;

		return ((this.getBuildapplyid() == castOther.getBuildapplyid()) || (this.getBuildapplyid() != null && castOther.getBuildapplyid() != null && this.getBuildapplyid().equals(castOther.getBuildapplyid()))) && ((this.getParentid() == castOther.getParentid()) || (this.getParentid() != null && castOther.getParentid() != null && this.getParentid().equals(castOther.getParentid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getBuildapplyid() == null ? 0 : this.getBuildapplyid().hashCode());
		result = 37 * result + (getParentid() == null ? 0 : this.getParentid().hashCode());
		return result;
	}

}