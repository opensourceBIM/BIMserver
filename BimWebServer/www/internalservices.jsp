<%@page import="org.bimserver.interfaces.objects.SInternalServicePluginConfiguration"%>
<%@page import="java.util.List"%>
<%@ include file="usersettingsmenu.jsp"%>
<%
if (request.getParameter("action") != null) {
	String action = request.getParameter("action");
	if (action.equals("enable")) {
		SInternalServicePluginConfiguration seService = loginManager.getService(request).getInternalServiceById(Long.parseLong(request.getParameter("oid")));
		seService.setEnabled(true);
		loginManager.getService(request).updateInternalService(seService);
	} else if (action.equals("disable")) {
		SInternalServicePluginConfiguration seService = loginManager.getService(request).getInternalServiceById(Long.parseLong(request.getParameter("oid")));
		seService.setEnabled(false);
		loginManager.getService(request).updateInternalService(seService);
	} else if (action.equals("delete")) {
		loginManager.getService(request).deleteInternalService(Long.parseLong(request.getParameter("oid")));
	}
	response.sendRedirect("internalservices.jsp");
}
%>
<h1>Internal Services</h1>
<a href="addinternalservice.jsp">Add Service</a>
<table class="formatted">
<tr><th>Name</th><th>Classname</th><th>State</th><th>Actions</th></tr>
<%
	List<SInternalServicePluginConfiguration> services = service.getAllInternalServices(false);
	for (SInternalServicePluginConfiguration seService : services) {
%>
	<tr>
		<td><a href="internalservice.jsp?id=<%=seService.getOid()%>"><%=seService.getName() %></a></td>
		<td><%=seService.getClassName() %></td>
		<td class="<%=seService.getEnabled() ? "enabled" : "disabled" %>"> <%=seService.getEnabled() ? "Enabled" : "Disabled" %></td>
		<td>
		<%
	if (!seService.getEnabled()) {
%>
<a href="internalservices.jsp?action=enable&oid=<%=seService.getOid() %>">Enable</a>
<%
	} else {
%>
<a href="internalservices.jsp?action=disable&oid=<%=seService.getOid() %>">Disable</a>
<%
	}
%>
		<a href="internalservices.jsp?action=delete&oid=<%=seService.getOid()%>">Delete</a>
<%
	}
%>
		</td>
	</tr>
</table>