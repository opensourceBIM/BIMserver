<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="org.bimwebserver.jsp.JspHelper"%>
<%@ include file="header.jsp"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="org.bimserver.utils.Formatters"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.apache.commons.io.IOUtils"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%@page import="org.bimserver.shared.interfaces.ServiceInterface"%>
<%@page import="org.bimserver.shared.exceptions.ServiceException"%>
<%@page import="org.bimserver.interfaces.objects.SSerializerPluginConfiguration"%>
<jsp:include page="serversettingsmenu.jsp"/>
<div class="content">
<h1>Server Settings</h1>
<%
	ServiceInterface service = loginManager.getService(request);
	if (loginManager.isLoggedIn() && loginManager.getUserType() == SUserType.ADMIN) {
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
				service.setSettingHideUserListForNonAdmin(request.getParameter("hideUserListForNonAdmin") != null);
				service.setSettingCustomLogoAddress(request.getParameter("customLogo"));
				service.setSettingSiteAddress(request.getParameter("siteAddress"));
				service.setSettingCheckinMergingEnabled(request.getParameter("checkinMergingEnabled") != null);
				service.setSettingHeaderAddition(request.getParameter("headerAddition"));
				service.setSettingFooterAddition(request.getParameter("footerAddition"));
				service.setSettingProtocolBuffersPort(Integer.parseInt(request.getParameter("protocolBuffersPort")));
				service.setServiceRepositoryUrl(request.getParameter("serviceRepositoryUrl"));
				response.sendRedirect(getServletContext().getContextPath() + "/serversettings.jsp?msg=settingschangeok");
			} catch (ServiceException e) {
				JspHelper.showException(out, e);
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
		<td><label for="hideUserListForNonAdmin">Hide userlists for non-admin users</label></td>
		<td><input id="hideUserListForNonAdmin" type="checkbox"
			name="hideUserListForNonAdmin"
			<%=(request.getParameter("save") == null ? service.isSettingHideUserListForNonAdmin() : request.getParameter("hideUserListForNonAdmin") != null) ? " checked=\"checked\"" : ""%>></input></td>
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
		<td><label for="protocolBuffersPort">Protocol Buffers Port</label></td>
		<td><input id="protocolBuffersPort" name="protocolBuffersPort"
			type="text" value="<%=(request.getParameter("save") == null ? service.getSettingProtocolBuffersPort() : request.getParameter("protocolBuffersPort")) %>"></input></td>
	</tr>
	<tr>
		<td><label for="serviceRepositoryUrl">Service Repository URL</label></td>
		<td><input id="serviceRepositoryUrl" name="serviceRepositoryUrl"
			type="text" value="<%=(request.getParameter("save") == null ? service.getServiceRepositoryUrl() : request.getParameter("serviceRepositoryUrl")) %>"></input></td>
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
		<td><label for="cacheOutputFiles">Cache output files</label></td>
		<td><input id="cacheOutputFiles" name="cacheOutputFiles" type="checkbox"
			<%=(request.getParameter("save") == null ? service.isSettingCacheOutputFiles() : request.getParameter("cacheOutputFiles") != null) ? " checked=\"checked\"" : ""%>></input></td>
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
<%
	} else {
		out.println("Insufficient rights");
	}
%>
</div>
<%@ include file="footer.jsp"%>