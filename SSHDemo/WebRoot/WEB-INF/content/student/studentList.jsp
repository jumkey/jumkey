<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>Student List</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<%--要包含下面的base.js，以能分页	--%>
		<script type="text/javascript" src="js/base.js"></script>

	</head>

	<body>
		<s:form action="listStudent" method="post">

			<%--下面三句可以不动			--%>
			<s:hidden name="page"></s:hidden>
			<s:if test="#request.pageView.totalRecord">
				<%--页数大于1才显示导航			--%>
				<s:if test="#request.pageView.totalPage > 1">
					<%@ include file="/WEB-INF/content/share/page.jsp"%>
				</s:if>
				<table border="1">
					<tr>
						<td>
							学号
						</td>
						<td>
							姓名
						</td>
						<td>
							性别
						</td>
						<td>
							年龄
						</td>
						<td>
							分数
						</td>
						<td>
							入学日期
						</td>
					</tr>
					<s:iterator value="#request.pageView.records" id="entity">
						<tr>
							<td>
								<s:property value="#entity.no" />
							</td>
							<td>
								<s:property value="#entity.name" />
							</td>
							<td>
								<s:property value="#entity.sex" />
							</td>
							<td>
								<s:property value="#entity.age" />
							</td>
							<td>
								<s:property value="#entity.score" />
							</td>
							<td>
								<s:property value="#entity.eduTime" />
							</td>
						</tr>
					</s:iterator>
				</table>
			</s:if>
			<s:else>
				没有记录
			</s:else>
		</s:form>
	</body>
</html>
