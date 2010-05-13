<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="cklog.jsp" %>
<!DOCTYPE HTML>
<html lang="zh">
<head>
<meta charset="UTF-8">
<title>Word Taste 后台首页</title>
<script type="text/javascript">
function init(){
	if("${addsec}"=="true"){
		alert("添加成功");
	}
}
</script>
</head>

<body onload="init()">
<header>
<h1><a href="/" title="首页">add</a></h1>
</header>
<article>
<p>
<form action="addtext" method="post">
标题：<input type="text" name="title" value="" /><br />
缩略名：<input type="text" name="slug" value="" /><br />
资源描述符：<input type="text" name="uri" value="" /><br />
内容：<input type="text" name="text" value="" /><br />
标签：<input type="text" name="tags" value="" /><br />
类别：<input type="text" name="meta" value="" /><br />
<input type="submit" value="添加文章" />
</form>
</p>
</article>
<footer>&copy;2010 - jumkey</footer>
</body>
</html>
