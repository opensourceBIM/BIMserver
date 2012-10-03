<%@page import="org.bimserver.interfaces.objects.SObjectIDMPluginConfiguration"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="org.bimserver.interfaces.objects.SObjectIDMPluginDescriptor"%>
<%@ include file="header.jsp"%>
<%@page import="org.bimserver.interfaces.objects.SSerializerPluginConfiguration"%>
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
<h1>Add ObjectIDM</h1>
<fieldset>
<%
	ServiceInterface service = loginManager.getService(request);
	if (request.getParameter("add") != null) {
		SObjectIDMPluginConfiguration objectIDM = new SObjectIDMPluginConfiguration();
		objectIDM.setName(request.getParameter("name"));
		objectIDM.setClassName(request.getParameter("className"));
		objectIDM.setEnabled(true);
		loginManager.getService(request).addObjectIDM(objectIDM);
		response.sendRedirect("objectidms.jsp");
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
	for (SObjectIDMPluginDescriptor gppd : loginManager.getService(request).getAllObjectIDMPluginDescriptors()) {
		out.print("<option value=\"" + gppd.getClassName() + "\">" + gppd.getClassName() + "</option>");
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