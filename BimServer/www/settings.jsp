<%@ include file="header.jsp"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="org.bimserver.utils.Formatters"%>
<%@page import="org.bimserver.shared.DatabaseInformation"%>
<%@page import="org.bimserver.VersionChecker"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="org.bimserver.ServerInitializer"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.bimserver.ServerSettings"%>
<%@page import="org.bimserver.shared.ResultType"%>
<%@page import="org.bimserver.Settings"%>
<%@page import="org.apache.commons.io.IOUtils"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%
	if (loginManager.getService().isLoggedIn() && loginManager.getUserType() == SUserType.ADMIN) {
		Settings settings = ServerSettings.getSettings();
		if (request.getParameter("save") != null) {
	settings.setAllowSelfRegistration(request.getParameter("allowSelfRegistration") != null);
	settings.setDatabaseLocation(request.getParameter("databaselocation"));
	settings.setEmailSenderAddress(request.getParameter("emailsenderaddress"));
	settings.setRegistrationAddition(request.getParameter("registrationAddition"));
	settings.setSendConfirmationEmailAfterRegistration(request.getParameter("sendConfirmationEmailAfterRegistration") != null);
	settings.setShowVersionUpgradeAvailable(request.getParameter("showVersionUpgradeAvailable") != null);
	settings.setAllowUsersToCreateTopLevelProjects(request.getParameter("allowUsersToCreateTopLevelProjects") != null);
	settings.setSmtpServer(request.getParameter("smtpServer"));
	settings.setUseCaching(request.getParameter("usecaching") != null);
	settings.setIntelligentMerging(request.getParameter("intelligentMerging") != null);
	settings.setAutoTestClashes(request.getParameter("autoTestClashes") != null);
	settings.setCustomLogoAddress(request.getParameter("customLogo"));
	settings.setSiteAddress(request.getParameter("siteAddress"));
	String enabledExportTypes = "";
	Set<ResultType> enabledTypes = new HashSet<ResultType>();
	for (ResultType resultType : ResultType.values()) {
		if (request.getParameter(resultType.name()) != null) {
			enabledTypes.add(resultType);
		}
	}
	settings.updateEnabledResultTypes(enabledTypes);
	settings.save();
	ServerSettings.setSettings(settings);
	EmfSerializerFactory.getInstance().initSerializers();
	response.sendRedirect(getServletContext().getContextPath() + "/settings.jsp?msg=settingschangeok");
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		if (request.getParameter("msg") != null) {
	if (request.getParameter("msg").equals("ignorefileuploadok")) {
		out.println("<div class=\"info\">New ignore file uploaded successfully, a restart of the BIMserver is required</div>");
	} else if (request.getParameter("msg").equals("settingsfileuploadok")) {
		out.println("<div class=\"info\">New settings uploaded successfully, a restart might be necessary</div>");
	} else if (request.getParameter("msg").equals("settingschangeok")) {
		out.println("<div class=\"info\">Settings successfully updated, a restart might be necessary</div>");
	} else if (request.getParameter("msg").equals("colladasettingsuploadok")) {
		out.println("<div class=\"info\">New collada settings successfully updated, a restart is necessary</div>");
	}
		}
%>


<%@page import="org.bimserver.serializers.EmfSerializerFactory"%><div class="sidebar">
<ul>
<li>
<a href="<%=getServletContext().getContextPath()%>/settings?action=downloadsettings">Download settings</a></li>
<li>
<a href="<%=getServletContext().getContextPath()%>/settings?action=downloadignorefile">Download ignore.xml</a></li>
</ul>
</div>

<div class="content">

<div class="tabber" id="settingstabber">
<div class="tabbertab" id="basicsettingstab" title="Basic settings">
<form method="post">
<table class="formatted infotable">
	<tr>
		<td colspan="2" class="tabletitle">Server</td>
	</tr>
	<tr>
		<td><label for="siteAddress">Site address (URL)</label></td>
		<td><input id="siteAddress" type="text" name="siteAddress" value="<%=settings.getSiteAddress() %>"></input></td>
	</tr>
	<tr>
		<td><label for="customLogo">Custom logo address</label></td>
		<td><input id="customLogo" name="customLogo" type="text" size="80"
			value="<%=settings.getCustomLogoAddress()%>"></input></td>
	</tr>
	<tr>
		<td colspan="2" class="tabletitle">Registration</td>
	</tr>
	<tr>
		<td><label for="registrationAddition">Extra information when registering</label></td>
		<td><textarea id="registrationAddition" name="registrationAddition" cols="60" rows="4"><%=settings.getRegistrationAddition()%></textarea></td>
	</tr>
	<tr>
		<td><label for="sendConfirmationEmailAfterRegistration">Send confirmation e-mail after registering</label></td>
		<td><input id="sendConfirmationEmailAfterRegistration" name="sendConfirmationEmailAfterRegistration"
			type="checkbox"
			<%=settings.isSendConfirmationEmailAfterRegistration() ? " checked=\"checked\"" : ""%>></input></td>
	</tr>
	<tr>
		<td><label for="allowSelfRegistration">Allow self registration</label></td>
		<td><input id="allowSelfRegistration" type="checkbox" name="allowSelfRegistration"
			<%=settings.isAllowSelfRegistration() ? " checked=\"checked\"" : ""%>></input></td>
	</tr>
	<tr>
		<td colspan="2" class="tabletitle">E-mail</td>
	</tr>
	<tr>
		<td><label for="emailsenderaddress">Address of e-mail sender</label></td>
		<td><input id="emailsenderaddress" type="text" name="emailsenderaddress"
			value="<%=settings.getEmailSenderAddress()%>"></input></td>
	</tr>
	<tr>
		<td><label for="smtpServer">SMTP server (for outgoing e-mail)</label></td>
		<td><input id="smtpServer" name="smtpServer" type="text"
			value="<%=settings.getSmtpServer()%>"></input></td>
	</tr>
	<tr>
		<td colspan="2" class="tabletitle">Database</td>
	</tr>
	<tr>
		<td><label for="databaselocation">Database location</label></td>
		<td><input id="databaselocation" type="text" name="databaselocation"
			value="<%=settings.getDatabaseLocation()%>"></input></td>
	</tr>
	<tr>
		<td colspan="2" class="tabletitle">Other</td>
	</tr>
	<tr>
		<td><label for="autoTestClashes">Automatic clash detection on main projects</label></td>
		<td><input id="autoTestClashes" name="autoTestClashes" type="checkbox"
			<%=settings.isAutoTestClashes() ? " checked=\"checked\"" : ""%>></input></td>
	</tr>
	<tr>
		<td><label for="allowUsersToCreateTopLevelProjects">Allow non-admin users to create projects</label></td>
		<td><input id="allowUsersToCreateTopLevelProjects" name="allowUsersToCreateTopLevelProjects" type="checkbox"
			<%=settings.isAllowUsersToCreateTopLevelProjects() ? " checked=\"checked\"" : ""%>></input></td>
	</tr>
	<tr>
		<td><label for="showVersionUpgradeAvailable">Show whether a new version is available</label></td>
		<td><input id="showVersionUpgradeAvailable" name="showVersionUpgradeAvailable" type="checkbox"
			<%=settings.isShowVersionUpgradeAvailable() ? " checked=\"checked\"" : ""%>></input></td>
	</tr>
	<tr>
		<td><label for="intelligentMerging">Intelligent merging</label></td>
		<td><input id="intelligentMerging" name="intelligentMerging" type="checkbox"
			<%=settings.isIntelligentMerging() ? " checked=\"checked\"" : ""%>></input></td>
	</tr>
	<!-- 
<tr><td>Use file-level caching</td><td><input name="usecaching" type="checkbox" <%=settings.isUseCaching() ? " checked=\"checked\"" : ""%>></input></td></tr>
 -->
	<tr>
		<td>Enabled export types</td>
		<td>
		<table class="cleantable">
			<%
				for (ResultType resultType : loginManager.getService().getAllResultTypes()) {
			%>
			<tr>
				<td><label for="<%=resultType.name()%>"><%=resultType.getNiceName()%></label></td>
				<td><input name="<%=resultType.name()%>"
					id="<%=resultType.name()%>" type="checkbox"
					<%=loginManager.getService().isExportTypeEnabled(resultType) ? " checked=\"checked\"" : ""%>></input></td>
			</tr>
			<%
				}
			%>
		</table>
		</td>
	</tr>
</table>
<input name="save" type="submit" value="Save"/>
</form>

</div>
<div class="tabbertab" id="importexport" title="Import/Export">
<form enctype="multipart/form-data" method="post"
	action="<%=getServletContext().getContextPath()%>/settings">
<table class="formatted infotable">
	<tr>
		<td>Download</td>
		<td><a
			href="<%=getServletContext().getContextPath()%>/settings?action=downloadsettings">Download
		settings.xml</a></td>
	</tr>
	<tr>
		<td>Upload</td>
		<td><input type="file" name="settings"></input><input
			type="submit" value="Upload"></input></td>
	</tr>
</table>
<input type="hidden" name="action" value="uploadsettings" /></form>
</div>
<div class="tabbertab" id="ignorefiletab" title="Ignore file">
<form enctype="multipart/form-data" method="post"
	action="<%=getServletContext().getContextPath()%>/settings">
<table class="formatted infotable">
	<tr>
		<td>Download</td>
		<td><a
			href="<%=getServletContext().getContextPath()%>/settings?action=downloadignorefile">Download
		ignore.xml</a></td>
	</tr>
	<tr>
		<td>Upload</td>
		<td><input type="file" name="ignorefile"></input><input
			type="submit" value="Upload"></input></td>
	</tr>
</table>
<input type="hidden" name="action" value="uploadsettings" /></form>
</div>
<div class="tabbertab" id="importexport" title="Collada/KMZ">
<form enctype="multipart/form-data" method="post" action="<%=getServletContext().getContextPath()%>/settings">
<table class="formatted infotable">
	<tr>
		<td>Download</td>
		<td><a
			href="<%=getServletContext().getContextPath()%>/settings?action=downloadcolladasettings">Download
		collada.xml</a></td>
	</tr>
	<tr>
		<td>Upload</td>
		<td><input type="file" name="colladasettings"></input><input
			type="submit" value="Upload"></input></td>
	</tr>
</table>
<input type="hidden" name="action" value="uploadcolladasettings" /></form>
</div>
</div>
<%
	} else {
		out.println("Insufficient rights");
	}
%>
</div>
<%@ include file="footer.jsp"%>