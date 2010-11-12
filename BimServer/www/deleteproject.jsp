<%@page import="org.bimserver.shared.UserException"%>
<%@ include file="header.jsp" %>
<%
	if (loginManager.getService().isLoggedIn()) {
		try {
			long poid = Long.parseLong(request.getParameter("poid"));
			if (loginManager.getService().deleteProject(poid)) {
				if (request.getParameter("ppid") != null) {
					response.sendRedirect("project.jsp?poid=" + request.getParameter("ppid"));
				} else {
					response.sendRedirect("main.jsp");
				}
			} else {
				out.println("Error");
			}
		} catch (UserException e) {
			out.println("<div class=\"error\">" + e.getUserMessage() + "</div>");
		}
	}
%>
<%@ include file="footer.jsp" %>