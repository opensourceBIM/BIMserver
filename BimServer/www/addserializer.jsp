<%@page import="org.bimserver.interfaces.objects.SIgnoreFile"%>
<%@page import="org.bimserver.interfaces.objects.SSerializer"%>
<%@ include file="header.jsp"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="org.bimserver.utils.Formatters"%>
<%@page import="org.bimserver.shared.DatabaseInformation"%>
<%@page import="org.bimserver.version.VersionChecker"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="org.bimserver.ServerInitializer"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.bimserver.shared.ResultType"%>
<%@page import="org.apache.commons.io.IOUtils"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%@page import="org.bimserver.shared.ServiceInterface"%>
<%@page import="org.bimserver.shared.UserException"%>
<div class="sidebar">
<ul>
</ul>
</div>
<div class="content">
<%
	ServiceInterface service = loginManager.getService();
%>
<form>
<table>
<tr>
	<td><label for="name">Name</label></td>
	<td><input name="name" id="name"></input></td>
</tr>
<tr>
	<td><label for="description">Description</label></td>
	<td><input name="description" id="description"></input></td>
</tr>
<tr>
	<td><label for="type">Type</label></td>
	<td><select id="type" name="type"></select></td>
</tr>
<tr>
	<td><label for="ignorefile">Ignore file</label></td>
	<td><select name="ignorefile" id="ignorefile"></select></td>
</tr>
<tr>
	<td></td>
	<td><input type="submit" value="Next"/></td>
</tr>
</table>
</form>
</div>
<%@ include file="footer.jsp"%>