<%@page import="org.bimserver.interfaces.objects.SQueryEnginePluginDescriptor"%>
<%@page import="org.bimserver.interfaces.objects.SQueryEngine"%>
<%@page import="org.bimserver.interfaces.objects.SIfcEnginePluginDescriptor"%>
<%@page import="org.bimserver.interfaces.objects.SIfcEngine"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="header.jsp"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="org.bimserver.utils.Formatters"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.apache.commons.io.IOUtils"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%@page import="org.bimserver.shared.ServiceInterface"%>
<%@page import="org.bimserver.shared.exceptions.ServiceException"%>
<div class="sidebar">
<ul>
</ul>
</div>
<div class="content">
<h1>Add Query Engine</h1>
<fieldset>
<%
	ServiceInterface service = loginManager.getService();
	if (request.getParameter("add") != null) {
		SQueryEngine queryEngine = new SQueryEngine();
		queryEngine.setName(request.getParameter("name"));
		queryEngine.setClassName(request.getParameter("className"));
		queryEngine.setEnabled(true);
		loginManager.getService().addQueryEngine(queryEngine);
		response.sendRedirect("queryengines.jsp");
	}
%>
<form>
<table>
<tr>
	<td><label for="name">Name</label></td>
	<td><input name="name" id="name" class="focusme"></input></td>
</tr>
<tr>
	<td><label for="className">Class</label></td>
	<td><select name="className" id="className">
<%
	for (SQueryEnginePluginDescriptor iepd : loginManager.getService().getAllQueryEnginePluginDescriptors()) {
		out.print("<option value=\"" + iepd.getPluginClassName() + "\">" + iepd.getPluginClassName() + "</option>");
	}
%>
	</select></td>
</tr>
<tr>
	<td></td>
	<td><input type="submit" name="add" value="Add"/></td>
</tr>
</table>
</form>
</fieldset>
</div>
<%@ include file="footer.jsp"%>