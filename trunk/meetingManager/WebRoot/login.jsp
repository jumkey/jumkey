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
		<title>系统登陆</title>
		<link rel="stylesheet" type="text/css" href="style/styles.css" />
	</head>
	<body>
	<div id="wrap">
	<div id="header" style="height: 50px;"></div><!-- end header -->
	<div id="main">
		<div id="login">
        <s:form method="post" namespace="/admin" action="sys_login" theme="simple">
            账户：<s:textfield label="账户" name="account" value="admin" /><br/>
            密码：<s:textfield label="密码" name="password"  value="123" /><br/>
            <s:submit value="" cssStyle="margin:0 0 0 50px; cursor:pointer; border:0; background:url('images/login.png') left top no-repeat; width:74px; height:22px; color:#fff; font-size:12px; display:block; line-height:24px;" />
        </s:form>
        </div>
    </div><!-- end main -->
	<div id="footer" style="text-align: center;">&copy; 2010</div><!-- end footer -->
	</div>
	</body>
</html>
