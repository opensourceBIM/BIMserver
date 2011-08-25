<%@page import="org.bimserver.web.JspHelper"%>
<%@page import="org.bimserver.shared.UserException"%>
<%@ include file="header.jsp" %>
<%
	if (loginManager.getService().isLoggedIn()) {
		try {
			long sid = Integer.parseInt(request.getParameter("sid"));
			loginManager.getService().deleteDeserializer(sid);
			response.sendRedirect("settings.jsp");
		} catch (UserException e) {
			JspHelper.showException(out, e);
		}
	}
%>
<%@ include file="footer.jsp" %>