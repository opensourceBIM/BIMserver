<%@ include file="header.jsp"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="org.bimserver.utils.Formatters"%>
<%@page import="org.bimserver.shared.DatabaseInformation"%>
<%@page import="org.bimserver.version.VersionChecker"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="org.bimserver.ServerInitializer"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.bimserver.shared.ResultType"%>
<%@page import="org.apache.commons.io.IOUtils"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%@page import="org.bimserver.serializers.EmfSerializerFactory"%>
<%@page import="org.bimserver.shared.ServiceInterface"%>
<div class="sidebar">
<ul>
	<li><a href="<%=getServletContext().getContextPath()%>/settings?action=downloadsettings">Download settings</a></li>
	<li><a href="<%=getServletContext().getContextPath()%>/settings?action=downloadignorefile">Download ignore.xml</a></li>
</ul>
</div>
<div class="content">
<%
	ServiceInterface service = loginManager.getService();
	if (loginManager.getService().isLoggedIn() && loginManager.getUserType() == SUserType.ADMIN) {
		if (request.getParameter("save") != null) {
			service.setSettingAllowSelfRegistration(request.getParameter("allowSelfRegistration") != null);
			service.setSettingEmailSenderAddress(request.getParameter("emailsenderaddress"));
			service.setSettingRegistrationAddition(request.getParameter("registrationAddition"));
			service.setSettingSendConfirmationEmailAfterRegistration(request.getParameter("sendConfirmationEmailAfterRegistration") != null);
			service.setSettingShowVersionUpgradeAvailable(request.getParameter("showVersionUpgradeAvailable") != null);
			service.setSettingAllowUsersToCreateTopLevelProjects(request.getParameter("allowUsersToCreateTopLevelProjects") != null);
			service.setSettingSmtpServer(request.getParameter("smtpServer"));
			service.setSettingUseCaching(request.getParameter("usecaching") != null);
			service.setSettingIntelligentMerging(request.getParameter("intelligentMerging") != null);
			service.setSettingAutoTestClashes(request.getParameter("autoTestClashes") != null);
			service.setSettingCustomLogoAddress(request.getParameter("customLogo"));
			service.setSettingSiteAddress(request.getParameter("siteAddress"));
			service.setSettingCheckinMergingEnabled(request.getParameter("checkinMergingEnabled") != null);
			String enabledExportTypes = "";
			Set<ResultType> enabledTypes = new HashSet<ResultType>();
			for (ResultType resultType : ResultType.values()) {
				if (request.getParameter(resultType.name()) != null) {
					enabledTypes.add(resultType);
				}
			}
			service.setSettingEnabledExportTypes(enabledTypes);
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
			} else if (request.getParameter("msg").equals("xsltuploadok")) {
				out.println("<div class=\"info\">New XSLT script successfully updated, a restart is necessary???</div>");
			}
		}
%>
<div class="tabber" id="settingstabber">
<div class="tabbertab" id="basicsettingstab" title="Basic settings">
<form method="post">
<table class="formatted infotable">
	<tr>
		<td colspan="2" class="tabletitle">Server</td>
	</tr>
	<tr>
		<td><label for="siteAddress">Site address (URL)</label></td>
		<td><input id="siteAddress" type="text" name="siteAddress"
			value="<%=request.getParameter("siteAddress") == null ? service.getSettingSiteAddress() : request.getParameter("siteAddress")%>"></input></td>
	</tr>
	<tr>
		<td><label for="customLogo">Custom logo address</label></td>
		<td><input id="customLogo" name="customLogo" type="text"
			size="80" value="<%=request.getParameter("customLogo") == null ? service.getSettingCustomLogoAddress() : request.getParameter("customLogo")%>"></input></td>
	</tr>
	<tr>
		<td colspan="2" class="tabletitle">Registration</td>
	</tr>
	<tr>
		<td><label for="registrationAddition">Extra information when registering</label></td>
		<td><textarea id="registrationAddition"
			name="registrationAddition" cols="60" rows="4"><%=request.getParameter("save") != null ? service.getSettingRegistrationAddition() : request.getParameter("registrationAddition")%></textarea></td>
	</tr>
	<tr>
		<td><label for="sendConfirmationEmailAfterRegistration">Send confirmation e-mail after registering</label></td>
		<td><input id="sendConfirmationEmailAfterRegistration"
			name="sendConfirmationEmailAfterRegistration" type="checkbox"
			<%=(request.getParameter("save") == null ? service.isSettingSendConfirmationEmailAfterRegistration() : request.getParameter("sendConfirmationEmailAfterRegistration") != null) ? " checked=\"checked\"" : ""%>></input></td>
	</tr>
	<tr>
		<td><label for="allowSelfRegistration">Allow self registration</label></td>
		<td><input id="allowSelfRegistration" type="checkbox"
			name="allowSelfRegistration"
			<%=(request.getParameter("save") == null ? service.isSettingAllowSelfRegistration() : request.getParameter("allowSelfRegistration") != null) ? " checked=\"checked\"" : ""%>></input></td>
	</tr>
	<tr>
		<td colspan="2" class="tabletitle">E-mail</td>
	</tr>
	<tr>
		<td><label for="emailsenderaddress">Address of e-mail sender</label></td>
		<td><input id="emailsenderaddress" type="text"
			name="emailsenderaddress"
			value="<%=request.getParameter("save") == null ? service.getSettingEmailSenderAddress() : request.getParameter("emailsenderaddress")%>"></input></td>
	</tr>
	<tr>
		<td><label for="smtpServer">SMTP server (for outgoing e-mail)</label></td>
		<td><input id="smtpServer" name="smtpServer" type="text"
			value="<%=request.getParameter("save") == null ? service.getSettingSmtpServer() : request.getParameter("smtpServer")%>"></input></td>
	</tr>
	<tr>
		<td colspan="2" class="tabletitle">Other</td>
	</tr>
	<tr>
		<td><label for="autoTestClashes">Automatic clash detection on main projects</label></td>
		<td><input id="autoTestClashes" name="autoTestClashes"
			type="checkbox"
			<%=(request.getParameter("save") == null ? service.isSettingAutoTestClashes() : request.getParameter("autoTestClashes") != null) ? " checked=\"checked\"" : ""%>></input></td>
	</tr>
	<tr>
		<td><label for="allowUsersToCreateTopLevelProjects">Allow non-admin users to create projects</label></td>
		<td><input id="allowUsersToCreateTopLevelProjects"
			name="allowUsersToCreateTopLevelProjects" type="checkbox"
			<%=(request.getParameter("save") == null ? service.isSettingAllowUsersToCreateTopLevelProjects() : request.getParameter("allowUsersToCreateTopLevelProjects") != null) ? " checked=\"checked\"" : ""%>></input></td>
	</tr>
	<tr>
		<td><label for="showVersionUpgradeAvailable">Show whether a new version is available</label></td>
		<td><input id="showVersionUpgradeAvailable"
			name="showVersionUpgradeAvailable" type="checkbox"
			<%=(request.getParameter("save") == null ? service.isSettingShowVersionUpgradeAvailable() : request.getParameter("showVersionUpgradeAvailable") != null) ? " checked=\"checked\"" : ""%>></input></td>
	</tr>
	<tr>
		<td><label for="intelligentMerging">Intelligent merging</label></td>
		<td><input id="intelligentMerging" name="intelligentMerging" type="checkbox"
			<%=(request.getParameter("save") == null ? service.isSettingIntelligentMerging() : request.getParameter("intelligentMerging") != null) ? " checked=\"checked\"" : ""%>></input></td>
	</tr>
	<tr>
		<td><label for="checkinMergingEnabled">Checkin merging <span
			style="color: red">(BETA)</span></label></td>
		<td><input id="checkinMergingEnabled"
			name="checkinMergingEnabled" type="checkbox"
			<%=(request.getParameter("save") == null ? service.isSettingCheckinMergingEnabled() : request.getParameter("checkinMergingEnabled") != null) ? " checked=\"checked\"" : ""%>></input>
		<span style="color: red">IFC models are modified on checkin!</span></td>
	</tr>
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
<input name="save" type="submit" value="Save" /></form>

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
<div class="tabbertab" id="colladatab" title="Collada/KMZ">
<form enctype="multipart/form-data" method="post"
	action="<%=getServletContext().getContextPath()%>/settings">
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
<div class="tabbertab" id="xsltuploadtab" title="XSLT script">
<form enctype="multipart/form-data" method="post"
	action="<%=getServletContext().getContextPath()%>/settings">
<table class="formatted infotable">
	<tr>
		<td>Upload</td>
		<td><label for="xsltName">XSLT script name</label></td>
		<td><input id="xsltName" type="text" name="xsltName" ></input></td>
		<td><input type="file" name="xslt"></input><input type="submit"
			value="Upload"></input></td>
	</tr>
</table>
<input type="hidden" name="action" value="uploadxslt" /></form>
</div>
</div>
<%
	} else {
		out.println("Insufficient rights");
	}
%>
</div>
<%@ include file="footer.jsp"%>