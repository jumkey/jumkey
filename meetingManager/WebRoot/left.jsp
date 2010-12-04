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
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#nav>li").addClass("menuParentLI");
		$("#nav>li>a").addClass("menuParent");
		$("#nav>li>ul>li>a").addClass("menuChild");
		$("#nav>li>a").click(function(){
			$(this).next().toggle();
		});
	});
</script>
</head>
<body>
<ul id="nav">
  <li><a href="main/price_list.action" target="I2">询价管理</a></li>
  <li><a href="main/meeting_list.action" target="I2">会议管理</a></li>
  <li><a href="javascript:void(0);">库管理</a>
    <ul>
      <li><a href="main/units_list.action" target="I2">单位管理</a></li>
      <li><a href="main/user_list.action" target="I2">个人管理</a></li>
    </ul>
  </li>
  <li><a href="javascript:void(0);">系统设置</a>
    <ul>
      <li><a href="main/roomtype_list.action" target="I2">房间类型</a></li>
      <li><a href="main/tradetype_list.action" target="I2">行业分类</a></li>
      <li><a href="main/feeitem_list.action" target="I2">费项管理</a></li>
      <li><a href="main/pinfo_list.action" target="I2">账户管理</a></li>
      <li><a href="admin/role_list.action" target="I2">角色权限</a></li>
    </ul>
  </li>
</ul>
</body>
</html>
