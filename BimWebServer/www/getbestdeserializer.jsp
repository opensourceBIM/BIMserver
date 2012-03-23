<%@page import="org.bimserver.web.LoginManager"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<%
	String name = loginManager.getService().getSuggestedDeserializerForExtension(request.getParameter("extension"));
	if (name != null) {
		out.print(name);
	} else {
		out.print("[NONE]");
	}
%>