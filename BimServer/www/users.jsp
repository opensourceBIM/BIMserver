<%@page import="java.util.List" %>
<%@page import="java.util.Collections"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.bimserver.interfaces.objects.SUser"%>
<%@ include file="header.jsp" %>

<%@page import="org.bimserver.shared.SUserNameComparator"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%@page import="org.bimserver.interfaces.objects.SObjectState"%>
<% if (loginManager.isLoggedIn() && loginManager.getUserType() == SUserType.ADMIN) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
%>

<div class="sidebar">
 <h4>Submenu</h4>
 <li>
 <a href="adduser.jsp">Add user</a></li>
</div>

<div class="content">
<h1>Users</h1>
<fieldset>
<table class="formatted">
<tr>
	<th>Name</th>
	<th>Username</th>
	<th>Created on</th>
	<th>Last seen</th>
	<th>Actions</th>
</tr>
<%
	List<SUser> users = loginManager.getService().getAllUsers();
	Collections.sort(users, new SUserNameComparator());
	for (SUser user : users) {
%>
<tr<%= user.getState() == SObjectState.DELETED ? " class=\"deleted\"" : "" %>>
	<td><a href="user.jsp?uoid=<%=user.getOid() %>"><%=user.getName() %></a></td>
	<td><a href="user.jsp?uoid=<%=user.getOid() %>"><%=user.getUsername() %></a></td>
	<td><%=dateFormat.format(user.getCreatedOn()) %></td>
	<td><%=dateFormat.format(user.getLastSeen()) %></td>
	<td>
<%
	if (user.getUserType() != SUserType.ADMIN && user.getUserType() != SUserType.ANONYMOUS) {
		if (user.getState() == SObjectState.ACTIVE) {
			%>
			<a href="deleteuser.jsp?uoid=<%=user.getOid() %>">delete</a>
			<%
		} else if (user.getState() == SObjectState.DELETED) {
			%>
			<a href="undeleteuser.jsp?uoid=<%=user.getOid() %>">undelete</a>
			<%	
		}
	}
%>
	</td>
</tr>
<%
	}
%>
</table>
<% } else {
	out.println("Insufficient rights");
}
%>
</fieldset>
</div>
<%@ include file="footer.jsp" %>