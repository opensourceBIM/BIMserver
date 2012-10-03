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
	long uoid = Long.parseLong(request.getParameter("uoid"));
	if (request.getParameter("password") != null) {
		try {
			SUser sUser = loginManager.getService(request).validateAccount(uoid, request.getParameter("token"), request.getParameter("password"));
			out.println("<div class=\"success\">Account successfully validated, you can now <a href=\"/?username=" + sUser.getUsername() + "\">login</a></div>");
			showForm = false;
		} catch (ServiceException e) {
			JspHelper.showException(out, e);
		}
	}
	if (showForm) {
%>
<p>Please choose your own personal password for accessing the BIMserver</p>
<form method="post" name="validateForm">
<table>
<tr><td>Username</td><td><%=request.getParameter("username") %></td></tr>
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