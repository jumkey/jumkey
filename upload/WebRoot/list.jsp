<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>DB</title>
<script type="text/javascript" src="../js/jquery-1.4.2.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$(".list img").mouseover(function(){
		$("#single img").attr("src",$(this).attr("src"));
		$("#single").show("slow");
	});
	$(".list img").mouseover(function(){
	});
	$(".list img").mouseout(function(){
		$("#single").hide("slow");
	});
});
</script>
<style type="text/css">
body {
	font-size: 12px;
}
/*未点击过的链接*/
a:link {
	color: blue;
	text-decoration: none;
}
/*已点击过的链接*/
a:visited {
	color: orange;
	text-decoration: none;
}
/*鼠标停留在上面的链接*/
a:hover {
	color: green;
	text-decoration: underline;
}
/*当前激活的链接*/
a:active {
	color: red;
	text-decoration: underline;
}
img {
	border: 0px;
}
ul {
	margin: 0px;
	padding: 0px;
}
li.list {
	float: left;
	display: inline;
    list-style: none;
    width: 120px;
    height: 160px;
    text-align: center;
    overflow: hidden;
}
li.list img {
	display: block;
	width: 100px;
	height: 100px;
	margin: 0 auto;
	border: 5px #ccc solid;
}
li.list a:hover img {
	border: 5px solid red;
}
#single {
	position: absolute;
	display: none;
}
</style>
</head>

<body>
<ul>
<c:forEach var="name" items="${list}">
<li class="list"><a href="show?name=${name }"><img src="../img/Moth_by_vhm_alex.jpg" />${name }</a></li>
</c:forEach>
</ul>
<div id="single">
<img src="" />
</div>
</body>
</html>
