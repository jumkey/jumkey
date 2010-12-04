package meetmanager.web.action;

import java.util.List;

import meetmanager.model.Income;
import meetmanager.model.MeetingInfo;
import meetmanager.model.Reach;
import meetmanager.model.Register;
import meetmanager.service.ReachService;
import meetmanager.utils.RandomAwardToolkits;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;

public class ReachAction extends ActionSupport {
	private ReachService reachService;
	private MeetingInfo meetinginfo;
	private String result;// 返回ajax 结果
	private Register register;
	private Integer perid;// 个人编号||单位编号
	private Income income1;// 个人
	private Income income2;// 团体
	private double money;// 报到费
	private Integer[] selected;// 选择项
	private String username;
	private String jiashuname;
	private Integer personalOptions;
	private List<Reach> reachs;

	public String getJiashuname() {
		return jiashuname;
	}

	public void setJiashuname(String jiashuname) {
		this.jiashuname = jiashuname;
	}

	public Integer getPersonalOptions() {
		return personalOptions;
	}

	public void setPersonalOptions(Integer personalOptions) {
		this.personalOptions = personalOptions;
	}

	public void setReachs(List<Reach> reachs) {
		this.reachs = reachs;
	}

	public List<Reach> getReachs() {
		return reachs;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Income getIncome1() {
		return income1;
	}

	public void setIncome1(Income income1) {
		this.income1 = income1;
	}

	public Income getIncome2() {
		return income2;
	}

	public void setIncome2(Income income2) {
		this.income2 = income2;
	}

	public MeetingInfo getMeetinginfo() {
		return meetinginfo;
	}

	public void setMeetinginfo(MeetingInfo meetinginfo) {
		this.meetinginfo = meetinginfo;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public Integer getPerid() {
		return perid;
	}

	public void setPerid(Integer perid) {
		this.perid = perid;
	}

	@JSON(serialize = false)
	public ReachService getReachService() {
		return reachService;
	}

	public void setReachService(ReachService reachService) {
		this.reachService = reachService;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Register getRegister() {
		return register;
	}

	public void setRegister(Register register) {
		this.register = register;
	}

	public Integer[] getSelected() {
		return selected;
	}

	public void setSelected(Integer[] selected) {
		this.selected = selected;
	}

	public String checkuser() {
		result = reachService.checkuser(perid, register.getMeetingid().getId());
		return SUCCESS;
	}

	public String checkunits() {
		result = reachService
				.checkunits(perid, register.getMeetingid().getId());
		return SUCCESS;
	}

	public String add() {
		try {
			String award = reachService.addInstance(register, income1, income2);
			// 添加成功信息
			result = "{\"success\":\"true\",\"msg\":\"添加成功，编号为：" + award
					+ "\",\"award\":\"" + register.getAward() + "\"}";
		} catch (Exception e) {
			// 添加失败信息
			result = "{\"success\":\"false\",\"msg\":\"添加失败" + e.getMessage()
					+ "\"}";
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String fajiang() {
		try {
			reachService.dofajiang(register);
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

	public String yajin() {
		try {
			reachService.doyajin(register);
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

	public String yaoshi() {
		try {
			reachService.doyaoshi(register);
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

	public String qiandao() {
		try {
			reachService.doqiandao(register);
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

	public String ziliao() {
		try {
			reachService.doziliao(register);
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
		reachs = reachService.getReachsByMeetingId(meetinginfo.getId());
		// meetinginfo = reachService.getMeetingInfoById(meetinginfo.getId());
		return "list";
	}

	public String zhusu() {
		meetinginfo = reachService.getMeetingInfoById(meetinginfo.getId());
		result = "zhusu";
		return "reach";
	}

	public String shoufei() {
		meetinginfo = reachService.getMeetingInfoById(meetinginfo.getId());
		result = "shoufei";
		return "reach";
	}

	public String baodao() {
		meetinginfo = reachService.getMeetingInfoById(meetinginfo.getId());
		result = "baodao";
		return "reach";
	}

	public String makecord() {
		meetinginfo = reachService.getMeetingInfoById(meetinginfo.getId());
		return "makecord";
	}

	public String makecords() {
		try {
			// 添加成功信息
			result = "{\"success\":\"true\",\"msg\":\"成功\",\"units\":"
					+ username + "}";
		} catch (Exception e) {
			// 添加失败信息
			result = "{\"success\":\"false\",\"msg\":\"失败" + e.getMessage()
					+ "\",\"units\":[]}";
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * @deprecated
	 * @return
	 */
	public String checkusername() {
		try {
			username = reachService.checkusername(perid, username, jiashuname,
					personalOptions);
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

	public String checkusername_x() {
		try {
			username = reachService.checkusername_x(perid, username,
					jiashuname, personalOptions);
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

	public String checkreachedusername() {
		try {
			username = reachService.checkreachedusername(perid, username);
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

	public String checkunitsname() {
		try {
			username = reachService.checkunitsname(perid, username);
			// 添加成功信息
			result = "{\"success\":\"true\",\"msg\":\"成功\",\"units\":"
					+ username + "}";
		} catch (Exception e) {
			// 添加失败信息
			result = "{\"success\":\"false\",\"msg\":\"失败" + e.getMessage()
					+ "\",\"units\":[]}";
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String findRegister() {
		try {
			Register r = reachService.findRegister(register);
			if (r == null) {
				result = "{\"success\":\"false\",\"msg\":\"失败 此人还未报到(缴费)\"}";
			} else {
				// 添加成功信息
				result = "{\"success\":\"true\",\"msg\":\"成功\",\"code\":"
						+ r.getCode() + "}";
			}
		} catch (Exception e) {
			// 添加失败信息
			result = "{\"success\":\"false\",\"msg\":\"失败" + e.getMessage()
					+ "\",\"units\":[]}";
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
