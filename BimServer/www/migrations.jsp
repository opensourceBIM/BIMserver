<%@page import="java.util.Set"%>
<%@page import="org.bimserver.shared.SMigration"%>
<%@page import="org.bimserver.shared.ServerException"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<jsp:include page="htmlheader.jsp" />
<body>
<div style="width: 1000px; margin-left: auto; margin-right: auto; padding-top: 20px">
<h1>BIMserver Database Migrations</h1>
<%
	if (request.getParameter("migrate") != null) {
		try {
			loginManager.getService().migrateDatabase();
		} catch (ServerException e) {
			out.println("<div class=\"error\">" + e.getUserMessage() + "</div>");
		}
	}
	Set<SMigration> migrations = loginManager.getService().getMigrations();
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
<form>
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
</div>
</body>