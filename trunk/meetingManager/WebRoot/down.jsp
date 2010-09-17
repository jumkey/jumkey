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
	<div style="float: left;background: url('images/main_25.gif'); width: 100%; height: 23px;">
		<div style="float: left;width: 200px;height:23px; background: url('images/main_24.gif') no-repeat;"></div>
		<div style="float: right; width: 200px;height:23px; background: url('images/main_27.gif') no-repeat right bottom;">
			<div style="color: #147233;">今天是：2007年08月15日 星期三</div>
		</div>
	</div>
</body>
</html>