package org.usc.actions.base;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 基础Action，所有的Action都可以继承，省去写page和控制层统一处理，继承后，只需要些Results和execute方法
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-3-9<br>
 *        Revision of last commit:$Revision: 648 $<br>
 *        Author of last commit:$Author: nhjsjmz@gmail.com $<br>
 *        Date of last commit:$Date: 2010-03-09 19:52:10 +0800 (周二, 09 三月 2010) $<br>
 *        <p>
 */
@SuppressWarnings("serial")
public class BaseActionSupport extends ActionSupport
{
	/** jsp页面传过来的当前页 **/
	private int page;

	public int getPage()
	{
		return page;
	}

	public void setPage(int page)
	{
		this.page = page;
	}

}
