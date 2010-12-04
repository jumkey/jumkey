package meetmanager.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Sysaccount entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Sysaccount implements java.io.Serializable {

    // Fields

    private Integer id;

    private Sysaccount sysaccount;

    private Department department;

    private Role role;

    private String account;

    private String password;

    private String username;

    private Integer sex;

    private String phone;

    private String zip;

    private String address;

    private Date createtime;

    private Set limits = new HashSet(0);

    private Set meetingFeeItems = new HashSet(0);

    private Set incomes = new HashSet(0);

    private Set sysaccounts = new HashSet(0);

    private Set departments = new HashSet(0);

    private Set sendNotificationPlans = new HashSet(0);

    private Set meetingFeeItemProperties = new HashSet(0);

    private Set meetingInfos = new HashSet(0);

    private Set roles = new HashSet(0);

    private Set outlaies = new HashSet(0);

    // Constructors

    /** default constructor */
    public Sysaccount() {
    }

    /** minimal constructor */
    public Sysaccount(Department department, String account, String password) {
        this.department = department;
        this.account = account;
        this.password = password;
    }

    /** full constructor */
    public Sysaccount(Sysaccount sysaccount, Department department, Role role,
            String account, String password, String username, Integer sex,
            String phone, String zip, String address, Date createtime,
            Set limits, Set meetingFeeItems, Set incomes, Set sysaccounts,
            Set departments, Set sendNotificationPlans, Set roles,
            Set meetingFeeItemProperties, Set meetingInfos, Set outlaies) {
        this.sysaccount = sysaccount;
        this.department = department;
        this.role = role;
        this.account = account;
        this.password = password;
        this.username = username;
        this.sex = sex;
        this.phone = phone;
        this.zip = zip;
        this.address = address;
        this.createtime = createtime;
        this.limits = limits;
        this.meetingFeeItems = meetingFeeItems;
        this.incomes = incomes;
        this.sysaccounts = sysaccounts;
        this.departments = departments;
        this.sendNotificationPlans = sendNotificationPlans;
        this.meetingFeeItemProperties = meetingFeeItemProperties;
        this.meetingInfos = meetingInfos;
        this.roles = roles;
        this.outlaies = outlaies;
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

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getSex() {
        return this.sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZip() {
        return this.zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Set getLimits() {
        return this.limits;
    }

    public void setLimits(Set limits) {
        this.limits = limits;
    }

    public Set getMeetingFeeItems() {
        return this.meetingFeeItems;
    }

    public void setMeetingFeeItems(Set meetingFeeItems) {
        this.meetingFeeItems = meetingFeeItems;
    }

    public Set getIncomes() {
        return this.incomes;
    }

    public void setIncomes(Set incomes) {
        this.incomes = incomes;
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

    public Set getSendNotificationPlans() {
        return this.sendNotificationPlans;
    }

    public void setSendNotificationPlans(Set sendNotificationPlans) {
        this.sendNotificationPlans = sendNotificationPlans;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set getMeetingFeeItemProperties() {
        return this.meetingFeeItemProperties;
    }

    public void setMeetingFeeItemProperties(Set meetingFeeItemProperties) {
        this.meetingFeeItemProperties = meetingFeeItemProperties;
    }

    public Set getMeetingInfos() {
        return this.meetingInfos;
    }

    public void setMeetingInfos(Set meetingInfos) {
        this.meetingInfos = meetingInfos;
    }

    public Set getOutlaies() {
        return this.outlaies;
    }

    public void setOutlaies(Set outlaies) {
        this.outlaies = outlaies;
    }

    public Set getRoles() {
        return roles;
    }

    public void setRoles(Set roles) {
        this.roles = roles;
    }

}