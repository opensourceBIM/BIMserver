<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="org.bimwebserver.jsp.JspHelper"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%@page import="org.bimserver.shared.exceptions.ServiceException"%>
<%@ include file="header.jsp"%>
<%
	if (loginManager.isLoggedIn()) {
		try {
			long poid = Long.parseLong(request.getParameter("poid"));
			String type = request.getParameter("type");
			if (type.equals("project") || type.equals("user")) {
				long uoid = Long.parseLong(request.getParameter("uoid"));
				loginManager.getService(request).addUserToProject(uoid, poid);
				if (request.getParameter("type").equals("project")) {
					response.sendRedirect("project.jsp?poid=" + poid);
				} else if (request.getParameter("type").equals("user")) {
					response.sendRedirect("user.jsp?uoid=" + uoid);
				}
			}
		} catch (ServiceException e) {
			JspHelper.showException(out, e);
		}
	}
%>