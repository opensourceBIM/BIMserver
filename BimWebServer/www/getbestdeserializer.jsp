<%@page import="org.bimserver.interfaces.objects.SDeserializer"%>
<%@page import="org.bimwebserver.jsp.LoginManager"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimwebserver.jsp.LoginManager" />
<%
	SDeserializer deserializer = loginManager.getService().getSuggestedDeserializerForExtension(request.getParameter("extension"));
	if (deserializer != null) {
		out.print(deserializer.getOid());
	} else {
		out.print("[NONE]");
	}
%>