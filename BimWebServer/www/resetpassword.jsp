<%@page import="org.bimserver.web.JspHelper"%>
<%@page import="org.bimserver.interfaces.objects.SUser"%>
<jsp:include page="htmlheader.jsp" />
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<%@page import="org.bimserver.shared.UserException"%>
<div class="loginwrapper">
<div class="header"><a href="main.jsp"><img src="images/fulllogo.gif" title="BIMserver"/></a></div>
<div>
<%
	boolean showForm = true;
	if (request.getParameter("username") != null) {
		try {
			SUser user = loginManager.getSystemService().getUserByUserName(request.getParameter("username"));
			loginManager.getSystemService().requestPasswordChange(user.getOid());
			showForm = false;
			out.println("An email with instructions on how to reset your password has been sent to your address");
		} catch (UserException e) {
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