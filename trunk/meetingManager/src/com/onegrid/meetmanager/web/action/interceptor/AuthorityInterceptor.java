package com.onegrid.meetmanager.web.action.interceptor;

import java.util.Map;

import com.onegrid.meetmanager.model.Sysaccount;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class AuthorityInterceptor extends AbstractInterceptor {
	@SuppressWarnings("unchecked")
	@Override
	// 拦截Action处理的拦截方法
	public String intercept(ActionInvocation invocation) throws Exception {
		// 取得请求相关的ActionContext实例
		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();
		// 取出名为user的Session属性
		Sysaccount sysaccount = (Sysaccount) session.get("account");
		// 如果没有登陆，或者登陆所用的用户名不是scott，都返回重新登陆
		if (sysaccount != null) {
			return invocation.invoke();
		}
		// 没有登陆，将服务器提示设置成一个HttpServletRequest属性
		ctx.put("tip", "您还没有登陆，请登陆系统");
		// 直接返回login的逻辑视图
		return Action.LOGIN;
	}
}
