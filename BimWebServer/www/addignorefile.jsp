<%@ include file="header.jsp"%>
<%@page import="org.bimserver.interfaces.objects.SSerializer"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="org.bimserver.utils.Formatters"%>
<%@page import="org.bimserver.shared.DatabaseInformation"%>
<%@page import="org.bimserver.version.VersionChecker"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="org.bimserver.web.WarServerInitializer"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.apache.commons.io.IOUtils"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%@page import="org.bimserver.shared.ServiceInterface"%>
<%@page import="org.bimserver.shared.UserException"%>
<%@page import="org.bimserver.interfaces.objects.SGuidanceProvider"%>
<div class="sidebar">
<ul>
</ul>
</div>
<div class="content">
<%
	ServiceInterface service = loginManager.getService();
	if (request.getParameter("add") != null) {
		SGuidanceProvider guidanceProvider = new SGuidanceProvider();
		guidanceProvider.setName(request.getParameter("name"));
	}
%>
<form action="settings">
<table>
<tr>
	<td><label for="name">Name</label></td>
	<td><input name="name" id="name"></input></td>
</tr>
<tr>
	<td><label for="ignorefile">File</label></td>
	<td><input name="ignorefile" id="ignorefile" type="file"></input></td>
</tr>
<tr>
	<td></td>
	<td><input type="submit" name="add" value="Add"/></td>
</tr>
</table>
</form>
</div>
<%@ include file="footer.jsp"%>