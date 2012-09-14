<%@page import="org.bimserver.interfaces.objects.SIfcEngine"%>
<%@page import="java.util.List"%>
<%@ include file="settingsmenu.jsp"%>
<%
if (request.getParameter("action") != null) {
	String action = request.getParameter("action");
	if (action.equals("disableIfcEngine")) {
		SIfcEngine ifcEngine = loginManager.getService().getIfcEngineByName(request.getParameter("ifcEngine"));
		ifcEngine.setEnabled(false);
		loginManager.getService().updateIfcEngine(ifcEngine);
	} else if (action.equals("enableIfcEngine")) {
		SIfcEngine ifcEngine = loginManager.getService().getIfcEngineByName(request.getParameter("ifcEngine"));
		ifcEngine.setEnabled(true);
		loginManager.getService().updateIfcEngine(ifcEngine);
	} else if (action.equals("setdefaultrenderengine")) {
		loginManager.getService().setDefaultIfcEngine(Long.parseLong(request.getParameter("oid")));
	}
	response.sendRedirect("renderengines.jsp");
}
%>
<h1>Render Engines</h1>
<a href="addrenderengine.jsp">Add RenderEngine</a>
<table class="formatted">
<tr><th>Name</th><th>Classname</th><th>Serializers</th><th>Default</th><th>State</th><th>Actions</th></tr>
<%
	List<SIfcEngine> ifcEngines = service.getAllIfcEngines(false);
	for (SIfcEngine ifcEngine : ifcEngines) {
		boolean isDefault = service.getDefaultIfcEngine() != null && service.getDefaultIfcEngine().getOid() == ifcEngine.getOid();
%>
	<tr>
		<td><a href="renderengine.jsp?id=<%=ifcEngine.getOid()%>"><%=ifcEngine.getName() %></a></td>
		<td><%=ifcEngine.getClassName() %></td>
		<td><%=ifcEngine.getSerializers().size() %></td>
		<td><input type="radio" name="default"<%=ifcEngine.getEnabled() ? "" : "disabled=\"disabled\"" %> oid="<%=ifcEngine.getOid()%>" <%=service.getDefaultIfcEngine() != null && service.getDefaultIfcEngine().getOid() == ifcEngine.getOid() ? "checked" : "" %>/></td>
		<td class="<%=ifcEngine.getEnabled() ? "enabledIfcEngine" : "disabledIfcEngine" %>"> <%=ifcEngine.getEnabled() ? "Enabled" : "Disabled" %></td>
		<td>
		<%
	if (!isDefault) {
	if (!ifcEngine.getEnabled()) {
%>
<a href="renderengines.jsp?action=enableIfcEngine&ifcEngine=<%=ifcEngine.getName() %>">Enable</a>
<%
	} else if (ifcEngine.getSerializers().isEmpty()) {
%>
<a href="renderengines.jsp?action=disableIfcEngine&ifcEngine=<%=ifcEngine.getName() %>">Disable</a>
<%
	}
	if (ifcEngine.getSerializers().isEmpty()) {
%>
			<a href="deleterenderengine.jsp?ifid=<%=ifcEngine.getOid()%>">Delete</a>
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
		document.location = "renderengines.jsp?action=setdefaultrenderengine&oid=" + $(this).attr("oid");
	});
});
</script>