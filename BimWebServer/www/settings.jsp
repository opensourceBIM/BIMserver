<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="org.bimserver.interfaces.objects.SModelCompare"%>
<%@page import="org.bimserver.interfaces.objects.SModelMerger"%>
<%@page import="org.bimserver.interfaces.objects.SQueryEngine"%>
<%@page import="org.bimserver.interfaces.objects.SExtendedDataSchema"%>
<%@page import="org.bimserver.interfaces.objects.SIfcEngine"%>
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
<li><a href="serializers.jsp">Serializers</a></li>
<li><a href="deserializers.jsp">Deserializers</a></li>
<li><a href="objectidms.jsp">Object IDMs</a></li>
<li><a href="renderengines.jsp">Render Engines</a></li>
<li><a href="queryengines.jsp">Query Engines</a></li>
<li><a href="modelmergers.jsp">Model Mergers</a></li>
<li><a href="modelcompares.jsp">Model Compares</a></li>
<li><a href="extendeddataschemas.jsp">Extended Data Schemas</a></li>
</ul>
</div>
<div class="content">
<%
	ServiceInterface service = null;
	if (loginManager.isLoggedIn() && loginManager.getUserType() == SUserType.ADMIN) {
	service = loginManager.getService();
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
		} else if (action.equals("enableQueryEngine")) {
			SQueryEngine queryEngine = loginManager.getService().getQueryEngineByName(request.getParameter("queryEngine"));
			queryEngine.setEnabled(true);
			loginManager.getService().updateQueryEngine(queryEngine);
		} else if (action.equals("disableQueryEngine")) {
			SQueryEngine queryEngine = loginManager.getService().getQueryEngineByName(request.getParameter("queryEngine"));
			queryEngine.setEnabled(false);
			loginManager.getService().updateQueryEngine(queryEngine);
		} else if (action.equals("enableModelMerger")) {
			SModelMerger modelMerger = loginManager.getService().getModelMergerByName(request.getParameter("modelMerger"));
			modelMerger.setEnabled(true);
			loginManager.getService().updateModelMerger(modelMerger);
		} else if (action.equals("disableModelMerger")) {
			SModelMerger modelMerger = loginManager.getService().getModelMergerByName(request.getParameter("modelMerger"));
			modelMerger.setEnabled(false);
			loginManager.getService().updateModelMerger(modelMerger);
		} else if (action.equals("enableModelCompare")) {
			SModelCompare modelCompare = loginManager.getService().getModelCompareByName(request.getParameter("modelCompare"));
			modelCompare.setEnabled(true);
			loginManager.getService().updateModelCompare(modelCompare);
		} else if (action.equals("disableModelCompare")) {
			SModelCompare modelCompare = loginManager.getService().getModelCompareByName(request.getParameter("modelCompare"));
			modelCompare.setEnabled(false);
			loginManager.getService().updateModelCompare(modelCompare);
		}
	}
%>
<%
	} else {
		out.println("Insufficient rights");
	}
%>
