<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="org.bimserver.shared.exceptions.ServiceException"%>
<%@page import="org.bimserver.interfaces.objects.SCheckinResult"%>
<%@ include file="header.jsp" %>
<%
	try {
		String action = request.getParameter("action");
		long roid = Long.parseLong(request.getParameter("roid"));
		if (action.equals("branchtonewproject")) {
			String name = request.getParameter("name");
			String comment = request.getParameter("comment");
			SCheckinResult checkinResult = loginManager.getService(request).branchToNewProject(roid, name, comment);
			response.sendRedirect("project.jsp?poid=" + checkinResult.getProjectId());
		} else if (action.equals("branchtoexistingproject")) {
			long destPoid = Long.parseLong(request.getParameter("destpoid"));
			String comment = request.getParameter("comment");
			loginManager.getService(request).branchToExistingProject(roid, destPoid, comment);
			response.sendRedirect("project.jsp?poid=" + destPoid);
		}
	} catch (Exception e) {
%>
	<%=e.getMessage() %>
	<%@ include file="footer.jsp" %>
<%
	}
%>