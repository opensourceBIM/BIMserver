<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.TreeSet"%>
<%@page import="org.bimserver.interfaces.objects.SCheckinState"%>
<%@page import="org.bimserver.interfaces.objects.SCheckout"%>
<%@page
	import="org.bimserver.interfaces.objects.SClashDetectionSettings"%>
<%@page import="org.bimserver.interfaces.objects.SGeoTag"%>
<%@page import="org.bimserver.interfaces.objects.SObjectState"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<%@page import="org.bimserver.interfaces.objects.SSIPrefix"%>
<%@page import="org.bimserver.interfaces.objects.SRevision"%>
<%@page import="org.bimserver.interfaces.objects.SUser"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%@page import="org.bimserver.models.store.SIPrefix"%>
<%@page import="org.bimserver.rights.RightsManager"%>
<%@page import="org.bimserver.shared.SCheckoutDateComparator"%>
<%@page import="org.bimserver.shared.SProjectNameComparator"%>
<%@page import="org.bimserver.shared.SRevisionIdComparator"%>
<%@page import="org.bimserver.shared.SRevisionSummary"%>
<%@page import="org.bimserver.shared.SUserNameComparator"%>
<%@page import="org.bimserver.shared.UserException"%>
<%@page import="org.bimserver.web.JspHelper"%>
<%@page import="org.bimserver.utils.Formatters"%>
<%@page import="org.bimserver.utils.WebUtils"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.slf4j.LoggerFactory"%>
<%@page import="org.bimserver.interfaces.objects.SSerializer"%>
<%@ include file="header.jsp"%>
<%
	if (loginManager.getService().isLoggedIn()) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		long poid = Long.parseLong(request.getParameter("poid"));
		try {
			SProject project = loginManager.getService().getProjectByPoid(poid);

			// Count the active subprojects
			int subProjectCount = 0;
			List<Long> subProjectIds = project.getSubProjects();
			for (Long subpoid : subProjectIds) {
				SProject subproject = loginManager.getService().getProjectByPoid(subpoid);
				SObjectState state = subproject.getState();
				if (subproject.getState() == SObjectState.ACTIVE) {
					subProjectCount++;
				}
			}

			SClashDetectionSettings sClashDetectionSettings = loginManager.getService().getClashDetectionSettings(project.getClashDetectionSettingsId());
			List<SRevision> revisions = loginManager.getService().getAllRevisionsOfProject(poid);
			Collections.sort(revisions, new SRevisionIdComparator(false));
			List<SRevision> revisionsInc = loginManager.getService().getAllRevisionsOfProject(poid);
			Collections.sort(revisionsInc, new SRevisionIdComparator(false));
			List<SCheckout> checkouts = loginManager.getService().getAllCheckoutsOfProjectAndSubProjects(poid);
			Collections.sort(checkouts, new SCheckoutDateComparator(false));
			List<SCheckout> activeCheckouts = new ArrayList<SCheckout>();
			for (SCheckout checkout : checkouts) {
				if (checkout.isActive()) {
					activeCheckouts.add(checkout);
				}
			}
			List<SUser> users = loginManager.getService().getAllAuthorizedUsersOfProject(poid);
			Collections.sort(users, new SUserNameComparator());
			List<SUser> nonAuthorizedUsers = loginManager.getService().getAllNonAuthorizedUsersOfProject(poid);
			Collections.sort(nonAuthorizedUsers, new SUserNameComparator());
			SRevision lastRevision = null;
			if (project.getLastRevisionId() != -1) {
				lastRevision = loginManager.getService().getRevision(project.getLastRevisionId());
			}
			SUser anonymousUser = null;
			try {
				anonymousUser = loginManager.getService().getAnonymousUser();
			} catch (UserException e) {
			}
			boolean anonymousAccess = anonymousUser != null && project.getHasAuthorizedUsers().contains(anonymousUser.getOid());
			boolean hasUserManagementRights = project.getHasAuthorizedUsers().contains(loginManager.getUoid()) && loginManager.getUserType() != SUserType.ANONYMOUS;
			boolean userHasCheckinRights = loginManager.getService().userHasCheckinRights(project.getOid());
			boolean hasEditRights = loginManager.getService().userHasRights(project.getOid());
			boolean hasCreateProjectRights = (loginManager.getUserType() == SUserType.ADMIN || loginManager.getService().isSettingAllowUsersToCreateTopLevelProjects());
			boolean o3dEnabled = loginManager.getService().hasActiveSerializer("application/json");
			boolean kmzEnabled = loginManager.getService().hasActiveSerializer("application/vnd.google-earth.kmz");
			if (o3dEnabled && lastRevision != null) {
%>
<jsp:include page="o3d.jsp" />
<%
	}
%>
<div class="sidebar">
	<ul>
		<%
			if (hasEditRights) {
		%>
		<li><a class="link" href="editproject.jsp?poid=<%=poid%>">Edit</a>
		</li>
		<%
			}
		%>
		<%
			if (o3dEnabled && lastRevision != null) {
		%>
		<li><a id="visualiselink" class="link">Visualise</a></li>
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
	<br /><%=JspHelper.showProjectTree(project, loginManager.getService())%>
</div>

<div class="content">
	<%
		if (request.getParameter("message") != null) {
					out.println("<div class=\"error\">" + request.getParameter("message") + "</div>");
				}
	%>
	<div id="guide">
		<div id="guidewrap">
			<ol id="breadcrumb">
				<li><%=JspHelper.generateBreadCrumbPath(project, loginManager.getService())%></li>
			</ol>
		</div>
	</div>

	<h1>
		Project details (<%=project.getName()%>)
	</h1>
	<div class="tabber" id="projecttabber">
		<div class="tabbertab" id="detailstab" title="Details">
			<%
				if (project.getRevisions().isEmpty()) {
							if (userHasCheckinRights) {
			%>
			<div class="info">
				<img src="images/warning.png" alt="warning" />There are no
				revisions yet, click <a id="revisiontablink" href="#">on the
					revisions tab</a> to add a first revision, or <a id="subprojecttablink"
					href="#">add a subproject.</a>
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
								SProject parentProject = loginManager.getService().getProjectByPoid(project.getParentId());
				%>
				<tr>
					<td class="first">Parent</td>
					<td><a href="project.jsp?poid=<%=parentProject.getOid()%>"><%=parentProject.getName()%></a>
					</td>
				</tr>
				<%
					}
							SUser createdBy = loginManager.getService().getUserByUoid(project.getCreatedById());
							SGeoTag geoTag = loginManager.getService().getGeoTag(project.getGeoTagId());
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
					<td><a href="user.jsp?uoid=<%=lastRevision.getUserId()%>"><%=loginManager.getService().getUserByUoid(lastRevision.getUserId()).getUsername()%></a></td>
				</tr>
				<%
					}
				%>
				<tr>
					<td class="first">State</td>
					<td><%=project.getState().name().toLowerCase()%></td>
				</tr>
				<tr>
					<td class="first">Anonymous access</td>
					<td><%=anonymousAccess%></td>
				</tr>
				<tr>
					<td class="first">Description</td>
					<td><%=project.getDescription()%></td>
				</tr>
				<%
					if (kmzEnabled) {
								String url = WebUtils.getWebServer(request.getRequestURL().toString());
								String link = "http://" + url + getServletContext().getContextPath() + "download?poid=" + project.getOid() + "&serializerName=KMZ";
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
					if (geoTag.isEnabled()) {
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
					<table>
						<tr class="downloadframe">
							<td>Download:</td>
							<td><select name="serializerName"
								id="detailsdownloadcheckoutselect">
									<%
										for (SSerializer serializer : loginManager.getService().getEnabledSerializers()) {
									%>
									<option value="<%=serializer.getName()%>"
										<%=serializer.isDefaultSerializer() ? " SELECTED=\"SELECTED\"" : ""%>><%=serializer.getName()%></option>
									<%
										}
									%>
							</select></td>
							<td><label for="simplezip_<%=lastRevision.getId()%>">Zip</label>
							</td>
							<td><input type="checkbox" name="zip"
								id="simplezip_<%=lastRevision.getId()%>" />
							</td>
							<td><input type="hidden" name="roid"
								value="<%=lastRevision.getOid()%>" />
								<button value="Download" type="button">Download</button>
							</td>
							<%
								if (userHasCheckinRights) {
							%>
							<td>
								<button class="checkoutButton" id="detailscheckoutbutton"
									type="button" value="Checkout">Checkout</button>
							</td>
							<%
								}
							%>
						</tr>
					</table>
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
					<table>
						<tr class="downloadframe">
							<td>Download:</td>
							<td><select name="serializerName">
									<%
										for (SSerializer serializer : loginManager.getService().getEnabledSerializers()) {
									%>
									<option value="<%=serializer.getName()%>"
										<%=serializer.isDefaultSerializer() ? " SELECTED=\"SELECTED\"" : ""%>><%=serializer.getName()%></option>
									<%
										}
									%>
							</select>
							</td>
							<td><label for="advancedzip_<%=lastRevision.getId()%>">Zip
							</label> <input type="checkbox" name="zip"
								id="advancedzip_<%=lastRevision.getId()%>" />
							</td>
							<td><input type="hidden" name="multiple" value="true">
								<input type="hidden" name="roid"
								value="<%=lastRevision.getOid()%>">
								<button value="Download" type="button">Download</button>
							</td>
						</tr>
					</table>

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
										SProject subProject = loginManager.getService().getProjectByPoid(subPoid);
										subProjects.add(subProject);
									} catch (UserException e) {
									}
								}
								for (SProject subProject : subProjects) {
									SRevision lastSubProjectRevision = null;
									if (subProject.getLastRevisionId() != -1) {
										lastSubProjectRevision = loginManager.getService().getRevision(subProject.getLastRevisionId());
									}
				%>
				<tr
					<%=(loginManager.getService().userHasCheckinRights(subProject.getOid()) == true ? "" : " class=\"checkinrights\"")%>
					<%=subProject.getState() == SObjectState.DELETED ? " class=\"deleted\"" : ""%>>
					<td><a href="project.jsp?poid=<%=subProject.getOid()%>"><%=subProject.getName()%></a>
					</td>
					<td><%=lastSubProjectRevision == null ? "No revisions" : ("<a href=\"revision.jsp?roid=" + lastSubProjectRevision.getOid() + "\">"
									+ lastSubProjectRevision.getId() + "</a> by <a href=\"user.jsp?id=" + lastSubProjectRevision.getUserId() + "\">"
									+ loginManager.getService().getUserByUoid(lastSubProjectRevision.getUserId()).getUsername() + "</a>")%></td>
					<td><%=subProject.getRevisions().size()%></td>
					<td><%=subProject.getCheckouts().size()%></td>
					<td><%=subProject.getHasAuthorizedUsers().size()%></td>
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

		<div class="tabbertab" id="revisionstab"
			title="Revisions<%=revisions.size() == 0 ? "" : " (" + revisions.size() + ")"%>">
			<%
				Set<String> checkoutWarnings = loginManager.getService().getCheckoutWarnings(project.getOid());
						for (String warning : checkoutWarnings) {
							out.write("<div class=\"warning\"><img src=\"images/warning.png\" alt=\"warning\" />" + warning + "</div>");
						}
						if (userHasCheckinRights) {
			%>
			<a href="#" id="uploadlink">Upload (note: Subprojects present)</a>
			<div id="upload"><jsp:include page="upload.jsp"><jsp:param
						name="poid" value="<%=poid %>" /></jsp:include>
				<%
					List<SProject> projects = loginManager.getService().getAllReadableProjects();
								Collections.sort(projects, new SProjectNameComparator());
								if (!projects.isEmpty() && (projects.size() > 1 || !projects.get(0).getRevisions().isEmpty())) {
									boolean atLeastOne = false;
									for (SProject sProject : projects) {
										if (!sProject.getRevisions().isEmpty()) {
											atLeastOne = true;
											break;
										}
									}
									if (atLeastOne) {
				%>
				<form method="post" action="branch.jsp">
					<fieldset>
						<legend>Checkin existing revision</legend>
						<label>Project/Revision</label> <select name="roid">
							<%
								for (SProject sProject : projects) {
														if (!sProject.getRevisions().isEmpty()) {
							%>
							<optgroup label="<%=sProject.getName()%>">
								<%
									List<SRevision> checkinRevisions = loginManager.getService().getAllRevisionsOfProject(sProject.getOid());
																Collections.sort(checkinRevisions, new SRevisionIdComparator(false));
																for (SRevision sRevision : checkinRevisions) {
								%>
								<option value="<%=sRevision.getOid()%>"><%=sRevision.getId()%></option>
								<%
									}
								%>
							</optgroup>
							<%
								}
													}
							%>
						</select> <label>Comment</label> <input type="text" name="comment" /> <input
							type="submit" value="Checkin as new revision" /> <input
							type="hidden" name="action" value="branchtoexistingproject" /> <input
							type="hidden" name="destpoid" value="<%=poid%>" />
					</fieldset>
				</form>
				<%
					}
								}
				%>
			</div>
			<%
				}
						if (revisions.size() > 1) {
			%>
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
					</select> Based on <select name="identifier">
						<option value="GUID_ID">GUID</option>
						<option value="NAME_ID">Name</option>
					</select>
					<button type="submit" name="compare" value="Compare">Compare</button>
				</form>
			</fieldset>
			<%
				}
						if (revisions.size() > 0) {
			%>
			<table class="formatted">
				<tr>
					<th>Id</th>
					<th>Date</th>
					<th>User</th>
					<th>Comment</th>
					<%
						if (project.getParentId() == -1 && sClashDetectionSettings.isEnabled()) {
					%>
					<th>Clashes</th>
					<%
						}
					%>
					<th>Size</th>
					<th>Status / Actions</th>
				</tr>
				<%
					for (SRevision revision : revisions) {
									SUser revisionUser = loginManager.getService().getUserByUoid(revision.getUserId());
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
							<a href="#" class="morelink">more</a>
						</div>
					</td>
					<%
						if (project.getParentId() == -1 && sClashDetectionSettings.isEnabled()) {
					%>
					<td class="clashesfield"><img src="images/ajax-loader.gif"
						align="left"
						style="margin-right: 5px; display: <%=revision.getState() == SCheckinState.SEARCHING_CLASHES ? "block" : "none"%>" />
						<span class="statusfield"> <%
 	if (revision.getState() == SCheckinState.DONE) {
 							out.print(revision.getLastClashes().size());
 						} else if (revision.getState() == SCheckinState.SEARCHING_CLASHES) {
 							out.print("Searching clashes...");
 						} else if (revision.getState() == SCheckinState.CLASHES_ERROR) {
 							out.print("Error: " + revision.getLastError());
 						}
 %> </span></td>
					<%
						}
					%>
					<td class="sizefield"><%=(revision.getState() == SCheckinState.DONE || revision.getState() == SCheckinState.SEARCHING_CLASHES || revision.getState() == SCheckinState.CLASHES_ERROR) ? revision
									.getSize() : ""%></td>
					<td class="downloadfield"><img src="images/ajax-loader.gif"
						align="left"
						style="margin-right: 5px; display: <%=(revision.getState() == SCheckinState.DONE || revision.getState() == SCheckinState.ERROR
									|| revision.getState() == SCheckinState.CLASHES_ERROR || revision.getState() == SCheckinState.SEARCHING_CLASHES) ? "none" : "block"%>" />
						<div id="uploadProgressBar<%=revision.getOid()%>"></div> <span
						class="statusfield"> <%
 	if (revision.getState() == SCheckinState.ERROR) {
 						out.print("Error: " + revision.getState().name().toLowerCase());
 					} else if (revision.getState() == SCheckinState.STORING) {
 						out.print("Storing...");
 					}
 %> </span>
						<div
							class="<%=revision.getState() == SCheckinState.DONE || revision.getState() == SCheckinState.CLASHES_ERROR
									|| revision.getState() == SCheckinState.SEARCHING_CLASHES ? "" : "blockinvisible"%>">
							<table class="cleantable">
								<tr class="downloadframe">
									<td><input type="hidden" name="roid"
										value="<%=revision.getOid()%>" /> <select
										name="serializerName" class="revisionsdownloadcheckoutselect">
											<%
												for (SSerializer serializer : loginManager.getService().getEnabledSerializers()) {
											%>
											<option value="<%=serializer.getName()%>"
												<%=serializer.isDefaultSerializer() ? " SELECTED=\"SELECTED\"" : ""%>><%=serializer.getName()%></option>
											<%
												}
											%>
									</select></td>
									<td><label for="revisionzip_<%=revision.getId()%>">Zip
									</label></td>
									<td><input type="checkbox" name="zip"
										id="revisionzip_<%=revision.getId()%>" />
									</td>
									<td><input type="hidden" name="roid"
										name="<%=revision.getOid()%>" />
										<button type="button" value="Download">Download</button>
									</td>
									<%
										if (userHasCheckinRights) {
									%>
									<td>
										<button type="button" value="Checkout"
											class="revisionscheckoutbutton">Checkout</button>
									</td>
									<%
										}
									%>
								</tr>
							</table>
						</div>
					</td>
				</tr>
				<%
					}
				%>
			</table>
			<%
				} else {
			%>
			<div class="none">
				No revisions<%=userHasCheckinRights ? ", upload a file" : ""%></div>
			<%
				}
			%>
		</div>
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
			</jsp:include></div>
		<div id="clashes" class="tabbertab" title="Clashes">
			<div id="clashdetectiondiv"></div>
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
								if (!checkout.isActive()) {
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
					<th>Status / Actions</th>
				</tr>
				<%
					for (SCheckout checkout : checkouts) {
									SUser checkoutUser = loginManager.getService().getUserByUoid(checkout.getUserId());
				%>
				<tr
					class="<%=checkout.isActive() ? "" : "inactivecheckoutrow"%>">
					<td><a href="revision.jsp?roid=<%=checkout.getRevisionId()%>"><%=loginManager.getService().getRevision(checkout.getRevisionId()).getId()%></a></td>
					<td><a href="user.jsp?uoid=<%=checkout.getUserId()%>"><%=checkoutUser.getUsername()%></a>
					</td>
					<td><%=dateFormat.format(checkout.getDate())%></td>
					<td><%=checkout.isActive()%></td>
					<td>
						<form method="get" action="<%=request.getContextPath()%>/download">
							<input type="hidden" name="roid"
								value="<%=checkout.getRevisionId()%>" /> <select
								name="serializerName">
								<%
									for (SSerializer serializer : loginManager.getService().getEnabledSerializers()) {
								%>
								<option value="<%=serializer.getName()%>"
									<%=serializer.isDefaultSerializer() ? " SELECTED=\"SELECTED\"" : ""%>><%=serializer.getName()%></option>
								<%
									}
								%>
							</select> <label for="checkoutsdownloadzip_<%=checkout.getOid()%>">Zip</label>
							<input type="checkbox" name="zip"
								id="checkoutsdownloadzip_<%=checkout.getOid()%>" /> <input
								name="download" type="submit" value="Download" />
						</form>
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
				if (nonAuthorizedUsers.size() > 0 && hasUserManagementRights) {
			%>
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
			</form>

			<%
				if (loginManager.getService().isSettingAllowSelfRegistration()) {
			%>
			<form method="post" action="addusertoproject.jsp">
				<input type="hidden" name="poid" value="<%=poid%>" /> <input
					type="hidden" name="type" value="invitedUser" /> Invite a new user
				to join this project:<br> <label for="usernamefield">User
					name (= e-mail address):</label><input id="usernamefield" type="email"
					name="username" /> <label for="namefield">Name:</label><input
					id="namefield" type="text" name="name" /> <input type="submit"
					value="Invite" />
			</form>
			<%
				}
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
	</div>

	<script>
	var poid = <%=poid%>;
	var lastRevisionOid = <%=lastRevision == null ? -1 : lastRevision.getOid()%>;
	$(document).ready(function(){
		$("#revisiontablink").click(function (){
			document.getElementById("projecttabber").tabber.tabShow(2);	
			return false;
		});
		$("#subprojecttablink").click(function (){
			document.getElementById("projecttabber").tabber.tabShow(1);
			return false;
		});
<%if (!loginManager.getService().getSubProjects(project.getOid()).isEmpty()) {%>
			$("#uploadlink").show();
			$("#uploadlink").click(function(){
				$("#upload").show();
				$("#uploadlink").hide();
			});
			$("#upload").hide();
<%} else {%>
			$("#upload").show();
			$("#uploadlink").hide();
<%}%>
		var updateInactiveCheckouts = function(){
			if ($('#showinactivecheckouts').is(':checked')) {
				$(".inactivecheckoutrow").show();
			} else {
				$(".inactivecheckoutrow").hide();
			}
		}
		// Crappy MS browser does not understand change
		if (!$.browser.msie) {
			$("#showinactivecheckouts").change(updateInactiveCheckouts);
		}
		updateInactiveCheckouts();
		var refreshFunction = function() {
			$.ajax({ url: "progress", cache: false, context: document.body, data: {poid: poid}, success: function(data){
				if (data.lastRevision != lastRevisionOid) {
					location.reload();
				} else {
					revisions = data.revisions;
					for (result in revisions) {
						var item = revisions[result];
						var state = item.state;
						if (state == "DONE") {
							$("#rev" + item.roid).children(".sizefield").text(item.totalsize);
							$("#rev" + item.roid).children(".downloadfield").children("img").hide();
							$("#rev" + item.roid).children(".downloadfield").children("form").removeClass("blockinvisible");
							$("#rev" + item.roid).children(".downloadfield").children(".statusfield").text("");
							$("#rev" + item.roid).children(".clashesfield").children("img").hide();
							$("#rev" + item.roid).children(".clashesfield").children(".statusfield").text(item.clashes);
						} else if (state == "ERROR") {
							$("#rev" + item.roid).children(".downloadfield").children("img").hide();
							$("#rev" + item.roid).children(".downloadfield").children("form").addClass("blockinvisible");
							$("#rev" + item.roid).children(".downloadfield").children(".statusfield").text("Error: " + item.lastError);
							$("#rev" + item.roid).children(".clashesfield").children("img").hide();
						} else if (state == "SEARCHING_CLASHES") {
							$("#rev" + item.roid).children(".clashesfield").children("img").show();
							$("#rev" + item.roid).children(".clashesfield").children(".statusfield").text("Searching clashes...");
							$("#rev" + item.roid).children(".downloadfield").children(".statusfield").text("");
							$("#rev" + item.roid).children(".downloadfield").children("form").removeClass("blockinvisible");
							$("#rev" + item.roid).children(".downloadfield").children("img").hide();
						} else if (state == "CLASHES_ERROR") {
							$("#rev" + item.roid).children(".clashesfield").children("img").hide();
							$("#rev" + item.roid).children(".clashesfield").children(".statusfield").text("Error: " + item.lastError);
							$("#rev" + item.roid).children(".downloadfield").children(".statusfield").text("");
							$("#rev" + item.roid).children(".downloadfield").children("form").removeClass("blockinvisible");
							$("#rev" + item.roid).children(".downloadfield").children("img").hide();
						} else {
							$("#rev" + item.roid).children(".downloadfield").children("img").hide();
							$("#rev" + item.roid).children(".downloadfield").children("form").addClass("blockinvisible");
							if (state == "STORING") {
								$("#uploadProgressBar" + item.roid).progressbar({"value": item.progress});
								$("#rev" + item.roid).children(".downloadfield").children(".statusfield").text("Storing (" + item.progress + "%)");
							} else {
								$("#rev" + item.roid).children(".downloadfield").children(".statusfield").text("");
							}
							$("#rev" + item.roid).children(".clashesfield").children("img").hide();
						} 
						if (item.islast) {
							$("#rev" + item.roid).addClass("lastrevision");
						} else {
							$("#rev" + item.roid).removeClass("lastrevision");
						}
					}
			    }
			}});
		};
<%boolean shouldRefresh = false;
					for (long roid : project.getRevisions()) {
						if (loginManager.getService().getRevision(roid).getState() != SCheckinState.DONE) {
							shouldRefresh = true;
						}
					}
					if (shouldRefresh) {%>
		refreshFunction();
		window.setInterval(refreshFunction, 1000);
<%}%>
	});
</script>
	<%
		if (lastRevision != null) {
	%>
	<script>
	$(document).ready(function(){
		$('button[value="Download"]').click(function(event){
			var progressDiv = $("<div>");
			$(this).parent().append(progressDiv);
			var downloadframe = $(event.target).parent().parent();
			var roid = downloadframe.find('input[name="roid"]');
			var serializerName = downloadframe.find('select[name="serializerName"]');
			var zipbox = downloadframe.find('input[name="zip"]');
			var zip = "";
			if (zipbox.attr('checked')) {
				zip = "&zip=on";
			}
			var multiple = downloadframe.find('input[name="multiple"]');
			if (multiple.val() != "undefined") {
				progressDiv.load("initiatedownload.jsp?roid=" + roid.val() + "&serializerName=" + serializerName.val() + zip + "&download=Download");
			} else {
				progressDiv.load("initiatedownload.jsp?roid=" + roid.val() + "&serializerName=" + serializerName.val() + zip + "&multiple=" + multiple.val() + "&download=Download");				
			}
		});
		$('button[value="Checkout"]').click(function(){
			var progressDiv = $("<div>");
			$(this).parent().append(progressDiv);
			var downloadframe = $(event.target).parent().parent();
			var roid = downloadframe.find('input[name="roid"]');
			var serializerName = downloadframe.find('select[name="serializerName"]');
			var zipbox = downloadframe.find('input[name="zip"]');
			var zip = "";
			if (zipbox.attr('checked')) {
				zip = "&zip=on";
			}
			progressDiv.load("initiatedownload.jsp?roid=" + roid.val() + "&serializerName=" + serializerName.val() + zip + "&checkout=Checkout");
		});
		
		$("#compareajaxloader").hide();
		$("#browserajaxloader").hide();
<%String clashesUrl = "clashes.jsp?poid=" + poid;
						if (request.getParameter("margin") != null) {
							clashesUrl += "&margin=" + request.getParameter("margin");
						}
						if (request.getParameter("revisions") != null) {
							clashesUrl += "&revisions=" + request.getParameter("revisions");
						}
						if (request.getParameter("ignored") != null) {
							clashesUrl += "&ignored=" + request.getParameter("ignored");
						}%>
		$("#clashdetectiondiv").load("<%=clashesUrl%>");
		$("#compareform").submit(function(){
			$("#compareform").hide();
			$("#compareajaxloader").show();
		});
		$("#browserajaxlink").click(function() {
												$("#browserajaxloader").show();
												$("#browser")
														.load(
																"browser.jsp?roid=<%=lastRevision.getOid()%>");
											});
							$(".commentbox div").css("height", "18px");
							$(".commentbox div").css("width", "200px");
							$(".commentbox div").css("overflow", "hidden");
							$(".commentbox div").each(function(index, element) {
								if ($(element).attr("scrollHeight") == 18) {
									$(element).parent().children("a").hide();
								}
							});
							$(".commentbox .morelink").click(
									function(event) {
										$(event.target).parent()
												.children("div").css("height",
														"auto");
										$(event.target).parent()
												.children("div").css(
														"overflow", "visible");
										$(event.target).hide();
										return false;
									});

							var checkDetailsCheckoutButton = function() {
								$("#detailscheckoutbutton")
										.attr(
												"disabled",
												$(
														"#detailsdownloadcheckoutselect")
														.val() != "Ifc2x3"
														&& $(
																"#detailsdownloadcheckoutselect")
																.val() != "IfcXML");
							};
							// Crappy MS browser does not understand change
							if (!$.browser.msie) {
								$("#detailsdownloadcheckoutselect").change(
										checkDetailsCheckoutButton);
							}
							checkDetailsCheckoutButton();

							var checkRevisionsCheckoutButton = function(event) {
								$(event.target)
										.parent()
										.children(
	".revisionscheckoutbutton")
									.attr(
											"disabled",
											$(event.target).val() != "Ifc2x3"
													&& $(event.target).val() != "IfcXML");
						};
						// Crappy MS browser does not understand change
						if (!$.browser.msie) {
							$(".revisionsdownloadcheckoutselect").change(
								checkRevisionsCheckoutButton);
						}

						$("#visualiselink")
								.click(
										function() {
											showOverlay("Visualisation",
													"visualize.jsp?roid=<%=project.getLastRevisionId()%>");
											return false;
										});

						$("#browserlink")
								.click(
										function() {
											showOverlay("Browser",
													"browser.jsp?roid=<%=project.getLastRevisionId()%>");
											return false;
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
			} catch (UserException e) {
				if (e.getCause() instanceof OutOfMemoryError) {
					response.sendRedirect(getServletContext().getContextPath());
				} else {
					e.printStackTrace();
					out.println(e.getUserMessage());
				}
			} catch (Exception e) {
				LoggerFactory.getLogger("project.jsp").error("", e);
			}
		}
	%>
</div>

<jsp:include page="footer.jsp" />