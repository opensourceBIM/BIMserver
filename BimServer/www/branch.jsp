<%@page import="org.bimserver.shared.UserException"%>
<%@page import="org.bimserver.shared.SCheckinResult"%>
<%@ include file="header.jsp" %>
<%
	try {
		String action = request.getParameter("action");
		long roid = Long.parseLong(request.getParameter("roid"));
		if (action.equals("branchtonewproject")) {
			String name = request.getParameter("name");
			String comment = request.getParameter("comment");
			SCheckinResult checkinResult = loginManager.getService().branchToNewProject(roid, name, comment);
			response.sendRedirect("project.jsp?poid=" + checkinResult.getPoid());
		} else if (action.equals("branchtoexistingproject")) {
			long destPoid = Long.parseLong(request.getParameter("destpoid"));
			String comment = request.getParameter("comment");
			loginManager.getService().branchToExistingProject(roid, destPoid, comment);
			response.sendRedirect("project.jsp?poid=" + destPoid);
		}
	} catch (Exception e) {
%>
	<%=e.getMessage() %>
	<%@ include file="footer.jsp" %>
<%
	}
%>