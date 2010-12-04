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
<title>${notice.meetingInfo.title }</title>
<link rel="stylesheet" type="text/css" href="style/styles.css" />
</head>

<body> 
<div id="tabwrap"><a class="ui-state-default" href="javascript:history.back();">返回</a>
<p>
通知单<br />
会议标题：${notice.meetingInfo.title }<br />
主讲人：${notice.meetingInfo.author }<br /> 
地址：${notice.meetingInfo.address }<br />
日期：${notice.meetingInfo.date }<br />
</p>
<s:iterator status="index" value="notice.sendNotificationPlans" id="snp">
<div class="user">
单位名称：<span class="red">${snp.user.units.name }</span>|
姓名：<span class="red">${snp.user.name }</span>|
性别：<span class="red">${snp.user.sex }</span>|
地址：<span class="red">${snp.user.address }</span>|
邮编：<span class="red">${snp.user.zip }</span>|
手机：<span class="red">${snp.user.cellphone }</span>|
电话：<span class="red">${snp.user.phone }</span>|
电邮：<span class="red">${snp.user.mail }</span>
</div>
</s:iterator>
<a href="javascript:print();">打印</a>
</div><!--end tabwrap-->
</body>
</html>
