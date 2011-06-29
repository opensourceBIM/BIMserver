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
<%@page import="org.bimserver.web.WarServerInitializer"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.apache.commons.io.IOUtils"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%@page import="org.bimserver.shared.ServiceInterface"%>
<%@page import="org.bimserver.shared.UserException"%>
<%@page import="org.bimserver.interfaces.objects.SMergeIdentifier"%>
<%@page import="org.bimserver.interfaces.objects.SSerializer"%>
<jsp:include page="serversettingsmenu.jsp"/>
<div class="content">
<%
	ServiceInterface service = loginManager.getService();
	if (loginManager.getService().isLoggedIn() && loginManager.getUserType() == SUserType.ADMIN) {
		if (request.getParameter("save") != null) {
			try {
				service.setSettingAllowSelfRegistration(request.getParameter("allowSelfRegistration") != null);
				service.setSettingEmailSenderAddress(request.getParameter("emailsenderaddress"));
				service.setSettingRegistrationAddition(request.getParameter("registrationAddition"));
				service.setSettingSendConfirmationEmailAfterRegistration(request.getParameter("sendConfirmationEmailAfterRegistration") != null);
				service.setSettingShowVersionUpgradeAvailable(request.getParameter("showVersionUpgradeAvailable") != null);
				service.setSettingAllowUsersToCreateTopLevelProjects(request.getParameter("allowUsersToCreateTopLevelProjects") != null);
				service.setSettingSmtpServer(request.getParameter("smtpServer"));
				service.setSettingCacheOutputFiles(request.getParameter("cacheOutputFiles") != null);
				service.setSettingIntelligentMerging(request.getParameter("intelligentMerging") != null);
				service.setSettingAutoTestClashes(request.getParameter("autoTestClashes") != null);
				service.setSettingCustomLogoAddress(request.getParameter("customLogo"));
				service.setSettingSiteAddress(request.getParameter("siteAddress"));
				service.setSettingCheckinMergingEnabled(request.getParameter("checkinMergingEnabled") != null);
				service.setSettingHeaderAddition(request.getParameter("headerAddition"));
				service.setSettingFooterAddition(request.getParameter("footerAddition"));
				service.setSettingMergeIdentifier(SMergeIdentifier.valueOf(request.getParameter("mergeIdentifier")));
				String enabledExportTypes = "";
				Set<String> enabledTypes = new HashSet<String>();
				for (SSerializer serializer : loginManager.getService().getAllSerializers(true)) {
					if (request.getParameter(serializer.getName()) != null) {
						enabledTypes.add(serializer.getName());
					}
				}
				service.setSettingEnabledExportTypes(enabledTypes);
				response.sendRedirect(getServletContext().getContextPath() + "/serversettings.jsp?msg=settingschangeok");
			} catch (UserException e) {
				out.println("<div class=\"error\">" + e.getUserMessage() + "</div>");
			}
		}
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			if (request.getParameter("msg") != null) {
			if (request.getParameter("msg").equals("settingsfileuploadok")) {
				out.println("<div class=\"success\">New settings uploaded successfully</div>");
			} else if (request.getParameter("msg").equals("settingschangeok")) {
				out.println("<div class=\"success\">Server settings successfully updated</div>");
			}
		}
%>
<h1>Server Settings</h1>
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
		<td><label for="headerAddition">Header addition</label></td>
		<td><textarea cols="60" rows="5" id="headerAddition" name="headerAddition"><%=request.getParameter("headerAddition") == null ? service.getSettingHeaderAddition() : request.getParameter("headerAddition")%></textarea></td>
	</tr>
	<tr>
		<td><label for="footerAddition">Footer addition</label></td>
		<td><textarea cols="60" rows="5" id="footerAddition" name="footerAddition"><%=request.getParameter("footerAddition") == null ? service.getSettingFooterAddition() : request.getParameter("footerAddition")%></textarea></td>
	</tr>
	<tr>
		<td colspan="2" class="tabletitle">Registration</td>
	</tr>
	<tr>
		<td><label for="registrationAddition">Extra information when registering</label></td>
		<td><textarea id="registrationAddition"
			name="registrationAddition" cols="60" rows="4"><%=request.getParameter("save") == null ? service.getSettingRegistrationAddition() : request.getParameter("registrationAddition")%></textarea></td>
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
		<td><label for="cacheOutputFiles">Cache output files</label></td>
		<td><input id="cacheOutputFiles" name="cacheOutputFiles" type="checkbox"
			<%=(request.getParameter("save") == null ? service.isSettingCacheOutputFiles() : request.getParameter("cacheOutputFiles") != null) ? " checked=\"checked\"" : ""%>></input></td>
	</tr>
	<tr>
		<td><label for="mergeIdentifier">Intelligent merging identifier</label></td>
		<td><select name="mergeIdentifier">
<%
	for (SMergeIdentifier sMergeIdentifier : SMergeIdentifier.values()) {
%>
	<option value="<%=sMergeIdentifier.name()%>"<%=request.getParameter("mergeIdentifier") != null && request.getParameter("mergeIdentifier").equals(sMergeIdentifier.name()) ? " SELECTED=\"SELECTED\"" : (service.getSettingMergeIdentifier() == sMergeIdentifier ? " SELECTED=\"SELECTED\"" : "") %>><%=sMergeIdentifier.name() %></option>
<%
	}
%>
		</select></td>
	</tr>
	<tr>
		<td><label for="checkinMergingEnabled">Checkin merging <span
			style="color: red">(BETA)</span></label></td>
		<td><input id="checkinMergingEnabled"
			name="checkinMergingEnabled" type="checkbox"
			<%=(request.getParameter("save") == null ? service.isSettingCheckinMergingEnabled() : request.getParameter("checkinMergingEnabled") != null) ? " checked=\"checked\"" : ""%>></input>
		<span style="color: red">IFC models are modified on checkin!</span></td>
	</tr>
</table>
<input name="save" type="submit" value="Save" /></form>
</div>
<%
	} else {
		out.println("Insufficient rights");
	}
%>
<%@ include file="footer.jsp"%>