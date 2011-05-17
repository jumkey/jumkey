package org.cafeboy.model;

/**
 * Sypermission entity.
 * 
 * @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
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

	public String getPermissionid() {
		return this.permissionid;
	}

	public void setPermissionid(String permissionid) {
		this.permissionid = permissionid;
	}

	public Msphase getMsphase() {
		return this.msphase;
	}

	public void setMsphase(Msphase msphase) {
		this.msphase = msphase;
	}

	public Syrole getSyrole() {
		return this.syrole;
	}

	public void setSyrole(Syrole syrole) {
		this.syrole = syrole;
	}

}