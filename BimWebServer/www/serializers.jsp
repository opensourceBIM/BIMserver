<%@page import="org.bimserver.interfaces.objects.SSettings"%>
<%@page import="org.bimserver.interfaces.objects.SObjectIDM"%>
<%@page import="org.bimserver.interfaces.objects.SSerializer"%>
<%@page import="java.util.List"%>
<%@ include file="settingsmenu.jsp"%>
<h1>Serializers</h1>
<a href="addserializer1.jsp">Add Serializer</a>
<table class="formatted">
<tr><th>Name</th><th>Description</th><th>Type</th><th>Content Type</th><th>ObjectIDM</th><th>Render Engine</th><th>Default</th><th>State</th><th>Actions</th></tr>
<%
	if (request.getParameter("action") != null) {
		String action = request.getParameter("action");
		if (action.equals("disableSerializer")) {
			SSerializer serializer = loginManager.getService().getSerializerById(Long.parseLong(request.getParameter("oid")));
			serializer.setEnabled(false);
			loginManager.getService().updateSerializer(serializer);
		} else if (action.equals("enableSerializer")) {
			SSerializer serializer = loginManager.getService().getSerializerById(Long.parseLong(request.getParameter("oid")));
			serializer.setEnabled(true);
			loginManager.getService().updateSerializer(serializer);
		} else if (action.equals("setdefaultserializer")) {
			loginManager.getService().setDefaultSerializer(Long.parseLong(request.getParameter("oid")));
		}
		response.sendRedirect("serializers.jsp");
	}
	List<SSerializer> serializers = service.getAllSerializers(false);
	for (SSerializer serializer : serializers) {
		boolean isDefault = service.getDefaultSerializer() != null && service.getDefaultSerializer().getOid() == serializer.getOid();
		SObjectIDM objectIDM = null;
		if (serializer.getObjectIDMId() != -1) {
			objectIDM = service.getObjectIDMById(serializer.getObjectIDMId());
		}
		SIfcEngine ifcEngine = null;
		if (serializer.getIfcEngineId() != -1) {
			ifcEngine = service.getIfcEngineById(serializer.getIfcEngineId());
		}
%>
	<tr>
		<td><a href="serializer.jsp?id=<%=serializer.getOid()%>"><%=serializer.getName() %></a></td>
		<td><%=serializer.getDescription() %></td>
		<td><%=serializer.getClassName() %></td>
		<td><%=serializer.getContentType() %></td>
		<td><%=objectIDM == null ? "none" : objectIDM.getName() %></td>
		<td><%=ifcEngine == null ? "none" : ifcEngine.getName() %></td>
		<td><input type="radio" name="default"<%=serializer.getEnabled() ? "" : "disabled=\"disabled\"" %> oid="<%=serializer.getOid()%>" <%=isDefault ? "checked" : "" %>/></td>
		<td class="<%=serializer.getEnabled() ? "enabledSerializer" : "disabledSerializer" %>"> <%=serializer.getEnabled() ? "Enabled" : "Disabled" %></td>
		<td>
<%
	if (!isDefault) {
	if (serializer.getEnabled()) {
%>
<a href="serializers.jsp?action=disableSerializer&oid=<%=serializer.getOid() %>">Disable</a>
<%
	} else {
%>
<a href="serializers.jsp?action=enableSerializer&oid=<%=serializer.getOid() %>">Enable</a>
<%
	}
%>
			<a href="deleteserializer.jsp?sid=<%=serializer.getOid()%>">Delete</a>
<%
}
%>
		</td>
	</tr>
<%
	}
%>
</table>
<script>
$(function(){
	$("input[name=\"default\"]").change(function(){
		document.location = "serializers.jsp?action=setdefaultserializer&oid=" + $(this).attr("oid");
	});
});
</script>