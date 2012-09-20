<%@page import="org.bimwebserver.jsp.LoginManager"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimwebserver.jsp.LoginManager" />
<%
	String name = loginManager.getService().getSuggestedDeserializerForExtension(request.getParameter("extension"));
	if (name != null) {
		out.print(name);
	} else {
		out.print("[NONE]");
	}
%>