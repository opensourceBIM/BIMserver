<%@ include file="header.jsp"%>
<%
	loginManager.getService().setDefaultSerializer(Long.parseLong(request.getParameter("oid")));
%>