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
<table style="width: 170px;height: 100%;background: url('images/menu_bg.jpg');" cellspacing="0" cellpadding="0" border="0">
  <tr>
    <td valign="top" align="center"><table cellspacing="0" cellpadding="0" width="100%" border="0">
        <tr>
          <td height="10"></td>
        </tr>
      </table>
      <table cellspacing="0" cellpadding="0" width="150" border="0">
        <tr>
          <td class="menuParentTD"><a 
            class="menuParent" onclick="expand(1)" 
            href="javascript:void(0);">关于我们</a></td>
        </tr>
        <tr>
          <td height="4"></td>
        </tr>
      </table>
      <table id="child1" style="display: none;" cellspacing="0" cellpadding="0" 
      width="150" border="0">
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">公司简介</a></td>
        </tr>
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">荣誉资质</a></td>
        </tr>
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">分类管理</a></td>
        </tr>
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">子类管理</a></td>
        </tr>
        <tr>
          <td height="4" colspan="2"></td>
        </tr>
      </table>
      <table cellspacing="0" cellpadding="0" width="150" border="0">
        <tr>
          <td class="menuParentTD"><a 
            class="menuParent" onclick="expand(2)" 
            href="javascript:void(0);">新闻中心</a></td>
        </tr>
        <tr>
          <td height="4"></td>
        </tr>
      </table>
      <table id="child2" style="DISPLAY: none" cellspacing="0" cellpadding="0" 
      width="150" border="0">
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">公司新闻</a></td>
        </tr>
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">分类管理</a></td>
        </tr>
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">子类管理</a></td>
        </tr>
        <tr>
          <td height="4" colspan="2"></td>
        </tr>
      </table>
      <table cellspacing="0" cellpadding="0" width="150" border="0">
        <tr>
          <td class="menuParentTD"><a 
            class="menuParent" onclick="expand(3)" 
            href="javascript:void(0);">产品中心</a></td>
        </tr>
        <tr>
          <td height="4"></td>
        </tr>
      </table>
      <table id="child3" style="DISPLAY: none" cellspacing="0" cellpadding="0" 
      width="150" border="0">
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">产品展示</a></td>
        </tr>
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">最新产品</a></td>
        </tr>
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">分类管理</a></td>
        </tr>
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">子类管理</a></td>
        </tr>
        <tr>
          <td height="4" colspan="2"></td>
        </tr>
      </table>
      <table cellspacing="0" cellpadding="0" width="150" border="0">
        <tr>
          <td class="menuParentTD"><a 
            class="menuParent" onclick="expand(4)" 
            href="javascript:void(0);">客户服务</a></td>
        </tr>
        <tr>
          <td height="4"></td>
        </tr>
      </table>
      <table id="child4" style="DISPLAY: none" cellspacing="0" cellpadding="0" 
      width="150" border="0">
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">客户服务</a></td>
        </tr>
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">分类管理</a></td>
        </tr>
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">子类管理</a></td>
        </tr>
        <tr>
          <td height="4" colspan="2"></td>
        </tr>
      </table>
      <table cellspacing="0" cellpadding="0" width="150" border="0">
        <tr>
          <td class="menuParentTD"><a 
            class="menuParent" onclick="expand(5)" 
            href="javascript:void(0);">经典案例</a></td>
        </tr>
        <tr>
          <td height="4"></td>
        </tr>
      </table>
      <table id="child5" style="DISPLAY: none" cellspacing="0" cellpadding="0" 
      width="150" border="0">
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">分类管理</a></td>
        </tr>
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">子类管理</a></td>
        </tr>
        <tr>
          <td height="4" colspan="2"></td>
        </tr>
      </table>
      <table cellspacing="0" cellpadding="0" width="150" border="0">
        <tr>
          <td class="menuParentTD"><a 
            class="menuParent" onclick="expand(6)" 
            href="javascript:void(0);">高级管理</a></td>
        </tr>
        <tr>
          <td height="4"></td>
        </tr>
      </table>
      <table id="child6" style="DISPLAY: none" cellspacing="0" cellpadding="0" 
      width="150" border="0">
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">广告管理</a></td>
        </tr>
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">访问统计</a></td>
        </tr>
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">邮件发送设置</a></td>
        </tr>
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">联系部门</a></td>
        </tr>
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">用户留言</a></td>
        </tr>
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">招聘职位</a></td>
        </tr>
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">应聘人员</a></td>
        </tr>
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">留言簿</a></td>
        </tr>
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">产品订购</a></td>
        </tr>
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">链接管理</a></td>
        </tr>
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">文件管理</a></td>
        </tr>
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">信息转移</a></td>
        </tr>
        <tr>
          <td height="4" colspan="2"></td>
        </tr>
      </table>
      <table cellspacing="0" cellpadding="0" width="150" border="0">
        <tr>
          <td class="menuParentTD"><a 
            class="menuParent" onclick="expand(7)" 
            href="javascript:void(0);">系统管理</a></td>
        </tr>
        <tr>
          <td height="4"></td>
        </tr>
      </table>
      <table id="child7" style="DISPLAY: none" cellspacing="0" cellpadding="0" 
      width="150" border="0">
        <tr>
          <td height="20"><a class="menuChild" href="main/pinfo_list.action" target="I2">账户管理</a></td>
        </tr>
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">基本设置</a></td>
        </tr>
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">样式管理</a></td>
        </tr>
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">栏目管理</a></td>
        </tr>
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">功能管理</a></td>
        </tr>
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">菜单管理</a></td>
        </tr>
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">首页设置</a></td>
        </tr>
        <tr>
          <td height="20"><a class="menuChild" href="javascript:void(0);" target="I2">管理员列表</a></td>
        </tr>
        <tr>
          <td height="4" colspan="2"></td>
        </tr>
      </table>
      <table cellspacing="0" cellpadding="0" width="150" border="0">
        <tr>
          <td class="menuParentTD"><a 
            class="menuParent" onclick="expand(0)" 
            href="javascript:void(0);">个人管理</a></td>
        </tr>
        <tr>
          <td height="4"></td>
        </tr>
      </table>
      <table id="child0" style="DISPLAY: none" cellspacing="0" cellpadding="0" 
      width="150" border="0">
        <tr>
          <td height="20"><a class="menuChild" href="main/pinfo_edit.action" target="I2">修改信息</a></td>
        </tr>
        <tr>
          <td height="20"><a class="menuChild" 
            onclick="if (confirm('确定要退出吗？')) return true; else return false;" 
            href="admin/sys_logout.action" 
            target="_top">退出系统</a></td>
        </tr>
      </table></td>
    <td width="1" bgcolor="#d1e6f7"></td>
  </tr>
</table>
</body>
</html>
