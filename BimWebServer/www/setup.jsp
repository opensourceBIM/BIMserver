<%@page import="org.bimserver.web.JspHelper"%>
<%@page import="org.bimserver.shared.exceptions.ServiceException"%>
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
	if (request.getParameter("setup") != null) {
		try {
			loginManager.getService().setup(siteAddress, smtpServer, adminName, adminUsername, adminPassword);
			response.sendRedirect("login.jsp?username=" + adminUsername);
		} catch (ServiceException e) {
			JspHelper.showException(out, e);
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
		<p class="explain">The address on which your BIMserver is going to be available, for example "http://www.myserver.com"</p>
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
	<td>
		<label for="engine">IFC geometry engine</label>
		<p class="explain">Choose which engine you want to use for IFC geometry calculations. These engines can be closed source and are not part of the BIMserver project.</p>
	</td>
	<td><select name="engine" size="1"><option value="bonsma">Bonsma Engine DLL</option></select>
</tr>
<tr>
	<td>
		<label for="ifcversion">IFC version</label>
		<p class="explain">Choose which version of IFC should be used as the main database structure.</p>
	</td>
	<td><select name="ifcversion" size="1"><option value="ifc2x3">IFC2x3 TC1</option></select>
</tr>
<tr>
	<td colspan="2" class="tabletitle">Admin user</td>
</tr>
<tr>
	<td>
		<label for="adminName">Admin name</label>
		<p class="explain">Name of the first admin user (example: Arthur Dent)</p>
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
	<td>
		<p class="explain">By clicking the 'setup' button, you agree that the JSP pages of this BIMserver will have a generic
		Google Analytics code. This data is send anonymous to the BIMserver.org team to evaluate the use of the GUI. 
		This is done to improve the usability of BIMserver.<br/>
		If you don't want this, you can remove the code under 'server settings' in the box 'footer addition'.</p>
	</td>
</tr>

</table>
<input type="submit" name="setup" value="Setup"/>
</form>
</div>
<jsp:include page="footer.jsp" />