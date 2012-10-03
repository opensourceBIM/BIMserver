<%@page import="org.bimserver.interfaces.objects.SModelMergerPluginConfiguration"%>
<%@page import="org.bimserver.interfaces.objects.SModelMergerPluginDescriptor"%>
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
<h1>Add Model Merger</h1>
<fieldset>
<%
	ServiceInterface service = loginManager.getService(request);
	if (request.getParameter("add") != null) {
		SModelMergerPluginConfiguration modelMerger = new SModelMergerPluginConfiguration();
		modelMerger.setName(request.getParameter("name"));
		modelMerger.setClassName(request.getParameter("className"));
		modelMerger.setEnabled(true);
		loginManager.getService(request).addModelMerger(modelMerger);
		response.sendRedirect("modelmergers.jsp");
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
	for (SModelMergerPluginDescriptor iepd : loginManager.getService(request).getAllModelMergerPluginDescriptors()) {
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