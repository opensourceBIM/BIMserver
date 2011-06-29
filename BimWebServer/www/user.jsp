<%@page import="java.util.List" %>
<%@page import="java.text.DateFormat" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="org.bimserver.utils.Formatters"%>
<%@page import="java.util.Collections"%>
<%@page import="org.bimserver.Message"%>
<%@page import="org.bimserver.shared.UserException"%>
<%@page import="org.bimserver.interfaces.objects.SUser"%>
<%@page import="org.bimserver.interfaces.objects.SRevision"%>
<%@page import="org.bimserver.interfaces.objects.SCheckout"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<%@page import="org.bimserver.shared.SCheckoutDateComparator"%>
<%@page import="org.bimserver.shared.SProjectNameComparator"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%@page import="org.bimserver.web.JspHelper"%>
<%@page import="java.util.Comparator"%>
<%@page import="org.bimserver.web.SProjectComparator"%>
<%@page import="org.bimserver.shared.ServiceInterface"%>
<%@page import="org.bimserver.shared.SRevisionDateComparator"%>
<%@page import="org.bimserver.interfaces.objects.SObjectState"%>
<%@ include file="header.jsp" %>
<%
	long uoid = Long.parseLong(request.getParameter("uoid"));
	SUser user = loginManager.getService().getUserByUoid(uoid);
	boolean allowEdit = (loginManager.getUserType() == SUserType.ADMIN && user.getUserType() != SUserType.SYSTEM) || uoid == loginManager.getUoid();
%>

<%@page import="org.bimserver.interfaces.objects.SSerializer"%><div class="sidebar">
 <ul>
<% if (allowEdit) { %>
 <li><a href="edituser.jsp?uoid=<%=uoid%>">Edit</a></li>
 <li><a href="changepassword.jsp?uoid=<%=uoid%>">Change password</a></li>
<% } %>
<jsp:include page="showdeleted.jsp"/>
 </ul>
</div>
<div class="content">
<%
	if (loginManager.getService().isLoggedIn()) {
		try {
	if (request.getParameter("mid") != null) {
		out.println("<div class=\"success\">" + Message.get(Integer.parseInt(request.getParameter("mid"))) + "</div>");
	}
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	List<SRevision> revisions = loginManager.getService().getAllRevisionsByUser(user.getOid());
	Collections.sort(revisions, new SRevisionDateComparator(false));
	List<SCheckout> checkouts = loginManager.getService().getAllCheckoutsByUser(user.getOid());
	Collections.sort(checkouts, new SCheckoutDateComparator(false));
	List<SProject> projects = loginManager.getService().getUsersProjects(uoid);
	Collections.sort(projects, new SProjectComparator(loginManager.getService()));
	List<SProject> nonAuthorizedProjects = loginManager.getService().getAllNonAuthorizedProjectsOfUser(user.getOid());
	final ServiceInterface service = loginManager.getService();
	Collections.sort(nonAuthorizedProjects, new SProjectComparator(loginManager.getService()));
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
<% SUser currentUser = loginManager.getService().getUserByUoid(loginManager.getUoid());
if (allowEdit) { %>
<tr><td class="first">Change password</td><td><a href="changepassword.jsp?uoid=<%=uoid%>">Change password</a></td></tr>
<% }
	SUser creater = loginManager.getService().getUserByUoid(user.getCreatedById());
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
	<th>Download / Checkout</th>
</tr>
<%
		for (SRevision revision : revisions) {
			SProject sProject = loginManager.getService().getProjectByPoid(revision.getProjectId());
%>
<tr>
	<td><a href="project.jsp?poid=<%=revision.getProjectId() %>"><%=sProject.getName() %></a></td>
	<td><a href="revision.jsp?roid=<%=revision.getOid() %>"><%=revision.getId() %></a></td>
	<td><%=dateFormat.format(revision.getDate()) %></td>
	<td><%=revision.getComment() %></td>
	<td><%=revision.getSize() %></td>
	<td>
	<form method="get" action="<%=request.getContextPath() %>/download">
	<input type="hidden" name="roid" value="<%=revision.getOid() %>"/>
	<select name="resultType" class="revisionsdownloadcheckoutselect">
	<%
		for (SSerializer serializer : loginManager.getService().getEnabledSerializers()) {
	%>
	<option value="<%=serializer.getName()%>"
		<%=serializer.isDefaultSerializer() ? " SELECTED=\"SELECTED\"" : ""%>><%=serializer.getName()%></option>
	<%
		}
	%>
	</select> <label for="zip_<%=revision.getId() %>">Zip</label> <input type="checkbox" name="zip" id="zip_<%=revision.getId() %>"/> 
	<input name="download" type="submit" value="Download"/>
<% 
	boolean userHasCheckinRights = loginManager.getService().userHasCheckinRights(sProject.getOid());
if (userHasCheckinRights) { %>
	<input name="checkout" type="submit" value="Checkout" class="revisionscheckoutbutton"/>
<% } %>
	</form>
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
	<th>Download / Checkout</th>
</tr>
<%
		for (SCheckout checkout : checkouts) {
			SProject sProject = loginManager.getService().getProjectByPoid(checkout.getProjectId());
			SRevision sRevision = loginManager.getService().getRevision(checkout.getRevisionId());
%>
<tr>
	<td><a href="project.jsp?poid=<%=checkout.getProjectId() %>"><%=sProject.getName() %></a></td>
	<td><a href="revision.jsp?roid=<%=sRevision.getOid() %>"><%=sRevision.getId() %></a></td>
	<td><%=dateFormat.format(checkout.getDate()) %></td>
	<td>
	<form method="get" action="<%=request.getContextPath() %>/download">
	<input type="hidden" name="roid" value="<%=checkout.getRevisionId() %>"/>
	<select name="resultType">
	<%
		for (SSerializer serializer : loginManager.getService().getEnabledSerializers()) {
	%>
	<option value="<%=serializer.getName()%>"
		<%=serializer.isDefaultSerializer() ? " SELECTED=\"SELECTED\"" : ""%>><%=serializer.getName()%></option>
	<%
		}
	%>
	</select> <label for="zip_<%=checkout.getOid() %>">Zip</label> <input type="checkbox" name="zip" id="zip_<%=checkout.getOid() %>"/> <input name="download" type="submit" value="Download"/>
	</form>
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
<option value="<%=project.getOid() %>"><%=JspHelper.completeProjectName(loginManager.getService(), project) %></option>
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
	<td><a href="project.jsp?poid=<%=project.getOid() %>"><%=JspHelper.completeProjectName(loginManager.getService(), project) %></a></td>
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
	} catch (UserException e) {
		out.println("<div class=\"error\">" + e.getUserMessage() + "</div>");
	}
}
%>
</div>
<script>
	$(document).ready(function(){
		checkRevisionsCheckoutButton = function(event){
			$(event.target).parent().children(".revisionscheckoutbutton").attr("disabled", $(event.target).val() != "IFC" && $(event.target).val() != "IFCXML");
		};
		$(".revisionsdownloadcheckoutselect").change(checkRevisionsCheckoutButton);
	});
</script>
<%@ include file="footer.jsp" %>