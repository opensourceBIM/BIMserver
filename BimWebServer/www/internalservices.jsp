<%@page import="org.bimserver.interfaces.objects.SEService"%>
<%@page import="org.bimserver.interfaces.objects.SQueryEngine"%>
<%@page import="java.util.List"%>
<%@ include file="usersettingsmenu.jsp"%>
<%
if (request.getParameter("action") != null) {
	String action = request.getParameter("action");
	if (action.equals("enable")) {
		SEService seService = loginManager.getService().getEServiceById(Long.parseLong(request.getParameter("oid")));
		seService.setEnabled(true);
		loginManager.getService().updateSEService(seService);
	} else if (action.equals("disable")) {
		SEService seService = loginManager.getService().getEServiceById(Long.parseLong(request.getParameter("oid")));
		seService.setEnabled(false);
		loginManager.getService().updateSEService(seService);
	} else if (action.equals("delete")) {
		loginManager.getService().deleteEService(Long.parseLong(request.getParameter("oid")));
	}
	response.sendRedirect("internalservices.jsp");
}
%>
<h1>Internal Services</h1>
<a href="addinternalservice.jsp">Add Service</a>
<table class="formatted">
<tr><th>Name</th><th>Classname</th><th>State</th><th>Actions</th></tr>
<%
	List<SEService> services = service.getAllSEServices(false);
	for (SEService seService : services) {
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