<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="org.bimwebserver.jsp.JspHelper"%>
<%@page import="org.bimserver.shared.exceptions.ServiceException"%>
<%@ include file="header.jsp" %>
<%
	if (loginManager.isLoggedIn()) {
		try {
			long sid = Long.parseLong(request.getParameter("sid"));
			loginManager.getService().deleteSerializer(sid);
			response.sendRedirect("serializers.jsp");
		} catch (ServiceException e) {
			JspHelper.showException(out, e);
		}
	}
%>
<%@ include file="footer.jsp" %>