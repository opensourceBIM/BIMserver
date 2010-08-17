<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.Session"%>
<%@page import="java.util.Properties"%>
<%@page import="org.bimserver.ServerSettings"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.LoginManager" />
<%
	if (request.getParameter("email") != null) {
		String senderName = loginManager.getService().getCurrentUser().getName();
		String senderAddress = loginManager.getService().getCurrentUser().getUsername();

		Properties props = new Properties();
		props.put("mail.smtp.host", ServerSettings.getSettings().getSmtpServer());

		Session mailSession = Session.getDefaultInstance(props);

		Message msg = new MimeMessage(mailSession);

		InternetAddress addressFrom = new InternetAddress(senderAddress);
		addressFrom.setPersonal(senderName);
		msg.setFrom(addressFrom);

		InternetAddress[] addressTo = new InternetAddress[1];
		addressTo[0] = new InternetAddress(request.getParameter("email"));
		msg.setRecipients(Message.RecipientType.TO, addressTo);
		
		msg.setSubject("www.bimserver.org");
		msg.setContent("Check out this website, www.bimserver.org", "text/plain");
		Transport.send(msg);
	}
	response.sendRedirect("main.jsp");
%>