<%@page import="org.bimserver.shared.UserException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Properties"%>
<%@page import="javax.mail.Session"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.Transport"%>
<%@page import="org.bimserver.Version"%>
<%@page import="org.bimserver.VersionChecker"%>
<%@page import="org.bimserver.ServerSettings"%>
<%@page import="org.apache.velocity.app.VelocityEngine"%>
<%@page import="org.apache.velocity.Template"%>
<%@page import="org.apache.velocity.VelocityContext"%>
<%@page import="java.io.StringWriter"%>
<%@page import="org.bimserver.TemplateEngine"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="org.bimserver.TemplateIdentifier"%>
<%@page import="org.bimserver.Settings"%>
<%@page import="org.bimserver.MailSystem"%>
<%@page import="org.slf4j.Logger"%>
<%@page import="org.slf4j.LoggerFactory"%>
<jsp:include page="htmlheader.jsp" />
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.LoginManager" />
<%
	Logger logger = LoggerFactory.getLogger(MailSystem.class);
	if (ServerSettings.getSettings().isAllowSelfRegistration()) {
		List<String> errorMessages = new ArrayList<String>();
		Version version = VersionChecker.getInstance().getLocalVersion();
		boolean succes = false;
		if (request.getParameter("register") != null) {
			String name = request.getParameter("register_name");
			String username = request.getParameter("register_username");
			String password = request.getParameter("register_password");
			try {
				long uoid = loginManager.getAdminService().addUser(username, password, name);
			} catch (UserException e) {
				errorMessages.add(e.getUserMessage());
			}
			if (errorMessages.size() == 0) {
				try {
					if (ServerSettings.getSettings().isSendConfirmationEmailAfterRegistration()) {
						Session mailSession = MailSystem.createMailSession();
		
						Message msg = new MimeMessage(mailSession);
	
						InternetAddress addressFrom = new InternetAddress(ServerSettings.getSettings().getEmailSenderAddress());
						msg.setFrom(addressFrom);
	
						InternetAddress[] addressTo = new InternetAddress[1];
						InternetAddress[] addressBcc = new InternetAddress[1];
						addressTo[0] = new InternetAddress(username);
						addressBcc[0] = new InternetAddress("register@bimserver.org");
						msg.setRecipients(Message.RecipientType.TO, addressTo);
						msg.setRecipients(Message.RecipientType.BCC, addressBcc);
	
						Map<String, Object> context = new HashMap<String, Object>();
						context.put("name", name);
						context.put("username", username);
						context.put("password", password);
						String body = TemplateEngine.getTemplateEngine().process(context, TemplateIdentifier.REGISTRATION_EMAIL_BODY);
						String subject = TemplateEngine.getTemplateEngine().process(context, TemplateIdentifier.REGISTRATION_EMAIL_SUBJECT);
						msg.setContent(body, "text/plain");
						msg.setSubject(subject.trim());
						Transport.send(msg);
					}
				} catch (Exception e) {
					logger.error("", e);
					errorMessages.add(e.getMessage());
				}
			}
			if (errorMessages.size() == 0) {
				succes = true;
			}
		}
%>
<div class="loginwrapper">
<div class="header"><a href="main.jsp"><img src="images/fulllogo.gif" title="BIM Server <%=version.getVersion() %>"/></a></div>
<div>
<%
String addition = ServerSettings.getSettings().getRegistrationAddition();
out.print(addition + "<br/><br/>");
if (errorMessages.size() > 0) {
	out.println("<div class=\"error\">");
	for (String message : errorMessages) {
		out.println(message + "<br/>");
	}
	out.println("</div>");
} else {
	if (request.getParameter("register") != null) {
		out.println("<div class=\"succes\">Your account has been created, an e-mail has been sent to your address to confirm. Please click <a href=\"login.jsp?username=" + request.getParameter("register_username") + "\">here</a> to login.</div>");
	}
}
if (!succes) {
%>
<form name="registerForm" method="post" action="register.jsp">
Once you register, you can create as many projects as you
like. A confirmation will be send to your e-mail address.
<table>
	<tr>
		<td><label>Name</label></td>
		<td><input type="text" name="register_name"<%=request.getParameter("register_name") != null ? " value=\"" + request.getParameter("register_name") + "\"" : "" %>/></td>
	</tr>
	<tr>
		<td><label>Username (E-mail address)</label></td>
		<td><input type="text" autocomplete="off" name="register_username"<%=request.getParameter("register_username") != null ? " value=\"" + request.getParameter("register_username") + "\"" : "" %> /></td>
	</tr>
	<tr>
		<td><label>Password</label></td>
		<td><input type="password" autocomplete="off" name="register_password" /></td>
	</tr>
	<tr>
		<td></td><td align="right"><input type="submit" name="register" value="Register" /></td>
	</tr>
</table>
</form>
<script type="text/javascript">
document.registerForm.register_name.focus();
</script>
<%
	}
} else {
%>
<div class="error">Registration not enabled, please contact site administrator</div>
<%
}
%>
<jsp:include page="footer.jsp" />