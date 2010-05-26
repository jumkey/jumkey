<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>DB</title>
<style type="text/css">
ul {
	display: inline;
	margin: 0px;
	list-style: none;
}
ul li {
	float: left;
	display: inline;
    list-style: none;
}
img {
	border: 0px;
}
</style>
</head>

<body>
<ul>
<c:forEach var="name" items="${list}">
<li><a href=""><img src="../img/Moth_by_vhm_alex.jpg" style="display: block;width: 100px;height: 100px;" />${name }</a></li>
</c:forEach>
</ul>
</body>
</html>
