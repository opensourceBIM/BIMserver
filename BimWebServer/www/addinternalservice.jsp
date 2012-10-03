<%@page import="org.bimserver.interfaces.objects.SInternalServicePluginConfiguration"%>
<%@page import="org.bimserver.interfaces.objects.SServicePluginDescriptor"%>
<%@page import="org.bimserver.interfaces.objects.SService"%>
<%@page import="org.bimserver.interfaces.objects.SQueryEnginePluginDescriptor"%>
<%@page import="org.bimserver.interfaces.objects.SIfcEnginePluginDescriptor"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="header.jsp"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="org.bimserver.utils.Formatters"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.apache.commons.io.IOUtils"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%@page import="org.bimserver.shared.interfaces.ServiceInterface"%>
<%@page import="org.bimserver.shared.exceptions.ServiceException"%>
<div class="sidebar">
<ul>
</ul>
</div>
<div class="content">
<h1>Add Service</h1>
<fieldset>
<%
	ServiceInterface service = loginManager.getService(request);
	if (request.getParameter("add") != null) {
		SInternalServicePluginConfiguration seService = new SInternalServicePluginConfiguration();
		seService.setName(request.getParameter("name"));
		seService.setClassName(request.getParameter("className"));
		seService.setEnabled(true);
		loginManager.getService(request).addInternalService(seService);
		response.sendRedirect("internalservices.jsp");
	}
%>
<form>
<table>
<tr>
	<td><label for="name">Name</label></td>
	<td><input name="name" id="name" class="focusme"></input></td>
</tr>
<tr>
	<td><label for="className">Class</label></td>
	<td><select name="className" id="className">
<%
	for (SServicePluginDescriptor iepd : loginManager.getService(request).getAllServicePluginDescriptors()) {
		out.print("<option value=\"" + iepd.getPluginClassName() + "\">" + iepd.getPluginClassName() + "</option>");
	}
%>
	</select></td>
</tr>
<tr>
	<td></td>
	<td><input type="submit" name="add" value="Add"/></td>
</tr>
</table>
</form>
</fieldset>
</div>
<%@ include file="footer.jsp"%>