<%@ include file="header.jsp" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Collections"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="org.bimserver.utils.Formatters"%>
<%@page import="org.bimserver.shared.DatabaseInformation"%>
<%@page import="org.bimserver.version.VersionChecker"%>
<%@page import="java.util.Map"%>
<%@page import="org.bimserver.web.WarServerInitializer"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.bimserver.database.Database"%>
<%@page import="java.io.File"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%@page import="org.bimserver.interfaces.objects.SLogAction"%>
<%@page import="org.bimserver.interfaces.objects.SUser"%>
<%@page import="org.bimserver.interfaces.objects.SUserAddedToProject"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<%@page import="org.bimserver.interfaces.objects.SNewProjectAdded"%>
<%@page import="org.bimserver.shared.SLogActionDateComparator"%>
<%@page import="org.bimserver.interfaces.objects.SNewUserAdded"%>
<%@page import="org.bimserver.interfaces.objects.SNewRevisionAdded"%>
<%@page import="org.bimserver.interfaces.objects.SRevision"%>
<%@page import="org.bimserver.interfaces.objects.SUserDeleted"%>
<%@page import="org.bimserver.interfaces.objects.SProjectDeleted"%>
<%@page import="org.bimserver.interfaces.objects.SUserUndeleted"%>
<%@page import="org.bimserver.interfaces.objects.SProjectUndeleted"%>
<%@page import="org.bimserver.interfaces.objects.SUserRemovedFromProject"%>
<%@page import="org.bimserver.interfaces.objects.SServerStarted"%>
<%@page import="org.bimserver.interfaces.objects.SProjectUpdated"%>
<%@page import="org.bimserver.shared.SUserSession"%>
<%@page import="org.bimserver.web.JspHelper"%>
<%@page import="org.bimserver.interfaces.objects.SClashDetectionSettingsUpdated"%>
<%@page import="org.bimserver.interfaces.objects.SGeoTagUpdated"%>
<%@page import="org.bimserver.interfaces.objects.SUserChanged"%>
<%@page import="org.bimserver.interfaces.objects.SPasswordReset"%>
<%@page import="org.bimserver.interfaces.objects.SPasswordChanged"%>
<%@page import="org.bimserver.interfaces.objects.SClashDetectionSettings"%>
<%@page import="org.bimserver.interfaces.objects.SGeoTag"%>
<%@page import="org.bimserver.interfaces.objects.SDatabaseCreated"%>
<%@page import="org.bimserver.shared.SLongAction"%>
<%@page import="java.util.Date"%><div class="sidebar">
</div>
<div class="content">
<h1>Info</h1>
<%
	if (loginManager.getService().isLoggedIn() && loginManager.getUserType() == SUserType.ADMIN) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		DatabaseInformation databaseInformation = loginManager.getService().getDatabaseInformation();
		VersionChecker checkVersion = WebServerHelper.getBimServer().getVersionChecker();
		if (loginManager.getService().isSettingShowVersionUpgradeAvailable() && checkVersion.updateNeeded()) {
%>
<div class="error">
A newer version of the BIMserver is available online.<br/>
<a href="<%= checkVersion.getOnlineVersion().getSupportUrl() %>">Support</a> | <a href="<%= checkVersion.getOnlineVersion().getDownloadUrl() %>">Download</a><br/>
E-mail <a href="mailto:<%= checkVersion.getOnlineVersion().getSupportEmail() %>"><%= checkVersion.getOnlineVersion().getSupportEmail() %></a> for more info<br/>
</div>
<%
	}
%>

<div class="tabber" id="infotabber">
	<%@ include file="extraInfo.jsp" %>
	<div class="tabbertab" id="license" title="License">
	  (c) Copyright bimserver.org<br/>
	  Licensed under GNU GPLv3<br/>
	  <a href="http://www.gnu.org/licenses/gpl-3.0.txt" target="_blank">http://www.gnu.org/licenses/gpl-3.0.txt</a><br/>
	  For more information mail to <a href="mailto:license@bimserver.org">license@bimserver.org</a><br/>
      <br/>
      BIMserver software uses the IFC Engine DLL.<br/>
      This Engine DLL is NOT open source. The IFC Engine DLL is a commercial product owned by TNO.<br/>
	  The latest versions are available for download from <a href=" http://ifcengine.com" target="_blank">ifcengine.com</a>. <br/>
      In case of none commercial use there is no license fee and redistribution is free as long as clearly mentioned that the IFC Engine DLL is used. <br/>
      This BIMserver software is non-commercial so users of the BIMserver software can use it free of charge.<br/>
      Within the Open Source BIMserver there is one exception to the normal conditions:<br/>
      A special version of the IFC Engine DLL is used that includes Clashdetection functionality, this version is not commercially available. For more information, please contact TNO.<br/>
      <br/>
	</div>
	<div class="tabbertab" id="systemtab" title="System">
		<table class="formatted infotable">
			<tr><td colspan="2" class="tabletitle">System</td></tr>
			<tr><td class="firstcolumn">CPU Cores</td><td><%=Runtime.getRuntime().availableProcessors() %></td></tr>
			<tr><td class="firstcolumn">Date/Time</td><td><%=new GregorianCalendar().getTime() %></td></tr>
			<tr><td colspan="2" class="tabletitle">Operating System</td></tr>
			<tr><td class="firstcolumn">OS Name</td><td><%=System.getProperty("os.name") %></td></tr>
			<tr><td class="firstcolumn">OS Version</td><td><%=System.getProperty("os.version") %></td></tr>
			<tr><td colspan="2" class="tabletitle">User</td></tr>
			<tr><td class="firstcolumn">User</td><td><%=System.getProperty("user.name") %></td></tr>
			<tr><td class="firstcolumn">User home</td><td><%=System.getProperty("user.home") %></td></tr>
			<tr><td class="firstcolumn">User dir</td><td><%=System.getProperty("user.dir") %></td></tr>
		</table>
	</div>
	<div class="tabbertab" id="javatab" title="Java">
		<table class="formatted infotable">
			<tr><td colspan="2" class="tabletitle">Memory</td></tr>
			<tr><td class="firstcolumn">Total mem</td><td><%=Formatters.bytesToString(Runtime.getRuntime().totalMemory()) %></td></tr>
			<tr><td class="firstcolumn">Used mem</td><td><%=Formatters.bytesToString(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) %></td></tr>
			<tr><td class="firstcolumn">Free mem</td><td><%=Formatters.bytesToString(Runtime.getRuntime().freeMemory()) %></td></tr>
			<tr><td class="firstcolumn">Max mem</td><td><%=Formatters.bytesToString(Runtime.getRuntime().maxMemory()) %></td></tr>
			<tr><td class="firstcolumn">Threads</td><td><%=Thread.activeCount() %></td></tr>
			<tr><td colspan="2" class="tabletitle">Java</td></tr>
			<tr><td class="firstcolumn">Java Home</td><td><%=System.getProperty("java.home") %></td></tr>
			<tr><td class="firstcolumn">Java Version</td><td><%=System.getProperty("java.version") %></td></tr>
			<tr><td class="firstcolumn">Java Vendor</td><td><%=System.getProperty("java.vendor") %></td></tr>
			<tr><td class="firstcolumn">Java Vendor URL</td><td><%=System.getProperty("java.vendor.url") %></td></tr>
			<tr><td colspan="2" class="tabletitle">Java VM</td></tr>
			<tr><td class="firstcolumn">Java VM version</td><td><%=System.getProperty("java.vm.version") %></td></tr>
			<tr><td class="firstcolumn">Java VM vendor</td><td><%=System.getProperty("java.vm.vendor") %></td></tr>
			<tr><td class="firstcolumn">Java VM name</td><td><%=System.getProperty("java.vm.name") %></td></tr>
			<tr><td colspan="2" class="tabletitle">Java Specification</td></tr>
			<tr><td class="firstcolumn">Java Spec version</td><td><%=System.getProperty("java.specification.version") %></td></tr>
			<tr><td class="firstcolumn">Java Spec vendor</td><td><%=System.getProperty("java.specification.vendor") %></td></tr>
			<tr><td class="firstcolumn">Java Spec name</td><td><%=System.getProperty("java.specification.name") %></td></tr>
			<tr><td colspan="2" class="tabletitle">Java Other</td></tr>
			<tr><td class="firstcolumn">Java Class version</td><td><%=System.getProperty("java.class.version") %></td></tr>
			<%
				String[] split = System.getProperty("java.class.path").split(File.pathSeparator);
			%>
			<tr><td class="firstcolumn">Java Class path</td><td>
			<%
				for (String path : split) {
					out.println(path + "<br/>");
				}
			%>
			</td></tr>
			<tr><td class="firstcolumn">Java Library path</td><td><%=System.getProperty("java.library.path") %></td></tr>
			<tr><td class="firstcolumn">Java IO tempdir</td><td><%=System.getProperty("java.io.tmpdir") %></td></tr>
			<tr><td class="firstcolumn">Java Compiler</td><td><%=System.getProperty("java.compiler") %></td></tr>
			<tr><td class="firstcolumn">Java ext dir</td><td><%=System.getProperty("java.ext.dirs") %></td></tr>
			<tr><td class="firstcolumn">File separator</td><td><%=System.getProperty("file.separator") %></td></tr>
			<tr><td class="firstcolumn">Path separator</td><td><%=System.getProperty("path.separator") %></td></tr>
			<tr><td class="firstcolumn">Line separator</td><td><%=System.getProperty("line.separator") %></td></tr>
		</table>
	</div>
	<div class="tabbertab" id="bimservertab" title="BIMserver">
		<table class="formatted infotable">
			<tr><td colspan="2" class="tabletitle">Version</td></tr>
			<tr><td class="firstcolumn">Local Version</td><td><%=checkVersion.getLocalVersion().getVersion() %></td></tr>
			<tr><td class="firstcolumn">Build date/time</td><td><%=dateFormat.format(checkVersion.getLocalVersion().getDate()) %></td></tr>
			<tr><td class="firstcolumn">Schema Version</td><td><%=Database.APPLICATION_SCHEMA_VERSION %></td></tr>
			<tr><td colspan="2" class="tabletitle">Latest available version</td></tr>
			<tr><td class="firstcolumn">Latest Version</td><td><%=checkVersion.getOnlineVersion().getVersion() %></td></tr>
			<tr><td class="firstcolumn">Build date/time</td><td><%=dateFormat.format(checkVersion.getOnlineVersion().getDate()) %></td></tr>
			<tr><td colspan="2" class="tabletitle">Counts</td></tr>
			<tr><td class="firstcolumn">Projects</td><td><%=databaseInformation.getNumberOfProjects() %></td></tr>
			<tr><td class="firstcolumn">Users</td><td><%=databaseInformation.getNumberOfUsers() %></td></tr>
			<tr><td class="firstcolumn">Revisions</td><td><%=databaseInformation.getNumberOfRevisions() %></td></tr>
			<tr><td class="firstcolumn">Checkouts</td><td><%=databaseInformation.getNumberOfCheckouts() %></td></tr>
			<tr><td colspan="2" class="tabletitle">Other</td></tr>
			<tr><td class="firstcolumn">Server started at</td><td><%=dateFormat.format(loginManager.getService().getServerStartTime()) %></td></tr>
			<%
				GregorianCalendar gc = new GregorianCalendar();
				gc.setTime(loginManager.getService().getServerStartTime());
			%>
			<tr><td class="firstcolumn">Uptime</td><td><%=Formatters.timeSpanToString(gc, new GregorianCalendar()) %></td></tr>
		</table>
	</div>
	<div class="tabbertab" id="databasetab" title="Database">
		<table class="formatted infotable">
			<tr><td colspan="2" class="tabletitle">General Information</td></tr>
			<tr><td class="firstcolumn">Location</td><td><%=databaseInformation.getLocation() %></td></tr>
			<tr><td class="firstcolumn">Created</td><td><%=dateFormat.format(databaseInformation.getCreated()) %></td></tr>
			<tr><td class="firstcolumn">Type</td><td><%=databaseInformation.getType() %></td></tr>
			<tr><td class="firstcolumn">Size</td><td><%=Formatters.bytesToString(databaseInformation.getDatabaseSizeInBytes()) %></td></tr>
			<tr><td class="firstcolumn">Schema Version</td><td><%=databaseInformation.getSchemaVersion() %></td></tr>
			<%
				Map<String, Map<String, String>> genericLines = databaseInformation.getGenericLines();
				for (String title : genericLines.keySet()) {
					out.println("<tr><td colspan=\"2\" class=\"tabletitle\">" + title + "</td></tr>");
					for (String key : genericLines.get(title).keySet()) {
						out.println("<tr><td class=\"firstcolumn\">" + key + "</td><td>" + genericLines.get(title).get(key) + "</td></tr>");
					}
				}
			%>
		</table>
	</div>
	<div class="tabbertab" id="webservicetab" title="Web Services">
		<table class="formatted infotable">
			<tr><td colspan="2" class="tabletitle">General Information</td></tr>
			<tr><td class="firstcolumn">SOAP Service Descriptor</td><td><a href="soap?wsdl">WSDL</a></td></tr>
			<tr><td class="firstcolumn">Rest Service Descriptor</td><td><a href="rest?_wadl">WADL</a></td></tr>
			<tr><td class="firstcolumn">Protocol Buffers Desriptor File</td><td><a href="/files?file=service.proto">Proto</a></td></tr>
		</table>
	</div>
	<div class="tabbertab" id="activesessions" title="Active sessions">
		<table class="formatted infotable">
			<tr>
				<th>Username</th>
				<th>Name</th>
				<th>Type</th>
				<th>Access method</th>
				<th>Active since</th>
				<th>Last active</th>
			</tr>
<%
	List<SUserSession> userSessions = loginManager.getService().getActiveUserSessions();
	for (SUserSession userSession : userSessions) {
%>
	<tr>
		<td><a href="user.jsp?uoid=<%=userSession.getUoid()%>"><%=userSession.getUsername() %></a></td>
		<td><%=userSession.getName() %></td>
		<td><%=JspHelper.getNiceUserTypeName(userSession.getType()) %></td>
		<td><%=JspHelper.getNiceAccessMethodName(userSession.getAccessMethod()) %></td>
		<td><%=dateFormat.format(userSession.getActiveSince()) %></td>
		<td><%=dateFormat.format(userSession.getLastActive()) %></td>
	</tr>
<%
	}
%>
		</table>
	</div>
	<div class="tabbertab" id="activelongactions" title="Active long actions">
		<table class="formatted infotable">
			<tr>
				<th>Username</th>
				<th>Name</th>
				<th>Description</th>
				<th>Started</th>
				<th>Running</th>
			</tr>
<%
	List<SLongAction> longActions = loginManager.getService().getActiveLongActions();
	for (SLongAction longAction : longActions) {
		long millis = System.currentTimeMillis() - longAction.getStart().getTime();		
%>
	<tr>
		<td><a href="user.jsp?uoid=<%=longAction.getUserOid()%>"><%=longAction.getUsername() %></a></td>
		<td><%=longAction.getName() %></td>
		<td><%=longAction.getIdentification() %></td>
		<td><%=dateFormat.format(longAction.getStart()) %></td>
		<td><%=Formatters.millisecondsToString(millis) %></td>
	</tr>
<%
	}
%>
		</table>
	</div>
	<div class="tabbertab" id="logtab" title="Log">
		<table class="formatted infotable">
			<tr><th>Date/Time</th><th>Type</th><th>User</th><th>Access method</th><th>Summary</th></tr>
<%
	List<SLogAction> logs = loginManager.getService().getLogs();
	Collections.sort(logs, new SLogActionDateComparator());
	for (SLogAction log : logs) {
		SUser logUser = loginManager.getService().getUserByUoid(log.getExecutorId());
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
				SProject sProject = loginManager.getService().getProjectByPoid(((SUserAddedToProject)log).getProjectId());
				SUser sUser = loginManager.getService().getUserByUoid(((SUserAddedToProject)log).getUserId());
%>User <a href="user.jsp?uoid=<%=sUser.getOid()%>"><%=sUser.getName() %></a> added to project <a href="project.jsp?poid=<%=sProject.getOid()%>"><%=sProject.getName() %></a><%
			} else if (log instanceof SNewProjectAdded) {
				SNewProjectAdded sNewProjectAdded = (SNewProjectAdded)log;
				SProject sProject = loginManager.getService().getProjectByPoid(sNewProjectAdded.getProjectId());
%>Project <a href="project.jsp?poid=<%=sProject.getOid()%>"><%=sProject.getName() %></a> created<%
if (sNewProjectAdded.getParentProjectId() != -1) {
	SProject parentProject = (SProject)loginManager.getService().getProjectByPoid(sNewProjectAdded.getParentProjectId());
%>
 as a subproject of <a href="project.jsp?poid=<%=parentProject.getOid()%>"><%=parentProject.getName() %></a>
<%
}
			} else if (log instanceof SNewUserAdded) {
				SUser sUser = loginManager.getService().getUserByUoid(((SNewUserAdded)log).getUserId());
%>User <a href="user.jsp?uoid=<%=sUser.getOid()%>"><%=sUser.getName() %></a> created<%
			} else if (log instanceof SNewRevisionAdded) {
				SNewRevisionAdded sNewRevisionAdded = (SNewRevisionAdded)log;
				SRevision sRevision = loginManager.getService().getRevision(sNewRevisionAdded.getRevisionId());
				SProject sProject = loginManager.getService().getProjectByPoid(sRevision.getProjectId());
%>Revision <a href="revision.jsp?roid=<%=sRevision.getOid()%>"><%=sRevision.getComment() + " (" + sRevision.getId() + ")" %></a> created on project <a href="project.jsp?poid=<%=sProject.getOid()%>"><%=sProject.getName() %></a><%
			} else if (log instanceof SUserDeleted) {
				SUser sUser = loginManager.getService().getUserByUoid(((SUserDeleted)log).getUserId());
%>User <a href="user.jsp?uoid=<%=sUser.getOid()%>"><%=sUser.getName() %></a> deleted<%
			} else if (log instanceof SProjectDeleted) {
				SProject sProject = loginManager.getService().getProjectByPoid(((SProjectDeleted)log).getProjectId());
%>Project <a href="project.jsp?poid=<%=sProject.getOid()%>"><%=sProject.getName() %></a> deleted<%
			} else if (log instanceof SUserUndeleted) {
				SUser sUser = loginManager.getService().getUserByUoid(((SUserUndeleted)log).getUserId());
%>User <a href="user.jsp?uoid=<%=sUser.getOid()%>"><%=sUser.getName() %></a> undeleted<%
			} else if (log instanceof SProjectUndeleted) {
				SProject sProject = loginManager.getService().getProjectByPoid(((SProjectUndeleted)log).getProjectId());
%>Project <a href="project.jsp?poid=<%=sProject.getOid()%>"><%=sProject.getName() %></a> undeleted<%
			} else if (log instanceof SUserRemovedFromProject) {
				SProject sProject = loginManager.getService().getProjectByPoid(((SUserRemovedFromProject)log).getProjectId());
				SUser sUser = loginManager.getService().getUserByUoid(((SUserRemovedFromProject)log).getUserId());
%>User <a href="user.jsp?uoid=<%=sUser.getOid()%>"><%=sUser.getName() %></a> removed from project <a href="project.jsp?poid=<%=sProject.getOid()%>"><%=sProject.getName() %></a><%
			} else if (log instanceof SServerStarted) {
%>Server started<%
			} else if (log instanceof SProjectUpdated) {
				SProject sProject = loginManager.getService().getProjectByPoid(((SProjectUpdated)log).getProjectId());
%>Project <a href="project.jsp?poid=<%=sProject.getOid()%>"><%=sProject.getName() %></a> updated<%
			} else if (log instanceof SClashDetectionSettingsUpdated) {
				SClashDetectionSettingsUpdated sClashDetectionSettingsUpdated =  (SClashDetectionSettingsUpdated)log;
				SClashDetectionSettings sClashDetectionSettings = loginManager.getService().getClashDetectionSettings(sClashDetectionSettingsUpdated.getClashDetectionSettingsId());
				SProject sProject = loginManager.getService().getProjectByPoid(sClashDetectionSettings.getProjects().get(0));
%>Clash detection settings of project <a href="project.jsp?poid=<%=sProject.getOid()%>"><%=sProject.getName() %></a> updated<%				
			} else if (log instanceof SGeoTagUpdated) {
				SGeoTagUpdated sGeoTagUpdated =  (SGeoTagUpdated)log;
			    SGeoTag sGeoTag = loginManager.getService().getGeoTag(sGeoTagUpdated.getGeoTagId());
			    SProject sProject = loginManager.getService().getProjectByPoid(sGeoTag.getProjects().get(0));
%>GeoTag of project <a href="project.jsp?poid=<%=sProject.getOid()%>"><%=sProject.getName() %></a> updated<%				
			} else if (log instanceof SUserChanged) {
				SUserChanged sUserChanged = (SUserChanged)log;
				SUser sUser = loginManager.getService().getUserByUoid(sUserChanged.getUserId());
%>User <a href="user.jsp?uoid=<%=sUser.getOid()%>"><%=sUser.getName() %></a> changed<%
			} else if (log instanceof SPasswordReset) {
				SPasswordReset sPasswordReset = (SPasswordReset)log;
				SUser sUser = loginManager.getService().getUserByUoid(sPasswordReset.getUserId());
%>Password of user <a href="user.jsp?uoid=<%=sUser.getOid()%>"><%=sUser.getName() %></a> resetted<%
			} else if (log instanceof SPasswordChanged) {
				SPasswordChanged sPasswordChanged = (SPasswordChanged)log;
				SUser sUser = loginManager.getService().getUserByUoid(sPasswordChanged.getUserId());
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
	</div>
</div>
<% } else {
	out.println("Insufficient rights");
}%>
</div>
<%@ include file="footer.jsp" %>