<%@page import="org.bimserver.interfaces.objects.SObjectIDMPluginConfiguration"%>
<%@page import="java.util.List"%>
<%@ include file="usersettingsmenu.jsp"%>
<%		
if (request.getParameter("action") != null) {
	String action = request.getParameter("action");
	if (action.equals("disable")) {
		SObjectIDMPluginConfiguration objectIDM = loginManager.getService(request).getObjectIDMById(Long.parseLong(request.getParameter("oid")));
		objectIDM.setEnabled(false);
		loginManager.getService(request).updateObjectIDM(objectIDM);
	} else if (action.equals("enable")) {
		SObjectIDMPluginConfiguration objectIDM = loginManager.getService(request).getObjectIDMById(Long.parseLong(request.getParameter("oid")));
		objectIDM.setEnabled(true);
		loginManager.getService(request).updateObjectIDM(objectIDM);
	} else if (action.equals("setdefault")) {
		loginManager.getService(request).setDefaultObjectIDM(Long.parseLong(request.getParameter("oid")));
	} else if (action.equals("delete")) {
		loginManager.getService(request).deleteObjectIDM(Long.parseLong(request.getParameter("oid")));
	}
	response.sendRedirect("objectidms.jsp");
}
%>
<h1>Object IDMs</h1>
<a href="addobjectidm.jsp">Add ObjectIDM</a>
<table class="formatted">
<tr><th>Name</th><th>Classname</th><th>Serializers</th><th>Default</th><th>State</th><th>Actions</th></tr>
<%
	List<SObjectIDMPluginConfiguration> objectIDMs = service.getAllObjectIDMs(false);
	for (SObjectIDMPluginConfiguration objectIDM : objectIDMs) {
		boolean isDefault = service.getDefaultObjectIDM() != null && service.getDefaultObjectIDM().getOid() == objectIDM.getOid();
%>
	<tr>
		<td><a href="objectidm.jsp?id=<%=objectIDM.getOid()%>"><%=objectIDM.getName() %></a></td>
		<td><%=objectIDM.getClassName() %></td>
		<td><%=objectIDM.getSerializers().size() %></td>
		<td><input type="radio" name="default"<%=objectIDM.getEnabled() ? "" : "disabled=\"disabled\"" %> oid="<%=objectIDM.getOid()%>" <%=service.getDefaultObjectIDM() != null && service.getDefaultObjectIDM().getOid() == objectIDM.getOid() ? "checked" : "" %>/></td>
		<td class="<%=objectIDM.getEnabled() ? "enabled" : "disabled" %>"> <%=objectIDM.getEnabled() ? "Enabled" : "Disabled" %></td>
		<td>
		<%
	if (!isDefault) {
	if (!objectIDM.getEnabled()) {
%>
<a href="objectidms.jsp?action=enable&oid=<%=objectIDM.getOid() %>">Enable</a>
<%
	} else if (objectIDM.getSerializers().isEmpty()) {
%>
<a href="objectidms.jsp?action=disable&oid=<%=objectIDM.getOid() %>">Disable</a>
<%
	}
	if (objectIDM.getSerializers().isEmpty()) {
%>
			<a href="objectidms.jsp?action=delete&oid=<%=objectIDM.getOid()%>">Delete</a>
<%} }%>
		</td>
	</tr>
<%
	}
%>
</table>
<script>
$(function(){
	$("input[name=\"default\"]").change(function(){
		document.location = "objectidms.jsp?action=setdefault&oid=" + $(this).attr("oid");
	});
});
</script>