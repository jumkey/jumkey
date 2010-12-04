package meetmanager.web.action;

import java.util.List;

import meetmanager.model.Fete;
import meetmanager.model.Meal;
import meetmanager.service.FeteService;
import meetmanager.service.MealService;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;

public class MealAction extends ActionSupport {
	private MealService mealService;
	private List<Meal> list;
	private String result;// 返回ajax 结果
	private Meal meal;
	private Integer[] selected;// 选择项
	private Integer meetingInfoId;
	
	
	public Integer getMeetingInfoId() {
		return meetingInfoId;
	}

	public void setMeetingInfoId(Integer meetingInfoId) {
		this.meetingInfoId = meetingInfoId;
	}

	public String delete() {
		//要判断是不是次单位或个人创建
		try {
			mealService.deleteInstance(meal);
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
		try {
			mealService.deleteSelectInstance(selected);
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
		try {
			// System.out.println(sysaccount.getDepartment().getId());
			mealService.updateInstance(meal);
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
			mealService.addInstance(meal);
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
	
	public String list() {
		list = mealService.findByMeal(meetingInfoId);
		return "listmeal";
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

	public List<Meal> getList() {
		return list;
	}

	public void setList(List<Meal> list) {
		this.list = list;
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public void setMealService(MealService mealService) {
		this.mealService = mealService;
	}




}
