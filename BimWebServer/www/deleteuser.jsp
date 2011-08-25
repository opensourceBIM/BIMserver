<%@page import="org.bimserver.web.JspHelper"%>
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
			JspHelper.showException(out, e);
		}
	}
%>
<%@ include file="footer.jsp" %>