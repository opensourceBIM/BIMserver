<%@page import="org.bimserver.interfaces.objects.SIfcEnginePluginConfiguration"%>
<%@page import="org.bimserver.interfaces.objects.SIfcEnginePluginDescriptor"%>
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
<%@page import="org.bimserver.shared.exceptions.ServiceException"%>
<div class="sidebar">
<ul>
</ul>
</div>
<div class="content">
<h1>Edit Render Engine</h1>
<fieldset>
<%
	String name = request.getParameter("name");
	String className = request.getParameter("className");
	long id = Long.parseLong(request.getParameter("id"));
	if (request.getParameter("update") != null) {
		SIfcEnginePluginConfiguration ifcEngine = loginManager.getService(request).getIfcEngineById(id);
		ifcEngine.setName(name);
		ifcEngine.setClassName(className);
		loginManager.getService(request).updateIfcEngine(ifcEngine);
		response.sendRedirect("renderengines.jsp");
	} else {
		SIfcEnginePluginConfiguration ifcEngine = loginManager.getService(request).getIfcEngineById(id);
		if (name == null) {
			name = ifcEngine.getName();
		}
		if (className == null) {
			className = ifcEngine.getClassName();
		}
	}
%>
<form>
<input type="hidden" name="id" value="<%=id%>"/>
<table>
<tr>
	<td><label for="name">Name</label></td>
	<td><input name="name" id="name" value="<%=name%>"></input></td>
</tr>
<tr>
	<td><label for="className">Render Engine</label></td>
	<td><select name="className" id="className">
		<option value="[none]">[None]</option>
<%
	for (SIfcEnginePluginDescriptor iepd : loginManager.getService(request).getAllIfcEnginePluginDescriptors()) {
%>
	<option value="<%=iepd.getPluginClassName()%>"<%=(iepd.getPluginClassName().equals(className) ? " selected=\"selected\"" : "") %>><%=iepd.getPluginClassName()%></option>
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