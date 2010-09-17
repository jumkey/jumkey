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
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="11" background="images/main_03.gif"><img src="images/main_01.gif" width="104" height="11" /></td>
  </tr>
  <tr>
    <td height="36" background="images/main_07.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="282" height="52" background="images/main_05.gif">&nbsp;</td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td>
            	<span class="STYLE3"><a href="index.jsp" target="_top">回首页</a></span>
            	<span class="STYLE1">
            		<a onclick="if (confirm('确定要退出吗？')) return true; else return false;" href="admin/sys_logout.action" target="_top">退出系统</a>
            	</span>
            </td>
          </tr>
        </table></td>
        <td width="247" background="images/main_08.gif">&nbsp;</td>
        <td width="283" background="images/main_09.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><span class="STYLE2">当前登录用户：${account.account } 角色：管理员</span></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>