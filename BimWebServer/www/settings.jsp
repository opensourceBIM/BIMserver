<%@page import="org.bimserver.interfaces.objects.SDeserializer"%>
<%@page import="org.bimserver.interfaces.objects.SSerializer"%>
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
<%@page import="org.bimserver.interfaces.objects.SGuidanceProvider"%>
<div class="sidebar">
<ul>
</ul>
</div>
<div class="content">
<h1>Settings</h1>
<%
	if (loginManager.isLoggedIn() && loginManager.getUserType() == SUserType.ADMIN) {
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
		} else if (action.equals("disableDeserializer")) {
			SDeserializer deserializer = loginManager.getService().getDeserializerByName(request.getParameter("deserializer"));
			deserializer.setEnabled(false);
			loginManager.getService().updateDeserializer(deserializer);
		} else if (action.equals("enableDeserializer")) {
			SDeserializer deserializer = loginManager.getService().getDeserializerByName(request.getParameter("deserializer"));
			deserializer.setEnabled(true);
			loginManager.getService().updateDeserializer(deserializer);
		} else if (action.equals("disableGuidanceProvider")) {
			SGuidanceProvider guidanceProvider = loginManager.getService().getGuidanceProviderByName(request.getParameter("guidanceProvider"));
			guidanceProvider.setEnabled(false);
			loginManager.getService().updateGuidanceProvider(guidanceProvider);
		} else if (action.equals("enableGuidanceProvider")) {
			SGuidanceProvider guidanceProvider = loginManager.getService().getGuidanceProviderByName(request.getParameter("guidanceProvider"));
			guidanceProvider.setEnabled(true);
			loginManager.getService().updateGuidanceProvider(guidanceProvider);
		}
	}
%>
<div class="tabber" id="settingstabber">
<div class="tabbertab" id="ignorefilestab" title="Guidance Providers">
<a href="addguidanceprovider.jsp">Add objectIDM</a>
<table class="formatted">
<tr><th>Name</th><th>Classname</th><th>Serializers</th><th>State</th><th>Actions</th></tr>
<%
	List<SGuidanceProvider> guidanceProviders = service.getAllGuidanceProviders();
	for (SGuidanceProvider guidanceProvider : guidanceProviders) {
%>
	<tr>
		<td><a href="guidanceprovider.jsp?id=<%=guidanceProvider.getOid()%>"><%=guidanceProvider.getName() %></a></td>
		<td><%=guidanceProvider.getClassName() %></td>
		<td><%=guidanceProvider.getSerializers().size() %></td>
		<td class="<%=guidanceProvider.isEnabled() ? "enabledGuidanceProvider" : "disabledGuidanceProvider" %>"> <%=guidanceProvider.isEnabled() ? "Enabled" : "Disabled" %></td>
		<td>
		<%
	if (guidanceProvider.isEnabled()) {
%>
<a href="settings.jsp?action=disableGuidanceProvider&guidanceProvider=<%=guidanceProvider.getName() %>">Disable</a>
<%
	} else {
%>
<a href="settings.jsp?action=enableGuidanceProvider&guidanceProvider=<%=guidanceProvider.getName() %>">Enable</a>
<%
	}
%>
			<a href="deleteguidanceprovider.jsp?ifid=<%=guidanceProvider.getOid()%>">Delete</a>
		</td>
	</tr>
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
		<td><a href="serializer.jsp?id=<%=serializer.getOid()%>"><%=serializer.getName() %></a></td>
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
<div class="tabbertab" id="deserializerstab" title="Deserializers">
<a href="adddeserializer1.jsp">Add Deserializer</a>
<table class="formatted">
<tr><th>Name</th><th>Description</th><th>Type</th><th>Ignore file</th><th>State</th><th>Actions</th></tr>
<%
	List<SDeserializer> deserializers = service.getAllDeserializers(false);
	for (SDeserializer deserializer : deserializers) {
%>
	<tr>
		<td><a href="deserializer.jsp?id=<%=deserializer.getOid()%>"><%=deserializer.getName() %></a></td>
		<td><%=deserializer.getDescription() %></td>
		<td><%=deserializer.getClassName() %></td>
		<td class="<%=deserializer.isEnabled() ? "enabledDeserializer" : "disabledDeserializer" %>"> <%=deserializer.isEnabled() ? "Enabled" : "Disabled" %></td>
		<td>
<%
	if (deserializer.isEnabled()) {
%>
<a href="settings.jsp?action=disableDeserializer&deserializer=<%=deserializer.getName() %>">Disable</a>
<%
	} else {
%>
<a href="settings.jsp?action=enableDeserializer&deserializer=<%=deserializer.getName() %>">Enable</a>
<%
	}
%>
			<a href="deletedeserializer.jsp?sid=<%=deserializer.getOid()%>">Delete</a>
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