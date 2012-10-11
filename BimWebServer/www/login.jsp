<%@page import="org.bimserver.shared.interfaces.ServiceInterface"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="org.bimserver.shared.AutologinAuthenticationInfo"%>
<%@page import="org.bimserver.shared.UsernamePasswordAuthenticationInfo"%>
<%@page import="org.bimserver.shared.AuthenticationInfo"%>
<%@page import="org.bimserver.interfaces.objects.SVersion"%>
<%@page import="org.bimserver.interfaces.objects.SServerState"%>
<%@page import="org.bimserver.interfaces.objects.SServerInfo"%>
<%@page import="org.slf4j.LoggerFactory"%>
<%@page import="org.bimserver.models.log.AccessMethod"%>
<%@page import="org.bimserver.shared.exceptions.ServiceException"%>
<%@page import="org.bimserver.utils.Hashers"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.net.URLEncoder"%>
<jsp:include page="htmlheader.jsp" />
<jsp:useBean id="errorMessages" scope="request" class="org.bimwebserver.jsp.ErrorMessages" />
<jsp:useBean id="loginManager" scope="session" class="org.bimwebserver.jsp.LoginManager" />
<body>
	<%
	try {
		ServiceInterface service = loginManager.getService(request);
		SServerInfo serverInfo = service.getServerInfo();		
		if (serverInfo.getServerState() == SServerState.RUNNING) {
			SVersion version = service.getVersion();
			if (request.getParameter("login") != null) {
				try {
					AuthenticationInfo authenticationInfo = new UsernamePasswordAuthenticationInfo(request.getParameter("username"), request.getParameter("password"));
					if (loginManager.login(authenticationInfo, request.getRemoteAddr(), request)) {
						if (request.getParameter("rememberme") != null) {
							String rememberHash = Hashers.getSha256Hash(request.getParameter("username") + Hashers.getSha256Hash(request.getParameter("password")));
							Cookie autologinCookie = new Cookie("autologin", rememberHash);
							autologinCookie.setMaxAge(2592000); // 30 days
							response.addCookie(autologinCookie);
							Cookie usernameCookie = new Cookie("username", request.getParameter("username"));
							usernameCookie.setMaxAge(2592000); // 30 days
							response.addCookie(usernameCookie);
						}
						if (request.getParameter("origurl") != null && !request.getParameter("origurl").endsWith("?null")) {
							response.sendRedirect(request.getParameter("origurl"));
						} else {
							response.sendRedirect("main.jsp");
							return;
						}
					} else {
						errorMessages.add("Login unsuccessful");
					}
				} catch (ServiceException e) {
					errorMessages.add(e.getUserMessage());
				}
			} else {
				Map<String, String> cookies = new HashMap<String, String>();
				if (request.getCookies() != null) {
					for (Cookie cookie : request.getCookies()) {
						cookies.put(cookie.getName(), cookie.getValue());
					}
				}
				if (request.getSession().getAttribute("loggingout") == null && cookies.containsKey("autologin") && cookies.containsKey("username")) {
					AuthenticationInfo authenticationInfo = new AutologinAuthenticationInfo(cookies.get("username"), cookies.get("autologin"));
					if (loginManager.login(authenticationInfo, request.getRemoteAddr(), request)) {
						if (!loginManager.isLoggedIn()) {
							response.sendRedirect(request.getContextPath() + "/login.jsp?origurl=" + URLEncoder.encode(request.getRequestURI() + "?" + request.getQueryString(), "UTF-8"));
						} else {
							response.sendRedirect(request.getContextPath() + "/main.jsp");
						}
						return;
					}
				}
			}
%>
<div class="loginwrapper">
<div class="header">
<a href="main.jsp"><img src="images/fulllogo.gif" title="BIMserver <%=version.getMajor() + "." + version.getMinor() + "." + version.getRevision() %>"/></a>
</div>
<br/>
<jsp:include page="loginExtra.jsp" />
<div>
<div class="loginwindow">
<% errorMessages.print(out); %>
<form id="loginForm" name="loginForm" method="post" action="login.jsp">
<table class="formtable">
<tr><td class="first"><label for="username">Username (e-mail)</label></td><td><input id="username" type="text" name="username" id="username" <%=request.getParameter("username") != null ? " value=\"" + request.getParameter("username") + "\"" : "" %> /></td></tr>
<tr><td class="first"><label for="password">Password</label></td><td><input id="password" type="password" name="password"/></td></tr>
<tr><td class="first"><label for="rememberme">Remember me</label></td><td><input id="rememberme" type="checkbox" name="rememberme"/></td></tr>
<tr><td></td><td align="right"><input name="login" type="submit" value="Login"/></td></tr>
</table>
<%
	if (request.getParameter("origurl") != null) {
%>
<input type="hidden" name="origurl" value="<%=request.getParameter("origurl") %>"/>
<%
	}
%>
</form>
<%
if (service.isSettingAllowSelfRegistration()) {
%>
<a href="register.jsp">Register here</a>
<%
}
%>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="resetpassword.jsp">Forgot your password?</a>
</div>
<script type="text/javascript">
$(function(){
	if ($.browser.msie) {
		$(".loginwindow").prepend("<span style=\"color: red\">Warning, Internet Explorer is not supported</span>");
	}
<%
	if (request.getParameter("username") != null && !request.getParameter("username").equals("")) {
		out.println("document.loginForm.password.focus();");		
	} else {
		out.println("document.loginForm.username.focus();");		
	}
%>
});
</script>
<%
 	} else if (serverInfo.getServerState() == SServerState.NOT_SETUP) {
 		response.sendRedirect("setup.jsp");
 		return;
 	} else if (serverInfo.getServerState() == SServerState.MIGRATION_REQUIRED || serverInfo.getServerState() == SServerState.MIGRATION_IMPOSSIBLE) {
 		response.sendRedirect("migrations.jsp");
 		return;
 	} else if (serverInfo.getServerState() == SServerState.FATAL_ERROR || serverInfo.getServerState() == SServerState.UNDEFINED) {
 		response.sendRedirect("error.jsp");
 		return;
 	} else if (serverInfo.getServerState() == SServerState.FATAL_ERROR) {
 		response.sendRedirect("error.jsp");
 		return;
 	}
} catch (Exception e) {
	LoggerFactory.getLogger("login.jsp").error("", e);
	out.println(e.getMessage());
}
%>
<jsp:include page="footer.jsp" />