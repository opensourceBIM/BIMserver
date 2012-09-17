<%@page import="org.apache.commons.io.IOUtils"%><%@page import="org.bimserver.interfaces.objects.SExtendedData"%><jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<% 
  SExtendedData sExtendedData = loginManager.getService().getExtendedData(Long.parseLong(request.getParameter("edid")));
  response.getOutputStream().write(sExtendedData.getData());
%>