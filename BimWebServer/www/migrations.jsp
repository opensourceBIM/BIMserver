<%@page import="java.util.List"%>
<%@page import="org.bimserver.interfaces.objects.SMigration"%>
<%@page import="org.bimserver.shared.exceptions.ServiceException"%>
<%@page import="java.util.Set"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<%
if (!loginManager.getService().isLoggedIn()) {
	response.sendRedirect("login.jsp");
} else {
%>
<h1>Migrations</h1>
<%
	if (request.getParameter("migrate") != null) {
		try {
			loginManager.getService().migrateDatabase();
			response.sendRedirect("main.jsp");
		} catch (ServiceException e) {
			out.println("<div class=\"error\">" + e.getUserMessage() + "</div>");
		}
	}
	List<SMigration> migrations = loginManager.getService().getMigrations();
%>
<table class="formatted">
<tr><th>Number</th><th>Description</th><th>Executed</th></tr>
<%
	for (SMigration migration : migrations) {
%>
	<tr>
		<td><%=migration.getNumber() %></td>
		<td><%=migration.getDescription() %></td>
		<td><%=migration.isExecuted() %></td>
	</tr>
<%
	}
%>
</table>
<form method="post">
<%
	if (!migrations.iterator().next().isExecuted()) {
%>
<input name="migrate" type="submit" value="Migrate to <%=migrations.iterator().next().getNumber() %>"/>
<%	
	} else {
%>
No migrations required to execute
<%
	}
%>
</form>
<% } %>
</div>
<%@ include file="footer.jsp"%>