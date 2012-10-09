<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="org.bimserver.interfaces.objects.SDatabaseInformationItem"%>
<%@page import="org.bimserver.interfaces.objects.SDatabaseInformationCategory"%>
<%@page import="org.bimserver.interfaces.objects.SDatabaseInformation"%>
<%@ include file="header.jsp" %>
<%@page import="java.util.List" %>
<%@page import="java.util.Collections"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="org.bimserver.utils.Formatters"%>
<%@page import="java.util.Map"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.io.File"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%@page import="org.bimserver.interfaces.objects.SLogAction"%>
<%@page import="org.bimserver.interfaces.objects.SUser"%>
<%@page import="org.bimserver.interfaces.objects.SUserAddedToProject"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<%@page import="org.bimserver.interfaces.objects.SNewProjectAdded"%>
<%@page import="org.bimserver.shared.comparators.SLogActionDateComparator"%>
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
<%@page import="org.bimserver.interfaces.objects.SUserSession"%>
<%@page import="org.bimwebserver.jsp.JspHelper"%>
<%@page import="org.bimserver.interfaces.objects.SGeoTagUpdated"%>
<%@page import="org.bimserver.interfaces.objects.SUserChanged"%>
<%@page import="org.bimserver.interfaces.objects.SPasswordReset"%>
<%@page import="org.bimserver.interfaces.objects.SPasswordChanged"%>
<%@page import="org.bimserver.interfaces.objects.SGeoTag"%>
<%@page import="org.bimserver.interfaces.objects.SDatabaseCreated"%>
<%@page import="org.bimserver.interfaces.objects.SLongAction"%>
<%@page import="java.util.Date"%><div class="sidebar">
</div>
<div class="content">
<h1>Info</h1>
<%
	if (loginManager.isLoggedIn() && loginManager.getUserType() == SUserType.ADMIN) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		SDatabaseInformation databaseInformation = loginManager.getService(request).getDatabaseInformation();
		SVersion version = loginManager.getService(request).getVersion();
		SVersion latestVersion = loginManager.getService(request).getLatestVersion();
		if (loginManager.getService(request).isSettingShowVersionUpgradeAvailable() && loginManager.getService(request).upgradePossible()) {
%>
<div class="error">
A newer version of the BIMserver is available online.<br/>
<a href="<%= latestVersion.getSupportUrl() %>">Support</a> | <a href="<%= latestVersion.getDownloadUrl() %>">Download</a><br/>
E-mail <a href="mailto:<%= latestVersion.getSupportEmail() %>"><%= latestVersion.getSupportEmail() %></a> for more info<br/>
</div>
<%
	}
%>

	<p>If you plan to post an issue on <a href="http://support.bimserver.org" target="_blank">http://support.bimserver.org</a>, please make sure 
	you accompany it with the <a href="<%=getServletContext().getContextPath()%>/download?action=getfile&file=serverlog">server logfile</a>, a solid 
	description of your situation (including BIMserver version number) and maybe even a screenshot. Only than we can help you the best possible way.</p>
<div class="tabber" id="infotabber">
	<%@ include file="extraInfo.jsp" %>
	<div class="tabbertab" id="license" title="License">
	  (c) Copyright bimserver.org<br/>
	  Licensed under GNU Affero General Public License<br/>
	  <a href="http://www.gnu.org/licenses/agpl.html" target="_blank">http://www.gnu.org/licenses/agpl.html</a><br/>
	  For more information mail to <a href="mailto:license@bimserver.org">license@bimserver.org</a><br/>
      <br/>
      BIMserver software uses several external plugins.<br/>
      Some plugins are NOT part of the BIMserver project.<br/>
      Please note that some plugins may have different license models.<br/>
      BIMserver distributes the following external plugins in the builds:<br/>
      <br/>
      <strong>TNO IFC Engine series</strong><br/>
	  The TNO IFC Engine Series DLL is used as a geometry renderer for BIMserver serializers.<br/>
	  This plugin is NOT open source. It is used in BIMserver according to the TNO IFC Engine series license.<br/>
	  In case of none commercial use there is no license fee and redistribution is free as long as clearly mentioned that the IFC Engine DLL is used. <br/>
      This BIMserver software is non-commercial so users of the BIMserver software can use it free of charge.<br/>
	  The latest versions are available for download from <a href=" http://ifcengine.com" target="_blank">ifcengine.com</a>.<br/>
	  Many thanks and credits go to <a href="http://tno.nl/" target="_blank">TNO</a> for distributing this plugin with BIMserver.org.<br/>
	  <br/>
	  <strong>IfcOpenShell</strong><br/>
	  The IfcOpenShell library is used as a geometry renderer for BIMserver serializers.<br/>
	  This plugin is distributed under the GNU LGPL license.
	  The latest versions are available for download from <a href="http://ifcopenshell.org" target="_blank">ifcopenshell.org</a>. <br/>
	  Many thanks and credits go to <a href="http://thomaskrijnen.nl/" target="_blank">Thomas Krijnen</a> for developing this plugin.<br/>
	  <br/>
	  <strong>COBie serializer and deserializer</strong><br/>
	  The COBie serializer and deserializer plugins are used to import and export COBie files.<br/>
	  This plugin is distributed under the GNU Affero GPL license.
	  The latest versions are available for download from <a href="https://github.com/bimserver/COBie-plugins" target="_blank">the github repository</a>. <br/>
	  Many thanks and credits go to <a href="http://www.linkedin.com/pub/chris-bogen/3/b94/4bb" target="_blank">Chris Bogen</a> for developing these plugins.<br/>
      <br/>
      <strong>Other plugins and extensions:</strong><br/>
	  More plugins and extensions can be found on <a href="http://extend.bimserver.org" target="_blank">http://extend.bimserver.org</a>.<br/>
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
			<tr><td class="firstcolumn">Local Version</td><td><%=version.getMajor() + "." + version.getMinor() + "." + version.getRevision() %></td></tr>
			<tr><td class="firstcolumn">Build date/time</td><td><%=dateFormat.format(version.getDate()) %></td></tr>
			<tr><td class="firstcolumn">Schema Version</td><td><%=loginManager.getService(request).getDatabaseInformation().getSchemaVersion() %></td></tr>
			<tr><td colspan="2" class="tabletitle">Latest available version</td></tr>
			<tr><td class="firstcolumn">Latest Version</td><td><%=latestVersion.getMajor() + "." + latestVersion.getMinor() + "." + latestVersion.getRevision() %></td></tr>
			<tr><td class="firstcolumn">Build date/time</td><td><%=dateFormat.format(latestVersion.getDate()) %></td></tr>
			<tr><td colspan="2" class="tabletitle">Counts</td></tr>
			<tr><td class="firstcolumn">Projects</td><td><%=databaseInformation.getNumberOfProjects() %></td></tr>
			<tr><td class="firstcolumn">Users</td><td><%=databaseInformation.getNumberOfUsers() %></td></tr>
			<tr><td class="firstcolumn">Revisions</td><td><%=databaseInformation.getNumberOfRevisions() %></td></tr>
			<tr><td class="firstcolumn">Checkouts</td><td><%=databaseInformation.getNumberOfCheckouts() %></td></tr>
			<tr><td colspan="2" class="tabletitle">Other</td></tr>
			<tr><td>BIMserver managers registration</td><td> Please take a moment to register yourself as a BIMserver manager.<br/>
			<a href="https://docs.google.com/spreadsheet/embeddedform?formkey=dG5DYUNyVnA0Mk5DWnN0eHFueDlMR2c6MQ" target="_blank">
			Click here to register</a>.</td></tr>
			<tr><td>Server log</td><td><a href="<%=getServletContext().getContextPath()%>/download?action=getfile&file=serverlog">Download server Logfile</a></td></tr>
			<tr><td class="firstcolumn">Server started at</td><td><%=dateFormat.format(loginManager.getService(request).getServerStartTime()) %></td></tr>
			<%
				GregorianCalendar gc = new GregorianCalendar();
				gc.setTime(loginManager.getService(request).getServerStartTime());
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
				List<SDatabaseInformationCategory> categories = databaseInformation.getCategories();
				for (SDatabaseInformationCategory category : categories) {
					out.println("<tr><td colspan=\"2\" class=\"tabletitle\">" + category.getTitle() + "</td></tr>");
					for (SDatabaseInformationItem item : category.getItems()) {
						out.println("<tr><td class=\"firstcolumn\">" + item.getKey() + "</td><td>" + item.getValue() + "</td></tr>");
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
			<tr><td class="firstcolumn">Protocol Buffers Desriptor File</td><td><a href="/download?action=getfile&file=service.proto">Proto</a></td></tr>
			<tr><td class="firstcolumn">JSON Documentation</td><td><a href="/jsonapi?doc">JSON Doc</a></td></tr>
		</table>
	</div>
	<div class="tabbertab" id="activesessions" title="Active sessions">
		<table class="formatted infotable">
			<tr>
				<th>Username</th>
				<th>Name</th>
				<th>Type</th>
				<th>Access method</th>
				<th>Remote address</th>
				<th>Active since</th>
				<th>Last active</th>
			</tr>
<%
	List<SUserSession> userSessions = loginManager.getService(request).getActiveUserSessions();
	for (SUserSession userSession : userSessions) {
%>
	<tr>
		<td><a href="user.jsp?uoid=<%=userSession.getUserId()%>"><%=userSession.getUsername() %></a></td>
		<td><%=userSession.getName() %></td>
		<td><%=JspHelper.getNiceUserTypeName(userSession.getType()) %></td>
		<td><%=JspHelper.getNiceAccessMethodName(userSession.getAccessMethod()) %></td>
		<td><%=userSession.getRemoteAddress() %></td>
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
	List<SLongAction> longActions = loginManager.getService(request).getActiveLongActions();
	for (SLongAction longAction : longActions) {
		long millis = System.currentTimeMillis() - longAction.getStart().getTime();		
%>
	<tr>
		<td><a href="user.jsp?uoid=<%=longAction.getUserId()%>"><%=longAction.getUsername() %></a></td>
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
<% } else {
	out.println("Insufficient rights");
}%>
</div>
<%@ include file="footer.jsp" %>