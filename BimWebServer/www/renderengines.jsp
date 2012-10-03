<%@page import="org.bimserver.interfaces.objects.SIfcEnginePluginConfiguration"%>
<%@page import="java.util.List"%>
<%@ include file="usersettingsmenu.jsp"%>
<%
if (request.getParameter("action") != null) {
	String action = request.getParameter("action");
	if (action.equals("disable")) {
		SIfcEnginePluginConfiguration ifcEngine = loginManager.getService(request).getIfcEngineById(Long.parseLong(request.getParameter("oid")));
		ifcEngine.setEnabled(false);
		loginManager.getService(request).updateIfcEngine(ifcEngine);
	} else if (action.equals("enable")) {
		SIfcEnginePluginConfiguration ifcEngine = loginManager.getService(request).getIfcEngineById(Long.parseLong(request.getParameter("oid")));
		ifcEngine.setEnabled(true);
		loginManager.getService(request).updateIfcEngine(ifcEngine);
	} else if (action.equals("setdefault")) {
		loginManager.getService(request).setDefaultIfcEngine(Long.parseLong(request.getParameter("oid")));
	} else if (action.equals("delete")) {
		loginManager.getService(request).deleteIfcEngine(Long.parseLong(request.getParameter("oid")));
	}
	response.sendRedirect("renderengines.jsp");
}
%>
<h1>Render Engines</h1>
<a href="addrenderengine.jsp">Add RenderEngine</a>
<table class="formatted">
<tr><th>Name</th><th>Classname</th><th>Serializers</th><th>Default</th><th>State</th><th>Actions</th></tr>
<%
	List<SIfcEnginePluginConfiguration> ifcEngines = service.getAllIfcEngines(false);
	for (SIfcEnginePluginConfiguration ifcEngine : ifcEngines) {
		boolean isDefault = service.getDefaultIfcEngine() != null && service.getDefaultIfcEngine().getOid() == ifcEngine.getOid();
%>
	<tr>
		<td><a href="renderengine.jsp?id=<%=ifcEngine.getOid()%>"><%=ifcEngine.getName() %></a></td>
		<td><%=ifcEngine.getClassName() %></td>
		<td><%=ifcEngine.getSerializers().size() %></td>
		<td><input type="radio" name="default"<%=ifcEngine.getEnabled() ? "" : "disabled=\"disabled\"" %> oid="<%=ifcEngine.getOid()%>" <%=service.getDefaultIfcEngine() != null && service.getDefaultIfcEngine().getOid() == ifcEngine.getOid() ? "checked" : "" %>/></td>
		<td class="<%=ifcEngine.getEnabled() ? "enabled" : "disabled" %>"> <%=ifcEngine.getEnabled() ? "Enabled" : "Disabled" %></td>
		<td>
		<%
	if (!isDefault) {
	if (!ifcEngine.getEnabled()) {
%>
<a href="renderengines.jsp?action=enable&oid=<%=ifcEngine.getOid() %>">Enable</a>
<%
	} else if (ifcEngine.getSerializers().isEmpty()) {
%>
<a href="renderengines.jsp?action=disable&oid=<%=ifcEngine.getOid() %>">Disable</a>
<%
	}
	if (ifcEngine.getSerializers().isEmpty()) {
%>
			<a href="renderengines.jsp?action=delete&oid=<%=ifcEngine.getOid()%>">Delete</a>
<% } }%>
		</td>
	</tr>
<%
	}
%>
</table>
<script>
$(function(){
	$("input[name=\"default\"]").change(function(){
		document.location = "renderengines.jsp?action=setdefault&oid=" + $(this).attr("oid");
	});
});
</script>