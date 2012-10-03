<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="org.bimserver.interfaces.objects.SVersion"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.bimserver.shared.exceptions.ServiceException"%>
<%@page import="java.util.Date"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimwebserver.jsp.LoginManager" />
<%
	SVersion version = loginManager.getService(request).getVersion();
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	Date lastReset = null;
	try {
		lastReset = loginManager.getService(request).getLastDatabaseReset();
	} catch (ServiceException e) {
		// Ignore		
	}
%>
<div class="info">Last database reset: <%=lastReset == null ? "Unknown" : dateFormat.format(lastReset) %><br/>
Version: <%=version.getMajor() + "." + version.getMinor() + "." + version.getRevision() + " (" + dateFormat.format(version.getDate()) + ")"%></div>