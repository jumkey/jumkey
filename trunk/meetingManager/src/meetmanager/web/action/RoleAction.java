package meetmanager.web.action;

import java.util.Date;
import java.util.List;

import meetmanager.model.Page;
import meetmanager.model.Role;
import meetmanager.model.Sysaccount;
import meetmanager.service.RoleService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RoleAction extends ActionSupport {

	private RoleService roleService;
	private List<Role> list;
	private Role role;
	private String result;// 返回ajax 结果
	private Integer[] selected;// 选择项
	private Page page;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Integer[] getSelected() {
		return selected;
	}

	public void setSelected(Integer[] selected) {
		this.selected = selected;
	}

	public String add() {
		try {
			role.setCreatetime(new Date());
			Sysaccount sysa = (Sysaccount) ActionContext.getContext()
					.getSession().get("account");
			Sysaccount sysa1 = new Sysaccount();
			sysa1.setId(sysa.getId());
			role.setSysaccount(sysa1);
			roleService.addInstance(role);
			// 添加成功信息
			result = "{\"success\":\"true\",\"msg\":\"添加成功\"}";
		} catch (Exception e) {
			// 添加失败信息
			result = "{\"success\":\"false\",\"msg\":\"添加失败" + e.getMessage()
					+ "\"}";
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String delete() {
		try {
			roleService.deleteInstance(role);
			// 添加成功信息
			result = "{\"success\":\"true\",\"msg\":\"删除成功\"}";
		} catch (Exception e) {
			// 添加失败信息
			result = "{\"success\":\"false\",\"msg\":\"删除失败" + e.getMessage()
					+ "\"}";
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String delselect() {
		try {
			roleService.deleteSelectInstance(selected);
			// 添加成功信息
			result = "{\"success\":\"true\",\"msg\":\"批量删除成功\"}";
		} catch (Exception e) {
			// 添加失败信息
			result = "{\"success\":\"false\",\"msg\":\"批量删除失败" + e.getMessage()
					+ "\"}";
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String modify() {
		try {
			roleService.updateInstance(role);
			// 添加成功信息
			result = "{\"success\":\"true\",\"msg\":\"修改成功\"}";
		} catch (Exception e) {
			// 添加失败信息
			result = "{\"success\":\"false\",\"msg\":\"修改失败" + e.getMessage()
					+ "\"}";
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String list() {
		if (page == null) {
			page = new Page();
		}
		list = roleService.getPageRole(page);
		return "listrole";
	}

	public List<Role> getList() {
		return list;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}

	public void setList(List<Role> list) {
		this.list = list;
	}
}
