<%@page import="org.bimserver.interfaces.objects.SExternalProfile"%><%@page import="java.util.List"%><jsp:useBean id="loginManager" scope="session" class="org.bimwebserver.jsp.LoginManager" />{
	"profiles": [
<%
	List<SExternalProfile> profiles = loginManager.getService().getRemoteProfiles(request.getParameter("url"));
	for (SExternalProfile profile : profiles) {
		out.println("{");
		out.print("\"name\": \"" + profile.getName() + "\",");
		out.print("\"serveroid\": \"" + profile.getServerId() + "\",");
		out.print("\"profileoid\": \"" + profile.getOid() + "\",");
		out.print("\"description\": \"" + profile.getDescription() + "\",");
		out.print("\"readRevision\": " + profile.isReadRevision() + ",");
		out.print("\"readExtendedData\": " + profile.isReadExtendedData() + ",");
		out.print("\"writeRevision\": \"" + profile.getWriteRevisionId() + "\",");
		out.print("\"writeExtendedData\": \"" + profile.getWriteExtendedDataId() + "\"");
		out.println("}");
		if (profile != profiles.get(profiles.size()-1)) {
			out.println(", ");
		}
	}
%>
	]
}