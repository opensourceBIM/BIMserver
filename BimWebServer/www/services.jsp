<%@page import="org.bimserver.interfaces.objects.SUser"%>
<%@page import="org.bimserver.interfaces.objects.SService"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimwebserver.jsp.LoginManager" />
<%
	if (request.getParameter("action") != null) {
		String action = request.getParameter("action");
		if (action.equals("delete")) {
			loginManager.getService(request).deleteService(Long.parseLong(request.getParameter("oid")));
			response.sendRedirect("project.jsp?poid=" + request.getParameter("poid"));
		}
	}

	SProject project = loginManager.getService(request).getProjectByPoid(Long.parseLong(request.getParameter("poid")));
%>
			<a href="#" class="addServiceButton">Add service</a>
<% if (project.getServices().isEmpty()) { %>
<p>No configured services</p>
<% } else { %>
			<table>
				<tr><th>Server</th><th>Service</th><th>User</th><th>Description</th><th>Actions</th></tr>
<%
	for (long epid : project.getServices()) {
		SService sService = loginManager.getService(request).getService(epid);
		SUser user = loginManager.getService(request).getUserByUoid(sService.getUserId());
%>
	<tr>
	<td><%=sService.getUrl() %></td>
	<td><%=sService.getName() %></td>
	<td><%=user.getName() %></td>
	<td><%=sService.getDescription() %></td>
	<td>
<% if (sService.getUserId() == loginManager.getUoid()) { %>
<a href="services.jsp?action=delete&poid=<%=project.getOid() %>&oid=<%=sService.getOid() %>">Delete</a>
<% } %>
	</td>
	</tr>
<%
	}
%>
			</table>
<% } %>
<script>
$(function(){
	$(".addServiceButton").click(function(event){
		event.preventDefault();
		$("#servicestab").load("addservice.jsp?oid=<%=project.getOid()%>");
	});
});
</script>