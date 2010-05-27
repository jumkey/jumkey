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
	var docW=$(document).width();
	var docH=$(document).height();
	var x,y;
	$(window).resize(function(){
		docW=$(document).width();
		docH=$(document).height();
	});
	$(".list img").mouseover(function(e){
		$("#single img").attr("src",$(this).attr("src"));
		$("#single").show();
	}).mousemove(function(e){
		if(e.pageX+330>docW){
			x=e.pageX-320-10;
		}else{
			x=e.pageX+10;
		}
		if(e.pageY+250>docH){
			y=e.pageY-240-10;
		}else{
			y=e.pageY+10;
		}
		$("#single").css({left:x,top:y});
	}).mouseout(function(e){
		//$("#single").remove();
		$("#single").hide();
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
/*li.list a:hover img*/
li.list a img:hover {
	border: 5px solid red;
}
#single {
	position: absolute;
	display: none;
	width: 320px;
	height: 240px;
	overflow: hidden;
	z-index: 999;
}
#single img {
	border: 2px solid #ccc;
	border-radius: 20px;
}

#scroll {
	background: url("../img/zsnos.png") no-repeat 0px 0px;
	height: 30px;
	width: 18px;
	margin: -15px -190px 0px 0px;
	overflow: hidden;
	position: fixed;
	right: 50%;
	top: 50%;
}
#scroll:hover {
	background: url("../img/zsnos.png") no-repeat 0px -30px;
}
#top {
	cursor: pointer;
	height: 15px;
	width: 18px;
}
#bottom {
	cursor: pointer;
	height: 15px;
	width: 18px;
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
<div id="scroll"><div id="top"></div><div id="bottom"></div></div>
</body>
</html>
