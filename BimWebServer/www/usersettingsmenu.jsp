<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="org.bimserver.interfaces.objects.SExtendedDataSchema"%>
<%@page import="org.bimserver.interfaces.objects.SSerializerPluginConfiguration"%>
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
<li><a href="usersettings.jsp">User Settings</a></li>
<li><a href="serializers.jsp">Serializers</a></li>
<li><a href="deserializers.jsp">Deserializers</a></li>
<li><a href="objectidms.jsp">Object IDMs</a></li>
<li><a href="renderengines.jsp">Render Engines</a></li>
<li><a href="queryengines.jsp">Query Engines</a></li>
<li><a href="modelmergers.jsp">Model Mergers</a></li>
<li><a href="modelcompares.jsp">Model Compares</a></li>
<li><a href="internalservices.jsp">Internal Services</a></li>
</ul>
</div>
<div class="content">
<%
	ServiceInterface service = null;
	if (loginManager.isLoggedIn()) {
	service = loginManager.getService(request);
%>
<%
	} else {
		out.println("Insufficient rights");
	}
%>
