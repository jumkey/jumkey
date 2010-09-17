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
<style type="text/css">
<!--
body {
	overflow:hidden;
}
table {
	width: 100%;
	height: 100%;
}
-->
</style>
<script type="text/javascript">
function switchSysBar(){
	var locate=location.href.replace('center.jsp','');
	var ssrc=document.getElementById("img1").src.replace(locate,'');
	if (ssrc=="images/main_18.gif"){
		document.getElementById("img1").src="images/main_18_1.gif";
		document.getElementById("frmTitle").style.display="none";
	}else{
		document.getElementById("img1").src="images/main_18.gif";
		document.getElementById("frmTitle").style.display="";
	}
}
</script>
</head>
<body>
<table>
  <tr>
    <td style="width: 4px; text-align: center; vertical-align: top; background: url('images/main_16.gif');"></td>
    <td height="100%" width="170" id="frmTitle" align="center" valign="top" nowrap="nowrap">
    	<iframe name="I1" height="100%" width="100%" src="left.jsp" frameborder="0" scrolling="no">
    	浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。</iframe></td>
    <td style="background: url('images/main_12.gif'); width: 8px; vertical-align: middle;" onclick="switchSysBar()">
    	<span class="navPoint"><img src="images/main_18.gif" name="img1" width="8px" height="52px" id="img1" /></span></td>
    <td height="100%" align="center" valign="top">
    	<iframe name="I2" height="100%" width="100%" frameborder="0" src="wellcome.jsp">
    	浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。</iframe></td>
    <td style="width: 4px; text-align: center; vertical-align: top; background: url('images/main_20.gif');"></td>
  </tr>
</table>
</body>
</html>
