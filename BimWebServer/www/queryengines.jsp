<%@page import="org.bimserver.interfaces.objects.SQueryEngine"%>
<%@page import="java.util.List"%>
<%@ include file="settingsmenu.jsp"%>
<%
if (request.getParameter("action") != null) {
	String action = request.getParameter("action");
	if (action.equals("enableQueryEngine")) {
		SQueryEngine queryEngine = loginManager.getService().getQueryEngineByName(request.getParameter("queryEngine"));
		queryEngine.setEnabled(true);
		loginManager.getService().updateQueryEngine(queryEngine);
	} else if (action.equals("disableQueryEngine")) {
		SQueryEngine queryEngine = loginManager.getService().getQueryEngineByName(request.getParameter("queryEngine"));
		queryEngine.setEnabled(false);
		loginManager.getService().updateQueryEngine(queryEngine);
	}
}
%>
<h1>Query Engines</h1>
<a href="addqueryengine.jsp">Add Query Engine</a>
<table class="formatted">
<tr><th>Name</th><th>Classname</th><th>Default</th><th>State</th><th>Actions</th></tr>
<%
	List<SQueryEngine> queryEngines = service.getAllQueryEngines(false);
	for (SQueryEngine queryEngine : queryEngines) {
%>
	<tr>
		<td><a href="queryengine.jsp?id=<%=queryEngine.getOid()%>"><%=queryEngine.getName() %></a></td>
		<td><%=queryEngine.getClassName() %></td>
		<td><input type="radio" name="default" oid="<%=queryEngine.getOid()%>" <%=service.getDefaultQueryEngine() != null && service.getDefaultQueryEngine().getOid() == queryEngine.getOid() ? "checked" : "" %>/></td>
		<td class="<%=queryEngine.getEnabled() ? "enabledIfcEngine" : "disabledIfcEngine" %>"> <%=queryEngine.getEnabled() ? "Enabled" : "Disabled" %></td>
		<td>
		<%
	if (!queryEngine.getEnabled()) {
%>
<a href="queryengines.jsp?action=enableQueryEngine&queryEngine=<%=queryEngine.getName() %>">Enable</a>
<%
	} else {
%>
<a href="queryengines.jsp?action=disableQueryEngine&queryEngine=<%=queryEngine.getName() %>">Disable</a>
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
<script>
$(function(){
	$("input[name=\"default\"]").change(function(){
		$.ajax("setdefaultqueryengine.jsp?oid=" + $(this).attr("oid"));
	});
});
</script>