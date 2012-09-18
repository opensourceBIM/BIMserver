<%@page import="org.bimserver.interfaces.objects.SProject"%>
<%@page import="org.bimserver.interfaces.objects.SExternalServer"%>
<%@page import="org.bimserver.interfaces.objects.SExternalProfile"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<%
	SProject project = loginManager.getService().getProjectByPoid(Long.parseLong(request.getParameter("oid")));
%>
			<a href="#" class="addServiceButton">Add service</a>
<% if (project.getProfiles().isEmpty()) { %>
<p>No configured services</p>
<% } else { %>
			<table>
				<tr><th>Server</th><th>Profile</th><th>Description</th></tr><tr>
<%
	for (long epid : project.getProfiles()) {
		SExternalProfile profile = loginManager.getService().getExternalProfile(epid);
		SExternalServer externalServer = loginManager.getService().getExternalServer(profile.getServerId());
%>
	<tr><td><%=externalServer.getTitle() %></td><td><%=profile.getName() %></td><td><%=profile.getDescription() %></td></tr>
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