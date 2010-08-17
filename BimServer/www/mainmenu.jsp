
<%@page import="org.bimserver.database.store.UserType"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%><jsp:useBean id="loginManager" scope="session" class="org.bimserver.LoginManager" />
<a class="menu" href="main.jsp">Projects</a>
<%
	if (loginManager.getUserType() == SUserType.ADMIN) {
%>
<a class="menu" href="users.jsp">Users</a><a class="menu" href="info.jsp">Info</a><a class="menu" href="settings.jsp">Settings</a> 
<%	
	}
%>
<a class="menu" href="#" onClick="alert('You foud the magic button! send an e-mail to magicbutton@bimserver.org to recieve status.'); return true"></a>