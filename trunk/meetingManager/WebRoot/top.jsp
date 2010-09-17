<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="style/styles.css" />
</head>
<body>
<div>
    <div style="height: 11px; background: url('images/main_03.gif');"><img src="images/main_01.gif" width="104" height="11" /></div>
	<div style="height: 52px; background: url('images/main_07.gif');">
		<div style="float: right; width: 300px;">
			<span class="STYLE1">当前登录用户：${account.account } 角色：</span><br />
			<span class="STYLE2">
				<a href="index.jsp" target="_top">回首页</a>
			</span>
			<span class="STYLE3">
				<a onclick="if (confirm('确定要退出吗？')) return true; else return false;" href="admin/sys_logout.action" target="_top">退出系统</a>
			</span>
		</div>
	</div>
</div>
</body>
</html>