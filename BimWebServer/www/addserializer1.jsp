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
<div class="sidebar">
<ul>
</ul>
</div>
<div class="content">
<h1>Add serializer (1)</h1>
<fieldset>
<%
	ServiceInterface service = loginManager.getService();
	if (request.getParameter("next") != null) {
		response.sendRedirect("addserializer2.jsp?type=" + request.getParameter("type"));
	}
%>
<form>
<table>
<tr>
	<td><label for="type">Type</label></td>
	<td><select id="type" name="type">
<%
	for (String className : service.getAllSerializerClassNames()) {
		if (request.getParameter("type") != null && className.equals(request.getParameter("type"))) {
%>
		<option value="<%=className%>" selected="selected"><%=className %></option>
<%
		} else {
%>
		<option value="<%=className%>"><%=className %></option>
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