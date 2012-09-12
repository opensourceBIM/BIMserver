<%@ include file="header.jsp"%>
<%
	loginManager.getService().setDefaultModelCompare(Long.parseLong(request.getParameter("oid")));
%>