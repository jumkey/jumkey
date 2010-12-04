package com.onegrid.meetmanager.web.action;

import java.util.List;

import com.onegrid.meetmanager.model.Limit;
import com.onegrid.meetmanager.model.Role;
import com.onegrid.meetmanager.model.RoleLimit;
import com.onegrid.meetmanager.service.LimitService;
import com.onegrid.meetmanager.service.RoleLimitService;
import com.onegrid.meetmanager.service.RoleService;
import com.opensymphony.xwork2.ActionSupport;

public class RoleLimitAction extends ActionSupport {
	private RoleLimitService roleLimitService;
	private LimitService limitService;
	private RoleService roleService;
	private List<RoleLimit> list;
	private List<RoleLimit> roleLimitlist;
	private List<Limit> llist;
	private List<Role> rlist;
	private RoleLimit roleLimit;
	private String result;
	private Integer roleId;
	private String limitIdStr;
	private Integer limitId;
	private String uncheckedstr;

	public List<RoleLimit> getRoleLimitlist() {
		return roleLimitlist;
	}

	public void setRoleLimitService(RoleLimitService roleLimitService) {
		this.roleLimitService = roleLimitService;
	}

	public void setLimitService(LimitService limitService) {
		this.limitService = limitService;
	}

	public String list() {
		if (roleId != null && !roleId.equals("")) {
			if (limitIdStr != null && !limitIdStr.equals("")) {
				String subLimitIdStr = limitIdStr.substring(0, limitIdStr
						.length() - 1);
				String[] limitarr = subLimitIdStr.split(",");
				for (int i = 0; i < limitarr.length; i++) {
					limitId = Integer.valueOf(limitarr[i]);
					List<RoleLimit> roleLimitList = roleLimitService
							.findRoleLimitByRoleIdAndLimitId(roleId, limitId);
					if (roleLimitList == null || roleLimitList.size() == 0) {
						RoleLimit roleLimit1 = new RoleLimit();
						
						// TODO 修改成对象
//						Role role=new Role();
//						role.setId(roleId);
//						
//						Limit limit=new Limit();
//						limit.setId(limitId);
						
						roleLimit1.setRoleid(roleId);
						roleLimit1.setLimitid(limitId);
						roleLimitService.addInstance(roleLimit1);
					}
				}
			}
			if (uncheckedstr != null && !uncheckedstr.equals("")) {
				String unchecked = uncheckedstr.substring(0, uncheckedstr
						.length() - 1);
				String[] uncheckedarr = unchecked.split(",");
				for (int i = 0; i < uncheckedarr.length; i++) {
					Integer unCheckId = Integer.valueOf(uncheckedarr[i]);
					List<RoleLimit> roleLimitList2 = roleLimitService
							.findRoleLimitByRoleIdAndLimitId(roleId, unCheckId);
					if (roleLimitList2.size() != 0) {
						roleLimitService.deleteInstance(roleLimitList2.get(0));
					}
				}
			}
			roleLimitlist = roleLimitService.getRoleLimitListByRoleId(roleId);
		}
		list = roleLimitService.getAllRoleLimit();
		llist = limitService.getAllLimit();
		rlist = roleService.getAllRole();
		return "listrolelimit";
	}

	public List<Role> getRlist() {
		return rlist;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}

	public String getLimitIdStr() {
		return limitIdStr;
	}

	public String getUncheckedstr() {
		return uncheckedstr;
	}

	public void setUncheckedstr(String uncheckedstr) {
		this.uncheckedstr = uncheckedstr;
	}

	public void setLimitIdStr(String limitIdStr) {
		this.limitIdStr = limitIdStr;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getLimitId() {
		return limitId;
	}

	public void setLimitId(Integer limitId) {
		this.limitId = limitId;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public RoleLimit getRoleLimit() {
		return roleLimit;
	}

	public void setRoleLimit(RoleLimit roleLimit) {
		this.roleLimit = roleLimit;
	}

	public List<RoleLimit> getList() {
		return list;
	}

	public List<Limit> getLlist() {
		return llist;
	}

}
