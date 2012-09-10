<%@page import="com.google.common.base.Charsets"%>
<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="org.codehaus.jettison.json.JSONArray"%>
<%@page import="org.codehaus.jettison.json.JSONTokener"%>
<%@page import="org.bimserver.interfaces.objects.SCompareIdentifier"%>
<%@page import="org.bimserver.interfaces.objects.SCompareType"%>
<%@page import="org.codehaus.jettison.json.JSONObject"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="org.bimserver.interfaces.objects.SLongActionState"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="org.slf4j.LoggerFactory"%>
<jsp:useBean id="loginManager" scope="session"
	class="org.bimserver.web.LoginManager" />
<%
	try {
		JSONObject data = new JSONObject(new JSONTokener(request.getParameter("data")));
		long roid = -1;
		if (data.has("roid")) {
			roid = data.getLong("roid");
		}
		String serializerName = "Ifc2x3";
		if (data.has("serializerName")) {
			serializerName = data.getString("serializerName");
		}
		boolean sync = false;
		if (data.has("sync") && data.getBoolean("sync")) {
			sync = true;
		}
		int longActionId = -1;
		String downloadType = data.getString("downloadType");
		if (downloadType.equals("checkout")) {
			longActionId = loginManager.getService().checkout(roid, serializerName, sync);
		} else if (downloadType.equals("guids")) {
			JSONArray jsonGuids = data.getJSONArray("guids");
			Set<String> guids = new HashSet<String>();
			for (int i = 0; i < jsonGuids.length(); i++) {
				guids.add(jsonGuids.getString(i));
			}
			Set<Long> roids = new HashSet<Long>();
			roids.add(roid);
			longActionId = loginManager.getService().downloadByGuids(roids, guids, serializerName, sync);
		} else if (downloadType.equals("oids")) {
			Set<Long> oids = new HashSet<Long>();
			JSONArray jsonOids = data.getJSONArray("oids");
			for (int i = 0; i < jsonOids.length(); i++) {
				oids.add(jsonOids.getLong(i));
			}
			Set<Long> roids = new HashSet<Long>();
			roids.add(roid);
			longActionId = loginManager.getService().downloadByOids(roids, oids, serializerName, sync);
		} else if (downloadType.equals("classes")) {
			Set<String> classes = new HashSet<String>();
			JSONArray jsonClasses = data.getJSONArray("classes");
			for (int i = 0; i < jsonClasses.length(); i++) {
				classes.add(jsonClasses.getString(i));
			}
			Set<Long> roids = new HashSet<Long>();
			roids.add(roid);
			longActionId = loginManager.getService().downloadByTypes(roids, classes, serializerName, false, sync);
		} else if (downloadType.equals("multiple")) {
			Set<Long> roids = new HashSet<Long>();
			JSONArray jsonRoids = data.getJSONArray("roids");
			for (int i = 0; i < jsonRoids.length(); i++) {
				roids.add(jsonRoids.getLong(i));
			}
			longActionId = loginManager.getService().downloadRevisions(roids, serializerName, sync);
		} else if (downloadType.equals("compare")) {
			SCompareType sCompareType = SCompareType.valueOf(data.getString("type"));
			SCompareIdentifier sCompareIdentifier = SCompareIdentifier.valueOf(data.getString("identifier"));
			Long roid1 = data.getLong("roid1");
			Long roid2 = data.getLong("roid2");
			longActionId = loginManager.getService().downloadCompareResults(serializerName, roid1, roid2, sCompareIdentifier, sCompareType, sync);
		} else if (downloadType.equals("query")) {
			longActionId = loginManager.getService().downloadQuery(roid, data.getLong("qeid"), data.getString("code"), sync, serializerName);
		} else {
			longActionId = loginManager.getService().download(roid, serializerName, true, sync);
		}
		JSONObject result = new JSONObject();
		result.put("laid", longActionId);
		result.write(out);
	} catch (Throwable e) {
		LoggerFactory.getLogger("initiatedownload.jsp").error("", e);
	}
%>