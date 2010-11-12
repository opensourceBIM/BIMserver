<%@page import="org.bimserver.shared.UserException"%>
<%@ include file="header.jsp" %>
<%
	if (loginManager.getService().isLoggedIn()) {
		try {
			long uoid = Integer.parseInt(request.getParameter("uoid"));
			if (loginManager.getService().deleteUser(uoid)) {
				response.sendRedirect("users.jsp");
			} else {
				out.println("Error");
			}
		} catch (UserException e) {
			out.println("<div class=\"error\">" + e.getUserMessage() + "</div>");
		}
	}
%>
<%@ include file="footer.jsp" %>