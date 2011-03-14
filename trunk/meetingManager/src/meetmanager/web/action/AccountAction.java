package meetmanager.web.action;

import java.util.List;

import meetmanager.model.Department;
import meetmanager.model.Sysaccount;
import meetmanager.service.DepartmentService;
import meetmanager.service.SysaccountService;
import meetmanager.utils.dao.Page;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AccountAction extends ActionSupport {
	private SysaccountService sysaccountService;
	private DepartmentService departmentService;
	private Sysaccount sysaccount;
	private List<Sysaccount> list;
	private List<Department> dlist;
	private String result;//返回ajax 结果
	private Integer[] selected;//选择项
	
	private Page page;

	public List<Department> getDlist() {
		return dlist;
	}

	public void setDlist(List<Department> dlist) {
		this.dlist = dlist;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
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

	public List<Sysaccount> getList() {
		return list;
	}

	public void setList(List<Sysaccount> list) {
		this.list = list;
	}
	@JSON(serialize=false)
	public SysaccountService getSysaccountService() {
		return sysaccountService;
	}

	public void setSysaccountService(SysaccountService sysaccountService) {
		this.sysaccountService = sysaccountService;
	}
	@JSON(serialize=false)
	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public Sysaccount getSysaccount() {
		return sysaccount;
	}

	public void setSysaccount(Sysaccount sysaccount) {
		this.sysaccount = sysaccount;
	}

	public String edit(){
		return "editpage";
	}
	public String doedit(){
		try {
			//更新session
			sysaccount=sysaccountService.updateAccount(sysaccount);
			ActionContext.getContext().getSession().put("account", sysaccount);
			//添加成功信息
			this.addActionMessage("修改成功！");
		} catch (Exception e) {
			//添加失败信息
			this.addActionMessage("修改失败！");
			e.printStackTrace();
		}
		return "editpage";
	}
	public String add(){
		try {
			sysaccountService.addAccount(sysaccount);
			//添加成功信息
			result="{\"success\":\"true\",\"msg\":\"添加成功\"}";
		} catch (Exception e) {
			//添加失败信息
			result="{\"success\":\"false\",\"msg\":\"添加失败"+e.getMessage()+"\"}";
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String delselect(){
		try {
			sysaccountService.deleteSelectAccount(selected);
			//添加成功信息
			result="{\"success\":\"true\",\"msg\":\"批量删除成功\"}";
		} catch (Exception e) {
			//添加失败信息
			result="{\"success\":\"false\",\"msg\":\"批量删除失败"+e.getMessage()+"\"}";
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String delete(){
		try {
			sysaccountService.deleteAccount(sysaccount);
			//添加成功信息
			result="{\"success\":\"true\",\"msg\":\"删除成功\"}";
		} catch (Exception e) {
			//添加失败信息
			result="{\"success\":\"false\",\"msg\":\"删除失败"+e.getMessage()+"\"}";
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String modify(){
		try {
			//System.out.println(sysaccount.getDepartment().getId());
			sysaccount=sysaccountService.updateAccount(sysaccount);
			//添加成功信息
			result="{\"success\":\"true\",\"msg\":\"修改成功\"}";
		} catch (Exception e) {
			//添加失败信息
			result="{\"success\":\"false\",\"msg\":\"修改失败"+e.getMessage()+"\"}";
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String list(){
		if(page==null){
			page=new Page();
		}
		dlist=departmentService.getAllDepartment();
		list=sysaccountService.getPageAccount(page);
		return "listaccount";
	}
}
