<%@page import="org.codehaus.jettison.json.JSONArray"%>
<%@page import="org.codehaus.jettison.json.JSONObject"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="org.bimserver.interfaces.objects.SLongActionState"%>
<%@page import="org.bimserver.interfaces.objects.SActionState"%>
<%@page import="org.slf4j.LoggerFactory"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimwebserver.jsp.LoginManager" />
<%
	long laid = Long.parseLong(request.getParameter("laid"));
	String zip = request.getParameter("zip");
	SLongActionState dls = loginManager.getService(request).getDownloadState(laid);
	JSONObject result = new JSONObject();
	result.put("progress", dls.getProgress());
	result.put("state", dls.getState().toString());
	JSONArray jsonErrors = new JSONArray();
	result.put("errors", jsonErrors);
	for (String error : dls.getErrors()) {
		jsonErrors.put(error);
	}
	JSONArray jsonWarnings = new JSONArray();
	result.put("warnings", jsonWarnings);
	for (String warning : dls.getWarnings()) {
		jsonWarnings.put(warning);
	}
	result.write(out);
%>