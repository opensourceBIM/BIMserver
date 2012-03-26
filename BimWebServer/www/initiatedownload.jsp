<%@page import="org.codehaus.jettison.json.JSONObject"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="org.bimserver.interfaces.objects.SLongActionState"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="org.slf4j.LoggerFactory"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<%
	long roid = Long.parseLong(request.getParameter("roid"));
	String serializerName = "Ifc2x3";
	if (request.getParameter("serializerName") != null) {
		serializerName = request.getParameter("serializerName");
	}
	int longActionId = -1;
	if (request.getParameter("checkout") != null) {
		longActionId = loginManager.getService().checkout(roid, serializerName, false);
	} else if (request.getParameter("download") != null) {
		if (request.getParameter("guids") != null) {
			Set<String> guids = new HashSet<String>();
			for (String guid : request.getParameter("guids").split(";")) {
				guids.add(guid);
			}
			Set<Long> roids = new HashSet<Long>();
			roids.add(roid);
			longActionId = loginManager.getService().downloadByGuids(roids, guids, serializerName, false);
		} else if (request.getParameter("oids") != null) {
			Set<Long> oids = new HashSet<Long>();
			for (String oidString : request.getParameter("oids").split(";")) {
				oids.add(Long.parseLong(oidString));
			}
			Set<Long> roids = new HashSet<Long>();
			roids.add(roid);
			longActionId = loginManager.getService().downloadByOids(roids, oids, serializerName, false);
		} else if (request.getParameter("classes") != null) {
			Set<String> classes = new HashSet<String>();
			for (String className : request.getParameter("classes").split(";")) {
				classes.add(className);
			}
			Set<Long> roids = new HashSet<Long>();
			roids.add(roid);
			longActionId = loginManager.getService().downloadByTypes(roids, classes, serializerName, false, false);
		} else if (request.getParameter("multiple") != null) {
			Set<Long> roids = new HashSet<Long>();
			for (Object key : request.getParameterMap().keySet()) {
				String keyString = (String) key;
				if (keyString.startsWith("download_")) {
					if (!request.getParameter(keyString).equals("[off]")) {
						roids.add(Long.parseLong(request.getParameter(keyString)));
					}
				}
			}
			longActionId = loginManager.getService().downloadRevisions(roids, serializerName, false);
		} else {
			longActionId = loginManager.getService().download(roid, serializerName, true, false);
		}
	}
	JSONObject result = new JSONObject();
	result.put("laid", longActionId);
	result.write(out);
%>