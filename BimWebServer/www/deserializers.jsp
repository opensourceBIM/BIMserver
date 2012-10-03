<%@page import="org.bimserver.interfaces.objects.SDeserializerPluginConfiguration"%>
<%@page import="java.util.List"%>
<%@ include file="usersettingsmenu.jsp"%>
<%
if (request.getParameter("action") != null) {
	String action = request.getParameter("action");
	if (action.equals("disable")) {
		SDeserializerPluginConfiguration deserializer = loginManager.getService(request).getDeserializerById(Long.parseLong(request.getParameter("oid")));
		deserializer.setEnabled(false);
		loginManager.getService(request).updateDeserializer(deserializer);
	} else if (action.equals("enable")) {
		SDeserializerPluginConfiguration deserializer = loginManager.getService(request).getDeserializerById(Long.parseLong(request.getParameter("oid")));
		deserializer.setEnabled(true);
		loginManager.getService(request).updateDeserializer(deserializer);
	} else if (action.equals("delete")) {
		loginManager.getService(request).deleteDeserializer(Long.parseLong(request.getParameter("oid")));
	}
	response.sendRedirect("deserializers.jsp");
}
%>
<h1>Deserializers</h1>
<a href="adddeserializer1.jsp">Add Deserializer</a>
<table class="formatted">
<tr><th>Name</th><th>Description</th><th>Type</th><th>State</th><th>Actions</th></tr>
<%
	List<SDeserializerPluginConfiguration> deserializers = service.getAllDeserializers(false);
	for (SDeserializerPluginConfiguration deserializer : deserializers) {
%>
	<tr>
		<td><a href="deserializer.jsp?id=<%=deserializer.getOid()%>"><%=deserializer.getName() %></a></td>
		<td><%=deserializer.getDescription() %></td>
		<td><%=deserializer.getClassName() %></td>
		<td class="<%=deserializer.getEnabled() ? "enabled" : "disabled" %>"> <%=deserializer.getEnabled() ? "Enabled" : "Disabled" %></td>
		<td>
<%
	if (deserializer.getEnabled()) {
%>
<a href="deserializers.jsp?action=disable&oid=<%=deserializer.getOid() %>">Disable</a>
<%
	} else {
%>
<a href="deserializers.jsp?action=enable&oid=<%=deserializer.getOid() %>">Enable</a>
<%
	}
%>
			<a href="deserializers.jsp?action=delete&oid=<%=deserializer.getOid()%>">Delete</a>
		</td>
	</tr>
<%
	}
%>
</table>