package meetmanager.web.action;

import java.util.List;

import meetmanager.model.TradeType;
import meetmanager.model.Units;
import meetmanager.model.UnitsType;
import meetmanager.service.TradeTypeService;
import meetmanager.service.UnitsService;
import meetmanager.utils.dao.Page;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;

public class UnitsAction extends ActionSupport {
	private UnitsService unitsService;
	private TradeTypeService tradeTypeService;
	private List<Units> list;
	private List<UnitsType> tlist;
	private List<TradeType> ttlist;
	private Units units;
	private String result;// 返回ajax 结果
	private Integer[] selected;// 选择项
	private Integer typeId = 0;
	private String unitName = "";
	private Page page;

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getUnitName() {
		return unitName;
	}

	public List<TradeType> getTtlist() {
		return ttlist;
	}

	public void setTradeTypeService(TradeTypeService tradeTypeService) {
		this.tradeTypeService = tradeTypeService;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	@JSON(serialize = false)
	public UnitsService getUnitsService() {
		return unitsService;
	}

	public void setUnitsService(UnitsService unitsService) {
		this.unitsService = unitsService;
	}

	public Units getUnits() {
		return units;
	}

	public List<UnitsType> getTlist() {
		return tlist;
	}

	public void setTlist(List<UnitsType> tlist) {
		this.tlist = tlist;
	}

	public void setUnits(Units units) {
		this.units = units;
	}

	public List<Units> getList() {
		return list;
	}

	public void setList(List<Units> list) {
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

	public String add() {
		try {
			unitsService.addInstance(units);
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

	public String modify() {
		try {
			unitsService.updateInstance(units);
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
		tlist = unitsService.getAllUnitsType();
		list = unitsService.findPageUnitsForSeach(page, typeId, unitName);
		ttlist = tradeTypeService.getAllTradeType();
		return "list";
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String listcompany() {
		list = unitsService.getUnitsByType(1);
		return "listcompany";
	}

	public String listdesign() {
		list = unitsService.getUnitsByType(2);
		return "listdesign";
	}

	public String listuser() {
		units = unitsService.getUnitsById(units.getId());
		return "listuser";
	}

}
