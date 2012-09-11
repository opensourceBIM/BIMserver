<%@page import="org.bimserver.interfaces.objects.SObjectIDM"%>
<%@page import="java.util.List"%>
<%@ include file="settings.jsp"%>
<h1>Object IDMs</h1>
<a href="addobjectidm.jsp">Add ObjectIDM</a>
<table class="formatted">
<tr><th>Name</th><th>Classname</th><th>Serializers</th><th>State</th><th>Actions</th></tr>
<%
	List<SObjectIDM> objectIDMs = service.getAllObjectIDMs(false);
	for (SObjectIDM objectIDM : objectIDMs) {
%>
	<tr>
		<td><a href="objectidm.jsp?id=<%=objectIDM.getOid()%>"><%=objectIDM.getName() %></a></td>
		<td><%=objectIDM.getClassName() %></td>
		<td><%=objectIDM.getSerializers().size() %></td>
		<td class="<%=objectIDM.getEnabled() ? "enabledObjectIDM" : "disabledObjectIDM" %>"> <%=objectIDM.getEnabled() ? "Enabled" : "Disabled" %></td>
		<td>
		<%
	if (!objectIDM.getEnabled()) {
%>
<a href="settings.jsp?action=enableObjectIDM&objectIDM=<%=objectIDM.getName() %>">Enable</a>
<%
	} else if (objectIDM.getSerializers().isEmpty()) {
%>
<a href="settings.jsp?action=disableObjectIDM&objectIDM=<%=objectIDM.getName() %>">Disable</a>
<%
	}
	if (objectIDM.getSerializers().isEmpty()) {
%>
			<a href="deleteobjectidm.jsp?ifid=<%=objectIDM.getOid()%>">Delete</a>
<%} %>
		</td>
	</tr>
<%
	}
%>
</table>