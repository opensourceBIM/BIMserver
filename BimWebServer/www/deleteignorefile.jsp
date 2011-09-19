<%@page import="org.bimserver.web.JspHelper"%>
<%@page import="org.bimserver.shared.exceptions.ServiceException"%>
<%@ include file="header.jsp" %>
<%
	if (loginManager.getService().isLoggedIn()) {
		try {
			long ifid = Integer.parseInt(request.getParameter("ifid"));
			loginManager.getService().deleteGuidanceProvider(ifid);
			response.sendRedirect("settings.jsp");
		} catch (ServiceException e) {
			JspHelper.showException(out, e);
		}
	}
%>
<%@ include file="footer.jsp" %>