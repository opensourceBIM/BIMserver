<%@page import="java.util.List" %>
<%@page import="java.text.DateFormat" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="org.bimserver.utils.Formatters"%>
<%@page import="org.bimserver.shared.UserException"%>
<%@page import="java.util.Properties"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.Session"%>
<%@page import="org.bimserver.ServerSettings"%>
<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@ include file="header.jsp" %>
<%
	if (loginManager.isLoggedIn()) {
		if (request.getParameter("save") != null) {
			try {
				long uoid = loginManager.getService().addUser(request.getParameter("username"), request.getParameter("password"), request.getParameter("name"));
				if (uoid != -1 && request.getParameter("sendconfirmation") != null) {
					String senderName = loginManager.getService().getCurrentUser().getName();
					String senderAddress = ServerSettings.getSettings().getEmailSenderAddress();
					
					Properties props = new Properties();
					props.put("mail.smtp.host", ServerSettings.getSettings().getSmtpServer());

					Session mailSession = Session.getDefaultInstance(props);

					Message msg = new MimeMessage(mailSession);

					InternetAddress addressFrom = new InternetAddress(senderAddress);
					addressFrom.setPersonal(senderName);
					msg.setFrom(addressFrom);

					InternetAddress[] addressTo = new InternetAddress[1];
					addressTo[0] = new InternetAddress(request.getParameter("username"));
					msg.setRecipients(Message.RecipientType.TO, addressTo);
					
					msg.setSubject("Welcome");
					msg.setContent("A user account with your e-mail address has been created", "text/plain");
					Transport.send(msg);
				}
				response.sendRedirect("user.jsp?uoid=" + uoid);
			} catch (UserException e) {
				out.println("<div class=\"error\">" + e.getUserMessage() + "</div>");
			}
		}
%>
<div class="sidebar">
</div>

<div class="content">

<h1>Add user</h1>
<fieldset>
<form name="form" method="post" action="adduser.jsp">
<table>
<tr><td><label for="name">Name</label></td><td><input id="name" type="text" name="name" autocomplete="off" value="<%=request.getParameter("name") != null ? request.getParameter("name") : "" %>"/></td></tr>
<tr><td><label for="username">Username (E-mail address)</label></td><td><input id="username" type="text" name="username" autocomplete="off" value="<%=request.getParameter("username") != null ? request.getParameter("username") : "" %>"/></td></tr>
<tr><td><label for="password">Password</label></td><td><input id="password" type="password" name="password" autocomplete="off"/></td></tr>
<tr><td><label for="confirm">Send confirmation to user</label></td><td><input id="confirm" type="checkbox" name="sendconfirmation"<%=(request.getParameter("sendconfirmation") != null ? " checked=\"checked\"" : "") %>/></td></tr>
</table>
<input type="submit" value="Save" name="save"/>
</form>
<script type="text/javascript">
document.form.name.focus();
</script>
<% } %>
</fieldset>
</div>
<%@ include file="footer.jsp" %>