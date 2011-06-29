<%@page import="org.bimserver.shared.UserException"%>
<%@ include file="header.jsp" %>
<%
	if (loginManager.getService().isLoggedIn()) {
		try {
			long ifid = Integer.parseInt(request.getParameter("ifid"));
			loginManager.getService().deleteGuidanceProvider(ifid);
			response.sendRedirect("settings.jsp");
		} catch (UserException e) {
			out.println("<div class=\"error\">" + e.getUserMessage() + "</div>");
		}
	}
%>
<%@ include file="footer.jsp" %>