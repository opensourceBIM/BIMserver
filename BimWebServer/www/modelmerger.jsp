<%@page import="org.bimserver.interfaces.objects.SModelMergerPluginConfiguration"%>
<%@page import="org.bimserver.interfaces.objects.SModelMergerPluginDescriptor"%>
<%@page import="org.bimserver.interfaces.objects.SModelComparePluginDescriptor"%>
<%@page import="org.bimserver.interfaces.objects.SQueryEnginePluginDescriptor"%>
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
<%@page import="org.bimserver.shared.interfaces.ServiceInterface"%>
<%@page import="org.bimserver.shared.exceptions.ServiceException"%>
<div class="sidebar">
<ul>
</ul>
</div>
<div class="content">
<h1>Edit Model Merger</h1>
<fieldset>
<%
	String name = request.getParameter("name");
	String className = request.getParameter("className");
	long id = Long.parseLong(request.getParameter("id"));
	if (request.getParameter("update") != null) {
		SModelMergerPluginConfiguration modelMerger = loginManager.getService(request).getModelMergerById(id);
		modelMerger.setName(name);
		modelMerger.setClassName(className);
		loginManager.getService(request).updateModelMerger(modelMerger);
		response.sendRedirect("modelmergers.jsp");
	} else {
		SModelMergerPluginConfiguration modelMerger = loginManager.getService(request).getModelMergerById(id);
		if (name == null) {
			name = modelMerger.getName();
		}
		if (className == null) {
			className = modelMerger.getClassName();
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
	<td><label for="className">Model Merger</label></td>
	<td><select name="className" id="className">
		<option value="[none]">[None]</option>
<%
	for (SModelMergerPluginDescriptor iepd : loginManager.getService(request).getAllModelMergerPluginDescriptors()) {
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