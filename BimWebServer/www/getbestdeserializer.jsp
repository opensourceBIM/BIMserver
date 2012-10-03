<%@page import="org.bimserver.interfaces.objects.SDeserializerPluginConfiguration"%>
<%@page import="org.bimwebserver.jsp.LoginManager"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimwebserver.jsp.LoginManager" />
<%
	SDeserializerPluginConfiguration deserializer = loginManager.getService(request).getSuggestedDeserializerForExtension(request.getParameter("extension"));
	if (deserializer != null) {
		out.print(deserializer.getOid());
	} else {
		out.print("[NONE]");
	}
%>