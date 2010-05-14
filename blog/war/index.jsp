<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="zh">
<head>
<meta charset="UTF-8">
<title>Word Taste</title>
</head>

<body>
<header>
<h1><a href="/" title="首页">Word Taste</a></h1>
</header>
<c:forEach var="contents" items="${contentslist}">
<article>
${contents.cid}.<b>${contents.title}</b><br />
${contents.text.value}<br /><br />
</article>
</c:forEach>
<footer>&copy; 2010 - jumkey</footer>
</body>
</html>
