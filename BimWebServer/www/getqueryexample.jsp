<%@ include file="header.jsp"%>
<%
	out.print(loginManager.getService().getQueryEngineExample(Long.parseLong(request.getParameter("qeid")), request.getParameter("key")));
%>