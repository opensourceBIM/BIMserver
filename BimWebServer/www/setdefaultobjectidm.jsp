<%@ include file="header.jsp"%>
<%
	loginManager.getService().setDefaultObjectIDM(Long.parseLong(request.getParameter("oid")));
%>