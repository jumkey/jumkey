<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Show</title>
    <link type="text/css" href="style/style.css" rel="stylesheet" />
  </head>

  <body>
  	<div id="header">
  		<h1>Show</h1>
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
	    <div class="post">
			<h1><s:property value="content.title" /></h1>
			发表于 <span class="date"><s:property value="content.created" /></span>：最后修改 <span class="date"><s:property value="content.modified" /></span>
		    <div><s:property value="content.text" /></div>
	    </div>
		<h2>comments</h2>
		<s:iterator var="comment" value="content.contents">
	    <div class="comments" style="width: 600px;">
			<h1><s:property value="comment.title" /></h1>
			发表于 <span class="date"><s:property value="comment.created" /></span>：最后修改 <span class="date"><s:property value="comment.modified" /></span>
		    <div><s:property value="comment.text" /></div>
	    </div>
		</s:iterator>
		<div id="commentForm">
		    <form action="add_Contents.do" method="post">
		    	标题<input type="text" name="contents.title" value="" /><br/>
		    	slug<input type="text" name="contents.slug" value="" /><br/>
		    	URI <input type="text" name="contents.uri" value="" /><br/>
		    	内容<br/><textarea name="contents.text" rows="10" cols="50" ></textarea><br/>
		    	metas
		    	<select name="contents.metas[0]">
		    		<s:iterator var="meta" value="metas">
		    		<option value="<s:property value="key" />">${meta.name}</option>
		    		</s:iterator>
		    	</select><br/>
		    	template<input type="text" name="contents.template" value="" /><br/>
		    	类型<input type="text" name="contents.type" value="1" /><br/>
		    	密码<input type="text" name="contents.password" value="" /><br/>
		    	<input type="checkbox" name="contents.allowComment" value="true" checked="checked" />allowComment<br/>
		    	<input type="checkbox" name="contents.allowPing" value="true" checked="checked" />allowPing<br/>
		    	<input type="checkbox" name="contents.allowFeed" value="true" checked="checked" />allowFeed<br/>
		    	<input type="submit" value="submit" />
		    </form>
    	</div>
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
