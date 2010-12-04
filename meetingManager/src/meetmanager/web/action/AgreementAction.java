package meetmanager.web.action;

import java.util.List;

import meetmanager.model.Agreement;
import meetmanager.model.MeetingInfo;
import meetmanager.service.AgreementService;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;

public class AgreementAction extends ActionSupport {
	private AgreementService agreementService;
	private List<Agreement> list;
	private Agreement agreement;
	private Integer[] selected;// 选择项
	private String result;// 返回ajax 结果
	
	@JSON(serialize = false)
	public AgreementService getAgreementService() {
		return agreementService;
	}

	public void setAgreementService(AgreementService agreementService) {
		this.agreementService = agreementService;
	}

	public List<Agreement> getList() {
		return list;
	}

	public void setList(List<Agreement> list) {
		this.list = list;
	}

	public Agreement getAgreement() {
		return agreement;
	}

	public void setAgreement(Agreement agreement) {
		this.agreement = agreement;
	}
	
	public Integer[] getSelected() {
		return selected;
	}

	public void setSelected(Integer[] selected) {
		this.selected = selected;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String add() {
		try {
			agreementService.addInstance(agreement);
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
			agreement=agreementService.updateInstance(agreement);
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

	public String show() {
		try {
			Agreement temp=agreementService.getInstance(agreement);
			
			MeetingInfo meet=new MeetingInfo();
			meet.setId(temp.getMeetingInfo().getId());
			meet.setTitle(temp.getMeetingInfo().getTitle());
			meet.setAuthor(temp.getMeetingInfo().getAuthor());
			
			agreement.setMeetingInfo(meet);
			agreement.setId(temp.getId());
			agreement.setTravelContact(temp.getTravelContact());
			agreement.setTravelPhone(temp.getTravelPhone());
			agreement.setHotelContacts(temp.getHotelContacts());
			agreement.setHotelPhone(temp.getHotelPhone());
			agreement.setHoteldeposit(temp.getHoteldeposit());
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
		list = agreementService.getAllAgreement();
		return "list";
	}
}
