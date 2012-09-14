<%@page import="org.bimserver.interfaces.objects.SObjectIDM"%>
<%@page import="java.util.List"%>
<%@ include file="settingsmenu.jsp"%>
<%		
if (request.getParameter("action") != null) {
	String action = request.getParameter("action");
	if (action.equals("disableObjectIDM")) {
		SObjectIDM objectIDM = loginManager.getService().getObjectIDMById(Long.parseLong(request.getParameter("oid")));
		objectIDM.setEnabled(false);
		loginManager.getService().updateObjectIDM(objectIDM);
	} else if (action.equals("enableObjectIDM")) {
		SObjectIDM objectIDM = loginManager.getService().getObjectIDMById(Long.parseLong(request.getParameter("oid")));
		objectIDM.setEnabled(true);
		loginManager.getService().updateObjectIDM(objectIDM);
	} else if (action.equals("setdefaultobjectidm")) {
		loginManager.getService().setDefaultObjectIDM(Long.parseLong(request.getParameter("oid")));
	}
	response.sendRedirect("objectidms.jsp");
}
%>
<h1>Object IDMs</h1>
<a href="addobjectidm.jsp">Add ObjectIDM</a>
<table class="formatted">
<tr><th>Name</th><th>Classname</th><th>Serializers</th><th>Default</th><th>State</th><th>Actions</th></tr>
<%
	List<SObjectIDM> objectIDMs = service.getAllObjectIDMs(false);
	for (SObjectIDM objectIDM : objectIDMs) {
		boolean isDefault = service.getDefaultObjectIDM() != null && service.getDefaultObjectIDM().getOid() == objectIDM.getOid();
%>
	<tr>
		<td><a href="objectidm.jsp?id=<%=objectIDM.getOid()%>"><%=objectIDM.getName() %></a></td>
		<td><%=objectIDM.getClassName() %></td>
		<td><%=objectIDM.getSerializers().size() %></td>
		<td><input type="radio" name="default"<%=objectIDM.getEnabled() ? "" : "disabled=\"disabled\"" %> oid="<%=objectIDM.getOid()%>" <%=service.getDefaultObjectIDM() != null && service.getDefaultObjectIDM().getOid() == objectIDM.getOid() ? "checked" : "" %>/></td>
		<td class="<%=objectIDM.getEnabled() ? "enabledObjectIDM" : "disabledObjectIDM" %>"> <%=objectIDM.getEnabled() ? "Enabled" : "Disabled" %></td>
		<td>
		<%
	if (!isDefault) {
	if (!objectIDM.getEnabled()) {
%>
<a href="objectidms.jsp?action=enableObjectIDM&oid=<%=objectIDM.getOid() %>">Enable</a>
<%
	} else if (objectIDM.getSerializers().isEmpty()) {
%>
<a href="objectidms.jsp?action=disableObjectIDM&oid=<%=objectIDM.getOid() %>">Disable</a>
<%
	}
	if (objectIDM.getSerializers().isEmpty()) {
%>
			<a href="deleteobjectidm.jsp?ifid=<%=objectIDM.getOid()%>">Delete</a>
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
		document.location = "objectidms.jsp?action=setdefaultobjectidm&oid=" + $(this).attr("oid");
	});
});
</script>