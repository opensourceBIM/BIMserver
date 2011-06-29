<%@page import="org.bimserver.shared.UserException"%>
<%@ include file="header.jsp" %>
<%
	if (loginManager.getService().isLoggedIn()) {
		try {
			long poid = Long.parseLong(request.getParameter("poid"));
			long uoid = Long.parseLong(request.getParameter("uoid"));
			loginManager.getService().removeUserFromProject(uoid, poid);
			if (request.getParameter("type").equals("project")) {
				response.sendRedirect("project.jsp?poid=" + poid);
			} else if (request.getParameter("type").equals("user")) {
				response.sendRedirect("user.jsp?uoid=" + uoid);
			}
		} catch (UserException e) {
			out.println("<div class=\"error\">" + e.getUserMessage() + "</div>");
		}
	}
%>