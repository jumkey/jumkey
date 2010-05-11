<%@ page language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="zh">
<head>
<meta charset="UTF-8">
<title>Word Taste</title>
</head>

<body>
<c:forEach var="art" items="${artlist}">
${art.id}.<b>${art.title}</b><br />
${art.content}<br /><br />
</c:forEach>
<header>
<h1><a href="/" title="首页">Word Taste</a></h1>
</header>
<article>
<h2 style="font-weight:bold;">Available Servlets:</h2>
<p><a href="blog">Blog</a></p>
</article>
<form action="add" method="post">
<input type="text" name="title" value="" />
<input type="text" name="content" value="" />
<input type="submit" value="submit" />
</form>
<footer>&copy;jumkey</footer>
</body>
</html>
