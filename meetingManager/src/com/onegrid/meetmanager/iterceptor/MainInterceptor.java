package com.onegrid.meetmanager.iterceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.springframework.aop.MethodBeforeAdvice;

import com.onegrid.meetmanager.model.Sysaccount;

public class MainInterceptor implements MethodBeforeAdvice {
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		WebContext ctx = WebContextFactory.get();// 唯一被DWR污染的地方
		HttpSession session = ctx.getSession();
		
		Sysaccount sysaccount = (Sysaccount) session.getAttribute("account");
		
		if (sysaccount == null) {
			throw new Exception("没有登陆");
		}
	}

}
