<%@page import="org.bimwebserver.jsp.SProjectComparator"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.List" %>
<%@page import="java.text.DateFormat" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="org.bimserver.utils.Formatters"%>
<%@page import="java.util.Collections"%>
<%@page import="org.bimserver.shared.exceptions.ServiceException"%>
<%@page import="org.bimserver.interfaces.objects.SUser"%>
<%@page import="org.bimserver.interfaces.objects.SRevision"%>
<%@page import="org.bimserver.interfaces.objects.SCheckout"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<%@page import="org.bimserver.shared.comparators.SCheckoutDateComparator"%>
<%@page import="org.bimserver.shared.comparators.SProjectNameComparator"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%@page import="org.bimwebserver.jsp.JspHelper"%>
<%@page import="java.util.Comparator"%>
<%@page import="org.bimserver.shared.interfaces.ServiceInterface"%>
<%@page import="org.bimserver.shared.comparators.SRevisionDateComparator"%>
<%@page import="org.bimserver.interfaces.objects.SObjectState"%>
<%@page import="org.bimserver.interfaces.objects.SSerializerPluginConfiguration"%>
<%@ include file="header.jsp" %>
<%
	long uoid = Long.parseLong(request.getParameter("uoid"));
	SUser user = loginManager.getService(request).getUserByUoid(uoid);
	boolean allowEdit = (loginManager.getUserType() == SUserType.ADMIN && user.getUserType() != SUserType.SYSTEM) || uoid == loginManager.getUoid();
%>
<div class="sidebar">
 <ul>
<% if (allowEdit) { %>
 <li><a href="edituser.jsp?uoid=<%=uoid%>">Edit</a></li>
 <li><a href="changepassword.jsp?uoid=<%=uoid%>">Change password</a></li>
<% } %>
<jsp:include page="showdeleted.jsp"/>
 </ul>
</div>
<div class="content">
<div id="downloadcheckoutpopup"></div>
<%
	if (loginManager.isLoggedIn()) {
		try {
	if (request.getParameter("mid") != null) {
		out.println("<div class=\"success\">" + request.getParameter("message") + "</div>");
	}
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	List<SRevision> revisions = loginManager.getService(request).getAllRevisionsByUser(user.getOid());
	Collections.sort(revisions, new SRevisionDateComparator(false));
	List<SCheckout> checkouts = loginManager.getService(request).getAllCheckoutsByUser(user.getOid());
	Collections.sort(checkouts, new SCheckoutDateComparator(false));
	List<SProject> projects = loginManager.getService(request).getUsersProjects(uoid);
	Collections.sort(projects, new SProjectComparator(loginManager.getService(request)));
	List<SProject> nonAuthorizedProjects = loginManager.getService(request).getAllNonAuthorizedProjectsOfUser(user.getOid());
	final ServiceInterface service = loginManager.getService(request);
	Collections.sort(nonAuthorizedProjects, new SProjectComparator(loginManager.getService(request)));
%>
<h1>User details (<%=user.getName() %>)</h1>
<div class="tabber" id="usertabber">
  <div class="tabbertab" id="detailstab" title="Details">
<table class="formtable">
<tr><td class="first">Name</td><td><%=user.getName() %></td></tr>
<tr><td class="first">Username</td><td><%=user.getUsername() %></td></tr>
<tr><td class="first">Created on</td><td><%=dateFormat.format(user.getCreatedOn()) %></td></tr>
<tr><td class="first">Last seen</td><td><%=user.getLastSeen() == null ? "never" : dateFormat.format(user.getLastSeen()) %></td></tr>
<tr><td class="first">State</td><td><%=user.getState().name().toLowerCase() %></td></tr>
<tr><td class="first">Type</td><td><%=JspHelper.getNiceUserTypeName(user.getUserType()) %></td></tr>
<% SUser currentUser = loginManager.getService(request).getUserByUoid(loginManager.getUoid());
if (allowEdit) { %>
<tr><td class="first">Change password</td><td><a href="changepassword.jsp?uoid=<%=uoid%>">Change password</a></td></tr>
<% }
	SUser creater = loginManager.getService(request).getUserByUoid(user.getCreatedById());
	if (creater != null) {
%>
<tr><td class="first">Created by</td><td><a href="user.jsp?uoid=<%=creater.getOid()%>"><%=creater.getUsername() %></a></td></tr>
<%
	}
%>
</table>
  </div>
  <div class="tabbertab" id="revisionstab" title="Revisions<%=revisions.size() == 0 ? "" : " (" + revisions.size() + ")" %>">
<%
	if (revisions.size() > 0) {
%>
<table class="formatted">
<tr>
	<th>Project</th>
	<th>Revision Id</th>
	<th>Date</th>
	<th>Comment</th>
	<th>Size</th>
	<th>Download/Checkout</th>
</tr>
<%
		for (SRevision revision : revisions) {
			SProject sProject = loginManager.getService(request).getProjectByPoid(revision.getProjectId());
%>
<tr>
	<td><a href="project.jsp?poid=<%=revision.getProjectId() %>"><%=sProject.getName() %></a></td>
	<td><a href="revision.jsp?roid=<%=revision.getOid() %>"><%=revision.getId() %></a></td>
	<td><%=dateFormat.format(revision.getDate()) %></td>
	<td><%=revision.getComment() %></td>
	<td><%=revision.getSize() %></td>
	<td>
		<a class="downloadCheckoutButton" revisionoid="<%=revision.getOid() %>">Download</a>
	</td>
</tr>
<%
		}
%>
</table>
<%
	} else {
%>
<div class="none">None</div>
<%		
	}
%>
</div>
<div class="tabbertab" id="checkoutstab" title="Checkouts<%=checkouts.size() == 0 ? "" : " (" + checkouts.size() + ")" %>">
<%
	if (checkouts.size() > 0) {
%>
<table class="formatted">
<tr>
	<th>Project</th>
	<th>Revision Id</th>
	<th>Date</th>
	<th>Download/Checkout</th>
</tr>
<%
		for (SCheckout checkout : checkouts) {
			SProject sProject = loginManager.getService(request).getProjectByPoid(checkout.getProjectId());
			SRevision sRevision = loginManager.getService(request).getRevision(checkout.getRevisionId());
%>
<tr>
	<td><a href="project.jsp?poid=<%=checkout.getProjectId() %>"><%=sProject.getName() %></a></td>
	<td><a href="revision.jsp?roid=<%=sRevision.getOid() %>"><%=sRevision.getId() %></a></td>
	<td><%=dateFormat.format(checkout.getDate()) %></td>
	<td>
		<a href="#" class="downloadCheckoutButton" revisionoid="<%=checkout.getRevisionId() %>">Download</a>
	</td>
</tr>
<%
		}
%>
</table>
<%
	} else {
%>
<div class="none">None</div>
<%
	}
%>
</div>
<div class="tabbertab" id="projectstab" title="Projects<%=projects.size() == 0 ? "" : " (" + projects.size() + ")" %>">
<% if (nonAuthorizedProjects.size() > 0 && loginManager.getUserType() == SUserType.ADMIN) { %>
<form method="post" action="addusertoproject.jsp">
<select name="poid">
<%
	for (SProject project : nonAuthorizedProjects) {
%>
<option value="<%=project.getOid() %>"><%=JspHelper.completeProjectName(loginManager.getService(request), project) %></option>
<%
	}
%>
</select>
<input type="hidden" name="uoid" value="<%=uoid %>"/>
<input type="hidden" name="type" value="user"/>
<input type="submit" value="Add"/>
</form>
<% } %>
<%
	if (projects.size() > 0) {
%>
<table class="formatted">
<tr>
	<th>Project</th>
	<th>Actions</th>
</tr>
<%
		for (SProject project : projects) {
%>
<tr<%= project.getState() == SObjectState.DELETED ? " class=\"deleted\"" : "" %>>
	<td><a href="project.jsp?poid=<%=project.getOid() %>"><%=JspHelper.completeProjectName(loginManager.getService(request), project) %></a></td>
	<td><% if (loginManager.getUserType() == SUserType.ADMIN && user.getUserType() != SUserType.ADMIN) { %><a href="revokepermission.jsp?type=user&amp;poid=<%=project.getOid() %>&amp;uoid=<%=uoid %>">revoke</a><% } %></td>
</tr>
<%
		}
%>
</table>
<%
	} else {
%>
<div class="none">None</div>
<%
	}
%>
</div>
</div>
<% 
	} catch (ServiceException e) {
		JspHelper.showException(out, e);
	}
}
%>
</div>
<script>
$(function(){
	$(".downloadCheckoutButton").click(function(event){
		event.preventDefault();
		var params = {
			downloadType: "single",
			allowCheckouts: true,
			roid: $(this).attr("revisionoid"),
		};
		showDownloadCheckoutPopup(params);
	});
});
</script>
<%@ include file="footer.jsp" %>