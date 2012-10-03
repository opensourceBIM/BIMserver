<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="org.bimwebserver.jsp.JspHelper"%>
<%@page import="org.bimserver.shared.exceptions.ServiceException"%>
<%@ include file="header.jsp" %>
<%
	if (loginManager.isLoggedIn()) {
		try {
			long uoid = Long.parseLong(request.getParameter("uoid"));
			if (loginManager.getService(request).deleteUser(uoid)) {
				response.sendRedirect("users.jsp");
			} else {
				out.println("Error");
			}
		} catch (ServiceException e) {
			JspHelper.showException(out, e);
		}
	}
%>
<%@ include file="footer.jsp" %>