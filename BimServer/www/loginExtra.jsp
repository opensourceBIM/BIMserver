<%@page import="org.bimserver.version.VersionChecker"%>
<%@page import="java.text.SimpleDateFormat"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<%
	VersionChecker checkVersion = VersionChecker.getInstance();
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
%>
<div class="info">Last database reset: <%=dateFormat.format(loginManager.getAdminService().getLastDatabaseReset()) %><br/>
Version: <%=checkVersion.getLocalVersion().getVersion() + " (" + dateFormat.format(checkVersion.getLocalVersion().getDate()) + ")"%></div>