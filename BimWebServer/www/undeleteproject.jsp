<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="org.bimwebserver.jsp.JspHelper"%>
<%@page import="org.bimserver.shared.exceptions.ServiceException"%>
<%@ include file="header.jsp" %>
<%
	if (loginManager.isLoggedIn()) {
		try {
			long poid = Long.parseLong(request.getParameter("poid"));
			if (loginManager.getService(request).undeleteProject(poid)) {
				if (request.getParameter("ppid") != null) {
					response.sendRedirect("project.jsp?poid=" + request.getParameter("ppid"));
				} else {
					response.sendRedirect("main.jsp");
				}
			} else {
				out.println("Error");
			}
		} catch (ServiceException e) {
			JspHelper.showException(out, e);
		}
	}
%>
<%@ include file="footer.jsp" %>