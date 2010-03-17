<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
当前页:第
<s:property value="#request.pageView.currentPage" />
页 | 总记录数:
<s:property value="#request.pageView.totalRecord" />
条 | 每页显示:
<s:property value="#request.pageView.maxResult" />
条 | 总页数:
<s:property value="#request.pageView.totalPage" />
页 |
<s:if test="#request.pageView.currentPage > 1">
	<a href="javascript:topage(1)">首页</a>&nbsp;
	<a href="javascript:topage('<s:property value="#request.pageView.currentPage - 1"/>')">上一页</a>&nbsp;
</s:if>
<s:else>
首页 &nbsp;上一页&nbsp; 
</s:else>
<s:iterator begin="#request.pageView.pageIndex.startIndex" end="#request.pageView.pageIndex.endIndex" var="wp">
	<s:if test="#request.pageView.currentPage== #wp">
	<font color="#FF0000"><s:property value="#wp" /></font>&nbsp;
	</s:if>
	<s:else>
		<a href="javascript:topage('<s:property value="#wp"/>')"><s:property value="#wp" /></a>&nbsp;
	</s:else>
</s:iterator>
<s:if test="#request.pageView.currentPage < #request.pageView.totalPage">
	<a href="javascript:topage('<s:property value="#request.pageView.currentPage + 1"/>')">下一页</a>&nbsp;
	<a href="javascript:topage('<s:property value="#request.pageView.totalPage"/>')">末页</a>&nbsp;
</s:if>
<s:else>
下一页 &nbsp;末页&nbsp; 
</s:else>


