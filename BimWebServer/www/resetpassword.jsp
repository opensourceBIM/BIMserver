<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="org.bimwebserver.jsp.JspHelper"%>
<%@page import="org.bimserver.interfaces.objects.SUser"%>
<jsp:include page="htmlheader.jsp" />
<jsp:useBean id="loginManager" scope="session" class="org.bimwebserver.jsp.LoginManager" />
<%@page import="org.bimserver.shared.exceptions.ServiceException"%>
<div class="loginwrapper">
<div class="header"><a href="main.jsp"><img src="images/fulllogo.gif" title="BIMserver"/></a></div>
<div>
<%
	boolean showForm = true;
	if (request.getParameter("username") != null) {
		try {
			loginManager.getService(request).requestPasswordChange(request.getParameter("username"));
			showForm = false;
			out.println("An email with instructions on how to reset your password has been sent to your address");
		} catch (ServiceException e) {
			JspHelper.showException(out, e);
		}
	}
	if (showForm) {
%>
<p>Please provide your BIMserver username (your e-mail address)</p>
<form method="post" name="resetPasswordForm">
<table>
<tr><td><label for="username">Username</label></td><td><input type="text" id="username" name="username"></input></td></tr>
</table>
<br/>
<input type="submit" value="Request password reset"/>
</form>
<%
	}
%>
<script type="text/javascript">
document.resetPasswordForm.username.focus();
</script>
<jsp:include page="footer.jsp" />