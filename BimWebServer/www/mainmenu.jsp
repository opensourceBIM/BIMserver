<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimwebserver.jsp.LoginManager" />
<a class="menu" href="main.jsp">Projects</a>
<%
	if (loginManager.getUserType() == SUserType.ADMIN) {
%>
<a class="menu" href="users.jsp">Users</a>
<a class="menu" href="info.jsp">Info</a> 
<a class="menu" href="log.jsp">Log</a> 
<a class="menu" href="serversettings.jsp">Server Settings</a>
<%}%>
<a class="menu" href="usersettings.jsp">Settings</a>
<a class="menu" href="http://www.bimserver.org/help/" target="_blank">Help</a>