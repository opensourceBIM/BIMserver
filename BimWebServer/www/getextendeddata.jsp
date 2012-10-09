<%@page import="org.bimserver.interfaces.objects.SFile"%>
<%@page import="org.apache.commons.io.IOUtils"%><%@page import="org.bimserver.interfaces.objects.SExtendedData"%><jsp:useBean id="loginManager" scope="session" class="org.bimwebserver.jsp.LoginManager" /><%
	SExtendedData sExtendedData = loginManager.getService(request).getExtendedData(Long.parseLong(request.getParameter("edid")));
	SFile sFile = loginManager.getService(request).getFile(sExtendedData.getFileId());
if (sFile.getMime() != null) {
	response.setContentType(sFile.getMime());
}
if (sFile.getFilename() != null) {
	response.setHeader("Content-Disposition", "inline; filename=\"" + sFile.getFilename()+ "\"");
}
  response.getOutputStream().write(sFile.getData());%>