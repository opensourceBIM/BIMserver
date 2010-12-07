<%@page import="org.bimserver.shared.SRevisionSummary"%>
<%@page import="org.bimserver.web.JspHelper"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.Session"%>
<%@page import="java.util.Properties"%>
<%@page import="org.bimserver.ServerSettings"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<%@page import="org.bimserver.mail.MailSystem"%>
<%@page import="org.slf4j.Logger"%>
<%@page import="org.slf4j.LoggerFactory"%>
<%@page import="org.bimserver.utils.WebUtils"%>
<%@page import="org.bimserver.interfaces.objects.SClashDetectionSettings"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<%
	Logger logger = LoggerFactory.getLogger(MailSystem.class);
	try {
		String address = request.getParameter("address");
		String senderName = loginManager.getService().getCurrentUser().getName();
		String senderAddress = loginManager.getService().getCurrentUser().getUsername();
		String url = WebUtils.getWebServer(request.getRequestURL().toString());
		MailSystem.getInstance().sendClashDetectionEmail(senderName, senderAddress, url, JspHelper.createSClashDetectionSettings(request), address);
		out.append("Clash detection succesfully e-mailed to " + address);
	} catch (Exception e) {
		logger.error("", e);
		out.append("An error has occured while sending clash detection: " + e.getMessage());
	}
%>