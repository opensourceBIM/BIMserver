<%@page import="org.bimserver.shared.UserException"%>
<%@ include file="header.jsp" %>
<%
	if (loginManager.getService().isLoggedIn()) {
		try {
			long ifid = Integer.parseInt(request.getParameter("ifid"));
			if (loginManager.getService().deleteIgnoreFile(ifid)) {
				response.sendRedirect("settings.jsp");
			} else {
				out.println("Error");
			}
		} catch (UserException e) {
			out.println("<div class=\"error\">" + e.getUserMessage() + "</div>");
		}
	}
%>
<%@ include file="footer.jsp" %>