<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Success</title>
  </head>

  <body>
    <h1>Success!</h1>
    <h2>test</h2>
	<s:iterator var="test" value="tests">
    <div>${test.title}</div>
    </s:iterator>
    <h2>metas</h2>
	<s:iterator var="meta" value="metas">
    <div>${meta.name}</div>
    </s:iterator>
    <h2>contents</h2>
	<s:iterator var="content" value="contentss">
    <div><s:property value="text" /></div>
    </s:iterator>
  </body>
</html>
