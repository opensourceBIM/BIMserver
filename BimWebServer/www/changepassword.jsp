<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="org.bimwebserver.jsp.JspHelper"%>
<%@page import="java.util.List" %>
<%@page import="java.text.DateFormat" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="org.bimserver.utils.Formatters"%>
<%@page import="org.bimserver.shared.exceptions.ServiceException"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%@ include file="header.jsp" %>
<div class="sidebar">
</div>
<div class="content">
<%
	if (loginManager.isLoggedIn()) {
		long uoid = Long.parseLong(request.getParameter("uoid"));
		if (request.getParameter("save") != null) {
			try {
				String oldPassword = request.getParameter("oldpassword");
				String newPassword1 = request.getParameter("newpassword1");
				String newPassword2 = request.getParameter("newpassword2");
				String errorMessage = "";
				if (!newPassword1.equals(newPassword2)) {
					out.println("<div class=\"error\">Password and password check did not match</div>");
				} else {
					loginManager.getService(request).changePassword(uoid, oldPassword, newPassword1);
					response.sendRedirect("user.jsp?uoid=" + uoid + "&message=Password successfully changed");
				}
			} catch (ServiceException e) {
				JspHelper.showException(out, e);
			}
		}
%>
<h1>Change password</h1>
<fieldset>
<form name="form" method="post" action="changepassword.jsp">
<input type="hidden" name="uoid" value="<%=request.getParameter("uoid")%>">
<table class="formtable">
<%
	if (loginManager.getUserType() != SUserType.ADMIN || loginManager.getUoid() == uoid) {
%>
<tr><td class="first">Old password</td><td><input type="password" name="oldpassword" /></td></tr>
<%		
	}
%>
<tr><td class="first">New password</td><td><input type="password" name="newpassword1" /></td></tr>
<tr><td class="first">New password (check)</td><td><input type="password" name="newpassword2" /></td></tr>
<tr><td class="first"></td><td align="right"><input type="submit" value="Change" name="save"/></td></tr>
</table>
</form>
<script type="text/javascript">
if (document.form.oldpassword) {
	document.form.oldpassword.focus();
} else {
	document.form.newpassword1.focus();
}
</script>
<% } %>
</fieldset>
</div>
<%@ include file="footer.jsp" %>