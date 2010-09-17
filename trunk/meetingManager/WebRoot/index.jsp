<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//跳转
if (request.getSession().getAttribute("account") != null) {
	response.sendRedirect(basePath+"main/main.action");
}else{
	response.sendRedirect(basePath+"login.jsp");
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%=basePath%>" />
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<title>系统登陆</title>
		<link rel="stylesheet" type="text/css" href="style/styles.css" />
	</head>
	<body>
	</body>
</html>
