package meetmanager.web.action;

import java.util.List;

import meetmanager.model.Income;
import meetmanager.model.MeetingFeeItem;
import meetmanager.model.MeetingInfo;
import meetmanager.model.Outlay;
import meetmanager.model.Sysaccount;
import meetmanager.service.PaymentService;
import meetmanager.utils.dao.Page;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PaymentAction extends ActionSupport {
	private PaymentService paymentService;
	private MeetingInfo meetinginfo;
	private Income income;
	private Outlay outlay;
	private List<MeetingFeeItem> list;
	private String result;// 返回 ajax结果
	private Integer[] selected;// 选择项
	private Page page;
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JSON(serialize = false)
	public PaymentService getPaymentService() {
		return paymentService;
	}

	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public Income getIncome() {
		return income;
	}

	public void setIncome(Income income) {
		this.income = income;
	}

	public Outlay getOutlay() {
		return outlay;
	}

	public void setOutlay(Outlay outlay) {
		this.outlay = outlay;
	}

	public List<MeetingFeeItem> getList() {
		return list;
	}

	public void setList(List<MeetingFeeItem> list) {
		this.list = list;
	}

	public MeetingInfo getMeetinginfo() {
		return meetinginfo;
	}

	public void setMeetinginfo(MeetingInfo meetinginfo) {
		this.meetinginfo = meetinginfo;
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
			// meetingFeeItemService.addInstance(meetingfeeitem);
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

	public String idelete() {
		try {
			paymentService.deleteIncome(income);
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

	public String odelete() {
		try {
			paymentService.deleteOutlay(outlay);
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
			// meetingFeeItemService.deleteSelectInstance(selected);
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

	public String modifyi() {
		try {
			paymentService.updateIncome(income);
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

	public String modifyo() {
		try {
			paymentService.updateOutlay(outlay);
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
		list=paymentService.getAllMeetingFeeItem();
		meetinginfo=paymentService.getMeetingInfoById(meetinginfo.getId());
		return "list";
	}

	public String addoutlay() {
		try {
			Sysaccount sysa=(Sysaccount) ActionContext.getContext().getSession().get("account");
			outlay.setPerson(sysa.getUsername());
			paymentService.addOutlay(outlay);
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

	public String addincome() {
		try {
			paymentService.addIncome(income);
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
	public String checkusername(){
		try {
			username = paymentService.checkusername(username);
			// 添加成功信息
			result = "{\"success\":\"true\",\"msg\":\"成功\",\"user\":"+username+"}";
		} catch (Exception e) {
			// 添加失败信息
			result = "{\"success\":\"false\",\"msg\":\"失败" + e.getMessage() + "\",\"user\":[]}";
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String checkunitsname(){
		try {
			username = paymentService.checkunitsname(username);
			// 添加成功信息
			result = "{\"success\":\"true\",\"msg\":\"成功\",\"units\":"+username+"}";
		} catch (Exception e) {
			// 添加失败信息
			result = "{\"success\":\"false\",\"msg\":\"失败" + e.getMessage() + "\",\"units\":[]}";
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String statistics() {
		// 添加结果信息
		//result = "{\"income\":\""+in+"\",\"outlay\":\""+out+"\",\"balance\":\""+balance+"\"}";
		result = paymentService.getStatistics(meetinginfo.getId());
		return SUCCESS;
	}
}
