<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.bimserver.shared.comparators.SLogActionDateComparator"%>
<%@page import="org.bimwebserver.jsp.JspHelper"%>
<%@page import="org.bimserver.interfaces.objects.SRevision"%>
<%@page import="org.bimserver.interfaces.objects.SDatabaseCreated"%>
<%@page import="org.bimserver.interfaces.objects.SPasswordChanged"%>
<%@page import="org.bimserver.interfaces.objects.SPasswordReset"%>
<%@page import="org.bimserver.interfaces.objects.SGeoTag"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<%@page import="org.bimserver.interfaces.objects.SGeoTagUpdated"%>
<%@page import="org.bimserver.interfaces.objects.SUserChanged"%>
<%@page import="org.bimserver.interfaces.objects.SProjectUpdated"%>
<%@page import="org.bimserver.interfaces.objects.SServerStarted"%>
<%@page import="org.bimserver.interfaces.objects.SUserRemovedFromProject"%>
<%@page import="org.bimserver.interfaces.objects.SProjectUndeleted"%>
<%@page import="org.bimserver.interfaces.objects.SUserUndeleted"%>
<%@page import="org.bimserver.interfaces.objects.SProjectDeleted"%>
<%@page import="org.bimserver.interfaces.objects.SUserDeleted"%>
<%@page import="org.bimserver.interfaces.objects.SNewRevisionAdded"%>
<%@page import="org.bimserver.interfaces.objects.SNewUserAdded"%>
<%@page import="org.bimserver.interfaces.objects.SNewProjectAdded"%>
<%@page import="org.bimserver.interfaces.objects.SUserAddedToProject"%>
<%@page import="java.util.Collections"%>
<%@page import="org.bimserver.interfaces.objects.SLogAction"%>
<%@page import="java.util.List"%>
<%@ include file="header.jsp" %>
<h1>Log</h1>
<%
if (loginManager.isLoggedIn() && loginManager.getUserType() == SUserType.ADMIN) {
%>
		<table class="formatted infotable">
			<tr><th>Date/Time</th><th>Type</th><th>User</th><th>Access method</th><th>Summary</th></tr>
<%
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	List<SLogAction> logs = loginManager.getService(request).getLogs();
	Collections.sort(logs, new SLogActionDateComparator());
	for (SLogAction log : logs) {
		SUser logUser = loginManager.getService(request).getUserByUoid(log.getExecutorId());
%>
	<tr>
		<td style="white-space:nowrap"><%=dateFormat.format(log.getDate()) %></td>
		<td style="white-space:nowrap"><%=log.getClass().getSimpleName().substring(1) %></td>
<% if (logUser != null) { %>
		<td style="white-space:nowrap"><a href="user.jsp?uoid=<%=log.getExecutorId()%>"><%=logUser.getUsername() %></a></td>
<% } else { %>
		<td>System</td>
<% } %>
		<td style="white-space:nowrap"><%=JspHelper.getNiceAccessMethodName(log.getAccessMethod()) %></td>
		<td>
		<%
			if (log instanceof SUserAddedToProject) {
				SProject sProject = loginManager.getService(request).getProjectByPoid(((SUserAddedToProject)log).getProjectId());
				SUser sUser = loginManager.getService(request).getUserByUoid(((SUserAddedToProject)log).getUserId());
%>User <a href="user.jsp?uoid=<%=sUser.getOid()%>"><%=sUser.getName() %></a> added to project <a href="project.jsp?poid=<%=sProject.getOid()%>"><%=sProject.getName() %></a><%
			} else if (log instanceof SNewProjectAdded) {
				SNewProjectAdded sNewProjectAdded = (SNewProjectAdded)log;
				SProject sProject = loginManager.getService(request).getProjectByPoid(sNewProjectAdded.getProjectId());
%>Project <a href="project.jsp?poid=<%=sProject.getOid()%>"><%=sProject.getName() %></a> created<%
if (sNewProjectAdded.getParentProjectId() != -1) {
	SProject parentProject = (SProject)loginManager.getService(request).getProjectByPoid(sNewProjectAdded.getParentProjectId());
%>
 as a subproject of <a href="project.jsp?poid=<%=parentProject.getOid()%>"><%=parentProject.getName() %></a>
<%
}
			} else if (log instanceof SNewUserAdded) {
				SUser sUser = loginManager.getService(request).getUserByUoid(((SNewUserAdded)log).getUserId());
%>User <a href="user.jsp?uoid=<%=sUser.getOid()%>"><%=sUser.getName() %></a> created<%
			} else if (log instanceof SNewRevisionAdded) {
				SNewRevisionAdded sNewRevisionAdded = (SNewRevisionAdded)log;
				SRevision sRevision = loginManager.getService(request).getRevision(sNewRevisionAdded.getRevisionId());
				SProject sProject = loginManager.getService(request).getProjectByPoid(sRevision.getProjectId());
%>Revision <a href="revision.jsp?roid=<%=sRevision.getOid()%>"><%=sRevision.getComment() + " (" + sRevision.getId() + ")" %></a> created on project <a href="project.jsp?poid=<%=sProject.getOid()%>"><%=sProject.getName() %></a><%
			} else if (log instanceof SUserDeleted) {
				SUser sUser = loginManager.getService(request).getUserByUoid(((SUserDeleted)log).getUserId());
%>User <a href="user.jsp?uoid=<%=sUser.getOid()%>"><%=sUser.getName() %></a> deleted<%
			} else if (log instanceof SProjectDeleted) {
				SProject sProject = loginManager.getService(request).getProjectByPoid(((SProjectDeleted)log).getProjectId());
%>Project <a href="project.jsp?poid=<%=sProject.getOid()%>"><%=sProject.getName() %></a> deleted<%
			} else if (log instanceof SUserUndeleted) {
				SUser sUser = loginManager.getService(request).getUserByUoid(((SUserUndeleted)log).getUserId());
%>User <a href="user.jsp?uoid=<%=sUser.getOid()%>"><%=sUser.getName() %></a> undeleted<%
			} else if (log instanceof SProjectUndeleted) {
				SProject sProject = loginManager.getService(request).getProjectByPoid(((SProjectUndeleted)log).getProjectId());
%>Project <a href="project.jsp?poid=<%=sProject.getOid()%>"><%=sProject.getName() %></a> undeleted<%
			} else if (log instanceof SUserRemovedFromProject) {
				SProject sProject = loginManager.getService(request).getProjectByPoid(((SUserRemovedFromProject)log).getProjectId());
				SUser sUser = loginManager.getService(request).getUserByUoid(((SUserRemovedFromProject)log).getUserId());
%>User <a href="user.jsp?uoid=<%=sUser.getOid()%>"><%=sUser.getName() %></a> removed from project <a href="project.jsp?poid=<%=sProject.getOid()%>"><%=sProject.getName() %></a><%
			} else if (log instanceof SServerStarted) {
%>Server started<%
			} else if (log instanceof SProjectUpdated) {
				SProject sProject = loginManager.getService(request).getProjectByPoid(((SProjectUpdated)log).getProjectId());
%>Project <a href="project.jsp?poid=<%=sProject.getOid()%>"><%=sProject.getName() %></a> updated<%
			} else if (log instanceof SGeoTagUpdated) {
				SGeoTagUpdated sGeoTagUpdated =  (SGeoTagUpdated)log;
			    SGeoTag sGeoTag = loginManager.getService(request).getGeoTag(sGeoTagUpdated.getGeoTagId());
			    SProject sProject = loginManager.getService(request).getProjectByPoid(sGeoTag.getProjects().get(0));
%>GeoTag of project <a href="project.jsp?poid=<%=sProject.getOid()%>"><%=sProject.getName() %></a> updated<%				
			} else if (log instanceof SUserChanged) {
				SUserChanged sUserChanged = (SUserChanged)log;
				SUser sUser = loginManager.getService(request).getUserByUoid(sUserChanged.getUserId());
%>User <a href="user.jsp?uoid=<%=sUser.getOid()%>"><%=sUser.getName() %></a> changed<%
			} else if (log instanceof SPasswordReset) {
				SPasswordReset sPasswordReset = (SPasswordReset)log;
				SUser sUser = loginManager.getService(request).getUserByUoid(sPasswordReset.getUserId());
%>Password of user <a href="user.jsp?uoid=<%=sUser.getOid()%>"><%=sUser.getName() %></a> resetted<%
			} else if (log instanceof SPasswordChanged) {
				SPasswordChanged sPasswordChanged = (SPasswordChanged)log;
				SUser sUser = loginManager.getService(request).getUserByUoid(sPasswordChanged.getUserId());
%>Password of user <a href="user.jsp?uoid=<%=sUser.getOid()%>"><%=sUser.getName() %></a> changed<%
			} else if (log instanceof SDatabaseCreated) {
				SDatabaseCreated sDatabaseCreated = (SDatabaseCreated)log;
%>Database (version <%=sDatabaseCreated.getVersion() %>) created in <%=sDatabaseCreated.getPath()%><%
			} else {
%>
[Not implemented]
<%
			}
		%>
		</td>
	</tr>
<%
	}
%>
		</table>
<%
} else {
	out.println("Insufficient rights");
}%>
<%@ include file="footer.jsp" %>