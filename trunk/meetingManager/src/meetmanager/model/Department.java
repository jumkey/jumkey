package meetmanager.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Department entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Department implements java.io.Serializable {

	// Fields

	private Integer id;
	private Sysaccount sysaccount;
	private Department department;
	private String departmentname;
	private Date createtime;
	private Set sysaccounts = new HashSet(0);
	private Set departments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** minimal constructor */
	public Department(String departmentname) {
		this.departmentname = departmentname;
	}

	/** full constructor */
	public Department(Sysaccount sysaccount, Department department,
			String departmentname, Date createtime, Set sysaccounts,
			Set departments) {
		this.sysaccount = sysaccount;
		this.department = department;
		this.departmentname = departmentname;
		this.createtime = createtime;
		this.sysaccounts = sysaccounts;
		this.departments = departments;
	}

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

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getDepartmentname() {
		return this.departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Set getSysaccounts() {
		return this.sysaccounts;
	}

	public void setSysaccounts(Set sysaccounts) {
		this.sysaccounts = sysaccounts;
	}

	public Set getDepartments() {
		return this.departments;
	}

	public void setDepartments(Set departments) {
		this.departments = departments;
	}

}