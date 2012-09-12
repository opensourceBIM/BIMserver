<%@ include file="header.jsp"%>
<%
	loginManager.getService().setDefaultQueryEngine(Long.parseLong(request.getParameter("oid")));
%>