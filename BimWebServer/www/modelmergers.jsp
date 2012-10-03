<%@page import="org.bimserver.interfaces.objects.SModelMergerPluginConfiguration"%>
<%@page import="java.util.List"%>
<%@ include file="usersettingsmenu.jsp"%>
<%
if (request.getParameter("action") != null) {
	String action = request.getParameter("action");
	if (action.equals("enable")) {
		SModelMergerPluginConfiguration modelMerger = loginManager.getService(request).getModelMergerById(Long.parseLong(request.getParameter("oid")));
		modelMerger.setEnabled(true);
		loginManager.getService(request).updateModelMerger(modelMerger);
	} else if (action.equals("disable")) {
		SModelMergerPluginConfiguration modelMerger = loginManager.getService(request).getModelMergerById(Long.parseLong(request.getParameter("oid")));
		modelMerger.setEnabled(false);
		loginManager.getService(request).updateModelMerger(modelMerger);
	} else if (action.equals("setdefault")) {
		loginManager.getService(request).setDefaultModelMerger(Long.parseLong(request.getParameter("oid")));
	} else if (action.equals("delete")) {
		loginManager.getService(request).deleteModelMerger(Long.parseLong(request.getParameter("oid")));
	}
	response.sendRedirect("modelmergers.jsp");
}
%>
<h1>Model Mergers</h1>
<a href="addmodelmerger.jsp">Add Model Merger</a>
<table class="formatted">
<tr><th>Name</th><th>Classname</th><th>Default</th><th>State</th><th>Actions</th></tr>
<%
	List<SModelMergerPluginConfiguration> modelMergers = service.getAllModelMergers(false);
	for (SModelMergerPluginConfiguration modelMerger : modelMergers) {
		boolean isDefault = service.getDefaultModelMerger() != null && service.getDefaultModelMerger().getOid() == modelMerger.getOid();
%>
	<tr>
		<td><a href="modelmerger.jsp?id=<%=modelMerger.getOid()%>"><%=modelMerger.getName() %></a></td>
		<td><%=modelMerger.getClassName() %></td>
		<td><input type="radio" name="default"<%=modelMerger.getEnabled() ? "" : "disabled=\"disabled\"" %> oid="<%=modelMerger.getOid()%>" <%=service.getDefaultModelMerger() != null && service.getDefaultModelMerger().getOid() == modelMerger.getOid() ? "checked" : "" %>/></td>
		<td class="<%=modelMerger.getEnabled() ? "enabled" : "disabled" %>"> <%=modelMerger.getEnabled() ? "Enabled" : "Disabled" %></td>
		<td>
		<%
	if (!isDefault) {
	if (!modelMerger.getEnabled()) {
%>
<a href="modelmergers.jsp?action=enable&oid=<%=modelMerger.getOid() %>">Enable</a>
<%
	} else {
%>
<a href="modelmergers.jsp?action=disable&oid=<%=modelMerger.getOid() %>">Disable</a>
<%
	}
%>
			<a href="modelmergers.jsp?action=delete&oid=<%=modelMerger.getOid()%>">Delete</a>
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
		document.location = "modelmergers.jsp?action=setdefault&oid=" + $(this).attr("oid");
	});
});
</script>