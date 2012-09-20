<%@page import="org.bimserver.interfaces.objects.SUser"%>
<%@page import="org.bimserver.interfaces.objects.SService"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<%@page import="org.bimserver.interfaces.objects.SExternalServer"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimwebserver.jsp.LoginManager" />
<%
	SProject project = loginManager.getService().getProjectByPoid(Long.parseLong(request.getParameter("oid")));
%>
			<a href="#" class="addServiceButton">Add service</a>
<% if (project.getServices().isEmpty()) { %>
<p>No configured services</p>
<% } else { %>
			<table>
				<tr><th>Server</th><th>Service</th><th>User</th><th>Description</th></tr><tr>
<%
	for (long epid : project.getServices()) {
		SService sService = loginManager.getService().getService(epid);
		SUser user = loginManager.getService().getUserByUoid(sService.getUserId());
%>
	<tr>
	<td><%=sService.getUrl() %></td>
	<td><%=sService.getName() %></td>
	<td><%=user.getName() %></td>
	<td><%=sService.getDescription() %></td>
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