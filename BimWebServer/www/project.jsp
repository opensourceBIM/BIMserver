<%@page import="org.bimserver.interfaces.objects.SModelComparePluginConfiguration"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="org.bimserver.shared.comparators.SUserNameComparator"%>
<%@page import="org.bimserver.shared.comparators.SProjectNameComparator"%>
<%@page import="org.bimserver.shared.comparators.SCheckoutDateComparator"%>
<%@page import="org.bimserver.shared.comparators.SRevisionIdComparator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.TreeSet"%>
<%@page import="org.bimserver.interfaces.objects.SCheckout"%>
<%@page import="org.bimserver.interfaces.objects.SGeoTag"%>
<%@page import="org.bimserver.interfaces.objects.SObjectState"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<%@page import="org.bimserver.interfaces.objects.SSIPrefix"%>
<%@page import="org.bimserver.interfaces.objects.SRevision"%>
<%@page import="org.bimserver.interfaces.objects.SUser"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%@page import="org.bimserver.models.store.SIPrefix"%>
<%@page import="org.bimserver.shared.exceptions.ServiceException"%>
<%@page import="org.bimwebserver.jsp.JspHelper"%>
<%@page import="org.bimserver.utils.Formatters"%>
<%@page import="org.bimserver.utils.WebUtils"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.slf4j.LoggerFactory"%>
<%@page import="org.bimserver.interfaces.objects.SSerializerPluginConfiguration"%>
<%@ include file="header.jsp"%>
<%
		if (loginManager.isLoggedIn()) {
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			long poid = Long.parseLong(request.getParameter("poid"));
			try {
				SProject project = loginManager.getService(request).getProjectByPoid(poid);
	
				// Count the active subprojects
				int subProjectCount = 0;
				List<Long> subProjectIds = project.getSubProjects();
				for (Long subpoid : subProjectIds) {
					SProject subproject = loginManager.getService(request).getProjectByPoid(subpoid);
					SObjectState state = subproject.getState();
					if (subproject.getState() == SObjectState.ACTIVE) {
						subProjectCount++;
					}
				}
	
				List<SRevision> revisions = loginManager.getService(request).getAllRevisionsOfProject(poid);
				Collections.sort(revisions, new SRevisionIdComparator(false));
				List<SRevision> revisionsInc = loginManager.getService(request).getAllRevisionsOfProject(poid);
				Collections.sort(revisionsInc, new SRevisionIdComparator(false));
				List<SCheckout> checkouts = loginManager.getService(request).getAllCheckoutsOfProjectAndSubProjects(poid);
				Collections.sort(checkouts, new SCheckoutDateComparator(false));
				List<SCheckout> activeCheckouts = new ArrayList<SCheckout>();
				for (SCheckout checkout : checkouts) {
					if (checkout.getActive()) {
						activeCheckouts.add(checkout);
					}
				}
				List<SUser> users = loginManager.getService(request).getAllAuthorizedUsersOfProject(poid);
				Collections.sort(users, new SUserNameComparator());
				List<SUser> nonAuthorizedUsers = loginManager.getService(request).getAllNonAuthorizedUsersOfProject(poid);
				Collections.sort(nonAuthorizedUsers, new SUserNameComparator());
				SRevision lastRevision = null;
				if (project.getLastRevisionId() != -1) {
					lastRevision = loginManager.getService(request).getRevision(project.getLastRevisionId());
				}
				boolean hasUserManagementRights = project.getHasAuthorizedUsers().contains(loginManager.getUoid()) && loginManager.getUserType() != SUserType.READ_ONLY;
				boolean userHasCheckinRights = loginManager.getService(request).userHasCheckinRights(loginManager.getUoid(), project.getOid()) && loginManager.getUserType() != SUserType.READ_ONLY;
				boolean hasEditRights = loginManager.getService(request).userHasRights(project.getOid()) && loginManager.getUserType() != SUserType.READ_ONLY;
				boolean hasCreateProjectRights = (loginManager.getUserType() == SUserType.ADMIN || loginManager.getService(request).isSettingAllowUsersToCreateTopLevelProjects());
				boolean kmzEnabled = loginManager.getService(request).hasActiveSerializer("application/vnd.google-earth.kmz");
				boolean isAdmin = loginManager.getService(request).getCurrentUser().getUserType() == SUserType.ADMIN;
%>
<div class="sidebar">
	<ul>
		<% if (userHasCheckinRights) { %>
		<li><a class="checkinlink link" href="project.jsp?poid=<%=poid%>&action=checkin">Checkin</a></li>
		<% } %>
		<%
			if (hasEditRights) {
		%>
		<li><a class="link" href="editproject.jsp?poid=<%=poid%>">Edit</a>
		</li>
		<%
			}
		%>
		<%
			if (lastRevision != null) {
		%>
		<li><a id="browserlink" class="link">Browser</a></li>
		<%
			}
		%>
		<li><a class="rss"
			href="<%=request.getContextPath()%>/syndication/revisions?poid=<%=poid%>">Revisions
				feed</a></li>
		<li><a class="rss"
			href="<%=request.getContextPath()%>/syndication/checkouts?poid=<%=poid%>">Checkouts
				feed</a></li>
		<jsp:include page="showdeleted.jsp" />
	</ul>
	<br /><%=JspHelper.showProjectTree(project, loginManager.getService(request))%>
</div>
<div id="checkinpopup"></div>
<div id="downloadcheckoutpopup"></div>
<div class="content project">
	<%
		if (request.getParameter("message") != null) {
					out.println("<div class=\"error\">" + request.getParameter("message") + "</div>");
				}
	%>
	<div id="guide">
		<div id="guidewrap">
			<ol id="breadcrumb">
				<li><%=JspHelper.generateBreadCrumbPath(project, loginManager.getService(request))%></li>
			</ol>
		</div>
	</div>

	<h1>
		Project details (<%=project.getName()%>)
	</h1>
	<div class="tabber" id="projecttabber">
		<div class="tabbertab projectdetails" id="detailstab" title="Details">
			<%
				if (project.getRevisions().isEmpty()) {
							if (userHasCheckinRights) {
			%>
			<div class="info">
				<img src="images/warning.png" alt="warning" />There are no
				revisions yet, click <a id="checkin" href="project.jsp?poid=<%=project.getOid()%>&action=checkin">on the
					checkin link</a> to add a revision, or <a id="subprojecttablink" href="#">add a subproject.</a>
			</div>
			<%
				}
						}
			%>
			<table class="formtable">
				<tr>
					<td class="first">Name</td>
					<td><%=project.getName()%></td>
				</tr>
				<%
					if (project.getParentId() != -1) {
								SProject parentProject = loginManager.getService(request).getProjectByPoid(project.getParentId());
				%>
				<tr>
					<td class="first">Parent</td>
					<td><a href="project.jsp?poid=<%=parentProject.getOid()%>"><%=parentProject.getName()%></a>
					</td>
				</tr>
				<%
					}
							SUser createdBy = loginManager.getService(request).getUserByUoid(project.getCreatedById());
							SGeoTag geoTag = loginManager.getService(request).getGeoTag(project.getGeoTagId());
				%>
				<tr>
					<td class="first">Created on</td>
					<td><%=dateFormat.format(project.getCreatedDate())%></td>
				</tr>
				<tr>
					<td class="first">Created by</td>
					<td><a href="user.jsp?uoid=<%=createdBy.getOid()%>"><%=createdBy.getUsername()%></a>
					</td>
				</tr>
				<%
					if (lastRevision != null) {
				%>
				<tr>
					<td class="first">Last update on</td>
					<td><%=dateFormat.format(lastRevision.getDate())%></td>
				</tr>
				<tr>
					<td class="first">Last update by</td>
					<td><a href="user.jsp?uoid=<%=lastRevision.getUserId()%>"><%=loginManager.getService(request).getUserByUoid(lastRevision.getUserId()).getUsername()%></a></td>
				</tr>
				<%
					}
				%>
				<tr>
					<td class="first">State</td>
					<td><%=project.getState().name().toLowerCase()%></td>
				</tr>
				<tr>
					<td class="first">Description</td>
					<td><%=project.getDescription()%></td>
				</tr>
				<%
					if (kmzEnabled) {
								String url = WebUtils.getWebServer(request.getRequestURL().toString());
								String link = "http://" + url + getServletContext().getContextPath() + "/download?poid=" + project.getOid() + "&serializerName=KMZ";
				%>
				<tr>
					<td class="first">Google Earth Link</td>
					<td><a href="<%=link%>"><%=link%></a></td>
				</tr>
				<%
					}
				%>
				<tr>
					<td class="first">Uniform length measure unit for combined
						revisions</td>
					<%
						if (project.getExportLengthMeasurePrefix() == null) {
									project.setExportLengthMeasurePrefix(SSIPrefix.meter);
								}
					%>
					<td><%=project.getExportLengthMeasurePrefix().name()%></td>
				</tr>
				<%
					if (geoTag.getEnabled()) {
				%>
				<tr>
					<td class="first">Coordinates</td>
					<td><%=geoTag.getX() + "," + geoTag.getY() + "," + geoTag.getZ()%></td>
				</tr>
				<tr>
					<td class="first">Direction angle</td>
					<td><%=geoTag.getDirectionAngle()%></td>
				</tr>
				<tr>
					<td class="first">EPSG</td>
					<td><%=geoTag.getEpsg()%></td>
				</tr>
				<%
					}
				%>
			</table>
			<br />
			<%
				if (lastRevision != null) {
			%>
			Click <a href="revision.jsp?roid=<%=lastRevision.getOid()%>">here</a>
			to go to the latest revision<br /> <br />
			<p></p>
			<div class="tabber" id="downloadtabber">
				<div class="tabbertab" id="detailstab" title="Simple Download">
					This will simply download the latest revision<br/>
					<a href="#" class="downloadCheckoutButton" revisionoid="<%=lastRevision.getOid()%>">Download</a>
				</div>

				<div class="tabbertab" id="" title="Advanced Download">
					<script>
	var projects = new Object();
	
	<%=JspHelper.writeDownloadProjectTreeJavaScript(project, loginManager)%>
</script>

					<table class="formatted maintable">
						<tr>
							<th>Project</th>
							<th>Last revision</th>
							<th>Revision</th>
						</tr>
						<%=JspHelper.writeDownloadProjectTree("download", project, loginManager, 0, null)%>
					</table>
					<a href="#" class="downloadCheckoutButtonAdvanced">Download</a>
				</div>
			</div>
			<%
				}
			%>
		</div>

		<div class="tabbertab" id="subprojectstab"
			title="Sub Projects<%=subProjectCount /*project.getSubProjects().size()*/== 0 ? "" : " (" + subProjectCount /*project.getSubProjects().size()*/
							+ ")"%>">
			<%
				if (hasCreateProjectRights) {
			%>
			<a href="addproject.jsp?parentoid=<%=project.getOid()%>">Add
				subproject</a><br /> <br />
			<%
				}
						if (project.getSubProjects().size() == 0) {
			%>
			<div class="none">No subprojects</div>
			<%
				} else {
			%>
			<table class="formatted">
				<tr>
					<th>Name</th>
					<th>Last Revision</th>
					<th>Revisions</th>
					<th>Checkouts</th>
					<th>Authorized users</th>
					<%
						if (userHasCheckinRights) {
					%>
					<th>Actions</th>
					<%
						}
					%>
				</tr>
				<%
					Set<SProject> subProjects = new TreeSet<SProject>(new SProjectNameComparator());
					for (long subPoid : project.getSubProjects()) {
						try {
							SProject subProject = loginManager.getService(request).getProjectByPoid(subPoid);
							subProjects.add(subProject);
						} catch (ServiceException e) {
						}
					}
					for (SProject subProject : subProjects) {
						List<SUser> subProjectUsers = loginManager.getService(request).getAllAuthorizedUsersOfProject(subProject.getOid());

						SRevision lastSubProjectRevision = null;
						if (subProject.getLastRevisionId() != -1) {
							lastSubProjectRevision = loginManager.getService(request).getRevision(subProject.getLastRevisionId());
						}
				%>
				<tr
					<%=(loginManager.getService(request).userHasCheckinRights(loginManager.getUoid(), subProject.getOid()) == true ? "" : " class=\"checkinrights\"")%>
					<%=subProject.getState() == SObjectState.DELETED ? " class=\"deleted\"" : ""%>>
					<td><a href="project.jsp?poid=<%=subProject.getOid()%>"><%=subProject.getName()%></a>
					</td>
					<td><%=lastSubProjectRevision == null ? "No revisions" : ("<a href=\"revision.jsp?roid=" + lastSubProjectRevision.getOid() + "\">"
									+ lastSubProjectRevision.getId() + "</a> by <a href=\"user.jsp?id=" + lastSubProjectRevision.getUserId() + "\">"
									+ loginManager.getService(request).getUserByUoid(lastSubProjectRevision.getUserId()).getUsername() + "</a>")%></td>
					<td><%=subProject.getRevisions().size()%></td>
					<td><%=subProject.getCheckouts().size()%></td>
					<td><%=subProjectUsers.size()%></td>
					<%
						if (userHasCheckinRights) {
					%>
					<%
						if (subProject.getState() == SObjectState.ACTIVE) {
					%>
					<td><a
						href="deleteproject.jsp?ppid=<%=project.getOid()%>&poid=<%=subProject.getOid()%>">delete</a>
					</td>
					<%
						} else if (subProject.getState() == SObjectState.DELETED) {
					%>
					<td><a
						href="undeleteproject.jsp?ppid=<%=project.getOid()%>&poid=<%=subProject.getOid()%>">undelete</a>
					</td>
					<%
						}
					%>
					<%
						}
					%>
				</tr>
				<%
					}
				%>
			</table>
			<%
				}
			%>
		</div>
<%
if (revisions.size() > 0) {
%>
		<div class="tabbertab" id="revisionstab" title="Revisions<%=revisions.size() == 0 ? "" : " (" + revisions.size() + ")"%>">
			<fieldset>
				<legend>Compare</legend>
				<div id="compareajaxloader">
					Comparing... <img src="images/ajax-loader.gif" />
				</div>
				<form method="get" action="compare.jsp" id="compareform">
					<input type="hidden" name="poid" value="<%=poid%>" /> Revision <select
						name="roid1">
						<%
							for (SRevision otherRevision : revisionsInc) {
						%>
						<option value="<%=otherRevision.getOid()%>"><%=otherRevision.getId()%></option>
						<%
							}
						%>
					</select> with Revision <select name="roid2">
						<%
							for (SRevision otherRevision : revisionsInc) {
						%>
						<option value="<%=otherRevision.getOid()%>"><%=otherRevision.getId()%></option>
						<%
							}
						%>
					</select> Show <select name="type">
						<option value="ALL">All</option>
						<option value="ADD">Added</option>
						<option value="MODIFY">Modified</option>
						<option value="DELETE">Deleted</option>
					</select> Compare Engine <select name="mcid">
<%
for (SModelComparePluginConfiguration modelCompare : loginManager.getService(request).getAllModelCompares(true)) {
%>
						<option value="<%=modelCompare.getOid()%>" <%=loginManager.getService(request).getDefaultModelCompare() != null && loginManager.getService(request).getDefaultModelCompare().getOid() == modelCompare.getOid() ? "selected=\"selected\"" : ""%>><%=modelCompare.getName() %></option>
<%
}
%>
					</select>
					<button type="submit" name="compare" value="Compare">Compare</button>
				</form>
			</fieldset>
			<table class="formatted">
				<tr>
					<th>Id</th>
					<th>Date</th>
					<th>User</th>
					<th>Comment</th>
					<th>Size</th>
					<th>Download/Checkout</th>
				</tr>
				<%
					for (SRevision revision : revisions) {
						SUser revisionUser = loginManager.getService(request).getUserByUoid(revision.getUserId());
						boolean isTagged = revision.getTag() != null;
				%>
				<tr <%=isTagged ? "class=\"tagged\"" : ""%>
					id="rev<%=revision.getOid()%>"
					<%=lastRevision != null && revision.getId() == lastRevision.getId() ? "class=\"lastrevision\"" : ""%>>
					<td><a href="revision.jsp?roid=<%=revision.getOid()%>"><%=revision.getId()%></a>
					</td>
					<td style="white-space: nowrap;"><%=dateFormat.format(revision.getDate())%></td>
					<td style="white-space: nowrap;"><a
						href="user.jsp?uoid=<%=revision.getUserId()%>"><%=revisionUser.getUsername()%></a>
					</td>
					<td>
						<div class="commentbox">
							<div><%=revision.getComment()%></div>
						</div>
					</td>
					<td class="sizefield"><%=revision.getSize()%></td>
					<td>
						<a href="#" revisionoid="<%=revision.getOid() %>" class="downloadCheckoutButton">Download</a>
					</td>
				</tr>
<% } %>
			</table>
		</div>
			<%
				}
			%>
		<%
			if (lastRevision != null) {
		%>
		<div class="tabbertab" id="querytab" title="Query">
			Note: Queries will be done on the latest revision (<a
				href="revision.jsp?roid=<%=lastRevision.getOid()%>"><%=lastRevision.getId()%></a>),
			open a specific revision to query other revisions<br /> <br />

			<jsp:include page="query.jsp">
				<jsp:param name="poid" value="<%=poid %>" />
				<jsp:param name="roid" value="<%=lastRevision.getOid() %>" />
			</jsp:include>
		</div>
		<%
			}
		%>
		<%
			if (checkouts.size() > 0) {
		%>
		<div class="tabbertab" id="checkoutstab"
			title="Checkouts<%=checkouts.size() == 0 ? "" : " (" + activeCheckouts.size() + ")"%>">
			<%
				boolean showCheckoutToggle = false;
							for (SCheckout checkout : checkouts) {
								if (!checkout.getActive()) {
									showCheckoutToggle = true;
								}
							}
							if (showCheckoutToggle) {
			%>
			<label for="showinactivecheckouts">Show inactive checkouts </label> <input
				id="showinactivecheckouts" type="checkbox" />
			<%
				}
			%>
			<table class="formatted">
				<tr>
					<th>Revision Id</th>
					<th>User</th>
					<th>Date</th>
					<th>Active</th>
					<th>Download/Checkout</th>
				</tr>
				<%
					for (SCheckout checkout : checkouts) {
									SUser checkoutUser = loginManager.getService(request).getUserByUoid(checkout.getUserId());
				%>
				<tr
					class="<%=checkout.getActive() ? "" : "inactivecheckoutrow"%>">
					<td><a href="revision.jsp?roid=<%=checkout.getRevisionId()%>"><%=loginManager.getService(request).getRevision(checkout.getRevisionId()).getId()%></a></td>
					<td><a href="user.jsp?uoid=<%=checkout.getUserId()%>"><%=checkoutUser.getUsername()%></a>
					</td>
					<td><%=dateFormat.format(checkout.getDate())%></td>
					<td><%=checkout.getActive()%></td>
					<td>
						<a href="#" class="downloadCheckoutButton" revisionoid="<%=checkout.getRevisionId() %>">Download</a>
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
		<div class="tabbertab" id="authorizeduserstab"
			title="Authorized users<%=users.size() == 0 ? "" : " (" + users.size() + ")"%>">
			<%
				if (nonAuthorizedUsers.size() > 0 && (isAdmin || (!loginManager.getService(request).isSettingHideUserListForNonAdmin() && hasUserManagementRights))) {
			%>
			Add an existing user<br/>
			<form method="post" action="addusertoproject.jsp">
				<select name="uoid">
					<%
						for (SUser user : nonAuthorizedUsers) {
					%>
					<option value="<%=user.getOid()%>"><%=user.getName() + " (" + user.getUsername() + ")"%></option>
					<%
						}
					%>
				</select> <input type="hidden" name="poid" value="<%=poid%>" /> <input
					type="hidden" name="type" value="project" /> <input type="submit"
					value="Add" />
			</form><br/>

			<%
				}
				if (loginManager.getService(request).isSettingHideUserListForNonAdmin() && hasUserManagementRights) {
			%>
			Invite more people<br/>
			<form method="post" action="addusertoproject.jsp">
				<input type="hidden" name="poid" value="<%=poid%>" />
				<input type="hidden" name="type" value="invitedUser" />
				<table>
					<tr>
						<td><label for="usernamefield">E-mail address</label></td>
						<td><input id="usernamefield" type="email" name="username" /></td>
					</tr>
					<tr>
						<td><label for="namefield">Name</label></td>
						<td><input id="namefield" type="text" name="name" /></td>
					</tr>
				</table>
				<input id="inviteButton" type="button" value="Invite" />
			</form>
			<%
				}
			%>
			<%
				if (users.size() > 0) {
			%>
			<table class="formatted">
				<tr>
					<th>Name</th>
					<th>Username</th>
					<th>Type</th>
					<%
						if (hasUserManagementRights) {
					%>
					<th>Actions</th>
					<%
						}
					%>
				</tr>
				<%
					for (SUser user : users) {
				%>
				<tr
					<%=user.getState() == SObjectState.DELETED ? " class=\"deleted\"" : ""%>>
					<td><a href="user.jsp?uoid=<%=user.getOid()%>"><%=user.getName()%></a>
					</td>
					<td><a href="user.jsp?uoid=<%=user.getOid()%>"><%=user.getUsername()%></a>
					</td>
					<td><%=JspHelper.getNiceUserTypeName(user.getUserType())%></td>
					<%
						if (hasUserManagementRights) {
					%>
					<td>
						<%
							if (user.getUserType() != SUserType.ADMIN) {
						%> <a
						href="revokepermission.jsp?type=project&poid=<%=poid%>&amp;uoid=<%=user.getOid()%>">revoke</a>
						<%
							}
						%>
					</td>
					<%
						}
					%>
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
		
		<div class="tabbertab" id="servicestab" title="Services">
		</div>
	</div>

	<script>
	var poid = <%=poid%>;
	var lastRevisionOid = <%=lastRevision == null ? -1 : lastRevision.getOid()%>;
	
	$(function(){
		$("#servicestab").load("services.jsp?poid=<%=project.getOid()%>");

		$("#inviteButton").click(function(){
			// TODO enable
//			bimServerApi.call({
//				action: "inviteuser",
//				username: $("#usernamefield").val(),
//				name: $("#namefield").val(),
//				type: "USER"
//			}, function(data){
//				if (data.error == null) {
//					document.location = "addusertoproject.jsp?uoid=" + data.uoid + "&poid=<%=project.getOid()%>&type=project";
//				} else {
//					alert(data.error);
//				}
//			});
		});
		
		$(".downloadCheckoutButtonAdvanced").click(function(event){
			event.preventDefault();
			$("#downloadcheckoutpopup").dialog({
				title: "Download/Checkout",
				width: 600,
				height: 300,
				modal: true
			});
			var roids = [];
			$(".projectdetails .treeselect").each(function(){
				if ($(this).val() != "[off]") {
					roids.push($(this).val());
				}
			});

			var params = {
				downloadType: "multiple",
				poid: <%=poid%>,
				roids: roids
			};
			$("#downloadcheckoutpopup").load("download.jsp", {data: JSON.stringify(params)});
		});

		$("#revisiontablink").click(function (){
			document.getElementById("projecttabber").tabber.tabShow(2);	
			return false;
		});
		$("#subprojecttablink").click(function (){
			document.getElementById("projecttabber").tabber.tabShow(1);
			return false;
		});
		var updateInactiveCheckouts = function(){
			if ($('#showinactivecheckouts').is(':checked')) {
				$(".inactivecheckoutrow").show();
			} else {
				$(".inactivecheckoutrow").hide();
			}
		}
		$("#showinactivecheckouts").click(updateInactiveCheckouts);
		updateInactiveCheckouts();
		
		var showCheckinPopup = function() {
			$("#checkinpopup").dialog({
				title: "Checkin new revision",
				width: 600,
				height: 300,
				modal: true
			});
			$("#checkinpopup").load("checkin.jsp?poid=<%=project.getOid()%>");
		} 
		
		$(".downloadCheckoutButton").click(function(event){
			event.preventDefault();
			var params = {
				downloadType: "single",
				allowCheckouts: true,
				poid: <%=poid%>,
				roid: $(this).attr("revisionoid")
			};
			showDownloadCheckoutPopup(params);
		});
		
		$(".checkinlink").click(function(event){
			event.preventDefault();
			showCheckinPopup();
		});
		<%
			if ("checkin".equals(request.getParameter("action"))) {
				%>
				showCheckinPopup();
				<%
			}
		%>
		<%="var checkinId = " + request.getParameter("checkinId") + ";"%>
	});
</script>
	<%
		if (lastRevision != null) {
	%>
	<script>
	var modelurl = null;
	$(function(){
		$("#compareajaxloader").hide();
		$("#browserajaxloader").hide();
		$("#compareform").submit(function(){
			$("#compareform").hide();
			$("#compareajaxloader").show();
		});
		$("#browserajaxlink").click(function() {
			$("#browserajaxloader").show();
			$("#browser").load("browser.jsp?roid=<%=lastRevision.getOid()%>");
		});

		$("#browserlink").click(function() {
			showOverlay("Browser", "browser.jsp?roid=<%=project.getLastRevisionId()%>");
			return false;
		});

		var lastFour = [0, 0, 0, 0];
		
		$(document).keypress(function(event){
			for (var i=0; i<3; i++) {
				lastFour[i] = lastFour[i+1];
			}
			lastFour[3] = event.keyCode;
			if (lastFour.compare([115, 117, 114, 102])) {
				var dialog = $("<div>");
				$(window).append(dialog);
				dialog.dialog({
					width: $(document).width() * 0.7,
					height: Math.min($(document).height(), $(window).height()) * 0.8,
					title: "BIMSurfer"
				});
				dialog.append("Loading...");
				var data = {};
				data.roid = <%=project.getLastRevisionId()%>;
				data.downloadType = "single";
				data.serializerName = "SceneJS";
				data.sync = true;
				$.ajax("initiatedownload.jsp?data=" + JSON.stringify(data), {
					dataType: "json",
					success: function(result, textStatus, jqXHR){
						modelurl = "/download?longActionId=" + result.laid + "&serializerName=SceneJS";
						dialog.load("bimsurfer.jsp?format=scenejson", function(){
							dialog.each(function(){
								$(this).addClass("unselectable");
							});
						});
					}
				});
			}
		});
		
		updateTreeSelectListeners();
	});

	function setOffSupers(baseName, pid) {
		var project = projects["project" + pid];
		if (project.superproject != null && project.superproject != "undefined") {
			$("#" + baseName + "_" + project.superproject.id).val("[off]");
			setOffSupers(baseName, project.superproject.id);
		}
	}

	function setOffSubs(baseName, pid) {
		var project = projects["project" + pid];
		for ( var i in project.subprojects) {
			$("#" + baseName + "_" + project.subprojects[i].id).val("[off]");
			setOffSubs(baseName, project.subprojects[i].id);
		}
	}
	
	function updateTreeSelectListeners() {
		// Crappy MS browser does not understand change
		if (!$.browser.msie) {
			$(".treeselect").change(function(e){
				var idString = e.target.id;
				var baseName = idString.substring(0, idString.indexOf("_"));
				var id = idString.substring(idString.indexOf("_") + 1);
				if ($("#" + baseName + "_" + id).val() != "[off]") {
					var revisionId = e.target.value;
					var project = projects["project" + id];
					setOffSupers(baseName, project.id);
					setOffSubs(baseName, project.id);
				}
			});
		}
	}
</script>
	<%
		}
			} catch (ServiceException e) {
				if (e.getCause() instanceof OutOfMemoryError) {
					response.sendRedirect(getServletContext().getContextPath());
				} else {
					LoggerFactory.getLogger(JspHelper.class).error("", e);
					out.println(e.getUserMessage());
				}
			} catch (Exception e) {
				LoggerFactory.getLogger("project.jsp").error("", e);
			}
		}
	%>
</div>
<jsp:include page="footer.jsp" />