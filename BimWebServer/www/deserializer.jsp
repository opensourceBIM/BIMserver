<%@page import="org.bimserver.interfaces.objects.SDeserializerPluginConfiguration"%>
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
<h1>Edit deserializer</h1>
<fieldset>
<%
	long id = Long.parseLong(request.getParameter("id"));
	String description = "";
	String name = request.getParameter("name");
	ServiceInterface service = loginManager.getService(request);
	
	if (request.getParameter("update") != null) {
		SDeserializerPluginConfiguration deserializer = loginManager.getService(request).getDeserializerById(Long.parseLong(request.getParameter("id")));
		description = request.getParameter("description");
		deserializer.setName(name);
		deserializer.setDescription(description);
		loginManager.getService(request).updateDeserializer(deserializer);
		response.sendRedirect("deserializers.jsp");
	} else {
		SDeserializerPluginConfiguration deserializer = loginManager.getService(request).getDeserializerById(Long.parseLong(request.getParameter("id")));
		description = deserializer.getDescription();
		name = deserializer.getName();
	}
%>
<form>
<input type="hidden" name="id" value="<%=id%>"/>
<input type="hidden" name="name" value="<%=name%>"/>
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