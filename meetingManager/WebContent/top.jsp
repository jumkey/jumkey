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
    <div style="height: 11px; background: url('images/main_03.gif');"><!-- <img src="images/main_01.gif" width="104" height="11" /> --></div>
	<div style="height: 52px; background: url('images/main_07.gif');">
		<div style="float: right; width: 300px;margin-top: 5px;">
			<span class="STYLE1">
				当前登录用户：${account.account }&nbsp;部门：${account.department.departmentname }
			</span><br />
			<span class="STYLE2">
				<a href="index.jsp" target="_top">首  页</a>
			</span>
			<span class="STYLE1">
				<a href="main/pinfo_edit.action" target="I2">修改个人资料</a>
			</span>
			<span class="STYLE3">
				<a onclick="if (confirm('确定要退出吗？')) return true; else return false;" href="admin/sys_logout.action" target="_top">退出系统</a>
			</span>
		</div>
	</div>
</div>
</body>
</html>