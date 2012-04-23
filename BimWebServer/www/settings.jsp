<%@page import="org.bimserver.interfaces.objects.SIfcEngine"%>
<%@ page contentType="text/html; charset=UTF-8" %>
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
<%@page import="org.bimserver.interfaces.objects.SObjectIDM"%>
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
		} else if (action.equals("disableObjectIDM")) {
			SObjectIDM objectIDM = loginManager.getService().getObjectIDMByName(request.getParameter("objectIDM"));
			objectIDM.setEnabled(false);
			loginManager.getService().updateObjectIDM(objectIDM);
		} else if (action.equals("enableObjectIDM")) {
			SObjectIDM objectIDM = loginManager.getService().getObjectIDMByName(request.getParameter("objectIDM"));
			objectIDM.setEnabled(true);
			loginManager.getService().updateObjectIDM(objectIDM);
		} else if (action.equals("disableIfcEngine")) {
			SIfcEngine ifcEngine = loginManager.getService().getIfcEngineByName(request.getParameter("ifcEngine"));
			ifcEngine.setEnabled(false);
			loginManager.getService().updateIfcEngine(ifcEngine);
		} else if (action.equals("enableIfcEngine")) {
			SIfcEngine ifcEngine = loginManager.getService().getIfcEngineByName(request.getParameter("ifcEngine"));
			ifcEngine.setEnabled(true);
			loginManager.getService().updateIfcEngine(ifcEngine);
		}
	}
%>
<div class="tabber" id="settingstabber">
<div class="tabbertab" id="ifcenginestab" title="Render Engines">
<a href="addifcengine.jsp">Add RenderEngine</a>
<table class="formatted">
<tr><th>Name</th><th>Classname</th><th>Serializers</th><th>State</th><th>Actions</th></tr>
<%
	List<SIfcEngine> ifcEngines = service.getAllIfcEngines(false);
	for (SIfcEngine ifcEngine : ifcEngines) {
%>
	<tr>
		<td><a href="ifcengine.jsp?id=<%=ifcEngine.getOid()%>"><%=ifcEngine.getName() %></a></td>
		<td><%=ifcEngine.getClassName() %></td>
		<td><%=ifcEngine.getSerializers().size() %></td>
		<td class="<%=ifcEngine.getEnabled() ? "enabledIfcEngine" : "disabledIfcEngine" %>"> <%=ifcEngine.getEnabled() ? "Enabled" : "Disabled" %></td>
		<td>
		<%
	if (!ifcEngine.getEnabled()) {
%>
<a href="settings.jsp?action=enableIfcEngine&ifcEngine=<%=ifcEngine.getName() %>">Enable</a>
<%
	} else if (ifcEngine.getSerializers().isEmpty()) {
%>
<a href="settings.jsp?action=disableIfcEngine&ifcEngine=<%=ifcEngine.getName() %>">Disable</a>
<%
	}
	if (ifcEngine.getSerializers().isEmpty()) {
%>
			<a href="deleteifcengine.jsp?ifid=<%=ifcEngine.getOid()%>">Delete</a>
<% } %>
		</td>
	</tr>
<%
	}
%>
</table>
</div>
<div class="tabbertab" id="ignorefilestab" title="Object IDMs">
<a href="addobjectidm.jsp">Add ObjectIDM</a>
<table class="formatted">
<tr><th>Name</th><th>Classname</th><th>Serializers</th><th>State</th><th>Actions</th></tr>
<%
	List<SObjectIDM> objectIDMs = service.getAllObjectIDMs(false);
	for (SObjectIDM objectIDM : objectIDMs) {
%>
	<tr>
		<td><a href="objectidm.jsp?id=<%=objectIDM.getOid()%>"><%=objectIDM.getName() %></a></td>
		<td><%=objectIDM.getClassName() %></td>
		<td><%=objectIDM.getSerializers().size() %></td>
		<td class="<%=objectIDM.getEnabled() ? "enabledObjectIDM" : "disabledObjectIDM" %>"> <%=objectIDM.getEnabled() ? "Enabled" : "Disabled" %></td>
		<td>
		<%
	if (!objectIDM.getEnabled()) {
%>
<a href="settings.jsp?action=enableObjectIDM&objectIDM=<%=objectIDM.getName() %>">Enable</a>
<%
	} else if (objectIDM.getSerializers().isEmpty()) {
%>
<a href="settings.jsp?action=disableObjectIDM&objectIDM=<%=objectIDM.getName() %>">Disable</a>
<%
	}
	if (objectIDM.getSerializers().isEmpty()) {
%>
			<a href="deleteobjectidm.jsp?ifid=<%=objectIDM.getOid()%>">Delete</a>
<%} %>
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
<tr><th>Name</th><th>Description</th><th>Type</th><th>Content Type</th><th>ObjectIDM</th><th>Render Engine</th><th>State</th><th>Actions</th></tr>
<%
	List<SSerializer> serializers = service.getAllSerializers(false);
	for (SSerializer serializer : serializers) {
		SObjectIDM objectIDM = null;
		if (serializer.getObjectIDMId() != -1) {
			objectIDM = service.getObjectIDMById(serializer.getObjectIDMId());
		}
		SIfcEngine ifcEngine = null;
		if (serializer.getIfcEngineId() != -1) {
			ifcEngine = service.getIfcEngineById(serializer.getIfcEngineId());
		}
%>
	<tr>
		<td><a href="serializer.jsp?id=<%=serializer.getOid()%>"><%=serializer.getName() %></a></td>
		<td><%=serializer.getDescription() %></td>
		<td><%=serializer.getClassName() %></td>
		<td><%=serializer.getContentType() %></td>
		<td><%=objectIDM == null ? "none" : objectIDM.getName() %></td>
		<td><%=ifcEngine == null ? "none" : ifcEngine.getName() %></td>
		<td class="<%=serializer.getEnabled() ? "enabledSerializer" : "disabledSerializer" %>"> <%=serializer.getEnabled() ? "Enabled" : "Disabled" %></td>
		<td>
<%
	if (serializer.getEnabled()) {
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
<tr><th>Name</th><th>Description</th><th>Type</th><th>State</th><th>Actions</th></tr>
<%
	List<SDeserializer> deserializers = service.getAllDeserializers(false);
	for (SDeserializer deserializer : deserializers) {
%>
	<tr>
		<td><a href="deserializer.jsp?id=<%=deserializer.getOid()%>"><%=deserializer.getName() %></a></td>
		<td><%=deserializer.getDescription() %></td>
		<td><%=deserializer.getClassName() %></td>
		<td class="<%=deserializer.getEnabled() ? "enabledDeserializer" : "disabledDeserializer" %>"> <%=deserializer.getEnabled() ? "Enabled" : "Disabled" %></td>
		<td>
<%
	if (deserializer.getEnabled()) {
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