<%@page import="org.bimserver.interfaces.objects.SObjectState"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="org.slf4j.LoggerFactory"%>
<%@page import="java.util.List" %>
<%@page import="java.util.Collections"%>
<%@page import="org.bimserver.web.LoginManager"%>
<%@page import="org.bimserver.web.JspHelper"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<%@page import="org.bimserver.shared.comparators.SProjectNameComparator"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%@ include file="header.jsp" %>
<%
try {
	if (loginManager.isLoggedIn()) {
		if (loginManager.getService().getServerInfo().getServerState() == SServerState.RUNNING) { %>
<div class="sidebar">
 <ul>
<% if (loginManager.getUserType() != SUserType.READ_ONLY && (loginManager.getUserType() == SUserType.ADMIN || loginManager.getService().isSettingAllowUsersToCreateTopLevelProjects())) { %>
 <li><a href="addproject.jsp">Add project</a></li>
<% } %>
 <li><a class="rss" href="<%=request.getContextPath() %>/syndication/projects">Projects feed</a></li>
<jsp:include page="showdeleted.jsp"/>
 </ul>
</div>
<div class="content">
<h1>Projects</h1>
<%
	List<SProject> projects = loginManager.getService().getAllProjects();
	Collections.sort(projects, new SProjectNameComparator());
	if (projects.size() > 0) {
%>
<table class="formatted maintable">
<%
		for (SProject project : projects) {
			if (project.getParentId() == -1 && project.getState() == SObjectState.ACTIVE) {
				%>
				<tr>
					<th>Name</th>
					<th>Last revision</th>
					<th>Revisions</th>
					<th>Checkouts</th>
					<th>Authorized users</th>
					<th>Actions</th>
				</tr>
				<%
				out.write(JspHelper.writeProjectTree(project, loginManager, 0));
				%>
				<tr><td colspan="6" class="seperator"></td></tr>
				<%
			}
		}
%>
</table>
<%
	} else {
%>
No projects<br/><br/>
<%
		}
	} else {
		response.sendRedirect("setup.jsp");
		return;
	}
} else {
	if (loginManager.getService().getServerInfo().getServerState() == SServerState.NOT_SETUP) {
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