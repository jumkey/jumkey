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
<script type="text/javascript">
	function expand(el){
		childObj = document.getElementById("child" + el);
		if (childObj.style.display == 'none'){
			childObj.style.display = 'block';
		}else{
			childObj.style.display = 'none';
		}
		return;
	}
</script>
</head>
<body>
<ul id="nav">
  <li><a href="javascript:void(0);">关于我们</a>
    <ul>
      <li><a href="javascript:void(0);" target="I2">公司简介</a></li>
      <li><a href="javascript:void(0);" target="I2">荣誉资质</a></li>
      <li><a href="javascript:void(0);" target="I2">分类管理</a></li>
      <li><a href="javascript:void(0);" target="I2">子类管理</a></li>
    </ul>
  </li>
  <li><a href="javascript:void(0);">新闻中心</a>
    <ul>
      <li><a href="javascript:void(0);" target="I2">公司新闻</a></li>
      <li><a href="javascript:void(0);" target="I2">分类管理</a></li>
      <li><a href="javascript:void(0);" target="I2">子类管理</a></li>
    </ul>
  </li>
  <li><a href="javascript:void(0);">产品中心</a>
    <ul>
      <li><a href="javascript:void(0);" target="I2">产品展示</a></li>
      <li><a href="javascript:void(0);" target="I2">最新产品</a></li>
      <li><a href="javascript:void(0);" target="I2">分类管理</a></li>
      <li><a href="javascript:void(0);" target="I2">子类管理</a></li>
    </ul>
  </li>
  <li><a href="javascript:void(0);">客户服务</a>
    <ul>
      <li><a href="javascript:void(0);" target="I2">客户服务</a></li>
      <li><a href="javascript:void(0);" target="I2">分类管理</a></li>
      <li><a href="javascript:void(0);" target="I2">子类管理</a></li>
    </ul>
  </li>
  <li><a href="javascript:void(0);">经典案例</a>
    <ul>
      <li><a href="javascript:void(0);" target="I2">分类管理</a></li>
      <li><a href="javascript:void(0);" target="I2">子类管理</a></li>
    </ul>
  </li>
  <li><a href="javascript:void(0);">高级管理</a>
    <ul>
      <li><a href="javascript:void(0);" target="I2">广告管理</a></li>
      <li><a href="javascript:void(0);" target="I2">访问统计</a></li>
      <li><a href="javascript:void(0);" target="I2">邮件发送设置</a></li>
      <li><a href="javascript:void(0);" target="I2">联系部门</a></li>
      <li><a href="javascript:void(0);" target="I2">用户留言</a></li>
      <li><a href="javascript:void(0);" target="I2">招聘职位</a></li>
      <li><a href="javascript:void(0);" target="I2">应聘人员</a></li>
      <li><a href="javascript:void(0);" target="I2">留言簿</a></li>
      <li><a href="javascript:void(0);" target="I2">产品订购</a></li>
      <li><a href="javascript:void(0);" target="I2">链接管理</a></li>
      <li><a href="javascript:void(0);" target="I2">文件管理</a></li>
      <li><a href="javascript:void(0);" target="I2">信息转移</a></li>
    </ul>
  </li>
  <li><a href="javascript:void(0);">系统管理</a>
    <ul>
      <li><a href="main/pinfo_list.action" target="I2">账户管理</a></li>
      <li><a href="javascript:void(0);" target="I2">基本设置</a></li>
      <li><a href="javascript:void(0);" target="I2">样式管理</a></li>
      <li><a href="javascript:void(0);" target="I2">栏目管理</a></li>
      <li><a href="javascript:void(0);" target="I2">功能管理</a></li>
      <li><a href="javascript:void(0);" target="I2">菜单管理</a></li>
      <li><a href="javascript:void(0);" target="I2">首页设置</a></li>
      <li><a href="javascript:void(0);" target="I2">管理员列表</a></li>
    </ul>
  </li>
  <li><a href="javascript:void(0);">个人管理</a>
    <ul>
      <li><a href="main/pinfo_edit.action" target="I2">修改信息</a></li>
      <li><a onclick="if (confirm('确定要退出吗？')) return true; else return false;" href="admin/sys_logout.action" target="_top">退出系统</a></li>
    </ul>
  </li>
</ul>
</body>
</html>
