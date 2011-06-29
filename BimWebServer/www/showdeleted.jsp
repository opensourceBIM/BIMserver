<%@page import="org.bimserver.interfaces.objects.SUserType"%>
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<%
if (loginManager.getUserType() == SUserType.ADMIN) {
%>
<li><label for="showdeleted">Show deleted</label> <input id="showdeleted" type="checkbox"/></li>
<% } %>
