<%@page import="org.bimserver.shared.SRevisionSummary"%>
<%@page import="org.bimserver.web.JspHelper"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<%@page import="org.slf4j.Logger"%>
<%@page import="org.slf4j.LoggerFactory"%>
<%@page import="org.bimserver.utils.WebUtils"%>
<%@page import="org.bimserver.interfaces.objects.SClashDetectionSettings"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<%
	try {
		String address = request.getParameter("address");
		String senderName = loginManager.getService().getCurrentUser().getName();
		String senderAddress = loginManager.getService().getCurrentUser().getUsername();
		long poid = Long.parseLong(request.getParameter("poid"));
		Set<String> addresses = new HashSet<String>();
		addresses.add(address);
		loginManager.getService().sendClashesEmail(JspHelper.createSClashDetectionSettings(request), poid, addresses);
		out.append("Clash detection successfully e-mailed to " + address);
	} catch (Exception e) {
		out.append("An error has occured while sending clash detection: " + e.getMessage());
	}
%>