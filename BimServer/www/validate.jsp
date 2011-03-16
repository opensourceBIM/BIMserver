<%@page import="org.bimserver.interfaces.objects.SUser"%>
<jsp:include page="htmlheader.jsp" />
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<%@page import="org.bimserver.shared.UserException"%>
<div class="loginwrapper">
<div class="header"><a href="main.jsp"><img src="images/fulllogo.gif" title="BIMserver"/></a></div>
<div>
<%
	boolean showForm = true;
	long uoid = Long.parseLong(request.getParameter("uoid"));
	SUser sUser = loginManager.getSystemService().getUserByUoid(uoid);
	if (request.getParameter("password") != null) {
		try {
			loginManager.getSystemService().validateAccount(uoid, request.getParameter("token"), request.getParameter("password"));
			out.println("<div class=\"success\">Account successfully validated, you can now <a href=\"/?username=" + sUser.getUsername() + "\">login</a></div>");
			showForm = false;
		} catch (UserException e) {
			out.println("<div class=\"error\">" + e.getMessage() + "</div>");
		}
	}
	if (showForm) {
%>
<p>Please choose your own personal password for accessing the BIMserver</p>
<form method="post" name="validateForm">
<table>
<tr><td>Username</td><td><%=sUser.getUsername() %></td></tr>
<tr><td><label for="password">Password</label></td><td><input type="password" id="password" name="password"></input></td></tr>
</table>
<input type="hidden" name="uoid" value="<%=request.getParameter("uoid")%>"/>
<input type="hidden" name="token" value="<%=request.getParameter("token")%>"/>
<input type="submit" value="Validate"/>
</form>
<%
	}
%>
<script type="text/javascript">
document.validateForm.password.focus();
</script>
<jsp:include page="footer.jsp" />