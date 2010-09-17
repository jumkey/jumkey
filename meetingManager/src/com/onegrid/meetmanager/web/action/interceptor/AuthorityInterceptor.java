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
	// ����Action��������ط���
	public String intercept(ActionInvocation invocation) throws Exception {
		// ȡ��������ص�ActionContextʵ��
		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();
		// ȡ����Ϊuser��Session����
		Sysaccount sysaccount = (Sysaccount) session.get("account");
		// ���û�е�½�����ߵ�½���õ��û�������scott�����������µ�½
		if (sysaccount != null) {
			return invocation.invoke();
		}
		// û�е�½������������ʾ���ó�һ��HttpServletRequest����
		ctx.put("tip", "����û�е�½�����½ϵͳ");
		// ֱ�ӷ���login���߼���ͼ
		return Action.LOGIN;
	}
}
