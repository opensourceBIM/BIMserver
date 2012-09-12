<%@ include file="header.jsp"%>
<%
	loginManager.getService().setDefaultModelMerger(Long.parseLong(request.getParameter("oid")));
%>