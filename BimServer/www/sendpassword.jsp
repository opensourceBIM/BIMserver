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
<%@page import="org.bimserver.templating.TemplateEngine"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="org.bimserver.templating.TemplateIdentifier"%>
<%@page import="org.bimserver.Settings"%>
<%@page import="org.bimserver.mail.MailSystem"%>
<%@page import="org.slf4j.Logger"%>
<%@page import="org.slf4j.LoggerFactory"%>
<jsp:include page="htmlheader.jsp" />
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<%
	String message = "";
	Logger logger = LoggerFactory.getLogger(MailSystem.class);
	if (request.getParameter("register") != null) {
		try {
	String emailaddress = request.getParameter("emailaddress");
	loginManager.getAdminService().resetPassword(emailaddress);

	Session mailSession = MailSystem.createMailSession();
	
	Message msg = new MimeMessage(mailSession);

	InternetAddress addressFrom = new InternetAddress(ServerSettings.getSettings().getEmailSenderAddress());
	msg.setFrom(addressFrom);

	InternetAddress[] addressTo = new InternetAddress[1];
	addressTo[0] = new InternetAddress(emailaddress);
	msg.setRecipients(Message.RecipientType.TO, addressTo);

	Map<String, Object> context = new HashMap<String, Object>();
	String body = TemplateEngine.getTemplateEngine().process(context, TemplateIdentifier.PASSWORD_RESET_EMAIL_BODY);
	String subject = TemplateEngine.getTemplateEngine().process(context, TemplateIdentifier.PASSWORD_RESET_EMAIL_SUBJECT);
	msg.setContent(body, "text/plain");
	msg.setSubject(subject.trim());
	Transport.send(msg);
	message = "<div class=\"info\">A new password has been sent to " + emailaddress + ", click <a href=\"login.jsp?username=" + emailaddress + "\">here</a> to login</div>";
		} catch (Exception e) {
	logger.error("", e);
	message = "<div class=\"error\">An unknown error has occured, please try again or contact an administrator</div>";
		}
	}
%>
<div class="loginwrapper">
<div class="header"><a href="main.jsp"><img src="images/fulllogo.gif" title="BIM Server"/></a></div>
<div>
<%=(message != null) ? message : "" %>
<form name="registerForm" method="post" action="sendpassword.jsp">
After submitting this form, a new password will be send to the provided email address<br/><br/>
<table>
	<tr>
		<td><label>E-mail address</label></td>
		<td><input type="text" id="emailaddress" autocomplete="off" name="emailaddress"<%=request.getParameter("emailaddress") != null ? " value=\"" + request.getParameter("emailaddress") + "\"" : "" %> /></td>
	</tr>
	<tr>
		<td></td><td align="right"><input type="submit" name="register" value="Request new password" /></td>
	</tr>
</table>
</form>
<script type="text/javascript">
document.registerForm.emailaddress.focus();
</script>
<jsp:include page="footer.jsp" />