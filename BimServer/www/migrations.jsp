<%@page import="java.util.Set"%>
<%@page import="org.bimserver.shared.SMigration"%>
<%@page import="org.bimserver.shared.ServerException"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<jsp:include page="htmlheader.jsp" />
<%
	if (request.getParameter("migrate") != null) {
		try {
			loginManager.getService().migrateDatabase();
		} catch (ServerException e) {
			out.println("<div class=\"error\">" + e.getUserMessage() + "</div>");
		}
	}
	Set<SMigration> migrations = loginManager.getService().getPendingMigrations();
%>
<table>
<tr><th>Number</th><th>Description</th></tr>
<%
	for (SMigration migration : migrations) {
%>
	<tr>
		<td><%=migration.getNumber() %></td>
		<td><%=migration.getDescription() %></td>
	</tr>
<%
	}
%>
</table>
<form>
<input name="migrate" type="submit" value="Migrate"/>
</form>