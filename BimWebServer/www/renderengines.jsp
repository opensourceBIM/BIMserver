<%@page import="org.bimserver.interfaces.objects.SIfcEngine"%>
<%@page import="java.util.List"%>
<%@ include file="settings.jsp"%>
<h1>Render Engines</h1>
<a href="addrenderengine.jsp">Add RenderEngine</a>
<table class="formatted">
<tr><th>Name</th><th>Classname</th><th>Serializers</th><th>Default</th><th>State</th><th>Actions</th></tr>
<%
	List<SIfcEngine> ifcEngines = service.getAllIfcEngines(false);
	for (SIfcEngine ifcEngine : ifcEngines) {
%>
	<tr>
		<td><a href="renderengine.jsp?id=<%=ifcEngine.getOid()%>"><%=ifcEngine.getName() %></a></td>
		<td><%=ifcEngine.getClassName() %></td>
		<td><%=ifcEngine.getSerializers().size() %></td>
		<td><input type="radio" name="default" oid="<%=ifcEngine.getOid()%>" <%=service.getDefaultIfcEngine() != null && service.getDefaultIfcEngine().getOid() == ifcEngine.getOid() ? "checked" : "" %>/></td>
		<td class="<%=ifcEngine.getEnabled() ? "enabledIfcEngine" : "disabledIfcEngine" %>"> <%=ifcEngine.getEnabled() ? "Enabled" : "Disabled" %></td>
		<td>
		<%
	if (!ifcEngine.getEnabled()) {
%>
<a href="settings.jsp?action=enableIfcEngine&ifcEngine=<%=ifcEngine.getName() %>">Enable</a>
<%
	} else if (ifcEngine.getSerializers().isEmpty()) {
%>
<a href="settings.jsp?action=disableIfcEngine&ifcEngine=<%=ifcEngine.getName() %>">Disable</a>
<%
	}
	if (ifcEngine.getSerializers().isEmpty()) {
%>
			<a href="deleterenderengine.jsp?ifid=<%=ifcEngine.getOid()%>">Delete</a>
<% } %>
		</td>
	</tr>
<%
	}
%>
</table>
<script>
$(function(){
	$("input[name=\"default\"]").change(function(){
		$.ajax("setdefaultrenderengine.jsp?oid=" + $(this).attr("oid"));
	});
});
</script>