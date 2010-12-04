package com.onegrid.meetmanager.model;

/**
 * RoleLimit entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class RoleLimit implements java.io.Serializable {

    private Integer id;

    private Integer roleid;

    private Integer limitid;

    // TODO 修改成对象
    // private Limit limitid;

    // private Role roleid;

    public RoleLimit() {
    }

    public RoleLimit(Integer id, Integer roleid, Integer limitid) {
        super();
        this.id = id;
        this.roleid = roleid;
        this.limitid = limitid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getLimitid() {
        return limitid;
    }

    public void setLimitid(Integer limitid) {
        this.limitid = limitid;
    }

}