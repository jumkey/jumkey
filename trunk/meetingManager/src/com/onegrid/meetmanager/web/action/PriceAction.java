package com.onegrid.meetmanager.web.action;

import java.util.HashSet;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.onegrid.meetmanager.model.Agreement;
import com.onegrid.meetmanager.model.Price;
import com.onegrid.meetmanager.model.PriceRoomType;
import com.onegrid.meetmanager.model.RoomType;
import com.onegrid.meetmanager.model.Units;
import com.onegrid.meetmanager.service.PriceService;
import com.opensymphony.xwork2.ActionSupport;

public class PriceAction extends ActionSupport {
	private PriceService priceService;
	private List<Price> list;
    private List<RoomType> rt;
    private List<PriceRoomType> prt;
	private String result;// 返回ajax 结果
	private Price price;
	private String unitsname;
	private Integer[] selected;// 选择项

	public List<RoomType> getRt() {
        return rt;
    }

    public void setRt(List<RoomType> rt) {
        this.rt = rt;
    }

    public void setPrt(List<PriceRoomType> prt) {
        this.prt = prt;
    }

    public List<PriceRoomType> getPrt() {
        return prt;
    }

    public String getUnitsname() {
		return unitsname;
	}

	public void setUnitsname(String unitsname) {
		this.unitsname = unitsname;
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

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	@JSON(serialize = false)
	public PriceService getPriceService() {
		return priceService;
	}

	public void setPriceService(PriceService priceService) {
		this.priceService = priceService;
	}

	public List<Price> getList() {
		return list;
	}

	public void setList(List<Price> list) {
		this.list = list;
	}
	
	public String checkunitsname(){
		try {
			unitsname=priceService.checkUnits(unitsname);
			// 添加成功信息
			result = "{\"success\":\"true\",\"msg\":\"成功\",\"units\":"+unitsname+"}";
		} catch (Exception e) {
			// 添加失败信息
			result = "{\"success\":\"false\",\"msg\":\"失败" + e.getMessage() + "\",\"units\":[]}";
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String add() {
		try {
			//会议时间地点先按照计划的
			//meeting.setDate(price.getDate());
			//meeting.setAddress(price.getAddress());
			priceService.addInstance(price,prt);
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
			priceService.deleteInstance(price);
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
			priceService.deleteSelectInstance(selected);
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
			// System.out.println(sysaccount.getDepartment().getId());
			price = priceService.updateInstance(price);
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
	public String askprice() {
		try {
			priceService.updateaskprice(price);
			// 添加成功信息
			result = "{\"success\":\"true\",\"msg\":\"报价成功\"}";
		} catch (Exception e) {
			// 添加失败信息
			result = "{\"success\":\"false\",\"msg\":\"报价失败" + e.getMessage()
					+ "\"}";
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String show() {
		try {
		    price=priceService.getInstance(price.getId());
//			price.setRegistTime(temp.getRegistTime());
//			price.setDate(temp.getDate());
//			price.setTravel(temp.getTravel());
//			price.setAddress(temp.getAddress());
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
		// dlist=departmentservice.getAllDepartment();
	    rt = priceService.getAllRoomType();
		list = priceService.getAllPrice();
		return "listprice";
	}
}
