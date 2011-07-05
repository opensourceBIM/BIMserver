<%@page import="org.bimserver.shared.SSerializerPluginDescriptor"%>
<%@ include file="header.jsp"%>
<%@page import="org.bimserver.interfaces.objects.SSerializer"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="org.bimserver.utils.Formatters"%>
<%@page import="org.bimserver.shared.DatabaseInformation"%>
<%@page import="org.bimserver.version.VersionChecker"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="org.bimserver.web.WarServerInitializer"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.apache.commons.io.IOUtils"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%@page import="org.bimserver.shared.ServiceInterface"%>
<%@page import="org.bimserver.shared.UserException"%>
<%@page import="org.bimserver.interfaces.objects.SGuidanceProvider"%>
<div class="sidebar">
<ul>
</ul>
</div>
<div class="content">
<h1>Edit serializer</h1>
<fieldset>
<%
	String type = request.getParameter("type");
	String contentType = "";
	String extension = "";
	String description = "";
	String name = request.getParameter("name");
	long guidanceProviderId = -1;
	ServiceInterface service = loginManager.getService();
	
	if (request.getParameter("update") != null) {
		SSerializer serializer = loginManager.getService().getSerializerByName(request.getParameter("name"));
		contentType = request.getParameter("contentType");
		extension = request.getParameter("extension");
		description = request.getParameter("description");
		guidanceProviderId = Long.parseLong(request.getParameter("guidanceProvider"));
		serializer.setContentType(contentType);
		serializer.setExtension(extension);
		serializer.setDescription(description);
		serializer.setName(request.getParameter("name"));
		serializer.setGuidanceProviderId(guidanceProviderId);
		loginManager.getService().updateSerializer(serializer);
	} else {
		SSerializer serializer = loginManager.getService().getSerializerByName(request.getParameter("name"));
		extension = serializer.getExtension();
		contentType = serializer.getContentType();
		description = serializer.getDescription();
		guidanceProviderId = serializer.getGuidanceProviderId();
		type = serializer.getClassName();
	}
%>
<form>
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
	<td><label for="guidanceProvider">Guidance provider</label></td>
	<td><select name="guidanceProvider" id="guidanceProvider">
		<option value="[none]">[None]</option>
<%
	for (SGuidanceProvider guidanceProvider : service.getAllGuidanceProviders()) {
%>
	<option value="<%=guidanceProvider.getOid()%>"<%=(guidanceProviderId == guidanceProvider.getOid() ? " selected=\"selected\"" : "") %>><%=guidanceProvider.getName()%></option>
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