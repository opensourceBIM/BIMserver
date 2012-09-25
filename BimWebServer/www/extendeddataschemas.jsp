<%@page import="org.bimserver.shared.interfaces.ServiceInterface"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%@page import="org.bimserver.interfaces.objects.SExtendedDataSchema"%>
<%@page import="java.util.List"%>
<%@ include file="header.jsp" %>
<%@ include file="serversettingsmenu.jsp"%>
<% 
	if (loginManager.isLoggedIn() && loginManager.getUserType() == SUserType.ADMIN) {
		ServiceInterface service = loginManager.getService();
%>
<div class="content">
<h1>Extended Data Schemas</h1>
<a href="addextendeddataschema.jsp">Add Extended Data Schema</a>
<table class="formatted">
<tr><th>Name</th><th>URL/Data</th><th>Namespace</th><th>Validate</th><th>Type</th><th>Used</th></tr>
<%
	List<SExtendedDataSchema> extendedDataSchemas = service.getAllExtendedDataSchemas();
	for (SExtendedDataSchema extendedDataSchema : extendedDataSchemas) {
%>
	<tr>
		<td><%=extendedDataSchema.getName() %></a></td>
		<td><%=(extendedDataSchema.getData() != null && extendedDataSchema.getData().length > 0) ? (extendedDataSchema.getData().length + " bytes") : extendedDataSchema.getUrl() %></td>
		<td><%=extendedDataSchema.getNamespace() %></td>
		<td><%=extendedDataSchema.isValidate() %></td>
		<td><%=extendedDataSchema.getType().name() %></td>
		<td><%=extendedDataSchema.getExtendedData().size() %></td>
	</tr>
<%
}
%>
</table>
<%
}
%>