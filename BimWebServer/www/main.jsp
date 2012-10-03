<%@page import="org.bimserver.shared.interfaces.ServiceInterface"%>
<%@page import="org.bimserver.interfaces.objects.SObjectState"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="org.slf4j.LoggerFactory"%>
<%@page import="java.util.List" %>
<%@page import="java.util.Collections"%>
<%@page import="org.bimwebserver.jsp.LoginManager"%>
<%@page import="org.bimwebserver.jsp.JspHelper"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<%@page import="org.bimserver.shared.comparators.SProjectNameComparator"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%@ include file="header.jsp" %>
<%
try {
	ServiceInterface service = loginManager.getService(request);
	if (loginManager.isLoggedIn()) {
		if (service.getServerInfo().getServerState() == SServerState.RUNNING) { %>
<div class="sidebar">
 <ul>
<% if (loginManager.getUserType() != SUserType.READ_ONLY && (loginManager.getUserType() == SUserType.ADMIN || service.isSettingAllowUsersToCreateTopLevelProjects())) { %>
 <li><a href="addproject.jsp">Add project</a></li>
<% } %>
 <li><a class="rss" href="<%=request.getContextPath() %>/syndication/projects">Projects feed</a></li>
<jsp:include page="showdeleted.jsp"/>
 </ul>
</div>
<div class="content">
<h1>Projects</h1>
<%
	List<SProject> projects = service.getAllProjects(false);
	Collections.sort(projects, new SProjectNameComparator());
	if (projects.size() > 0) {
%>
<table class="formatted maintable">
<%
		for (SProject project : projects) {
			if (project.getParentId() == -1) {
				out.write(JspHelper.writeProjectTree(project, loginManager, 0, true));
			}
		}
%>
</table>
<%
	} else {
%>
There are no projects yet.<br/><br/>
<% if (loginManager.getUserType() == SUserType.ADMIN ) { %>
 Please take a moment to register yourself as a BIMserver manager.<br/>
 <a href="https://docs.google.com/spreadsheet/embeddedform?formkey=dG5DYUNyVnA0Mk5DWnN0eHFueDlMR2c6MQ" target="_blank">Click here to register. We promise you will feel better afterwards.</a><br/>
<% } %>

<%
		}
	} else {
		response.sendRedirect("setup.jsp");
		return;
	}
} else {
	if (service.getServerInfo().getServerState() == SServerState.NOT_SETUP) {
		response.sendRedirect("setup.jsp");
		return;
	}
}
%>
</div>
<%
} catch (Exception e) {
	LoggerFactory.getLogger(JspHelper.class).error("", e);
}
%>
<%@ include file="footer.jsp" %>