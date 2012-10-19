<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="org.bimserver.web.WebServerHelper"%>
<%@page import="org.bimserver.version.VersionChecker"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.bimserver.shared.UserException"%>
<%@page import="java.util.Date"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimwebserver.jsp.LoginManager" />
<%
	VersionChecker checkVersion = WebServerHelper.getBimServer().getVersionChecker();
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	Date lastReset = null;
	try {
		lastReset = loginManager.getSystemService().getLastDatabaseReset();
	} catch (UserException e) {
		// Ignore		
	}
%>

<div class="info">Last database reset: <%=lastReset == null ? "Unknown" : dateFormat.format(lastReset) %><br/>
Version: <%=checkVersion.getLocalVersion().getVersion() + " (" + dateFormat.format(checkVersion.getLocalVersion().getDate()) + ")"%></div>