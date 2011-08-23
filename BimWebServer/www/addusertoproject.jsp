<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%@page import="org.bimserver.shared.UserException"%>
<%@ include file="header.jsp"%>
<%
	if (loginManager.getService().isLoggedIn()) {
		try {
			long poid = Long.parseLong(request.getParameter("poid"));
			String type = request.getParameter("type");
			if (type.equals("project") || type.equals("user")) {
				long uoid = Long.parseLong(request.getParameter("uoid"));
				loginManager.getService().addUserToProject(uoid, poid);
				if (request.getParameter("type").equals("project")) {
					response.sendRedirect("project.jsp?poid=" + poid);
				} else if (request.getParameter("type").equals("user")) {
					response.sendRedirect("user.jsp?uoid=" + uoid);
				}
			} else if (type.equals("invitedUser")) {
				String username = request.getParameter("username");
				String name = request.getParameter("name");
%>
<jsp:include page="register.jsp">
	<jsp:param name="register" value="Register" />
	<jsp:param name="register_username" value="<%=username%>" />
	<jsp:param name="register_name" value="<%=name%>" />
</jsp:include>
<%
				SUser user = loginManager.getService().getUserByUserName(username);
				if (user != null) {
					long uoid = user.getOid();
					loginManager.getService().addUserToProject(uoid, poid);
					response.sendRedirect("project.jsp?poid=" + poid);
				}
			}
		} catch (UserException e) {
			out.println("<div class=\"error\">" + e.getUserMessage() + "</div>");
		}
	}
%>