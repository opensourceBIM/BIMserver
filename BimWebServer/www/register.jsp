<%@page import="org.bimserver.interfaces.objects.SUser"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="org.bimserver.interfaces.objects.SVersion"%>
<%@page import="org.bimserver.shared.exceptions.ServiceException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Properties"%>
<%@page import="org.apache.velocity.app.VelocityEngine"%>
<%@page import="org.apache.velocity.Template"%>
<%@page import="org.apache.velocity.VelocityContext"%>
<%@page import="java.io.StringWriter"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="org.slf4j.Logger"%>
<%@page import="org.slf4j.LoggerFactory"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<jsp:include page="htmlheader.jsp" />
<jsp:useBean id="loginManager" scope="session" class="org.bimwebserver.jsp.LoginManager" />
<%
	if (loginManager.getService(request).isSettingAllowSelfRegistration()) {
		List<String> errorMessages = new ArrayList<String>();
		SVersion version = loginManager.getService(request).getVersion();
		boolean success = false;
		if (request.getParameter("register") != null) {
			String name = request.getParameter("register_name");
			String username = request.getParameter("register_username");
			try {
				SUser user = loginManager.getService(request).addUser(username, name, SUserType.USER, true);
			} catch (ServiceException e) {
				errorMessages.add(e.getUserMessage());
			}
			if (errorMessages.size() == 0) {
				success = true;
			}
		}
%>
<div class="loginwrapper">
<div class="header"><a href="main.jsp"><img src="images/fulllogo.gif" title="BIMserver <%=version.getMajor() + "." + version.getMinor() + "." + version.getRevision() %>"/></a></div>
<div>
<%
	String addition = loginManager.getService(request).getSettingRegistrationAddition();
out.print(addition + "<br/><br/>");
if (errorMessages.size() > 0) {
	out.println("<div class=\"error\">");
	for (String message : errorMessages) {
		out.println(message + "<br/>");
	}
	out.println("</div>");
} else {
	if (request.getParameter("register") != null) {
		out.println("<div class=\"success\">Your account has been created, an e-mail has been sent to your address to confirm</div>");
	}
}
if (!success) {
%>
<form name="registerForm" method="post" action="register.jsp">
<p>Once you register, you can create as many projects as you
like. A confirmation will be send to your e-mail address.</p>
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