package org.cafeboy.model;

/**
 * Syuser entity.
 * 
 * @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Syuser implements java.io.Serializable {

	// Fields

	private String userid;
	private Sygroup sygroup;
	private Syrole syrole;
	private String loginname;
	private String username;
	private String password;
	private Long activesymbol;
	private Long deletesymbol;
	private String officenumber;
	private String mobilenumber;
	private String email;

	// Constructors

	/** default constructor */
	public Syuser() {
	}

	/** minimal constructor */
	public Syuser(String loginname, String password, Long activesymbol, Long deletesymbol) {
		this.loginname = loginname;
		this.password = password;
		this.activesymbol = activesymbol;
		this.deletesymbol = deletesymbol;
	}

	/** full constructor */
	public Syuser(Sygroup sygroup, Syrole syrole, String loginname, String username, String password, Long activesymbol, Long deletesymbol, String officenumber, String mobilenumber, String email) {
		this.sygroup = sygroup;
		this.syrole = syrole;
		this.loginname = loginname;
		this.username = username;
		this.password = password;
		this.activesymbol = activesymbol;
		this.deletesymbol = deletesymbol;
		this.officenumber = officenumber;
		this.mobilenumber = mobilenumber;
		this.email = email;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Sygroup getSygroup() {
		return this.sygroup;
	}

	public void setSygroup(Sygroup sygroup) {
		this.sygroup = sygroup;
	}

	public Syrole getSyrole() {
		return this.syrole;
	}

	public void setSyrole(Syrole syrole) {
		this.syrole = syrole;
	}

	public String getLoginname() {
		return this.loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getActivesymbol() {
		return this.activesymbol;
	}

	public void setActivesymbol(Long activesymbol) {
		this.activesymbol = activesymbol;
	}

	public Long getDeletesymbol() {
		return this.deletesymbol;
	}

	public void setDeletesymbol(Long deletesymbol) {
		this.deletesymbol = deletesymbol;
	}

	public String getOfficenumber() {
		return this.officenumber;
	}

	public void setOfficenumber(String officenumber) {
		this.officenumber = officenumber;
	}

	public String getMobilenumber() {
		return this.mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}