<%@page import="org.bimserver.web.JspHelper"%>
<%@page import="org.bimserver.shared.UserException"%>
<%@ include file="header.jsp" %>
<%
	if (loginManager.getService().isLoggedIn()) {
		try {
			long poid = Long.parseLong(request.getParameter("poid"));
			if (loginManager.getService().deleteProject(poid)) {
				if (request.getParameter("ppid") != null) {
					response.sendRedirect("project.jsp?poid=" + request.getParameter("ppid"));
				} else {
					response.sendRedirect("main.jsp");
				}
			} else {
				out.println("Error");
			}
		} catch (UserException e) {
			JspHelper.showException(out, e);
		}
	}
%>
<%@ include file="footer.jsp" %>