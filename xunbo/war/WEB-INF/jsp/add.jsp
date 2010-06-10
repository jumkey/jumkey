<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Add</title>
  </head>

  <body>
    <h1>Add</h1>
	<!-- 
    <form action="add_Test.do" method="post">
    	title<input type="text" name="test.title" value="" /><br/>
    	content<input type="text" name="test.content" value="" /><br/>
    	<input type="submit" value="submit" />
    </form>
     -->
    <form action="add_Metas.do" method="post">
    	名称<input type="text" name="meta.name" value="" /><br/>
    	slug<input type="text" name="meta.slug" value="" /><br/>
    	类型<select name="meta.type">
    		<option value="1">类别</option>
    		<option value="2">标签</option>
    	</select><br/>
    	描述<input type="text" name="meta.description" value="" /><br/>
    	count<input type="text" name="meta.count" value="" /><br/>
    	sort<input type="text" name="meta.sort" value="" /><br/>
    	<input type="submit" value="submit" />
    </form>
    <form action="add_Contents.do" method="post">
    	标题<input type="text" name="contents.title" value="" /><br/>
    	slug<input type="text" name="contents.slug" value="" /><br/>
    	uri<input type="text" name="contents.uri" value="" /><br/>
    	内容<textarea name="contents.text" rows="" cols="" ></textarea><br/>
    	metas
    	<select name="contents.metas[0]">
    		<s:iterator var="meta" value="metas">
    		<option value="<s:property value="key" />">${meta.name}</option>
    		</s:iterator>
    	</select><br/>
    	template<input type="text" name="contents.template" value="" /><br/>
    	type<input type="text" name="contents.type" value="1" /><br/>
    	密码<input type="text" name="contents.password" value="" /><br/>
    	<input type="checkbox" name="contents.allowComment" value="true" checked="checked" />allowComment<br/>
    	<input type="checkbox" name="contents.allowPing" value="true" checked="checked" />allowPing<br/>
    	<input type="checkbox" name="contents.allowFeed" value="true" checked="checked" />allowFeed<br/>
    	<input type="submit" value="submit" />
    </form>
  </body>
</html>
