<%@page import="org.codehaus.jettison.json.JSONObject"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="org.bimserver.interfaces.objects.SLongActionState"%>
<%@page import="org.bimserver.interfaces.objects.SActionState"%>
<%@page import="org.slf4j.LoggerFactory"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<%
	int laid = Integer.parseInt(request.getParameter("laid"));
	String zip = request.getParameter("zip");
	SLongActionState dls = loginManager.getService().getDownloadState(laid);
	JSONObject result = new JSONObject();
	result.put("progress", dls.getProgress());
	result.put("state", dls.getState().toString());
	result.write(out);
%>