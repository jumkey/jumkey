<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Exception</title>
  </head>

  <body>
    <h1>Exception!</h1>
	<div id="systemFailed" style="text-align:left; padding-left:80px; padding-right:80px;">
        <s:property value="exception"/>
    </div>
    <br/>
    <div style="text-align:left; padding-left:80px; padding-right:80px;">
        <s:property value="exceptionStack"/>
    </div>
  </body>
</html>
