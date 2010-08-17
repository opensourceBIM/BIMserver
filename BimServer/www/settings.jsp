<%@ include file="header.jsp"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="org.bimserver.utils.Formatters"%>
<%@page import="org.bimserver.shared.DatabaseInformation"%>
<%@page import="org.bimserver.VersionChecker"%>
<%@page import="java.util.Map"%>
<%@page import="org.bimserver.ServerInitializer"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.bimserver.ServerSettings"%>
<%@page import="org.bimserver.shared.ResultType"%>
<%@page import="org.bimserver.Settings"%>
<%@page import="org.bimserver.EmfSerializerFactory"%>
<%@page import="org.apache.commons.io.IOUtils"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%
	if (loginManager.isLoggedIn() && loginManager.getUserType() == SUserType.ADMIN) {
		Settings settings = ServerSettings.getSettings();
		EmfSerializerFactory emfSerializerFactory = EmfSerializerFactory.getInstance();
		if (request.getParameter("save") != null) {
			settings.setAllowSelfRegistration(request.getParameter("allowSelfRegistration") != null);
			settings.setDatabaseLocation(request.getParameter("databaselocation"));
			settings.setEmailSenderAddress(request.getParameter("emailsenderaddress"));
			settings.setRegistrationAddition(request.getParameter("registrationAddition"));
			settings.setSendConfirmationEmailAfterRegistration(request.getParameter("sendConfirmationEmailAfterRegistration") != null);
			settings.setShowVersionUpgradeAvailable(request.getParameter("showVersionUpgradeAvailable") != null);
			settings.setSmtpServer(request.getParameter("smtpServer"));
			settings.setUseCaching(request.getParameter("usecaching") != null);
			settings.setIntelligentMerging(request.getParameter("intelligentMerging") != null);
			settings.setUseSecondEngineJvm(request.getParameter("usesecondenginejvm") != null);
			settings.setAutoTestClashes(request.getParameter("autoTestClashes") != null);
			settings.setCustomLogoAddress(request.getParameter("customLogo"));
			String enabledExportTypes = "";
			for (ResultType resultType : ResultType.values()) {
				if (request.getParameter(resultType.name()) != null) {
					enabledExportTypes += resultType.name() + ",";
				}
			}
			if (enabledExportTypes.endsWith(",")) {
				enabledExportTypes = enabledExportTypes.substring(0, enabledExportTypes.length() - 1);
			}
			settings.setEnabledExportTypes(enabledExportTypes);
			settings.save();
			emfSerializerFactory.initSerializers();
			response.sendRedirect(getServletContext().getContextPath() + "/settings.jsp?msg=settingschangeok");
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		if (request.getParameter("msg") != null) {
			if (request.getParameter("msg").equals("ignorefileuploadok")) {
				out.println("<div class=\"info\">New ignore file uploaded succesfully, a restart of the BIMserver is required</div>");
			} else if (request.getParameter("msg").equals("settingsfileuploadok")) {
				out.println("<div class=\"info\">New settings uploaded succesfully, a restart might be necessary</div>");
			} else if (request.getParameter("msg").equals("settingschangeok")) {
				out.println("<div class=\"info\">Settings succesfully updated, a restart might be necessary</div>");
			}
		}
%>

<div class="sidebar">
<h4>Submenu</h4>
<a
	href="<%=getServletContext().getContextPath()%>/settings?action=downloadsettings">Download
settings</a> <a
	href="<%=getServletContext().getContextPath()%>/settings?action=downloadignorefile">Download
ignore.xml</a></div>

<div class="content">

<div class="tabber" id="settingstabber">
<div class="tabbertab" id="basicsettingstab" title="Basic settings">
<form method="post">
<table class="formatted infotable">
	<tr>
		<td colspan="2" class="tabletitle">Registration</td>
	</tr>
	<tr>
		<td>Extra information when registering</td>
		<td><textarea name="registrationAddition" cols="60" rows="4"><%=settings.getRegistrationAddition()%></textarea></td>
	</tr>
	<tr>
		<td>Send confirmation e-mail after registering</td>
		<td><input name="sendConfirmationEmailAfterRegistration"
			type="checkbox"
			<%=settings.isSendConfirmationEmailAfterRegistration() ? " checked=\"checked\"" : ""%>></input></td>
	</tr>
	<tr>
		<td>Allow self registration</td>
		<td><input type="checkbox" name="allowSelfRegistration"
			<%=settings.isAllowSelfRegistration() ? " checked=\"checked\"" : ""%>></input></td>
	</tr>
	<tr>
		<td colspan="2" class="tabletitle">E-mail</td>
	</tr>
	<tr>
		<td>Address of e-mail sender</td>
		<td><input type="text" name="emailsenderaddress"
			value="<%=settings.getEmailSenderAddress()%>"></input></td>
	</tr>
	<tr>
		<td>SMTP server (for outgoing e-mail)</td>
		<td><input name="smtpServer" type="text"
			value="<%=settings.getSmtpServer()%>"></input></td>
	</tr>
	<tr>
		<td colspan="2" class="tabletitle">Database</td>
	</tr>
	<tr>
		<td>Database location</td>
		<td><input type="text" name="databaselocation"
			value="<%=settings.getDatabaseLocation()%>"></input></td>
	</tr>
	<tr>
		<td colspan="2" class="tabletitle">Other</td>
	</tr>
	<tr>
		<td>Automatic clash detection on main projects</td>
		<td><input name="autoTestClashes" type="checkbox"
			<%=settings.isAutoTestClashes() ? " checked=\"checked\"" : ""%>></input></td>
	</tr>
	<tr>
		<td>Show whether a new version is available</td>
		<td><input name="showVersionUpgradeAvailable" type="checkbox"
			<%=settings.isShowVersionUpgradeAvailable() ? " checked=\"checked\"" : ""%>></input></td>
	</tr>
	<tr>
		<td>Use second JVM for IFCEngine</td>
		<td><input name="usesecondenginejvm" type="checkbox"
			<%=settings.isUseSecondEngineJvm() ? " checked=\"checked\"" : ""%>></input></td>
	</tr>
	<tr>
		<td>Intelligent merging</td>
		<td><input name="intelligentMerging" type="checkbox"
			<%=settings.isIntelligentMerging() ? " checked=\"checked\"" : ""%>></input></td>
	</tr>
	<tr>
		<td>Custom logo address</td>
		<td><input name="customLogo" type="text" size="80"
			value="<%=settings.getCustomLogoAddress()%>"></input></td>
	</tr>
	<!-- 
<tr><td>Use file-level caching</td><td><input name="usecaching" type="checkbox" <%=settings.isUseCaching() ? " checked=\"checked\"" : ""%>></input></td></tr>
 -->
	<tr>
		<td>Enabled export types</td>
		<td>
		<table class="cleantable">
			<%
				for (ResultType resultType : ResultType.values()) {
						if (resultType.isUserType()) {
			%>
			<tr>
				<td><label for="<%=resultType.name()%>"><%=resultType.getNiceName()%></label></td>
				<td><input name="<%=resultType.name()%>"
					id="<%=resultType.name()%>" type="checkbox"
					<%=emfSerializerFactory.getSingleResultTypes().contains(resultType) ? " checked=\"checked\"" : ""%>></input></td>
			</tr>
			<%
				}
					}
			%>
		</table>
		</td>
	</tr>
	<tr>
		<td></td>
		<td><input name="save" type="submit" value="Save"></input></td>
	</tr>
</table>
</form>
<h1>Import/Export settings</h1>
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
</div>
<%
	} else {
		out.println("Insufficient rights");
	}
%>
</div>
<%@ include file="footer.jsp"%>