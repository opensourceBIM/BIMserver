<%@page import="org.bimserver.interfaces.objects.SService"%>
<%@page import="java.util.List"%><jsp:useBean id="loginManager" scope="session" class="org.bimwebserver.jsp.LoginManager" />{
	"services": [
<%
	List<SService> services = loginManager.getService().getRemoteServices(request.getParameter("url"));
	for (SService service : services) {
		out.println("{");
		out.print("\"name\": \"" + service.getName() + "\",");
		out.print("\"url\": \"" + service.getUrl() + "\",");
		out.print("\"profileoid\": \"" + service.getOid() + "\",");
		out.print("\"description\": \"" + service.getDescription() + "\",");
		out.print("\"notificationProtocol\": \"" + service.getNotificationProtocol() + "\",");
		out.print("\"url\": \"" + service.getUrl() + "\",");
		out.print("\"trigger\": \"" + service.getTrigger() + "\",");
		out.print("\"readRevision\": " + service.isReadRevision() + ",");
		out.print("\"readExtendedData\": " + service.isReadExtendedData() + ",");
		out.print("\"writeRevision\": \"" + service.getWriteRevisionId() + "\",");
		out.print("\"writeExtendedData\": \"" + service.getWriteExtendedDataId() + "\"");
		out.println("}");
		if (service != services.get(services.size()-1)) {
			out.println(", ");
		}
	}
%>
	]
}