<%@page import="blog.util.Contains"%>
<%
Boolean t=(Boolean)session.getAttribute("logstr");
if(t==null||!t){
	response.sendRedirect(Contains.index);
}
%>