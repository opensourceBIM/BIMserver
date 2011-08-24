<%@page import="org.bimserver.shared.UserException"%>
<%@ include file="header.jsp" %>
<%
	if (loginManager.getService().isLoggedIn()) {
		try {
			long sid = Integer.parseInt(request.getParameter("sid"));
			loginManager.getService().deleteDeserializer(sid);
			response.sendRedirect("settings.jsp");
		} catch (UserException e) {
			out.println("<div class=\"error\">" + e.getUserMessage() + "</div>");
		}
	}
%>
<%@ include file="footer.jsp" %>