<%@ include file="header.jsp"%>
<%@page import="org.bimserver.interfaces.objects.SIgnoreFile"%>
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
<h1>Add serializer</h1>
<%
	ServiceInterface service = loginManager.getService();
	if (request.getParameter("next") != null) {
		SSerializer serializer = new SSerializer();
		serializer.setName(request.getParameter("name"));
		serializer.setDescription(request.getParameter("description"));
		serializer.setEnabled(true);
		try {
			serializer.setIgnoreFileId(Long.parseLong(request.getParameter("ignorefile")));
		} catch (NumberFormatException e) {
			serializer.setIgnoreFileId(-1);			
		}
		serializer.setClassName(request.getParameter("type"));
		try {
			service.addSerializer(serializer);
			response.sendRedirect("settings.jsp");
		} catch (UserException e) {
			out.println("<div class=\"error\">" + e.getMessage() + "</div>");
		}
	}
%>
<form>
<table>
<tr>
	<td><label for="name">Name</label></td>
	<td><input name="name" id="name" value="<%=request.getParameter("name") != null ? request.getParameter("name") : ""%>"></input></td>
</tr>
<tr>
	<td><label for="description">Description</label></td>
	<td><input name="description" id="description" value="<%=request.getParameter("description") != null ? request.getParameter("description") : ""%>"></input></td>
</tr>
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
	<td><label for="ignorefile">Ignore file</label></td>
	<td><select name="ignorefile" id="ignorefile">
		<option value="[none]">[None]</option>
<%
	for (SIgnoreFile ignoreFile : service.getAllIgnoreFiles()) {
%>
	<option value="<%=ignoreFile.getOid()%>"<%=(request.getParameter("ignorefile") != null && request.getParameter("ignorefile").equals("" + ignoreFile.getOid())) ? " selected=\"selected\"" : "" %>><%=ignoreFile.getName()%></option>
<%
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
</div>
<script>
$(function(){
	$("#name").focus();
});
</script>
<%@ include file="footer.jsp"%>