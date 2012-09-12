<%@ include file="header.jsp"%>
<%
	loginManager.getService().setDefaultIfcEngine(Long.parseLong(request.getParameter("oid")));
%>