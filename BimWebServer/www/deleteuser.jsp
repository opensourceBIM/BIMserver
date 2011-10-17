<%@page import="org.bimserver.web.JspHelper"%>
<%@page import="org.bimserver.shared.exceptions.ServiceException"%>
<%@ include file="header.jsp" %>
<%
	if (loginManager.isLoggedIn()) {
		try {
			long uoid = Long.parseLong(request.getParameter("uoid"));
			if (loginManager.getService().deleteUser(uoid)) {
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