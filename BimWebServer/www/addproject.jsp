<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.List" %>
<%@page import="java.text.DateFormat" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="org.bimserver.utils.Formatters"%>
<%@page import="org.bimserver.shared.exceptions.ServiceException"%>
<%@page import="org.bimwebserver.jsp.JspHelper"%>
<%@page import="org.bimserver.interfaces.objects.SGeoTag"%>
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
	if (loginManager.isLoggedIn()) {
		SProject superProject = null;
		if (request.getParameter("parentoid") != null) {
			superProject = loginManager.getService(request).getProjectByPoid(Long.parseLong(request.getParameter("parentoid")));
		}
		if (loginManager.getUserType() == SUserType.ADMIN || loginManager.getService(request).isSettingAllowUsersToCreateTopLevelProjects()) {
			if (request.getParameter("save") != null) {
				try {
					SProject sProject = null;
					SProject parentProject = null;
					if (request.getParameter("parentoid") != null) {
						parentProject = loginManager.getService(request).getProjectByPoid(Long.parseLong(request.getParameter("parentoid")));
					}
					if (request.getParameter("parentoid") != null) {
						sProject = loginManager.getService(request).addProjectAsSubProject(request.getParameter("name"), Long.parseLong(request.getParameter("parentoid")));
					} else {
						sProject = loginManager.getService(request).addProject(request.getParameter("name"));
					}
					if (request.getParameter("parentoid") == null) {
						SGeoTag sGeoTag = loginManager.getService(request).getGeoTag(sProject.getGeoTagId());
						sGeoTag.setEnabled(request.getParameter("coordcheck") != null);
						sGeoTag.setDirectionAngle(Double.parseDouble(request.getParameter("directionAngle")));
						sGeoTag.setEpsg(Integer.parseInt(request.getParameter("epsg").substring(5)));
						sGeoTag.setX(Double.parseDouble(request.getParameter("x"))); 
						sGeoTag.setY(Double.parseDouble(request.getParameter("y"))); 
						sGeoTag.setZ(Double.parseDouble(request.getParameter("z")));
						if (sGeoTag.getEnabled()) {
							loginManager.getService(request).updateGeoTag(sGeoTag);
						}
					}
					if (request.getParameter("parentoid") != null) {
						response.sendRedirect("project.jsp?poid=" + request.getParameter("parentoid"));
					} else {
						response.sendRedirect("project.jsp?poid=" + sProject.getOid());
					}
				} catch (NumberFormatException e) {
					out.println("<div class=\"error\">" + e.getMessage() + "</div>");
				} catch (ServiceException e) {
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
<% if (request.getParameter("parentoid") == null) { %>
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
$(function(){
	document.form.name.focus();
<% if (request.getParameter("coordcheck") == null) { %>
	$(".coordcheckrow").hide();
<%}%>
	$("#coordcheck").click(function(){
		if ($("#coordcheck").attr('checked')) {
			$(".coordcheckrow").show();
		} else {
			$(".coordcheckrow").hide();
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