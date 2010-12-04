package meetmanager.web.action;

import java.util.List;

import meetmanager.model.JoinActivitiesRecord;
import meetmanager.model.Page;
import meetmanager.service.JoinActivitiesRecordService;

import com.opensymphony.xwork2.ActionSupport;

public class JoinActivitiesRecordAction extends ActionSupport {
	private JoinActivitiesRecordService joinActivitiesRecordService;
	private List<JoinActivitiesRecord> list;
	private String result;// 返回ajax 结果
	private JoinActivitiesRecord joinactivities;
	private Integer[] selected;// 选择项
	private Integer id;
	private String username;
	private Page page;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String delete() {
		// 要判断是不是次单位或个人创建
		try {
			joinActivitiesRecordService.deleteInstance(joinactivities);
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
		// 要判断是不是次单位或个人创建
		try {
			joinActivitiesRecordService.deleteSelectInstance(selected);
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
		// 要判断是不是次单位或个人创建
		try {
			// System.out.println(sysaccount.getDepartment().getId());
			joinActivitiesRecordService.updateInstance(joinactivities);
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

	public String add() {
		try {
			// System.out.println(sysaccount.getDepartment().getId());
			joinActivitiesRecordService.addInstance(joinactivities);
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

	public String checkusername() {
		try {
			username = joinActivitiesRecordService.checkUser(id, username);
			// 添加成功信息
			result = "{\"success\":\"true\",\"msg\":\"成功\",\"user\":"
					+ username + "}";
		} catch (Exception e) {
			// 添加失败信息
			result = "{\"success\":\"false\",\"msg\":\"失败" + e.getMessage()
					+ "\",\"user\":[]}";
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String list() {
		if (page == null) {
			page = new Page();
		}
		list = joinActivitiesRecordService
				.findPageByJoinActivitiesRecordByActivitiesId(page, id);
		return "listjoinactivities";
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer[] getSelected() {
		return selected;
	}

	public void setSelected(Integer[] selected) {
		this.selected = selected;
	}

	public List<JoinActivitiesRecord> getList() {
		return list;
	}

	public void setList(List<JoinActivitiesRecord> list) {
		this.list = list;
	}

	public JoinActivitiesRecord getJoinactivities() {
		return joinactivities;
	}

	public void setJoinactivities(JoinActivitiesRecord joinactivities) {
		this.joinactivities = joinactivities;
	}

	public void setJoinActivitiesRecordService(
			JoinActivitiesRecordService joinActivitiesRecordService) {
		this.joinActivitiesRecordService = joinActivitiesRecordService;
	}

}
