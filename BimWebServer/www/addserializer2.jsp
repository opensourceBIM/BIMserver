<%@page import="org.bimserver.interfaces.objects.SSerializerPluginDescriptor"%>
<%@page import="org.bimserver.interfaces.objects.SObjectIDMPluginConfiguration"%>
<%@page import="org.bimserver.interfaces.objects.SIfcEnginePluginConfiguration"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="org.bimwebserver.jsp.JspHelper"%>
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
<h1>Add serializer (2)</h1>
<fieldset>
<%
	String type = request.getParameter("type");
	String contentType = "";
	String extension = "";
	String description = "";
	String name = "";
	ServiceInterface service = loginManager.getService(request);
	if (request.getParameter("next") != null) {
		description = request.getParameter("description");
		contentType = request.getParameter("contentType");
		extension = request.getParameter("extension");
		name = request.getParameter("name");
		SSerializerPluginConfiguration serializer = new SSerializerPluginConfiguration();
		serializer.setName(name);
		serializer.setDescription(description);
		serializer.setContentType(contentType);
		serializer.setExtension(extension);
		serializer.setEnabled(true);
		try {
			serializer.setObjectIDMId(Long.parseLong(request.getParameter("objectIDM")));
		} catch (NumberFormatException e) {
			serializer.setObjectIDMId(-1);			
		}
		try {
			serializer.setIfcEngineId(Long.parseLong(request.getParameter("ifcEngine")));
		} catch (NumberFormatException e) {
			serializer.setIfcEngineId(-1);			
		}
		serializer.setClassName(request.getParameter("type"));
		try {
			service.addSerializer(serializer);
			response.sendRedirect("serializers.jsp");
		} catch (ServiceException e) {
			JspHelper.showException(out, e);
		}
	} else {
		SSerializerPluginDescriptor serializerPluginDescriptor = loginManager.getService(request).getSerializerPluginDescriptor(type);
		contentType = serializerPluginDescriptor.getDefaultContentType();
		extension = serializerPluginDescriptor.getDefaultExtension();
		name = serializerPluginDescriptor.getDefaultName();
	}
%>
<form>
<input type="hidden" name="type" value="<%=type%>"/>
<table>
<tr>
	<td><label for="name">Name</label></td>
	<td><input name="name" id="name" value="<%=name%>" class="focusme"></input></td>
</tr>
<tr>
	<td><label for="description">Description</label></td>
	<td><input name="description" id="description" value="<%=description%>"></input></td>
</tr>
<tr>
	<td><label for="contentType">Content Type</label></td>
	<td><input name="contentType" id="contentType" value="<%=contentType%>"></input></td>
</tr>
<tr>
	<td><label for="extension">Extension</label></td>
	<td><input name="extension" id="extension" value="<%=extension%>"></input></td>
</tr>
<tr>
	<td><label for="type">Type</label></td>
	<td><%=type %></td>
</tr>
<tr>
	<td><label for="objectIDM">Object IDM</label></td>
	<td><select name="objectIDM" id="objectIDM">
		<option value="[none]">[None]</option>
<%
	for (SObjectIDMPluginConfiguration objectIDM : service.getAllObjectIDMs(true)) {
%>
	<option value="<%=objectIDM.getOid()%>"<%=(request.getParameter("objectIDM") != null && request.getParameter("objectIDM").equals("" + objectIDM.getOid())) ? " selected=\"selected\"" : "" %>><%=objectIDM.getName()%></option>
<%
	}
%>
	</select></td>
</tr>
<tr>
	<td><label for="ifcEngine">IFC Engine</label></td>
	<td><select name="ifcEngine" id="ifcEngine">
		<option value="[none]">[None]</option>
<%
	for (SIfcEnginePluginConfiguration ifcEngine : service.getAllIfcEngines(true)) {
%>
	<option value="<%=ifcEngine.getOid()%>"<%=(request.getParameter("ifcEngine") != null && request.getParameter("ifcEngine").equals("" + ifcEngine.getOid())) ? " selected=\"selected\"" : "" %>><%=ifcEngine.getName()%></option>
<%
	}
%>
	</select></td>
</tr>
<tr>
	<td></td>
	<td><input name="next" type="submit" value="Next"/></td>
</tr>
</table>
</form>
</fieldset>
</div>
<%@ include file="footer.jsp"%>