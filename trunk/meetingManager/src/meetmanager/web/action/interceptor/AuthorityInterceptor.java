package meetmanager.web.action.interceptor;

import java.util.List;
import java.util.Map;

import meetmanager.model.Limit;
import meetmanager.model.Sysaccount;

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
        List<Limit> llist = (List<Limit>) session.get("llist");

        // 如果没有登陆,都返回重新登陆
        if (sysaccount != null) {
            // 得到action信息
            System.out.println(invocation.getAction().getClass()
                    .getSimpleName());
            System.out.println(invocation.getProxy().getMethod());

            String Actionstr = invocation.getAction().getClass()
                    .getSimpleName();
            String Methodstr = invocation.getProxy().getMethod();
            boolean flag = true;//

//            if(llist!=null&&llist.size()!=0) {
//                for (Limit l : llist) {
//                    String[] uu = l.getUrl().split("-");
//                    for (String u : uu) {
//                        if (Actionstr.equals(uu[0]) && Methodstr.equals(u)) {
//                            flag = true;
//                        }
//                    }
//                }
//            }
            if (flag) {
                return invocation.invoke();
            } else {
                ctx.put("tip", "权限不足");
            }
        } else {
            // 没有登陆，将服务器提示设置成一个HttpServletRequest属性
            ctx.put("tip", "您还没有登陆，请登陆系统");
        }
        // 直接返回login的逻辑视图
        return Action.LOGIN;
    }

    public static void main(String[] args) {
    }
}
