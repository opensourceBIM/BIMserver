<%@page import="java.util.List"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Collections"%>
<%@page import="org.bimserver.utils.Formatters"%>
<%@page import="org.bimserver.shared.UserException"%>
<%@page import="org.bimserver.web.JspHelper"%>
<%@page import="org.bimserver.interfaces.objects.SCheckout"%>
<%@page import="org.bimserver.interfaces.objects.SRevision"%>
<%@page import="org.bimserver.shared.SCheckoutDateComparator"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<%@page import="org.bimserver.interfaces.objects.SUser"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%@page import="org.bimserver.utils.WebUtils"%>
<%@page import="org.bimserver.interfaces.objects.SSerializer"%>
<%@ include file="header.jsp"%>
<%
	if (loginManager.getService().isLoggedIn()) {
		try {
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	long roid = Long.parseLong(request.getParameter("roid"));
	SRevision revision = loginManager.getService().getRevision(roid);
	boolean isTagged = revision.getTag() != null;
	SProject project = loginManager.getService().getProjectByPoid(revision.getProjectId());
	SUser user = loginManager.getService().getUserByUoid(revision.getUserId());
	List<SCheckout> checkouts = loginManager.getService().getAllCheckoutsOfRevision(roid);
	Collections.sort(checkouts, new SCheckoutDateComparator(false));
	List<String> classes = loginManager.getService().getAvailableClasses();
	Collections.sort(classes);
	boolean isAdmin = loginManager.getService().getCurrentUser().getUserType() == SUserType.ADMIN;
	boolean isTopProject = project.getParentId() == -1L;
	boolean o3dEnabled = loginManager.getService().hasActiveSerializer("appliction/json");
	boolean kmzEnabled = loginManager.getService().hasActiveSerializer("application/vnd.google-earth.kmz");
	if (o3dEnabled) {
%>
<jsp:include page="o3d.jsp"/>
<%
	}
%>
<div class="sidebar">
 <%
 	if (o3dEnabled) {
 %>
<ul>
<li>
 <a id="visualiselink" class="link">Visualise</a></li>
 <%
 	}
 %> 
 <li>
 <a id="browserlink" class="link">Browser</a></li>
</ul>
</div>
<div class="content">

<h1>Revision details (Project: <%=project.getName()%>, Revision: <%=revision.getId()%>)</h1>
<div id="guide">
  <div id="guidewrap">
    <ol id="breadcrumb">
	  <li><%=JspHelper.generateBreadCrumbPath(revision, loginManager.getService())%></li>
    </ol>
  </div>
</div>
<div id="guide_wrap_btm"></div>

<div class="tabber" id="revisiontabber">
<div class="tabbertab" id="detailstab" title="Details">
<table class="formtable">
	<tr>
		<td class="first">Id</td>
		<td><%=revision.getId()%></td>
	</tr>
	<tr>
		<td class="first">Project</td>
		<td><a href="project.jsp?poid=<%=revision.getProjectId()%>"><%=project.getName()%></a></td>
	</tr>
	<tr>
		<td class="first">User</td>
		<td><a href="user.jsp?id=<%=revision.getUserId()%>"><%=user.getUsername()%></a></td>
	</tr>
	<tr>
		<td class="first">Date</td>
		<td><%=dateFormat.format(revision.getDate())%></td>
	</tr>
	<tr>
		<td class="first">Comment</td>
		<td><%=revision.getComment()%></td>
	</tr>
	<tr>
		<td class="first">Size</td>
		<td><%=revision.getSize()%></td>
	</tr>
<%
	if (kmzEnabled) {
	String url = WebUtils.getWebServer(request.getRequestURL().toString());
	String link = "http://" + url + getServletContext().getContextPath() + "download?roid=" + revision.getOid() + "&resultType=KMZ";
%>
	<tr>
		<td class="first">Google Earth Link</td>
		<td><a href="<%=link%>"><%=link%></a></td>
	</tr>
<%
	}
%>
</table>
<br />

<%-- ------------------------------------------------------------------------ REVISION TAG --%>
<form action="setrevisiontag.jsp" method="post"><input
	type="hidden" name="roid" value="<%=roid%>" />
<table class="formtable">
	<tr>
		<td class="first" width="100">Tag:</td>
		<%
			if (isAdmin && isTagged && isTopProject) {
		%>
		<td><%=revision.getTag()%></td>
		<td></td>
		<%
			} else if (isAdmin && !isTagged && isTopProject) {
		%>
		<td><input type="text" name="tagLabel" /></td>
		<td><input type="submit" name="setTag" value="Set" /></td>
		<%
			} else if (isTagged) {
		%>
		<td><%=revision.getTag()%></td><td></td>
		<%
			} else {
		%>
		<td></td><td></td>
		<%
			}
		%>
	</tr>
</table>
</form>
<br />

<%-- ---------------------------------------------------------------------------- DOWNLOAD --%>
<form action="<%=request.getContextPath()%>/download" method="get">
<input type="hidden" name="roid" value="<%=roid%>" />
<table class="formtable">
	<tr>
		<td class="first" width="100">Download:</td>
		<td><select name="resultType" id="downloadcheckoutselect">
			<%
				for (SSerializer serializer : loginManager.getService().getEnabledSerializers()) {
			%>
			<option value="<%=serializer.getName()%>"
				<%=serializer.isDefaultSerializer() ? " SELECTED=\"SELECTED\"" : ""%>><%=serializer.getName()%></option>
			<%
				}
			%>
		</select> <label for="zip_<%=revision.getId()%>">Zip</label><input
			type="checkbox" name="zip" id="zip_<%=revision.getId()%>" />
			<input name="download" type="submit" value="Download">
<%
	boolean userHasCheckinRights = loginManager.getService().userHasCheckinRights(project.getOid());
if (userHasCheckinRights) { %>
			<input name="checkout" type="submit" value="Checkout" class="checkoutbutton">
<% } %>
			</td>
</table>
</form>
<br />

<%-- --------------------------------------------------------------- BRANCH TO NEW PROJECT --%>
<fieldset>
<legend>Branch to new project</legend>
<form method="post" action="branch.jsp">
<label>New project name</label> <input type="text" name="name" /> 
<label>Revision comment</label> <input type="text" name="comment" />
<input type="submit" value="Branch" /> <input type="hidden" name="roid" value="<%=roid%>" />
<input type="hidden" name="action" value="branchtonewproject" />
</form>
</fieldset>
</div>
<%
	if (checkouts.size() > 0) {
%>
<div class="tabbertab" id="checkoutstab"
	title="Checkouts<%=checkouts.size() == 0 ? "" : " (" + checkouts.size() + ")"%>">
<table class="formatted">
	<tr>
		<th>User</th>
		<th>Date</th>
		<th>Download</th>
	</tr>
	<%
		for (SCheckout checkout : checkouts) {
					SUser checkoutUser = loginManager.getService().getUserByUoid(checkout.getUserId());
	%>
	<tr>
		<td><a href="user.jsp?id=<%=checkout.getUserId()%>"><%=checkoutUser.getUsername()%></a></td>
		<td><%=dateFormat.format(checkout.getDate())%></td>
		<td>
		<form method="get" action="<%=request.getContextPath()%>/download">
		<input type="hidden" name="roid" value="<%=checkout.getRevisionId()%>" />
		<select name="resultType">
			<%
				for (SSerializer serializer : loginManager.getService().getEnabledSerializers()) {
			%>
			<option value="<%=serializer.getName()%>"
				<%=serializer.isDefaultSerializer() ? " SELECTED=\"SELECTED\"" : ""%>><%=serializer.getName()%></option>
			<%
				}
			%>
		</select> <label for="zip_<%=checkout.getOid()%>">Zip</label><input
			type="checkbox" name="zip" id="zip_<%=checkout.getOid()%>" /> <input
			type="submit" value="Download" /></form>
		</td>
	</tr>
	<%
		}
	%>
</table>
</div>
<%
	}
%>
</div>
<script>
	$(document).ready(function(){
		$("#browserajaxloader").hide();
		$("#browserajaxlink").click(function(){
			$("#browserajaxlink").hide();
			$("#browserajaxloader").show();
			$("#browser").load("browser.jsp?roid=<%=roid%>");
		});
		checkCheckoutButton = function(event){
			$(".checkoutbutton").attr("disabled", $("#downloadcheckoutselect").val() != "IFC" && $("#downloadcheckoutselect").val() != "IFCXML");
		};
		$("#downloadcheckoutselect").change(checkCheckoutButton);
		$("#visualiselink").click(function(){
			showOverlay("Visualisation", "visualize.jsp?roid=<%=revision.getOid() %>");
			return false;
		});

		$("#browserlink").click(function(){
			showOverlay("Browser", "browser.jsp?roid=<%=revision.getOid() %>");
			return false;
		});
		checkCheckoutButton();
	});
</script> <%
 	} catch (UserException e) {
 			out.println(e.getUserMessage());
 		}
 	}
 %>
</div>
<%@ include file="footer.jsp"%>