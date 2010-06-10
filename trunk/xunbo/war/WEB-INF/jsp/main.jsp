<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <title>Main</title>
    <link type="text/css" href="style/style.css" rel="stylesheet" />
  </head>

  <body>
  	<div id="header">
  		<h1>Jumkey!</h1>
  		<div id="navSearch">
  		<div id="navSearchIn">
		<div class="nav">
			<a class="highlight" title="首页" href="/index.do">首页</a>
			<a class="normal" title="关于" href="/about.do">关于</a>
		</div>
		<div class="search">
			<form name="searchedForm" action="/search.do" method="post" target="_blank">
				<input name="key" id="key" type="text" value="">
				<a class="btn" href="javascript:submitSearcheForm();">搜索</a>
			</form>
		</div>
		</div>
		</div>
  	</div>
  	<div id="container">
  	<div id="main">
	    <div id="content">
		    <h2>contents</h2>
			<s:iterator var="content" value="contents">
	    	<div class="post">
				<h1><a href="show.do?key=<s:property value="key" />"><s:property value="title" /></a></h1>
				发表于 <span class="date"><s:property value="created" /></span>：最后修改 <span class="date"><s:property value="modified" /></span>
			    <div><s:property value="text" /></div>
	    	</div>
		    </s:iterator>
	    </div>
	    <div id="sidebar">
		    <h2>metas</h2>
		    <ul>
			    <li class="widget">
			    <h2><a href="/">Jumkey's博客</a></h2>
			    </li>
			    <li class="widget">
			    <ul>
					<s:iterator var="meta" value="metas">
				    <li><a href="category.do?key=<s:property value="key" />"><s:property value="name" /></a></li>
				    </s:iterator>
			    </ul>
			    </li>
		    </ul>
	    </div>
    </div><!-- end main -->
    </div><!-- end container -->
    <div id="footer">
    	<div id="bottomSearch"></div>
    	<p>&copy;Jumkey 2010</p>
    </div>
  </body>
</html>
