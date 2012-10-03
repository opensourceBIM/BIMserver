<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="org.bimserver.interfaces.objects.SDeserializerPluginDescriptor"%>
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
<%@page import="org.bimserver.shared.interfaces.ServiceInterface"%>
<%@page import="org.bimserver.shared.exceptions.ServiceException"%>
<div class="sidebar">
<ul>
</ul>
</div>
<div class="content">
<h1>Add deserializer (1)</h1>
<fieldset>
<%
	ServiceInterface service = loginManager.getService(request);
	if (request.getParameter("next") != null) {
		response.sendRedirect("adddeserializer2.jsp?type=" + request.getParameter("type"));
	}
%>
<form>
<table>
<tr>
	<td><label for="type">Type</label></td>
	<td><select id="type" name="type">
<%
	for (SDeserializerPluginDescriptor deserializerPluginDescriptor : service.getAllDeserializerPluginDescriptors()) {
		if (request.getParameter("type") != null && deserializerPluginDescriptor.getPluginClassName().equals(request.getParameter("type"))) {
%>
		<option value="<%=deserializerPluginDescriptor.getPluginClassName()%>" selected="selected"><%=deserializerPluginDescriptor.getPluginClassName() %></option>
<%
		} else {
%>
		<option value="<%=deserializerPluginDescriptor.getPluginClassName()%>"><%=deserializerPluginDescriptor.getPluginClassName() %></option>
<%			
		}
	}
%>
	</select></td>
</tr>
<tr>
	<td></td>
	<td><input name="next" type="submit" value="Next"/></td>
</tr>
</table>
</form>
</fieldset>
</div>
<%@ include file="footer.jsp"%>