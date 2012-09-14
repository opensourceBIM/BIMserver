<%@page import="org.bimserver.interfaces.objects.SModelMerger"%>
<%@page import="java.util.List"%>
<%@ include file="settingsmenu.jsp"%>
<%
if (request.getParameter("action") != null) {
	String action = request.getParameter("action");
	if (action.equals("enableModelMerger")) {
		SModelMerger modelMerger = loginManager.getService().getModelMergerByName(request.getParameter("modelMerger"));
		modelMerger.setEnabled(true);
		loginManager.getService().updateModelMerger(modelMerger);
	} else if (action.equals("disableModelMerger")) {
		SModelMerger modelMerger = loginManager.getService().getModelMergerByName(request.getParameter("modelMerger"));
		modelMerger.setEnabled(false);
		loginManager.getService().updateModelMerger(modelMerger);
	} else if (action.equals("setdefaultmodelmerger")) {
		loginManager.getService().setDefaultModelMerger(Long.parseLong(request.getParameter("oid")));
	}
	response.sendRedirect("modelmergers.jsp");
}
%>
<h1>Model Mergers</h1>
<a href="addmodelmerger.jsp">Add Model Merger</a>
<table class="formatted">
<tr><th>Name</th><th>Classname</th><th>Default</th><th>State</th><th>Actions</th></tr>
<%
	List<SModelMerger> modelMergers = service.getAllModelMergers(false);
	for (SModelMerger modelMerger : modelMergers) {
		boolean isDefault = service.getDefaultModelMerger() != null && service.getDefaultModelMerger().getOid() == modelMerger.getOid();
%>
	<tr>
		<td><a href="modelmerger.jsp?id=<%=modelMerger.getOid()%>"><%=modelMerger.getName() %></a></td>
		<td><%=modelMerger.getClassName() %></td>
		<td><input type="radio" name="default" oid="<%=modelMerger.getOid()%>" <%=service.getDefaultModelMerger() != null && service.getDefaultModelMerger().getOid() == modelMerger.getOid() ? "checked" : "" %>/></td>
		<td class="<%=modelMerger.getEnabled() ? "enabledModelMerger" : "disabledModelMerger" %>"> <%=modelMerger.getEnabled() ? "Enabled" : "Disabled" %></td>
		<td>
		<%
	if (!isDefault) {
	if (!modelMerger.getEnabled()) {
%>
<a href="modelmergers.jsp?action=enableModelMerger&modelMerger=<%=modelMerger.getName() %>">Enable</a>
<%
	} else {
%>
<a href="modelmergers.jsp?action=disableModelMerger&modelMerger=<%=modelMerger.getName() %>">Disable</a>
<%
	}
%>
			<a href="deletemodelmerger.jsp?ifid=<%=modelMerger.getOid()%>">Delete</a>
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
		document.location = "modelmergers.jsp?action=setdefaultmodelmerger&oid=" + $(this).attr("oid");
	});
});
</script>