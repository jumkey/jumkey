<%@page import="blog.util.Contains"%>
<%
Boolean t=(Boolean)session.getAttribute("logstr");
if(!t){
	response.sendRedirect(Contains.login);
}
%>