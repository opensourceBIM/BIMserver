<%@page import="org.bimserver.interfaces.objects.SDeserializer"%>
<%@page import="java.util.List"%>
<%@ include file="settingsmenu.jsp"%>
<%
if (request.getParameter("action") != null) {
	String action = request.getParameter("action");
	if (action.equals("disableDeserializer")) {
		SDeserializer deserializer = loginManager.getService().getDeserializerById(Long.parseLong(request.getParameter("oid")));
		deserializer.setEnabled(false);
		loginManager.getService().updateDeserializer(deserializer);
	} else if (action.equals("enableDeserializer")) {
		SDeserializer deserializer = loginManager.getService().getDeserializerById(Long.parseLong(request.getParameter("oid")));
		deserializer.setEnabled(true);
		loginManager.getService().updateDeserializer(deserializer);
	}
	response.sendRedirect("deserializers.jsp");
}
%>
<h1>Deserializers</h1>
<a href="adddeserializer1.jsp">Add Deserializer</a>
<table class="formatted">
<tr><th>Name</th><th>Description</th><th>Type</th><th>State</th><th>Actions</th></tr>
<%
	List<SDeserializer> deserializers = service.getAllDeserializers(false);
	for (SDeserializer deserializer : deserializers) {
%>
	<tr>
		<td><a href="deserializer.jsp?id=<%=deserializer.getOid()%>"><%=deserializer.getName() %></a></td>
		<td><%=deserializer.getDescription() %></td>
		<td><%=deserializer.getClassName() %></td>
		<td class="<%=deserializer.getEnabled() ? "enabledDeserializer" : "disabledDeserializer" %>"> <%=deserializer.getEnabled() ? "Enabled" : "Disabled" %></td>
		<td>
<%
	if (deserializer.getEnabled()) {
%>
<a href="deserializers.jsp?action=disableDeserializer&oid=<%=deserializer.getOid() %>">Disable</a>
<%
	} else {
%>
<a href="deserializers.jsp?action=enableDeserializer&oid=<%=deserializer.getOid() %>">Enable</a>
<%
	}
%>
			<a href="deletedeserializer.jsp?sid=<%=deserializer.getOid()%>">Delete</a>
		</td>
	</tr>
<%
	}
%>
</table>