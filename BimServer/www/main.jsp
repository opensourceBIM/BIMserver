<%@page import="java.util.List" %>
<%@page import="java.util.Collections"%>
<%@page import="org.bimserver.LoginManager"%>
<%@page import="org.bimserver.JspHelper"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<%@page import="org.bimserver.shared.SProjectNameComparator"%>
<%@ include file="header.jsp" %>
<%
if (serverInfo.isAvailable()) {
	if (loginManager.isLoggedIn()) { %>
<%@page import="org.bimserver.interfaces.objects.SUserType"%><div class="sidebar">
 <h4>Submenu</h4>
 <ul>
<% if (loginManager.getUserType() == SUserType.ADMIN || ServerSettings.getSettings().isAllowUsersToCreateTopLevelProjects()) { %>
 <li><a href="addproject.jsp">Add project</a></li>
<% } %>
 </ul>
</div>

<div class="content">

<h1>Projects</h1>
<fieldset>
<table class="formatted maintable">
<%
	List<SProject> projects = loginManager.getService().getAllProjects();
	Collections.sort(projects, new SProjectNameComparator());
	if (projects.size() > 0) {

	for (SProject project : projects) {
		if (project.getParentId() == -1) {
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
</table>
No projects<br/><br/>

<%
	}
%>
<a class="rss" href="<%=request.getContextPath() %>/syndication/projects">Projects feed</a>
<%
	}
}
%>
</fieldset>
</div>
<%@ include file="footer.jsp" %>