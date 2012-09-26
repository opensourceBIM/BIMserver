<%@page import="org.apache.commons.io.IOUtils"%><%@page import="org.bimserver.interfaces.objects.SExtendedData"%><jsp:useBean id="loginManager" scope="session" class="org.bimwebserver.jsp.LoginManager" /><%
  SExtendedData sExtendedData = loginManager.getService().getExtendedData(Long.parseLong(request.getParameter("edid")));
if (sExtendedData.getMime() != null) {
	response.setContentType(sExtendedData.getMime());
}
if (sExtendedData.getFilename() != null) {
	response.setHeader("Content-Disposition", "inline; filename=\"" + sExtendedData.getFilename()+ "\"");
}
  response.getOutputStream().write(sExtendedData.getData());%>