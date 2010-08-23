<%@page import="org.bimserver.ifc.file.compare.CompareResult"%>
<%@page import="org.bimserver.shared.SRevisionSummary"%>
<%@page import="org.bimserver.JspHelper"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.Session"%>
<%@page import="java.util.Properties"%>
<%@page import="org.bimserver.ServerSettings"%>
<%@page import="org.bimserver.shared.SCompareResult"%>
<%@page import="org.bimserver.interfaces.objects.SProject"%>
<%@page import="org.bimserver.MailSystem"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.LoginManager" />
<%
	try {
		String address = request.getParameter("address");
		long poid = Long.parseLong(request.getParameter("poid"));
		SProject project = loginManager.getService().getProjectByPoid(poid);
		long roid1 = Long.parseLong(request.getParameter("roid1"));
		long roid2 = Long.parseLong(request.getParameter("roid2"));
		
		String senderName = loginManager.getService().getCurrentUser().getName();
		String senderAddress = loginManager.getService().getCurrentUser().getUsername();
		if (!senderAddress.contains("@") || !senderAddress.contains(".")) {
			senderAddress = ServerSettings.getSettings().getEmailSenderAddress();
		}
		
		Session mailSession = MailSystem.createMailSession();

		Message msg = new MimeMessage(mailSession);

		InternetAddress addressFrom = new InternetAddress(senderAddress);
		addressFrom.setPersonal(senderName);
		msg.setFrom(addressFrom);

		InternetAddress[] addressTo = new InternetAddress[1];
		addressTo[0] = new InternetAddress(address);
		msg.setRecipients(Message.RecipientType.TO, addressTo);
		
		msg.setSubject("BIMserver Model Comparator");
		SCompareResult compareResult = loginManager.getService().compare(roid1, roid2);
		String html = JspHelper.writeCompareResult(compareResult, roid1, roid2, project);
		msg.setContent(html, "text/html");
		Transport.send(msg);
		out.append("Compare results succesfully e-mailed to " + address);
	} catch (Exception e) {
		out.append("An error has occured while sending compare results: " + e.getMessage());
	}
%>