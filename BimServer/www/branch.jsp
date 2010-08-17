<%@page import="org.bimserver.shared.CheckinResult"%>
<%@ include file="header.jsp" %>
<%
	String action = request.getParameter("action");
	long roid = Long.parseLong(request.getParameter("roid"));
	if (action.equals("branchtonewproject")) {
		String name = request.getParameter("name");
		String comment = request.getParameter("comment");
		CheckinResult checkinResult = loginManager.getService().branch(roid, name, comment);
		response.sendRedirect("project.jsp?poid=" + checkinResult.getPoid());
	} else if (action.equals("branchtoexistingproject")) {
		long destPoid = Long.parseLong(request.getParameter("destpoid"));
		String comment = request.getParameter("comment");
		loginManager.getService().branch(roid, destPoid, comment);
		response.sendRedirect("project.jsp?poid=" + destPoid);
	}
%>