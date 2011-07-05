<%@page import="org.slf4j.LoggerFactory"%>
<%@page import="org.bimserver.web.WebServerHelper"%>
<%@page import="org.bimserver.models.log.AccessMethod"%>
<%@page import="org.bimserver.version.Version"%>
<%@page import="org.bimserver.version.VersionChecker"%>
<%@page import="org.bimserver.shared.UserException"%>
<%@page import="org.bimserver.utils.Hashers"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="org.bimserver.ServerInfo"%>
<%@page import="org.bimserver.ServerInfo.ServerState"%><jsp:include page="htmlheader.jsp" />
<jsp:useBean id="errorMessages" scope="request" class="org.bimserver.web.ErrorMessages" />
<jsp:useBean id="loginManager" scope="session" class="org.bimserver.web.LoginManager" />
<body>
	<%
	try {
	if (WebServerHelper.getBimServer().getServerInfo().isAvailable() || WebServerHelper.getBimServer().getServerInfo().getServerState() == ServerInfo.ServerState.MIGRATION_REQUIRED) {
		Version version = WebServerHelper.getBimServer().getVersionChecker().getLocalVersion();
		boolean redirected = false;
		if (request.getParameter("login") != null) {
			try {
				if (loginManager.getService().login(request.getParameter("username"), request.getParameter("password"))) {
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
					}
					redirected = true;
				} else {
					errorMessages.add("Login unsuccessful");
				}
			} catch (UserException e) {
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
				if (loginManager.getService().autologin(cookies.get("username"), cookies.get("autologin"))) {
					if (!loginManager.getService().isLoggedIn()) {
						response.sendRedirect(request.getContextPath() + "/login.jsp?origurl=" + URLEncoder.encode(request.getRequestURI() + "?" + request.getQueryString(), "UTF-8"));
					} else {
						response.sendRedirect(request.getContextPath() + "/main.jsp");
					}
					redirected = true;
				}
			}
		}
		if (!redirected) {
%>
<div class="loginwrapper">
<div class="header">
<a href="main.jsp"><img src="images/fulllogo.gif" title="BIMserver <%=version.getVersion() %>"/></a>
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
if (loginManager.getService().isSettingAllowSelfRegistration()) {
%>
<a href="register.jsp">Register here</a>
<%
}
%>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="resetpassword.jsp">Forgot your password?</a>
</div>
<script type="text/javascript">
<%
	if (request.getParameter("username") != null && !request.getParameter("username").equals("")) {
		out.println("document.loginForm.password.focus();");		
	} else {
		out.println("document.loginForm.username.focus();");		
	}
%>
</script>
<%
		}
 	} else if (WebServerHelper.getBimServer().getServerInfo().getServerState() == ServerInfo.ServerState.NOT_SETUP) {
 		response.sendRedirect("setup.jsp");
 	} else if (WebServerHelper.getBimServer().getServerInfo().getServerState() == ServerInfo.ServerState.MIGRATION_REQUIRED || WebServerHelper.getBimServer().getServerInfo().getServerState() == ServerInfo.ServerState.MIGRATION_IMPOSSIBLE) {
 		response.sendRedirect("migrations.jsp");
 	} else if (WebServerHelper.getBimServer().getServerInfo().getServerState() == ServerInfo.ServerState.FATAL_ERROR || WebServerHelper.getBimServer().getServerInfo().getServerState() == ServerInfo.ServerState.UNKNOWN) {
 		response.sendRedirect("error.jsp");
 	} else if (WebServerHelper.getBimServer().getServerInfo().getServerState() == ServerInfo.ServerState.FATAL_ERROR) {
 		response.sendRedirect("error.jsp");
 	}
	} catch (Exception e) {
		LoggerFactory.getLogger("login.jsp").error("", e);
		out.println(e.getMessage());
	}
%>
<jsp:include page="footer.jsp" />