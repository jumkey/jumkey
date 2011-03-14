package meetmanager.web.action;

import java.util.List;

import meetmanager.model.FeeItem;
import meetmanager.model.Units;
import meetmanager.service.FeeItemService;
import meetmanager.utils.dao.Page;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;

public class FeeItemAction extends ActionSupport{
	private FeeItemService feeItemService;
	private List<FeeItem> list;
	private FeeItem feeitem;
	private String result;// 返回 ajax结果
	private Integer[] selected;// 选择项
	private Page page;

	public FeeItem getFeeitem() {
		return feeitem;
	}

	public void setFeeitem(FeeItem feeitem) {
		this.feeitem = feeitem;
	}
	@JSON(serialize = false)
	public FeeItemService getFeeItemService() {
		return feeItemService;
	}

	public void setFeeItemService(FeeItemService feeItemService) {
		this.feeItemService = feeItemService;
	}

	public List<FeeItem> getList() {
		return list;
	}

	public void setList(List<FeeItem> list) {
		this.list = list;
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

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	public String add() {
		try {
			feeItemService.addInstance(feeitem);
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
		//要判断是不是次单位或个人创建
		Units operator = new Units();// (Units)
		// ActionContext.getContext().getSession().get("units");
		operator.setId(1);
		try {
			feeItemService.deleteInstance(feeitem);
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
		//要判断是不是次单位或个人创建
		Units operator = new Units();// (Units)
		// ActionContext.getContext().getSession().get("units");
		operator.setId(1);
		try {
			feeItemService.deleteSelectInstance(selected);
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
		//要判断是不是次单位或个人创建
		Units operator = new Units();// (Units)
		// ActionContext.getContext().getSession().get("units");
		operator.setId(1);
		try {
			// System.out.println(sysaccount.getDepartment().getId());
			feeitem = feeItemService.updateInstance(feeitem);
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

	public String list(){
		list=feeItemService.getAllFeeItem();
		return "listfeeitem";
	}
}
