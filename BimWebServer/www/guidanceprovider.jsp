<%@page import="org.bimserver.interfaces.objects.SGuidanceProviderPluginDescriptor"%>
<%@page import="org.bimserver.models.store.GuidanceProviderPluginDescriptor"%>
<%@ include file="header.jsp"%>
<%@page import="org.bimserver.interfaces.objects.SSerializer"%>
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
<%@page import="org.bimserver.shared.ServiceInterface"%>
<%@page import="org.bimserver.shared.exceptions.ServiceException"%>
<%@page import="org.bimserver.interfaces.objects.SGuidanceProvider"%>
<div class="sidebar">
<ul>
</ul>
</div>
<div class="content">
<h1>Edit guidance provider</h1>
<fieldset>
<%
	String name = request.getParameter("name");
	String className = request.getParameter("className");
	long id = Long.parseLong(request.getParameter("id"));
	if (request.getParameter("update") != null) {
		SGuidanceProvider guidanceProvider = loginManager.getService().getGuidanceProviderById(id);
		guidanceProvider.setName(name);
		guidanceProvider.setClassName(className);
		loginManager.getService().updateGuidanceProvider(guidanceProvider);
	} else {
		SGuidanceProvider guidanceProvider = loginManager.getService().getGuidanceProviderById(id);
		if (name == null) {
			name = guidanceProvider.getName();
		}
		if (className == null) {
			className = guidanceProvider.getClassName();
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
	<td><label for="className">Guidance provider</label></td>
	<td><select name="className" id="className">
		<option value="[none]">[None]</option>
<%
	for (SGuidanceProviderPluginDescriptor guidanceProviderPluginDescriptor : loginManager.getService().getAllGuidanceProviderPluginDescriptors()) {
%>
	<option value="<%=guidanceProviderPluginDescriptor.getClassName()%>"<%=(guidanceProviderPluginDescriptor.getClassName().equals(className) ? " selected=\"selected\"" : "") %>><%=guidanceProviderPluginDescriptor.getClassName()%></option>
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
</div>
<script>
$(function(){
	$("#name").focus();
});
</script>
</fieldset>
<%@ include file="footer.jsp"%>