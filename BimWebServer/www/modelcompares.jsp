<%@page import="org.bimserver.interfaces.objects.SModelCompare"%>
<%@page import="java.util.List"%>
<%@ include file="usersettings.jsp"%>
<%
if (request.getParameter("action") != null) {
	String action = request.getParameter("action");
	if (action.equals("enableModelCompare")) {
		SModelCompare modelCompare = loginManager.getService().getModelCompareById(Long.parseLong(request.getParameter("oid")));
		modelCompare.setEnabled(true);
		loginManager.getService().updateModelCompare(modelCompare);
	} else if (action.equals("disableModelCompare")) {
		SModelCompare modelCompare = loginManager.getService().getModelCompareById(Long.parseLong(request.getParameter("oid")));
		modelCompare.setEnabled(false);
		loginManager.getService().updateModelCompare(modelCompare);
	} else if (action.equals("setdefaultmodelcompare")) {
		loginManager.getService().setDefaultModelCompare(Long.parseLong(request.getParameter("oid")));
	}
	response.sendRedirect("modelcompares.jsp");
}
%><h1>Model Compares</h1>
<a href="addmodelcompare.jsp">Add Model Compare</a>
<table class="formatted">
<tr><th>Name</th><th>Classname</th><th>Default</th><th>State</th><th>Actions</th></tr>
<%
	List<SModelCompare> modelCompares = service.getAllModelCompares(false);
	for (SModelCompare modelCompare : modelCompares) {
		boolean isDefault = service.getDefaultModelCompare() != null && service.getDefaultModelCompare().getOid() == modelCompare.getOid();
%>
	<tr>
		<td><a href="modelcompare.jsp?id=<%=modelCompare.getOid()%>"><%=modelCompare.getName() %></a></td>
		<td><%=modelCompare.getClassName() %></td>
		<td><input type="radio" name="default"<%=modelCompare.getEnabled() ? "" : "disabled=\"disabled\"" %> oid="<%=modelCompare.getOid()%>" <%=service.getDefaultModelCompare() != null && service.getDefaultModelCompare().getOid() == modelCompare.getOid() ? "checked" : "" %>/></td>
		<td class="<%=modelCompare.getEnabled() ? "enabledModelCompare" : "disabledModelCompare" %>"> <%=modelCompare.getEnabled() ? "Enabled" : "Disabled" %></td>
		<td>
		<%
	if (!isDefault) {
	if (!modelCompare.getEnabled()) {
%>
<a href="modelcompares.jsp?action=enableModelCompare&oid=<%=modelCompare.getOid() %>">Enable</a>
<%
	} else {
%>
<a href="modelcompares.jsp?action=disableModelCompare&oid=<%=modelCompare.getOid() %>">Disable</a>
<%
	}
%>
			<a href="deletemodelcompare.jsp?ifid=<%=modelCompare.getOid()%>">Delete</a>
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
		document.location = "modelcompares.jsp?action=setdefaultmodelcompare&oid=" + $(this).attr("oid");
	});
});
</script>