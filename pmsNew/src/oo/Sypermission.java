package org.cafeboy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Sypermission entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SYPERMISSION", schema = "JUMKEY")
public class Sypermission implements java.io.Serializable {

	// Fields

	private String permissionid;
	private Msphase msphase;
	private Syrole syrole;

	// Constructors

	/** default constructor */
	public Sypermission() {
	}

	/** minimal constructor */
	public Sypermission(Syrole syrole) {
		this.syrole = syrole;
	}

	/** full constructor */
	public Sypermission(Msphase msphase, Syrole syrole) {
		this.msphase = msphase;
		this.syrole = syrole;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "PERMISSIONID", unique = true, nullable = false, length = 32)
	public String getPermissionid() {
		return this.permissionid;
	}

	public void setPermissionid(String permissionid) {
		this.permissionid = permissionid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PHASEID")
	public Msphase getMsphase() {
		return this.msphase;
	}

	public void setMsphase(Msphase msphase) {
		this.msphase = msphase;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLEID", nullable = false)
	public Syrole getSyrole() {
		return this.syrole;
	}

	public void setSyrole(Syrole syrole) {
		this.syrole = syrole;
	}

}