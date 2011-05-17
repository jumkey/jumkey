package org.cafeboy.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TxclientsplitId entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Embeddable
public class TxclientsplitId implements java.io.Serializable {

	// Fields

	private String buildapplyid;
	private String relateid;

	// Constructors

	/** default constructor */
	public TxclientsplitId() {
	}

	/** full constructor */
	public TxclientsplitId(String buildapplyid, String relateid) {
		this.buildapplyid = buildapplyid;
		this.relateid = relateid;
	}

	// Property accessors

	@Column(name = "BUILDAPPLYID", nullable = false, length = 32)
	public String getBuildapplyid() {
		return this.buildapplyid;
	}

	public void setBuildapplyid(String buildapplyid) {
		this.buildapplyid = buildapplyid;
	}

	@Column(name = "RELATEID", nullable = false, length = 32)
	public String getRelateid() {
		return this.relateid;
	}

	public void setRelateid(String relateid) {
		this.relateid = relateid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TxclientsplitId))
			return false;
		TxclientsplitId castOther = (TxclientsplitId) other;

		return ((this.getBuildapplyid() == castOther.getBuildapplyid()) || (this.getBuildapplyid() != null && castOther.getBuildapplyid() != null && this.getBuildapplyid().equals(castOther.getBuildapplyid()))) && ((this.getRelateid() == castOther.getRelateid()) || (this.getRelateid() != null && castOther.getRelateid() != null && this.getRelateid().equals(castOther.getRelateid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getBuildapplyid() == null ? 0 : this.getBuildapplyid().hashCode());
		result = 37 * result + (getRelateid() == null ? 0 : this.getRelateid().hashCode());
		return result;
	}

}