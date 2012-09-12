<%@page import="org.bimserver.interfaces.objects.SModelMerger"%>
<%@page import="java.util.List"%>
<%@ include file="settings.jsp"%>
<h1>Model Mergers</h1>
<a href="addmodelmerger.jsp">Add Model Merger</a>
<table class="formatted">
<tr><th>Name</th><th>Classname</th><th>Default</th><th>State</th><th>Actions</th></tr>
<%
	List<SModelMerger> modelMergers = service.getAllModelMergers(false);
	for (SModelMerger modelMerger : modelMergers) {
%>
	<tr>
		<td><a href="modelmerger.jsp?id=<%=modelMerger.getOid()%>"><%=modelMerger.getName() %></a></td>
		<td><%=modelMerger.getClassName() %></td>
		<td><input type="radio" name="default" oid="<%=modelMerger.getOid()%>" <%=service.getDefaultModelMerger() != null && service.getDefaultModelMerger().getOid() == modelMerger.getOid() ? "checked" : "" %>/></td>
		<td class="<%=modelMerger.getEnabled() ? "enabledModelMerger" : "disabledModelMerger" %>"> <%=modelMerger.getEnabled() ? "Enabled" : "Disabled" %></td>
		<td>
		<%
	if (!modelMerger.getEnabled()) {
%>
<a href="settings.jsp?action=enableModelMerger&modelMerger=<%=modelMerger.getName() %>">Enable</a>
<%
	} else {
%>
<a href="settings.jsp?action=disableModelMerger&modelMerger=<%=modelMerger.getName() %>">Disable</a>
<%
	}
%>
			<a href="deletemodelmerger.jsp?ifid=<%=modelMerger.getOid()%>">Delete</a>
		</td>
	</tr>
<%
	}
%>
</table>
<script>
$(function(){
	$("input[name=\"default\"]").change(function(){
		$.ajax("setdefaultmodelmerger.jsp?oid=" + $(this).attr("oid"));
	});
});
</script>