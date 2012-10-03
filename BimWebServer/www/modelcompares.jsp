<%@page import="org.bimserver.interfaces.objects.SModelComparePluginConfiguration"%>
<%@page import="java.util.List"%>
<%@ include file="usersettingsmenu.jsp"%>
<%
if (request.getParameter("action") != null) {
	String action = request.getParameter("action");
	if (action.equals("enable")) {
		SModelComparePluginConfiguration modelCompare = loginManager.getService(request).getModelCompareById(Long.parseLong(request.getParameter("oid")));
		modelCompare.setEnabled(true);
		loginManager.getService(request).updateModelCompare(modelCompare);
	} else if (action.equals("disable")) {
		SModelComparePluginConfiguration modelCompare = loginManager.getService(request).getModelCompareById(Long.parseLong(request.getParameter("oid")));
		modelCompare.setEnabled(false);
		loginManager.getService(request).updateModelCompare(modelCompare);
	} else if (action.equals("setdefault")) {
		loginManager.getService(request).setDefaultModelCompare(Long.parseLong(request.getParameter("oid")));
	} else if (action.equals("delete")) {
		loginManager.getService(request).deleteModelCompare(Long.parseLong(request.getParameter("oid")));
	}
	response.sendRedirect("modelcompares.jsp");
}
%><h1>Model Compares</h1>
<a href="addmodelcompare.jsp">Add Model Compare</a>
<table class="formatted">
<tr><th>Name</th><th>Classname</th><th>Default</th><th>State</th><th>Actions</th></tr>
<%
	List<SModelComparePluginConfiguration> modelCompares = service.getAllModelCompares(false);
	for (SModelComparePluginConfiguration modelCompare : modelCompares) {
		boolean isDefault = service.getDefaultModelCompare() != null && service.getDefaultModelCompare().getOid() == modelCompare.getOid();
%>
	<tr>
		<td><a href="modelcompare.jsp?id=<%=modelCompare.getOid()%>"><%=modelCompare.getName() %></a></td>
		<td><%=modelCompare.getClassName() %></td>
		<td><input type="radio" name="default"<%=modelCompare.getEnabled() ? "" : "disabled=\"disabled\"" %> oid="<%=modelCompare.getOid()%>" <%=service.getDefaultModelCompare() != null && service.getDefaultModelCompare().getOid() == modelCompare.getOid() ? "checked" : "" %>/></td>
		<td class="<%=modelCompare.getEnabled() ? "enabled" : "disabled" %>"> <%=modelCompare.getEnabled() ? "Enabled" : "Disabled" %></td>
		<td>
		<%
	if (!isDefault) {
	if (!modelCompare.getEnabled()) {
%>
<a href="modelcompares.jsp?action=enable&oid=<%=modelCompare.getOid() %>">Enable</a>
<%
	} else {
%>
<a href="modelcompares.jsp?action=disable&oid=<%=modelCompare.getOid() %>">Disable</a>
<%
	}
%>
			<a href="modelcompares.jsp?action=delete&oid=<%=modelCompare.getOid()%>">Delete</a>
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
		document.location = "modelcompares.jsp?action=setdefault&oid=" + $(this).attr("oid");
	});
});
</script>