package meetmanager.web.action;

import java.util.Date;
import java.util.List;

import meetmanager.model.Page;
import meetmanager.model.Sysaccount;
import meetmanager.model.TradeType;
import meetmanager.model.Units;
import meetmanager.model.UnitsType;
import meetmanager.service.TradeTypeService;
import meetmanager.service.UnitsService;
import meetmanager.service.UnitsTypeService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TradeTypeAction extends ActionSupport {
	private TradeTypeService tradeTypeService;
	private UnitsService unitsService;
	private UnitsTypeService unitsTypeService;
	private Units units;
	private List<TradeType> list;
	private List<TradeType> rlist;
	private List<UnitsType> tlist;
	private TradeType tradetype;
	private String result;// 返回ajax 结果
	private Integer[] selected;// 选择项
	private Integer parentid = 0;
	private Integer unittypeid = 0;
	private Page page;

	public void setTradeTypeService(TradeTypeService tradeTypeService) {
		this.tradeTypeService = tradeTypeService;
	}

	public void setUnitsService(UnitsService unitsService) {
		this.unitsService = unitsService;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String add() {
		try {
			if (unittypeid != null && unittypeid != 0) {
				tradetype.setUnitstype(unitsTypeService
						.getUnitsTypeById(unittypeid));
			}
			tradetype.setParentid(parentid);
			tradetype.setCreatetime(new Date());
			Sysaccount sysa = (Sysaccount) ActionContext.getContext()
					.getSession().get("account");
			Sysaccount sysa1 = new Sysaccount();
			sysa1.setId(sysa.getId());
			tradetype.setSysaccount(sysa1);
			tradeTypeService.addInstance(tradetype);
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
			tradeTypeService.deleteInstance(tradetype);
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

	public Integer[] getSelected() {
		return selected;
	}

	public String delselect() {
		// 要判断是不是次单位或个人创建
		Units operator = new Units();// (Units)
		// ActionContext.getContext().getSession().get("units");
		operator.setId(1);
		try {
			tradeTypeService.deleteSelectInstance(selected);
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
			if (unittypeid != null && unittypeid != 0) {
				tradetype.setUnitstype(unitsTypeService
						.getUnitsTypeById(unittypeid));
			}
			tradeTypeService.updateInstance(tradetype);
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
		if (parentid != null && parentid > 0) {
			tradetype=tradeTypeService.findInstanceById(parentid);
			list = tradeTypeService
					.findPageTradeTypesByParentId(parentid, page);
		} else {
			list = tradeTypeService.findPageRootTradeTypes(page);
		}
		rlist = tradeTypeService.findRootTradeTypes();
		tlist = unitsService.getAllUnitsType();
		return "listtradetype";
	}
	
	public List<TradeType> getList() {
		return list;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}

	public List<TradeType> getRlist() {
		return rlist;
	}

	public Integer getUnittypeid() {
		return unittypeid;
	}

	public void setUnittypeid(Integer unittypeid) {
		this.unittypeid = unittypeid;
	}

	public void setSelected(Integer[] selected) {
		this.selected = selected;
	}

	public TradeType getTradetype() {
		return tradetype;
	}

	public void setTradetype(TradeType tradetype) {
		this.tradetype = tradetype;
	}

	public Units getUnits() {
		return units;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public void setUnits(Units units) {
		this.units = units;
	}

	public List<UnitsType> getTlist() {
		return tlist;
	}

	public void setUnitsTypeService(UnitsTypeService unitsTypeService) {
		this.unitsTypeService = unitsTypeService;
	}

}
