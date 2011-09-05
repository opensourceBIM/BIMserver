<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<a class="menu" href="main.jsp">Projects</a>
<%
	if (loginManager.getUserType() == SUserType.ADMIN) {
%>
<a class="menu" href="users.jsp">Users</a><a class="menu" href="info.jsp">Info</a> 
<a class="menu" href="serversettings.jsp">Server Settings</a>
<a class="menu" href="settings.jsp">Settings</a>
<%}%>
<a class="menu" style="color:#188107; href="http://support.bimserver.org" target="_blank">Help</a>