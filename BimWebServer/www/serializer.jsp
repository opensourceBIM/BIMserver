<%@page import="org.bimserver.interfaces.objects.SObjectIDMPluginConfiguration"%>
<%@page import="org.bimserver.interfaces.objects.SIfcEnginePluginConfiguration"%>
<%@ page contentType="text/html; charset=UTF-8" %>
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
<h1>Edit serializer</h1>
<fieldset>
<%
	long id = Long.parseLong(request.getParameter("id"));
	String type = "";
	String contentType = "";
	String extension = "";
	String description = "";
	String name = "";
	long objectIDMId = -1;
	long ifcEngineId = -1;
	ServiceInterface service = loginManager.getService(request);
	if (request.getParameter("update") != null) {
		SSerializerPluginConfiguration serializer = loginManager.getService(request).getSerializerById(id);
		name = request.getParameter("name");
		type = request.getParameter("type");
		contentType = request.getParameter("contentType");
		extension = request.getParameter("extension");
		description = request.getParameter("description");
		objectIDMId = request.getParameter("objectIDM").equals("[none]") ? -1 : Long.parseLong(request.getParameter("objectIDM"));
		ifcEngineId = request.getParameter("ifcEngine").equals("[none]") ? -1 : Long.parseLong(request.getParameter("ifcEngine"));
		serializer.setName(name);
		serializer.setContentType(contentType);
		serializer.setExtension(extension);
		serializer.setDescription(description);
		serializer.setName(request.getParameter("name"));
		serializer.setObjectIDMId(objectIDMId);
		serializer.setIfcEngineId(ifcEngineId);
		loginManager.getService(request).updateSerializer(serializer);
		response.sendRedirect("serializers.jsp");
	} else {
		SSerializerPluginConfiguration serializer = loginManager.getService(request).getSerializerById(id);
		name = serializer.getName();
		extension = serializer.getExtension();
		contentType = serializer.getContentType();
		description = serializer.getDescription();
		objectIDMId = serializer.getObjectIDMId();
		type = serializer.getClassName();
		ifcEngineId = serializer.getIfcEngineId();
	}
%>
<form method="post">
<input type="hidden" name="id" value="<%=id%>"/>
<input type="hidden" name="type" value="<%=type%>"/>
<table>
<tr>
	<td><label for="name">Name</label></td>
	<td><input name="name" id="name" value="<%=name%>"></input></td>
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
	<option value="<%=objectIDM.getOid()%>"<%=(objectIDMId == objectIDM.getOid() ? " selected=\"selected\"" : "") %>><%=objectIDM.getName()%></option>
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
	<option value="<%=ifcEngine.getOid()%>"<%=(ifcEngineId == ifcEngine.getOid() ? " selected=\"selected\"" : "") %>><%=ifcEngine.getName()%></option>
<%
	}
%>
	</select></td>
</tr>
<tr>
	<td></td>
	<td><input name="update" type="submit" value="Update"/></td>
</tr>
</table>
</form>
</fieldset>
</div>
<script>
$(function(){
	$("#name").focus();
});
</script>
<%@ include file="footer.jsp"%>