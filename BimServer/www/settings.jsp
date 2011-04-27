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
	<li><a href="<%=getServletContext().getContextPath()%>/settings?action=downloadignorefile">Download ignore.xml</a></li>
	<li><a href="<%=getServletContext().getContextPath()%>/settings?action=downloadsettingsfile">Download settings.xml</a></li>
</ul>
</div>
<div class="content">
<%
	ServiceInterface service = loginManager.getService();
%>
<div class="tabber" id="settingstabber">
<div class="tabbertab" id="ignorefilestab" title="Ignore files">
<form enctype="multipart/form-data" method="post" action="<%=getServletContext().getContextPath()%>/serversettings.jsp">
<table class="formatted infotable">
	<tr>
		<td>Download</td>
		<td><a href="<%=getServletContext().getContextPath()%>/settings?action=downloadignorefile">Download ignore.xml</a></td>
	</tr>
	<tr>
		<td>Upload</td>
		<td><input type="file" name="ignorefile"></input><input type="submit" value="Upload"></input></td>
	</tr>
</table>
<input type="hidden" name="action" value="uploadsettings" /></form>
</div>
<div class="tabbertab" id="serializerstab" title="Serializers">
<table>
<tr><th>Name</th><th>Description</th><th>Type</th><th>Ignore file</th></tr>
<%
	List<SSerializer> serializers = service.getAllSerializers();
	for (SSerializer serializer : serializers) {
		SIgnoreFile ignoreFile = null;
		if (serializer.getIgnoreFileId() != -1) {
			ignoreFile = service.getIgnoreFileById(serializer.getIgnoreFileId());
		}
%>
	<tr><td><%=serializer.getName() %></td><td><%=serializer.getDescription() %></td><td><%=serializer.getClassName() %></td><td><%=ignoreFile == null ? "none" : ignoreFile.getName() %></td></tr>
<%
	}
%>
</table>
<form enctype="multipart/form-data" method="post"
	action="<%=getServletContext().getContextPath()%>/settings">
<table class="formatted infotable">
	<tr>
		<td>Download</td>
		<td><a
			href="<%=getServletContext().getContextPath()%>/settings?action=downloadcolladasettings">Download collada.xml</a></td>
	</tr>
	<tr>
		<td>Upload</td>
		<td><input type="file" name="colladasettings"></input><input type="submit" value="Upload"></input></td>
	</tr>
</table>
<input type="hidden" name="action" value="uploadcolladasettings" /></form>
</div>
</div>
<%@ include file="footer.jsp"%>