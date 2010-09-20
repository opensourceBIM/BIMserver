<%@page import="org.bimserver.shared.SRevisionSummary"%>
<%@page import="org.bimserver.JspHelper"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.Session"%>
<%@page import="java.util.Properties"%>
<%@page import="org.bimserver.ServerSettings"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<%@page import="org.bimserver.MailSystem"%>
<%@page import="org.slf4j.Logger"%>
<%@page import="org.slf4j.LoggerFactory"%>

<%@page import="org.bimserver.utils.WebUtils"%><jsp:useBean id="loginManager" scope="session" class="org.bimserver.LoginManager" />
<%
	Logger logger = LoggerFactory.getLogger(MailSystem.class);
	try {
		
		String address = request.getParameter("address");
		
		String senderName = loginManager.getService().getCurrentUser().getName();
		String senderAddress = loginManager.getService().getCurrentUser().getUsername();
		if (!senderAddress.contains("@") || !senderAddress.contains(".")) {
			senderAddress = ServerSettings.getSettings().getEmailSenderAddress();
		}
		Session mailSession = MailSystem.createMailSession();
	
		MimeMessage msg = new MimeMessage(mailSession);
	
		InternetAddress addressFrom = new InternetAddress(senderAddress);
		addressFrom.setPersonal(senderName);
		msg.setFrom(addressFrom);
	
		InternetAddress[] addressTo = new InternetAddress[1];
		addressTo[0] = new InternetAddress(address);
		msg.setRecipients(Message.RecipientType.TO, addressTo);
		
		msg.setSubject("BIMserver Clash Detection");
		String url = WebUtils.getWebServer(request.getRequestURL().toString());
		msg.setContent("<a href=\"http://" + url + "project.jsp?tab=cd&poid=" + request.getParameter("poid") + "&margin=" + request.getParameter("margin") + "&revisions=" + request.getParameter("revisions") + "&ignore=" + request.getParameter("ignore") + "\">Click here for clash detection results</a>", "text/html");
		Transport.send(msg);
		out.append("Clash detection succesfully e-mailed to " + address);
	} catch (Exception e) {
		logger.error("", e);
		out.append("An error has occured while sending clash detection: " + e.getMessage());
	}
%>