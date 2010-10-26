<%@page import="java.util.List"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.bimserver.utils.Formatters"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Comparator"%>
<%@page import="org.bimserver.shared.UserException"%>
<%@page import="org.bimserver.EmfSerializerFactory"%>
<%@page import="org.bimserver.shared.ResultType"%>
<%@page import="org.bimserver.JspHelper"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<%@page import="org.bimserver.interfaces.objects.SGeoTag"%>
<%@page	import="org.bimserver.interfaces.objects.SClashDetectionSettings"%>
<%@page import="org.bimserver.interfaces.objects.SUser"%>
<%@page import="org.bimserver.interfaces.objects.SSIPrefix"%>
<%@ include file="header.jsp"%>
<%
	if (loginManager.isLoggedIn()) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		EmfSerializerFactory emfSerializerFactory = EmfSerializerFactory.getInstance();
		long poid = Long.parseLong(request.getParameter("poid"));
		SProject sProject = loginManager.getService().getProjectByPoid(poid);
		boolean anonymousAccess = sProject.getHasAuthorizedUsers().contains(loginManager.getService().getAnonymousUser().getOid());
		try {
			SGeoTag sGeoTag = loginManager.getService().getGeoTag(sProject.getGeoTagId());
			SClashDetectionSettings sClashDetectionSettings = loginManager.getService().getClashDetectionSettings(
					sProject.getClashDetectionSettingsId());
			if (request.getParameter("save") != null) {
				try {
					if (sProject.getParentId() == -1) {
						sGeoTag.setEnabled(request.getParameter("coordcheck") != null);
						sGeoTag.setX(Float.parseFloat(request.getParameter("x")));
						sGeoTag.setY(Float.parseFloat(request.getParameter("y")));
						sGeoTag.setZ(Float.parseFloat(request.getParameter("z")));
						sGeoTag.setDirectionAngle(Float.parseFloat(request.getParameter("directionAngle")));
						sGeoTag.setEpsg(Integer.parseInt(request.getParameter("epsg")));
						loginManager.getService().updateGeoTag(sGeoTag);
						sClashDetectionSettings.setEnabled(request.getParameter("clashdetection") != null);
						sClashDetectionSettings.setMargin(Float.parseFloat(request.getParameter("margin")));
						loginManager.getService().updateClashDetectionSettings(sClashDetectionSettings);
					}
					sProject.setName(request.getParameter("name"));
					sProject.setDescription(request.getParameter("description"));
					sProject.setExportLengthMeasurePrefix(SSIPrefix.values()[Integer.parseInt(request.getParameter("exportLengthMeasurePrefix"))]);
					loginManager.getService().updateProject(sProject);
					SUser anonymousUser = loginManager.getService().getAnonymousUser();
					if (request.getParameter("anonymous") == null) {
						if (anonymousAccess) {
							loginManager.getService().removeUserFromProject(anonymousUser.getOid(), poid);
						}
					} else {
						loginManager.getService().addUserToProject(anonymousUser.getOid(), poid);
					}
					response.sendRedirect("project.jsp?poid=" + poid);
				} catch (UserException e) {
					out.println("<div class=\"error\">" + e.getMessage() + "</div>");
				}
			}
%>
<div class="sidebar"></div>

<div class="content">
<h1>Project details (<%=sProject.getName()%>)</h1>
<%
	if (request.getParameter("message") != null) {
				out.println("<div class=\"error\">" + request.getParameter("message") + "</div>");
			}
%>
<div id="guide">
  <div id="guidewrap">
    <ol id="breadcrumb">
	  <li><%=JspHelper.generateBreadCrumbPath(sProject, loginManager.getService())%></li>
    </ol>
  </div>
</div>
<div id="guide_wrap_btm"></div>
<div class="tabber" id="projecttabber">
<div class="tabbertab" id="detailstab" title="Details">
<form method="post" action="editproject.jsp">
<table class="formtable">
	<tr>
		<td class="first">Name</td>
		<td><input type="text" name="name"
			value="<%=request.getParameter("name") != null ? request.getParameter("name") : sProject.getName()%>" /></td>
	</tr>
	<tr>
		<td class="first">Description</td>
		<td><textarea name="description" cols="80" rows="5"><%=request.getParameter("description") != null ? request.getParameter("description") : sProject.getDescription()%></textarea></td>
	</tr>
	<tr>
		<td><label for="anonymous" class="checkbox">Anonymous
		access</label></td>
		<td><input id="anonymous" name="anonymous" type="checkbox"
			class="checkbox" <%=anonymousAccess ? "checked=\"checked\"" : ""%> /></td>
	</tr>
	<%
		if (sProject.getParentId() == -1) {
	%>
	<tr>
		<td><label for="clashdetection" class="checkbox">Automatic
		clashdetection</label></td>
		<td><input id="clashdetection" name="clashdetection"
			class="checkbox" type="checkbox"
			<%=sClashDetectionSettings.isEnabled() ? "checked=\"checked\"" : ""%> /></td>
	</tr>
	<tr class="clashdetectionrow">
		<td class="indent first">Margin</td>
		<td class="indent"><input type="text" name="margin"
			value="<%=sClashDetectionSettings.getMargin()%>" /></td>
	</tr>
	<tr>
		<td><label for="coordcheck" class="checkbox">Geolocate</label></td>
		<td><input id="coordcheck" name="coordcheck" class="checkbox"
			type="checkbox" <%=sGeoTag.isEnabled() ? "checked=\"checked\"" : ""%> /></td>
	</tr>
	<tr class="coordcheckrow">
		<td class="indent first">X</td>
		<td class="indent"><input type="text" name="x"
			value="<%=sGeoTag.getX()%>" /></td>
	</tr>
	<tr class="coordcheckrow">
		<td class="indent first">Y</td>
		<td class="indent"><input type="text" name="y"
			value="<%=sGeoTag.getY()%>" /></td>
	</tr>
	<tr class="coordcheckrow">
		<td class="indent first">Z</td>
		<td class="indent"><input type="text" name="z"
			value="<%=sGeoTag.getZ()%>" /></td>
	</tr>
	<tr class="coordcheckrow">
		<td class="indent first">Direction Angle</td>
		<td class="indent"><input type="text" name="directionAngle"
			value="<%=sGeoTag.getDirectionAngle()%>" /></td>
	</tr>
	<tr class="coordcheckrow">
		<td class="indent first">EPSG</td>
		<td class="indent">
		<select name="epsg">
		<option value="<%=sGeoTag.getEpsg()%>"><%=sGeoTag.getEpsg()%></option>
		<option value="<%=sGeoTag.getEpsg()%>">More options will follow later</option>
		</select>
		</td>
	</tr>
	<%
		}
	%>
	<tr>
		<td class="first">Uniform length measure unit for combined
		revisions</td>
		<td><select name=exportLengthMeasurePrefix>
			<%
				SSIPrefix pref = sProject.getExportLengthMeasurePrefix();
						for (SSIPrefix p : SSIPrefix.values()) {
			%>
			<option title="<%=p.name()%>" value="<%=p.ordinal()%>"
				<%=(p == pref ? "selected" : "")%>><%=p.toString().toLowerCase()%></option>
			<%
				}
			%>
		</select></td>
	</tr>
</table>
<input type="submit" value="Save" name="save" /> <input type="hidden"
	name="poid" value="<%=request.getParameter("poid")%>" /></form>
</div>
</div>
<script type="text/javascript">
$(document).ready(function(){
<%if (!sGeoTag.isEnabled()) {%>
	$(".coordcheckrow").hide();
<%}%>
<%if (!sClashDetectionSettings.isEnabled()) {%>
	$(".clashdetectionrow").hide();
<%}%>
	$("#coordcheck").click(function(){
		if ($("#coordcheck").attr('checked')) {
			$(".coordcheckrow").show();
		} else {
			$(".coordcheckrow").hide();
		}
	});
	$("#clashdetection").click(function(){
		if ($("#clashdetection").attr('checked')) {
			$(".clashdetectionrow").show();
		} else {
			$(".clashdetectionrow").hide();
		}
	});
});
</script> <%
 	} catch (UserException e) {
 			out.println(e.getUserMessage());
 		}
 	}
 %>
</div>
<jsp:include page="footer.jsp" />