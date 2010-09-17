<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<base href="<%=basePath%>" />
		<title>添加</title>
		<meta http-equiv="keywords" content="enter,your,keywords,here" />
		<meta http-equiv="description" content="A short description of this page." />
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		
		<!--<link rel="stylesheet" type="text/css" href="styles.css">-->
	</head>
	<body>
        <s:form method="post" action="news_add" namespace="/admin">
            <s:textfield label="标题" name="title" />
            <s:textfield label="内容" name="content" />
            <s:submit value="Submit" />
        </s:form>
	</body>
</html>
