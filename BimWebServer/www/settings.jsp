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
<h1>Settings</h1>
<%
	if (loginManager.getService().isLoggedIn() && loginManager.getUserType() == SUserType.ADMIN) {
	ServiceInterface service = loginManager.getService();
	if (request.getParameter("action") != null) {
		String action = request.getParameter("action");
		if (action.equals("disableSerializer")) {
			SSerializer serializer = loginManager.getService().getSerializerByName(request.getParameter("serializer"));
			serializer.setEnabled(false);
			loginManager.getService().updateSerializer(serializer);
		} else if (action.equals("enableSerializer")) {
			SSerializer serializer = loginManager.getService().getSerializerByName(request.getParameter("serializer"));
			serializer.setEnabled(true);
			loginManager.getService().updateSerializer(serializer);
		}
	}
%>
<div class="tabber" id="settingstabber">
<div class="tabbertab" id="ignorefilestab" title="Guidance Providers">
<a href="addguidanceprovider.jsp">Add Guidance Provider</a>
<table class="formatted">
<tr><th>Name</th><th>Serializers</th><th>Actions</th></tr>
<%
	List<SGuidanceProvider> guidanceProviders = service.getAllGuidanceProviders();
	for (SGuidanceProvider guidanceProvider : guidanceProviders) {
%>
	<tr>
		<td><%=guidanceProvider.getName() %></td>
		<td><%=guidanceProvider.getSerializers().size() %></td>
		<td><a href="editguidanceprovider.jsp?ifid=<%=guidanceProvider.getOid()%>">Edit</a> <a href="deleteguidanceprovider.jsp?ifid=<%=guidanceProvider.getOid()%>">Delete</a></td></tr>
<%
	}
%>
</table>
</div>
<div class="tabbertab" id="serializerstab" title="Serializers">
<a href="addserializer1.jsp">Add Serializer</a>
<table class="formatted">
<tr><th>Name</th><th>Description</th><th>Type</th><th>Content Type</th><th>Ignore file</th><th>State</th><th>Actions</th></tr>
<%
	List<SSerializer> serializers = service.getAllSerializers(false);
	for (SSerializer serializer : serializers) {
		SGuidanceProvider guidanceProvider = null;
		if (serializer.getGuidanceProviderId() != -1) {
			guidanceProvider = service.getGuidanceProviderById(serializer.getGuidanceProviderId());
		}
%>
	<tr>
		<td><a href="serializer.jsp?name=<%=serializer.getName()%>"><%=serializer.getName() %></a></td>
		<td><%=serializer.getDescription() %></td>
		<td><%=serializer.getClassName() %></td>
		<td><%=serializer.getContentType() %></td>
		<td><%=guidanceProvider == null ? "none" : guidanceProvider.getName() %></td>
		<td class="<%=serializer.isEnabled() ? "enabledSerializer" : "disabledSerializer" %>"> <%=serializer.isEnabled() ? "Enabled" : "Disabled" %></td>
		<td>
<%
	if (serializer.isEnabled()) {
%>
<a href="settings.jsp?action=disableSerializer&serializer=<%=serializer.getName() %>">Disable</a>
<%
	} else {
%>
<a href="settings.jsp?action=enableSerializer&serializer=<%=serializer.getName() %>">Enable</a>
<%
	}
%>
			<a href="deleteserializer.jsp?sid=<%=serializer.getOid()%>">Delete</a>
		</td>
	</tr>
<%
	}
%>
</table>
</div>
</div>
<%
	} else {
		out.println("Insufficient rights");
	}
%>
<%@ include file="footer.jsp"%>