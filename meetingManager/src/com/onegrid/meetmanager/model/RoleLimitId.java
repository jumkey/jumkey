package com.onegrid.meetmanager.model;

/**
 * RoleLimitId entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class RoleLimitId implements java.io.Serializable {

	// Fields

	private Limit limit;
	private Role role;

	// Constructors

	/** default constructor */
	public RoleLimitId() {
	}

	/** full constructor */
	public RoleLimitId(Limit limit, Role role) {
		this.limit = limit;
		this.role = role;
	}

	// Property accessors

	public Limit getLimit() {
		return this.limit;
	}

	public void setLimit(Limit limit) {
		this.limit = limit;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RoleLimitId))
			return false;
		RoleLimitId castOther = (RoleLimitId) other;

		return ((this.getLimit() == castOther.getLimit()) || (this.getLimit() != null
				&& castOther.getLimit() != null && this.getLimit().equals(
				castOther.getLimit())))
				&& ((this.getRole() == castOther.getRole()) || (this.getRole() != null
						&& castOther.getRole() != null && this.getRole()
						.equals(castOther.getRole())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getLimit() == null ? 0 : this.getLimit().hashCode());
		result = 37 * result
				+ (getRole() == null ? 0 : this.getRole().hashCode());
		return result;
	}

}