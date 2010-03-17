package org.usc.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.usc.actions.base.BaseActionSupport;
import org.usc.beans.Student;
import org.usc.beans.base.PageView;
import org.usc.services.student.IStudentService;

import com.opensymphony.xwork2.ActionContext;

/**
 * 列出所有的学生action
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-3-9<br>
 *        Revision of last commit:$Revision: 648 $<br>
 *        Author of last commit:$Author: nhjsjmz@gmail.com $<br>
 *        Date of last commit:$Date: 2010-03-09 19:52:10 +0800 (周二, 09 三月 2010) $<br>
 *        <p>
 */

@SuppressWarnings("serial")
public class StudentListAction extends BaseActionSupport
{
	private IStudentService studentService;

	public void setStudentService(IStudentService studentService)
	{
		this.studentService = studentService;
	}

	public String execute() throws Exception
	{
		/**
		 * 下面3句固定
		 */
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		int maxResult = 5;
		/**
		 * 修改Bean和service即可
		 */
		PageView<Student> pageView = new PageView<Student>(maxResult, getPage());
		pageView.setQueryResult(studentService.getScrollData(pageView.getFirstResult(), maxResult));

		/**
		 * request.setAttribute("pageView", pageView)中key尽量为pageView，不然需要修改代码
		 */
		request.setAttribute("pageView", pageView);
		return SUCCESS;
	}

}
