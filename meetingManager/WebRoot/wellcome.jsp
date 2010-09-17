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
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<title>wellcome</title>
		<link rel="stylesheet" type="text/css" href="style/styles.css" />
	</head>
	<body>
<table cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
  <tr>
    <td bgcolor="#b1ceef" height="1"></td>
  </tr>
  <tr>
    <td height="20"></td>
  </tr>
</table>
<table cellspacing="0" cellpadding="0" width="90%" align="center" border="0">
	<tr>
	  <td>当前时间：2008-12-27 17:03:55</td>
	</tr>
	<tr>
	  <td style="FONT-WEIGHT: bold; FONT-SIZE: 16px">${account.account }欢迎进入管理中心！</td>
	</tr>
</table>
<table cellspacing="0" cellpadding="0" width="95%" align="center" border="0">
  <tr>
    <td height="20"></td>
  </tr>
  <tr>
    <td height="22" style="padding-left: 20px; font-weight: bold;" align="center">您的相关信息</td>
  </tr>
  <tr bgcolor="#ecf4fc">
    <td height="12"></td>
  </tr>
  <tr>
    <td height="20"></td>
  </tr>
</table>
<table cellspacing="0" cellpadding="2" width="95%" align="center" border="0">
  <tr>
    <td align="right" width="100">登陆帐号：</td>
    <td style="COLOR: #880000">admin</td>
  </tr>
  <tr>
    <td align="right">真实姓名：</td>
    <td style="COLOR: #880000">${account.username }</td>
  </tr>
  <tr>
    <td align="right">注册时间：</td>
    <td style="COLOR: #880000">${account.createtime }</td>
  </tr>
</table>
	</body>
</html>
