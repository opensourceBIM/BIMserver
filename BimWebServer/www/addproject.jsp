<%@page import="java.util.List" %>
<%@page import="java.text.DateFormat" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="org.bimserver.utils.Formatters"%>
<%@page import="org.bimserver.shared.UserException"%>
<%@page import="org.bimserver.web.JspHelper"%>
<%@page import="org.bimserver.interfaces.objects.SGeoTag"%>
<%@page import="org.bimserver.interfaces.objects.SClashDetectionSettings"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%@ include file="header.jsp" %>
<!-- start map scripts - many thanks to Bart vd Eijnden www.osgis.nl -->
<script type="text/javascript" src="js/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="js/ext-all.js"></script>
<link rel="stylesheet" type="text/css" href="css/ext-all.css" />
<script type="text/javascript" src="js/OpenLayers.js"></script>
<script type="text/javascript" src="js/ol_overrides.js"></script>
<script type="text/javascript" src="js/GeoExt.js"></script>
<script type="text/javascript" src="js/proj4js.js"></script>
<script type="text/javascript" src="js/map.js"></script>
<!-- end mapscripts -->
<div class="sidebar">
</div>
<div class="content">
<%
	if (loginManager.getService().isLoggedIn()) {
		SProject superProject = null;
		if (request.getParameter("parentoid") != null) {
			superProject = loginManager.getService().getProjectByPoid(Long.parseLong(request.getParameter("parentoid")));
		}
		if (loginManager.getUserType() == SUserType.ADMIN || loginManager.getService().isSettingAllowUsersToCreateTopLevelProjects()) {
			if (request.getParameter("save") != null) {
				try {
					SProject sProject = null;
					SProject parentProject = null;
					if (request.getParameter("parentoid") != null) {
						parentProject = loginManager.getService().getProjectByPoid(Long.parseLong(request.getParameter("parentoid")));
					}
					if (request.getParameter("parentoid") != null) {
						sProject = loginManager.getService().addProjectAsSubProject(request.getParameter("name"), Long.parseLong(request.getParameter("parentoid")));
					} else {
						sProject = loginManager.getService().addProject(request.getParameter("name"));
					}
					if (request.getParameter("anonymous") != null) {
						loginManager.getService().addUserToProject(loginManager.getService().getAnonymousUser().getOid(), sProject.getOid());
					}
					if (request.getParameter("parentoid") == null) {
						SGeoTag sGeoTag = loginManager.getService().getGeoTag(sProject.getGeoTagId());
						sGeoTag.setEnabled(request.getParameter("coordcheck") != null);
						sGeoTag.setDirectionAngle(Float.parseFloat(request.getParameter("directionAngle")));
						sGeoTag.setEpsg(Integer.parseInt(request.getParameter("epsg").substring(5)));
						sGeoTag.setX(Float.parseFloat(request.getParameter("x"))); 
						sGeoTag.setY(Float.parseFloat(request.getParameter("y"))); 
						sGeoTag.setZ(Float.parseFloat(request.getParameter("z")));
						if (sGeoTag.isEnabled()) {
							loginManager.getService().updateGeoTag(sGeoTag);
						}
						SClashDetectionSettings sClashDetectionSettings = loginManager.getService().getClashDetectionSettings(sProject.getClashDetectionSettingsId());
						sClashDetectionSettings.setEnabled(request.getParameter("clashdetection") != null);
						sClashDetectionSettings.setMargin(Float.parseFloat(request.getParameter("margin")));
						if (sClashDetectionSettings.isEnabled()) {
							loginManager.getService().updateClashDetectionSettings(sClashDetectionSettings);
						}
					}
					if (request.getParameter("parentoid") != null) {
						response.sendRedirect("project.jsp?poid=" + request.getParameter("parentoid"));
					} else {
						response.sendRedirect("project.jsp?poid=" + sProject.getOid());
					}
				} catch (NumberFormatException e) {
					out.println("<div class=\"error\">" + e.getMessage() + "</div>");
				} catch (UserException e) {
					JspHelper.showException(out, e);
				}
			}
%>
<h1>Add <%= (superProject != null) ? "sub" : "" %>project<%=superProject != null ? (" (to " + superProject.getName() + ")") : "" %></h1>
<fieldset style="padding: 5px; margin-top: 10px">
<form name="form" method="post" action="addproject.jsp">
<table class="formtable">
<tr>
	<td class="first">Name</td>
	<td><input type="text" name="name" value="<%= request.getParameter("name") != null ? request.getParameter("name") : "" %>"/></td>
</tr>
<tr>
	<td><label for="anonymous" class="checkbox">Anonymous access</label></td>
	<td><input id="anonymous" name="anonymous" type="checkbox" class="checkbox" <%=request.getParameter("anonymous") == null ? "" : "checked=\"checked\"" %>/></td>
</tr>
<% if (request.getParameter("parentoid") == null) { %>
<tr>
	<td><label for="clashdetection">Automatic clashdetection</label></td>
	<td><input id="clashdetection" name="clashdetection" type="checkbox" class="checkbox" <%=request.getParameter("clashdetection") == null ? "" : "checked=\"checked\"" %>/></td>
</tr>
<tr class="clashdetectionrow">
	<td class="indent first">Margin</td>
	<td class="indent"><input type="text" name="margin" value="<%=request.getParameter("margin") != null ? request.getParameter("margin") : "0" %>"/></td>
</tr>
<tr>
	<td><label for="coordcheck" class="checkbox">Geolocate</label></td>
	<td><input id="coordcheck" name="coordcheck" type="checkbox" class="checkbox" <%=request.getParameter("coordcheck") == null ? "" : "checked=\"checked\"" %>/><br/><br/></td>
</tr>
<tr class="coordcheckrow">
	<td class="indent first">X</td>
	<td class="indent"><input type="text" name="x" value="<%= request.getParameter("x") != null ? request.getParameter("x") : "0" %>"/></td>
</tr>
<tr class="coordcheckrow">
	<td class="indent first">Y</td>
	<td class="indent"><input type="text" name="y" value="<%= request.getParameter("y") != null ? request.getParameter("y") : "0" %>"/></td>
</tr>
<tr class="coordcheckrow">
	<td class="indent first">Z</td>
	<td class="indent"><input type="text" name="z" value="<%= request.getParameter("z") != null ? request.getParameter("z") : "0" %>"/></td>
</tr>
<tr class="coordcheckrow">
	<td class="indent first">Direction angle</td>
	<td class="indent"><input type="text" name="directionAngle" value="<%= request.getParameter("directionAngle") != null ? request.getParameter("directionAngle") : "0" %>"/></td>
</tr>
<tr class="coordcheckrow">
	<td class="indent first">EPSG</td>
	<td>
	<select name="epsg">
	<option value="EPSG:4326">4326</option> 
	<option value="EPSG:900913">900913</option> 
	</select>
	</td>
</tr>
<tr class="coordcheckrow">
<td>
Don't know the coordinates? <a href="#" onclick="BIMServer.Viewer.create({width: 650, height: 500, title: 'Map', formid: 'form'});">Use a map!</a>
</td>
</tr>

<% } %>
</table>
<input type="submit" value="Save" name="save"/>
<%
	if (request.getParameter("parentoid") != null) {
%>
<input type="hidden" name="parentoid" value="<%=request.getParameter("parentoid") %>"/>
<%
	}
%>
</form>
</fieldset>
</div>
<script type="text/javascript">
$(document).ready(function(){
	document.form.name.focus();
<% if (request.getParameter("coordcheck") == null) { %>
	$(".coordcheckrow").hide();
<%}%>
<% if (request.getParameter("clashdetection") == null) { %>
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
</script>
<% } else {
%>
<div class="error">Only administrator can create new projects</div>
<%
}
}%>
<%@ include file="footer.jsp" %>