<%@page import="org.bimserver.VersionChecker"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.bimserver.shared.DatabaseInformation"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.LoginManager" />
<%
	VersionChecker checkVersion = VersionChecker.getInstance();
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	DatabaseInformation databaseInformation = loginManager.getAdminService().getDatabaseInformation();
%>

<div class="info">Want to try out the BIMserver software together with other enthusiastic users? <br/>
Want a sneak preview for the newest features? Are you new to the BIMserver and want some help <br/>
during first use? Give us your ideas, feedback and comments. We will give you a breakfast and coffee in return!<br/>
Feel free to join us at the 3rd BIMserver breakfast on September 1st 2010 in Utrecht (the Netherlands).<br/>
Sign up for free at <a href="http://breakfast.bimserver.org/" target="_blank">breakfast.bimserver.org</a></div>

<div class="info">Last database reset: <%=dateFormat.format(databaseInformation.getCreated()) %><br/>
Version: <%=checkVersion.getLocalVersion().getVersion() + " (" + dateFormat.format(checkVersion.getLocalVersion().getDate()) + ")"%></div>