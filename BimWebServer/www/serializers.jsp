<%@page import="org.bimserver.interfaces.objects.SObjectIDMPluginConfiguration"%>
<%@page import="org.bimserver.interfaces.objects.SIfcEnginePluginConfiguration"%>
<%@page import="org.bimserver.interfaces.objects.SSerializerPluginConfiguration"%>
<%@page import="java.util.List"%>
<%@ include file="usersettingsmenu.jsp"%>
<h1>Serializers</h1>
<a href="addserializer1.jsp">Add Serializer</a>
<table class="formatted">
<tr><th>Name</th><th>Description</th><th>Type</th><th>Content Type</th><th>ObjectIDM</th><th>Render Engine</th><th>Default</th><th>State</th><th>Actions</th></tr>
<%
	if (request.getParameter("action") != null) {
		String action = request.getParameter("action");
		if (action.equals("disable")) {
			SSerializerPluginConfiguration serializer = loginManager.getService(request).getSerializerById(Long.parseLong(request.getParameter("oid")));
			serializer.setEnabled(false);
			loginManager.getService(request).updateSerializer(serializer);
		} else if (action.equals("enable")) {
			SSerializerPluginConfiguration serializer = loginManager.getService(request).getSerializerById(Long.parseLong(request.getParameter("oid")));
			serializer.setEnabled(true);
			loginManager.getService(request).updateSerializer(serializer);
		} else if (action.equals("setdefault")) {
			loginManager.getService(request).setDefaultSerializer(Long.parseLong(request.getParameter("oid")));
		} else if (action.equals("delete")) {
			loginManager.getService(request).deleteSerializer(Long.parseLong(request.getParameter("oid")));
		}
		response.sendRedirect("serializers.jsp");
	}
	List<SSerializerPluginConfiguration> serializers = service.getAllSerializers(false);
	for (SSerializerPluginConfiguration serializer : serializers) {
		boolean isDefault = service.getDefaultSerializer() != null && service.getDefaultSerializer().getOid() == serializer.getOid();
		SObjectIDMPluginConfiguration objectIDM = null;
		if (serializer.getObjectIDMId() != -1) {
			objectIDM = service.getObjectIDMById(serializer.getObjectIDMId());
		}
		SIfcEnginePluginConfiguration ifcEngine = null;
		if (serializer.getIfcEngineId() != -1) {
			ifcEngine = service.getIfcEngineById(serializer.getIfcEngineId());
		}
%>
	<tr>
		<td><a href="serializer.jsp?id=<%=serializer.getOid()%>"><%=serializer.getName() %></a></td>
		<td><%=serializer.getDescription() %></td>
		<td><%=serializer.getClassName() %></td>
		<td><%=serializer.getContentType() %></td>
		<td><%=objectIDM == null ? "none" : objectIDM.getName() %></td>
		<td><%=ifcEngine == null ? "none" : ifcEngine.getName() %></td>
		<td><input type="radio" name="default"<%=serializer.getEnabled() ? "" : "disabled=\"disabled\"" %> oid="<%=serializer.getOid()%>" <%=isDefault ? "checked" : "" %>/></td>
		<td class="<%=serializer.getEnabled() ? "enabled" : "disabled" %>"> <%=serializer.getEnabled() ? "Enabled" : "Disabled" %></td>
		<td>
<%
	if (!isDefault) {
	if (serializer.getEnabled()) {
%>
<a href="serializers.jsp?action=disable&oid=<%=serializer.getOid() %>">Disable</a>
<%
	} else {
%>
<a href="serializers.jsp?action=enable&oid=<%=serializer.getOid() %>">Enable</a>
<%
	}
%>
			<a href="serializers.jsp?action=delete&oid=<%=serializer.getOid()%>">Delete</a>
<%
}
%>
		</td>
	</tr>
<%
	}
%>
</table>
<script>
$(function(){
	$("input[name=\"default\"]").change(function(){
		document.location = "serializers.jsp?action=setdefault&oid=" + $(this).attr("oid");
	});
});
</script>