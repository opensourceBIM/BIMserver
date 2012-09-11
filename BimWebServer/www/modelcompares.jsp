<%@page import="org.bimserver.interfaces.objects.SModelCompare"%>
<%@page import="java.util.List"%>
<%@ include file="settings.jsp"%>
<h1>Model Compares</h1>
<a href="addmodelcompare.jsp">Add Model Compare</a>
<table class="formatted">
<tr><th>Name</th><th>Classname</th><th>State</th><th>Actions</th></tr>
<%
	List<SModelCompare> modelCompares = service.getAllModelCompares(false);
	for (SModelCompare modelCompare : modelCompares) {
%>
	<tr>
		<td><a href="modelcompare.jsp?id=<%=modelCompare.getOid()%>"><%=modelCompare.getName() %></a></td>
		<td><%=modelCompare.getClassName() %></td>
		<td class="<%=modelCompare.getEnabled() ? "enabledModelCompare" : "disabledModelCompare" %>"> <%=modelCompare.getEnabled() ? "Enabled" : "Disabled" %></td>
		<td>
		<%
	if (!modelCompare.getEnabled()) {
%>
<a href="settings.jsp?action=enableModelCompare&modelCompare=<%=modelCompare.getName() %>">Enable</a>
<%
	} else {
%>
<a href="settings.jsp?action=disableModelCompare&modelCompare=<%=modelCompare.getName() %>">Disable</a>
<%
	}
%>
			<a href="deletemodelcompare.jsp?ifid=<%=modelCompare.getOid()%>">Delete</a>
		</td>
	</tr>
<%
	}
%>
</table>