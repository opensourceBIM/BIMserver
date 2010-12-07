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
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<%
	Logger logger = LoggerFactory.getLogger(MailSystem.class);
	try {
		String address = request.getParameter("address");
		long poid = Long.parseLong(request.getParameter("poid"));
		SProject project = loginManager.getService().getProjectByPoid(poid);
		long roid = Long.parseLong(request.getParameter("roid"));
		
		String senderName = loginManager.getService().getCurrentUser().getName();
		String senderAddress = loginManager.getService().getCurrentUser().getUsername();
		if (!senderAddress.contains("@") || !senderAddress.contains(".")) {
			senderAddress = ServerSettings.getSettings().getEmailSenderAddress();
		}
		
		Session mailSession = MailSystem.getInstance().createMailSession();
	
		Message msg = new MimeMessage(mailSession);
	
		InternetAddress addressFrom = new InternetAddress(senderAddress);
		addressFrom.setPersonal(senderName);
		msg.setFrom(addressFrom);
	
		InternetAddress[] addressTo = new InternetAddress[1];
		addressTo[0] = new InternetAddress(address);
		msg.setRecipients(Message.RecipientType.TO, addressTo);
		
		msg.setSubject("BIMserver Revision Summary");
		SRevisionSummary revisionSummary = loginManager.getService().getRevisionSummary(roid);
//		String html = JspHelper.writeSummaryTable(project, rid, revisionSummary);
//		msg.setContent(html, "text/html");
		Transport.send(msg);
		out.append("Revision summary succesfully e-mailed to " + address);
	} catch (Exception e) {
		logger.error("", e);
		out.append("An error has occured while sending revision summary: " + e.getMessage());
	}
%>