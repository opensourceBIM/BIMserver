<%@page import="org.bimserver.shared.UserException"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<jsp:include page="htmlheader.jsp" />
<body>
<div style="width: 1000px; margin-left: auto; margin-right: auto; padding-top: 20px">
<a href="main.jsp"><img src="images/fulllogo.gif" title="BIMserver"/></a>
<%
	String siteAddress = request.getParameter("siteAddress") != null ? request.getParameter("siteAddress") : "http://localhost:8082";
	String smtpServer = request.getParameter("smtpServer") != null ? request.getParameter("smtpServer") : "";
	String adminName = request.getParameter("adminName") != null ? request.getParameter("adminName") : "Administrator";
	String adminUsername = request.getParameter("adminUsername") != null ? request.getParameter("adminUsername") : "";
	String adminPassword = request.getParameter("adminPassword") != null ? request.getParameter("adminPassword") : "";
	boolean createAnonymousUser = request.getParameter("createAnonymousUser") != null;
	if (request.getParameter("setup") != null) {
		try {
			loginManager.getService().setup(siteAddress, smtpServer, adminName, adminUsername, adminPassword, createAnonymousUser);
			response.sendRedirect("login.jsp?username=" + adminUsername);
		} catch (UserException e) {
			out.println("<div class=\"error\">" + e.getUserMessage() + "</div>");
		}
	}
%>
<h1>BIMserver Setup</h1>
<p>This BIMserver has not yet been configured, configuration is required before the server can be used.</p>
<form method="post">
<table class="formatted">
<tr>
	<td colspan="2" class="tabletitle">Server</td>
</tr>
<tr>
	<td>
		<label for="siteAddress">Site address</label>
		<p class="explain">The address on which your BIMserver is going to be available, for example "http://demo.bimserver.org"</p>
	</td>
	<td><input type="text" id="siteAddress" name="siteAddress" value="<%=siteAddress %>"/></td>
</tr>
<tr>
	<td>
		<label for="stmpServer">SMTP server</label>
		<p class="explain">Address of the SMTP server that should be used for sending e-mail</p>
	</td>
	<td><input type="text" id="smtpServer" name="smtpServer" value="<%=smtpServer %>"/></td>
</tr>
<tr>
	<td colspan="2" class="tabletitle">Admin user</td>
</tr>
<tr>
	<td>
		<label for="adminName">Admin name</label>
		<p class="explain">Name of the first admin user (example: Bill Gates)</p>
	</td>
	<td><input type="text" id="adminName" name="adminName" value="<%=adminName %>"/></td>
</tr>
<tr>
	<td>
		<label for="adminUsername">Admin username</label>
		<p class="explain">Username of the first admin user (must be a valid e-mail address)</p>
	</td>
	<td><input type="text" id="adminUsername" name="adminUsername" value="<%=adminUsername %>"/></td>
</tr>
<tr>
	<td>
		<label for="adminPassword">Admin password</label>
		<p class="explain">Password of the first admin user</p>
	</td>
	<td><input type="password" id="adminPassword" name="adminPassword" value="<%=adminPassword %>"/></td>
</tr>
<tr>
	<td colspan="2" class="tabletitle">Anonymous user</td>
</tr>
<tr>
	<td>
		<label for="createAnonymousUser">Create anonymous user</label>
		<p class="explain">Whether to create an anonymous user</p>
	</td>
	<td><input type="checkbox" id="createAnonymousUser" name="createAnonymousUser"<%=(createAnonymousUser ? "CHECKED=\"CHECKED\"" : "") %>/></td>
</tr>
</table>
<input type="submit" name="setup" value="Setup"/>
</form>
</div>
</body>
</html>