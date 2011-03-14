package meetmanager.web.action;

import java.util.List;

import meetmanager.model.FeteRecord;
import meetmanager.service.FeteRecordService;
import meetmanager.utils.dao.Page;

import com.opensymphony.xwork2.ActionSupport;

public class FeteRecordAction extends ActionSupport {
	private FeteRecordService feteRecordService;
	private List<FeteRecord> list;
	private String result;// 返回ajax 结果
	private FeteRecord feterecord;
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

	public void setId(Integer id) {
		this.id = id;
	}

	public String delete() {
		// 要判断是不是次单位或个人创建
		try {
			feteRecordService.deleteInstance(feterecord);
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
			feteRecordService.deleteSelectInstance(selected);
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

	public String add() {
		try {
			feteRecordService.addInstance(feterecord);
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
			username = feteRecordService.checkUser(id, username);
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
		list = feteRecordService.findPageByFeteRecord(page, id);
		return "listfeterecord";
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

	public List<FeteRecord> getList() {
		return list;
	}

	public void setList(List<FeteRecord> list) {
		this.list = list;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public FeteRecord getFeterecord() {
		return feterecord;
	}

	public void setFeterecord(FeteRecord feterecord) {
		this.feterecord = feterecord;
	}

	public void setFeteRecordService(FeteRecordService feteRecordService) {
		this.feteRecordService = feteRecordService;
	}

	public Integer getId() {
		return id;
	}
}
