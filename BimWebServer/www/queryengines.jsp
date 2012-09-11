<%@page import="org.bimserver.interfaces.objects.SQueryEngine"%>
<%@page import="java.util.List"%>
<%@ include file="settings.jsp"%>
<h1>Query Engines</h1>
<a href="addqueryengine.jsp">Add Query Engine</a>
<table class="formatted">
<tr><th>Name</th><th>Classname</th><th>State</th><th>Actions</th></tr>
<%
	List<SQueryEngine> queryEngines = service.getAllQueryEngines(false);
	for (SQueryEngine queryEngine : queryEngines) {
%>
	<tr>
		<td><a href="queryengine.jsp?id=<%=queryEngine.getOid()%>"><%=queryEngine.getName() %></a></td>
		<td><%=queryEngine.getClassName() %></td>
		<td class="<%=queryEngine.getEnabled() ? "enabledIfcEngine" : "disabledIfcEngine" %>"> <%=queryEngine.getEnabled() ? "Enabled" : "Disabled" %></td>
		<td>
		<%
	if (!queryEngine.getEnabled()) {
%>
<a href="settings.jsp?action=enableQueryEngine&ifcEngine=<%=queryEngine.getName() %>">Enable</a>
<%
	}
%>
		<a href="deletequeryengine.jsp?ifid=<%=queryEngine.getOid()%>">Delete</a>
		</td>
	</tr>
<%
	}
%>
</table>