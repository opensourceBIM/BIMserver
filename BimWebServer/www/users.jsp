<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="org.bimserver.shared.comparators.SUserNameComparator"%>
<%@page import="java.util.List" %>
<%@page import="java.util.Collections"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.bimserver.interfaces.objects.SUser"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%@page import="org.bimserver.interfaces.objects.SObjectState"%>
<%@page import="org.bimwebserver.jsp.JspHelper"%>
<%@ include file="header.jsp" %>
<% if (loginManager.isLoggedIn() && loginManager.getUserType() == SUserType.ADMIN) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
%>
<div class="sidebar">
<ul>
<li>
<a href="adduser.jsp">Add user</a></li>
<jsp:include page="showdeleted.jsp"/>
</ul>
</div>

<div class="content">
<h1>Users</h1>
<table class="formatted">
<tr>
	<th>Name</th>
	<th>Username</th>
	<th>Type</th>
	<th>Created on</th>
	<th>Last login</th>
	<th>Actions</th>
</tr>
<%
	List<SUser> users = loginManager.getService(request).getAllUsers();
	Collections.sort(users, new SUserNameComparator());
	for (SUser user : users) {
%>
<tr<%= user.getState() == SObjectState.DELETED ? " class=\"deleted\"" : "" %>>
	<td><a href="user.jsp?uoid=<%=user.getOid() %>"><%=user.getName() %></a></td>
	<td><a href="user.jsp?uoid=<%=user.getOid() %>"><%=user.getUsername() %></a></td>
	<td><%=JspHelper.getNiceUserTypeName(user.getUserType()) %></td>
	<td><%=dateFormat.format(user.getCreatedOn()) %></td>
	<td><%=user.getLastSeen() == null ? "never" : dateFormat.format(user.getLastSeen()) %></td>
	<td>
<%
	if (user.getUserType() != SUserType.ADMIN && user.getUserType() != SUserType.SYSTEM) {
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
</div>
<%@ include file="footer.jsp" %>