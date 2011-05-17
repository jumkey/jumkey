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
 * Syuser entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SYUSER", schema = "JUMKEY")
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
	@Id
	@GeneratedValue
	@Column(name = "USERID", unique = true, nullable = false, length = 32)
	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GROUPID")
	public Sygroup getSygroup() {
		return this.sygroup;
	}

	public void setSygroup(Sygroup sygroup) {
		this.sygroup = sygroup;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLEID")
	public Syrole getSyrole() {
		return this.syrole;
	}

	public void setSyrole(Syrole syrole) {
		this.syrole = syrole;
	}

	@Column(name = "LOGINNAME", nullable = false)
	public String getLoginname() {
		return this.loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	@Column(name = "USERNAME", length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "ACTIVESYMBOL", nullable = false, precision = 1, scale = 0)
	public Long getActivesymbol() {
		return this.activesymbol;
	}

	public void setActivesymbol(Long activesymbol) {
		this.activesymbol = activesymbol;
	}

	@Column(name = "DELETESYMBOL", nullable = false, precision = 1, scale = 0)
	public Long getDeletesymbol() {
		return this.deletesymbol;
	}

	public void setDeletesymbol(Long deletesymbol) {
		this.deletesymbol = deletesymbol;
	}

	@Column(name = "OFFICENUMBER", length = 20)
	public String getOfficenumber() {
		return this.officenumber;
	}

	public void setOfficenumber(String officenumber) {
		this.officenumber = officenumber;
	}

	@Column(name = "MOBILENUMBER", length = 100)
	public String getMobilenumber() {
		return this.mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	@Column(name = "EMAIL", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}