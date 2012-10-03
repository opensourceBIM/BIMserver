<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.List" %>
<%@page import="java.text.DateFormat" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="org.bimserver.utils.Formatters"%>
<%@page import="org.bimserver.shared.exceptions.ServiceException"%>
<%@page import="java.util.Properties"%>
<%@page import="org.bimwebserver.jsp.JspHelper"%>
<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<%@ include file="header.jsp" %>
<div class="sidebar">
</div>
<div class="content">
<%
	if (loginManager.isLoggedIn()) {
		if (request.getParameter("save") != null) {
			try {
				SUser user = loginManager.getService(request).addUser(request.getParameter("username"), request.getParameter("name"), SUserType.values()[Integer.parseInt(request.getParameter("type"))], false);
				response.sendRedirect("user.jsp?uoid=" + user.getOid());
			} catch (ServiceException e) {
				JspHelper.showException(out, e);
			}
		}
%>
<h1>Add user</h1>
<fieldset>
<form name="form" method="post" action="adduser.jsp">
<table>
<tr><td><label for="name">Name</label></td><td><input id="name" type="text" name="name" autocomplete="off" value="<%=request.getParameter("name") != null ? request.getParameter("name") : "" %>"/></td></tr>
<tr><td><label for="username">Username (E-mail address)</label></td><td><input id="username" type="text" name="username" autocomplete="off" value="<%=request.getParameter("username") != null ? request.getParameter("username") : "" %>"/></td></tr>
<tr><td><label for="type">Type</label></td><td><select name="type">
<%
	for (SUserType sUserType : SUserType.values()) {
		if (sUserType != SUserType.SYSTEM) {
			if (request.getParameter("type") != null && request.getParameter("type").equals("" + sUserType.ordinal())) {
			%>
			<option selected="selected" value="<%=sUserType.ordinal() %>"><%=JspHelper.getNiceUserTypeName(sUserType) %></option>
			<%
			} else {
			%>
			<option <%=(request.getParameter("type") == null && sUserType == SUserType.USER) ? "selected=\"selected\"" : "" %>value="<%=sUserType.ordinal() %>"><%=JspHelper.getNiceUserTypeName(sUserType) %></option>
			<%
			}
		}
	}
%>
	</select></td></tr>
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