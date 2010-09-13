<%@page import="org.bimserver.VersionChecker"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.bimserver.shared.DatabaseInformation"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.LoginManager" />
<%
	VersionChecker checkVersion = VersionChecker.getInstance();
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	DatabaseInformation databaseInformation = loginManager.getAdminService().getDatabaseInformation();
%>

<div class="info">Last database reset: <%=dateFormat.format(databaseInformation.getCreated()) %><br/>
Version: <%=checkVersion.getLocalVersion().getVersion() + " (" + dateFormat.format(checkVersion.getLocalVersion().getDate()) + ")"%></div>