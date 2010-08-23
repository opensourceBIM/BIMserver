<%@page import="java.util.List"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Collections"%>
<%@page import="org.bimserver.utils.Formatters"%>
<%@page import="org.bimserver.shared.UserException"%>
<%@page import="org.bimserver.shared.ResultType"%>
<%@page import="org.bimserver.EmfSerializerFactory"%>
<%@page import="org.bimserver.JspHelper"%>
<%@page import="org.bimserver.interfaces.objects.SCheckout"%>
<%@page import="org.bimserver.interfaces.objects.SRevision"%>
<%@page import="org.bimserver.shared.SCheckoutDateComparator"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<%@page import="org.bimserver.interfaces.objects.SUser"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%@ include file="header.jsp"%>
<%
	if (loginManager.isLoggedIn()) {
		EmfSerializerFactory emfSerializerFactory = EmfSerializerFactory.getInstance();
		try {
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			long roid = Long.parseLong(request.getParameter("roid"));
			SRevision revision = loginManager.getService().getRevision(roid);
			boolean isTagged = revision.getTag() != null;
			SProject project = loginManager.getService().getProjectByPoid(revision.getProjectId());
			SUser user = loginManager.getService().getUserByUoid(revision.getUserId());
			List<SCheckout> checkouts = loginManager.getService().getAllCheckoutsOfRevision(roid);
			Collections.sort(checkouts, new SCheckoutDateComparator());
			List<String> classes = loginManager.getService().getAvailableClasses();
			Collections.sort(classes);
			boolean isAdmin = loginManager.getService().getCurrentUser().getUserType() == SUserType.ADMIN;
			boolean isTopProject = project.getParentId() == -1L;
			if (emfSerializerFactory.resultTypeEnabled(ResultType.O3D_JSON)) {
%>
<jsp:include page="o3d.jsp"/>
<%
}
%>
<div class="sidebar">
 <h4>Submenu</h4>
 <%
	if (emfSerializerFactory.resultTypeEnabled(ResultType.O3D_JSON)) {
%>
<li>
 <a href="visualize.jsp?width=520&height=530&roid=<%=revision.getOid() %>" class="visualizelink thickbox" title="Visualisation">Visualise</a></li>
 <%} %> 
 <li>
 <a href="browser.jsp?width=520&height=530&roid=<%=revision.getOid() %>" class="thickbox" id="browserajaxlink" title="Browser">Browser</a></li>
</div>
<div class="content">

<h1>Revision details (Project: <%=project.getName()%>, Revision: <%=revision.getId()%>)</h1>
<div id="guide">
<div id="guidewrap">
<ol id="breadcrumb">
	<li id="bc-home"><a href="main.jsp" id="usernav-home" class="home">Home</a>
	</li>
	<li><%=JspHelper.generateBreadCrumbPath(revision, loginManager.getService())%>
	</li>
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
		<td><a href="project.jsp?id=<%=revision.getProjectId()%>"><%=project.getName()%></a></td>
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
		<td><input type="text" name="tagLabel"
			value="<%=revision.getTag()%>" disabled="disabled" /></td>
		<td><input type="submit" name="setTag" value="Set"
			disabled="disabled" /></td>
		<%
			} else if (isAdmin && !isTagged && isTopProject) {
		%>
		<td><input type="text" name="tagLabel" /></td>
		<td><input type="submit" name="setTag" value="Set" /></td>
		<%
			} else if (isTagged) {
		%>
		<td><input type="text" name="tagLabel"
			value="<%=revision.getTag()%>" disabled="disabled" /></td>
		<%
			} else {
		%>
		<td><input type="text" name="tagLabel" disabled="disabled" /></td>
		<%
			}
		%>
	</tr>
</table>
</form>
<br />

<%-- ---------------------------------------------------------------------------- DOWNLOAD --%>
<form action="<%=request.getContextPath()%>/download" method="post">
<input type="hidden" name="roid" value="<%=roid%>" />
<table class="formtable">
	<tr>
		<td class="first" width="100">Download:</td>
		<td><select name="resultType" id="downloadcheckoutselect">
			<%
				for (ResultType resultType : EmfSerializerFactory.getInstance().getMultipleResultTypes()) {
			%>
			<option value="<%=resultType.name()%>"
				<%=resultType.isDefaultSelected() ? " SELECTED=\"SELECTED\"" : ""%>><%=resultType.getNiceName()%></option>
			<%
				}
			%>
		</select> <label for="zip_<%=revision.getId()%>">Zip</label><input
			type="checkbox" name="zip" id="zip_<%=revision.getId()%>" /> <input
			name="download" type="submit" value="Download"> <input
			name="checkout" type="submit" value="Checkout" class="checkoutbutton"></td>
</table>
</form>
<br />

<%-- --------------------------------------------------------------- BRANCH TO NEW PROJECT --%>
Branch to new project
<form method="post" action="branch.jsp"><label>New
project name</label> <input type="text" name="name" /> <label>Revision
comment</label> <input type="text" name="comment" /> <input type="submit"
	value="Branch" /> <input type="hidden" name="roid" value="<%=roid%>" />
<input type="hidden" name="action" value="branchtonewproject" /></form>
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
		<form method="post" action="<%=request.getContextPath()%>/download">
		<input type="hidden" name="roid" value="<%=checkout.getRevisionId()%>" />
		<select name="resultType">
			<%
				for (ResultType resultType : EmfSerializerFactory.getInstance().getMultipleResultTypes()) {
			%>
			<option value="<%=resultType.name()%>"
				<%=resultType.isDefaultSelected() ? " SELECTED=\"SELECTED\"" : ""%>><%=resultType.name()%></option>
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
			$(event.target).parent().children(".checkoutbutton").attr("disabled", $(event.target).val() != "IFC" && $(event.target).val() != "IFCXML");
		};
		$("#downloadcheckoutselect").change(checkCheckoutButton);
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